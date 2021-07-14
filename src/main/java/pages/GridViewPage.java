package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GridViewPage {

    ChromeDriver driver;

    public GridViewPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getQuoteText(int index) {
        List<WebElement> quotes = driver.findElementsByName("quoteText");
        WebElement quoteKedua = quotes.get(index);
        String actualQuote = quoteKedua.getText();
        return actualQuote;
    }

}
