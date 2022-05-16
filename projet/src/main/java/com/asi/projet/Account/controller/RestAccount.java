package com.asi.projet.Account.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println(login);
		return sAccount.VerifyRegister(login, psw);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info/{id}")
	public User showUserInfo(@PathVariable String id) {
		return sAccount.getUserInfo(id);
	}
}