package com.gn3.kpc.localnews.model.repository;

import com.gn3.kpc.localnews.model.entity.DsvnCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DsvnCodeRepository extends JpaRepository<DsvnCode, Long> {
    Optional<DsvnCode> findByCityAndDsvn(String city, String dvsn);
}
