package com.application1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.application.driver.DriverManager;
import com.application1.Enums.waitStrategy;
import com.application1.constants.FrameworkConstants;
import com.application1.reports.ExtentLogger;

public class BasePage {

	protected void click(By by,waitStrategy wait, String fieldname) {
		if (wait == waitStrategy.ENABLED) {
			explicitilyWaitForAnElementEnabled(by);
		}
		else if (wait == waitStrategy.DISPLAYED) {
			explicitilyWaitForAnElementDisplayed(by);
		}
		explicitilyWaitForAnElementEnabled(by);
		DriverManager.getDriver().findElement(by).click();
		ExtentLogger.Pass(fieldname + " successfull clicked");
	}
	protected void sendKeys(By by,String value,waitStrategy wait, String fieldname) {
		if (wait == waitStrategy.ENABLED) {
			explicitilyWaitForAnElementEnabled(by);
		}
		else if (wait == waitStrategy.DISPLAYED) {
			explicitilyWaitForAnElementDisplayed(by);
		}
		DriverManager.getDriver().findElement(by).sendKeys(value);
		ExtentLogger.Pass(value + " entered in to the " + fieldname);
	}
	private void explicitilyWaitForAnElementEnabled(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(d->d.findElement(by).isEnabled());
	}
	private void explicitilyWaitForAnElementDisplayed(By by) {
		WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwait());
		wait.until(d->d.findElement(by).isDisplayed());
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();


	}

}
