package org.example.Herokuapp;

import org.example.Pages.Herokuapp.TestLoginPage;
import org.example.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HerokuappTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new WebDriverFactory().createBrowserDriver();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void Test_1() { //Test Authentication Fail
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("temp-generic");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(!driver.findElements(By.xpath("//div[@class='flash error']")).isEmpty());
    }

    @Test
    public void Test_2() { //Test Authentication Pass
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(driver.findElements(By.xpath("//div[@class='flash error']")).isEmpty());
    }

    @Test
    public void Test_3() { //Test Login Success
        driver.get("https://the-internet.herokuapp.com/login");
        TestLoginPage loginPage = new TestLoginPage(driver);

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getLoginSuccessMsg().isDisplayed());
    }
}
