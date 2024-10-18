package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class AdminUsersSearchPage {
	public WebDriver driver;

	public AdminUsersSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='un']")
	WebElement usernameField;
	@FindBy(xpath = "//select[@name='ut']")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement userTable;

	public AdminUsersSearchPage enterUserName(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public AdminUsersSearchPage selectUserType(String useValue) {
		PageUtilities pg = new PageUtilities(driver);
		pg.selectByVisibleText(userTypeDropDown, useValue);
		return this;
	}

	public AdminUsersSearchPage clickSerachButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForClickingElement(driver, searchButton);
		searchButton.click();
		return this;
	}

	public boolean isValuePresentInTable(String value) {
		List<WebElement> rows = userTable
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]"));
		for (WebElement row : rows) {
			if (row.getText().contains(value)) {
				return true; // Value found
			}
		}
		return false; // not found
	}
}
