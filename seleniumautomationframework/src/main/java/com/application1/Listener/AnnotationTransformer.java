package com.application1.Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import com.application1.utils.DataProviderutils;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotation, Class testclass, Constructor testConstructor,Method testMethod )
	{
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderutils.class);
		annotation.setRetryAnalyzer(RetryTestCases.class);
	}

}
