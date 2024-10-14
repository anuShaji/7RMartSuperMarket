package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubCategoryDeletePage {

    private WebDriver driver;

    public SubCategoryDeletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
    private WebElement subCategoryListTable;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successAlert;

    /**
     * Deletes a subcategory from the list if found.
     * 
     * @param subcategory the name of the subcategory to be deleted
     * @return this instance for method chaining
     */
    public SubCategoryDeletePage deleteSubCategory(String subcategory) {
        // Get all rows in the table
        List<WebElement> rows = subCategoryListTable.findElements(By.xpath(".//tbody/tr"));

        boolean subcategoryFound = false;

        // Iterate through each row to find the subcategory
        for (WebElement row : rows) {
            WebElement subcategoryCell = row.findElement(By.xpath(".//td[1]"));
            System.out.println("Found subcategory: " + subcategoryCell.getText());

            // Check if the subcategory name matches
            if (subcategoryCell.getText().equals(subcategory)) { // Use equals for exact match
                System.out.println("Matching subcategory found: " + subcategoryCell.getText());
                subcategoryFound = true;

                // Scroll the row into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", row);

                // Wait for the delete button to be present and clickable
                WebElement deleteButton = row.findElement(By.xpath(".//i[@class='fas fa-trash-alt']"));
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(deleteButton));

                // Click the delete button
                deleteButton.click();
                System.out.println("Delete button clicked.");

                // Wait for the alert to be present
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.alertIsPresent());

                // Confirm the deletion alert
                confirmDeletion();
                System.out.println("Deletion confirmed.");

                // Wait for the success alert to be present
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOf(successAlert));

                if (isSuccessAlertPresent()) {
                    System.out.println("Success alert displayed.");
                } else {
                    System.out.println("Success alert not displayed after deletion.");
                }
                break; // Exit after deletion
            }
        }

        if (!subcategoryFound) {
            System.out.println("Subcategory '" + subcategory + "' not found for deletion.");
        }

        return this;
    }

    /**
     * Handles the confirmation alert after delete action.
     * 
     * @return this instance for method chaining
     */
    private SubCategoryDeletePage confirmDeletion() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // Accept the alert to confirm deletion
            System.out.println("Alert accepted.");
        } catch (Exception e) {
            System.out.println("No alert to accept: " + e.getMessage());
        }
        return this;
    }

    /**
     * Checks if the success alert is present after deletion.
     * 
     * @return true if success alert is displayed, false otherwise
     */
    public boolean isSuccessAlertPresent() {
        try {
            return successAlert.isDisplayed() && successAlert.getText().contains("Sub Category Deleted Successfully");
        } catch (Exception e) {
            System.out.println("Success alert not present: " + e.getMessage());
            return false;
        }
    }
}
