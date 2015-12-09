package com.cml.mvc.test.user;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.cml.mvc.test.BaseTest;

public class UserTest extends BaseTest {

	public void testAddUser() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders
				.post("/user/addUser.mvc");
		this.mockMvc.perform(request).andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void testUser() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/user.mvc")
				.param("name", "222").param("username", "1")
				.param("age", "123a")
				.param("birthday", "1a2015-11-10 11:11:11").param("high", "11");
		this.mockMvc.perform(request)
		// .andExpect(status().isOk())
		// .andExpect(
		// content().contentType("application/json;charset=UTF-8"))
				.andDo(MockMvcResultHandlers.print());

		System.out.println("-----------------");
		System.out.println(content().json("result"));
	}

	@Test
	public void test() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/times.mvc")
				.param("id", "1").param("time", "2015-11-11 21:22:22");
		this.mockMvc.perform(request)
		// .andExpect(status().isOk())
		// .andExpect(
		// content().contentType("application/json;charset=UTF-8"))
				.andDo(MockMvcResultHandlers.print());

		System.out.println("-----------------");
		System.out.println(content().json("result"));
	}
}
