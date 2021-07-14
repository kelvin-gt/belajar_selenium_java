import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestRun {

  @Test
  public void addQoute() {

    // download webdriver and setup
    WebDriverManager.chromedriver().setup();

    // namabahin incognito
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito", "--start-maximized");

    // inisialisasi webdriver
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();

    // buka web
    driver.get("http://bdd.atlasid.tech/");

    // input quote
//    By inputQuoteLocator = By.id("inputQuote");
//    WebElement inputQuote = driver.findElement(inputQuoteLocator);
    WebElement inputQuote = driver.findElementById("inputQuote");
    inputQuote.sendKeys("There is a will there is a way");

    // select color
    WebElement selectColor = driver.findElementById("colorSelect");
    Select select = new Select(selectColor);
    select.selectByVisibleText("Blue");

    // click ADD Quote
    WebElement buttonAddQuote = driver.findElementById("buttonAddQuote");
    buttonAddQuote.click();

    // get Quote Text
    List<WebElement> quotes = driver.findElementsByName("quoteText");
    WebElement quoteKedua = quotes.get(1);
    String actualQuote = quoteKedua.getText();
    Assert.assertEquals("There is a will there is a way",actualQuote);

    // tutup browser
    driver.quit();
  }

}
