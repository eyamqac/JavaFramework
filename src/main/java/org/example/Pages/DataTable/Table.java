package org.example.Pages.DataTable;

import org.example.Pages.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractComponent implements GenericTable {
    //xPaths
    private final String header_column = "descendant::th";
    private final String all_rows = "child::tbody//child::tr";

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
         *
         * Note that when using WebElement.findElement(), since we can search for an element within
         * the context of another WebElement, the xPath provided to WebElement.findElement() may omit
         * the double slashes (//) because it is implicitly implied. Thus, we are able to search for
         * the child/descendant..etc elements relative to the current node
         * */
        return driver.findElement(By.xpath(this.tablePath));
    }

    //Accessor Methods
    @Override
    public List<String> getHeaders() { //Gets header columns
        List<WebElement> headers = getTable().findElements(By.xpath(header_column));
        List<String> headersString = new ArrayList<>();

        for (WebElement element : headers) {
            headersString.add(element.getText());
        }
        return headersString;
    }

    @Override
    public TableRow getHeadersRow() { //Gets header row
        List<String> headerColumns = getHeaders();
        return new TableRow(headerColumns.get(0),
                headerColumns.get(1),
                headerColumns.get(2),
                headerColumns.get(3),
                headerColumns.get(4),
                headerColumns.get(5));
    }

    @Override
    public TableRow getRow(int index) {
        List<TableRow> allRows = getAllRows();
        return allRows.get(index);
    }

    @Override
    public List<TableRow> getAllRows() {
        List<WebElement> allRows = getTable().findElements(By.xpath(all_rows));
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

    public boolean headerOrderSame(List<String> t2Header) {
        List<String> t1Header = getHeaders();

        boolean isSame = true;
        for (int i = 0; i < t1Header.size(); i++) {
            isSame = isSame && (t1Header.get(i).equals(t2Header.get(i)));
        }
        return isSame;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Table other = (Table) obj;

            return this.headerOrderSame(other.getHeaders())
                    && this.tableRowExists(other.getAllRows());
        }
    }
}
