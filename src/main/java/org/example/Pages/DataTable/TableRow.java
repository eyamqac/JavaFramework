package org.example.Pages.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Note that Table row classes will be uniquely defined for their corresponding tables. Currently, there are
 * no methods to abstract
 */
public class TableRow {
    //xPaths
    private String COLUMN = "child::td";

    //Attributes
    private String lastName;
    private String firstName;
    private String email;
    private String amountDue;
    private String website;
    private String action;

    public TableRow(String lastName, String firstName, String email, String amountDue, String website, String action) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.amountDue = amountDue;
        this.website = website;
        this.action = action;
    }

    public TableRow(WebElement tableRow) {
        List<WebElement> data = tableRow.findElements(By.xpath(COLUMN));

        this.lastName = data.get(0).getText();
        this.firstName = data.get(1).getText();
        this.email = data.get(2).getText();
        this.amountDue = data.get(3).getText();
        this.website = data.get(4).getText();
        this.action = data.get(5).getText();
    }

    //Accessor methods
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public String getWebsite() {
        return website;
    }

    public String getAction() {
        return action;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            TableRow other = (TableRow) obj;

            return this.getFirstName().equals(other.getFirstName())
                    && this.getLastName().equals(other.getLastName())
                    && this.getEmail().equals(other.getEmail())
                    && this.getAmountDue().equals(other.getAmountDue())
                    && this.getWebsite().equals(other.getWebsite())
                    && this.getAction().equals(other.getAction());
        }
    }
}
