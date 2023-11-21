package com.gn3.kpc.localnews.service;

import com.gn3.kpc.localnews.model.entity.LocalNews;
import com.gn3.kpc.localnews.model.repository.CityCodeRepository;
import com.gn3.kpc.localnews.model.repository.DsvnCodeRepository;
import com.gn3.kpc.localnews.model.repository.LocalNewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor=Exception.class)
public class LocalNewsServiceImpl implements LocalNewsService{

    @Autowired
    LocalNewsRepository localNewsRepository;
    @Autowired
    CityCodeRepository cityCodeRepository;
    @Autowired
    DsvnCodeRepository dsvnCodeRepository;

    @Override
    public List<LocalNews> getLocalNews(String cityCode, String dsvnCode) {
        return localNewsRepository.findByCityNoAndDvsnNo(cityCode, dsvnCode);
    }
}
