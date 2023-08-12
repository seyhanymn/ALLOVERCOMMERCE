package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class YAlloverPage {

    public YAlloverPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement sign;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement email;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "(//*[text()='Sign In'])[2]")
    public WebElement sign2;



    @FindBy(xpath = "//*[@class='login logout inline-type']")
    public WebElement signOut;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    public WebElement orders;

    @FindBy(xpath = "(//*[@class='woocommerce-orders-table__row woocommerce-orders-table__row--status-on-hold order'])")
    public List<WebElement> liste;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--downloads']")
    public WebElement dowlands;

    @FindBy(xpath = "//*[@class='page-content']")
    public WebElement ekranresmi;

    @FindBy(css = ".icon-box-icon.icon-addresses")
    public WebElement adresler;



    @FindBy(xpath = "(//*[@class='woocommerce-Address'])[1]")
    public List<WebElement> bulıngadres;

    @FindBy(xpath = "(//*[@class='woocommerce-Address'])[2]")
    public List<WebElement>  shıppınadres;

    @FindBy(xpath = "//*[@class='icon-box-icon icon-account']")
    public WebElement hesapdetaylari;

    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emailgüncelle;

    @FindBy(xpath = "//*[@id='password_current']")
    public WebElement paswordtekrar;

    @FindBy(xpath = "//*[text()='Account details changed successfully.']")
    public WebElement popMessage;


}
