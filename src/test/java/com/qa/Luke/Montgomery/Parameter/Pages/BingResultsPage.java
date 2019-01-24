package com.qa.Luke.Montgomery.Parameter.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingResultsPage {
	
	@FindBy(id = "b_results")
	private WebElement searchResult;
	
	public boolean checkSearchResult(String arg) {
		return searchResult.getText().contains(arg);
	}
	
	
}
