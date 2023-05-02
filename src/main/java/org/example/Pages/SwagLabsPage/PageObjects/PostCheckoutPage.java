package org.example.Pages.SwagLabsPage.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * When this page is reached, the item(s) were successfully checked out.
 */

public class PostCheckoutPage extends TopNavBar {
    //xPaths
    static final String SUCCESS_MESSAGE = "//h2[contains(text(),'Thank you for your order!')]";
    static final String BACK_HOME_BUTTON = "//button[@id='back-to-products']";

    //WebElements
    @FindBy(how = How.XPATH, using = SUCCESS_MESSAGE)
    WebElement successMsg;

    @FindBy(how = How.XPATH, using = BACK_HOME_BUTTON)
    WebElement backHomeButton;

    public PostCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return super.isElementDisplayed(driver, SUCCESS_MESSAGE);
    }

    public InventoryPage clickBackHomeButton() {
        this.backHomeButton.click();
        return new InventoryPage(driver);
    }
}
