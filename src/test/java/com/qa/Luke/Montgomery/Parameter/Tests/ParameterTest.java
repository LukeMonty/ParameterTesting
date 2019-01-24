package com.qa.Luke.Montgomery.Parameter.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.Luke.Montgomery.Main.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class ParameterTest {

	static ExtentReports report;

	@BeforeClass
	public static void setUp() {
		report = new ExtentReports(Constants.REPORT_FILEPATH, true);
	}

	@AfterClass
	public static void tearDown() {
		report.flush();
	}

}
