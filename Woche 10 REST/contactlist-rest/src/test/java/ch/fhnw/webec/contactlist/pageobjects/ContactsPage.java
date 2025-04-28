package ch.fhnw.webec.contactlist.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsPage {

    private WebDriver driver;

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getContactEntries() {
        return driver.findElements(By.cssSelector("[data-test-id=contact-entry]"));
    }

    public WebElement getContactFirstName() {
        return driver.findElement(By.cssSelector("[data-test-id=firstName]"));
    }

    public WebElement getContactLastName() {
        return driver.findElement(By.cssSelector("[data-test-id=lastName]"));
    }

    public WebElement getSearchQuery() {
        return driver.findElement(By.cssSelector("[data-test-id=search-query]"));
    }

    public WebElement getSearchSubmit() {
        return driver.findElement(By.cssSelector("[data-test-id=search-submit]"));
    }

    public WebElement getSearchReset() {
        return driver.findElement(By.cssSelector("[data-test-id=search-reset]"));
    }

    public WebElement getNoResultsMessage() {
        return driver.findElement(By.cssSelector("[data-test-id=no-results]"));
    }

}
