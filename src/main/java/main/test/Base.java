package main.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import main.test.TestConstants.TestData;

public class Base {
//to intiate test suit variables

	@BeforeSuite
	public void setUpEnvironment() {

		TestData.ENVIRONMENT = "http://thawing-shelf-73260.herokuapp.com";
		System.out.println(TestData.ENVIRONMENT);
	
		TestData.BROWSER = "chrome";
		System.out.println(TestData.BROWSER);

	}

	@AfterSuite
	public void calledAfterTestSuite() {

		System.out.println("test Suite done");

	}

}
