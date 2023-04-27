package org.example.AutomationExercisePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpLoginPage extends AbstractPage {
    //xPaths
    static final String LOGIN_EMAIL = "//input[@data-qa='login-email']";
    static final String LOGIN_PASSWORD = "//input[@data-qa='login-password']";
    static final String LOGIN_BUTTON = "//button[@data-qa='login-button']";
    static final String LOGIN_ERROR_MESSAGE = "//p[@style='color: red;' and contains(text(),'Your email or password is incorrect!')]";
    static final String SIGNUP_NAME = "//input[@data-qa='signup-name']";
    static final String SIGNUP_EMAIL_ADDRESS = "//input[@data-qa='signup-email']";
    static final String SIGNUP_BUTTON = "//button[@data-qa='signup-button']";
    static final String SIGNUP_ERROR_MESSAGE = "//p[@style='color: red;' and contains(text(),'Email Address already exist!')]";


    //WebElements
    @FindBy(how = How.XPATH, using = LOGIN_EMAIL)
    WebElement loginEmail;

    @FindBy(how = How.XPATH, using = LOGIN_PASSWORD)
    WebElement loginPassword;

    @FindBy(how = How.XPATH, using = LOGIN_BUTTON)
    WebElement loginButton;

    @FindBy(how = How.XPATH, using = LOGIN_ERROR_MESSAGE)
    WebElement loginErrorMessage;

    @FindBy(how = How.XPATH, using = SIGNUP_NAME)
    WebElement signUpName;

    @FindBy(how = How.XPATH, using = SIGNUP_EMAIL_ADDRESS)
    WebElement signUpEmailAddress;

    @FindBy(how = How.XPATH, using = SIGNUP_BUTTON)
    WebElement signUpButton;

    @FindBy(how = How.XPATH, using = SIGNUP_ERROR_MESSAGE)
    WebElement signUpErrorMessage;

    public SignUpLoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginEmailAddress(String text) {
        loginEmail.sendKeys(text);
    }

    public void enterLoginPassword(String text) {
        loginPassword.sendKeys(text);
    }

    public void enterSignUpName(String text) {
        signUpName.sendKeys(text);
    }

    public void enterSignUpEmailAddress(String text) {
        signUpEmailAddress.sendKeys(text);
    }

    public boolean loginErrorMessageDisplayed() {
        return loginErrorMessage.isDisplayed();
    }

    public boolean signUpErrorMessageDisplayed() {
        return signUpErrorMessage.isDisplayed();
    }

    //This method is supposed to redirect back to home page only
    //when authentication is successful. Displays failure message
    //when login is invalid.
    public AutomationExerciseHomePage clickLoginButton() {
        loginButton.click();
        return new AutomationExerciseHomePage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }
}
