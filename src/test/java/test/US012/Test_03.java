package test.US012;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.YAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class Test_03 extends TestBaseRapor {

    YAlloverPage yAlloverPage =new YAlloverPage();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    List<String> list;

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web Raporlama");
        //Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Sayfaya basarili bir sekilde giris yapildi");

        //Sign in'e tıklanir
        Thread.sleep(2000);
        yAlloverPage.sign.click();
        //Gecerli bir email girilir
        yAlloverPage.email.sendKeys(ConfigReader.getProperty("alloverEmail"));
        //Gecerli bir password girilir
        yAlloverPage.password.sendKeys(ConfigReader.getProperty("alloverPass"));
        extentTest.info("Dogru kullancı email ve password girildi");

        //Sig in'e tıklanir
        yAlloverPage.sign2.click();

        //Sign Out tiklanir
        yAlloverPage.signOut.click();
        Thread.sleep(2000);
        //Adresler bölümüne tiklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", yAlloverPage.adresler);
        jse.executeScript("arguments[0].click();", yAlloverPage.adresler);
        Thread.sleep(2000);
        extentTest.info("Adresler bolumune click yapildi");
        //Fatura ve adres bilgilerini listeler
        list = new ArrayList<>();
        for (WebElement w : yAlloverPage.bulıngadres) {
            list.add(w.getText());
        }
        for (WebElement w : yAlloverPage.shıppınadres){
            list.add(w.getText());
        }

        list.forEach(System.out::println);
        extentTest.pass("Adresler basarili bir sekilde listelendi");
        //Browser kapatılır
       // Driver.quitDriver();
    }



    }

