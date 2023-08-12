package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RüveydaAlloverPage {

    public RüveydaAlloverPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//*[contains (text(), 'Sign In')]")
    public WebElement signInButonu;

    @FindBy(xpath = "// input[@id='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement singInButonu2;

    @FindBy(xpath = "(//*[contains (text(), 'My Account')])[2]")
    public WebElement myAccount;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy(xpath = "//a[@id='add_new_product_dashboard']")
    public WebElement addNew;

    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement featuredImg;

    @FindBy(xpath = "//button[@class='media-menu-item']")
    public WebElement mediaLibrary;

    @FindBy(xpath = "(//div[@class='centered'])[41]")
    public WebElement telefonResmi2;

    @FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-select']")
    public WebElement selectButonu;

    @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
    public WebElement galleryImg;

    @FindBy(xpath = "(//button[@class='button media-button button-primary button-large media-button-select'])[2]")
    public WebElement addToGallery;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_cat '])[18]")
    public  WebElement checkBox;

    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStocksBox;

    @FindBy(xpath = "(//div[@class='centered'])[20]")
    public WebElement telefonResmi;

    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement submitButonu;

    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement singOutButonu;

    @FindBy(xpath = "//select[@id='backorders']")
    public WebElement dropDown;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement shippingSekmesi;

    @FindBy(xpath = "//input[@id='width']")
    public WebElement weight;

    @FindBy(xpath = "//input[@id='length']")
    public WebElement  length;

    @FindBy(xpath = "//input[@id='weight']")
    public WebElement width;

    @FindBy(xpath = "//input[@id='height']")
    public WebElement height;

    @FindBy(xpath = "//select[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;

    @FindBy(xpath = "(//span[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[9]")
    public WebElement electronics;

    @FindBy(xpath = "//span[@class='product-status product-status-publish']")
    public WebElement successMessage;




}
