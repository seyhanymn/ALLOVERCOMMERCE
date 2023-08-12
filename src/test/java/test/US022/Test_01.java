package test.US022;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.YAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Test_01 extends TestBaseRapor {

    Actions actions;

    YAlloverPage yAlloverPage;

    @Test
    public void test01() throws InterruptedException, IOException {
        actions=new Actions(Driver.getDriver());
        yAlloverPage=new YAlloverPage();

        extentTest = extentReports.createTest("alloverUrl", "Web Raporlama");
        //Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

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
        //Sayfada tumunu gor linkine tıklanir
        ReusableMethods.getScreenshotWebElement("tumunu gor yok", yAlloverPage.ekranresmi);
        extentTest.pass("Ekran goruntusu basarili bir sekilde alindi");

        Driver.quitDriver();
    }

    @Test
    public void test02() throws InterruptedException, IOException {
        actions=new Actions(Driver.getDriver());
        yAlloverPage=new YAlloverPage();

        extentTest = extentReports.createTest("alloverUrl", "Web Raporlama");
        //Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

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
        //İndirimli ürünlere tıklanır
        ReusableMethods.getScreenshotWebElement("indirimli urun yok", yAlloverPage.ekranresmi);
        extentTest.pass("Ekran goruntusu basarili bir sekilde alindi");
        Driver.quitDriver();

    }

    @Test
    public void test03() throws InterruptedException, IOException {
        actions=new Actions(Driver.getDriver());
        yAlloverPage=new YAlloverPage();

        extentTest = extentReports.createTest("alloverUrl", "Web Raporlama");
        //Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

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
        //Fiyata göre sırala
        ReusableMethods.getScreenshotWebElement("fiyata gore sirala", yAlloverPage.ekranresmi);
        extentTest.pass("Ekran goruntusu basarili bir sekilde alindi");
        Driver.quitDriver();

    }
}


