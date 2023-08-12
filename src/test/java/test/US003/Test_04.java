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

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

public class Test_04 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void test04 () throws InterruptedException, IOException {

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sign in buttonun'a tıklanır
        ilkerAlloverPage.anasayfaSignInButton.click();

        //Açılan Pop Up pencerede "Username or email address" box'a gecerli email gonderilir
        ilkerAlloverPage.signInEmailAdresBoxPopUp.sendKeys(ConfigReader.getProperty("alloverEmail"));
        ReusableMethods.waitFor(2);

        //Açılan Pop Up pencerede "passwords" box'a gecerli password gonderilir
        ilkerAlloverPage.signInPasswordBoxPopUp.sendKeys(ConfigReader.getProperty("alloverPass"));

        // Açılan Pop Up pencerede "sign in"submit buttonuna tiklanir
        ilkerAlloverPage.signInSubmitPopUp.click();
        Thread.sleep(2000);

        //  Ana sayfadaki Add Cart buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.addCartButtonuAnasayfa);
        ReusableMethods.waitFor(3);

        // Add cart butonunda acilan Pop Up ta View Cart butununa tiklanir
        ilkerAlloverPage.addCartTiklaAcilanViewCartButonPopUp.click();
        ReusableMethods.waitFor(3);

        // View cart butununa basdiktan sonra acilan sayfada Checkout'a gidilir
        ilkerAlloverPage.viewCarttaCheckoutTikla.click();
        ReusableMethods.waitFor(3);

       // Billing Details bilgileri doldurulur
        ilkerAlloverPage.billingDetailsFirstName.clear();

        actions.sendKeys(ilkerAlloverPage.billingDetailsFirstName, faker.name().firstName()).
                        sendKeys(Keys.TAB).
                        sendKeys(faker.name().lastName()).
                        sendKeys(Keys.TAB).
                        sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys("Ukraine").
                        sendKeys(Keys.TAB).
                        sendKeys(Keys.TAB).
                        sendKeys(faker.address().streetAddress()).
                        sendKeys(Keys.TAB).
                        sendKeys(faker.address().buildingNumber()).
                        sendKeys(Keys.TAB).
                        sendKeys(faker.address().city()).
                        sendKeys(Keys.TAB).sendKeys("Donetsk Oblast").
                        sendKeys(Keys.TAB).
                        sendKeys(faker.address().zipCode()).
                        sendKeys(Keys.TAB).
                        sendKeys(faker.phoneNumber().phoneNumber()).
                        sendKeys(Keys.TAB).
                        sendKeys("timetoteam23@gmail.com").
                        sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                        sendKeys("Hocamm! teste devam.. ").perform();

        // Billing'e girilen bilgilerin goruldugu teyit edilir
        ReusableMethods.getScreenshotWebElement("Billings details", ilkerAlloverPage.billingDetailsTable);

        js.executeScript("arguments[0].click();", ilkerAlloverPage.myAccountaSignOutIleGit);
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].scrollIntoView(true);", ilkerAlloverPage.anaSayfaSonuMyAccount);
        js.executeScript("arguments[0].click();", ilkerAlloverPage.logOutMyAccountSayfasinda);
        ReusableMethods.waitFor(3);




    }



    }







