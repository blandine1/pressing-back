package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Produit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    @Query("select p from Produit p where p.client.phoneNumber=?1 and p.status=true order by p.creationDate desc")
    List<Produit> findAllAndTrue(String phone);

    @Query("select p from Produit p where p.client.phoneNumber=?1 and p.status=false order by p.creationDate desc")
    List<Produit> findAllAndFalse(String phone);
    List<Produit> findAllByStatusIsTrue();
    List<Produit> findAllByStatusIsFalse();

    //@Query("select p from Produit p inner join Ligneproduit l on p.id=l.id_produit")
//    @Query("select p.client.firstName,p.prixTotal from Produit p inner join Ligneproduit l on p.id=l.id_produit")
//    List<Produit> findByIdAndLigneproduits(Integer produitId);

    @Query("update Produit p set p.status = true where p.id=?1")
    Produit updateByStatusAndTrue(Integer id);
}
