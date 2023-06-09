package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductItemPage extends AbstractPage {
    //xPaths
    static final String ADD_TO_CART_BUTTON = "//button[@type='button' and text()[contains(.,'Add to cart')]]";
    static final String VIEW_CART = "//a[@href='/view_cart']//child::u";

    //WebElements
    @FindBy(how = How.XPATH, using = ADD_TO_CART_BUTTON)
    WebElement addToCartButton;

    @FindBy(how = How.XPATH, using = VIEW_CART)
    WebElement viewCart;

    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage clickAddToCart() {
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(viewCart));
        viewCart.click();

        return new ShoppingCartPage(driver);
    }
}
