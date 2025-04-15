package ch.fhnw.webec.wishlist.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
public class HomePageIT {

    @LocalServerPort
    int port;

    WebDriver driver;

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
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void containsWishlistLinks() {
        driver.navigate().to("http://localhost:" + port + "/");
        var urls = findWishlistUrls();
        assertEquals(3, urls.size());
    }

    @Test
    public void deleteButtonDeletesWishlist() {
        driver.navigate().to("http://localhost:" + port + "/");
        var deleteButtons = driver.findElements(By.cssSelector("button.delete"));
        assertEquals(3, deleteButtons.size());
        deleteButtons.get(0).click();
        assertEquals(2, findWishlistUrls().size());
    }

    private Set<String> findWishlistUrls() {
        var links = driver.findElements(By.tagName("a"));
        return links.stream()
                .map(e -> e.getAttribute("href"))
                .filter(url -> url.contains("/wishlist/"))
                .collect(toSet());
    }
}
