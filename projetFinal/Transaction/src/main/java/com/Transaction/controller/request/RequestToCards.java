package com.Transaction.controller.request;

import com.CardsDTO.CardsDTO;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestToCards {

    final String uri = "localhost:8080/cards";

    public CardsDTO getCard(int cardId) {
        String url = uri +"/"+Integer.toString(cardId);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, CardsDTO.class);
    }

    public void deleteCard(int cardId){
        String url = uri +"/"+Integer.toString(cardId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
    }

    public void createCard(int userId, int templateId){
        String url = uri;
        RestTemplate restTemplate = new RestTemplate();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        jsonObject.put("templateId", templateId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);

        restTemplate.postForObject(uri, request, CardsDTO.class);
    }

}
