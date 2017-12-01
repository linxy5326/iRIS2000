package com.iris.monitor.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserAccountControllerTest {

	static String url = "http://localhost:8018/api/UA";

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetUAByNameAndPwd() {

		/*
		 * request = get(url + "/1"); try {
		 * mvc.perform(request).andExpect(status().isOk());
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

}
