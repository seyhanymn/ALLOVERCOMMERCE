package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeynepAlloverPage {
    public ZeynepAlloverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        }
            //Zeynep locate'ler
            @FindBy(xpath = "//*[text()='Sign In']")
            public WebElement signIn;
            @FindBy(xpath = "//input[@id='username']")
            public WebElement emailTextBox;
            @FindBy(xpath = "//input[@id='password']")
            public WebElement passwordTextBox;
            @FindBy(xpath = "(//button[@type='submit'])[1]")
            public WebElement signIn2;
            @FindBy(xpath = "//*[text()='Sign Out']")
            public WebElement singOut;
            @FindBy(xpath = "//*[text()='Store Manager']")
            public WebElement storeManager;
            @FindBy(xpath = "//span[normalize-space()='Customers']")
            public WebElement customers;

            @FindBy(xpath = "//*[@class='sorting_asc']")
            public WebElement customerName;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[1]")
            public WebElement customerUsername;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[2]")
            public WebElement customerEmail;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[3]")
            public WebElement customerLocation;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[4]")
            public WebElement customerOrders;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[5]")
            public WebElement customerMoneySpent;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[6]")
            public WebElement customerLastOrder;

            @FindBy(xpath = "(//*[@class='sorting_disabled'])[7]")
            public WebElement customerActions;

            @FindBy(xpath = "//*[@class='dt-button buttons-pdf buttons-html5']")
            public WebElement customerPdf;


            @FindBy(xpath = "//*[@class='dt-button buttons-excel buttons-html5']")
            public WebElement customerExcel;

            @FindBy(xpath = "//*[@class='dt-button buttons-csv buttons-html5']")
            public WebElement customerCsv;

            @FindBy(xpath = "//*[@class='wcfmfa fa-user-plus']")
            public WebElement customerAddNew;

            @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele '])[1]")
            public WebElement customerAddUsername;

             @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele '])[2]")
             public WebElement customerAddEmail;


             @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele '])[3]")
             public WebElement customerAddFirstName;

             @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele '])[4]")
             public WebElement customerAddLastName;

             @FindBy(xpath = "//*[@id=\"wcfm_customer_submit_button\"]")
             public WebElement customerSubmitButton;

             @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele'])[1]")
             public WebElement customerBillingFirstName;

             @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele'])[2]")
             public WebElement customerBillingLastName;

             @FindBy(xpath = "//*[@id=\"bcompany_name\"]")
             public WebElement customerBillingCompanyName;

             @FindBy(xpath = "//*[@id='bphone']")
             public WebElement customerBillingPhone;

             @FindBy(xpath = "//*[@id='baddr_1']")
             public WebElement customerBillingAddress1;

             @FindBy(xpath = "//*[@id='baddr_2']")
             public WebElement customerBillingAddress2;
             @FindBy(xpath = "//select[@id='bcountry']")
             public WebElement customerBillingCountry;

             @FindBy(xpath = "//*[@id='bcity']")
             public WebElement customerBillingCity;

              @FindBy(xpath = "//*[@id='bstate']")
             public WebElement customerBillingState;

              @FindBy(xpath = "//*[@id='bzip']")
             public WebElement customerBillingZip;

             @FindBy(xpath = "//*[@id='same_as_billing']")
             public WebElement sameAsBillingClick;

              @FindBy(xpath = "//*[@id='sfirst_name']")
              public WebElement shippingFirstName;

              @FindBy(xpath = "//*[@id='slast_name']")
              public WebElement shippingLastName;

             @FindBy(xpath = "//*[@id='scompany_name']")
             public WebElement shippingCompanyName;

             @FindBy(xpath = "//*[@id='saddr_1']")
             public WebElement shippingAddress1;

             @FindBy(xpath = "//*[@id='saddr_2']")
             public WebElement shippingAddress2;

             @FindBy(xpath = "//*[@id='scountry']")
             public WebElement shippingCountry;

             @FindBy(xpath = "//*[@id='scity']")
             public WebElement shippingCity;

             @FindBy(xpath = "//*[@id='sstate']")
             public WebElement shippingState;

             @FindBy(xpath = "//*[@id='szip']")
             public WebElement shippingZip;

             @FindBy(xpath = "//*[@class='wcfm-tabWrap']")
             public WebElement shippingTiklanamadi;

        }