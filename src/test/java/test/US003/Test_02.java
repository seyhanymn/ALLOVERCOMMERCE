package test.US003;


import com.github.javafaker.Faker;
import com.mongodb.operation.CreateUserOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IlkerAlloverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

import static java.lang.System.out;

public class Test_02 {

    IlkerAlloverPage ilkerAlloverPage = new IlkerAlloverPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test02() throws InterruptedException {

        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sign in buttonun'a tıklanır
        ilkerAlloverPage.anasayfaSignInButton.click();

        //Açılan Pop Up pencerede "Username or email address" box'a gecerli email gonderilir
        ilkerAlloverPage.signInEmailAdresBoxPopUp.sendKeys(ConfigReader.getProperty("alloverEmail"));
        ReusableMethods.waitFor(2);

        //Açılan Pop Up pencerede "passwords" box'a gecerli password gonderilir
        ilkerAlloverPage.signInPasswordBoxPopUp.sendKeys(ConfigReader.getProperty("alloverPass"));

        // Açılan Pop Up pencerede "sign in"submit buttonuna tiklanir
        js.executeScript("arguments[0].click();",ilkerAlloverPage.signInSubmitPopUp);
        Thread.sleep(2000);

        // Ana sayfa'da My Account'a giris yapmak icin Sign Out buttonuna tiklanir
        js.executeScript("arguments[0].click();", ilkerAlloverPage.myAccountaSignOutIleGit);

        // My Account sayfasinda Orders'a tiklar
        ilkerAlloverPage.myAccountSayfasindaOrders.click();

        // Orders'a tikladiktan sonra acilan sayfada Browse Products / Go Shop'a tiklar
        js.executeScript("arguments[0].click();", ilkerAlloverPage.ordersSayfasindaGoShopButtonu);
        ReusableMethods.waitFor(5);

        // Cart kontrol edilir (burasi ekstra)
        int cartaEkliUrunMiktari = Integer.parseInt(ilkerAlloverPage.cartaEkliUrunAdedi.getText());

        // Rastgele 5 urun sepete eklenir

        WebElement selectElement = Driver.getDriver().findElement(By.xpath("//select[@name='count']"));
        Select option = new Select(selectElement);
        option.selectByValue("36");
        ReusableMethods.waitFor(5);

        js.executeScript("arguments[0].scrollIntoView(true);", ilkerAlloverPage.anaSayfaSonuMyAccount);
        Thread.sleep(3000);

        List<WebElement> addCart = Driver.getDriver().findElements(By.xpath("//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']"));


        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", addCart.get(7));
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", addCart.get(8));

        ReusableMethods.waitFor(3);


        // Sepete eklenen urun sayisi teyit edilir
        int cartaEkliUrunMiktarison = Integer.parseInt(ilkerAlloverPage.cartaEkliUrunAdedi.getText()) - cartaEkliUrunMiktari;
        int expectedEklenenUrunMiktari = 2;
        Assert.assertEquals(cartaEkliUrunMiktarison, expectedEklenenUrunMiktari);
        ReusableMethods.waitFor(5);


        js.executeScript("arguments[0].click();", ilkerAlloverPage.myAccountaSignOutIleGit);
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].scrollIntoView(true);", ilkerAlloverPage.anaSayfaSonuMyAccount);
        js.executeScript("arguments[0].click();", ilkerAlloverPage.logOutMyAccountSayfasinda);
        ReusableMethods.waitFor(3);


    }


}




