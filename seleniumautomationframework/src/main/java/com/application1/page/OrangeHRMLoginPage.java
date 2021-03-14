package com.application1.page;

import org.openqa.selenium.By;

import com.application1.Enums.waitStrategy;

public class OrangeHRMLoginPage extends BasePage {



	private final By txtLogin = By.id("txtUsername");
	private final By txtPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By btnLogin = By.id("btnLogin");


	public OrangeHRMLoginPage txtLogin(String login) {
		sendKeys(txtLogin,login, waitStrategy.ENABLED,"loginname field");
		return this;

	}
	public OrangeHRMLoginPage txtPassword(String password) {
		sendKeys(txtPassword,password, waitStrategy.ENABLED,"password field");
		return this;
	}
	public OrangeHRMHomePage clickLogin() {
		click(btnLogin,waitStrategy.ENABLED,"Login button");
		return new OrangeHRMHomePage();
	}
	public String getTitle() {
		return getPageTitle();


	}

}
