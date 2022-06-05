package com.atelier3.LoginRegister.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.model.AccountDto;

public class ServiceLoginRegister {
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();

	
	static final String URL_ACCOUNT = "http://localhost:8080/account";
			
	public AccountDto VerifyRegister(String login, String password) {
		
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.set("my_other_key", "my_other_value");

		// HttpEntity<String>: To get result as String.
		HttpEntity<AccountForm> entity = new HttpEntity<String>(aform,headers);

		// Send request with GET method, and Headers.
		
		ResponseEntity<String> response = restTemplate.postForEntity(URL_ACCOUNT, entity, AccountForm.class);
		
//		ResponseEntity<String> response = restTemplate.exchange(URL_ACCOUNT, //
//				HttpMethod.GET, entity, String.class);

		String result = response.getBody();
		
		
		User res = null;
		List<String> listLogin = rLogin.getLogin(); //get login d'authentification
		if(!login.contains(" ") && !login.isBlank()) { //Le login est vide ou contient des espaces ?
			if(!listLogin.contains(login)) { //Le login ne fais pas partit des listes utilisateurs
				User newUser = new User(login, password, 5000);
				
				res = rAccount.save(newUser); //TODO: REQUETE AU SERVICE ACCOUT
				//sCards.initCards(res.getId());
			}
		}
		return res;
		
		return null;
	}

}
