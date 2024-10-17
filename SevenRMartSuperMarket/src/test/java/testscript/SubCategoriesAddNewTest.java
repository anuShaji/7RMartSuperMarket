package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoriesAddNewPage;
import utilities.ExcelUtilities;

public class SubCategoriesAddNewTest extends Base {
	HomePage homepage;
	SubCategoriesAddNewPage addSubCategoriesPage;

	@Test
	@Parameters({ "imagePath", "categoryToSelect", "subCategory" }) // Added imagePath as parameter
	public void verifyAddingNewSubCategoryWithValidDetails(String imagePath, String categoryToSelect,
			String subCategory) throws IOException, AWTException {
		// Login actions
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"))
				.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1"));
		homepage = loginpage.clickSignInButton();
		// Navigate to SubCategories page
		addSubCategoriesPage = homepage.clickSubCategory();
		// Add new sub-category with valid details
		addSubCategoriesPage.clickAddNewButton().selectCategory(categoryToSelect).enterSubCategory(subCategory)
				.chooseFile(imagePath) // Use the image path from XML parameter
				.clickSaveButton();
	}
}
