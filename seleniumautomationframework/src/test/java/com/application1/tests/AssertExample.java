package com.application1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AssertExample {
	
	@Test
	public void stingTest() {
		
	String temp = "hello";
	String a = null;
	Assertions.assertThat(a)
	.as("String is null").isNotNull()
	.isBlank();
	}
	
}
