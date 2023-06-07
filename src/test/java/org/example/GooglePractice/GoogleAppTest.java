package org.example.GooglePractice;

import org.example.Pages.GooglePractice.PageObjects.GoogleHomePage;
import org.example.Pages.GooglePractice.PageObjects.GoogleResultPage;
import org.example.Factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleAppTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        /*
         * Note that Selenium uses implicit waits by default after every action/command in Selenium
         * Given that Selenium cannot find the element, it will wait the entire duration trying
         * to locate the element which may substantially increase the time of the test
         */
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Adjust implicit wait timeout
//        driver = new EdgeDriver();
        driver = new WebDriverFactory().createBrowserDriver();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void Test_1() {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Steve Jobs");
        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();

        assertTrue(driver.findElements(By.xpath("//input[@class='gNO89b']")).isEmpty()); //verify search button no longer visible after clicked
    }

    @Test
    public void Test_2() {
        //Note that since driver holds the context of the web browser(where we are in the website)
        //ensure the state of the driver has been set before passing it into the next page object to be created
        //that will use the driver
        driver.get("https://www.google.ca");
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);

        googleHomePage.enterTextSearchBar("How To Code");
        GoogleResultPage searchResult = googleHomePage.clickSearchButton().clickSearchResult(1);
    }
}
