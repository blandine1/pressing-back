package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProduitSortRepository extends PagingAndSortingRepository<Produit, Integer> {
    @Query("select p from Produit  p where p.client.firstName=?1")
    Page<Produit> findAll(String firstName, Pageable pageable);

}
