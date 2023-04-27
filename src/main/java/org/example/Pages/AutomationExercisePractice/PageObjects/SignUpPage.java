package org.example.Pages.AutomationExercisePractice.PageObjects;

import org.example.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends AbstractPage {
    //xPaths
    static final String TITLE_OPTION_1 = "//input[@id='id_gender1']";
    static final String TITLE_OPTION_2 = "//input[@id='id_gender2']";
    static final String NAME = "//input[@id='name']";
    //    static final String EMAIL = "//input[@id='email']";
    static final String PASSWORD = "//input[@id='password']";
    static final String DAY = "//select[@id='days']";
    static final String MONTH = "//select[@id='months']";
    static final String YEAR = "//select[@id='years']";
    static final String FIRST_NAME = "//input[@id='first_name']";
    static final String LAST_NAME = "//input[@id='last_name']";
    static final String COMPANY = "//input[@id='company']";
    static final String ADDRESS = "//input[@id='address1']";
    static final String COUNTRY = "//select[@id='country']";
    static final String STATE = "//input[@id='state']";
    static final String CITY = "//input[@id='city']";
    static final String ZIPCODE = "//input[@id='zipcode']";
    static final String MOBILE_NUMBER = "//input[@id='mobile_number']";
    static final String CREATE_ACCOUNT_BUTTON = "//button[@data-qa='create-account']";

    //WebElements
    @FindBy(how = How.XPATH, using = TITLE_OPTION_1)
    WebElement title1;

    @FindBy(how = How.XPATH, using = TITLE_OPTION_2)
    WebElement title2;

    @FindBy(how = How.XPATH, using = NAME)
    WebElement name;

    //Element is disabled on this page
//    @FindBy(how = How.XPATH, using = EMAIL)
//    WebElement email;

    @FindBy(how = How.XPATH, using = PASSWORD)
    WebElement password;

    @FindBy(how = How.XPATH, using = DAY)
    WebElement day;

    @FindBy(how = How.XPATH, using = MONTH)
    WebElement month;

    @FindBy(how = How.XPATH, using = YEAR)
    WebElement year;

    @FindBy(how = How.XPATH, using = FIRST_NAME)
    WebElement firstName;

    @FindBy(how = How.XPATH, using = LAST_NAME)
    WebElement lastName;

    @FindBy(how = How.XPATH, using = COMPANY)
    WebElement company;

    @FindBy(how = How.XPATH, using = ADDRESS)
    WebElement address;

    @FindBy(how = How.XPATH, using = COUNTRY)
    WebElement country;

    @FindBy(how = How.XPATH, using = STATE)
    WebElement state;

    @FindBy(how = How.XPATH, using = CITY)
    WebElement city;

    @FindBy(how = How.XPATH, using = ZIPCODE)
    WebElement zipcode;

    @FindBy(how = How.XPATH, using = MOBILE_NUMBER)
    WebElement mobileNumber;

    @FindBy(how = How.XPATH, using = CREATE_ACCOUNT_BUTTON)
    WebElement createAccountButton;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void selectTitleOption1() {
        title1.click();
    }

    public void selectTitleOption2() {
        title2.click();
    }

    public void enterName(String text) {
        name.sendKeys(text);
    }

    public void enterPassword(String text) {
        password.sendKeys(text);
    }

    public void selectDateOfBirth(int day, int month, int year) {
        selectDay(day);
        selectMonth(month);
        selectYear(year);
    }

    public void selectDay(int index) {
        Select select = new Select(day);
        select.selectByIndex(index);
    }

    public void selectMonth(int index) {
        Select select = new Select(month);
        select.selectByIndex(index);
    }

    public void selectYear(int index) {
        Select select = new Select(year);
        select.selectByIndex(index);
    }

    public void enterFirstName(String text) {
        firstName.sendKeys(text);
    }

    public void enterLastname(String text) {
        lastName.sendKeys(text);
    }

    public void enterCompany(String text) {
        company.sendKeys(text);
    }

    public void enterAddress(String text) {
        address.sendKeys(text);
    }

    public void selectCountry(int index) {
        Select select = new Select(country);
        select.selectByIndex(index);
    }

    public void enterState(String text) {
        state.sendKeys(text);
    }

    public void enterCity(String text) {
        city.sendKeys(text);
    }

    public void enterZipCode(String text) {
        zipcode.sendKeys(text);
    }

    public void enterMobileNumber(String text) {
        mobileNumber.sendKeys(text);
    }

    public AccountCreatedPage clickCreateAccount() {
        createAccountButton.click();
        return new AccountCreatedPage(driver);
    }

}
