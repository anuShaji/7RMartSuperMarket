package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class ManageNewsAddPage {
	public WebDriver driver;
	public PageUtilities pageUtilities;

	public ManageNewsAddPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newsField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
public void clickManageNews() {
	managenews.click();
}
public void clikNewButton() {
	newButton.click();
}
public void enterNewsField(String news) {
	newsField.sendKeys(news);
}
public void clickSaveButton() {
	saveButton.click();
}
public boolean isAlertDisplayed() {
	return alert.isDisplayed();
}
}
