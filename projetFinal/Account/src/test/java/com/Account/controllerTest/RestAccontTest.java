package com.Account.controllerTest;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Account.controller.RestAccount;
import com.Account.controller.ServiceAccount;
import com.Account.model.AccountBody;
import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;

@RunWith(SpringRunner.class)	
@WebMvcTest(value = RestAccount.class)
@WithMockUser
public class RestAccontTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceAccount sAccount;

	AccountBody user = new AccountBody("test", "UNIT", 5000);

	String exampleAccountJson = "{\"id\":1,\"login\":\"log\",\"password\":\"psw\",\"balance\":1000}";

	@Test
	public void showUserInfo() throws Exception {
		System.out.println("test3");
		Mockito.when(sAccount.getUserInfo("1")).thenReturn(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/account/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,login:log,password:psw,balance:1000}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	
	
	@Test
	public void addAccount() throws Exception {
		AccountBody addUser = new AccountBody("unitAdd", "testadd",1000);

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				sAccount.addAccount(Mockito.any(AccountFormDTO.class))).thenReturn(addUser);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/account")
				.accept(MediaType.APPLICATION_JSON).content(exampleAccountJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus()	);

		assertEquals("http://localhost/8081/account",
				response.getHeader(HttpHeaders.LOCATION));

	}

	
}
