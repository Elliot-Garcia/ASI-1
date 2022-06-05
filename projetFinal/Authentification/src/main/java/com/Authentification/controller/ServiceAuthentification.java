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
				
				//res = rAccount.save(newUser); //TODO: REQUETE AU SERVICE ACCOUT
				//sCards.initCards(res.getId());
			}
		}
		/**
		AccountFormDTO res = null;
		List<String> listLogin = rLogin.getLogin(); //get login d'authentification
	
		//return res;
		 */
		return newUser;
	}
}
/**	
	headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	// Request to return JSON format
	headers.setContentType(MediaType.APPLICATION_JSON);
	//headers.set("my_other_key", "my_other_value");

	// HttpEntity<String>: To get result as String.
	AccountFormDTO aform; 
	return null;
	HttpEntity<AccountFormDTO> entity = new HttpEntity<String>(aform,headers);

	// Send request with GET method, and Headers.
	
	ResponseEntity<String> response = restTemplate.postForEntity(URL_ACCOUNT, entity, AccountForm.class);
	
//	ResponseEntity<String> response = restTemplate.exchange(URL_ACCOUNT, //
//			HttpMethod.GET, entity, String.class);

	String result = response.getBody();
*/