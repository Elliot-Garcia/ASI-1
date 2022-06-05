package com.Account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Account.model.AccountBody;
import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;


@RestController
public class RestAccount {
	
	private final ServiceAccount sAccount;
	
	@Autowired
	private final RepositoryAccount rAccount;
	
	public RestAccount(ServiceAccount serviceAccount, RepositoryAccount repoAccount) {
		this.sAccount = serviceAccount;
		this.rAccount = repoAccount;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<AccountBody> GetAllAccount() {
		System.out.println("OUI");
		return sAccount.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account/{id}")
	public AccountBody showUserInfo(@PathVariable String id) {
		System.out.println("OUI++");
		return sAccount.getUserInfo(id);
	}

	 @PostMapping("/account")
	 public AccountBody addAccount(@RequestBody AccountFormDTO account) {
	    return sAccount.addAccount(account);
	  }
	
	 @PutMapping(value = "/account/{id}/balance/{amount}")
		public AccountBody showUserInfo(@PathVariable String id, @PathVariable String amount) {
			System.out.println("put");
			return sAccount.updateBalance(id, amount);
		}

}
