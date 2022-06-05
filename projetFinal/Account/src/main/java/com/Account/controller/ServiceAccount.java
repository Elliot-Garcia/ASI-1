package com.Account.controller;

import com.Account.model.AccountBody;
import com.AccountDTO.AccountFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;


@Service
public class ServiceAccount {
	
	@Autowired
	private RepositoryAccount rAccount;
	

	public ServiceAccount(RepositoryAccount repositoryAccount) {
		this.rAccount = repositoryAccount;
	}


	public Iterable<AccountBody> getUsers() {
		return rAccount.findAll();
		
	}
	
	public AccountBody getUserInfo(String idUser) {
		System.out.println("getUse");
		Optional<AccountBody> uOpt = rAccount.findById(Integer.parseInt(idUser));

		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
	}


	public AccountBody addAccount(AccountFormDTO account) {
		AccountBody res;
		AccountBody newUser = new AccountBody(account.getLogin(), account.getPassword(), account.getBalance());
		res = rAccount.save(newUser);
		return res;
	}


	public AccountBody updateBalance(String id, String amout) {
		AccountBody user = getUserInfo(id);
		user.setBalance(Integer.parseInt(amout));
		rAccount.save(user);
		return user;
	}


	public AccountBody AccountForm2Body(AccountFormDTO accountForm) {
		return new AccountBody(accountForm.getLogin(), accountForm.getPassword(), accountForm.getBalance());
	}
}
