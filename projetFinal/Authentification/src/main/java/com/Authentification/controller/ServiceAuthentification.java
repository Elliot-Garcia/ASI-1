package com.Authentification.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;

@Service
public class ServiceAuthentification {
	
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();

	
	static final String URL_ACCOUNT = "http://localhost:8081";
	static final String URL_ACCOUNT_POST = "http://localhost:8081/account";

	public AccountFormDTO VerifyRegister(String login, String password) {
		// Send request with GET method and default Headers.
		AccountFormDTO newUser = null;
		String result = restTemplate.getForObject(URL_ACCOUNT, String.class);

		if(!login.contains(" ") && !login.isBlank()) { //Le login est vide ou contient des espaces ?
			if(!(result == login)) { //result.contains(login)  Le login ne fais pas partit des listes utilisateurs
				newUser = new AccountFormDTO(login, password, 5000);
				System.out.println("user = "+newUser);
				System.out.println(newUser.getLogin()+" "+newUser.getBalance() +" "+newUser.getPassword());

			    HttpHeaders headers = new HttpHeaders();
				headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

			    headers.setContentType(MediaType.APPLICATION_JSON);
			    RestTemplate restTemplate = new RestTemplate();
			    System.out.println(newUser.getLogin());
			    
			    // Data attached to the request.
			    HttpEntity<AccountFormDTO> requestBody = new HttpEntity<>(newUser, headers);
			    System.out.println("body = "+requestBody.getBody());
			      // Send request with POST method.
			    AccountFormDTO a = restTemplate.postForObject(URL_ACCOUNT_POST, requestBody, AccountFormDTO.class);
			    System.out.println("a = "+" "+a);
			    //TODO:Faire test d'existance du compte ou non
			      if (a != null && a.getLogin() != null) {

			         System.out.println("Account created: " + a.getLogin());
			      } else {
			         System.out.println("Something error!");
			      }
				
				
			}
		}
		
		return newUser;
	}
}
