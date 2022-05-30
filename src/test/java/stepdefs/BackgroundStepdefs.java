package stepdefs;

import Hook.Hook;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Homepage;
import utils.Driver;
import utils.ExcelUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BackgroundStepdefs extends Homepage {

    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        goToUrl(url);
    }

    @And("go to Login page")
    public void goToLoginPage() {
        clickTo(lAusblenden);
        clickTo(lLoignButton);
    }

    @When("login with username {string} and password {string}")
    public void loginWithUsernameAndPassword(String username, String pass) {
        sendKeysTo(lInputUsername,username);
        sendKeysTo(lInputPassword,pass);
        clickTo(lLoginSubmitButton);
        Assert.assertTrue(driver.findElement(lAssertLogin).getText().contains("Mein Konto"));
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","Dogru kullanici ve sifre ile giris yapildi",ExcelUtility.getCurrentTime())));
    }


    @Then("driver quit")
    public void driverQuit() {
        quitDriver();
    }

    @When("click random product")
    public void clickRandomProduct() {
        List<WebElement> list=driver.findElements(lProduktsnames);
        int randomSayi=(int) (Math.random()*list.size());
        String productName=list.get(randomSayi).getText();
        clickTo(list.get(randomSayi));
        clickTo(lAlleProdukte);

        String lastVievedProduktName=driver.findElement(lLastViewedProduct).getText();

        Assert.assertEquals(productName,lastVievedProduktName);

        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","Enson tiklanan ürün sol kategoriler altinda bulunan Son görüntülenenler kisminda listeleniyor",ExcelUtility.getCurrentTime())));

    }

    @Given("add product to cart")
    public void addProductToCart() {
        addProductToCartMethod();
        updateCartMethod();
    }


    @And("buy product")
    public void buyProduct() {
        buyProductMethod();
    }
}
