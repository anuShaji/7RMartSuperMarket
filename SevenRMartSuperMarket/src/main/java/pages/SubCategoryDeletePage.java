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

    public SubCategoryDeletePage deleteSubCategory(String subcategory) {
        List<WebElement> rows = subCategoryListTable.findElements(By.xpath(".//tbody/tr"));

        for (WebElement row : rows) {
            WebElement subcategoryCell = row.findElement(By.xpath(".//td[1]"));

            if (subcategoryCell.getText().trim().equalsIgnoreCase(subcategory)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", row);

                WebElement deleteButton = row.findElement(By.xpath(".//i[@class='fas fa-trash-alt']"));
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(deleteButton));

                deleteButton.click();

                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.alertIsPresent());

                confirmDeletion();

                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOf(successAlert));
                break;
            }
        }
        return this;
    }

    private SubCategoryDeletePage confirmDeletion() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public boolean isSuccessAlertPresent() {
        try {
            return successAlert.isDisplayed() && successAlert.getText().contains("Sub Category Deleted Successfully");
        } catch (Exception e) {
            return false;
        }
    }
}
