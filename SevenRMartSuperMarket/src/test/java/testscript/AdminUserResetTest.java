package testscript;

import org.testng.annotations.Test;
import pages.AdminUserResetPage;
import pages.AdminUsersPage;
import pages.LoginPage;

public class AdminUserResetTest extends Base {
    
    @Test
    public void verifyUpdatingUser() {
        String username = "admin"; // The original username
        String usernameToUpdate="AnupamaTest666";
        String newUsername = "adminUpdatedTest"; // The updated username
        String newPassword = "newPassword"; // The updated password
        String newUserType = "Partner"; // The updated user type

        // Log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserNameField(username);
        loginPage.enterPasswordField("admin"); // Assuming the password is "admin"
        loginPage.clickSignInButton();

        // Navigate to Admin Users page
        AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
        adminUsersPage.clickAdminUserModule();
        adminUsersPage.clickManageUsersSubModule();

        // Reset and update user details
        AdminUserResetPage adminUserResetPage = new AdminUserResetPage(driver);
        adminUserResetPage.clickResetButton(); // Click the reset button
        adminUserResetPage.updateUser(usernameToUpdate, newUsername, newPassword, newUserType); // Update user details
    }
}
