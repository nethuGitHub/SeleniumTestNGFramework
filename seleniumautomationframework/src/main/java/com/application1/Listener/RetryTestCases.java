package com.application1.Listener;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.application1.Enums.ConfigEnum;
import com.application1.utils.DataProviderutils;
import com.application1.utils.ReadPropertyFile;

public class RetryTestCases implements  IRetryAnalyzer{
	
	private int count = 0;
	private int retry = 1;
	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(ReadPropertyFile.get(ConfigEnum.RETRYFAILEDTESTCASES).equalsIgnoreCase("yes"))
					{
						value = count<retry;
						count++;
						return value;
					}
		} catch (IOException e) {	
			e.printStackTrace();
		}
		return value;
	}
	
	

}
