package test.US005;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import pages.RabiaAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Test_01 extends TestBaseRapor {

    RabiaAlloverPage RabiaAlloverPage = new RabiaAlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void US_005() throws InterruptedException {
        extentTest = extentReports.createTest("Urun Ekleme", "Web Automation Raporlama");
        // TESTCASE_001*******
        // Kullanici https://allovercommerce.com/ sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        // Kullanici sign in butonuna tiklar
        RabiaAlloverPage.IlkSignIn.click();
        // Kullanici mail adresini ve sifresini girer
        actions.click(RabiaAlloverPage.email)
                .sendKeys("timetoteam23@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("team2022++")
                .click(RabiaAlloverPage.signIn).perform();
        Thread.sleep(2000);
        extentTest.info("Basarili bir sekilde giris yapildi");

        // My Account'a tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", RabiaAlloverPage.myAccount);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", RabiaAlloverPage.myAccount);
        // Store managera tiklar
        RabiaAlloverPage.storeManager.click();
        // Product kategorisine tiklar
        RabiaAlloverPage.products.click();
        // Status'un gorundugunu dogrular
        Assert.assertTrue(RabiaAlloverPage.status.isDisplayed());
        // Stock' un gorundugunu dogrular
        Assert.assertTrue(RabiaAlloverPage.stock.isDisplayed());
        // Price'in gorundugunu dogrular
        Assert.assertTrue(RabiaAlloverPage.price.isDisplayed());
        // Date'in gorundugunu dogrular
        Assert.assertTrue(RabiaAlloverPage.date.isDisplayed());
        extentTest.info("Store managera gidildi");

        // TESTCASE_002*********
        // Kullanici "add new" butonun tiklanabilir oldugunu dogrular ve tiklar
        Assert.assertTrue(RabiaAlloverPage.addNew.isDisplayed());
        RabiaAlloverPage.addNew.click();
        // Kullanici virtual butonunun gorunur oldugunu dogrular
        Assert.assertTrue(RabiaAlloverPage.virtualText.isDisplayed());
        // Kullanici "downloadable" butonunun gorunur oldugunu dogrular
        Assert.assertTrue(RabiaAlloverPage.downloadableText.isDisplayed());

        // TESTCASE_003*******
        // Kullanici product title bolmesine "Kahverengi Kadin Kazak" yazar
        // Kullanici fiyati "120" olarak girer
        actions.click(RabiaAlloverPage.simpleProduct).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Kahverengi Kadin Kazak")
                .sendKeys(Keys.TAB).sendKeys("120").perform();
        extentTest.info("Urunun fiyati ve basligi girildi");

        // TESTCASE_004*******
        // Kullanici urun gorsel ekleme ikonuna tiklar
        RabiaAlloverPage.buyukGorselEkleButonu.click();
        // Kullanici media library sekmesinden kazak.jpg'yi secer
        RabiaAlloverPage.mediaLibrary.click();
        Thread.sleep(4000);
        RabiaAlloverPage.kahverengiKazak.click();
        // Kullanici "select"e tiklar
        RabiaAlloverPage.selectButon.click();
        Thread.sleep(3000);
        extentTest.info("Urunun buyuk gorseli eklendi");

        // TESTCASE_005*******
        jse.executeScript("arguments[0].scrollIntoView(true);", RabiaAlloverPage.addMediaUst);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click;", RabiaAlloverPage.addMediaUst);
        ReusableMethods.waitFor(3);
        // Kullanici short description text areaya tiklar
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@id='excerpt_ifr']"));
        frame.click();
        Driver.getDriver().switchTo().frame(frame);
        // Kullanici "Kahverengi kadin kazak" kisa aciklamasini yazar
        WebElement shortDescription = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        shortDescription.sendKeys("Kahverengi kadin kazak");
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.waitFor(3);

        // Kullanici Description text areaya tiklar
        WebElement frame2 = Driver.getDriver().findElement(By.xpath("//iframe[@id='description_ifr']"));
        jse.executeScript("arguments[0].click();", frame2);
        Driver.getDriver().switchTo().frame(frame2);
        // Kullanici aciklamaya "Uzun kollu kahverengi yun kadin kazak" yazar
        WebElement description = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        description.sendKeys("Uzun kollu kahverengi yun kadin kazak");
        Driver.getDriver().switchTo().defaultContent(); //x
        extentTest.info("Urunun aciklamalari yazildi");

        //Kullanici kucuk gorsel ikonuna tiklar
        RabiaAlloverPage.kucukGorselEkleButonu.click();
        RabiaAlloverPage.mediaLibrary2.click();
        ReusableMethods.waitFor(2);
        //Kullanici kahverengi kazagi secer
        RabiaAlloverPage.kahverengiKazak2.click();
        RabiaAlloverPage.addToGallery.click();
        extentTest.info("Urunun kucuk gorseli eklendi");
        //Kullanici kategoriyi secer
        RabiaAlloverPage.clothing.click();
        //Kullanici brandi secer
        RabiaAlloverPage.defacto.click();
        extentTest.info("kategori secildi");
        //Kullanici submit butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", RabiaAlloverPage.submit);
        jse.executeScript("arguments[0].click();", RabiaAlloverPage.submit);
        extentTest.info("Urun basariyla siteye eklendi!");
    }


    @Test
    public void US_006_007() throws InterruptedException {
        storeManageraGit();

        //  jse.executeScript("argumnets[0].scrollIntoView(true);",RabiaAlloverPage);
        actions.click(RabiaAlloverPage.simpleProduct).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Nutraxin C Vitamini")
                .sendKeys(Keys.TAB).sendKeys("40").perform();
        extentTest.info("Urunun fiyati ve basligi girildi");

        // TESTCASE_007*******
        // Kullanici urun gorsel ekleme ikonuna tiklar
        RabiaAlloverPage.buyukGorselEkleButonu.click();
        // Kullanici media library sekmesinden kazak.jpg'yi secer
        RabiaAlloverPage.mediaLibrary.click();
        Thread.sleep(4000);
        RabiaAlloverPage.cVitamini.click();
        // Kullanici "select"e tiklar
        RabiaAlloverPage.selectButon.click();
        Thread.sleep(3000);
        extentTest.info("Urunun buyuk gorseli eklendi");


        jse.executeScript("arguments[0].scrollIntoView(true);", RabiaAlloverPage.addMediaUst);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click;", RabiaAlloverPage.addMediaUst);
        ReusableMethods.waitFor(3);
        // Kullanici short description text areaya tiklar
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@id='excerpt_ifr']"));
        frame.click();
        Driver.getDriver().switchTo().frame(frame);
        WebElement shortDescription = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        shortDescription.sendKeys("C Vitamini");
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.waitFor(3);

        // Kullanici Description text areaya tiklar
        WebElement frame2 = Driver.getDriver().findElement(By.xpath("//iframe[@id='description_ifr']"));
        jse.executeScript("arguments[0].click();", frame2);
        Driver.getDriver().switchTo().frame(frame2);
        WebElement description = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        description.sendKeys("Kolay icim C Vitamini Sizin ve Cocuklariniz Icin");
        Driver.getDriver().switchTo().defaultContent(); //x
        extentTest.info("Urunun aciklamalari yazildi");

        //Kullanici kucuk gorsel ikonuna tiklar
        RabiaAlloverPage.kucukGorselEkleButonu.click();
        RabiaAlloverPage.mediaLibrary2.click();
        ReusableMethods.waitFor(2);
        //Kullanici kahverengi kazagi secer
        RabiaAlloverPage.cVitamini.click();
        RabiaAlloverPage.addToGallery.click();
        extentTest.info("Urunun kucuk gorseli eklendi");

        //Kullanici kategoriyi secer
        RabiaAlloverPage.besinTakviyesi.click();
        //Kullanici brandi secer
        RabiaAlloverPage.toysGames.click();
        extentTest.info("kategori secildi");
        //Kullanici submit butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", RabiaAlloverPage.submit);
        jse.executeScript("arguments[0].click();", RabiaAlloverPage.submit);
        extentTest.info("Urun basariyla siteye eklendi!");



    }
    public void storeManageraGit() throws InterruptedException {
        // Kullanici https://allovercommerce.com/ sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        // Kullanici sign in butonuna tiklar
        RabiaAlloverPage.IlkSignIn.click();
        // Kullanici mail adresini ve sifresini girer
        actions.click(RabiaAlloverPage.email)
                .sendKeys("timetoteam23@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("team2022++")
                .click(RabiaAlloverPage.signIn).perform();
        Thread.sleep(2000);
        // Kullanici my Account'a tiklar
        jse.executeScript("arguments[0].scrollIntoView(true);", RabiaAlloverPage.myAccount);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", RabiaAlloverPage.myAccount);
        // Kullanici store managera tiklar
        RabiaAlloverPage.storeManager.click();
        // Kullanici product kategorisine tiklar
        RabiaAlloverPage.products.click();

    }

}

