package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoriesAddNewPage;
import utilities.ExcelUtilities;

public class SubCategoriesAddNewTest extends Base {
	@Test
public void verifyAddingNewSubCategoryWithValidDetails() throws IOException, AWTException {
		String username = ExcelUtilities.readStringData(0, 1, "LoginPage1");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		// Initialize the page class
        SubCategoriesAddNewPage subCategoriesPage = new SubCategoriesAddNewPage(driver);
        subCategoriesPage.clickSubCategory();
        String filePath = ExcelUtilities.readStringData(0, 1, "ImagesForTest");  // Get file path from Excel
        subCategoriesPage.clickAddNewButton();
        subCategoriesPage.selectCategory("167");
        subCategoriesPage.enterSubCategory("anupamaTest");
        subCategoriesPage.chooseFile(filePath);
        //String filePath = ExcelUtilities.readStringData(0, 1, "ImagesForTest");  // Get file path from Excel
        //subCategoriesPage.uploadFileUsingRobot(filePath);
        subCategoriesPage.clickSaveButton();

}
}
