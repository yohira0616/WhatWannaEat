package com.bigfield.model.service.ganvi;


import com.bigfield.config.GrunaviApi;
import com.bigfield.model.service.Restaurant;
import com.google.common.collect.Lists;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GNaviSearchService {

    private GrunaviApi api;

    @Autowired
    public GNaviSearchService(GrunaviApi grunaviApi) {
        this.api = grunaviApi;
    }

    public List<Restaurant> search(String word, long latitude, long longitude) {
        String key = api.getKeyid();
        RequestConfig config = RequestConfig.DEFAULT;
        HttpGet httpGet=new HttpGet();



        return Lists.newArrayList();
    }

}
