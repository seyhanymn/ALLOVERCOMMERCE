package test.US016;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlloverPage;
import pages.ZeynepAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Test_01 extends TestBaseRapor {
    ZeynepAlloverPage zeynepAlloverPage = new ZeynepAlloverPage();
    Actions actions = new Actions(Driver.getDriver());


    //"Register"a Tıkla
    //"Sign In"a Tıkla
    //Gecerli email gir
    //Gecerli password gir
    //"Sign In" butonuna tıkla.
    //"Sign Out"a tıkla.
    //"Store Manager"e Tıkla.
    //"Customer"a Tıkla.
    //"Customer"dan "Name" görünürlüğünü test et.
    //"Customer"dan "Username" görünürlüğünü test et.
    //"Customer"dan "Email" görünürlüğünü test et.
    //"Customer"dan "Location" görünürlüğünü test et.
    //"Customer"dan "Orders" görünürlüğünü test et.
    //"Customer"dan "Money Spent" görünürlüğünü test et.
    //"Customer"dan "Last Order" görünürlüğünü test et.
    //"Customer"dan "Actions" görünürlüğünü test et.
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

    @Test (dependsOnMethods = "customerPage")
    public void tc_01() throws InterruptedException {
        Assert.assertTrue(zeynepAlloverPage.customerName.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerUsername.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerEmail.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerLocation.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerOrders.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerMoneySpent.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerLastOrder.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(zeynepAlloverPage.customerActions.isDisplayed());

        //Browser'i kapat.
        Driver.closeDriver();
    }
}
