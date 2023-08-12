package test.US012;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Test_04 extends TestBaseRapor {

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    YAlloverPage yAlloverPage =new YAlloverPage();

    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void test01() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("alloverUrl", "Web Raporlama");
        //Belirtilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Sayfaya basarili bir sekilde giris yapildi");
        //Sign in'e tıklanir
        Thread.sleep(2000);
        yAlloverPage.sign.click();
        //Gecerli bir email girilir
        yAlloverPage.email.sendKeys(ConfigReader.getProperty("alloverEmail"));
        //Gecerli bir password  girilir
        yAlloverPage.password.sendKeys(ConfigReader.getProperty("alloverPass"));
        extentTest.info("Dogru kullancı email ve password girildi");

        //Sig in'e tıklanir
        yAlloverPage.sign2.click();

        //Sign Out tiklanir
        yAlloverPage.signOut.click();
        ReusableMethods.waitFor(2);
        //Hesap detaylarına tıklanır

        jse.executeScript("arguments[0].scrollIntoView(true);", yAlloverPage.hesapdetaylari);
        jse.executeScript("arguments[0].click();", yAlloverPage.hesapdetaylari);
        //Bilgilerin update edilir oldugu test edilmelidir
        yAlloverPage.emailgüncelle.clear();
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        yAlloverPage.emailgüncelle.sendKeys("ultrateam0@gmail.com");
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        yAlloverPage.paswordtekrar.sendKeys("team2022++",Keys.TAB+"team2022++"
                ,Keys.TAB+ "team2022++"+Keys.TAB,Keys.ENTER);
        extentTest.info("Yeni bir e posta adresi girildi");

        ReusableMethods.waitFor(10);
        WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),10);
        ReusableMethods.getScreenshotWebElement("popMessage", yAlloverPage.popMessage);
        wait1.until(ExpectedConditions.visibilityOf(yAlloverPage.popMessage));
        Assert.assertTrue(yAlloverPage.popMessage.isDisplayed());
        Driver.getDriver().navigate().refresh();
        yAlloverPage.emailgüncelle.clear();
        Thread.sleep(2000);
        yAlloverPage.emailgüncelle.sendKeys("timetoteam23@gmail.com");
        Thread.sleep(3000);
        yAlloverPage.paswordtekrar.sendKeys("team2022++",Keys.TAB+"team2022++"
                ,Keys.TAB+ "team2022++"+Keys.TAB,Keys.ENTER);
        extentTest.pass("Basarili bir sekilde güncellendi");
        //Browser kapatilir
        Driver.quitDriver();


    }




    }

