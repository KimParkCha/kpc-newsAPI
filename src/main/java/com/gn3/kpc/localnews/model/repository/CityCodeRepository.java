package com.gn3.kpc.localnews.model.repository;

import com.gn3.kpc.localnews.model.entity.CityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityCodeRepository extends JpaRepository<CityCode, Long> {
    Optional<CityCode> findByCity(String city);
}
