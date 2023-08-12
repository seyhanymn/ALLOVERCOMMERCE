package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IlkerAlloverPage {

    public IlkerAlloverPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//span[text()='Sign In']")
    public WebElement anasayfaSignInButton;

    @FindBy (xpath = "//input[@id='username']")
    public WebElement signInEmailAdresBoxPopUp;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement signInPasswordBoxPopUp;

    @FindBy (xpath = "//*[@id=\"signin\"]/form/button")
    public WebElement signInSubmitPopUp;

    @FindBy (xpath = "//li[@id='menu-item-1079']")
    public WebElement anaSayfaSonuMyAccount;

    @FindBy (xpath = "//a[@class='login logout inline-type']")
    public WebElement myAccountaSignOutIleGit;

    @FindBy (xpath = "//a[text()='Orders']")
    public WebElement myAccountSayfasindaOrders;

    @FindBy(xpath = "//a[text()='Go Shop']")
    public WebElement ordersSayfasindaGoShopButtonu;

    @FindBy (xpath = "//li[text()='Shop']")
    public WebElement goShopIleAcilanSayfadakiShopText;

    @FindBy (xpath = "/html/body/div[2]/header/div/div/div/div/div/div[6]/div/div/a/i")
    public WebElement addCartButtonuAnasayfa;

    @FindBy (xpath = "//*[@id='header']/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[1]")
    public WebElement addCartTiklaAcilanViewCartButonPopUp;

    @FindBy (xpath = "//a[@href='https://allovercommerce.com/checkout-2/']")
    public WebElement addCartTiklaAcilanCheckoutButonPopUp;

    @FindBy (xpath = "//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public WebElement addCartKucukSimge;

    @FindBy (xpath = "/html/body/div[2]/main/div/div/div/div[4]/ul/li[9]/div/figure/div/a[1]")                                          //a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']"
    public WebElement addCartIleUrunEkle;

    @FindBy (xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure/div[2]/a[1]")
    public WebElement addCartIleUrunEkle1;

    @FindBy (xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[17]/div/figure/div/a[1]")
    public WebElement addCartIleUrunEkle2;

    @FindBy (xpath = "//*[@id='main']/div/div/div/div[4]/ul/li[9]/div/figure/div/a[1]")
    public WebElement addCartIleUrunEkle3;

    @FindBy (xpath = "//*[@id='main']/div/div/div/div[4]/ul/li[26]/div/figure/div[2]/a[1]")
    public WebElement addCartIleUrunEkle4;

    @FindBy (xpath = "(//a[@href='?add-to-cart=14661'])[2]")
    public WebElement addCartIleUrunEkle5;

    @FindBy (xpath = "/html/body/div[2]/header/div/div/div/div/div/div[6]/div/div/a/i/span" )
    public WebElement cartaEkliUrunAdedi;

    @FindBy (xpath = "(//a[@href='https://allovercommerce.com/checkout-2/'])[2]")
    public WebElement viewCarttaCheckoutTikla;

    @FindBy (xpath = "//input[@id='billing_first_name']")
    public WebElement billingDetailsFirstName;

    @FindBy (id = "//select[@id='billing_country']")
    public WebElement billingDetailsCountryRegionDropDown;

    @FindBy (xpath = "//select[@id='billing_state']")
    public WebElement billingDetailsStateDropDown;

    @FindBy (xpath = "//button[@id='place_order']")
    public WebElement billingDetailsPlaceOrder;

    @FindBy (xpath = "//p[text()='Thank you. Your order has been received.']")
    public WebElement orderCompleteYazisi;

    @FindBy (xpath = "//button[@name='update_cart']")
    public WebElement updateCartButton;

    @FindBy (id = "customer_details")
    public WebElement billingDetailsTable;

    @FindBy (xpath = "//*[@id=\"main\"]/div/div/div/div[4]")
    public WebElement shoppingSayfasindaAcilanUrunListe;

    @FindBy (xpath = "//p[@class='stock in-stock']")
    public WebElement urunSayfasindakiStokDurumu;

    @FindBy (xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement urunSayfasindaAdtoCartButonu;

    @FindBy (xpath = "//button[@name='clear_cart']")
    public WebElement viewCarttaClearCart;

    @FindBy  (xpath = "(//*[@class='quantity-plus w-icon-plus'])[1]")
    public WebElement urunMiktarArttirma1Row;

    @FindBy (xpath = "(//*[@class='col-lg-8 pr-lg-4'])[1]")
    public WebElement quantity;

    @FindBy (xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement urunMiktarAzaltma1Row;

    @FindBy (xpath = "(//input[@class='input-text qty text'])[1]")
    public WebElement viewCartUrunQuntity1Row;

    @FindBy (xpath = "//p[@class='return-to-shop']")
    public WebElement returnShopButonu;

    @FindBy (xpath = "//*[@id='main']/div/div/div/div/div/div[2]/div[1]/form/table/tbody/tr[1]/td[5]/span")   //"(//span[@class='woocommerce-Price-amount amount'])[4]")
    public WebElement siparisSubtotal;

    @FindBy (xpath = "//button[@name='apply_coupon']")
    public WebElement applayCouponButton;

    @FindBy (xpath = "//a[@href='https://allovercommerce.com/shop/']")
    public WebElement continueShoppingButton;

    @FindBy (xpath = "//div[@class='cart-information']")
    public WebElement sagTarafShippingVeTotalRakam;

    @FindBy (xpath = "//p[@class='cart-empty woocommerce-info']")
    public WebElement yourCartCurrentlyEmpty;

    @FindBy  (xpath = "//a[text()='Log out']")
    public WebElement logOutMyAccountSayfasinda;


}






