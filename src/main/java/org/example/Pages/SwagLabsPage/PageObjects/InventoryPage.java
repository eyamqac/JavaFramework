package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.SwagLabsPage.Components.TopNavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends TopNavBar {
    //xPaths
    static final String TITLE = "//span[@class='title' and contains(text(),'Products')]";
    static final String FILTER = "//select[@class='product_sort_container']";
    static final String PRODUCT_1 = "//a[@id='item_0_title_link']";
    static final String PRODUCT_2 = "//a[@id='item_1_title_link']";
    static final String PRODUCT_3 = "//a[@id='item_2_title_link']";
    static final String PRODUCT_4 = "//a[@id='item_3_title_link']";
    static final String PRODUCT_5 = "//a[@id='item_4_title_link']";
    static final String PRODUCT_6 = "//a[@id='item_5_title_link']";

    //WebElement
    @FindBy(how = How.XPATH, using = TITLE)
    WebElement title;

    @FindBy(how = How.XPATH, using = FILTER)
    WebElement filter;

    @FindBy(how = How.XPATH, using = PRODUCT_1)
    WebElement product1;

    @FindBy(how = How.XPATH, using = PRODUCT_2)
    WebElement product2;

    @FindBy(how = How.XPATH, using = PRODUCT_3)
    WebElement product3;

    @FindBy(how = How.XPATH, using = PRODUCT_4)
    WebElement product4;

    @FindBy(how = How.XPATH, using = PRODUCT_5)
    WebElement product5;

    @FindBy(how = How.XPATH, using = PRODUCT_6)
    WebElement product6;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInventoryTitleDisplayed() {
        return super.isElementDisplayed(TITLE);
    }

    public void selectFilter(int index) {
        Select select = new Select(filter);
        select.selectByIndex(index);
        super.setLogMessage("Selected Filter");
    }

    public InventoryItemPage clickProduct1() {
        this.product1.click();
        super.setLogMessage("Clicked Product 1");
        return new InventoryItemPage(driver);
    }

    public InventoryItemPage clickProduct2() {
        this.product2.click();
        super.setLogMessage("Clicked Product 2");
        return new InventoryItemPage(driver);
    }

    public InventoryItemPage clickProduct3() {
        this.product3.click();
        return new InventoryItemPage(driver);
    }

    public InventoryItemPage clickProduct4() {
        this.product4.click();
        return new InventoryItemPage(driver);
    }

    public InventoryItemPage clickProduct5() {
        this.product5.click();
        return new InventoryItemPage(driver);
    }

    public InventoryItemPage clickProduct6() {
        this.product6.click();
        return new InventoryItemPage(driver);
    }
}
