package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	// Constructor to initialize the PageFactory elements
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page elements using @FindBy annotation
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement adminUserModule;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement manageUsersSubModule;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewUserButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;

	@FindBy(xpath = "//select[@id='user_type' and contains(@class, 'form-control')]")
	WebElement userTypeDropDown;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;

	// Methods to interact with elements
	public void clickAdminUserModule() {
		adminUserModule.click();
	}

	public void clickManageUsersSubModule() {
		
		manageUsersSubModule.click();
	}

	public void clickAddNewUser() {
		addNewUserButton.click();
	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectUserType(int userType) {
		Select select = new Select(userTypeDropDown);
		select.selectByIndex(userType); // Pass the userType as an argument for flexibility
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
