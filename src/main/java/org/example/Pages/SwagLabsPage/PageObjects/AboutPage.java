package org.example.Pages.SwagLabsPage.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AboutPage extends AbstractPage {
    //xPaths
    static final String TITLE = "//div[@class='MuiBox-root css-lwb5go']";

    //WebElements
    @FindBy(how = How.XPATH, using = TITLE)
    WebElement title;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAboutTitleDisplayed() {
        return super.isElementDisplayed(TITLE);
    }
}
