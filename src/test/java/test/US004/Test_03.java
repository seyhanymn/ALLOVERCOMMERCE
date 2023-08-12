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

import static java.lang.System.out;

public class Test_03 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void test03() throws InterruptedException, IOException {

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
        ReusableMethods.waitFor(4);

        //  Anasayfadaki Add Cart buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.addCartButtonuAnasayfa);
        ReusableMethods.waitFor(4);

        // Add cart butonunda acilan Pop Up ta View Cart butununa tiklanir
        ilkerAlloverPage.addCartTiklaAcilanViewCartButonPopUp.click();
        ReusableMethods.waitFor(4);

        // Siparis edilen urunun stok durumu tespit edilir ve stok fazlasi urunun girilemedigi teyit edilir

        String siparisSubtotalIlk =  ilkerAlloverPage.siparisSubtotal.getText();
        out.println("siparisSubtotalIlk = " + siparisSubtotalIlk);
        String siparisAltToplam =  siparisSubtotalIlk.replace("$", "");
        double siprisAltToplamm = Double.parseDouble(siparisAltToplam);

        int actualUrunStokAdedi = Integer.parseInt(ilkerAlloverPage.viewCartUrunQuntity1Row.getAttribute("max"));
        out.println("actualUrunStokAdedi = " + actualUrunStokAdedi);

        int plusButtonClickCount=0;

        for (int i = 0 ; i < actualUrunStokAdedi+1; i++) {
            ilkerAlloverPage.urunMiktarArttirma1Row.click();
            plusButtonClickCount++;
            ReusableMethods.waitFor(1);
        }

        js.executeScript("arguments[0].click();",ilkerAlloverPage.updateCartButton);
        ReusableMethods.waitFor(4);
        out.println("plus button click adedi :"+plusButtonClickCount);

        int urununSiparisSonDurum = Integer.parseInt(ilkerAlloverPage.viewCartUrunQuntity1Row.getAttribute("value"));

        Assert.assertTrue(urununSiparisSonDurum < plusButtonClickCount);

        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();",ilkerAlloverPage.updateCartButton);
        ReusableMethods.waitFor(4);

        // Update carta basildiginda urunun Subtotal kisminin guncellendigi teyit edilir

        String siparisSubtotalSon =  ilkerAlloverPage.siparisSubtotal.getText();
        out.println("siparis Subtotal Son = " + siparisSubtotalSon);
        String siparisAltToplamSon = siparisSubtotalSon.replace("$", "");
        double siparisAltToplamSonn = Double.parseDouble(siparisAltToplamSon);

        Assert.assertTrue(siparisAltToplamSonn > siprisAltToplamm);
        ReusableMethods.waitFor(3);

        ilkerAlloverPage.viewCarttaClearCart.click();

    }

}







