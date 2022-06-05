package com.asi.projet.Account.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.asi.projet.Account.model.User;

@Service
public interface RepositoryAccount extends CrudRepository<User, Integer>{
	

	
}
