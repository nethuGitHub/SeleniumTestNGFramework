package Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("before suite is listener");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("after suite is listener");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("before method is listener");
	}

	

}
