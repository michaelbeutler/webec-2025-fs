package com.fhnw.webec.converter.e2e.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// variant using the @FindBy annotation
public class ConverterPage2 {

	private final WebDriver driver;

	@FindBy(name = "feet")
	private WebElement feetInput;

	@FindBy(name = "inches")
	private WebElement inchesInput;

	@FindBy(css = "input[type=submit]")
	private WebElement convertButton;

	@FindBy(css = "[data-test-id=result]")
	private WebElement resultText;

	public ConverterPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void typeFeet(Integer feet) {
		feetInput.sendKeys(feet.toString());
	}

	public void typeInches(Integer inches) {
		inchesInput.sendKeys(inches.toString());
	}

	public void clickConvert() {
		convertButton.click();
	}

	public String getResult() {
		return resultText.getText();
	}

}
