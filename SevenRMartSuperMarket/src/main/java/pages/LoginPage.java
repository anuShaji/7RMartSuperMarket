package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// page factory declaration
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signUpButton;
	@FindBy(xpath = "//li[text()='Dashboard']")
	WebElement dashboard; //// li[text()='Dashboard']
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public LoginPage enterUserNameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;

	}

	public HomePage  clickSignInButton() {
		signUpButton.click();
		return new HomePage(driver);
	}

	public boolean isDashboardLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
