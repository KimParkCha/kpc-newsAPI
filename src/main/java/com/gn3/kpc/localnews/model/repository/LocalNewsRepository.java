package com.gn3.kpc.localnews.model.repository;

import com.gn3.kpc.localnews.model.entity.LocalNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalNewsRepository extends JpaRepository<LocalNews, Long> {
    List<LocalNews> findByCityNoAndDvsnNo(String cityNo, String dvsnNo);
    void deleteByCityNoAndDvsnNo(String cityNo, String dvsnNo);
}
