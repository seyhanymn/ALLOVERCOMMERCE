package test.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_07 extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");


        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL'e gidildi");

        //Register'a tıklanır
        allowerPageObje.registerButton.click();
        extentTest.info("'Register' butonuna tıklandı");

        //Açılan pencerede Satıcı ol(Become a vendor)'a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info("Become a vendor yazisi tıklanıldı");

        //Kullanıcı geçerli bir email adresi girer
        allowerPageObje.registerEmailBox.sendKeys("hsoysal@gmail.com");
        extentTest.info("Geçerli bir email girildi");

        allowerPageObje.verifikasyonCodeBox.sendKeys("41233");
        //Verification code sent to your email: yazısının geldiğini doğrular
        Thread.sleep(3000);
        Assert.assertTrue(allowerPageObje.mailSentText.isDisplayed());
        extentTest.info("Verifikasyon kodunun gönderildiği yazisi görüldü");

        // Geçerli bir "Password" girilir
        allowerPageObje.password2GirisiButton.sendKeys("team2022++");
        extentTest.info("Geçerli bir passsword girildi");

        //Aynı şifre tekrar "Confirm Password"e girilir
        allowerPageObje.confirm2PasswordGirisButton.sendKeys("team2022++");
        extentTest.info("İstenilen adım yapıldı");
        //Register'a tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", allowerPageObje.afterVerfyRegisterButton);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();", allowerPageObje.afterVerfyRegisterButton);
        extentTest.info("Register butonuna tıklanıldı");

        // "This Email already exists" yazısının göründüğü test edilir
        Assert.assertTrue(allowerPageObje.emailErrorText.isDisplayed());
        extentTest.pass("İstenilen yazi görüldü");


    }
}