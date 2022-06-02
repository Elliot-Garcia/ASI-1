package com.Account.controller;
import org.springframework.stereotype.Service;

import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;

@Service
public class RepositoryAccount {

	public AccountFormDTO save(AccountFormDTO account) {
		System.out.println("save");
		return account;
	}


}
