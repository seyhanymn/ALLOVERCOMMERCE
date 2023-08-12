package test.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Test_06 extends TestBaseRapor {

    AlloverPage allowerPageObje = new AlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");


        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        String allowerWindowHandle = Driver.getDriver().getWindowHandle();
        extentTest.info("belirtilen URL'e gidildi");

        //Register'a tıklanır
        allowerPageObje.registerButton.click();
        extentTest.info("'Register' butonuna tıklandı");

        //Açılan pencerede Satıcı ol(Become a vendor)'a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info(" Become a vendor tıklanıldı");


        //Kullanıcı geçerli bir email adresi girer
        allowerPageObje.registerEmailBox.sendKeys("timetoteam23@gmail.com");
        allowerPageObje.verifikasyonCodeBox.click();
        extentTest.info("Geçerli bir email girildi");

        //Verification code sent to your email: yazısının geldiğini doğrular
        Thread.sleep(3000);
        Assert.assertTrue(allowerPageObje.mailSentText.isDisplayed());
        extentTest.info(" VErifikasyon için mail gönderildi yazısı görüldü");

        //Geçerli Email hesabına gider
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://mail.google.com/mail/u/0/?pli=1#inbox");
        String teamGmailWindowHandle = Driver.getDriver().getWindowHandle();
        allowerPageObje.googleSıgnIn.sendKeys("timetoteam23@gmail.com");
        allowerPageObje.googleSıgnInNextButton.click();
        Thread.sleep(3000);
        allowerPageObje.googlePassword.sendKeys("team2022++");
        allowerPageObje.googlePaswordNext.click();
        Thread.sleep(3000);
        extentTest.info(" Geçerli email adresine gidildi");

        //Verification code'u email hesabından alır ve sitedeki kod bölümüne girer
        ReusableMethods.hover(allowerPageObje.firstMailBox);
        Thread.sleep(2000);
        allowerPageObje.firstMailBox.click();
        String verificationCode = allowerPageObje.verificationCode.getText();
        Driver.getDriver().switchTo().window(allowerWindowHandle);
        allowerPageObje.verifikasyonCodeBox.sendKeys(verificationCode);
        extentTest.info(" İstenilen adım yapıldi");

//    Geçerli bir "Password" girilir
        allowerPageObje.password2GirisiButton.sendKeys("Tt2+");
        extentTest.info(" İstenilen bir sekilde password girildi");

//    Aynı şifre tekrar "Confirm Password"e girilir
        allowerPageObje.confirm2PasswordGirisButton.sendKeys("Tt2+");
        extentTest.info(" Aynı şekilde istenilen password girildi");

        Thread.sleep(3000);
        //Register'a tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", allowerPageObje.afterVerfyRegisterButton);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();", allowerPageObje.afterVerfyRegisterButton);
        extentTest.info(" Register butonuna tıklanıldı");

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

//    Uyarı yazısında 'Strong' yazısının göründüğü doğrulanır
        extentTest.fail("'Strong' yazisi görülemedi");
       Assert.assertTrue(allowerPageObje.passwordUyariText.getText().contains("Strong"));


    }
}