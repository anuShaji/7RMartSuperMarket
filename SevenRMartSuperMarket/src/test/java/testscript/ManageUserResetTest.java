package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import pages.ManageUserResetPage;
import utilities.ExcelUtilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ManageUserResetTest extends Base {
HomePage homepage;
ManageNewsAddPage managenewsaddpage;
ManageUserResetPage manageReset;
	@Test
	@Parameters({"username","password"})
	public void verifyResetingTheTitle(String username,String password) throws IOException {
		String newsTitle = "This is an automation test by Anupama - Reset Test";
		String newsTitleToUpdate = "This is an automation test by Anupama - Reset Test2";

		// Log in
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(username).enterPasswordField(password);
		homepage=loginPage.clickSignInButton();
		managenewsaddpage=homepage.clickManageNews();
		manageReset=homepage.clickResetButton();

		// Update the news title and perform validation
		manageReset.updateNewsTitle(newsTitle, newsTitleToUpdate);

		// Validate if the success alert is displayed
		boolean alertDisplayed = manageReset.isAlertPresent();
		assertTrue(alertDisplayed, "Alert not displayed - unexpected error occurred");
	}
}
