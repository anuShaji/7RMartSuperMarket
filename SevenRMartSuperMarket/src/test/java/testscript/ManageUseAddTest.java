package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import utilities.ExcelUtilities;

public class ManageUseAddTest extends Base {
	HomePage homePage;
	ManageNewsAddPage managenewsaddpage;

	@Test
	@Parameters({"username","password"})
	public void verifyAddingNews(String username,String password) throws IOException {
		// Log in
		LoginPage loginPage = new LoginPage(driver);
//		String username = ExcelUtilities.readStringData(0, 1, "LoginPage1");
//		String password = ExcelUtilities.readStringData(1, 1, "LoginPage1");
		loginPage.enterUserNameField(username).enterPasswordField(password);
		homePage=loginPage.clickSignInButton();
		// Manage news
		managenewsaddpage = homePage.clickManageNews();
		managenewsaddpage.clikNewButton().
		enterNewsField("This is an automation test by anupama").clickSaveButton();
		
		boolean isAlertdisplayed = managenewsaddpage.isAlertDisplayed();
		assertTrue(isAlertdisplayed, Constants.UNABLETOADDERRORMSG);

	}
}
