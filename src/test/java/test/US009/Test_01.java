package test.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RüveydaAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test_01 {


    RüveydaAlloverPage rüveydaAlloverPage = new RüveydaAlloverPage();

    @Test
    public void kiloBoyutHacimTeslimatSuresi(){

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.waitForPageToLoad(3);

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.signInButonu,3);
        ReusableMethods.waitForPageToLoad(3);

        rüveydaAlloverPage.usernameTextBox.sendKeys(ConfigReader.getProperty("alloverEmail"));
        rüveydaAlloverPage.passwordTextBox.sendKeys(ConfigReader.getProperty("alloverPass"));

        rüveydaAlloverPage.singInButonu2.click();

        ReusableMethods.waitFor(5);
        ReusableMethods.scrollIntoViewJS(rüveydaAlloverPage.myAccount);
        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.myAccount,3);

        rüveydaAlloverPage.storeManager.click();

        rüveydaAlloverPage.products.click();

        rüveydaAlloverPage.addNew.click();

        rüveydaAlloverPage.productTitle.sendKeys("IPHONE");
        Assert.assertEquals("IPHONE","IPHONE");

        rüveydaAlloverPage.featuredImg.click();

        rüveydaAlloverPage.mediaLibrary.click();

        rüveydaAlloverPage.telefonResmi.click();
        ReusableMethods.waitFor(3);

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.selectButonu,3);

        rüveydaAlloverPage.galleryImg.click();
        ReusableMethods.waitFor(3);

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.telefonResmi2,3);

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.addToGallery,3);

        ReusableMethods.scrollIntoViewJS(rüveydaAlloverPage.electronics);
        ReusableMethods.waitFor(3);
        ReusableMethods.selectCheckBox(rüveydaAlloverPage.checkBox,true);
        Assert.assertTrue(rüveydaAlloverPage.checkBox.isSelected());

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.shippingSekmesi,3);

        rüveydaAlloverPage.weight.sendKeys("6");

        rüveydaAlloverPage.length.sendKeys("30");

        rüveydaAlloverPage.width.sendKeys("40");

        rüveydaAlloverPage.height.sendKeys("50");

        ReusableMethods.selectByVisibleText(rüveydaAlloverPage.processingTime,"1-2 business days");

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.submitButonu,3);
        Assert.assertTrue(rüveydaAlloverPage.successMessage.isDisplayed());

        ReusableMethods.clickWithTimeOut(rüveydaAlloverPage.singOutButonu,3);

        Driver.closeDriver();
    }

}
