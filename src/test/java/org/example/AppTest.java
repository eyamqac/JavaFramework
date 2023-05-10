package org.example;

import org.example.Pages.AutomationExercisePractice.PageObjects.*;
import org.example.Pages.Practice.PageObjects.GoogleHomePage;
import org.example.Pages.Practice.PageObjects.GoogleResultPage;
import org.example.Pages.SwagLabsPage.PageObjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        /*
         * Note that Selenium uses implicit waits by default after every action/command in Selenium
         * Given that Selenium cannot find the element, it will wait the entire duration trying
         * to locate the element which may substantially increase the time of the test
         */
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Adjust implicit wait timeout

        EdgeOptions options = new EdgeOptions();
        options.addExtensions(new File("./bin/1.49.2_0.crx"));
        driver = new EdgeDriver(options);
//        driver = new EdgeDriver();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void RunMyTest() {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Steve Jobs");
        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();

        assertTrue(driver.findElements(By.xpath("//input[@class='gNO89b']")).isEmpty()); //verify search button no longer visible after clicked
    }

    @Test
    public void Test_3() { //Test Authentication Fail
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("temp-generic");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(!driver.findElements(By.xpath("//div[@class='flash error']")).isEmpty());
    }

    @Test
    public void Test_3_5() { //Test Authentication Pass
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(driver.findElements(By.xpath("//div[@class='flash error']")).isEmpty());
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
    public void Test_6() { //Failed Login
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
    public void Test_7() { //Successful Signup
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
    public void Test_8() { //Purchase an Item
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

        OrderPlacedPage orderPlacedPage = paymentPage.clickPayConfirmOrderButton();
        assertTrue(orderPlacedPage.orderPlacedMessageDisplayed());

        homePage = orderPlacedPage.clickContinueButton();
    }

    @Test
    public void Test_9() { //Successful Login
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();

        assertTrue(!loginPage.loginErrorDisplayed());
    }

    @Test
    public void Test_10() { //Failed Login
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "invalidpassword");
        loginPage.clickLoginButton();

        assertTrue(loginPage.loginErrorDisplayed());
    }

    @Test
    public void Test_11() {//Purchase Item
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertTrue(inventoryPage.isInventoryTitleDisplayed());

        InventoryItemPage inventoryItemPage = inventoryPage.clickProduct1();
        assertTrue(inventoryItemPage.getAddButton().isDisplayed());
        inventoryItemPage.clickAddToCart();
        assertTrue(inventoryItemPage.getRemoveButton().isDisplayed());

        YourCartPage yourCartPage = inventoryItemPage.clickShoppingCartButton();
        assertTrue(yourCartPage.isShoppingCartTitleDisplayed());

        CheckoutPage checkoutPage = yourCartPage.clickCheckoutButton();
        assertTrue(checkoutPage.isCheckoutTitleDisplayed());
        checkoutPage.fill("temp", "generic", "12345");

        CheckoutOverViewPage overViewPage = checkoutPage.clickContinueButton();
        assertTrue(overViewPage.isCheckoutOverViewTitleDisplayed());

        PostCheckoutPage postCheckoutPage = overViewPage.clickFinishButton();
        assertTrue(postCheckoutPage.isSuccessMessageDisplayed());

        inventoryPage = postCheckoutPage.clickBackHomeButton();
        assertTrue(inventoryPage.isInventoryTitleDisplayed());

        inventoryPage.openSideBar();
        loginPage = inventoryPage.clickSideMenuLogout();
    }

    @Test
    public void Test_12() { //Filter Select
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        inventoryPage.selectFilter(2);
    }

    @Test
    public void Test_13() { //Go to About page
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        inventoryPage.openSideBar();
        AboutPage aboutPage = inventoryPage.clickSideMenuAbout();
        assertTrue(aboutPage.isAboutTitleDisplayed());
    }

    @Test
    public void Test_14() { //Add item to cart, then remove item from cart
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        InventoryItemPage inventoryItemPage = inventoryPage.clickProduct1();
        inventoryItemPage.clickAddToCart();
        inventoryItemPage.clickRemoveFromCart();
        inventoryItemPage.clickBackButton();
        assertTrue(inventoryPage.isInventoryTitleDisplayed());

        inventoryItemPage = inventoryPage.clickProduct2();
        inventoryItemPage.clickAddToCart();
        inventoryItemPage.clickRemoveFromCart();
        inventoryItemPage.clickBackButton();
        assertTrue(inventoryPage.isInventoryTitleDisplayed());
    }
}
