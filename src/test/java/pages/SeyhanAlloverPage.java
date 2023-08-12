package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SeyhanAlloverPage {

    public SeyhanAlloverPage(){
        PageFactory.initElements(Driver.getDriver(), this);}



       @FindBy(xpath="//*[text()='Store Manager']")
        public WebElement systoreManager;
    @FindBy(xpath = "//*[text()='WELCOME TO ALLOVER COMMERCE...']")
    public WebElement syanasayfa;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement symyAccountSignOutLink;
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement syanasayfaSignInButton;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement syikinciSayfaEmailAdressButton;
    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement syikinciSayfaSignInButton;
    @FindBy(xpath = "//span[text()='Register']")
    public WebElement syregisterButton;
        @FindBy(xpath = "//main//div[6]//a//span[2]")
     public WebElement systoreManagerPageOrders;
       @FindBy (xpath = "(//tbody//tr//td[9]//a[3])[1]")
        public WebElement systoreManagerPageOrdersRefundRequest;
       @FindBy(xpath="//select[@id='wcfm_refund_request']")
        public WebElement sypartialRefundOrdersRefund;
        @FindBy(xpath="//select[@class='wcfm_popup_input wcfm_refund_input_qty wcfm_refund_input_ele']")
        public WebElement syRefundByItemQTY;
        @FindBy(xpath="//input[@class='wcfm_popup_input wcfm_refund_input_total wcfm_refund_input_ele']")
        public WebElement syRefundByItemTotal;
        @FindBy(xpath="//textarea[@id='wcfm_refund_reason']")
        public WebElement syRefundRequestReason;
        @FindBy(xpath="//input[@id='wcfm_refund_requests_submit_button']")
        public WebElement syRefundRequestSubmit;

       @FindBy(xpath="//main//div[9]//span[2]")
        public WebElement systoreMAnagerRefund;
        @FindBy(xpath="//th[@class='sorting_disabled']")
        public List<WebElement> systoreMAnagerRefundRequestOrderTypeReason;
        @FindBy(xpath="//th[text()='Date'][1]")
        public WebElement systoreMAnagerRefundRequestDate;
        @FindBy(xpath="//span[@class='wcfm_dashboard_item_title']")
        public List<WebElement> syRefundRequestId;
        @FindBy(xpath="//a[@class='wcfm_dashboard_item_title transaction_order_id']")
        public List<WebElement> syRefundOrderId;
       @FindBy(xpath="//tbody/tr//td[4]//span//bdi")
        public List<WebElement> syRefundAmaunt;
        @FindBy(xpath="//tbody/tr//td[5]")
        public List<WebElement> syRefundType;
        @FindBy(xpath="//tbody/tr//td[6]")
        public List<WebElement> syRefundReason;
        @FindBy(xpath="//tbody/tr//td[2]")
       public List<WebElement> syRefundRequestIdProduct;
    @FindBy(xpath="//tbody/tr//td[3]")
    public List<WebElement> syRefundOrdeerIdProduct;
    @FindBy(xpath="//tbody/tr//td[4]")
    public List<WebElement> syRefundAmauntProduct;
    @FindBy(xpath="//tbody/tr//td[5]")
    public List<WebElement> syRefundTypedProduct;
    @FindBy(xpath="//tbody/tr//td[6]")
    public List<WebElement> syRefundReosonProduct;
    @FindBy(xpath="//tbody/tr//td[7]")
    public List<WebElement> syRefundDateProduct;
}
