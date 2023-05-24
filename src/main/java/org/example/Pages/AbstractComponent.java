package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractComponent {
    protected WebDriver driver;

    public AbstractComponent (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
