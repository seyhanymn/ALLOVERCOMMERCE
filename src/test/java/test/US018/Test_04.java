package test.US018;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SeyhanAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test_04 extends TestBaseRapor {


    SeyhanAlloverPage seyhanAlloverPage;
    Actions actions=new Actions(Driver.getDriver());


    @Test
    public void test_04() throws InterruptedException, IOException {



        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");

        TakesScreenshot ts=(TakesScreenshot)Driver.getDriver();
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekrangoruntusu.jpeg"));


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
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        seyhanAlloverPage.systoreMAnagerRefund.click();




        //9)ürünlerin listelendiği tets edilir

        List<WebElement> list2=seyhanAlloverPage.syRefundRequestIdProduct;
        List<String> linkListString = new ArrayList<>();

        for (WebElement w:list2
        ) {
            linkListString.add(w.getText());

        }

        System.out.println(linkListString);
        Assert.assertTrue(linkListString.containsAll(linkListString));
        Thread.sleep(2000);

        List<WebElement> list3=seyhanAlloverPage.syRefundOrdeerIdProduct;
        List<String> linkListString3 = new ArrayList<>();

        for (WebElement w:list3
        ) {
            linkListString3.add(w.getText());

        }
        System.out.println(linkListString3);
        Assert.assertTrue(linkListString3.containsAll(linkListString3));
        Thread.sleep(2000);


        List<WebElement> list4=seyhanAlloverPage.syRefundDateProduct;
        List<String> linkListString4 = new ArrayList<>();

        for (WebElement w:list4
        ) {
            linkListString4.add(w.getText());

        }
        System.out.println(linkListString4);
        Assert.assertTrue(linkListString4.containsAll(linkListString4));
        Thread.sleep(2000);

        List<WebElement> list5=seyhanAlloverPage.syRefundAmauntProduct;
        List<String> linkListString5 = new ArrayList<>();

        for (WebElement w:list5
        ) {
            linkListString5.add(w.getText());

        }
        System.out.println(linkListString5);
        Assert.assertTrue(linkListString5.containsAll(linkListString5));
        Thread.sleep(2000);


        extentTest.pass("'sign in, gecerli mail  ve sifre girildi" +
                "'signouta tıklandı,refunda tıkladı request edilen urunler' başarıyla görüldü");

        }








}


