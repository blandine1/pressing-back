package com.pressing.pressing.services.impl;

import com.pressing.pressing.dto.ClientDto;
import com.pressing.pressing.dto.LigneProduitDto;
import com.pressing.pressing.dto.ProduitDto;
import com.pressing.pressing.dto.ServiceDto;
import com.pressing.pressing.entity.Client;
import com.pressing.pressing.entity.Ligneproduit;
import com.pressing.pressing.entity.Produit;
import com.pressing.pressing.entity.Services;
import com.pressing.pressing.exception.EntityNotFoundException;
import com.pressing.pressing.exception.ErrorCode;
import com.pressing.pressing.exception.InvalidEntityException;
import com.pressing.pressing.exception.InvalidOperationException;
import com.pressing.pressing.repository.*;
import com.pressing.pressing.services.ProduitService;
import com.pressing.pressing.validator.ProduitValidator;
import com.pressing.pressing.validator.ServicesValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    private final ServiceRepository serviceRepository;
    private final CategorieRepository categorieRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final LigneProduitRepository ligneProduitRepository;
    private final ClientRepository clientRepository;
   // private final PaginationRepository paginationRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository,
                              ServiceRepository serviceRepository,
                              CategorieRepository categorieRepository,
                              UtilisateurRepository utilisateurRepository,
                              LigneProduitRepository ligneProduitRepository,
                              ClientRepository clientRepository)
    {

        this.produitRepository = produitRepository;
        this.serviceRepository = serviceRepository;
        this.categorieRepository = categorieRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.ligneProduitRepository = ligneProduitRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        ProduitValidator produitValidator=new ProduitValidator();
        List<String> errors = produitValidator.validator(produitDto);
        if(!errors.isEmpty()){
            log.error("le produit est invalide");
            throw new InvalidEntityException("le produit est invalide", ErrorCode.PRODUIT_NOT_VALID);
        }

        List<String> servicesErrors = new ArrayList<>();
        if(produitDto.getListeLigneProduit() !=null){
            produitDto.getListeLigneProduit().forEach(p->{
                if(p.getService() != null){
                    Optional<Services> optional = serviceRepository.findById(p.getService().getId());
                    if (optional.isEmpty()){
                        servicesErrors.add("le service avec cet Id "+ p.getService().getId() +" n'est pas disponible");
                    }
                }
            });
        }
        if(!servicesErrors.isEmpty()){
            log.error("");
            throw new InvalidEntityException("le service n'existe pas dans cette BD ", ErrorCode.SERVICE_NOT_FOUND, servicesErrors);
        }

        produitDto.setUtilisateurid(1);

        Produit saveDproduit = produitRepository.save(ProduitDto.toEntity(produitDto));

        if(produitDto.getListeLigneProduit() != null){
            produitDto.getListeLigneProduit().forEach(lgnePt->{
                Ligneproduit ligneproduit = LigneProduitDto.toEntity(lgnePt);
                ligneproduit.setProduit(saveDproduit);
                ligneproduit.setId_produit(saveDproduit.getId());
                ligneproduit.setCreationDate(new Date());
                ligneproduit.setLastUpdatedDate(new Date());
                ligneProduitRepository.save(ligneproduit);
            });
        }

        return ProduitDto.fromEntity(saveDproduit);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {

        ProduitValidator produitValidator=new ProduitValidator();
        List<String> errors = produitValidator.validator(produitDto);
        if(!errors.isEmpty()){
            log.error("le produit est invalide");
            throw new InvalidEntityException("le produit est invalide", ErrorCode.PRODUIT_NOT_VALID);
        }

       /* if(!produitDto.isStatus() && produitDto.isLivre()){
            throw new InvalidEntityException("Ce produit n'est pas encore payé", ErrorCode.PRODUIT_NOT_VALID);
        }*/

        List<String> servicesErrors = new ArrayList<>();
        if(produitDto.getListeLigneProduit() !=null){
            produitDto.getListeLigneProduit().forEach(p->{
                if(p.getService() != null){
                    Optional<Services> optional = serviceRepository.findById(p.getService().getId());
                    if (optional.isEmpty()){
                        servicesErrors.add("le service avec cet Id "+ p.getService().getId() +" n'est pas disponible");
                    }
                }
            });
        }
        if(!servicesErrors.isEmpty()){
            log.error("");
            throw new InvalidEntityException("le service n'existe pas dans cette BD ", ErrorCode.SERVICE_NOT_FOUND, servicesErrors);
        }

        produitDto.setUtilisateurid(1);

        Produit saveDproduit = produitRepository.save(ProduitDto.toEntity(produitDto));

        if(produitDto.getListeLigneProduit() != null){
            produitDto.getListeLigneProduit().forEach(lgnePt->{
                Ligneproduit ligneproduit1 = ligneProduitRepository.findById(lgnePt.getId()).get();

                Ligneproduit ligneproduit = LigneProduitDto.toEntity(lgnePt);
                ligneproduit.setProduit(saveDproduit);
                ligneproduit.setId_produit(saveDproduit.getId());
                if (lgnePt.isStatus() &&  !ligneproduit1.isStatus()){
                    ligneproduit.setLastUpdatedDate(new Date());
                }
                ligneProduitRepository.save(ligneproduit);
            });
        }
        return ProduitDto.fromEntity(saveDproduit);
    }


    @Override
    public ProduitDto findById(Integer id) {
        if(id == null){
          log.error("Aucun produit n'est disponible avec cet Id " + id );
          return null;
        }
        return produitRepository.findById(id)
                .map(ProduitDto:: fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Aucun produit n'est disponible avec cet Id " +id, ErrorCode.SERVICE_NOT_FOUND));
    }
    @Override
    public ProduitDto findByIdAndLigneProduit(Integer id){
        if(id == null){
            log.error("Aucun produit n'est disponible avec cet Id " + id );
            return null;
        }

        Produit produit = produitRepository.findById(id).get();

        ProduitDto produitDto = ProduitDto.fromEntity(produit);

        List<LigneProduitDto> collect = ligneProduitRepository.findAllByProduitId(id).stream().map(LigneProduitDto::fromEntity).collect(Collectors.toList());

        produitDto.setListeLigneProduit(collect);

        return produitDto;
    }

    @Override
    public List<LigneProduitDto> findAllLigneProduitByProduitId(Integer idProduit) {
        return ligneProduitRepository.findAllByProduitId(idProduit).stream()
                .map(LigneProduitDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDto updateQuantiteProduit(Integer id, Integer idLigneCommende, BigDecimal quantite) {
        if (id == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id null");
        }
        ProduitDto produitDto = findById(idLigneCommende);
        Optional<Ligneproduit> ligneproduitOptional = ligneProduitRepository.findById(idLigneCommende);

        if(ligneproduitOptional.isEmpty()){
            throw new EntityNotFoundException("Impossible de valider cette operation avec le id null" + idLigneCommende, ErrorCode.PRODUIT_NOT_FOUND);
        }

        if (quantite == null || quantite.compareTo(BigDecimal.ZERO) == 0){
            log.error("la quantite n peut etre negatve");
            throw new InvalidOperationException("Impossible de valider cette operation avec une quantite null");
        }

        Ligneproduit ligneproduit = ligneproduitOptional.get();
        ligneproduit.setQuantite(quantite);
        ligneProduitRepository.save(ligneproduit);

        return produitDto;
    }

    @Override
    public ProduitDto updateStatut(Integer id) {
        if (id == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id null");
        }
       ProduitDto produitDto = findById(id);
        Produit produit = produitRepository.updateByStatusAndTrue(produitDto.getId());
        return ProduitDto.fromEntity(produit);
    }

    @Override
    public ProduitDto updateClient(Integer idProduit, Integer idClient) {
        if (idProduit == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du produit null" + idClient, ErrorCode.PRODUIT_NOT_FOUND);
        }
        if (idProduit == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du client null" + idClient, ErrorCode.CLIENT_NOT_FOUND_EXCEPTION);
        }
        ProduitDto produitDto = findById(idProduit);
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        Client client = clientOptional.get();
        produitDto.setClient(ClientDto.fromEntity(clientOptional.get()));


        return ProduitDto.fromEntity(produitRepository.save(ProduitDto.toEntity(produitDto)));
    }

    @Override
    public List<ProduitDto> findAll() {
//        Page<Produit> byCreationDate = paginationRepository.findAllOrOrderByCreationDate(PageRequest.of(0, 2));
//        Map<String, Object> res = new HashMap<>();
//        res.put("produit", byCreationDate.getContent());
//        res.put("current-page",byCreationDate.getNumber());
//        res.put("total-items",byCreationDate.getTotalElements());
//        res.put("total-pages",byCreationDate.getTotalPages());
        return produitRepository.findAll().stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }


    /**
     * recher avec le statut livre est a faux
     * @return
     */
    @Override
    public List<ProduitDto> findAllTrue() {
        List<Produit> produitDtoList = produitRepository.findAllByLivreIsFalse();
        if (produitDtoList.isEmpty()){
            log.error("La liste est vide");
        }
        List<ProduitDto> dtoList = new ArrayList<>();
        produitDtoList.forEach(p ->{
            dtoList.add(ProduitDto.fromEntity(p));
        });

        return dtoList;
    }


    /**
     * recher avec le statut status est a faux
     * @return
     */
    @Override
    public List<ProduitDto> findAllFalse() {
        List<Produit> produitDtoList = produitRepository.findAllByStatusIsFalse();
        if (produitDtoList.isEmpty()){
            log.error("La liste est vide");
        }
        List<ProduitDto> dtoList = new ArrayList<>();
        produitDtoList.forEach(p ->{
            dtoList.add(ProduitDto.fromEntity(p));
        });

        return dtoList;
    }

    @Override
    public List<ProduitDto> findBIsLivreTrue() {
        List<Produit> produitDtoList = produitRepository.findAllByLivreIsTrue();
        if (produitDtoList.isEmpty()){
            log.error("La liste est vide");
        }
        List<ProduitDto> dtoList = new ArrayList<>();
        produitDtoList.forEach(p ->{
            dtoList.add(ProduitDto.fromEntity(p));
        });

        return dtoList;
    }


    /**
     *
     * @param idProduit
     * @param idLigneProduit
     * @param idService
     * @return
     */
    @Override
    public ProduitDto updateService(Integer idProduit, Integer idLigneProduit, Integer idService) {
        if (idProduit == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du produit null" + idProduit, ErrorCode.PRODUIT_NOT_FOUND);
        }

        if (idLigneProduit == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du service null" + idLigneProduit, ErrorCode.SERVICE_NOT_FOUND);
        }

        if (idService == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du nouveau service null" + idService, ErrorCode.SERVICE_NOT_FOUND);
        }

        ProduitDto produitDto = findById(idProduit);
        Optional<Ligneproduit> optionalLigneproduit = ligneProduitRepository.findById(idLigneProduit);
        if (optionalLigneproduit.isEmpty()){
            log.error("Aucun service avec cet Id "+idLigneProduit+" n'a ete trouve");
        }
        Optional<Services> optional = serviceRepository.findById(idService);
        if (optional.isEmpty()){
            throw new EntityNotFoundException("Auun id avec le Id "+idService+" n'a ete trouve", ErrorCode.SERVICE_NOT_FOUND);
        }
        ServicesValidator c = new ServicesValidator();
        List<String> errors = c.validator(ServiceDto.fromEntity(optional.get()));
        if(errors.isEmpty()){
            throw new InvalidEntityException("Setrvice invalid", ErrorCode.SERVICE_NOT_VALID, errors);
        }

        Ligneproduit ligneproduit = optionalLigneproduit.get();
        ligneproduit.setServices(optional.get());
        ligneProduitRepository.save(ligneproduit);

        return produitDto;
    }


    /**
     *
     * @param idProduit
     * @param idLigneProduit
     * @return
     */
    @Override
    public ProduitDto deleteProduit(Integer idProduit, Integer idLigneProduit) {
        if (idProduit == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du produit null" + idProduit, ErrorCode.PRODUIT_NOT_FOUND);
        }

        if (idLigneProduit == null){
            log.error("le id est null");
            throw new InvalidOperationException("Impossible de valider cette operation avec le id du service null" + idLigneProduit, ErrorCode.SERVICE_NOT_FOUND);
        }

        ProduitDto produitDto = findById(idProduit);
        Optional<Ligneproduit> optionalLigneproduit = ligneProduitRepository.findById(idLigneProduit);
        if (optionalLigneproduit.isEmpty()){
            log.error("Aucun service avec cet Id "+idLigneProduit+" n'a ete trouve");
        }
       ligneProduitRepository.deleteById(idLigneProduit);

        return produitDto;
    }

    @Override
    public void delete(Integer id) {
       if (id == null){
          log.error("Le produit avec cet Id "+ id+" n'existe pas");
       }
       produitRepository.deleteById(id);
    }


    /**
     * on recher les produit d'un client deja payé
     * @param phone
     * @return
     */
    @Override
    public List<ProduitDto> findAllByPhoneNumberTrue(String phone) {
        if (phone.isEmpty()){
            log.error("Aucun produit avec ce numero de telephone " +phone);
        }
        List<ProduitDto> produits = new ArrayList<>();
        List<Produit> allAndTrue = produitRepository.findAllAndTrue(phone);

        allAndTrue.forEach(p->{
            ProduitDto produitDto = ProduitDto.fromEntity(p);
            produits.add(produitDto);
        });

        return produits;
    }

    /**
     * on recher les produit d'un client aui nùq pas payé
     * @param phone
     * @return
     */
    @Override
    public List<ProduitDto> findAllByPhoneNumberFalse(String phone) {
        System.out.println("//////////////////////////////// " + phone);
        if (phone.isEmpty()){
            log.error("Aucun produit avec ce numero de telephone " +phone);
        }
        List<ProduitDto> produits = new ArrayList<>();
        List<Produit> allAndTrue = produitRepository.findAllAndFalse(phone);

        allAndTrue.forEach(p->{
            ProduitDto produitDto = ProduitDto.fromEntity(p);
            produits.add(produitDto);
        });

        return produits;
    }


    /**
     * on recherche les produits d'un client deja payé et livre
     * @param phone
     * @return
     */
    @Override
    public List<ProduitDto> findAllAndIsLivreTrue(String phone) {
       //System.out.println("//////////////////////////////// " + phone);
        if (phone.isEmpty()){
            log.error("Aucun produit avec ce numero de telephone " +phone);
        }
        List<ProduitDto> produits = new ArrayList<>();
        List<Produit> allAndIsLivreTrue = produitRepository.findAllAndIsLivreTrue(phone);

        allAndIsLivreTrue.forEach(p->{
            ProduitDto produitDto = ProduitDto.fromEntity(p);
            produits.add(produitDto);
        });

        return produits;
    }
}
