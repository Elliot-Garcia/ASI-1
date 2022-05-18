package com.atelier3.account.controller;

import org.springframework.stereotype.Service;

import com.atelier3.account.model.User;



@Service
public class ServiceAccount {
	private RepositoryAccount rAccount;

	
	public ServiceAccount(RepositoryAccount repositoryAccount) {
		this.rAccount = repositoryAccount;
	}


	public User VerifyRegister(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	public User getUserInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
