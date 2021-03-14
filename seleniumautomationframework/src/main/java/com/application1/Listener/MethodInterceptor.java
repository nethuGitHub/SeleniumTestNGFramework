package com.application1.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.application1.constants.FrameworkConstants;
import com.application1.utils.ExcelOperations;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		
		
		List<Map<String, String>> list =  new ArrayList<Map<String, String>>();
		try {
			list = ExcelOperations.getTestcase(FrameworkConstants.getRunmanagerpath());
			System.out.println("list details is" + list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<IMethodInstance> result = new ArrayList<>();
		System.out.println("initial result" + result);
		
		
		for (int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))
				&& list.get(j).get("execute").equalsIgnoreCase("yes")) 
					{
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
					else if(list.get(j).get("execute").equalsIgnoreCase("no"))
					{
						//result.remove(methods.get(i));
					}
				

			}
		}
		System.out.println("final result" + result);
		return result;

	}

}



