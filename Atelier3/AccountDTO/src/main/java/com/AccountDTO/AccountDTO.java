package com.AccountDTO;

public class AccountDTO {
		private String login;
		private String id;
		private int balance;
		
		public AccountDTO() {
			
		}
		public AccountDTO(String login, String id, int balance) {
			this.login = login;
			this.id = id;
			this.balance = balance;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			return "{id:" + id + "login:" + login + ",balance:" + balance + "}";
		}

}
