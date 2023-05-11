package org.example.SwagLabs;

import org.example.Pages.SwagLabsPage.PageObjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsTest {
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
    public void Test_1() { //Successful Login
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();

        assertTrue(!loginPage.loginErrorDisplayed());
    }

    @Test
    public void Test_2() { //Failed Login
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "invalidpassword");
        loginPage.clickLoginButton();

        assertTrue(loginPage.loginErrorDisplayed());
    }

    @Test
    public void Test_3() {//Purchase Item
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
    public void Test_4() { //Filter Select
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        inventoryPage.selectFilter(2);
    }

    @Test
    public void Test_5() { //Go to About page
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill("standard_user", "secret_sauce");

        InventoryPage inventoryPage = loginPage.clickLoginButton();
        inventoryPage.openSideBar();
        AboutPage aboutPage = inventoryPage.clickSideMenuAbout();
        assertTrue(aboutPage.isAboutTitleDisplayed());
    }

    @Test
    public void Test_6() { //Add item to cart, then remove item from cart
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
