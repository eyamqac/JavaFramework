package org.example.Factory;

import org.example.Builders.ChromeOptionsBuilder;
import org.example.Builders.EdgeOptionsBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

//Factory Class
public class WebDriverFactory {

    public EdgeOptions getEdgeOptions() {
        //Invoke method calls from the Builder class
        return new EdgeOptionsBuilder()
                .setWindowSize("start-maximized")
                .setExtension(new File("./bin/1.49.2_0.crx"))
                .build();
    }

    public ChromeOptions getChromeOptions() {
        //Invoke method calls from the Builder class
        return new ChromeOptionsBuilder()
                .setWindowSize("start-maximized")
//                .setIncognito("--incognito")
                .setExtension(new File("./bin/1.49.2_0.crx"))
                .build();
    }

    public WebDriver createBrowserDriver() {
        switch (System.getProperty("browser").toLowerCase()) {
            case "chrome":
                return new ChromeDriver(getChromeOptions());
            case "firefox":
                return new FirefoxDriver();
            default:
                return new EdgeDriver(getEdgeOptions());
        }
    }
}
