package org.example.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.log = LogManager.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public boolean isElementDisplayed(String xPath) {
        return driver.findElements(By.xpath(xPath)).size() > 0;
    }

    public boolean isElementDisplayed(By b) {
        return driver.findElements(b).size() > 0;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void setLogMessage(String msg) {
        log.info(msg);
    }
}

