package com.bigfield.controller.api;

import com.bigfield.model.service.LunchDecideService;
import com.bigfield.model.service.Restaurant;
import com.bigfield.model.service.ganvi.GNaviSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class LunchDecideController {

    private LunchDecideService lunchDecideService;

    private GNaviSearchService gNaviSearchService;

    @Autowired
    public LunchDecideController(LunchDecideService lunchDecideService, GNaviSearchService gNaviSearchService) {
        this.lunchDecideService = lunchDecideService;
        this.gNaviSearchService = gNaviSearchService;
    }

    @RequestMapping("/lunch")
    public String lunch() {
        return lunchDecideService.decideLunch();
    }

    @RequestMapping("/restaurant")
    public List<Restaurant> canditateRestaurants(@RequestParam("freeword") String freeword, @RequestParam("longitude") double longitude, @RequestParam("latitude") double latitude) {
        return gNaviSearchService.search(freeword, latitude, longitude);
    }
}
