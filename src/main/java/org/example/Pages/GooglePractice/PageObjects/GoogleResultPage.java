package org.example.Pages.GooglePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleResultPage extends AbstractPage {
    static final String SEARCH_BAR = "//textarea[@name='q']";

    @FindBy(how = How.XPATH, using = SEARCH_BAR)
    WebElement searchBar;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public GoogleResultPage clickSearchResult(int index) {
        return null;
    }
}
