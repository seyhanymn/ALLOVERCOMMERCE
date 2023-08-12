package test.US012;

import org.testng.annotations.Test;
import pages.YAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Test_02 extends TestBaseRapor {


    YAlloverPage yAlloverPage =new YAlloverPage();

    @Test
    public void test01() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("alloverUrl", "Web Raporlama");
        //Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Sayfaya basarili bir sekilde giris yapildi");

        //Sign in'e tıklanir
        Thread.sleep(2000);
        yAlloverPage.sign.click();
        //Gecerli bir email girilir
        yAlloverPage.email.sendKeys(ConfigReader.getProperty("alloverEmail"));
        //Gecerli bir password  girilir
        yAlloverPage.password.sendKeys(ConfigReader.getProperty("alloverPass"));
        extentTest.info("Dogru kullancı email ve password girildi");

        //Sig in'e tıklanir
        yAlloverPage.sign2.click();

        Thread.sleep(5000);
        //Sign Out tiklanir
        yAlloverPage.signOut.click();
        //Dowlands'a tıklanır
        yAlloverPage.dowlands.click();
        ReusableMethods.waitFor(2);
        //İndirimli ürün varsa listelenir
        ReusableMethods.getScreenshotWebElement("indirim yok", yAlloverPage.ekranresmi);
        extentTest.pass("İndirimli urunler bolumunun ekran goruntusu  basarili bir sekilde alindi");
        //Browser'i kapatir
       // Driver.quitDriver();


    }



    }

