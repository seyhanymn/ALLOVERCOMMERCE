package test.US016;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ZeynepAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_03 extends TestBaseRapor {
    ZeynepAlloverPage zeynepAlloverPage = new ZeynepAlloverPage();

    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();
    //"Register"a Tıkla
    //"Sign In"a Tıkla
    //Gecerli email gir
    //Gecerli password gir
    //"Sign In" butonuna tıkla.
    //"Sign Out"a tıkla.
    //"Store Manager"e Tıkla.
    //"Customer"a Tıkla.
    //"Add New" butonuna tıklanmalı.
    //"Add Customer" altında "UserName" ekleniyor mu tes et.
    //"Add Customer" altında "Email" ekleniyor mu tes et.
    //"Add Customer" altında "FirstName" ekleniyor mu test et.
    //"Add Customer" altında "LastName" ekleniyor mu tes et.
    //"Submit" butonuna tıklanıyor mu test et.
    // Sayfayı yenileyip "Customer" listesi görünüyor mu test et.
    //Browser'i kapat.

    @Test
    public void customerPage() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        zeynepAlloverPage.signIn.click();
        zeynepAlloverPage.emailTextBox.sendKeys(ConfigReader.getProperty("alloverEmail"));
        zeynepAlloverPage.passwordTextBox.sendKeys(ConfigReader.getProperty("alloverPass"));
        zeynepAlloverPage.signIn2.click();
        zeynepAlloverPage.singOut.click();
        zeynepAlloverPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(zeynepAlloverPage.customers).click().perform();
        Thread.sleep(1000);
    }

    @Test (dependsOnMethods = "customerPage")
    public void tc_01() throws InterruptedException {
        //"Add New" butonuna tıklanmalı.
        zeynepAlloverPage.customerAddNew.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //"Add Customer" altında "UserName" ekleniyor mu tes et.
        //"Add Customer" altında "Email" ekleniyor mu tes et.
        //"Add Customer" altında "FirstName" ekleniyor mu test et.
        //"Add Customer" altında "LastName" ekleniyor mu tes et.

        zeynepAlloverPage.customerAddUsername.sendKeys(faker.name().username());
        Thread.sleep(1000);
        zeynepAlloverPage.customerAddEmail.sendKeys(faker.internet().emailAddress());
        Thread.sleep(1000);
        zeynepAlloverPage.customerAddFirstName.sendKeys(faker.name().firstName());
        Thread.sleep(1000);
        zeynepAlloverPage.customerAddLastName.sendKeys(faker.name().lastName());

        //"Submit" butonuna tıklanıyor mu test et.

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", zeynepAlloverPage.customerSubmitButton);
        jse.executeScript("arguments[0].click()", zeynepAlloverPage.customerSubmitButton);

        Thread.sleep(1000);
        //Browser'i kapat.
        Driver.closeDriver();
    }
}
