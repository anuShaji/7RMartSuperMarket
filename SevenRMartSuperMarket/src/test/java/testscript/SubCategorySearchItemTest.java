package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoriesAddNewPage;
import pages.SubCategorySearchItemPage;
import utilities.ExcelUtilities;

public class SubCategorySearchItemTest extends Base {
	HomePage homepage;
	SubCategoriesAddNewPage subcategoryadd;
	SubCategorySearchItemPage subcategorysearch;

	@Test(retryAnalyzer = retry.Retry.class)
	@Parameters({ "categoryname", "subcategoryName" })
	public void verifyWhetherAValidSubCategoryIsPresentInTheList(String categoryname, String subcategoryName)
			throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"))
				.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1"));
		homepage = loginpage.clickSignInButton();
		subcategoryadd = homepage.clickSubCategory();
		subcategorysearch = homepage.clickSubCategorySearchButton();
		subcategorysearch.selectCategory(categoryname);
		subcategorysearch.enterSubcategoryName(subcategoryName);
		subcategorysearch.clickSubmitButton();
		boolean isSubCategoryPresent = subcategorysearch.ifSubCategoryIsPresent(subcategoryName);
		assertTrue(isSubCategoryPresent, Constants.NOMATCHFOUND);

	}
}
