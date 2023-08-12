package test.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_04 extends TestBaseRapor {
    AlloverPage allowerPageObje = new AlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("belirtilen URL'e gidildi");

        //Register'a tıklanır
        allowerPageObje.registerButton.click();

        //Açılan pencerede Satıcı ol(Become a vendor)'a tıklanır
        allowerPageObje.becomeAVendorButton.click();
        extentTest.info("Become vendor tıklanıldı");

        //Kullanıcı geçerciz bir email adresi girer
        allowerPageObje.registerEmailBox.sendKeys("hsoysal@");
        allowerPageObje.verifikasyonCodeBox.sendKeys(" ");
        Thread.sleep(3000);
        extentTest.info("Gecersiz email girildi ");


        //"Please provide a valid email address."  yazısının geldiğini doğrular
        String expectedEmailUyari = "Please provide a valid email address";
        Assert.assertTrue(allowerPageObje.vendorRegPasswordUyariText.getText().contains(expectedEmailUyari));
        extentTest.pass("Please provide a valid email address yazısı görüldü");


    }
}

