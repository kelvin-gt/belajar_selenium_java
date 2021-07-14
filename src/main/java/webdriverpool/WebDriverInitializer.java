package webdriverpool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverInitializer {

    // Instance / Global Variabel
    public static ChromeDriver driver;

    public static void initialize(){

        // download webdriver and setup
        WebDriverManager.chromedriver().setup();

        // namabahin incognito
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized");

        // inisialisasi webdriver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void quit() {
        // tutup browser
        driver.quit();
    }
}
