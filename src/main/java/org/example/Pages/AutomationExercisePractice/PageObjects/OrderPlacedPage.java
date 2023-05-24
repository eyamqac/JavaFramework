package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * When this page is reached, the order was successfully placed
 */

public class OrderPlacedPage extends AbstractPage {
    //xPaths
    static final String ORDER_PLACED_MSG = "//b[contains(text(),'Order Placed!')]";
    static final String CONTINUE_BUTTON = "//a[@data-qa='continue-button']";
    static final String DOWNLOAD_INVOICE_BUTTON = "//a[@href='/download_invoice/8000']";

    //WebElements
    @FindBy(how = How.XPATH, using = ORDER_PLACED_MSG)
    WebElement orderPlacedMsg;

    @FindBy(how = How.XPATH, using = CONTINUE_BUTTON)
    WebElement continueButton;

    @FindBy(how = How.XPATH, using = DOWNLOAD_INVOICE_BUTTON)
    WebElement downloadInvoiceButton;

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    //Unsure what this does
    public void clickDownloadInvoiceButton() {
        downloadInvoiceButton.click();
    }

    public AutomationExerciseHomePage clickContinueButton() {
        continueButton.click();
        return new AutomationExerciseHomePage(driver);
    }

    public boolean orderPlacedMessageDisplayed() {
        return super.isElementDisplayed(By.xpath(ORDER_PLACED_MSG));
    }
}
