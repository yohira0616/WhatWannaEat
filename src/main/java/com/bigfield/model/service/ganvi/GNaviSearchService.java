package com.bigfield.model.service.ganvi;


import com.bigfield.config.GrunaviApi;
import com.bigfield.model.service.Restaurant;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class GNaviSearchService {

  private GrunaviApi api;

  @Autowired
  public GNaviSearchService(GrunaviApi grunaviApi) {
    this.api = grunaviApi;
  }

  public List<Restaurant> search(String word, double latitude, double longitude) {
    String key = api.getKeyid();
    CloseableHttpClient httpClient = HttpClients.createDefault();
    URI url = null;
    try {
      url = new URIBuilder().setScheme("http")
          .setHost("api.gnavi.co.jp")
          .setPath("/RestSearchAPI/20150630/")
          .setParameter("keyid", key)
          .setParameter("format", "json")
          .setParameter("latitude", String.valueOf(latitude))
          .setParameter("longitude", String.valueOf(longitude))
          .setParameter("freeword", word)
          .build();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    HttpGet httpGet = new HttpGet(url);
    CloseableHttpResponse response = null;
    try {
      response = httpClient.execute(httpGet);

      ObjectMapper mapper = new ObjectMapper();
      JsonNode jsonNode = mapper.readTree(response.getEntity().getContent());
      JsonNode restaurant = jsonNode.path("rest");

      List<Restaurant> result = Lists.newArrayList();
      for (JsonNode node : restaurant) {
        Restaurant r = new Restaurant();
        r.setName(node.path("name").asText());
        r.setUrlMobile(node.path("url_mobile").asText());
        r.setAddress(node.path("address").asText());
        result.add(r);
      }

      //print
      result.forEach((re) -> {
        System.out.println(re.getName() + ":" + re.getUrlMobile() + ":" + re.getAddress());
      });

      return result;
    } catch (IOException e) {
      e.printStackTrace();
    }


    return Lists.newArrayList();
  }

}
