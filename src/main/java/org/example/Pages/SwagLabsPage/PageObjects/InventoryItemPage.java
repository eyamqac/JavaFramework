package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.SwagLabsPage.Components.TopNavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryItemPage extends TopNavBar {
    //xPaths
    static final String BACK_BUTTON = "//button[@id='back-to-products']";
    static final String ADD_TO_CART_BUTTON = "//button[contains(text(),'Add to cart')]";
    static final String REMOVE_BUTTON = "//button[contains(text(),'Remove')]";

    //WebElement
    @FindBy(how = How.XPATH, using = BACK_BUTTON)
    WebElement backButton;

    @FindBy(how = How.XPATH, using = ADD_TO_CART_BUTTON)
    WebElement addToCartButton;

    @FindBy(how = How.XPATH, using = REMOVE_BUTTON)
    WebElement removeButton;

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        this.addToCartButton.click();
        super.setLogMessage("Clicked Add Item To Cart");
    }

    public void clickRemoveFromCart() {
        this.removeButton.click();
    }

    public InventoryPage clickBackButton() {
        this.backButton.click();
        return new InventoryPage(driver);
    }

    public WebElement getAddButton() {
        return addToCartButton;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }
}
