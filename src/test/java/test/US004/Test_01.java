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

public class Test_01 {

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

        // 2 urun secilir ve sepete eklenir

        WebElement selectElement = Driver.getDriver().findElement(By.xpath("//select[@name='count']"));
        Select option = new Select(selectElement);
        option.selectByValue("36");
        Thread.sleep(2000);

        js.executeScript("arguments[0].click();",ilkerAlloverPage.addCartIleUrunEkle5);
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();",ilkerAlloverPage.addCartIleUrunEkle1);
        ReusableMethods.waitFor(3);

        //  Anasayfadaki Add Cart buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.addCartButtonuAnasayfa);
        ReusableMethods.waitFor(3);

        // Add cart butonunda acilan Pop Up ta View Cart butununa tiklanir
        ilkerAlloverPage.addCartTiklaAcilanViewCartButonPopUp.click();
        ReusableMethods.waitFor(3);

        // Sepette urunlerin goruldugu dogrulanir
        ReusableMethods.getScreenshotWebElement("View Cart Urunler", ilkerAlloverPage.viewCarttaCheckoutTikla);
        ReusableMethods.waitFor(5);

        js.executeScript("arguments[0].click();", ilkerAlloverPage.viewCarttaClearCart);


    }

}










