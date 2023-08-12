package test.US004;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IlkerAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class Test_02 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test02() throws InterruptedException, IOException {

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

        // Ilk urunun siparis adedi bir arttirilir

        int actualGirilenUrunAdedi = Integer.parseInt(ilkerAlloverPage.viewCartUrunQuntity1Row.getAttribute("value"));
        out.println("actualGirilenUrunAdedi = " + actualGirilenUrunAdedi);

        ilkerAlloverPage.urunMiktarArttirma1Row.click();
        ReusableMethods.waitFor(4);

        ilkerAlloverPage.updateCartButton.click();
        ReusableMethods.waitFor(4);

        // Ilk urunun siparis adedinin arttigi teyid edilir

        int arttirmadanSonraUrunAdedi = Integer.parseInt(ilkerAlloverPage.viewCartUrunQuntity1Row.getAttribute("value"));
        out.println("arttirmadanSonraUrunAdedi = " + arttirmadanSonraUrunAdedi);

        Assert.assertTrue(arttirmadanSonraUrunAdedi > actualGirilenUrunAdedi);
        ReusableMethods.waitFor(4);

        // Ilk urunun siparis adedi bir azaltilir

        int actualGirilenUrunAdediAzaltma = Integer.parseInt(ilkerAlloverPage.viewCartUrunQuntity1Row.getAttribute("value"));
        out.println("actualGirilenUrunAdediAzaltma = " + actualGirilenUrunAdedi);

        ilkerAlloverPage.urunMiktarAzaltma1Row.click();
        ReusableMethods.waitFor(4);

        ilkerAlloverPage.updateCartButton.click();
        ReusableMethods.waitFor(5);

        // Ilk urunun siparis adedinin arttigi teyid edilir

        int azaltmadanSonraUrunAdedi = Integer.parseInt(ilkerAlloverPage.viewCartUrunQuntity1Row.getAttribute("value"));
        out.println("azaltmadanSonraUrunAdedi = " + arttirmadanSonraUrunAdedi);
        ReusableMethods.waitFor(2);

        Assert.assertTrue(azaltmadanSonraUrunAdedi < actualGirilenUrunAdediAzaltma);
        ReusableMethods.waitFor(2);

        ilkerAlloverPage.viewCarttaClearCart.click();


    }
}

