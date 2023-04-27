package org.example;

import org.example.AutomationExercisePractice.*;
import org.example.Practice.GoogleResultPage;
import org.example.Practice.GoogleHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new EdgeDriver();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void RunMyTest() throws InterruptedException {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Steve Jobs");
        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();

        assertTrue(driver.findElements(By.xpath("//input[@class='gNO89b']")).isEmpty()); //verify search button no longer visible after clicked
        Thread.sleep(10000);
    }

    @Test
    public void Test_3() throws InterruptedException { //Test Authentication Fail
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("temp-generic");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(!driver.findElements(By.xpath("//div[@class='flash error']")).isEmpty());
        Thread.sleep(10000);
    }

    @Test
    public void Test_3_5() throws InterruptedException { //Test Authentication Pass
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(driver.findElements(By.xpath("//div[@class='flash success']")).isEmpty());
        Thread.sleep(10000);
    }

    @Test
    public void Test_4() {
        driver.get("https://the-internet.herokuapp.com/login");
        TestLoginPage loginPage = new TestLoginPage(driver);

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getLoginSuccessMsg().isDisplayed());
    }

    @Test
    public void Test_5() {
        //Note that since driver holds the context of the web browser(where we are in the website)
        //ensure the state of the driver has been set before passing it into the next page object to be created
        //that will use the driver
        driver.get("https://www.google.ca");
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);

        googleHomePage.enterTextSearchBar("How To Code");
        GoogleResultPage searchResult = googleHomePage.clickSearchButton().clickSearchResult(1);
    }

    @Test
    public void Test_6() throws InterruptedException { //Failed Login
        driver.get("https://www.automationexercise.com/");
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(driver);

        SignUpLoginPage loginPage = homePage.clickSignUpLoginNavigationItem();
        //Incorrect credentials
        loginPage.enterLoginPassword("tempgeneric");
        loginPage.enterLoginEmailAddress("tempgeneric@hotmail.com");
        loginPage.clickLoginButton();
        assertTrue(loginPage.loginErrorMessageDisplayed());

        Thread.sleep(5000);
    }

    @Test
    public void Test_7() throws InterruptedException { //Successful Signup
        driver.get("https://www.automationexercise.com/");
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(driver);

        SignUpLoginPage loginPage = homePage.clickSignUpLoginNavigationItem();
        loginPage.enterSignUpName("temporarygeneric");
        loginPage.enterSignUpEmailAddress("temporarygeneric4@hotmail.com");

        SignUpPage signUpPage = loginPage.clickSignUpButton();
        signUpPage.selectTitleOption1();
        signUpPage.enterPassword("123456");
        signUpPage.selectDateOfBirth(20, 2, 2);
        signUpPage.enterFirstName("generic");
        signUpPage.enterLastname("generic");
        signUpPage.enterCompany("generic");
        signUpPage.enterAddress("generic");
        signUpPage.selectCountry(2);
        signUpPage.enterState("generic");
        signUpPage.enterCity("generic");
        signUpPage.enterZipCode("generic");
        signUpPage.enterMobileNumber("generic");

        AccountCreatedPage accountCreatedPage = signUpPage.clickCreateAccount();
        assertTrue(accountCreatedPage.isSuccessMessageDisplayed());

        homePage = accountCreatedPage.clickContinueButton();

        Thread.sleep(10000);
    }

    @Test
    public void Test_8() throws InterruptedException { //Purchase an Item
        driver.get("https://www.automationexercise.com/");
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(driver);
        SignUpLoginPage loginPage = homePage.clickSignUpLoginNavigationItem();

        loginPage.enterLoginEmailAddress("tempgeneric1@hotmail.com");
        loginPage.enterLoginPassword("123456");
        homePage = loginPage.clickLoginButton();

        ProductsPage productsPage = homePage.clickProductNavigationItem();
        ProductItemPage productItemPage = productsPage.clickItem();
        ShoppingCartPage shoppingCartPage = productItemPage.clickAddToCart();
        OrderReviewPage orderReviewPage = shoppingCartPage.clickCheckoutButton();
        PaymentPage paymentPage = orderReviewPage.clickPlaceOrder();
        paymentPage.enterNameOnCard("Generic");
        paymentPage.enterCardNumber("1234567");
        paymentPage.enterCVC("311");
        paymentPage.enterExpirationMonth("2");
        paymentPage.enterExpirationYear("2021");

        Thread.sleep(10000);
    }
}
