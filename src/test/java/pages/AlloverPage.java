package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AlloverPage {
    public AlloverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='WELCOME TO ALLOVER COMMERCE...']")
    public WebElement anasayfa;
    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerButton;
    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAVendorButton;
    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement vendorRegistrationText;
    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement registerEmailBox;
    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement mailSentText;
    @FindBy(xpath = "//*[@id='wcfm_membership_registration_form_expander']")
    public WebElement emailButton;
    @FindBy(xpath = "(//*[@class='required'])[3]")
    public WebElement passwordButton;
    @FindBy(xpath = "//*[@id='passoword']")
    public WebElement password2GirisiButton;
    @FindBy(xpath = "//*[@id='confirm_pwd']")
    public WebElement confirm2PasswordGirisButton;
    @FindBy(xpath = "//*[@class='confirm_pwd wcfm_ele wcfm_title']")
    public WebElement confirmPasswordButton;

    @FindBy(xpath = "//input[@id='wcfm_membership_register_button']")
    public WebElement confirmPassword2RegisterButton;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement vendorRegPasswordUyariText;

    @FindBy(xpath = "//*[@class='whsOnd zHQkBf']")
    public WebElement googleSıgnIn;
    @FindBy(xpath = "//*[text()='Next']")
    public WebElement googleSıgnInNextButton;

    @FindBy(xpath = "(//span[@jsname='V67aGc'])[2]")
    public WebElement googlePaswordNext;
    @FindBy(xpath = "//*[@name='Passwd']")
    public WebElement googlePassword;

    @FindBy(xpath = "//span[@id='email']")
    public WebElement fakeEmailBox;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement vendorRegEmailBox;

    @FindBy(xpath = "//span[@id='email']")
    public WebElement fake1EmailBox;
    @FindBy(xpath = "(//*[text()='Allover Commerce '])[1]")
    public WebElement fakeEmailGelen;
    @FindBy(xpath = "//span[@id='predmet']")
    public WebElement fakeEmailGelenCod;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement vendorRegCodeBox;
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement vendorRegCodeUyariText;
    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement vendorRegPasswordBox;
    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement vendorRegConfirmPasswordBox;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement vendorRegisterButton;
    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement vendorRegMailUyariText;
    @FindBy(xpath = "//*[text()='Welcome to Allover Commerce!']")
    public WebElement vendorRegOnayText;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement vendorRegMailUniceUyariText;
    @FindBy(xpath = "(//tbody/tr[@jscontroller='ZdOxDb'])[1]")
    public WebElement firstMailBox;
    @FindBy(xpath = "(//b)[2]")
    public WebElement verificationCode;
    @FindBy(xpath = "//*[@class='wcfm-text wcfm_email_verified_input']")
    public WebElement verifikasyonCodeBox;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement afterVerfyRegisterButton;
    @FindBy(xpath = "//*[@id='password_strength']")
    public WebElement passwordUyariText;
    @FindBy(xpath = "//*[@class='wcicon-status-cancelled']")
    public WebElement passwordAfterComingText;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement emailErrorText;
    @FindBy(xpath = "//*[@class='gb_A gb_La gb_f']")
    public WebElement newWindow;
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement anasayfaSignInButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement sayfa2EmailAdressButton;
    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement ikinciSayfaSignInButton;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement myAccountSignOutLink;
    @FindBy(xpath = "//*[@class='myaccount-content']")
    public WebElement myAccountList;
    @FindBy(xpath = "//*[@class='myaccount-content']")
    public WebElement supportFollowinglogoutMenu;

    @FindBy(xpath = "//*[@href='https://allovercommerce.com/my-account-2/support-tickets/']")
    public WebElement supportTicketsButton;

    @FindBy(xpath = "//*[@href='https://allovercommerce.com/my-account-2/followings/']")
    public WebElement followingsButton;

    @FindBy(xpath = "(//*[@href='https://allovercommerce.com/my-account-2/customer-logout/?_wpnonce=049ba78787'])[1]")
    public WebElement soldakiLogoutButton;
    @FindBy(partialLinkText = "woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link")
    public List<WebElement> dashboardAltindakiLinkler;//HABİBE HOCA BİTİRDİ

}
