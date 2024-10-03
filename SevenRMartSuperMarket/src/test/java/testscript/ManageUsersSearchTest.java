package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import pages.ManageUsersSearchPage;
import utilities.ExcelUtilities;

public class ManageUsersSearchTest extends Base{
	@Test
	public void verifySearchingAValidNews() throws IOException {
		String newsTitle="This is an automation test by anupama";
		// Log in
				LoginPage loginPage = new LoginPage(driver);
				loginPage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"));
				loginPage.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1")); 
				loginPage.clickSignInButton();
				ManageNewsAddPage managepage=new ManageNewsAddPage(driver);
				managepage.clickManageNews();
				ManageUsersSearchPage userTest=new ManageUsersSearchPage(driver);
				userTest.clickSearchButton();
				userTest.enterNewsTitle(newsTitle);
				userTest.clickSearchButton2();
				boolean isSearchFound=userTest.searchForNewsTitle(newsTitle);
				assertTrue(isSearchFound,Constants.NOMATCHFOUND);
	}
	
}
