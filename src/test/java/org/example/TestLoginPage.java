package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLoginPage {

    //Attributes
    private WebDriver driver;
    private WebElement userNameTextBox;
    private WebElement passwordTextBox;
    private WebElement loginButton;
    private WebElement logoutButton;
    private WebElement loginSuccessMsg;
    private WebElement loginFailureMsg;

    //Constructor
    public TestLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Mutator methods
    public void enterUserName(String username) {
        this.getUserNameTextBox().sendKeys(username);
    }

    public void enterPassword(String password) {
        this.getPasswordTextBox().sendKeys(password);
    }

    public void clickLoginButton() {
        this.getLoginButton().click();
    }

    public void clickLogOutButton() {
        this.getLogoutButton().click();
    }

    //Accessor methods
    public WebElement getUserNameTextBox() {
        this.userNameTextBox = this.driver.findElement(By.xpath("//input[@id='username']"));
        return userNameTextBox;
    }

    public WebElement getPasswordTextBox() {
        this.passwordTextBox = this.driver.findElement(By.xpath("//input[@id='password']"));
        return passwordTextBox;
    }

    public WebElement getLoginButton() {
        this.loginButton = this.driver.findElement(By.xpath("//button[@type='submit']"));
        return loginButton;
    }

    public WebElement getLogoutButton() {
        this.logoutButton = this.driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        return logoutButton;
    }

    public WebElement getLoginFailureMsg() {
        this.loginFailureMsg = this.driver.findElement(By.xpath("//div[@class='flash error']"));
        return loginFailureMsg;
    }

    public WebElement getLoginSuccessMsg() {
        this.loginSuccessMsg = this.driver.findElement(By.xpath("//div[@class='flash success']"));
        return loginSuccessMsg;
    }
}
