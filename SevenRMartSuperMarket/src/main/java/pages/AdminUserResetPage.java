package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserResetPage {
    public WebDriver driver;

    public AdminUserResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
    WebElement resetButton;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
    private WebElement userTable;

    @FindBy(xpath = "//select[@name='user_type']")
    WebElement userTypeDropDown;

    public void clickResetButton() {
        resetButton.click();
    }

    // Method to update a user by username
    public void updateUser(String username, String newUsername, String newPassword, String newUserType) {
        // Locate all rows in the table
        List<WebElement> rows = userTable.findElements(By.tagName("tr"));

        // Iterate through each row to find the specified username
        for (WebElement row : rows) {
            if (row.getText().contains(username)) {
                // Click the update button in the row
                WebElement updateButton = row.findElement(By.xpath(".//a[contains(@href, 'edit')]"));
                updateButton.click();

                // Update fields for username, password, and user type
                updateField(By.name("username"), newUsername);
                updateField(By.name("password"), newPassword);
                updateSelectField(By.name("user_type"), newUserType);

                // Click the update submit button
                WebElement updateSubmitButton = driver.findElement(By.xpath("//button[@name='Update']"));
                updateSubmitButton.click();
                break; // Exit loop after updating
            }
        }
    }

    // Helper method to update text fields
    private void updateField(By by, String value) {
        WebElement field = driver.findElement(by);
        field.clear();
        field.sendKeys(value);
    }

    // Helper method to update select fields
    private void updateSelectField(By by, String newUserType) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(newUserType); // Assuming the user type is visible text
    }
}
