package com.Account.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Account.controller.RepositoryAccount;
import com.Account.controller.ServiceAccount;
import com.Account.model.AccountBody;
import com.AccountDTO.AccountFormDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceAccountTest {

	@MockBean
	ServiceAccount sAccount;

	@Autowired
	RepositoryAccount rAccount;
	@Test
	public void addAccount(AccountFormDTO account) {
		when(sAccount.addAccount(account)).thenReturn(new AccountBody ( "login", "psw", 1000 ));
		AccountBody newUser = new AccountBody(account.getLogin(), account.getPassword(), account.getBalance());
		assertEquals("{id:1, login:login, password:psw, balance:1000}", rAccount.save(newUser));
	}
	
}


