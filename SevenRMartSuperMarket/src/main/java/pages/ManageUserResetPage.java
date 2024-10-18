package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUserResetPage {
	public WebDriver driver;

	public ManageUserResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextArea;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement newsTable;

	public ManageUserResetPage updateNewsTitle(String newsTitle, String newsTitleToUpdate) {
		List<WebElement> rows = newsTable
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr"));

		for (WebElement row : rows) {
			if (row.findElement(By.xpath("td[1]")).getText().contains(newsTitle)) {
				WebElement editButton = row.findElement(By.xpath(".//i[@class='fas fa-edit']"));
				editButton.click();
				newsTextArea.clear();
				newsTextArea.sendKeys(newsTitleToUpdate);
				updateButton.click();
				break; 
			}
		}
		return this;
	}
	public boolean isAlertPresent() {
		return alert.isDisplayed();
	}
}
