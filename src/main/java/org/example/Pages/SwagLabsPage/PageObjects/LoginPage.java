package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.By;
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
        super.setLogMessage("Enter Login Information");
        this.enterUserName(username);
        this.enterPassword(password);
    }

    public void enterUserName(String text) {
        super.setLogMessage("Enter Username");
        this.username.sendKeys(text);
    }

    public void enterPassword(String text) {
        super.setLogMessage("Enter Password");
        this.password.sendKeys(text);
    }

    public boolean loginErrorDisplayed() {
//        return super.isElementDisplayed(LOGIN_ERROR_MESSAGE);
        return super.isElementDisplayed(By.xpath(LOGIN_ERROR_MESSAGE));
    }

    public InventoryPage clickLoginButton() {
        super.setLogMessage("Click Login Button");
        this.loginButton.click();
        return new InventoryPage(driver);
    }
}
