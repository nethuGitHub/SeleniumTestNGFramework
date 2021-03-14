package com.application.driver;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.application1.Enums.ConfigEnum;
import com.application1.utils.ReadPropertyFile;

public final class Driver {
	private Driver() {

	}

	private static WebDriver driver;

	public static  void initDriver(String browser) throws IOException {
		
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				
				//WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromePath());
				//WebDriver driver = new ChromeDriver();
				//DriverManager.setDriver(new ChromeDriver());
				
				DesiredCapabilities dr = new DesiredCapabilities();
				//specify the browser
				dr.setBrowserName(browser);  
				System.out.println(browser);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
				DriverManager.setDriver(driver);
				
			}
			if (browser.equalsIgnoreCase("firefox")) {
				//WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver",FrameworkConstants.getFirefoxpath());
				//WebDriver driver = new FirefoxDriver();
				//DriverManager.setDriver(new FirefoxDriver());
				
				DesiredCapabilities dr = new DesiredCapabilities();
				//specify the browser
				dr.setBrowserName(browser); 
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
				DriverManager.setDriver(driver);
				
			}

			
			DriverManager.getDriver().get(ReadPropertyFile.get(ConfigEnum.URL));
			//DriverManager.getDriver().manage().window().maximize();
		}

	}
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
