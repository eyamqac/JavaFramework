package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.SwagLabsPage.Components.TopNavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends TopNavBar {
    //xPaths
    static final String TITLE = "//span[@class='title' and contains(text(),'Checkout: Your Information')]";
    static final String FIRST_NAME = "//input[@id='first-name']";
    static final String LAST_NAME = "//input[@id='last-name']";
    static final String ZIP_CODE = "//input[@id='postal-code']";
    static final String CANCEL_BUTTON = "//button[@id='cancel']";
    static final String CONTINUE_BUTTON = "//input[@id='continue']";

    //WebElement
    @FindBy(how = How.XPATH, using = TITLE)
    WebElement title;

    @FindBy(how = How.XPATH, using = FIRST_NAME)
    WebElement firstName;

    @FindBy(how = How.XPATH, using = LAST_NAME)
    WebElement lastName;

    @FindBy(how = How.XPATH, using = ZIP_CODE)
    WebElement zipCode;

    @FindBy(how = How.XPATH, using = CANCEL_BUTTON)
    WebElement cancelButton;

    @FindBy(how = How.XPATH, using = CONTINUE_BUTTON)
    WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fill(String firstName, String lastName, String zipCode) {
        this.enterFirstName(firstName);
        this.enterLastName(lastName);
        this.enterZipCode(zipCode);
        super.setLogMessage("Enter Personal Checkout Information");
    }

    public void enterFirstName(String text) {
        this.firstName.sendKeys(text);
    }

    public void enterLastName(String text) {
        this.lastName.sendKeys(text);
    }

    public void enterZipCode(String text) {
        this.zipCode.sendKeys(text);
    }

    public boolean isCheckoutTitleDisplayed() {
        return super.isElementDisplayed(TITLE);
    }

    public YourCartPage clickCancelButton() {
        this.cancelButton.click();
        return new YourCartPage(driver);
    }

    public CheckoutOverViewPage clickContinueButton() {
        this.continueButton.click();
        super.setLogMessage("Click Continue");
        return new CheckoutOverViewPage(driver);
    }
}
