package test.US018;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SeyhanAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class Test_01 extends TestBaseRapor {

    //hjghjkkjhghjk
    SeyhanAlloverPage seyhanallowerPageObje;
    Actions actions = new Actions(Driver.getDriver());
    Select options;

    @Test
    public void tc_001() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        TakesScreenshot ts=(TakesScreenshot)Driver.getDriver();
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekrangoruntusu.jpeg"));


        //extentTest.info("'My Account' linkine tıklandı");


        //  1)Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //        2)Sign in'e tıklanir
        seyhanallowerPageObje = new SeyhanAlloverPage();
        seyhanallowerPageObje.syregisterButton.click();


        //        3)Gecerli bir email girilir
        Thread.sleep(2000);
        seyhanallowerPageObje.syanasayfaSignInButton.click();
        seyhanallowerPageObje.syikinciSayfaEmailAdressButton.sendKeys("timetoteam23@gmail.com", Keys.TAB);

        //        4)Gecerli bir password  girilir
        Thread.sleep(2000);

        actions.sendKeys("team2022++").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).perform();
        //        5)Sig in'e tıklanir
        seyhanallowerPageObje.syikinciSayfaSignInButton.click();


        //        6)Anasayfanın görünür oldugu dogrulanır
        Assert.assertTrue(seyhanallowerPageObje.syanasayfa.isDisplayed());
        //7) Signouta tıklanır
        seyhanallowerPageObje.symyAccountSignOutLink.click();
        //        7)Store Managere tıklanır
        seyhanallowerPageObje.systoreManager.click();
        Thread.sleep(2000);
        //        8)ordersa tıklar

      // actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //seyhanallowerPageObje.systoreManagerPageOrders.click();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",seyhanallowerPageObje.systoreManagerPageOrders);
        jse.executeScript("arguments[0].click();", seyhanallowerPageObje.systoreManagerPageOrders);


        //        9)Refund Requestte tıklar

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        seyhanallowerPageObje.systoreManagerPageOrdersRefundRequest.click();


        //        10)Request mod seçer,Quantyty seçer,Refund Request belirtir submite tıklar
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //seyhanallowerPageObje.sypartialRefundOrdersRefund.click();
        options=new Select(seyhanallowerPageObje.sypartialRefundOrdersRefund);

        options.selectByVisibleText("Partial Refund");


        options=new Select(seyhanallowerPageObje.syRefundByItemQTY);
        options.selectByVisibleText("1");


        seyhanallowerPageObje.syRefundByItemTotal.sendKeys("0",Keys.ENTER);

        actions.click(seyhanallowerPageObje.syRefundRequestReason).  sendKeys("urun bozuk",Keys.ENTER).perform();




        seyhanallowerPageObje.syRefundRequestSubmit.click();



        extentTest.pass("'sign in, gecerli mail  ve sifre girildi" +
                "'signouta tıklandı,refunda tıkladı request ıd' başarıyla görüldü,ordersa girildi ve iade planı olusturuldu");




    }

}

