package com.bigfield.controller.api;

import com.bigfield.model.service.LunchDecideService;
import com.bigfield.model.service.Restaurant;
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

    @Autowired
    public LunchDecideController(LunchDecideService lunchDecideService) {
        this.lunchDecideService = lunchDecideService;
    }

    @RequestMapping("/lunch")
    public String lunch() {
        return lunchDecideService.decideLunch();
    }

    @RequestMapping("/restaurant")
    public List<Restaurant> canditateRestaurants(@RequestParam String freeword, @RequestParam long longitude, @RequestParam long latitude) {
        return new ArrayList<>();
    }
}
