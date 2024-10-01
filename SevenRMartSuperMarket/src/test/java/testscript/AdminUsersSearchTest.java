package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.AdminUsersSearchPage;
import pages.LoginPage;

public class AdminUsersSearchTest extends Base {
	@Test
public void verifySearchingAnExistingUserAndTypeCombination() {
		String username = "admin";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickAdminUserModule();
		adminUsersPage.clickManageUsersSubModule();
		AdminUsersSearchPage adminUserSearchPage=new AdminUsersSearchPage(driver);
		adminUserSearchPage.clickAdminUserSearchButton();
		adminUserSearchPage.enterUserName("Douglass");
		adminUserSearchPage.selectUserType(2);
		adminUserSearchPage.clickSerachButton();
		 // Check if the value is present in the table
        boolean isPresent = adminUserSearchPage.isValuePresentInTable("Douglass");
        // Assert to verify the presence of the value
        assertTrue(isPresent, "User value not found in the search results table.");
}
}
