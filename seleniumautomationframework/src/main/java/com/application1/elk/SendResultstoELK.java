package com.application1.elk;

import  static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import org.junit.Assert;

public class SendResultstoELK {

	@SuppressWarnings({ "deprecation", "restriction" })
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("testname", "Test Case 15");
		map.put("status", "pass");
		map.put("executionTime", LocalDateTime.now().toString());

		System.out.println(map);
		System.out.println(map.get("status"));
		System.out.println(map.get("execution time"));

		Response response = given().header("Content-Type","application/json")
		.log()
		.all()
		.body(map)
		.post("http://localhost:9200/regression/results");
		Assert.assertEquals(response.statusCode(), 201);
		System.out.println(response.statusCode());
		response.prettyPrint();

	}

}
