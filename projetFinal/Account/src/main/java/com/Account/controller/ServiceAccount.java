package com.Account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AccountDTO.AccountDTO;


@Service
public class ServiceAccount {
	
	private RepositoryAccount rAccount;
	

	public ServiceAccount(RepositoryAccount repositoryAccount) {
		System.out.println("OUI");
		//this.rAccount = repositoryAccount;
	}


	public List<AccountDTO> getUsers() {
	    List<AccountDTO> listAccount = (List<AccountDTO>) rAccount.findAll();
		return listAccount;
	}
	
	public AccountDTO getUserInfo(String idUser) {
		Optional<AccountDTO> uOpt = rAccount.findById(Integer.parseInt(idUser)); 
		
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}


}
