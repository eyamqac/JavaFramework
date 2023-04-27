package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage extends AbstractPage {
    //xPath
    static final String SEARCH_BAR = "//input[@id='search_product']";
    static final String PRODUCT_ITEM_1 = "//a[@href='/product_details/1']";

    //WebElement
    @FindBy(how = How.XPATH, using = SEARCH_BAR)
    WebElement searchBar;

    @FindBy(how = How.XPATH, using = PRODUCT_ITEM_1)
    WebElement productItem1;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductItemPage clickItem() {
        productItem1.click();
        return new ProductItemPage(driver);
    }
}
