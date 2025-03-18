package com.fhnw.webec.converter.e2e.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConverterPage {

	private final WebDriver driver;

	public ConverterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeFeet(Integer feet) {
		driver.findElement(By.name("feet")).sendKeys(feet.toString());
	}

	public void typeInches(Integer inches) {
		driver.findElement(By.name("inches")).sendKeys(inches.toString());
	}

	public void clickConvert() {
		driver.findElement(By.cssSelector("input[type=submit]")).click();
	}

	public String getResult() {
		return driver.findElement(By.cssSelector("[data-test-id=result]")).getText();
	}

}
