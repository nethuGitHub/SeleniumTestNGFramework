package com.application1.Listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.application1.annotation.CustomAnnotation;
import com.application1.reports.ExtentLogger;
import com.application1.reports.ExtentReport;
import com.application1.utils.ELKUtils;

public class ListenerClass implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		try {
			ExtentReport.initReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		try {
			ExtentReport.flushReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.AddAuthors(
				result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(CustomAnnotation.class)
				.author());
		ExtentReport.AddCatagories(
				result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(CustomAnnotation.class)
				.catagory());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentLogger.Pass(result.getMethod().getMethodName()+ " is Passed");
		try {
			ELKUtils.SendResultstoELK(result.getMethod().getMethodName(), "pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			ExtentLogger.Fail(result.getMethod().getMethodName()+ " is Failed", true);
			ExtentLogger.Fail(result.getThrowable().toString());
			ELKUtils.SendResultstoELK(result.getMethod().getMethodName(), "fail");
		//	ExtentLogger.Fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentLogger.Skip(result.getMethod().getMethodName()+ " is Skipped");
		try {
			ELKUtils.SendResultstoELK(result.getMethod().getMethodName(), "skip");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}



}
