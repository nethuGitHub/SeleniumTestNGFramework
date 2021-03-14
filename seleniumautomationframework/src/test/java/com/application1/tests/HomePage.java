package com.application1.tests;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.application.driver.DriverManager;

public class HomePage extends BaseTest {

	private static final List<WebElement> element = null;
	private static final boolean WebElement = false;

	protected HomePage() {
		
	}
	
	@Test
	public void test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		System.out.println(title);
		
		assertThat(title)
			.as("Object is Null").isNotNull()
			.as("does not contain google search").containsIgnoringCase("google search")
			.as("Length is not >15").hasSizeBetween(15, 100);
		
		List<WebElement> myElements = DriverManager.getDriver().findElements(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3/span"));
		System.out.println(myElements.size());
		
		assertThat(myElements)
			.extracting(e->e.getText())
			.contains("Selenium WebDriver");
		
		
	}
	
	
}
