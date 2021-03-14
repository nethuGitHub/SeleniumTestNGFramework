package com.application1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.application.driver.DriverManager;


public final class LoginPage extends BaseTest {
	private LoginPage() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void test() {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		

	}

}


