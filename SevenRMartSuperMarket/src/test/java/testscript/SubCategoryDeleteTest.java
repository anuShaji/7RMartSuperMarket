package testscript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryDeletePage;

public class SubCategoryDeleteTest extends Base {
	HomePage homepage;
	SubCategoryDeletePage subcategoryDelete;

	@Test
	@Parameters({ "username", "password", "subcategoryName" })
	public void verifyDeletingAnExistingSubCategory(String username, String password, String subcategoryName)
			throws IOException {
		// Login page actions
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginpage.clickSignInButton();
		subcategoryDelete = homepage.clickSubCategoryForDelete();
		subcategoryDelete.deleteSubCategory(subcategoryName);
		boolean isAlertPresent = subcategoryDelete.isSuccessAlertPresent();
		assertTrue(isAlertPresent, Constants.NOMATCHFOUND);

	}
}