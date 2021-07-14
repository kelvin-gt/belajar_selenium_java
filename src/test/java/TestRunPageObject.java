import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.GridViewPage;
import pages.TableViewPage;
import pages.WebPlayGroundHomePage;
import webdriverpool.WebDriverInitializer;

// Belajar Tes TDD
public class TestRunPageObject {

  @Before
  public void inisialisasiWebDriver() {
    WebDriverInitializer.initialize();
  }

  @After
  public void quit() {
    // tutup browser
    WebDriverInitializer.quit();
  }

  @Test
  public void addQoute() {

    // Membuat object
    WebPlayGroundHomePage homePage = new WebPlayGroundHomePage(WebDriverInitializer.driver);
    GridViewPage gridViewPage = new GridViewPage(WebDriverInitializer.driver);

    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("Blue");
    homePage.clickButtonAddQuote();

    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals("There is a will there is a way",actualQuote);

  }

  @Test
  public void addQuoteWIthBlueColor() {

    // Membuat object
    WebPlayGroundHomePage homePage = new WebPlayGroundHomePage(WebDriverInitializer.driver);
    GridViewPage gridViewPage = new GridViewPage(WebDriverInitializer.driver);

    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("Blue");
    homePage.clickButtonAddQuote();

    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals("There is a will there is a way",actualQuote);

//    // Membuat pause
//    try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }

  @Test
  public void addQuoteWIthYellowColor() {

    // Membuat object
    WebPlayGroundHomePage homePage = new WebPlayGroundHomePage(WebDriverInitializer.driver);
    GridViewPage gridViewPage = new GridViewPage(WebDriverInitializer.driver);

    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("Yellow");
    homePage.clickButtonAddQuote();

    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals("There is a will there is a way",actualQuote);
  }


  @Test
  public void hoverShowTableButton() {
    WebPlayGroundHomePage homePage = new WebPlayGroundHomePage(WebDriverInitializer.driver);
    TableViewPage tableViewPage = new TableViewPage(WebDriverInitializer.driver);

    homePage.openPage();
    tableViewPage.clickTableView();
    tableViewPage.hoverShowTableBtn();
    boolean hasil = tableViewPage.isTableShow();
    Assert.assertTrue(hasil);
  }

  @Test
  public void clickButtonShowTableAfterTenSec() {
    WebPlayGroundHomePage homePage = new WebPlayGroundHomePage(WebDriverInitializer.driver);
    TableViewPage tableViewPage = new TableViewPage(WebDriverInitializer.driver);

    homePage.openPage();
    tableViewPage.clickTableView();
    tableViewPage.clickButtonShowTableAfterTenSec();
    boolean hasil = tableViewPage.isTableShow();
    Assert.assertTrue(hasil);
  }

  @Test
  public void switchTab() {
    WebPlayGroundHomePage homePage = new WebPlayGroundHomePage(WebDriverInitializer.driver);

    homePage.openPage();
    homePage.clickPoweredByLink();
    String title = homePage.getAtlasTitle();
    System.out.println(title);
    Assert.assertEquals("Atlas ID – Automatin Testing Learning and Sharing Indonesia", title);
  }

}
