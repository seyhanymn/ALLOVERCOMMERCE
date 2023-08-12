package test.US017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ZeynepAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Test_02 extends TestBaseRapor {
    ZeynepAlloverPage zeynepAlloverPage = new ZeynepAlloverPage();

    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    //Vendor olarak giriş yap.
    //"Sign In" butonuna tıkla.
    //"Sign Out"a tıkla.
    //"Store Manager"e Tıkla.
    //"Customer"a Tıkla.
    //"Add New"e Tıkla.
    //"Same as Shipping" butonu işaretlenmediğini kontrol et.
    //"Shipping" Address bilgilerini ekle.
    //"Shipping" Address'teki bilgiler "Billing" adresinden farklı ekleniyor mu test et.
    //"Submit" butonuna çalışıyor mu diye test et.
    //Browserı kapat

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
    public void tc_01() throws InterruptedException, IOException {
        //"Add New" butonuna tıklanmalı.
        zeynepAlloverPage.customerAddNew.click();

        zeynepAlloverPage.customerBillingFirstName.sendKeys(faker.name().firstName());
        zeynepAlloverPage.customerBillingLastName.sendKeys(faker.name().lastName());
        zeynepAlloverPage.customerBillingCompanyName.sendKeys(faker.company().name());
        zeynepAlloverPage.customerBillingPhone.sendKeys(faker.phoneNumber().phoneNumber());
        zeynepAlloverPage.customerBillingAddress1.sendKeys(faker.address().fullAddress());
        zeynepAlloverPage.customerBillingAddress2.sendKeys(faker.address().fullAddress());
        WebElement ddm = zeynepAlloverPage.customerBillingCountry;
        Select options = new Select(ddm);
        options.selectByVisibleText("Germany");
        zeynepAlloverPage.customerBillingCity.sendKeys(faker.address().city());
        zeynepAlloverPage.customerBillingState.sendKeys(faker.address().state());
        zeynepAlloverPage.customerBillingZip.sendKeys(faker.address().zipCode());

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", zeynepAlloverPage.sameAsBillingClick);
        jse.executeScript("arguments[0].click()", zeynepAlloverPage.sameAsBillingClick);


        Thread.sleep(1500);

        zeynepAlloverPage.shippingFirstName.sendKeys(faker.name().firstName());
        zeynepAlloverPage.shippingLastName.sendKeys(faker.name().lastName());
        zeynepAlloverPage.shippingCompanyName.sendKeys(faker.company().name());
        zeynepAlloverPage.shippingAddress1.sendKeys(faker.address().fullAddress());
        zeynepAlloverPage.shippingAddress2.sendKeys(faker.address().fullAddress());
        WebElement country = zeynepAlloverPage.shippingCountry;
        Select options1 = new Select(country);
        options1.selectByVisibleText("Germany");
        zeynepAlloverPage.shippingCity.sendKeys(faker.address().cityName());
        zeynepAlloverPage.shippingState.sendKeys(faker.address().state());
        zeynepAlloverPage.shippingZip.sendKeys(faker.address().zipCode());

        JavascriptExecutor jsex = (JavascriptExecutor) Driver.getDriver();
        jsex.executeScript("arguments[0].scrollIntoView(true);", zeynepAlloverPage.customerSubmitButton);
        jsex.executeScript("arguments[0].click()", zeynepAlloverPage.customerSubmitButton);

        Thread.sleep(1000);
        //Browser'i kapat.
        Driver.closeDriver();
    }
}
