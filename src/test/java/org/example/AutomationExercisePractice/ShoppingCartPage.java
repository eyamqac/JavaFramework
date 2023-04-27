package org.example.AutomationExercisePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends AbstractPage {
    //xPath
    static final String CHECKOUT_BUTTON = "//a[@class='btn btn-default check_out' and contains(text(),'Proceed To Checkout')]";

    //WebElements
    @FindBy(how = How.XPATH, using = CHECKOUT_BUTTON)
    WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public OrderReviewPage clickCheckoutButton() {
        checkoutButton.click();
        return new OrderReviewPage(driver);
    }
}
