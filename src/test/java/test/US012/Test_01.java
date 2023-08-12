package test.US012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.YAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class Test_01 extends TestBaseRapor {

    Actions actions=new Actions(Driver.getDriver());
    List<String> list;

    YAlloverPage yAlloverPage =new YAlloverPage();

    @Test
    public void test01() throws InterruptedException {
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
        //Sign Out tiklanir
        yAlloverPage.signOut.click();


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Orders bölümüne tıklanır
        yAlloverPage.orders.click();
        extentTest.info("Siparisler listesine click yapildi") ;
        ReusableMethods.waitFor(2);

        //Sipariş edilen ürünleri listeler

        list = new ArrayList<>();
        for (WebElement w : yAlloverPage.liste) {
            list.add(w.getText());

        }
        list.forEach(System.out::println);
        extentTest.pass("Siparisler basarili bir sekilde listelendi");
        //Browser'i kapatir
       // Driver.quitDriver();

    }

    }
