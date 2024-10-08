package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class SubCategorySearchItemPage {
    public WebDriver driver;
    private WaitUtility wait;

    public SubCategorySearchItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtility(); // Initialize WaitUtility instance here
    }

    @FindBy(xpath = "//a[@onclick='click_button(2)']")
    WebElement searchButton;

    @FindBy(xpath = "//select[@name='un']")
    WebElement selectCategoryDropDown;

    @FindBy(xpath = "//input[@name='ut']")
    WebElement subCategoryInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
    WebElement subCategoryListTable;

    // Click search button with explicit wait
    public void clickSearchButton() {
        wait.waitForClickingElement(driver, searchButton);
        searchButton.click();
    }

    // Select category dropdown with explicit wait
    public void selectCategory(String visibleText) {
        wait.waitForVisibilityOfElement(driver, selectCategoryDropDown);
        PageUtilities pg = new PageUtilities(driver);
        pg.selectByVisibleText(selectCategoryDropDown, visibleText);
    }

    // Enter subcategory name with explicit wait
    public void enterSubcategoryName(String subCategoryName) {
        wait.waitForVisibilityOfElement(driver, subCategoryInputBox);
        subCategoryInputBox.sendKeys(subCategoryName);
    }

    // Click submit button with explicit wait
    public void clickSubmitButton() {
        wait.waitForClickingElement(driver, submitButton);
        submitButton.click();
    }

    // Check if subcategory is present with explicit wait
    public boolean ifSubCategoryIsPresent(String subCategoryName) {
        wait.waitForVisibilityOfElement(driver, subCategoryListTable);

        // Get all rows from the first column of the table
        List<WebElement> rows = driver.findElements(
            By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
        );

        // Loop through each row
        for (WebElement row : rows) {
            // Check if the subcategory name is found
            if (row.getText().contains(subCategoryName)) {
                return true; // Return true as soon as we find the subcategory
            }
        }

        return false;
    }
}
