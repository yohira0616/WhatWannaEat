package com.bigfield.model.service.spec;

import com.bigfield.model.service.Restaurant;

import java.util.List;

public interface GNaviSearchServiceSpec {
  List<Restaurant> search(String word, double latitude, double longitude);
}
