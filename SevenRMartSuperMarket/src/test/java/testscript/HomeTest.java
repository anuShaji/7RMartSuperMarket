package testscript;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base{

	@Test
	public void verifyIsUserAbleToLogOut() {
		String username="admin";
		String password="admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		HomePage homepage=new HomePage(driver);
		homepage.clickAdminLogo();
		homepage.clickLogoutButton();
        assertEquals(driver.getTitle(),"Login | 7rmart supermarket", "Logout Failed !");
	}
}
