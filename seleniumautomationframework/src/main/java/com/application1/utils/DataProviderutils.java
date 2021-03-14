package com.application1.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.application1.constants.FrameworkConstants;

public final class DataProviderutils {
	
	private static List<Map<String, String>> list =  new ArrayList<>();
	@DataProvider(name = "getData")
	public static Object[] getData(Method m) {
		
		try {
			if (list.isEmpty()) {
				list = ExcelOperations.getTestcase(FrameworkConstants.getIterationpath());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, String>> iterationlist =  new ArrayList<>();
		String testname = m.getName();
		for (int i=0;i<list.size();i++)
		{
			if (list.get(i).get("name").equalsIgnoreCase(m.getName()) && 
			list.get(i).get("execute").equalsIgnoreCase("yes")) {
					iterationlist.add(list.get(i));
			}
		}
		return iterationlist.toArray();
		
	}

}
