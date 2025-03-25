package ch.fhnw.webec.contactlist.e2e;

import ch.fhnw.webec.contactlist.e2e.page.ContactsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ContactListIT {

    @LocalServerPort
    int port;

    WebDriver driver;

    private ContactsPage contactsPage;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // see section on implicit waits: https://www.selenium.dev/documentation/webdriver/waits/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        contactsPage = new ContactsPage(driver, port);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testContactListAndDetails() {
        contactsPage.goToContacts();
        contactsPage.assertNumberOfSearchResults(30);

        contactsPage.clickFirstContact();
		contactsPage.assertContactDetails("""
			First name Mabel
			Last name Guppy
			Phone numbers
			405-580-6403""");
    }

    @Test
    public void testSearch() {
        contactsPage.goToContacts();

        // search "cat" -> 2 results are listed
        contactsPage.typeSearchQuery("cat" + Keys.RETURN); // submit using enter key
        contactsPage.assertResetButtonIsShown(); // make sure the search was executed before we assert the number of test results
											     // (otherwise it might fail because it finds 30 contacts)
        contactsPage.assertNumberOfSearchResults(2);

        // click first entry -> contact details are shown, search persists
        contactsPage.clickFirstContact();
        contactsPage.assertContactDetails("""
			First name Aileen
			Last name Cattrell
			Email addresses
			mstaves0@opensource.org
			vmash1@patch.com
			Phone numbers
			525-477-4251
			331-888-1254
			657-694-9841""");
        contactsPage.assertSearchQuery("cat");
        contactsPage.assertNumberOfSearchResults(2);

        // search something with 0 results -> message "no results" is shown
        contactsPage.resetSearch();
        contactsPage.typeSearchQuery("dog");
        contactsPage.clickSearchButton(); // this time use button instead of enter
		contactsPage.assertNoResultsMessageIsShown();

		// don't do this with implicit wait enabled, it slows the test down (instead assert the no results message is shown)
        // contactsPage.assertNumberOfSearchResults(0);

        // reset -> everything is shown
        contactsPage.resetSearch();
		contactsPage.assertSearchQuery(""); // wait for this to make sure the page was reloaded
        contactsPage.assertNumberOfSearchResults(30);
    }
}
