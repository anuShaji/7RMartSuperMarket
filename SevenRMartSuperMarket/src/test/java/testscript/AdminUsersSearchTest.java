package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.AdminUsersSearchPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersSearchTest extends Base {
	HomePage homepage;
	AdminUsersPage adminpage;
	AdminUsersSearchPage adminsearch;

	@Test
	@Parameters({ "username", "password", "testUsername", "testValueToSelect" })
	public void verifySearchingAnExistingUserAndTypeCombination(String username, String password, String testUsername,
			int testValueToSelect) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
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
