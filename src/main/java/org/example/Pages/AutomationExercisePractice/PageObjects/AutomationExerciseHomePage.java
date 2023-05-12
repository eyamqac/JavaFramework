package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
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
    static final String LOGGED_IN_AS = "//a[contains(text(),'Logged in as')]";
    static final String DELETE_ACCOUNT = "//a[@href='/delete_account']";

    //WebElements
    @FindBy(how = How.XPATH, using = HOME)
    WebElement homeNavItem;

    @FindBy(how = How.XPATH, using = PRODUCTS)
    WebElement productNavItem;

    @FindBy(how = How.XPATH, using = CART)
    WebElement cartNavItem;

    @FindBy(how = How.XPATH, using = SIGNUP_LOGIN)
    WebElement signUpLoginNavItem;

    @FindBy(how = How.XPATH, using = LOGGED_IN_AS)
    WebElement loggedInAs;

    @FindBy(how = How.XPATH, using = DELETE_ACCOUNT)
    WebElement deleteAccountNavItem;

    public AutomationExerciseHomePage(WebDriver driver) {
        super(driver);
    }

    //TODO: Model other pages and make them return the new page instead of having them be void methods
    public AutomationExerciseHomePage clickHomeNavigationItem() {
        homeNavItem.click();
        return new AutomationExerciseHomePage(driver);
    }

    public ProductsPage clickProductNavigationItem() {
        productNavItem.click();
        return new ProductsPage(driver);
    }

    public ShoppingCartPage clickCartNavigationItem() {
        cartNavItem.click();
        return new ShoppingCartPage(driver);
    }

    public SignUpLoginPage clickSignUpLoginNavigationItem() {
        signUpLoginNavItem.click();
        return new SignUpLoginPage(driver);
    }

    public AccountDeletedPage clickDeleteAccount() {
        deleteAccountNavItem.click();
        return new AccountDeletedPage(driver);
    }

    public boolean LoggedInAsDisplayed() {
        return super.isElementDisplayed(LOGGED_IN_AS);
    }
}
