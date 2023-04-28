package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * When this page is reached, the account was successfully deleted.
 */

public class AccountDeletedPage extends AbstractPage {
    //xPaths
    static final String ACCOUNT_DELETED_MESSAGE = "//b[contains(text(),'Account Deleted!')]";
    static final String CONTINUE_BUTTON = "//a[@data-qa='continue-button']";

    //WebElements
    @FindBy(how = How.XPATH, using = ACCOUNT_DELETED_MESSAGE)
    WebElement accountDeletedMsg;

    @FindBy(how = How.XPATH, using = CONTINUE_BUTTON)
    WebElement continueButton;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedMessageDisplayed() {
        return super.isElementDisplayed(driver, ACCOUNT_DELETED_MESSAGE);
    }

    public AutomationExerciseHomePage clickContinueButton() {
        continueButton.click();
        return new AutomationExerciseHomePage(driver);
    }
}
