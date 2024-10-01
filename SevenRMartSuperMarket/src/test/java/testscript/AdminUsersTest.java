package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	@Test
	public void verifyAddingANewUser() {
		String username = "admin";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickAdminUserModule();
		adminUsersPage.clickManageUsersSubModule();
		adminUsersPage.clickAddNewUser();
		adminUsersPage.enterUserName("AnupamaTest");
		adminUsersPage.enterPassword("password@123");
		adminUsersPage.selectUserType(4);
		adminUsersPage.clickSaveButton();
		boolean alertDisplayed=adminUsersPage.isAlertDisplayed();
		assertTrue(alertDisplayed,"Username Already Exists");
		
		
	}
}
