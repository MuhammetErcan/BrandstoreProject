package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import javax.swing.*;


public interface Locators {

    By lAusblenden = By.xpath("//a[text()='Ausblenden']");
    By lLoignButton=By.xpath("(//i[@class='_mi _before far fa-user-circle'])[1]");
    By lInputUsername=By.cssSelector("input[id='username']");
    By lInputPassword=By.cssSelector("input[id='password']");
    By lLoginSubmitButton=By.cssSelector("button[value='Anmelden']");
    By lAssertLogin=By.cssSelector("h1[class='entry-title']");
    By lDNKLogo=By.xpath("(//img[@class='custom-logo'])[1]");
    By lAlleProdukte=By.xpath("(//span[@class='menu-text'])[2]");
    By lProducts2= By.xpath("//ul[@class='products columns-3']/li");

    By lProducts= By.cssSelector("div[class='astra-shop-summary-wrap'] a h2");
    By lProductsImage=By.xpath("//ul[@class='products columns-3']/li/div/a/img");
    By lNext=By.cssSelector("a[class='next page-numbers']");
    By lPrices=By.cssSelector("div[class='astra-shop-summary-wrap'] span[class='price']");
    By lKategorien=By.cssSelector("span[aria-labelledby='select2-product_cat-container']");
    By lDropdownList = By.cssSelector("ul[class='select2-results__options'] li");
    By lselectedKategorienProducts=By.cssSelector("ul[class='products columns-3'] li");
    By lRowProductsPrices=By.cssSelector("div[class='astra-shop-summary-wrap'] span[class='price']");
    By lSelectSort=By.cssSelector("select[name='orderby']");
    By lAscendingSort=By.cssSelector("option[value='price']");
    By lDecrasingSort=By.cssSelector("option[value='price-desc']");
    By lProductsRating=By.cssSelector("div[class='astra-shop-summary-wrap'] strong[class='rating']");
    By lRatingSort=By.cssSelector("option[value='rating']");
    By lProdukteFilter=By.cssSelector("span[class='astra-woo-filter-text']");
    By lLeftSlider=By.xpath("(//span[@tabindex='0'])[2]");
    By lRightSlider=By.xpath("(//span[@tabindex='0'])[3]");
    By lInputColour=By.xpath("(//input[@class='select2-search__field'])[1]");
    By lColours=By.cssSelector("ul[class='select2-results__options'] li");
    By lColourFilterButton=By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[1]");
    By lGrasseFilterButton=By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[2]");
    By lMaterialFilterButton=By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[3]");
    By lGenderFilterButton=By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[4]");
    By lFarbeSelect=By.cssSelector("select[id='pa_farbe']");
    By lFarbeSelectOptions=By.cssSelector("select[id='pa_farbe'] option");
    By lInformation=By.xpath("(//ul[@class='tabs wc-tabs']/li)[2]");
    By lTable=By.cssSelector("table[class='woocommerce-product-attributes shop_attributes']");
    By lInputGrosse=By.xpath("(//input[@class='select2-search__field'])[2]");
    By lProductsColour= By.xpath("//ul[@class='products columns-3']/li");
    By lProductsGross=By.xpath("//ul[@class='products columns-3']/li");
    By lProductsMaterial=By.xpath("//ul[@class='products columns-3']/li");
    By lInputMaterial=By.xpath("(//input[@class='select2-search__field'])[3]");
    By lInputGender=By.xpath("(//input[@class='select2-search__field'])[4]");
    By lProductsGender=By.xpath("//ul[@class='products columns-3']/li");
    By lAddFavoriteButtons=By.cssSelector("i[class='yith-wcwl-icon fa fa-heart-o']");
    By lProduktsnames=By.cssSelector("h2[class='woocommerce-loop-product__title']");
    By lWunschlist = By.cssSelector("a[title='Zur Wunschliste']");
    By lFavoriteProductNameInWunschlist=By.cssSelector("td[class='product-name'] a");
    By lFavoriteProductNameInWunschlist2=By.cssSelector("h1[class='product_title entry-title']");
    By lRemoveFavoriteButton=By.cssSelector("td[class='product-remove'] a");
    By lLastViewedProduct=By.xpath("(//ul[@class='product_list_widget']//span[@class='product-title'])[1]");
    By lSearchButtonOnMenu=By.xpath("(//a[@class='header-cover astra-search-icon'])[1]");
    By lInputSearch=By.xpath("(//input[@class='search-field'])[1]");
    By lSearchedProducts=By.cssSelector("h2[class='entry-title']");
    By lInputSearchLeft=By.cssSelector("input[type='search']");
    By lAddComparison=By.cssSelector("a[class='compare']");
    By lCloseButton=By.cssSelector("button[id='cboxClose']");
    By lGoToVergleichsliste=By.xpath("(//div[@class='ast-custom-button'])[3]");
    By lVergleischlisteFalse=By.xpath("(//a[@title='Zur Vergleichsliste'])[3]");
    By lComparisonTableRow=By.xpath("(//tr[@class='title odd'])[1]");
    By lComparisonFistProductName=By.xpath("(//tr[@class='title odd'] //td)[1]");
    By lComparisonSecondProductName=By.xpath("(//tr[@class='title odd'] //td)[2]");
    By lProductAddToCartButtons=By.cssSelector("div[class='astra-shop-summary-wrap'] a[data-quantity='1']");
    By lWarenkorb=By.xpath("(//i[@class='_mi _before dashicons dashicons-cart'])[1]");
    By lProductinWarenkorb=By.cssSelector("td[class='product-name'] a");
    By lGrosseButton=By.cssSelector("select[id='pa_groesse']");
    By lOptionsInGross=By.cssSelector("option[class='attached enabled']");
    By lSubmitButtonForProduct=By.xpath("(//button[@type='submit'])[2]");
    By lProductPlus=By.cssSelector("a[id='plus_qty']");
    By lButtonUpdateCart=By.cssSelector("button[name='update_cart']");
    By lproductPriceInCart=By.xpath("(//td[@class='product-price']/span)");
    By lTotalPrice=By.xpath("//td[@class='product-subtotal']/span");
    By lGoExitButton=By.cssSelector("a[class='checkout-button button alt wc-forward']");
    By lInputName=By.cssSelector("input[name='billing_first_name']");
    By lInputSurName=By.cssSelector("input[name='billing_last_name']");
    By lInputRegion=By.cssSelector("input[name='billing_address_1']");
    By lPostCode=By.cssSelector("input[name='billing_postcode']");
    By lCity=By.cssSelector("input[name='billing_city']");
    By lSelectKantonButton=By.cssSelector("select[name='billing_state']");
    By lSelectAargau=By.cssSelector("select[name='billing_state'] option[value='AG']");
    By lPhone=By.cssSelector("span[class='woocommerce-input-wrapper'] input[type='tel']");
    By lEmail=By.cssSelector("span[class='woocommerce-input-wrapper'] input[type='email']");
    By lContinue=By.cssSelector("a[class='flex-next button']");
    By lCreeditCartButton=By.cssSelector("input[id='payment_method_woocommerce_payments']");
    By lcheckBox=By.xpath("(//input[@type='checkbox'])[3]");
    By lSendButton=By.cssSelector("button[class='button alt']");
    By lTextForBuy=By.cssSelector("p[class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
    By lBestSellerNum=By.xpath("//li[@class='woocommerce-order-overview__order order']/strong");
    By lMeinKonto=By.cssSelector("li[id='menu-item-3194']");
    By lGoToBestellungenButton=By.xpath("//a[text()='letzten Bestellungen']");
    By lBestellungNum=By.xpath("((//td[@data-title='Bestellung'])/a)[1]");










}
