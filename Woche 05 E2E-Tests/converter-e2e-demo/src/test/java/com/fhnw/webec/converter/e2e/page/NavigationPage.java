package com.fhnw.webec.converter.e2e.page;

import org.openqa.selenium.WebDriver;

public class NavigationPage {

	private final WebDriver driver;

	public NavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToConverter() {
		driver.get("http://localhost:8080/convert");
	}

}
