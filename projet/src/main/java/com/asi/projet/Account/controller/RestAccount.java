package com.asi.projet.Account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asi.projet.Account.model.User;

@RestController
public class RestAccount {
	
	private final ServiceAccount sAccount;
	
	public RestAccount(ServiceAccount serviceAccount) {
		this.sAccount = serviceAccount;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account")
	public User Register(@RequestParam String login, @RequestParam String psw) {
		return sAccount.VerifyRegister(login, psw);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public User showUserInfo(@RequestParam int idUser) {
		return sAccount.getUserInfo(idUser);
	}
}