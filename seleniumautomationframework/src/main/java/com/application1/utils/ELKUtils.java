package com.application1.utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.testng.internal.PropertyUtils;

import com.application1.Enums.ConfigEnum;

import io.restassured.response.Response;

public class ELKUtils {
	private ELKUtils(){

	}

	public static void SendResultstoELK(String testname, String status) throws IOException {
		
		if(ReadPropertyFile.get(ConfigEnum.SENDREPORTTOELK).equalsIgnoreCase("yes")) {
			Map<String,String> map = new HashMap<>();
			map.put("testname", testname);
			map.put("status", status);
			map.put("executionTime", LocalDateTime.now().toString());

			Response response = given().header("Content-Type","application/json")
					.log()
					.all()
					.body(map)
					.post("http://localhost:9200/regression/results");
			response.prettyPrint();
			response=null;
		}

	}

}
