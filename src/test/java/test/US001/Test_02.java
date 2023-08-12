
package test.US001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_02 extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();
    @Test
    public void test1() {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL'e gidildi");

        //Register'a tıklanır
        allowerPageObje.registerButton.click();
        extentTest.info("'Register' butonuna tıklandı");

        //Açılan pencerede Satıcı ol(Become a vendor)'a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info("Become vendor tıklanıldı");

        //Açılan sayfada 'Email' bölümünün göründüğü test edilir
        Assert.assertTrue(allowerPageObje.emailButton.isDisplayed());
        extentTest.info("Email bölümünü oldugu görüldü");

        // Açılan sayfada 'Password' bölümünün göründüğü test edilir
        Assert.assertTrue(allowerPageObje.emailButton.isDisplayed());
        extentTest.info("Password bölümünü oldugu görüldü");

        //Açılan sayfada 'Confim PassWord' bölümünün göründüğü test edilir
        Assert.assertTrue(allowerPageObje.confirmPasswordButton.isDisplayed());
        extentTest.pass("Confirm password yazısının göründüğü dogrulandı");

    }
}