package org.example.AutomationExercisePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AutomationExerciseHomePage extends AbstractPage {
    //xPaths
    static final String HOME = "//a[@href='/' and contains(text(),'Home')]";
    static final String PRODUCTS = "//a[@href='/products']";
    static final String CART = "//a[@href='/view_cart']";
    static final String SIGNUP_LOGIN = "//a[@href='/login']";

    //WebElements
    @FindBy(how = How.XPATH, using = HOME)
    WebElement homeNavItem;
    @FindBy(how = How.XPATH, using = PRODUCTS)
    WebElement productNavItem;
    @FindBy(how = How.XPATH, using = CART)
    WebElement cartNavItem;
    @FindBy(how = How.XPATH, using = SIGNUP_LOGIN)
    WebElement signUpLoginNavItem;

    public AutomationExerciseHomePage(WebDriver driver) {
        super(driver);
    }

    //TODO: Model other pages and make them return the new page instead of having them be void methods
    public void clickHomeNavigationItem() {
        homeNavItem.click();
    }

    public ProductsPage clickProductNavigationItem() {
        productNavItem.click();
        return new ProductsPage(driver);
    }

    public void clickCartNavigationItem() {
        cartNavItem.click();
    }

    public SignUpLoginPage clickSignUpLoginNavigationItem() {
        signUpLoginNavItem.click();
        return new SignUpLoginPage(driver);
    }

}
