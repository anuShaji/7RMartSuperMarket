package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminUsersPage;
	@Test
	@Parameters({"username","password"})
	public void verifyAddingANewUser(String username,String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage=loginpage.clickSignInButton();
		adminUsersPage=homepage.clickAdminUserModule();
		adminUsersPage.clickManageUsersSubModule();
		adminUsersPage.clickAddNewUser();
		adminUsersPage.enterUserName("AnupamachainingTest");
		adminUsersPage.enterPassword("password@123");
		adminUsersPage.selectUserType(4);
		adminUsersPage.clickSaveButton();
		boolean alertDisplayed=adminUsersPage.isAlertDisplayed();
		assertTrue(alertDisplayed,"Username Already Exists");
		
		
	}
}
