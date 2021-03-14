package Listener;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Runner {

	@BeforeSuite
	public void setupsuite() {
		System.out.println("before suite in runner");		
	}
	@AfterSuite
	public void teamDownSuite() {
		System.out.println("After suite in runner");	
		
	}
	@BeforeMethod
	public void setupMethod() {
		System.out.println("before method in runner");		
	}
	@AfterMethod
	public void teamDownMethod() {
		System.out.println("After method in runner");		
	}

	@Test(retryAnalyzer= Retry.class)
	public void test1() { System.out.println("Test1");}

	@Test
	public void test2() { System.out.println("Test2");
	Assert.assertTrue(false);}
	
	@Test
	public void test3() { System.out.println("Test3");}


}
