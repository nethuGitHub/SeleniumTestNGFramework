package com.application1.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private  ExtentManager() {
	}
	private static ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
	public static ExtentTest getExtentTest( ) {
		return extenttest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extenttest.set(test);
	}

	static void unload() {
		extenttest.remove();
	}


}
