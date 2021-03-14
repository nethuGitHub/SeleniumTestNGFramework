package Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int counter = 0;
	int limit  = 0;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (counter<limit) {
			counter++;
			return true;
			
		}
		
		return false;
	}

}
