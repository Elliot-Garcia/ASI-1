package com.atelier3.account.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atelier3.account.model.User;


public class RestAccount {
	
	private final ServiceAccount sAccount;
	
	public RestAccount(ServiceAccount serviceAccount) {
		this.sAccount = serviceAccount;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account")
	public User Register(@RequestBody AccountBody account) {
		return sAccount.VerifyRegister(account.getLogin(), account.getPassword());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info/{id}")
	public User showUserInfo(@PathVariable String id) {
		return sAccount.getUserInfo(id);
	}

}
