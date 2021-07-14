package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebPlayGroundHomePage {

    // Variabel Global
    ChromeDriver driver;

    public WebPlayGroundHomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://bdd.atlasid.tech/");
    }


    public void inputQuote(String quote){
        WebElement inputQuote = driver.findElementByCssSelector("#inputQuote");
        inputQuote.sendKeys(quote);
    }

    public void selectColor(String color){
        WebElement selectColor = driver.findElementByXPath("//select[@id='colorSelect']");
        Select select = new Select(selectColor);
        select.selectByVisibleText(color);
    }

    public void clickButtonAddQuote(){
        WebElement buttonAddQuote = driver.findElementById("buttonAddQuote");
        buttonAddQuote.click();
    }

    public void clickPoweredByLink(){
        WebElement poweredByLink = driver.findElementById("poweredBy");
        poweredByLink.click();
    }

    public String getAtlasTitle(){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        String title = driver.getTitle();
        return title;
    }

}
