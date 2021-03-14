package com.application1.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import com.application1.Enums.CatagoryType;
import com.application1.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {

	private ExtentReport(){}
	private static ExtentReports extent;
	public  static ExtentTest test;

	public static void initReport() throws IOException {
		
		if(Objects.isNull(extent)) {
			extent= new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Nethaji testing");
			Date date = new Date();
			String starttime = date.toString();
		}
	}

	public static void flushReport() throws IOException {
		if(Objects.nonNull(extent)) {
			Date date = new Date();
			String Endtime = date.toString();
			extent.flush();
		}
		ExtentManager.unload();

		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());

	}

	public static void createTest(String testcasename) {

		ExtentManager.setExtentTest(extent.createTest(testcasename));

	}
	public static void AddAuthors(String[] authors) {
		for( String author:authors){
			ExtentManager.getExtentTest().assignAuthor(authors);	
		}
	}
	public static void AddCatagories(CatagoryType[] catagories) {
		for( CatagoryType catagory:catagories){
			ExtentManager.getExtentTest().assignCategory(catagory.toString());	
		}
	}
	
}
