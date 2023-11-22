package com.gn3.kpc.localnews.controller;

import com.gn3.kpc.localnews.model.entity.LocalNews;
import com.gn3.kpc.localnews.service.LocalNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/localnews")
public class LocalNewsController {

    @Autowired
    LocalNewsService localNewsService;
    @Autowired
    JedisPool jedisPool;


    @ResponseBody
    @GetMapping("/cityCode/{cityCode}/dsvnCode/{dsvnCode}")
    public ResponseEntity<List<LocalNews>> getLocalNews(@PathVariable String cityCode, @PathVariable String dsvnCode){
        System.out.println("cityCode = " + cityCode);
        System.out.println("dsvnCode = " + dsvnCode);
        List<LocalNews> localNews = localNewsService.getLocalNews(cityCode, dsvnCode);

        if(localNews == null){
            return new ResponseEntity<List<LocalNews>>(localNews, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<List<LocalNews>>(localNews, HttpStatus.OK);
        }
    }

    @GetMapping("/temperature")
    public ResponseEntity<Integer> getTemperature(){
        Jedis jedis = jedisPool.getResource();
        double positive = Double.parseDouble(jedis.get("positive"));
        double negative = Double.parseDouble(jedis.get("negative"));
        int result = (int) ((positive/(positive + negative))*100.0);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @GetMapping("/wordcloud")
    public ResponseEntity<List<List<Object>>> getWordCloud(){
        Jedis jedis = jedisPool.getResource();
        Map<String, String> wordcloud = jedis.hgetAll("wordcloud");
        List<String> keySet = new ArrayList<>(wordcloud.keySet());
        keySet.sort((o1, o2) -> wordcloud.get(o2).compareTo(wordcloud.get(o1)));

        List<List<Object>> result = new ArrayList<>();
        int cnt = 0;
        for (String s : wordcloud.keySet()) {
            List<Object> list = new ArrayList<>();
            list.add(s);
            list.add(Integer.parseInt(wordcloud.get(s)));
            result.add(list);
            System.out.println(s + " " + Integer.parseInt(wordcloud.get(s)));
            if(cnt++ >= 200)break;
        }

        return new ResponseEntity<List<List<Object>>>(result, HttpStatus.OK);
    }
}
