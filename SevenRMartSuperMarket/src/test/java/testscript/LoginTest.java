package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@Test
	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException {
		//String username = ExcelUtilities.readStringData(0, 1, "LoginPage1");
		String username="jjj";
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
		assertTrue(isHomePageLoaded, Constants.INVALID_USERNAME_OR_PASSWORD);

	}

	@Test
	public void verifyUserIsUnableToLoginWithInvalidPasswordAndValidUserName() {
		String username = "admin"; // Valid username
		String password = "admin123"; // Invalid password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		boolean isAlertLoaded = loginpage.isAlertDisplayed();
		assertTrue(isAlertLoaded, Constants.INVALID_USERNAME_OR_PASSWORD);
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
