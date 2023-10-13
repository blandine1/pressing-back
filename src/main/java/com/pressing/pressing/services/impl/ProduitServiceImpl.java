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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    private final ServiceRepository serviceRepository;
    private final CategorieRepository categorieRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final LigneProduitRepository ligneProduitRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository, ServiceRepository serviceRepository, CategorieRepository categorieRepository, UtilisateurRepository utilisateurRepository, LigneProduitRepository ligneProduitRepository, ClientRepository clientRepository) {
        this.produitRepository = produitRepository;
        this.serviceRepository = serviceRepository;
        this.categorieRepository = categorieRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.ligneProduitRepository = ligneProduitRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public ProduitDto save(ProduitDto produitDto) {

        System.out.println(produitDto);

        ProduitValidator produitValidator=new ProduitValidator();
        List<String> errors = produitValidator.validator(produitDto);
        if(!errors.isEmpty()){
            log.error("le produit est invalide");
            throw new InvalidEntityException("le produit est invalide", ErrorCode.PRODUIT_NOT_VALID);
        }

        // il faut en fait que l'utilisateur soit enregistré ar defaut
      System.out.println("////////////////////////// "+produitDto);
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

        //a changer lors de la securite
        produitDto.setUtilisateurid(1);
        produitDto.setCreationDate(new Date());
        Produit saveDproduit = produitRepository.save(ProduitDto.toEntity(produitDto));

        if(produitDto.getListeLigneProduit() != null){
            produitDto.getListeLigneProduit().forEach(lgnePt->{
                Ligneproduit ligneproduit = LigneProduitDto.toEntity(lgnePt);
                ligneproduit.setProduit(saveDproduit);
                ligneproduit.setId_produit(saveDproduit.getId());
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

    //retourne la list des ligne de produit appartenant a un produit
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
       produitDto.setStatus(true);

        return ProduitDto.fromEntity(produitRepository.save(ProduitDto.toEntity(produitDto)));
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
        return produitRepository.findAll().stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduitDto> findAllTrue() {
        List<Produit> produitDtoList = produitRepository.findAllByStatusIsTrue();
        if (produitDtoList.isEmpty()){
            log.error("La liste est vide");
            //throw new EntityNotFoundException("list is empty", ErrorCode.PRODUIT_NOT_FOUND);
        }
        List<ProduitDto> dtoList = new ArrayList<>();
        produitDtoList.forEach(p ->{
            dtoList.add(ProduitDto.fromEntity(p));
        });

        return dtoList;
    }

    @Override
    public List<ProduitDto> findAllFalse() {
        List<Produit> produitDtoList = produitRepository.findAllByStatusIsFalse();
        if (produitDtoList.isEmpty()){
            log.error("La liste est vide");
            //throw new EntityNotFoundException("list is empty", ErrorCode.PRODUIT_NOT_FOUND);
        }
        List<ProduitDto> dtoList = new ArrayList<>();
        produitDtoList.forEach(p ->{
            dtoList.add(ProduitDto.fromEntity(p));
        });

        return dtoList;
    }

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
}
