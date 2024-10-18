package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtilities;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class SubCategoriesAddNewPage {
	public WebDriver driver;
	private WaitUtility wait;

	public SubCategoriesAddNewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WaitUtility(); // Initialize WaitUtility instance here
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewButton;

	@FindBy(xpath = "//select[@name='cat_id']")
	WebElement selectCategory;

	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryField;

	@FindBy(xpath = "//input[@name='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	
	public SubCategoriesAddNewPage clickAddNewButton() {
		//wait.waitForClickingElement(driver, addNewButton);
		addNewButton.click();
		return this;
	}

	public SubCategoriesAddNewPage selectCategory(String value) {
		wait.waitForVisibilityOfElement(driver, selectCategory); 
		PageUtilities pg = new PageUtilities(driver);
		pg.selectByValue(selectCategory, value);
		return this;
	}
	public SubCategoriesAddNewPage enterSubCategory(String subCatgory) {
		wait.waitForVisibilityOfElement(driver, subCategoryField); 
		subCategoryField.sendKeys(subCatgory);
		return this;
	}
	public SubCategoriesAddNewPage chooseFile(String filepath) {
		wait.waitForVisibilityOfElement(driver, chooseFile); // Wait for chooseFile to be visible
		chooseFile.sendKeys(filepath);
		return this;
	}
	public SubCategoriesAddNewPage clickSaveButton() {
		wait.waitForClickingElement(driver, saveButton); 
		saveButton.click();
		return this;
	}
}
