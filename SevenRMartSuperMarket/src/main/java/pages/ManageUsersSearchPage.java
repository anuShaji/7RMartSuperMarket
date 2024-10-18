package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersSearchPage {
	public WebDriver driver;

	public ManageUsersSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titleField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton2;

	public ManageUsersSearchPage enterNewsTitle(String newsTitle) {
		titleField.sendKeys(newsTitle);
		return this;
	}

	public ManageUsersSearchPage clickSearchButton2() {
		searchButton2.click();
		return this;
	}

	public boolean searchForNewsTitle(String newsTitle) {
		// gives the rows of the table
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr"));

		for (WebElement row : rows) {
			// get the text of the first column (the news title)
			String rowTitle = row.findElement(By.xpath("td[1]")).getText();

			// If the title matches, return true
			if (rowTitle.equals(newsTitle)) {
				return true;
			}
		}

		// Return false if the title is not found in any row
		return false;
	}

}
