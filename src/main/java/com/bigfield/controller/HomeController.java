package com.bigfield.controller;

import com.bigfield.config.GrunaviApi;
import com.bigfield.model.service.LunchDecideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private LunchDecideService lunchDecider;

    private GrunaviApi grunaviApi;

    @Autowired
    public HomeController(LunchDecideService lunchDecider, GrunaviApi grunaviApi) {
        this.lunchDecider = lunchDecider;
        this.grunaviApi = grunaviApi;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/result")
    public String result(Model model) {
        String result = lunchDecider.decideLunch();
        model.addAttribute("lunch", result);
        model.addAttribute("pageTitle", "今日は" + result + "を食べましょう。");
        return "result";
    }


}
