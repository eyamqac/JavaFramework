package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.SwagLabsPage.Components.TopNavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YourCartPage extends TopNavBar {
    //xPaths
    static final String TITLE = "//span[@class='title' and contains(text(),'Your Cart')]";
    static final String CONTINUE_SHOPPING_BUTTON = "//button[@id='continue-shopping']";
    static final String CHECKOUT_BUTTON = "//button[@id='checkout']";

    //WebElements
    @FindBy(how = How.XPATH, using = TITLE)
    WebElement title;

    @FindBy(how = How.XPATH, using = CONTINUE_SHOPPING_BUTTON)
    WebElement continueShoppingButton;

    @FindBy(how = How.XPATH, using = CHECKOUT_BUTTON)
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartTitleDisplayed() {
        return super.isElementDisplayed(TITLE);
    }

    public InventoryPage clickContinueShoppingButton() {
        this.continueShoppingButton.click();
        return new InventoryPage(driver);
    }

    public CheckoutPage clickCheckoutButton() {
        super.setLogMessage("Click Checkout Button");
        this.checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
