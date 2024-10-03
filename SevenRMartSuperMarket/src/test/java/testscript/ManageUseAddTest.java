package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import utilities.ExcelUtilities;

public class ManageUseAddTest extends Base {
	@Test
	public void verifyAddingNews() throws IOException {
		// Log in
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"));
		loginPage.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1")); 
		loginPage.clickSignInButton();
		// Manage news
		ManageNewsAddPage managepage=new ManageNewsAddPage(driver);
		managepage.clickManageNews();
		managepage.clikNewButton();
		managepage.enterNewsField("This is an automation test by anupama");
		managepage.clickSaveButton();
		boolean isAlertdisplayed=managepage.isAlertDisplayed();
		assertTrue(isAlertdisplayed,Constants.UNABLETOADDERRORMSG);
	}
}
