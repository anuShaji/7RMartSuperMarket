package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminUsersPage;

	@Test
	@Parameters({ "username", "password", "testUsername", "newPassword", "userType" })
	public void verifyAddingANewUser(String username, String password, String testUsername, String newPassword,
			int userType) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginpage.clickSignInButton();
		adminUsersPage = homepage.clickAdminUserModule();
		adminUsersPage.clickManageUsersSubModule();
		adminUsersPage.clickAddNewUser();
		adminUsersPage.enterUserName(testUsername);
		adminUsersPage.enterPassword(newPassword);
		adminUsersPage.selectUserType(userType);
		adminUsersPage.clickSaveButton();
		boolean alertDisplayed = adminUsersPage.isAlertDisplayed();
		assertTrue(alertDisplayed, Constants.USER_ALREADY_EXISTS);

	}
}
