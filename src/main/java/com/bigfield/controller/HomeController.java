package com.bigfield.controller;

import com.bigfield.model.service.LunchDecideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private LunchDecideService lunchDecider;

    @Autowired
    public HomeController(LunchDecideService lunchDecider) {
        this.lunchDecider = lunchDecider;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/result")
    public String result(Model model) {
        String result = lunchDecider.decideLunch();
        model.addAttribute("result", result);
        model.addAttribute("pageTitle", "今日は" + result + "を食べましょう。");
        return "result";
    }


}
