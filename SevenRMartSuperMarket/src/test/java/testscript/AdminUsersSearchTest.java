package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.AdminUsersSearchPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminUsersSearchTest extends Base {
	HomePage homepage;
	AdminUsersPage adminpage;
	AdminUsersSearchPage adminsearch;

	@Test
	@Parameters({"testUsername", "testValueToSelect" })
	public void verifySearchingAnExistingUserAndTypeCombination(String testUsername,
			String testValueToSelect) throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"))
				.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1"));
		homepage = loginpage.clickSignInButton();

		adminpage = homepage.clickAdminUserModule();
		adminpage.clickManageUsersSubModule();
		adminsearch = homepage.clickAdminUserSearchButton();
		adminsearch.enterUserName(testUsername);
		adminsearch.selectUserType(testValueToSelect);
		adminsearch.clickSerachButton();
		// Check if the value is present in the table
		boolean isPresent = adminsearch.isValuePresentInTable(testUsername);
		// Assert to verify the presence of the value
		assertTrue(isPresent, Constants.NOMATCHFOUND);
	}
}
