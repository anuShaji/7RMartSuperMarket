package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

    private WebDriver driver;

    public PageUtilities(WebDriver driver) {
        this.driver = driver;
    }

    // Select option from dropdown by visible text
    public void selectByVisibleText(WebElement dropdown, String visibleText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    // Select option from dropdown by value
    public void selectByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    // Select option from dropdown by index
    public void selectByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    // Perform drag-and-drop action from source to target element
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Perform a mouse hover over an element
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Perform a double-click action on an element
    public void doubleClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Perform a right-click (context click) on an element
    public void rightClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    
}
