package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends AbstractPage {
    //xPaths
    static final String USERNAME = "//input[@id='user-name']";
    static final String PASSWORD = "//input[@id='password']";
    static final String LOGIN_BUTTON = "//input[@id='login-button']";
    static final String LOGIN_ERROR_MESSAGE = "//div[@class='error-message-container error']";

    //WebElements
    @FindBy(how = How.XPATH, using = USERNAME)
    WebElement username;

    @FindBy(how = How.XPATH, using = PASSWORD)
    WebElement password;

    @FindBy(how = How.XPATH, using = LOGIN_BUTTON)
    WebElement loginButton;

    @FindBy(how = How.XPATH, using = LOGIN_ERROR_MESSAGE)
    WebElement loginErrorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fill(String username, String password) {
        this.enterUserName(username);
        this.enterPassword(password);
    }

    public void enterUserName(String text) {
        this.username.sendKeys(text);
    }

    public void enterPassword(String text) {
        this.password.sendKeys(text);
    }

    public boolean loginErrorDisplayed() {
        return super.isElementDisplayed(driver, LOGIN_ERROR_MESSAGE);
    }

    public InventoryPage clickLoginButton() {
        this.loginButton.click();
        return new InventoryPage(driver);
    }
}
