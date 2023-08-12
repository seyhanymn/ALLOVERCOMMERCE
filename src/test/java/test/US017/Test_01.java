package test.US017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ZeynepAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_01 extends TestBaseRapor {
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
    //"Address" kısmında "Billing" bilgileri giriliyor mu test et.
    //Browserı kapat.


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

    @Test(dependsOnMethods = "customerPage")
    public void tc_01() throws InterruptedException {
        //"Add New" butonuna tıklanmalı.
        zeynepAlloverPage.customerAddNew.click();

        //"Address" kısmında "Billing" bilgilerini doldur.
        //firstName
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

        //Billing Address'i Shipping Address ile aynı olarak Submit Yap.
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", zeynepAlloverPage.customerSubmitButton);
        jse.executeScript("arguments[0].click()", zeynepAlloverPage.customerSubmitButton);

        Driver.closeDriver();
    }
}

