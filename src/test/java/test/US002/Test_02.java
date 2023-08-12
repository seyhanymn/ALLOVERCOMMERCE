package test.US002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_02 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    AlloverPage allowerPageObje = new AlloverPage();

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");

        //    Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL'e gidildi");

//    Sign in 'e tiklanir
        allowerPageObje.anasayfaSignInButton.click();
        extentTest.info("Sign in butonuna tıklanıldı");


//    Gecerli bir mail girilir
        allowerPageObje.sayfa2EmailAdressButton.sendKeys("timetoteam23@gmail.com", Keys.TAB);
        extentTest.info("Geçerli bir mail girildi");

//    Gecerli bir password girilir
//    Sign in 'e tiklanir
        actions.sendKeys("team2022++").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        extentTest.info("Geçerli bir password girildi");
        extentTest.info("Sign in butouna tıklanıldı girildi");

//    My Account'a tıklanır
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        allowerPageObje.myAccountSignOutLink.click();
        extentTest.info("My acount tıklanıldı ");
        Thread.sleep(300);

//    Orders, Downloads, addresses, account details,whislist ve Logout butonlarının göründüğü test edilir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(allowerPageObje.myAccountList.isDisplayed());
        extentTest.pass("Belirtilen seceneklerin oldugu görüldü");

    }
}
