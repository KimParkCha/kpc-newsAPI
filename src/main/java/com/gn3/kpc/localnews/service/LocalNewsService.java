package com.gn3.kpc.localnews.service;

import com.gn3.kpc.localnews.model.entity.LocalNews;

import java.util.List;
import java.util.Optional;

public interface LocalNewsService {
    public List<LocalNews> getLocalNews(String city, String dsvn);
}
