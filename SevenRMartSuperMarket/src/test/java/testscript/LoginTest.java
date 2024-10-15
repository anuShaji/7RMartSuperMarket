package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@DataProvider(name = "credentials", indices = { 0, 1 })
//	public Object[][] testData() {// data provider
//		Object[][] input = new Object[2][2];
//		input[0][0] = "admin";
//		input[0][1] = "admin";
//		input[1][0] = "admin@123";
//		input[1][1] = "admin123";
//		return input;
//		}
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "adminrr", "admiwwn" }, { "admin22", "admin22" },
				{ "admin11", "adminbb" }

		};
		return data;
	}

	@Test(dataProvider = "credentials")
	public void verifyUserIsAbleToLoginUsingValidCredentials(String username, String password) throws IOException {
//		String username = ExcelUtilities.readStringData(0, 1, "LoginPage1");
//		String password = ExcelUtilities.readStringData(1, 1, "LoginPage1");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
		assertTrue(isHomePageLoaded, Constants.INVALID_USERNAME_OR_PASSWORD);

	}

	@Test(groups = { "smoke" })
	@Parameters({ "username", "password" })
	public void verifyUserIsUnableToLoginWithInvalidPasswordAndValidUserName(String username, String password) {
//		String username = "admin"; // Valid username
//		String password = "admin123"; // Invalid password
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
	@Parameters({ "invalidUSername", "password" })
	public void verifyUserIsUnableToLoginWithValidPasswordAndInalidUserName(String invalidUSername, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(invalidUSername);
		loginpage.enterPasswordField(password);
		loginpage.clickSignInButton();
//		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
//		assertFalse(isHomePageLoaded, "Home page not loaded due to entering invalid credentials");
		boolean alertLoaded = loginpage.isAlertDisplayed();
		assertTrue(alertLoaded, Constants.INVALID_USERNAME_OR_PASSWORD);
	}

	@Test
	@Parameters({ "invalidUSername", "invalidPassword" })
	public void verifyUserIsUnableToLoginWithInvalidCredentials(String invalidUSername, String invalidPassword) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(invalidUSername);
		loginpage.enterPasswordField(invalidPassword);
		loginpage.clickSignInButton();
//		boolean isHomePageLoaded = loginpage.isDashboardLoaded();
//		assertFalse(isHomePageLoaded, "Home page not loaded due to entering invalid credentials");
		boolean alertLoaded = loginpage.isAlertDisplayed();
		assertTrue(alertLoaded, Constants.INVALID_USERNAME_OR_PASSWORD);
	}

}
