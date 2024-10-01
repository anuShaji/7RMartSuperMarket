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
     WebElement userTable;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//select[@id='user_type']")
    WebElement userTypeDropDown;
    @FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;

    public void clickResetButton() {
        resetButton.click();
    }

 // Method to update a user by username
    public void updateUser(String username, String newUsername, String newPassword, String newUserType) {
        // Locate all rows in the table
        List<WebElement> rows = userTable.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr"));

        // Iterate through each row to find the specified username
        for (WebElement row : rows) {
            // Check if the row contains the username
            if (row.findElement(By.xpath("td[1]")).getText().contains(username)) {
                // Find the corresponding edit button in this row and click it
                WebElement updateButton = row.findElement(By.xpath(".//i[@class='fas fa-edit']"));
                updateButton.click();

                // Update the username field
                updateUsernameField(newUsername);

                // Update the password field
                updatePasswordField(newPassword);

                // Update the user type dropdown
                updateUserType(newUserType);

                // Click the update submit button
                WebElement updateSubmitButton = driver.findElement(By.xpath("//button[@name='Update']"));
                updateSubmitButton.click();
                break; // Exit loop after updating
            }
        }
    }


    //  method to update the username field
    public void updateUsernameField(String newUsername) {
        usernameField.clear();
        usernameField.sendKeys(newUsername);
    }

    // method to update the password field
    public void updatePasswordField(String newPassword) {
        passwordField.clear();
        passwordField.sendKeys(newPassword);
    }

    // Helper method to update the user type dropdown
    public void updateUserType(String newUserType) {
        Select select = new Select(userTypeDropDown);
        select.selectByVisibleText(newUserType); // Assuming the user type is visible text
    }
    public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
