package com.Account.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AccountDTO.AccountDTO;


@RestController
public class RestAccount {
	
	private final ServiceAccount sAccount;
	
	public RestAccount(ServiceAccount serviceAccount) {
		this.sAccount = serviceAccount;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AccountDTO> GetAllAccount() {
		System.out.println("OUI");
		return sAccount.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/info/{id}")
	public AccountDTO showUserInfo(@PathVariable String id) {
		System.out.println("OUI++");
		return sAccount.getUserInfo(id);
	}


}
