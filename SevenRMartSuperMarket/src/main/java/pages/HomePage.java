package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminLogo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logoutButton;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton1;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement adminUserModule;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement adminresetButton;
	@FindBy(xpath = "//a[@onclick=\"click_button(2)\"]")
	WebElement adminUserSearchButton;
	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subCategory;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement subCategorySearchButton;

	public SubCategorySearchItemPage clickSubCategorySearchButton() {
		subCategorySearchButton.click();
		return new SubCategorySearchItemPage(driver);
	}

	public SubCategoryDeletePage clickSubCategoryForDelete() {
		subCategory.click();
		return new SubCategoryDeletePage(driver);
	}

	public AdminUsersSearchPage clickAdminUserSearchButton() {
		adminUserSearchButton.click();
		return new AdminUsersSearchPage(driver);
	}

	public AdminUsersPage clickAdminUserModule() {
		adminUserModule.click();
		return new AdminUsersPage(driver);
	}

	public AdminUserResetPage adminClickResetButton() {
		adminresetButton.click();
		return new AdminUserResetPage(driver);
	}

	public ManageUsersSearchPage clickSearchButton() {
		searchButton1.click();
		return new ManageUsersSearchPage(driver);
	}

	public ManageNewsAddPage clickManageNews() {
		managenews.click();
		return new ManageNewsAddPage(driver);
	}

	public ManageUserResetPage clickResetButton() {
		resetButton.click();
		return new ManageUserResetPage(driver);
	}

	public SubCategoriesAddNewPage clickSubCategory() {
		subCategory.click();
		return new SubCategoriesAddNewPage(driver);
	}

	public void clickAdminLogo() {
		adminLogo.click();
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

}
