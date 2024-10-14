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

    @FindBy(xpath = "//select[@name='un']")
    WebElement selectCategoryDropDown;

    @FindBy(xpath = "//input[@name='ut']")
    WebElement subCategoryInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
    WebElement subCategoryListTable;

    // Click search button with explicit wait

    // Select category dropdown with explicit wait
    public SubCategorySearchItemPage selectCategory(String visibleText) {
        wait.waitForVisibilityOfElement(driver, selectCategoryDropDown);
        PageUtilities pg = new PageUtilities(driver);
        pg.selectByVisibleText(selectCategoryDropDown, visibleText);
		return this;
    }

    // Enter subcategory name with explicit wait
    public SubCategorySearchItemPage enterSubcategoryName(String subCategoryName) {
        wait.waitForVisibilityOfElement(driver, subCategoryInputBox);
        subCategoryInputBox.sendKeys(subCategoryName);
		return this;
    }

    // Click submit button with explicit wait
    public SubCategorySearchItemPage clickSubmitButton() {
        wait.waitForClickingElement(driver, submitButton);
        submitButton.click();
		return this;
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
