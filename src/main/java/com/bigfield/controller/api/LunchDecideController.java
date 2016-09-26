package com.bigfield.controller.api;

import com.bigfield.model.service.LunchDecideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
