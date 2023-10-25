package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginationRepository extends PagingAndSortingRepository<Produit,Integer> {
    //Page<Produit> findAllOrOrderByCreationDate(Pageable pageable);
}
