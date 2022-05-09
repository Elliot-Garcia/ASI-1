package com.asi.projet.Account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAccount {
	
	private final ServiceAccount sAccount;
	
	public RestAccount(ServiceAccount serviceAccount) {
		this.sAccount = serviceAccount;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account")
	public String Register(@RequestParam String login, @RequestParam String psw) {
		return sAccount.VerifyRegister(login, psw);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public String showUserInfo(@RequestParam String idUser) {
		return sAccount.getUserInfo(idUser);
	}
}