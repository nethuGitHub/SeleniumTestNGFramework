package com.application1.constants;

import java.io.IOException;

import com.application1.Enums.ConfigEnum;
import com.application1.utils.ReadPropertyFile;

public final class FrameworkConstants {

	private FrameworkConstants() {
		
	}

	private static final String RESOURCES = System.getProperty("user.dir")+"\\src\\test\\resources";
	private static final String CHROMEPATH = RESOURCES+"\\Executables\\chromedriver.exe";
	private static final String FIREFOXPATH = RESOURCES+"\\Executables\\geckodriver.exe";
	private static final String CONFIGPATH = RESOURCES+"\\Config\\FrameworkProperties";
	private static final int EXPLICITWAIT = 5;
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/extent-test-report";
	private static String EXTENTREPORTFILEPATH = "";
	private static final String RUNMANAGERPATH = "RUNMANAGER";
	private static final String ITERATIONPATH = "TestData";
	
	/**
	 * @return the iterationpath
	 */
	public static String getIterationpath() {
		return ITERATIONPATH;
	}

	/**
	 * @return the runmanagerpath
	 */
	public static String getRunmanagerpath() {
		return RUNMANAGERPATH;
	}

	/**
	 * @return the extentreportpath
	 * @throws IOException 
	 */
	private static String getExtentreportpath() throws IOException {
		if(ReadPropertyFile.get(ConfigEnum.OVERRIDEREPORTS).equalsIgnoreCase("no"))
		{
			return EXTENTREPORTPATH+ "/" + System.currentTimeMillis()+"index.html";
		}
		else
		{
			return EXTENTREPORTPATH+ "/" + "index.html";
		}
		
	}

	/**
	 * @return the extentreportfilepath
	 * @throws IOException 
	 */
	public static String getExtentreportfilepath() throws IOException {
		if(EXTENTREPORTFILEPATH.isEmpty()){
			EXTENTREPORTFILEPATH = getExtentreportpath();
		}
		
		return EXTENTREPORTFILEPATH;
	}

	public static String getResources() {
		return RESOURCES;
	}

	public static String getConfigPath() {
		return CONFIGPATH;
	}


	public static String getChromePath() {
		return CHROMEPATH;
	}
	
	public static String getFirefoxpath() {
		return FIREFOXPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

}
