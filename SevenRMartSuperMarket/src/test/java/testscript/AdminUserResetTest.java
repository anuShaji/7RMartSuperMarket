package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.service.FakerIDN;

import constants.Constants;
import pages.AdminUserResetPage;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtilities;

public class AdminUserResetTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserpage;
	AdminUserResetPage adminreset;
	FakerUtilities faker;

	@Test
	@Parameters({ "username", "password", "usernameToUpdate", "newUsername", "newPassword", "newUserType" })
	public void verifyUpdatingUser(String username, String password, String usernameToUpdate, String newUsername,
			String newPassword, String newUserType) throws IOException {
		// Log in
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginPage.clickSignInButton();

		// Navigate to Admin Users page
		adminuserpage = homepage.clickAdminUserModule();
		adminuserpage.clickManageUsersSubModule();

		// Reset and update user details

		adminreset = homepage.adminClickResetButton();// Click the reset button
		adminreset.updateUser(usernameToUpdate, newUsername, newPassword, newUserType); // Update user details
		boolean alertDisplayed = adminreset.isAlertDisplayed();
		assertTrue(alertDisplayed, Constants.UNEXPECTED_ERROR);
	}
}
