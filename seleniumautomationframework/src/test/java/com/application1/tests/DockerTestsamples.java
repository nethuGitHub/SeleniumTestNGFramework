package com.application1.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

public class DockerTestsamples {
	
	@Test (dataProvider = "getData")
	public void localtest(String browser) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browser);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.google.com");
		System.out.println("Title is" + driver.getTitle());
		Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
		driver.quit();
		
	}


	@DataProvider(parallel=true)
	public Object[][] getData(){
		return new Object[][]
				{{"chrome"},{"chrome"},{"chrome"},{"chrome"},{"chrome"},{"chrome"},{"firefox"},{"firefox"}};
				
	}

}
