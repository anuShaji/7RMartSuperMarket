package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import pages.ManageUserResetPage;
import utilities.ExcelUtilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ManageUserResetTest extends Base {

	@Test
	public void verifyResetingTheTitle() throws IOException {
		String newsTitle = "This is an automation test by Anupama - Reset Test";
		String newsTitleToUpdate = "This is an automation test by Anupama - Reset Test2";

		// Log in
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"));
		loginPage.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1"));
		loginPage.clickSignInButton();

		// Navigate to Manage News page
		ManageNewsAddPage managePage = new ManageNewsAddPage(driver);
		managePage.clickManageNews();

		// Perform Reset Test
		ManageUserResetPage manageReset = new ManageUserResetPage(driver);
		manageReset.clickResetButton();

		// Update the news title and perform validation
		manageReset.updateNewsTitle(newsTitle, newsTitleToUpdate);

		// Validate if the success alert is displayed
		boolean alertDisplayed = manageReset.isAlertPresent();
		assertTrue(alertDisplayed, "Alert not displayed - unexpected error occurred");
	}
}
