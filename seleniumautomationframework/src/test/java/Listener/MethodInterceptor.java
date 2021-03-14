package Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.application1.Enums.ConfigEnum;
import com.application1.constants.FrameworkConstants;
import com.application1.utils.ExcelOperations;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// TODO Auto-generated method stub
		List<IMethodInstance> result = new ArrayList<>();
		//String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdata.xlsx";

		List<Map<String, String>> list =  new ArrayList<Map<String, String>>();
		try {
			list = ExcelOperations.getTestcase(FrameworkConstants.getIterationpath());
			System.out.println(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(methods.size()+list.size());
		for (int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name")));
				{
					if(list.get(j).get("execute").equalsIgnoreCase("yes")) 
					{
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						result.add(methods.get(i));
					}
					else if(list.get(j).get("execute").equalsIgnoreCase("no"))
					{
						System.out.println(list.get(j).get("name"));
					}
				}

			}
		}

		return result;

	}

}



