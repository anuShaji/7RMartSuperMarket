package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SubCategoriesAddNewPage;
import pages.SubCategoryDeletePage;
import utilities.ExcelUtilities;

public class SubCategoryDeleteTest extends Base{
	@Test
public void verifyDeletingAnExistingsubCategory() throws IOException {
		String username = ExcelUtilities.readStringData(0, 1, "LoginPage1");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		// Initialize the page class
        SubCategoriesAddNewPage subCategoriesPage = new SubCategoriesAddNewPage(driver);
        subCategoriesPage.clickSubCategory();
        SubCategoryDeletePage delete=new SubCategoryDeletePage(driver);
        delete.deleteSubCategory("MeatBalls");
        boolean isAlertPresent1=delete.isSuccessAlertPresent();
        assertTrue(isAlertPresent1, Constants.NOMATCHFOUND);
}
}
