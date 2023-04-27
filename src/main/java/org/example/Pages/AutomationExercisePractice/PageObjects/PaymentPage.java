package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage extends AbstractPage {
    //xPaths
    static final String NAME_ON_CARD = "//input[@data-qa='name-on-card']";
    static final String CARD_NUMBER = "//input[@data-qa='card-number']";
    static final String CVC = "//input[@data-qa='cvc']";
    static final String EXPIRATION_MONTH = "//input[@data-qa='expiry-month']";
    static final String EXPIRATION_YEAR = "//input[@data-qa='expiry-year']";

    //WebElements
    @FindBy(how = How.XPATH, using = NAME_ON_CARD)
    WebElement nameOnCard;

    @FindBy(how = How.XPATH, using = CARD_NUMBER)
    WebElement cardNumber;

    @FindBy(how = How.XPATH, using = CVC)
    WebElement cvc;

    @FindBy(how = How.XPATH, using = EXPIRATION_MONTH)
    WebElement expirationMonth;

    @FindBy(how = How.XPATH, using = EXPIRATION_YEAR)
    WebElement expirationYear;


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void enterNameOnCard(String text) {
        nameOnCard.sendKeys(text);
    }

    public void enterCardNumber(String text) {
        cardNumber.sendKeys(text);
    }

    public void enterCVC(String text) {
        cvc.sendKeys(text);
    }

    public void enterExpirationMonth(String text) {
        expirationMonth.sendKeys(text);
    }

    public void enterExpirationYear(String text) {
        expirationYear.sendKeys(text);
    }
}
