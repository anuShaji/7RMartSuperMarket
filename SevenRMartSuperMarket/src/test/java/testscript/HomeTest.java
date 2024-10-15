package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base {
	HomePage homepage;

	@Test
	@Parameters({ "username", "password" })
	public void verifyIsUserAbleToLogOut(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginpage.clickSignInButton();
		homepage.clickAdminLogo();
		homepage.clickLogoutButton();
		assertEquals(driver.getTitle(), "Login | 7rmart supermarket", "Logout Failed !");
	}
}
