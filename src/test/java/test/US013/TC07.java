package test.US013;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FezaAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC07 extends TestBaseRapor {
    FezaAlloverPage fezaAlloverPage = new FezaAlloverPage();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();


    @Test
    public void addNewCouponPage() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        fezaAlloverPage.signIn.click();
        fezaAlloverPage.emailTextBox.sendKeys(ConfigReader.getProperty("alloverEmail"));
        fezaAlloverPage.passwordTextBox.sendKeys(ConfigReader.getProperty("alloverPass"));
        fezaAlloverPage.signIn2.click();
        fezaAlloverPage.singOut.click();
        fezaAlloverPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(fezaAlloverPage.coupons).perform();
        Thread.sleep(1000);
        fezaAlloverPage.addNewButton.click();

    }
    @Test(dependsOnMethods = "addNewCouponPage")
    public void testTC007() {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");
        jse.executeScript("arguments[0].click();",fezaAlloverPage.allowFreeShipping);
        Assert.assertTrue(fezaAlloverPage.allowFreeShipping.isSelected());
        extentTest.pass("Allow free shipping butonunun tıklandığı  dogrulandı");

    }


}
