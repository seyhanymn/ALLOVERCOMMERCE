package test.US002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class Test_03 extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());
    AlloverPage allowerPageObje = new AlloverPage();

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("İstenlen adrese gidildi");

        //Sign in 'e tiklanir
        allowerPageObje.anasayfaSignInButton.click();
        extentTest.info("Sign in tıklanıldı");


        //Gecerli bir mail girilir
        allowerPageObje.sayfa2EmailAdressButton.sendKeys("timetoteam23@gmail.com", Keys.TAB);
        extentTest.info("Geçerli bir mail girildi");

        //Gecerli bir password girilir
        actions.sendKeys("team2022++").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).perform();
        extentTest.info("Geçerli bir password girildi");

        //Sign in 'e tiklanir
        allowerPageObje.ikinciSayfaSignInButton.click();
        extentTest.info("iteye giriş için ikindi olarak sign in e tıklanıldı");


        //My Account'a tıklanır
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        allowerPageObje.myAccountSignOutLink.click();
        extentTest.info("'My Account' linkine tıklandı");

        //Dashboard altında; Store manager, orders, downloads, addresses , account details, appointments,
        //wishlist, Support tickets, followings ve log out  butonlarının göründüğü test edilir
        extentTest.pass("'Store manager, orders, downloads, addresses , account details" +
                "'wishlist, Support tickets, followings ve Logout butonları' başarıyla görüldü");
        extentTest.fail("'Appointments' linki görülemedi");

        List<WebElement> linkList = allowerPageObje.dashboardAltindakiLinkler;
        List<String> linkListString = new ArrayList<>();
        for (WebElement w : linkList) {
            linkListString.add(w.getText());
        }
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(linkListString.contains("Appointments"));
    }
}