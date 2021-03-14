package com.application1.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.application1.Enums.CatagoryType;
import com.application1.Listener.RetryTestCases;
import com.application1.annotation.CustomAnnotation;
import com.application1.page.OrangeHRMLoginPage;
import com.application1.reports.ExtentManager;
import com.application1.utils.DataProviderutils;


public final class OrangeHRMLogin extends BaseTest {
	@CustomAnnotation(author = {"Nethaji"}, catagory = { CatagoryType.REGRESSION })
	@Test (dataProvider = "getData" ,dataProviderClass = DataProviderutils.class,retryAnalyzer = RetryTestCases.class)
	public void Login(Map<String,String> data) throws InterruptedException  {

		String title = new OrangeHRMLoginPage()
				.txtLogin(data.get("username")).txtPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();			
	}
	@CustomAnnotation(author = {"Riya"}, catagory = { CatagoryType.SMOKE })
	@Test (dataProvider = "getData" ,dataProviderClass = DataProviderutils.class,retryAnalyzer = RetryTestCases.class)
	public void Loginnew(Map<String,String> data) throws InterruptedException  {
		ExtentManager.getExtentTest().assignAuthor("Riya").assignCategory("Regression");
		String title1 = new OrangeHRMLoginPage()
				.txtLogin(data.get("username")).txtPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();			
	}
}
