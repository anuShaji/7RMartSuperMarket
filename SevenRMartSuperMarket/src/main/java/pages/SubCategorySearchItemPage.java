package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class SubCategorySearchItemPage {
	public WebDriver driver;
	private WaitUtility wait;

	public SubCategorySearchItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WaitUtility(); // Initialize WaitUtility instance here
	}

	@FindBy(xpath = "//select[@name='un']")
	WebElement selectCategoryDropDown;

	@FindBy(xpath = "//input[@name='ut']")
	WebElement subCategoryInputBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement subCategoryListTable;

	public SubCategorySearchItemPage selectCategory(String visibleText) {
		wait.waitForVisibilityOfElement(driver, selectCategoryDropDown);
		PageUtilities pg = new PageUtilities(driver);
		pg.selectByVisibleText(selectCategoryDropDown, visibleText);
		return this;
	}

	public SubCategorySearchItemPage enterSubcategoryName(String subCategoryName) {
		wait.waitForVisibilityOfElement(driver, subCategoryInputBox);
		subCategoryInputBox.sendKeys(subCategoryName);
		return this;
	}

	public SubCategorySearchItemPage clickSubmitButton() {
		wait.waitForClickingElement(driver, submitButton);
		submitButton.click();
		return this;
	}

	public boolean ifSubCategoryIsPresent(String subCategoryName) {
		wait.waitForVisibilityOfElement(driver, subCategoryListTable);
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]"));

		for (WebElement row : rows) {
			if (row.getText().contains(subCategoryName)) {
			}
		}

		return false;
	}
}
