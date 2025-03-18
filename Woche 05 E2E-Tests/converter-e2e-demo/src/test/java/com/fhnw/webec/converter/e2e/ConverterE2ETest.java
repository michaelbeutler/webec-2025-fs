package com.fhnw.webec.converter.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterE2ETest {

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
		driver.get("http://localhost:8080/convert");

		driver.findElement(By.name("feet")).sendKeys("5");
		driver.findElement(By.name("inches")).sendKeys("2");
		driver.findElement(By.cssSelector("input[type=submit]")).click();

		var result = driver.findElement(By.cssSelector("[data-test-id=result]")).getText();

		assertEquals("157 cm, 5 mm", result);
	}

}
