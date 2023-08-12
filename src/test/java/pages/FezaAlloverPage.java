package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FezaAlloverPage {

        public     FezaAlloverPage(){
                PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;
    @FindBy (xpath = "//input[@id='username']")
    public WebElement emailTextBox;
    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextBox;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement signIn2;
    @FindBy (xpath = "//*[text()='Sign Out']")
    public WebElement singOut;
    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;
    @FindBy (xpath = "//span[normalize-space()='Coupons']")
    public WebElement coupons;
    @FindBy(xpath = "//span[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']")
    public WebElement addNewButton;
    @FindBy(xpath = "//h2[normalize-space()='Add Coupon']")
    public WebElement addCouponText;
    @FindBy (xpath = "//input[@id='title']")
    public WebElement couponCodeTextSatır;
    @FindBy (xpath = "(//input[@type='submit'])[1]")
    public WebElement couponsSubmit;
    @FindBy (xpath = "//*[@id='wcfm-coupons']/tbody/tr[1]/td[1]")
    public WebElement couponsKodu;
    @FindBy (xpath = "//*[@id='wcfm-coupons']/tbody/tr[1]/td[6]/a[2]")
    public WebElement couponsKoduDelete;
    @FindBy (xpath = "//textarea[@id='description']")
    public WebElement descriptionTextSatir;
    @FindBy (xpath = "//select[@id='discount_type']")
    public WebElement discountTypeDDM;
    @FindBy (xpath = "(//span[@class='coupon-types coupon-types-percent'])[1]")
    public WebElement discountTypeTextArea;
    @FindBy (xpath = "//input[@class='wcfm-text wcfm_non_negative_input wcfm_ele']")
    public WebElement CouponAmountTextArea;
    @FindBy (xpath = "//input[@id='expiry_date']")
    public WebElement couponExpiryDate;
    @FindBy (xpath = "//input[@id='free_shipping']")
    public WebElement allowFreeShipping;
    @FindBy(xpath = "//*[@id='wcfm-coupons']/tbody/tr[1]/td[3]")
    public WebElement couponAmountDogrulama;
    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement showOnStore;
    @FindBy(xpath = "//*[@id='wcfm-coupons']/tbody/tr[1]/td[5]")
    public WebElement couponExpiryDateDogrulama;
    @FindBy(xpath = "//*[@id='coupons_manage_restriction']")
    public WebElement restriction;
    @FindBy(xpath = "//*[@id='minimum_amount']")
    public WebElement minimumSpendTextArea;

    @FindBy(xpath = "//*[@id='maximum_amount']")
    public WebElement maximumSpendTextArea;

    @FindBy(xpath = "//input[@id='individual_use']")
    public WebElement individualUseOnly;

    @FindBy(xpath = "//*[@id='coupons_manage_restriction_expander']/span[1]/span[1]/span/ul/li/input")
    public WebElement excludeProducts;

    @FindBy(id = "coupons_manage_restriction_expander")
    public WebElement excludeProductsNew;

    @FindBy(xpath = "//*[@id='coupons_manage_restriction_expander']/span[4]/span[1]/span/ul/li/input")
    public WebElement excludeCategories;

    @FindBy(xpath = "//div[@id='coupons_manage_limit']")
    public WebElement limit;

    @FindBy(xpath = "//*[@id='usage_limit']")
    public WebElement usagelimitPerCoupon;

    @FindBy(id = "coupons_manage_limit_expander")
    public WebElement usagelimitArea;

    @FindBy(xpath = "//*[@id='limit_usage_to_x_items']")
    public WebElement limitUsageToXItems;

    @FindBy(xpath = "//*[@id='usage_limit_per_user']")
    public WebElement usagelimitperuser;

    @FindBy(xpath = "//*['@id=header']/div/div/div/div/div/div[9]/div/div/a")
    public WebElement signOut;
    @FindBy(xpath = "//*[@id='main']/div/div/div/div/div/div/div/div[2]/p[1]/a")
    public WebElement logOut;



}

