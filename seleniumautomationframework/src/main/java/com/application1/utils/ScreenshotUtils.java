package com.application1.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.application.driver.DriverManager;

public class ScreenshotUtils {
	private ScreenshotUtils() {

	}

	public static String getBase64image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
