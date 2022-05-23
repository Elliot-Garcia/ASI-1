package com.atelier3.LoginRegister.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.AccountDto;



public class RestLoginRegister {
	
	private final ServiceLoginRegister sLoginRegister;
	
	public RestLoginRegister(ServiceLoginRegister loginRegister) {
		this.sLoginRegister = loginRegister;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account")
	public AccountDto Register(@RequestBody RegistertBody register) {
		return sLoginRegister.VerifyRegister(register.getLogin(), register.getPassword());
	}

}
