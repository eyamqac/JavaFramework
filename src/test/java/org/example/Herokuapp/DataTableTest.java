package org.example.Herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DataTableTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new EdgeDriver();
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void Test_1() {

    }
}
