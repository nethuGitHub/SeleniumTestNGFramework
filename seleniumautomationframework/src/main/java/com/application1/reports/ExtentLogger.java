package com.application1.reports;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.application.driver.DriverManager;
import com.application1.Enums.ConfigEnum;
import com.application1.utils.ReadPropertyFile;
import com.application1.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {
	
	private ExtentLogger(){}
	
	public static void Pass(String text) {
		ExtentManager.getExtentTest().pass(text);
	}
	public static void Fail(String text) {
		ExtentManager.getExtentTest().fail(text);
	}
	public static void Skip(String text) {
		ExtentManager.getExtentTest().skip(text);
	}
	
	public static void Pass(String message, boolean isScreenshotrequired) throws IOException {
		if(ReadPropertyFile.get(ConfigEnum.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenshotrequired) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64image()).build());
		}
		else
		{
			Pass(message);
		}
	}
	
	public static void Fail(String message, boolean isScreenshotrequired) throws IOException {
		if(ReadPropertyFile.get(ConfigEnum.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenshotrequired) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64image()).build());
		}
		else
		{
			Fail(message);
		}
	}
	
	public static void Skip(String message, boolean isScreenshotrequired) throws IOException {
		if(ReadPropertyFile.get(ConfigEnum.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenshotrequired) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64image()).build());
		}
		else
		{
			Skip(message);
		}
		
	}
	
	
}
