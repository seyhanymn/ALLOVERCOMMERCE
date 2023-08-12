package test.US016;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ZeynepAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.plaf.TableHeaderUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test_02 extends TestBaseRapor {

    ZeynepAlloverPage zeynepAlloverPage =new ZeynepAlloverPage();

    Actions actions = new Actions(Driver.getDriver());

    //"Register"a Tıkla
    //"Sign In"a Tıkla
    //Gecerli email gir
    //Gecerli password gir
    //"Sign In" butonuna tıkla.
    //"Sign Out"a tıkla.
    //"Store Manager"e Tıkla.
    //"Customer"a Tıkla.
    //"Customer"daki kisilerin bilgileri "Pdf" oluyor mu test et.
    //"Customer"daki kisilerin bilgiler "Excel" oluyor mu test et.
    //"Customer"daki kisilerin bilgileri "CSV" oluyor mu test et.
    //Browserı kapat.


    @Test
    public void customerPage() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        zeynepAlloverPage.signIn.click();
        zeynepAlloverPage.emailTextBox.sendKeys(ConfigReader.getProperty("alloverEmail"));
        zeynepAlloverPage.passwordTextBox.sendKeys(ConfigReader.getProperty("alloverPass"));
        zeynepAlloverPage.signIn2.click();
        zeynepAlloverPage.singOut.click();
        zeynepAlloverPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(zeynepAlloverPage.customers).click().perform();
        Thread.sleep(1000);
    }

    //"Customer"daki kisilerin bilgileri "Pdf" oluyor mu test et.
    @Test (dependsOnMethods = "customerPage")
    public void tc_02() throws InterruptedException, IOException {
        zeynepAlloverPage.customerPdf.click();
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "/Downloads/Store Manager - Allover Commerce.pdf";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    //"Customer"daki kisilerin bilgiler "Excel" oluyor mu test et.
    @Test (dependsOnMethods = "customerPage")
    public void tc_03() throws InterruptedException {
        zeynepAlloverPage.customerExcel.click();
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\Store Manager - Allover Commerce.xlsx";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    //"Customer"daki kisilerin bilgileri "CSV" oluyor mu test et.
    @Test (dependsOnMethods = "customerPage")

    public void tc_04() throws InterruptedException {
        Thread.sleep(1500);
        zeynepAlloverPage.customerCsv.click();
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\Store Manager - Allover Commerce.csv";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        Driver.closeDriver();
    }
}
