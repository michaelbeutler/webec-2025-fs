package ch.fhnw.webec.contactlist.e2e.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactsPage {

	private WebDriver driver;
	private int port;

	public ContactsPage(WebDriver driver, int port) {
		this.driver = driver;
		this.port = port;
	}

	public void goToContacts() {
		driver.get("http://localhost:" + port + "/contacts");
	}

	public void typeSearchQuery(String query) {
		getSearchQuery().sendKeys(query);
	}

	public void assertSearchQuery(String expected) {
		assertEquals(expected, getSearchQuery().getAttribute("value"));
	}

	public void clickSearchButton() {
		driver.findElement(By.cssSelector("[data-test-id=search-submit]")).click();
	}

	public void assertNumberOfSearchResults(int expected) {
		assertEquals(expected, driver.findElements(By.cssSelector("[data-test-id=contact-entry]")).size());
	}

	public void resetSearch() {
		driver.findElement(By.cssSelector("[data-test-id=search-reset]")).click();
	}

	public void clickFirstContact() {
		driver.findElements(By.cssSelector("[data-test-id=contact-entry]")).getFirst().click();
	}

	public void assertContactDetails(String expected) {
		assertEquals(expected, driver.findElement(By.cssSelector("[data-test-id=contact-details]")).getText());
	}

	public void assertResetButtonIsShown() {
		assertTrue(driver.findElement(By.cssSelector("[data-test-id=search-reset]")).isDisplayed());
	}

	public void assertNoResultsMessageIsShown() {
		assertTrue(driver.findElement(By.cssSelector("[data-test-id=no-results]")).isDisplayed());
	}

	private WebElement getSearchQuery() {
		return driver.findElement(By.cssSelector("[data-test-id=search-query]"));
	}
}
