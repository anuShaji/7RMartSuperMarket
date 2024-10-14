package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.AdminUsersSearchPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersSearchTest extends Base {
	HomePage homepage;
	AdminUsersPage adminpage;
	AdminUsersSearchPage adminsearch;
	@Test
	@Parameters({"username","password"})
public void verifySearchingAnExistingUserAndTypeCombination(String username,String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage=loginpage.clickSignInButton();
		
		adminpage=homepage.clickAdminUserModule();
		adminpage.clickManageUsersSubModule();
		adminsearch=homepage.clickAdminUserSearchButton();
		adminsearch.enterUserName("Gukesh Kathlyn");
		adminsearch.selectUserType(2);
		adminsearch.clickSerachButton();
		 // Check if the value is present in the table
        boolean isPresent = adminsearch.isValuePresentInTable("Gukesh Kathlyn");
        // Assert to verify the presence of the value
        assertTrue(isPresent, "User value not found in the search results table.");
}
}
