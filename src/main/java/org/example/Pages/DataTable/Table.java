package org.example.Pages.DataTable;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractPage implements GenericTable {
    //xPaths
    private final String HEADER_ROW = "//child::thead//child::tr";
    private final String HEADERS_COLUMNS = "//descendant::th";
    private final String ALL_ROWS = "//child::tbody//child::tr";
    private final String ALL_COLUMNS = "//child::tbody//child::td";

    //Attributes
    private String tableId;
    private String tablePath;

    public Table(WebDriver driver, String tableId) {
        super(driver);
        this.tableId = tableId;
        this.tablePath = "//table[@id='" + this.tableId + "']";
    }

    //Note that since PageFactory does not work with dynamic locators, this was the alternative
    //workaround such that the xPath of the Parent node is used during PageFactory initialization,
    //then we specify the table with the tableId to be passed in.
    public WebElement getTable() {
        /*
         * Note that
         * WebElement.findElement() will use the element as the scope in which to search for your
         * selector. This means it is used to search for child elements of current node.
         *
         * WebDriver.findElement() will use the driver (i.e the entire page) to search for your
         * given selector.
         * */
        return driver.findElement(By.xpath(this.tablePath));
    }

    //Accessor Methods
    @Override
    public List<String> getHeaders() {
        List<WebElement> headers = getTable().findElements(By.xpath("." + HEADERS_COLUMNS));
        List<String> headersString = new ArrayList<>();

        for (WebElement element : headers) {
            headersString.add(element.getText());
        }
        return headersString;
    }

    @Override
    public TableRow getHeadersRow() {
        WebElement header = getTable().findElement(By.xpath("." + HEADER_ROW));
        return new TableRow(header);
    }

    @Override
    public TableRow getRow(int index) {
        List<TableRow> allRows = getAllRows();
        return allRows.get(index);
    }

    @Override
    public List<TableRow> getAllRows() {
        List<WebElement> allRows = getTable().findElements(By.xpath("." + ALL_ROWS));
        List<TableRow> resultList = new ArrayList<>();

        for (WebElement element : allRows) {
            TableRow tableRow = new TableRow(element);
            resultList.add(tableRow);
        }

        return resultList;
    }

    public boolean tableRowExists(List<TableRow> t2Rows) {
        List<TableRow> t1Rows = getAllRows();

        boolean allRowsExist = true;
        for (int i = 0; i < t1Rows.size(); i++) {
            boolean rowExists = false;
            for (int j = 0; !rowExists && j < t2Rows.size(); j++) {
                rowExists = t1Rows.get(i).equals(t2Rows.get(j));
            }
            allRowsExist = allRowsExist && rowExists;
        }
        return allRowsExist;
    }
}
