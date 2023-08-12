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

public class TC06 extends TestBaseRapor {
    FezaAlloverPage fezaAlloverPage = new FezaAlloverPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();
    int couponNumber = faker.random().nextInt(10, 150);

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
    public void testTC006() throws InterruptedException {
        extentTest = extentReports.createTest("alloverUrl", "Web automation Raporlama");
        fezaAlloverPage.couponCodeTextSatır.sendKeys("SON" + couponNumber);
        fezaAlloverPage.couponExpiryDate.sendKeys("2022-11-15");
        jse.executeScript("arguments[0].click();", fezaAlloverPage.couponsSubmit);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", fezaAlloverPage.coupons);
        jse.executeScript("arguments[0].click();", fezaAlloverPage.coupons);
        String ExpectedDate = "November 15, 2022";
        jse.executeScript("arguments[0].scrollIntoView(true);", fezaAlloverPage.couponExpiryDateDogrulama);
        Assert.assertEquals(fezaAlloverPage.couponExpiryDateDogrulama.getText(), ExpectedDate);
        extentTest.pass("expiry date seçilebildiği  dogrulandı");

    }
}