package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SubCategoriesAddNewPage;
import pages.SubCategorySearchItemPage;
import utilities.ExcelUtilities;

public class SubCategorySearchItemTest extends Base {
	@Test
	public void verifyWhetherAValidSubCategoryIsPresentInTheList() throws IOException {
		String username = ExcelUtilities.readStringData(0, 1, "LoginPage1");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		SubCategoriesAddNewPage subCategoriesPage = new SubCategoriesAddNewPage(driver);
        subCategoriesPage.clickSubCategory();
        SubCategorySearchItemPage searchItem=new SubCategorySearchItemPage(driver);
        searchItem.clickSearchButton();
        String subCateGory="MeatBalls";
        searchItem.selectCategory("Grocery");
        searchItem.enterSubcategoryName(subCateGory);
        searchItem.clickSubmitButton();
        boolean isSubCategoryPresent= searchItem.ifSubCategoryIsPresent(subCateGory);
        assertTrue(isSubCategoryPresent,Constants.NOMATCHFOUND);

	}
}
