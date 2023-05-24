package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.SwagLabsPage.PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CucumberSteps {
    protected WebDriver driver;

    @Given("(the user )opens the browser")
    public void openBrowser() {
        driver = new EdgeDriver();
    }

    @Given("the user navigates to {string}")
    public void theUserNavigatesTo(String string) {
        driver.get(string);
    }

    @Given("the user navigates to <website>")
    public void theUserNavigatesToWebsite(String website) {
        theUserNavigatesTo(website);
    }

    @When("the user logs in with {string} {string}")
    public void theUserLogsInWith(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill(username, password);
        loginPage.clickLoginButton();
    }

    @When("the user logs in with <username> <password>")
    public void theUserLogsInWithUsernamePassword(String username, String password) {
        theUserLogsInWith(username, password);
    }

    @Then("the user should successfully log in")
    public void theUserShouldSuccessfullyLogIn() { //Can't import assertions for some reason
        driver.findElement(By.xpath("//span[@class='title' and contains(text(),'Products')]")).isDisplayed();
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {
        driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed();
    }

    @Then("(the user )closes the browser")
    public void closeBrowser() {
        driver.quit();
    }

}
