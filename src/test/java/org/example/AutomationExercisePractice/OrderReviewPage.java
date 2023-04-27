package org.example.AutomationExercisePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderReviewPage extends AbstractPage {
    //xPath
    static final String PLACE_ORDER_BUTTON = "//a[@href='/payment']";
    static final String COMMENT_SECTION = "//textarea[@class='form-control']";

    //WebElements
    @FindBy(how = How.XPATH, using = PLACE_ORDER_BUTTON)
    WebElement placeOrderButton;

    @FindBy(how = How.XPATH, using = COMMENT_SECTION)
    WebElement commentSection;

    public OrderReviewPage(WebDriver driver) {
        super(driver);
    }

    public void enterComments(String text) {
        commentSection.sendKeys(text);
    }

    public PaymentPage clickPlaceOrder() {
        placeOrderButton.click();
        return new PaymentPage(driver);
    }
}
