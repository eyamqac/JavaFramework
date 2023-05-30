package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Factory Class
public class WebDriverFactory {

    public WebDriver createBrowserDriver() {
        switch (System.getProperty("browser").toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new EdgeDriver();
        }
    }
}
