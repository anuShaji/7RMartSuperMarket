package pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class SubCategoryDeletePage {

    private WebDriver driver;
    private WaitUtility wait;

    public SubCategoryDeletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtility(); // Initialize WaitUtility instance here
    }

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
    private WebElement subCategoryListTable;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successAlert;

    // Method to delete subcategory with explicit wait for the table and delete button
    public void deleteSubCategory(String subcategory) {
        wait.waitForVisibilityOfElement(driver, subCategoryListTable); // Wait for the table to be visible
        List<WebElement> rows = subCategoryListTable.findElements(By.xpath(".//tbody/tr")); // Get all rows in the table
        for (WebElement row : rows) {
            // Assuming the subcategory name is in the first cell (td[1])
            if (row.findElement(By.xpath(".//td[1]")).getText().contains(subcategory)) {
                WebElement deleteButton = row.findElement(By.xpath(".//i[@class='fas fa-trash-alt']"));
                wait.waitForClickingElement(driver, deleteButton); // Wait for the delete button to be clickable
                deleteButton.click(); // Click the delete button
                confirmDeletion(); // Confirm deletion via alert
                break; // Exit loop after deletion
            }
        }
    }

    // Private method to handle confirmation alert after delete action
    private void confirmDeletion() {
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Accept the alert to confirm deletion
    }

    // Method to check if success alert is present after deletion
    public boolean isSuccessAlertPresent() {
        wait.waitForVisibilityOfElement(driver, successAlert); // Wait for success alert to be visible
        return successAlert.isDisplayed() && successAlert.getText().contains("Sub Category Deleted Successfully");
    }
}
