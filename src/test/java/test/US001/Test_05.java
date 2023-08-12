package test.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Test_05 extends TestBaseRapor {
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
        extentTest.info("Become vendor tıklanıldı");

        //Kullanıcı geçerli bir email adresi girer
        allowerPageObje.registerEmailBox.sendKeys("timetoteam23@gmail.com");
        allowerPageObje.verifikasyonCodeBox.click();
        //Verification code sent to your email: yazısının geldiğini doğrular
        Thread.sleep(3000);
        Assert.assertTrue(allowerPageObje.mailSentText.isDisplayed());
        extentTest.info("Verification code sent yazısı görüldü");

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
        extentTest.info("Gecerli email hesabına gidildi");

        //Verification code'u email hesabından alır ve sitedeki kod bölümüne girer
        ReusableMethods.hover(allowerPageObje.firstMailBox);
        Thread.sleep(2000);
        allowerPageObje.firstMailBox.click();
        String verificationCode = allowerPageObje.verificationCode.getText();
        Driver.getDriver().switchTo().window(allowerWindowHandle);
        allowerPageObje.verifikasyonCodeBox.sendKeys(verificationCode);
        extentTest.info("İsteilen adım gerceklestirildi");

//    Geçerli bir "Password" girilir
        allowerPageObje.password2GirisiButton.sendKeys("team2022++");
        extentTest.info("Gecerli bir password girildi");

//    Aynı şifre tekrar "Confirm Password"e girilir
        allowerPageObje.confirm2PasswordGirisButton.sendKeys("team2022++");
        extentTest.info(" Ayni password girildi");

        //Register'a tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", allowerPageObje.afterVerfyRegisterButton);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();", allowerPageObje.afterVerfyRegisterButton);
        extentTest.info(" Register butonuna tıklanıldı");

        // "This Email already exists" yazısının göründüğü test edilir
        Assert.assertTrue(allowerPageObje.emailErrorText.isDisplayed());
        extentTest.pass("This Email already exists yazısı görüldü");

    }
}