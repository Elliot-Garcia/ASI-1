package com.asi.projet.authentification.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.asi.projet.Account.model.User;

public interface RepositoryAuthentification extends CrudRepository<User, Integer> {
	
	/**
	 * acces to DB and return the login
	 * @param int : id of the asked user
	 * @return String : login of the asked user
	 */
	@Query("select login from User where id=$1")
	String getLogin(int id);
	
	/**
	 * acces to DB and return all the logins
	 * @return String : all login in DB
	 */
	@Query("select login from User")
	List<String> getLogin();
	
	/**
	 * acces to DB and return the asked password
	 * @param String : login of the asked user
	 * @return String : password of the asked user
	 */
	@Query("select psw from User where login=$1")
	String getPasswordWithLogin(String login);


	/**
	 * acces to DB and return the password
	 * @param int : id of the asked user
	 * @return String : password of the asked user
	 */
	@Query("select psw from User where id = $1 ")
	String getPassword(int id);
}

