package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.SwagLabsPage.Components.TopNavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutOverViewPage extends TopNavBar {
    //xPaths
    static final String TITLE = "//span[@class='title' and contains(text(),'Checkout: Overview')]";
    static final String CANCEL_BUTTON = "//button[@id='cancel']";
    static final String FINISH_BUTTON = "//button[@id='finish']";

    //WebElements
    @FindBy(how = How.XPATH, using = TITLE)
    WebElement title;

    @FindBy(how = How.XPATH, using = CANCEL_BUTTON)
    WebElement cancelButton;

    @FindBy(how = How.XPATH, using = FINISH_BUTTON)
    WebElement finishButton;


    public CheckoutOverViewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutOverViewTitleDisplayed() {
        return super.isElementDisplayed(By.xpath(TITLE));
    }

    public InventoryPage clickCancelButton() {
        this.cancelButton.click();
        super.setLogMessage("Click Cancel Button");
        return new InventoryPage(driver);
    }

    public PostCheckoutPage clickFinishButton() {
        this.finishButton.click();
        super.setLogMessage("Click Finish Button");
        return new PostCheckoutPage(driver);
    }
}
