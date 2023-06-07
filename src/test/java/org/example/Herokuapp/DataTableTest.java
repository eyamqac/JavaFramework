package org.example.Herokuapp;

import org.example.Pages.DataTable.Table;
import org.example.Pages.DataTable.TableRow;
import org.example.Factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DataTableTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new WebDriverFactory().createBrowserDriver();
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void Test_0() { //Rough work
        driver.get("https://the-internet.herokuapp.com/tables");

        //Headers
        List<WebElement> list1;
        List<WebElement> list2;

        //All Table Rows
        List<WebElement> list3;

        //First table row
        List<WebElement> list4;

        //Data of first table row
        List<WebElement> list5;

        list1 = driver.findElements(By.xpath("//table[@id='table1']//descendant::th"));
        assertTrue(list1.size() == 6);

        list2 = driver.findElements(By.xpath("//table[@id='table2']//descendant::th"));
        assertTrue(list2.size() == 6);

        list3 = driver.findElements(By.xpath("//table[@id='table1']//child::tbody//child::tr"));

        list4 = driver.findElements(By.xpath("//table[@id='table1']//child::tbody//child::tr[1]"));

        list5 = driver.findElements(By.xpath("//table[@id='table1']//child::tbody//child::tr[1]//child::td"));

        WebElement td1 = list5.get(0);
        WebElement td2 = list5.get(1);
        WebElement td3 = list5.get(2);
        WebElement td4 = list5.get(3);
        WebElement td5 = list5.get(4);
        WebElement td6 = list5.get(5);
    }

    @Test
    public void Test_1() {//Evaluate equality between tables
        driver.get("https://the-internet.herokuapp.com/tables");
        Table t1 = new Table(driver, "table1");
        Table t2 = new Table(driver, "table2");

        //These rows are content equal
        TableRow tr1 = new TableRow("smith", "john", "jsmith@gmail.com", "$30.00", "http://www.js.com", "edit delete");
        TableRow tr2 = new TableRow("smith", "john", "jsmith@gmail.com", "$30.00", "http://www.js.com", "edit delete");

        List<String> temp = t1.getHeaders();
        List<TableRow> temp2 = t1.getAllRows();
        TableRow temp3 = t1.getHeadersRow();

        assertEquals(tr1, tr2);
        assertTrue(t1.tableRowExists(t2.getAllRows()));
    }
}
