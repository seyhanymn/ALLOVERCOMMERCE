package test.US002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_01  extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {
        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL'e gidildi");

        //Sign in 'e tiklanir
        allowerPageObje.anasayfaSignInButton.click();
        extentTest.info("Sign in butonuna tıklanıldı");


        //Gecerli bir mail girilir
        allowerPageObje.sayfa2EmailAdressButton.sendKeys("timetoteam23@gmail.com", Keys.TAB);
        extentTest.info("Geçerli bir mail girildi");

        //Gecerli bir password girilir
        // Sign in 'e tiklanir
        actions.sendKeys("team2022++").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        extentTest.info("Geçerli bir password girildi");
        extentTest.info("Sign in butouna tıklanıldı girildi");


        //My Account sayfasina giris yapildigi test edilir
        Assert.assertTrue(allowerPageObje.myAccountSignOutLink.isDisplayed());
        extentTest.pass("My account sayfasına giriş yapıldı");


    }
}