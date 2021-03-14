package com.application1.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.application1.Enums.CatagoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface CustomAnnotation {
	
	public String[] author();
	public CatagoryType[] catagory();

}
