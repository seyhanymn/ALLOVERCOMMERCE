package test.US003;


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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.openqa.selenium.devtools.v97.dom.DOM.querySelector;

public class Test_01 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test01() throws InterruptedException {

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

        // Browse Product / Go Shop'a tikladiktan sonra acilan sayfada Shop yazisini text olarak gorurdugunu dogrular
        Assert.assertTrue(ilkerAlloverPage.goShopIleAcilanSayfadakiShopText.isDisplayed());
        out.println(Driver.getDriver().getTitle()); //Shop - Allover Commerce


        js.executeScript("arguments[0].click();", ilkerAlloverPage.myAccountaSignOutIleGit);
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].scrollIntoView(true);", ilkerAlloverPage.anaSayfaSonuMyAccount);
        js.executeScript("arguments[0].click();", ilkerAlloverPage.logOutMyAccountSayfasinda);
        ReusableMethods.waitFor(3);

    }
}
