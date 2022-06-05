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

    final String uri = "localhost:8082";

    /**
     * Send GET card request to Cards Microservice to find card corresponding to card id
     * @param cardId card id
     * @return CardDTO
     */
    public CardsDTO getCard(int cardId) {
        String url = uri +"/card/"+ cardId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, CardsDTO.class);
    }

    /**
     * Send GET card request to Cards Microservice to find card corresponding to user id and template id
     * @param userId user id
     * @param templateId template id
     * @return CardsDTO card found
     */
    public CardsDTO findCard(int userId, int templateId) {
        String url = uri +"/find/"+ userId +"/"+ templateId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, CardsDTO.class);
    }

    /**
     * Send DELETE card request to Cards Microservice, providing card id
     * @param cardId card id
     */
    public void deleteCard(int cardId){
        String url = uri +"/card/"+ cardId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
    }

    /**
     * Send POST (create) card request to Cards Microservice, providing user id and template id
     * @param userId user id
     * @param templateId template id
     */
    public void createCard(int userId, int templateId){
        RestTemplate restTemplate = new RestTemplate();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        jsonObject.put("templateId", templateId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<>(jsonObject.toString(), headers);

        restTemplate.postForObject(uri +"/card", request, CardsDTO.class);
    }

}
