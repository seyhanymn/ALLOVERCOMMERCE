package test.US021;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FettahAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class Test_04 extends TestBaseRapor {

    FettahAlloverPage fettahAlloverPage = new FettahAlloverPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Satış Raporlarının İncelebilmesi Testi", "Bir önceki ayın raporu incelendi");

        // 1) Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("İlgili web sitesine gidildi");

        // 2) Ana sayfanın göründüğü doğrulanır
        String expectedUrl = "https://allovercommerce.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        extentTest.info("Ana sayfanın görüntülendiği doğrulandı");

        // 3) Sing In butonuna tıklanır
        fettahAlloverPage.ilkSayfaSignInLink.click();
        extentTest.info("Sign In butonuna tıklandı");

        // 4) E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır
        wait.until(ExpectedConditions.visibilityOf(fettahAlloverPage.signInMailBox));
        wait.until(ExpectedConditions.visibilityOf(fettahAlloverPage.signInPasswordBox));
        Assert.assertTrue(fettahAlloverPage.signInMailBox.isDisplayed());
        Assert.assertTrue(fettahAlloverPage.signInPasswordBox.isDisplayed());
        extentTest.info("E-mail ve password textboxlarının açıldığı doğrulandı");

        // 5) Açılan pencerede ilgili kısımlara geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır
        fettahAlloverPage.signInMailBox.sendKeys(ConfigReader.getProperty("alloverEmail"));
        fettahAlloverPage.signInPasswordBox.sendKeys(ConfigReader.getProperty("alloverPass"));
        fettahAlloverPage.signInOnayButton.click();
        extentTest.info("E-mail ve password textboxlarına geçerli değerler girildi");


        // 6) Başarıyla giriş yapıldığı doğrulanır
        Assert.assertTrue(fettahAlloverPage.signOutLink.isDisplayed());
        extentTest.info("Giriş yapıldığı doğrulandı");

        // 7) Sağ üst taraftaki Sing Out seçeneğine tıklanır
        fettahAlloverPage.signOutLink.click();

        // 8) Açılan sayfada Store Manager seçeneğine tıklanır
        fettahAlloverPage.storeManagerLink.click();
        extentTest.info("Store Manager bölümüne gidildi");

        // 9) Store Manager penceresindeyken Reports sekmesine tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", fettahAlloverPage.reportsLink);
        jse.executeScript("arguments[0].click();", fettahAlloverPage.reportsLink);
        extentTest.info("Reports sekmesine tıklandı");

        // 10) Last 7 Days sekmesine tıklanır ve ilgili raporun göründüğü doğrulanır
        fettahAlloverPage.last7DaysLink.click();
        Assert.assertTrue(fettahAlloverPage.rapor.isDisplayed());
        extentTest.info("Son 7 günün raporu incelendi");

        Driver.quitDriver();
    }
}
