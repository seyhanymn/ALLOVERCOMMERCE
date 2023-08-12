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

import java.util.List;

import static java.lang.System.out;

public class Test_03 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test03 () throws InterruptedException {

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
        ReusableMethods.waitFor(3);

        //  Ana sayfadaki Add Cart buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.addCartButtonuAnasayfa);

        // Add cart butonunda acilan Pop Up ta View Cart butununa tiklanir
        js.executeScript("arguments[0].click();",ilkerAlloverPage.addCartTiklaAcilanViewCartButonPopUp);
        ReusableMethods.waitFor(3);

        // View cart butununa basdiktan sonra acilan sayfada Checkout'a gidilir
        ilkerAlloverPage.viewCarttaCheckoutTikla.click();
        ReusableMethods.waitFor(3);

        // Checkout sayfasinda oldugumuz dogrulanir
        String actualPagetitle = Driver.getDriver().getTitle();
        String expectedPageTitle = "Checkout - Allover Commerce";
        Assert.assertEquals(actualPagetitle,expectedPageTitle);

        js.executeScript("arguments[0].click();", ilkerAlloverPage.myAccountaSignOutIleGit);
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].scrollIntoView(true);", ilkerAlloverPage.anaSayfaSonuMyAccount);
        js.executeScript("arguments[0].click();", ilkerAlloverPage.logOutMyAccountSayfasinda);
        ReusableMethods.waitFor(3);

        }

    }







