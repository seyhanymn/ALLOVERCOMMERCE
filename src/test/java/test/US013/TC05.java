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

public class TC05 extends TestBaseRapor {
    FezaAlloverPage fezaAlloverPage = new FezaAlloverPage();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();
    int couponNumber=faker.random().nextInt(10,150);

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
    public void testTC005() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");
        fezaAlloverPage.couponCodeTextSatır.sendKeys("SON"+couponNumber);
        fezaAlloverPage.CouponAmountTextArea.clear();
        fezaAlloverPage.CouponAmountTextArea.sendKeys("25");
        jse.executeScript("arguments[0].click();",fezaAlloverPage.couponsSubmit);
        Thread.sleep(4000);
        jse.executeScript("arguments[0].scrollIntoView(true);",fezaAlloverPage.coupons);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click();",fezaAlloverPage.coupons);
        String expectedAmount="25";
        jse.executeScript("arguments[0].scrollIntoView(true);",fezaAlloverPage.couponAmountDogrulama);
        Thread.sleep(1000);
        Assert.assertEquals(fezaAlloverPage.couponAmountDogrulama.getText(),expectedAmount);
        extentTest.pass("Coupon amount girilebildiğidogrulandı");

    }
}
