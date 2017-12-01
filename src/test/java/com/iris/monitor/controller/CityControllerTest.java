package com.iris.monitor.controller;

import com.jayway.restassured.RestAssured;  
import com.jayway.restassured.response.ValidatableResponse;  
import static com.jayway.restassured.RestAssured.*;  
import static org.hamcrest.Matchers.*;

import org.junit.Before;  
import org.junit.Test;  

public class CityControllerTest  {

	@Before
	public void before()  {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8018;
		RestAssured.basePath="/api/city";
	}
	@Test
	public void testFindOneCity() {
		ValidatableResponse resp =get("/1").then();
		resp.body("id",equalTo(1),
				"city_name",equalTo("西安")).toString();
	}
}
