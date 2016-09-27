package com.bigfield;

import com.bigfield.model.service.ganvi.GNaviSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhatWannaEatApplicationTests {

    @Autowired
    private GNaviSearchService service;

    @Test
    public void contextLoads() {
        service.search("中華", 35.746477399999996, 139.7392217);
    }

}
