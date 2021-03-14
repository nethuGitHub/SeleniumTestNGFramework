package com.application1.page;

import org.openqa.selenium.By;

import com.application1.Enums.waitStrategy;
import com.application1.reports.ExtentLogger;
import com.application1.reports.ExtentManager;
import com.application1.reports.ExtentReport;

public class OrangeHRMHomePage extends BasePage {



	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//*[@id=\"welcome\"]");


	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome,waitStrategy.DISPLAYED,"Welcome button");	
		return this;
	}
	public OrangeHRMLoginPage clickLogout() {
		
		click(linkLogout,waitStrategy.DISPLAYED,"Logout button");
		return new OrangeHRMLoginPage();
	}

}
