package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableViewPage {

    ChromeDriver driver;

    public TableViewPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void clickTableView() {
        WebElement tableViewTab = driver.findElementById("tableView");
        tableViewTab.click();
    }

    public void hoverShowTableBtn() {
        WebElement buttonShowTable = driver.findElementById("buttonShowTable");
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonShowTable).pause(5000).build().perform();
    }

    public boolean isTableShow() {
        By locatorTable = By.id("tableQuote");
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTable));

//    WebElement table = driver.findElementById("tableQuote");
        boolean result = table.isDisplayed();
        return result;
    }

    public void clickButtonShowTableAfterTenSec() {
        WebElement buttonYellow = driver.findElementById("buttonShowAfterTen");
        buttonYellow.click();
    }
}
