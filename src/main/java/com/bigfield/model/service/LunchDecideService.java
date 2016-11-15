package com.bigfield.model.service;


import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LunchDecideService {

  public String decideLunch() {
    Random rand = new Random();
    int randomNumber = rand.nextInt(3);
    switch (randomNumber) {
      case 0:
        return "和食";
      case 1:
        return "中華";
      case 2:
        return "イタリアン";
      default:
        return "ラーメン二郎";
    }
  }
}
