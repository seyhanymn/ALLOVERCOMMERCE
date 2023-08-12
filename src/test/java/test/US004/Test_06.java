package test.US004;


import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IlkerAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Test_06 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void test01() throws InterruptedException, IOException {

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sign in buttonun'a tıklanır
        ilkerAlloverPage.anasayfaSignInButton.click();

        //Açılan Pop Up pencerede "Username or email address" box'a gecerli email gonderilir
        ilkerAlloverPage.signInEmailAdresBoxPopUp.sendKeys(ConfigReader.getProperty("alloverEmail"));

        //Açılan Pop Up pencerede "passwords" box'a gecerli password gonderilir
        ilkerAlloverPage.signInPasswordBoxPopUp.sendKeys(ConfigReader.getProperty("alloverPass"));

        // Açılan Pop Up pencerede "sign in"submit buttonuna tiklanir
        ilkerAlloverPage.signInSubmitPopUp.click();
        Thread.sleep(2000);

        // Ana sayfa'da My Account'a giris yapmak icin Sign Out buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.myAccountaSignOutIleGit);

        // My Account sayfasinda Orders'a tiklar
        ilkerAlloverPage.myAccountSayfasindaOrders.click();

        // Orders'a tikladiktan sonra acilan sayfada Browse Products / Go Shop'a tiklar
        js.executeScript("arguments[0].click();", ilkerAlloverPage.ordersSayfasindaGoShopButtonu);

        // 1 urun secilir ve sepete eklenir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.addCartIleUrunEkle1);
        ReusableMethods.waitFor(3);

        //  Anasayfadaki Add Cart buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.addCartButtonuAnasayfa);
        ReusableMethods.waitFor(3);

        // Add cart butonunda acilan Pop Up ta View Cart butununa tiklanir
        ilkerAlloverPage.addCartTiklaAcilanViewCartButonPopUp.click();
        ReusableMethods.waitFor(4);

        // Acilan sayfada sag tarafta shipping ve total rakam bilgilerinin oldugu teyit edilir

        Assert.assertTrue(ilkerAlloverPage.sagTarafShippingVeTotalRakam.isDisplayed());

        ReusableMethods.getScreenshotWebElement("Sag taraf shipping_total bilgi", ilkerAlloverPage.sagTarafShippingVeTotalRakam);




     }



    }







