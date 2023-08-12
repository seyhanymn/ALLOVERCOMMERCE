package test.US001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_01  extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");
        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen url e gidildi");

        //Anasayfanın göründüğü doğrulanır
        Assert.assertTrue(allowerPageObje.anasayfa.isDisplayed());
        extentTest.info("Anasayfanın göründüğü gidildi");

        //Register'a tıklanır
        allowerPageObje.registerButton.click();
        extentTest.info("Register butonuna tıklanıldı");


        //Açılan pencerede Satıcı ol(Become a vendor)'a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info("Become vendor tıklanıldı");

        //Vendor Registration yazısının göründüğü test edilir
        Assert.assertTrue(allowerPageObje.vendorRegistrationText.isDisplayed());
        extentTest.pass("Vendor registration yazısının göründüğü dogrulandı");

    }
}
