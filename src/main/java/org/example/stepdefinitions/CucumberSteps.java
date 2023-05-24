package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.SwagLabsPage.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CucumberSteps {
    protected WebDriver driver;

    @Given("the browser is open")
    public void openBrowser() {
        driver = new EdgeDriver();
    }

    @Given("the website {string} is open")
    public void theUserNavigatesTo(String string) {
        driver.get(string);
    }

    @Given("the website <website> is open")
    public void theUserNavigatesToWebsite(String website) {
        theUserNavigatesTo(website);
    }

    @When("the user logs in with {string} {string}")
    public void theUserLogsInWith(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill(username, password);
        loginPage.clickLoginButton();
    }

    @And("the user checks out an item with their information {string} {string} {string}")
    public void theUserChecksOutAnItemWithTheirInformation(String firstName, String lastName, String zipCode) {
        InventoryPage inventoryPage = new InventoryPage(driver);
        InventoryItemPage itemPage = inventoryPage.clickProduct1();
        itemPage.clickAddToCart();
        YourCartPage yourCartPage = itemPage.clickShoppingCartButton();
        CheckoutPage checkoutPage = yourCartPage.clickCheckoutButton();
        checkoutPage.fill(firstName, lastName, zipCode);
        CheckoutOverViewPage overViewPage = checkoutPage.clickContinueButton();
        overViewPage.clickFinishButton();
    }

    @When("the user logs in with <username> <password>")
    public void theUserLogsInWithUsernamePassword(String username, String password) {
        theUserLogsInWith(username, password);
    }

    @Then("the user should successfully log in")
    public void theUserShouldSuccessfullyLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(!loginPage.loginErrorDisplayed());
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.loginErrorDisplayed());
    }

    @Then("(the user )closes the browser")
    public void closeBrowser() {
        driver.quit();
    }

    @Then("the user's purchase was successful")
    public void theUserSPurchaseWasSuccessful() {
        PostCheckoutPage postCheckoutPage = new PostCheckoutPage(driver);
        assertTrue(postCheckoutPage.isSuccessMessageDisplayed());
    }

    @And("the user navigates to the about page")
    public void theUserNavigatesToTheAboutPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openSideBar();
        AboutPage aboutPage = inventoryPage.clickSideMenuAbout();
    }
}
