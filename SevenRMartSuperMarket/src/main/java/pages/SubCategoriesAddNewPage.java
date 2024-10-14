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

	// Method to click on Sub Category with explicit wait

	// Method to click on Add New Button with explicit wait
	public SubCategoriesAddNewPage clickAddNewButton() {
		//wait.waitForClickingElement(driver, addNewButton); // Wait for addNewButton to be clickable
		addNewButton.click();
		return this;
	}

	// Method to select category with explicit wait
	public SubCategoriesAddNewPage selectCategory(String value) {
		wait.waitForVisibilityOfElement(driver, selectCategory); // Wait for selectCategory to be visible
		PageUtilities pg = new PageUtilities(driver);
		pg.selectByValue(selectCategory, value);
		return this;
	}

	// Method to enter subcategory name with explicit wait
	public SubCategoriesAddNewPage enterSubCategory(String subCatgory) {
		wait.waitForVisibilityOfElement(driver, subCategoryField); // Wait for subCategoryField to be visible
		subCategoryField.sendKeys(subCatgory);
		return this;
	}

	// Method to choose a file using the sendKeys method with explicit wait
	public SubCategoriesAddNewPage chooseFile(String filepath) {
		wait.waitForVisibilityOfElement(driver, chooseFile); // Wait for chooseFile to be visible
		chooseFile.sendKeys(filepath);
		return this;
	}

	// Method to upload a file using Robot class
	/*
	 * public void uploadFileUsingRobot(String filePath) throws AWTException {
	 * wait.waitForClickingElement(driver, chooseFile); // Wait for chooseFile to be
	 * clickable chooseFile.click(); // Open the file upload dialog
	 * 
	 * // Use Robot class to type the file path and upload FileUploadUtilities
	 * fileUploadUtil = new FileUploadUtilities();
	 * fileUploadUtil.fileUploadUsingRobotClass(chooseFile, filePath); }
	 */

	// Method to click save button with explicit wait
	public SubCategoriesAddNewPage clickSaveButton() {
		wait.waitForClickingElement(driver, saveButton); // Wait for saveButton to be clickable
		saveButton.click();
		return this;
	}
}
