package com.Account.controller;

import com.Account.model.AccountBody;
import com.AccountDTO.AccountFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestAccount {

	@Autowired
	private final ServiceAccount sAccount;

	public RestAccount(ServiceAccount serviceAccount) {
		this.sAccount = serviceAccount;
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
