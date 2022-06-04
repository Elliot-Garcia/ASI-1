package com.Transaction.controller.request;

import com.Transaction.controller.body.AccountBody;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestToAccount {
    final String uri = "localhost:8080/account";

    public AccountBody getAccount(int cardId) {
        String url = uri +"/"+Integer.toString(cardId);
        RestTemplate restTemplate = new RestTemplate();
        AccountBody result = restTemplate.getForObject(uri, AccountBody.class);
        return result;
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
