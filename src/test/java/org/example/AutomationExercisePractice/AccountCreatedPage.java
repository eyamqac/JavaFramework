package org.example.AutomationExercisePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * When this page is reached, the account was successfully created.
 */

public class AccountCreatedPage extends AbstractPage {
    //xPaths
    static final String SUCCESS_MESSAGE = "//b[contains(text(),'Account Created!')]";
    static final String CONTINUE_BUTTON = "//a[@data-qa='continue-button']";

    //WebElements
    @FindBy(how = How.XPATH, using = SUCCESS_MESSAGE)
    WebElement successMsg;

    @FindBy(how = How.XPATH, using = CONTINUE_BUTTON)
    WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return successMsg.isDisplayed();
    }

    public AutomationExerciseHomePage clickContinueButton() {
        continueButton.click();
        return new AutomationExerciseHomePage(driver);
    }
}
