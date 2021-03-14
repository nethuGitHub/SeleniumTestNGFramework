package com.application1.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.application.driver.Driver;
import com.application.driver.DriverManager;

public class BaseTest {


	protected BaseTest() {

	}
	

	@BeforeSuite
	public void setupSuite()
	{


	}

	@AfterSuite
	public void AfterSuite() throws IOException
	{
		//Driver.quitDriver();

	}


	@BeforeMethod
	protected void setup(Object[] data) throws IOException
	{
		Map<String,String> map = (Map<String,String>)data[0];
		//System.out.println(map);
		Driver.initDriver(map.get("browser"));
		System.out.println(map.get("browser"));

	}

	@AfterMethod
	protected void tearDown(ITestResult result) {

		Driver.quitDriver();

	}
}
