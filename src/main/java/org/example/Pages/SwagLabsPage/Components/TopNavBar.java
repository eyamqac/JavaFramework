package org.example.Pages.SwagLabsPage.Components;

import org.example.Pages.AbstractPage;
import org.example.Pages.SwagLabsPage.PageObjects.AboutPage;
import org.example.Pages.SwagLabsPage.PageObjects.InventoryPage;
import org.example.Pages.SwagLabsPage.PageObjects.LoginPage;
import org.example.Pages.SwagLabsPage.PageObjects.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopNavBar extends AbstractPage {
    //xPaths
    static final String SIDE_MENU = "//button[@id='react-burger-menu-btn']";
    static final String SIDE_MENU_ALL_ITEMS = "//a[@id='inventory_sidebar_link']";
    static final String SIDE_MENU_ABOUT = "//a[@id='about_sidebar_link']";
    static final String SIDE_MENU_LOGOUT = "//a[@id='logout_sidebar_link']";
    static final String SIDE_MENU_RESET_APP_STATE = "//a[@id='reset_sidebar_link']";
    static final String SHOPPING_CART_BUTTON = "//a[@class='shopping_cart_link']";

    //WebElements
    @FindBy(how = How.XPATH, using = SIDE_MENU)
    WebElement sideMenu;

    @FindBy(how = How.XPATH, using = SIDE_MENU_ALL_ITEMS)
    WebElement allItems;

    @FindBy(how = How.XPATH, using = SIDE_MENU_ABOUT)
    WebElement about;

    @FindBy(how = How.XPATH, using = SIDE_MENU_LOGOUT)
    WebElement logout;

    @FindBy(how = How.XPATH, using = SIDE_MENU_RESET_APP_STATE)
    WebElement reset;

    @FindBy(how = How.XPATH, using = SHOPPING_CART_BUTTON)
    WebElement shoppingCartButton;

    public TopNavBar(WebDriver driver) {
        super(driver);
    }

    public void openSideBar() {
        this.sideMenu.click();
        super.setLogMessage("Open Side Action Bar");
    }

    //TODO: Make click methods navigate to the appropriate pages
    public InventoryPage clickSideMenuAllItems() {
        /*
         * Note that this is an explicit wait that will tell Selenium to wait on this
         * particular instance until a certain condition is met. Does not have to
         * wait for the full time duration.
         * */
        wait.until(ExpectedConditions.visibilityOf(allItems));
        this.allItems.click();
        return new InventoryPage(driver);
    }

    public AboutPage clickSideMenuAbout() {
        wait.until(ExpectedConditions.visibilityOf(about));
        super.setLogMessage("Click About Page");
        this.about.click();
        return new AboutPage(driver);
    }

    public LoginPage clickSideMenuLogout() {
        wait.until(ExpectedConditions.visibilityOf(logout)); //wait needed as automation runs too fast to find element
        this.logout.click();
        super.setLogMessage("Click Logout");
        return new LoginPage(driver);
    }

    public void clickSideMenuResetAppState() {
    }

    public YourCartPage clickShoppingCartButton() {
        super.setLogMessage("Click Shopping Cart Button");
        this.shoppingCartButton.click();
        return new YourCartPage(driver);
    }
}
