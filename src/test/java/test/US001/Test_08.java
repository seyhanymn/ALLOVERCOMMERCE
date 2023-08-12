package test.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class Test_08 extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test008() throws InterruptedException {

        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");
        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("belirtilen URL'e gidildi");
        //Register'a tıklanır
        allowerPageObje.registerButton.click();
        extentTest.info("'Register' butonuna tıklandı");
        //Açılan pencerede "Become a vendor"a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info("'Become a vendor' butonuna tıklandı");

        //Geçerli bir Email adresi girilir
        Driver.getDriver().get("https://www.fakemail.net/");
        String fakeMail = allowerPageObje.fake1EmailBox.getText();
        Driver.getDriver().navigate().back();
        allowerPageObje.vendorRegEmailBox.sendKeys(fakeMail);
        extentTest.info("Geçerli bir email girildi");

        //Verification code'u istenir
        allowerPageObje.vendorRegCodeBox.click();
        allowerPageObje.vendorRegPasswordBox.sendKeys(" ");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(allowerPageObje.vendorRegCodeUyariText));
        extentTest.info("Geçerli verification code'u mail hesabından alındı");

        //Verification code'u email hesabından alınır ve sitedeki kod bölümüne girilir
        Driver.getDriver().navigate().forward();
        allowerPageObje.fakeEmailGelen.click();
        String verCode = allowerPageObje.fakeEmailGelenCod.getText().replaceAll("\\D", "");
        Driver.getDriver().navigate().back();
        allowerPageObje.vendorRegCodeBox.sendKeys(verCode);
        extentTest.info("Geçerli verification code'u girildi");
        //Geçerli bir "Password" girilir
        allowerPageObje.vendorRegPasswordBox.clear();
        allowerPageObje.vendorRegPasswordBox.sendKeys("Zeynep425*");
        extentTest.info("'Geçerli bir password' girildi");
        //Aynı şifre tekrar "Confirm Password"e girilir
        allowerPageObje.vendorRegConfirmPasswordBox.sendKeys("Zeynep425*");
        extentTest.info("'Confirm Password' girildi");
        //Register'a tıklanır
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", allowerPageObje.vendorRegisterButton);
        jse.executeScript("arguments[0].click();", allowerPageObje.vendorRegisterButton);
        extentTest.info("'Register' butonuna tıklandı");
        //Welcome to Allover Commerce! Yazısının göründüğü test edilir
        Assert.assertTrue(allowerPageObje.vendorRegOnayText.isDisplayed());
        extentTest.pass("'Welcome to Allover Commerce!' yazısı başarıyla görüldü");
    }  }