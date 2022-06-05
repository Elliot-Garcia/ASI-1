package com.Account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Account.model.AccountBody;
import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;


@Service
public class ServiceAccount {
	
	@Autowired
	private RepositoryAccount rAccount;
	

	public ServiceAccount(RepositoryAccount repositoryAccount) {
		this.rAccount = repositoryAccount;
	}


	public List<AccountDTO> getUsers() {
		/**
	    List<AccountDTO> listAccount = (List<AccountDTO>) rAccount.findAll();
		return listAccount;
		*/
		return null;
		
	}
	
	public AccountBody getUserInfo(String idUser) {
		System.out.println("getUse");
		Optional<AccountBody> uOpt = rAccount.findById(Integer.parseInt(idUser)); 
		
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}


	public AccountBody addAccount(AccountFormDTO account) {
		AccountBody res = null;
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


}
