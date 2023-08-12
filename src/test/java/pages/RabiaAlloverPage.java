package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RabiaAlloverPage {
    public RabiaAlloverPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class=\"w-icon-account\"]")
    public WebElement IlkSignIn;
    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement email;
    @FindBy(xpath = "//*[@name=\"login\"]")
    public WebElement signIn;
    @FindBy(xpath = "(//*[text()=\"My Account\"])[2]")
    public WebElement myAccount;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;
    @FindBy(xpath = "(//*[@class=\"wcfm_menu_item \"])[3]")
    public WebElement products;
    @FindBy(xpath = "//*[@class=\"sorting_disabled\"][4]")
    public WebElement status;
    @FindBy(xpath = "//*[@class=\"sorting_disabled\"][5]")
    public WebElement stock;
    @FindBy(xpath = "(//*[@class=\"sorting\"])[2]")
    public WebElement price;
    @FindBy(xpath = "//*[@class=\"sorting_asc\"]")
    public WebElement date;
    @FindBy(xpath = "(//*[@class=\"text\"])[18]")
    public static WebElement addNew;

    @FindBy(xpath = "(//*[text()='Virtual'])[1]")
    public WebElement virtualText;
    @FindBy(xpath = "(//*[text()='Downloadable'])[1]")
    public WebElement downloadableText;
    @FindBy(xpath = "//input[@name=\"pro_title\"]")
    public WebElement productTitle;
    @FindBy(xpath = "//*[@id=\"product_type\"]")
    public WebElement simpleProduct;
    @FindBy(xpath = "(//*[@class=\"placeHolder\"])[1]")
    public WebElement buyukGorselEkleButonu;
    @FindBy(xpath = "(//*[@class='placeHolder'])[1]")
    public WebElement kucukGorselEkleButonu;
    @FindBy(xpath = "//*[@id=\"menu-item-browse\"]")
    public WebElement mediaLibrary;
    @FindBy(xpath = "(//*[@class='media-menu-item active'])[4]")
    public WebElement mediaLibrary2;
    @FindBy(xpath = "//*[@class=\"button media-button button-primary button-large media-button-select\"]")
    public WebElement selectButon;
    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGallery;

    @FindBy(xpath = "//*[@data-id=\"excerpt\"]")
    public WebElement shortDescription;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement description;
    @FindBy(xpath = "//*[@id=\"insert-media-button\"]")
    public WebElement addMediaUst;
    @FindBy(xpath = "//*[@id=\"wcfm_products_simple_submit_button\"]")
    public WebElement submit;
    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public static WebElement addNeww;

    //resimler
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[8]")
    public WebElement kahverengiKazak;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[29]")
    public WebElement kahverengiKazak2;
    @FindBy(xpath = "(//*[@class='thumbnail'])[21]")
    public WebElement cVitamini;
    @FindBy(xpath = "(//*[@class=\"attachment save-ready\"])[19]")
    public WebElement iPhone;
    @FindBy(xpath = "(//*[@class=\"attachment save-ready\"])[11]")
    public WebElement koltukTakimi;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[94]")
    public WebElement kitap;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[93]")
    public WebElement jbl;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[91]")
    public WebElement ruj;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[89]")
    public WebElement tisort;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[89]")
    public WebElement zekaKupu;
    @FindBy(xpath = "(//*[@class=\"thumbnail\"])[89]")
    public WebElement takiSeti;


    //checkbox kategoriler
    @FindBy(xpath = "(//*[@type=\"checkbox\"])[18]")
    public WebElement clothing;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[9]")
    public WebElement besinTakviyesi;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[19]")
    public WebElement electronics;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[26]")
    public WebElement evYasam;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[35]")
    public WebElement games;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[65]")
    public WebElement kozmetik;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[72]")
    public WebElement modaGiyim;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[80]")
    public WebElement takiAksesuar;
    @FindBy(xpath = "(//*[@name=\"product_cats[]\"])[81]")
    public WebElement toysGames;
    @FindBy(xpath = "(//*[@type=\"checkbox\"])[101]")
    public WebElement defacto;


}
