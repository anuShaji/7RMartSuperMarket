package testscript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base {
	@Test
	public void verifyUserIsAbleToLoginUsingValidCredentials() {
		String username = "admin";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
		assertTrue(isHomePageLoaded, "Home page not loaded due to entering invalid credentials");
	}

	@Test
	public void verifyUserIsUnableToLoginWithInvalidPasswordAndValidUserName() {
		String username = "admin"; // Valid username
		String password = "admin123"; // Invalid password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		boolean alertLoaded = loginpage.isAlertDisplayed();
		assertTrue(alertLoaded, "Home page should not load when logging in with invalid password");
//		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
//		assertFalse(isHomePageLoaded, "Home page not loaded due to entering invalid credentials");
	}

	@Test
	public void verifyUserIsUnableToLoginWithValidPasswordAndInalidUserName() {
		String username = "hhhhh"; // Valid username
		String password = "admin"; // Invalid password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
//		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
//		assertFalse(isHomePageLoaded, "Home page not loaded due to entering invalid credentials");
		boolean alertLoaded = loginpage.isAlertDisplayed();
		assertTrue(alertLoaded, "Home page should not load when logging in with invalid username");
	}

	@Test
	public void verifyUserIsUnableToLoginWithInvalidCredentials() {
		String username = "ssss"; // Valid username
		String password = "ddddd"; // Invalid password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
//		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
//		assertFalse(isHomePageLoaded, "Home page not loaded due to entering invalid credentials");
		boolean alertLoaded = loginpage.isAlertDisplayed();
		assertTrue(alertLoaded, "Home page should not load when logging in with invalid credentials");
	}

}
