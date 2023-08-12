package test.US015;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.FezaAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC01  extends TestBaseRapor {

    FezaAlloverPage fezaAlloverPage = new FezaAlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


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
    public void testTC01() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");
        jse.executeScript("arguments[0].scrollIntoView(true);",fezaAlloverPage.limit);
        Thread.sleep(2000);
        fezaAlloverPage.limit.click();
        fezaAlloverPage.usagelimitPerCoupon.sendKeys("5");
        ReusableMethods.getScreenshotWebElement("usagelimitPerCoupon",fezaAlloverPage.usagelimitArea);
        extentTest.pass("Vendor registration yazısının göründüğü dogrulandı");

    }
}
