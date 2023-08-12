package test.US018;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SeyhanAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class Test_03 extends TestBaseRapor {
    @Test
    public void tc_03() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        TakesScreenshot ts=(TakesScreenshot)Driver.getDriver();
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekrangoruntusu.jpeg"));



        SeyhanAlloverPage seyhanAlloverPage;
        Actions actions=new Actions(Driver.getDriver());
        //  1)Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //        2)Sign in'e tıklanir
        seyhanAlloverPage=new SeyhanAlloverPage();
        seyhanAlloverPage.syregisterButton.click();


        //        3)Gecerli bir email girilir
        Thread.sleep(2000);
        seyhanAlloverPage.syanasayfaSignInButton.click();
        seyhanAlloverPage.syikinciSayfaEmailAdressButton.sendKeys("timetoteam23@gmail.com", Keys.TAB);

        //        4)Gecerli bir password  girilir
        Thread.sleep(2000);

        actions.sendKeys("team2022++").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).perform();
        //        5)Sig in'e tıklanir
        seyhanAlloverPage.syikinciSayfaSignInButton.click();


        //        6)Anasayfanın görünür oldugu dogrulanır
        Assert.assertTrue(seyhanAlloverPage.syanasayfa.isDisplayed());
        //7) Signouta tıklanır
        seyhanAlloverPage.symyAccountSignOutLink.click();
        //        7)Store Managere tıklanır
        seyhanAlloverPage.systoreManager.click();
        Thread.sleep(2000);

        // 8)Refunda tıklanır
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        seyhanAlloverPage.systoreMAnagerRefund.click();

        //  9)Request date nin görünür olduğu doğrulanır
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(seyhanAlloverPage.systoreMAnagerRefundRequestDate.isDisplayed());

        extentTest.pass("'sign in, gecerli mail  ve sifre girildi" +
                "'signouta tıklandı,refunda tıkladı request date' başarıyla görüldü");



    }
}
