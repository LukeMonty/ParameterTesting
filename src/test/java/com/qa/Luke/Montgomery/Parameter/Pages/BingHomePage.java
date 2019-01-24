package com.qa.Luke.Montgomery.Parameter.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingHomePage {

	@FindBy(id = "sb_form_q")
	private WebElement searchInput;

	public void inputSearchParameters(String arg1) {
		searchInput.sendKeys(arg1, Keys.ENTER);
	}

}
