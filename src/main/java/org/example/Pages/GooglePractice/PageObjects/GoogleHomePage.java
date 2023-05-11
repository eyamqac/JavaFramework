package org.example.Pages.GooglePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleHomePage extends AbstractPage {
    //xPaths
    static final String SEARCH_BAR = "//textarea[@name='q']";
    static final String SEARCH_BUTTON = "//input[@class='gNO89b']";

    //WebElements
    @FindBy(how = How.XPATH, using = SEARCH_BAR)
    WebElement searchBar;

    @FindBy(how = How.XPATH, using = SEARCH_BUTTON)
    WebElement searchButton;

    //When initializing page, it looks through the findby annotations
    //the webdriver is then passed in which provides the page the context for what we are seraching for
    //then it fills in the webelements given the locator information given without finding the element ourselves
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextSearchBar(String text) {
        searchBar.sendKeys(text);
    }

    public GoogleResultPage clickSearchButton() {
        searchButton.click();
        return new GoogleResultPage(driver);
    }
}
