package com.udemy.selenium.docker;

import java.util.List;

import org.testng.TestNG;

import com.beust.jcommander.internal.Lists;

public class Execute {
	
	static TestNG testNG;
	public static void main(String[] args) {
	
		testNG = new TestNG();
		//testNG.setTestClasses(new Class[] {Runner.class});
		
		List<String> suites = Lists.newArrayList();
		suites.add("H:\\SDET_BY_VinothSelvaraj\\selenium.docker\\testng.xml");
		testNG.setTestSuites(suites);
		testNG.run();
	}

}
