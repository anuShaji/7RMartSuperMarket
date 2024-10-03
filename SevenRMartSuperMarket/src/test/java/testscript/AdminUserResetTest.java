package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import pages.AdminUserResetPage;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminUserResetTest extends Base {

	@Test
	public void verifyUpdatingUser() throws IOException {
		String username = "admin"; // The original username
		
		String usernameToUpdate = "Gukesh Eloy";
		String newUsername = "RamaKrishna Pillai"; // The updated username
		String newPassword = "newPassword"; // The updated password
		String newUserType = "partner"; // The updated user type

		// Log in
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"));
		loginPage.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1")); // Assuming the password is "admin"
		loginPage.clickSignInButton();

		// Navigate to Admin Users page
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickAdminUserModule();
		adminUsersPage.clickManageUsersSubModule();

		// Reset and update user details
		AdminUserResetPage adminUserResetPage = new AdminUserResetPage(driver);
		adminUserResetPage.clickResetButton(); // Click the reset button
		adminUserResetPage.updateUser(usernameToUpdate, newUsername, newPassword, newUserType); // Update user details
		boolean alertDisplayed = adminUserResetPage.isAlertDisplayed();
		assertTrue(alertDisplayed, "unexpected error occured");
	}
}
