package test.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class  Test_03 extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {

        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("belirtilen URL'e gidildi");

        //Register'a tıklanır
        allowerPageObje.registerButton.click();
        extentTest.info("'Register' butonuna tıklandı");

        //Açılan pencerede Satıcı ol(Become a vendor)'a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info("Become vendor tıklanıldı");

        //Mail girmeden geçerli bir "Password" girilir
        allowerPageObje.password2GirisiButton.sendKeys("team2022++");
        extentTest.info("Mail girmeden bgecerli password  girildi");

        //Aynı şifre tekrar "Confirm Password"e girilir
        allowerPageObje.confirm2PasswordGirisButton.sendKeys("team2022++");
        extentTest.info("Aynı password  girildi");

//        //Register'a tıklanır
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", allowerPageObje.vendorRegisterButton);
        jse.executeScript("arguments[0].click();", allowerPageObje.vendorRegisterButton);
        Thread.sleep(4000);
        extentTest.info("Register butonuna tıklanıldı");

        // "Email: this field is required" yazısının göründüğü test edili
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(allowerPageObje.emailErrorText.isDisplayed());
        extentTest.pass("Email:This is field required yazısının göründüğü dogrulandı");



    }
}