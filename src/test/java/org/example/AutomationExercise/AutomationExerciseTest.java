package org.example.AutomationExercise;

import org.example.Pages.AutomationExercisePractice.PageObjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomationExerciseTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        options.addExtensions(new File("./bin/1.49.2_0.crx")); //Used to remove popup ads within AutomationExercise page
        driver = new EdgeDriver(options);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void Test_1() { //Failed Login
        driver.get("https://www.automationexercise.com/");
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(driver);

        SignUpLoginPage loginPage = homePage.clickSignUpLoginNavigationItem();
        //Incorrect credentials
        loginPage.enterLoginPassword("tempgeneric");
        loginPage.enterLoginEmailAddress("tempgeneric@hotmail.com");
        loginPage.clickLoginButton();
        assertTrue(loginPage.loginErrorMessageDisplayed());
    }

    @Test
    public void Test_2() { //Successful Signup
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
        assertTrue(homePage.LoggedInAsDisplayed());

        //Delete Account afterwards so that we can keep re-using the same username for this test
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();
        homePage = accountDeletedPage.clickContinueButton();
        assertTrue(!homePage.LoggedInAsDisplayed());
    }

    @Test
    public void Test_3() { //Purchase an Item
        driver.get("https://www.automationexercise.com/");
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(driver);
        SignUpLoginPage loginPage = homePage.clickSignUpLoginNavigationItem();

        loginPage.enterLoginEmailAddress("tempgeneric1@hotmail.com");
        loginPage.enterLoginPassword("123456");
        homePage = loginPage.clickLoginButton();
        assertTrue(homePage.LoggedInAsDisplayed());

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

        OrderPlacedPage orderPlacedPage = paymentPage.clickPayConfirmOrderButton();
        assertTrue(orderPlacedPage.orderPlacedMessageDisplayed());

        homePage = orderPlacedPage.clickContinueButton();
    }
}
