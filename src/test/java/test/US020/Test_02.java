package test.US020;

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

public class Test_02 extends TestBaseRapor {

    FettahAlloverPage fettahAlloverPage = new FettahAlloverPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Yorumların İncelenebilmesi Testi", "Yorumlar görüntülendi");

        //      1. Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("İlgili web sitesine gidildi");

        //      2. Ana sayfanın göründüğü doğrulanır
        String expectedUrl = "https://allovercommerce.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        extentTest.info("Ana sayfanın görüntülendiği doğrulandı");

        //      3. Sing In butonuna tıklanır
        fettahAlloverPage.ilkSayfaSignInLink.click();
        extentTest.info("Sign In butonuna tıklandı");

        //      4. E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır
        wait.until(ExpectedConditions.visibilityOf(fettahAlloverPage.signInMailBox));
        wait.until(ExpectedConditions.visibilityOf(fettahAlloverPage.signInPasswordBox));
        Assert.assertTrue(fettahAlloverPage.signInMailBox.isDisplayed());
        Assert.assertTrue(fettahAlloverPage.signInPasswordBox.isDisplayed());
        extentTest.info("E-mail ve password textboxlarının açıldığı doğrulandı");

        //      5. Açılan pencerede ilgili kısımlara geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır
        fettahAlloverPage.signInMailBox.sendKeys(ConfigReader.getProperty("alloverEmail"));
        fettahAlloverPage.signInPasswordBox.sendKeys(ConfigReader.getProperty("alloverPass"));
        fettahAlloverPage.signInOnayButton.click();
        extentTest.info("E-mail ve password textboxlarına geçerli değerler girildi");

        //      6. Başarıyla giriş yapıldığı doğrulanır
        Assert.assertTrue(fettahAlloverPage.signOutLink.isDisplayed());
        extentTest.info("Başarıyla giriş yapıldığı doğrulandı");

        //      7. Sağ üst taraftaki Sing Out seçeneğine tıklanır
        fettahAlloverPage.signOutLink.click();

        //      8. Açılan sayfada Store Manager seçeneğine tıklanır
        fettahAlloverPage.storeManagerLink.click();
        extentTest.info("Store Manager bölümüne gidildi");

        //      9. Store Manager penceresindeyken Reviews sekmesine tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", fettahAlloverPage.reviewsLink);
        jse.executeScript("arguments[0].click();", fettahAlloverPage.reviewsLink);
        extentTest.info("Reviews sekmesine tıklandı");


        //      10. Açılan ekranda Product Reviews butonuna tıklanır
        fettahAlloverPage.productReviewsLink.click();
        extentTest.info("Product Reviews butonuna tıklandı");

        //      11) Rating sekmesi altında puanlamanın, Dated sekmesi altında da tarihin görüntülendiği doğrulanır
        Assert.assertTrue(fettahAlloverPage.ratingText.isDisplayed());
        Assert.assertTrue(fettahAlloverPage.datedText.isDisplayed());
        extentTest.info("Puanlamanın ve tarihin görüntülendiği doğrulandı");

        Driver.quitDriver();

    }
}
