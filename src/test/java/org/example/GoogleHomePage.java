package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    //Attributes
    private WebDriver driver;
    private WebElement searchBar;
    private WebElement searchButton;

    //Constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Mutator methods
    public void clickSearchButton() {
        getSearchButton().click();
    }

    public void enterSearchBar(String searchItem) {
        getSearchBar().sendKeys(searchItem);
    }

    //Accessor methods
    public WebElement getSearchBar() {
        this.searchBar = this.driver.findElement(By.xpath("//textarea[@name='q']"));
        return this.searchBar;
    }

    public WebElement getSearchButton() {
        this.searchButton = this.driver.findElement(By.xpath("//input[@class='gNO89b']"));
        return this.searchButton;
    }

    public boolean isElementDisplayed() {
        return false;
    }
}
