package com.asi.projet.authentification.controller;

import org.springframework.stereotype.Service;

@Service
public class RepositoryAuthentification {
	
	/**
	 * acces to DB and return the login
	 * @param int : id of the asked user
	 * @return String : login of the asked user
	 */
	public String getLogin(int id) {
		// select login from user where id = id
		String ret = "vick";
		return ret;
	}
	
	/**
	 * acces to DB and return all the logins
	 * @return String : all login in DB
	 */
	public String getLogin() {
		// select login from user
		String ret = "all login";
		return ret;
	}
	
	/**
	 * acces to DB and return the asked password
	 * @param String : login of the asked user
	 * @return String : password of the asked user
	 */
	public String getPasswordWithLogin(String login) {
		// select login from user where login = login
		String ret = "vick";
		return ret;
	}
	
	/**
	 * acces to DB and return the password
	 * @param int : id of the asked user
	 * @return String : password of the asked user
	 */
	public String getPassword(int id) {
		// select password from user where id = id 
		String ret = "vick"; 
		return ret;
	}
}

