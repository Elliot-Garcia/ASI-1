package com.Transaction.controller.request;

import com.AccountDTO.AccountDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestToAccount {
    final String uri = "localhost:8080/account";

    public AccountDTO getAccount(int cardId) {
        String url = uri +"/"+Integer.toString(cardId);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, AccountDTO.class);
    }

    public void addBalance(int userId, int amount){
        String url = uri +"/"+Integer.toString(userId)+"/balance/"+Integer.toString(amount);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<String>(headers);

        restTemplate.put(url, request);
    }

}
