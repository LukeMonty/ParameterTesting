package com.qa.Luke.Montgomery.Parameter.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Luke.Montgomery.Main.Constants;
import com.qa.Luke.Montgomery.Parameter.Pages.BingHomePage;
import com.qa.Luke.Montgomery.Parameter.Pages.BingResultsPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParameterSteps {

	WebDriver driver;

	ExtentTest test;

	BingHomePage home;
	BingResultsPage results;
	
	private String argToResults = "";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_FILEPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = ParameterTest.report.startTest("Navigate the website");
	}

	@After
	public void tearDown() {
		driver.quit();
		ParameterTest.report.endTest(test);
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		
		
		driver.get(arg1);
		test.log(LogStatus.INFO, "Go to URL: " + arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		argToResults = arg1;
		home = PageFactory.initElements(driver, BingHomePage.class);
		home.inputSearchParameters(arg1);
		test.log(LogStatus.INFO, "Input search parameters:" + arg1 + ", and searched.");
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
		results = PageFactory.initElements(driver, BingResultsPage.class);
		
		
		

		test.log(LogStatus.PASS, "Success: Found correct results");
		assertTrue(results.checkSearchResult(argToResults));
		
	}

}
