package com.Account.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;


@RestController
public class RestAccount {
	
	private final ServiceAccount sAccount;
	private final RepositoryAccount rAccount;
	
	public RestAccount(ServiceAccount serviceAccount, RepositoryAccount repoAccount) {
		this.sAccount = serviceAccount;
		this.rAccount = repoAccount;
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

	 @PostMapping("/account")
	 public AccountFormDTO addAccount(@RequestBody AccountFormDTO account) {
	    return rAccount.save(account);
	  }
	

}
