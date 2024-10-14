package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoriesAddNewPage;

public class SubCategoriesAddNewTest extends Base {
	HomePage homepage;
	SubCategoriesAddNewPage addSubCategoriesPage;

	@Test
	@Parameters({ "username", "password", "imagePath" }) // Added imagePath as parameter
	public void verifyAddingNewSubCategoryWithValidDetails(String username, String password, String imagePath)
			throws IOException, AWTException {

		// Login actions
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginpage.clickSignInButton();

		// Navigate to SubCategories page
		addSubCategoriesPage = homepage.clickSubCategory();

		// Add new sub-category with valid details
		addSubCategoriesPage.clickAddNewButton().selectCategory("167") // You may parameterize this value if needed
				.enterSubCategory("anupamaTestretest") // You can make this dynamic as well
				.chooseFile(imagePath) // Use the image path from XML parameter
				.clickSaveButton();
	}
}
