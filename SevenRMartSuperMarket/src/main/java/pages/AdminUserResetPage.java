package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;

import java.util.List;
import org.openqa.selenium.By;

public class AdminUserResetPage {
    public WebDriver driver;
    private PageUtilities pageUtilities;

    public AdminUserResetPage(WebDriver driver) {
        this.driver = driver;
        this.pageUtilities = new PageUtilities(driver);
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

    public void updateUser(String username, String newUsername, String newPassword, String newUserType) {
        List<WebElement> rows = userTable.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr"));

        for (WebElement row : rows) {
            if (row.findElement(By.xpath("td[1]")).getText().contains(username)) {
                WebElement updateButton = row.findElement(By.xpath(".//i[@class='fas fa-edit']"));
                updateButton.click();

                updateUsernameField(newUsername);
                updatePasswordField(newPassword);
                pageUtilities.selectByValue(userTypeDropDown, newUserType) ;// Using PageUtilities

                WebElement updateSubmitButton = driver.findElement(By.xpath("//button[@name='Update']"));
                updateSubmitButton.click();
                break;
            }
        }
    }

    public void updateUsernameField(String newUsername) {
        usernameField.clear();
        usernameField.sendKeys(newUsername);
    }

    public void updatePasswordField(String newPassword) {
        passwordField.clear();
        passwordField.sendKeys(newPassword);
    }

    public boolean isAlertDisplayed() {
        return alert.isDisplayed(); // Using PageUtilities
    }
}
