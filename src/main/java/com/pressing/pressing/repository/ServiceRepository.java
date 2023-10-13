package com.pressing.pressing.repository;

import com.pressing.pressing.dto.ServiceDto;
import com.pressing.pressing.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Services, Integer> {
    Optional<Services> findByName(String name);
}
