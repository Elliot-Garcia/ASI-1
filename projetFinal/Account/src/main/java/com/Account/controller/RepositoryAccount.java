package com.Account.controller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.Account.model.AccountBody;
import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;

@Service
public interface RepositoryAccount extends CrudRepository<AccountBody, Integer> {

	/**
	public AccountFormDTO save(AccountFormDTO account) {
		System.out.println("save");
		return account;
	}
	 */

}
