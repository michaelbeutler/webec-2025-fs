package com.fhnw.webec.converter.e2e;

import com.fhnw.webec.converter.e2e.page.ConverterPage2;
import com.fhnw.webec.converter.e2e.page.NavigationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterWithPageObjects2E2ETest {

	WebDriver driver;

	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setupTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// see section on implicit waits: https://www.selenium.dev/documentation/webdriver/waits/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterEach
	void teardown() {
		driver.quit();
	}

	@Test
	public void ConvertImperialToMetric() {
		var navigationPage = new NavigationPage(driver);
		var converterPage = new ConverterPage2(driver);

		navigationPage.goToConverter();

		converterPage.typeFeet(5);
		converterPage.typeInches(2);
		converterPage.clickConvert();

		assertEquals("157 cm, 5 mm", converterPage.getResult());
	}

}
