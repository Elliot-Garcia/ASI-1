package com.Account;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.Account.controller.RepositoryAccount;
import com.Account.controller.ServiceAccount;
import com.Account.model.AccountBody;
import com.AccountDTO.AccountFormDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	ServiceAccount sAccount;

	@Autowired
	RepositoryAccount rAccount;

	@Test
	public void addAccount() {
		System.out.println("test1");
		AccountFormDTO newUser = new AccountFormDTO("login", "psw", 1000);
		AccountBody userCreated;
		when(sAccount.addAccount(newUser)).thenReturn(userCreated = new AccountBody("login", "psw", 1000));
		System.out.println(userCreated);
		assertEquals("{login:login,password:psw,balance:1000}", newUser.toString());
	}
	
	@Test
	public void getUserInfo() {
		System.out.println("test2");
		AccountBody newUser = new AccountBody("login", "psw", 1000);
		when(sAccount.getUserInfo("0")).thenReturn(newUser);
		assertEquals("{id:0,login:login,psw:psw,balance:1000}", newUser.toString());
		System.out.println("user exist");
	}

}

