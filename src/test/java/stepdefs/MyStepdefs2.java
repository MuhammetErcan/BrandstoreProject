package stepdefs;

import Hook.Hook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Homepage;
import utils.ExcelUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStepdefs2 extends Homepage {
    @Given("control image with getAttribute at homepage")
    public void controlImageWithGetAttributeAtHomePage() {
        for (int i = 0; i < 51; i++) {
            List<WebElement>list=driver.findElements(By.cssSelector("img"));
            for (WebElement webElement : list) {
                Assert.assertFalse(webElement.getAttribute("src").isEmpty());
                Assert.assertTrue(!webElement.getAttribute("src").isEmpty());
            }
        }
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("","Anasayfada tüm resimler tanımlı",Hook.tarihSaat)));
    }

    @Given("user goes to homepage")
    public void userGoesToHomepage() {
        driver.get("https://brandstore.e-shopland.ch");
    }

    @And("go to alle produkte")
    public void goToAlleProdukte() {
        clickTo(lAlleProdukte);
    }

    @When("control image all produkte")
    public void controlImageAllProdukte() {
        isThereImageAllProducts();
    }

    @When("control price all produkte")
    public void controlPriceAllProdukte() {
        isTherePriceAllProducts();
    }

    @When("control kategorien dropdown")
    public void controlKategorienDropdown() {
        controlKategorienDropdownMethod();
    }

    @When("sort by price ascending")
    public void sortByPriceAscending() {
        sortByPriceAscendingMethod();
    }

    @And("sort by price desc")
    public void sortByPriceDesc() {
        sortByPriceDescMethod();
    }

    @And("sort by rating")
    public void sortByRating() {
        sortByRatingMethod();
    }



    @And("filter nach preis")
    public void filterNachPreis() {

        filterNachPreisMethod();
    }

    @And("filter nach farbe\\(colour)")
    public void filterNachFarbeColour() {
        filterMethod(lInputColour,lColourFilterButton,"renk");
    }

    @When("filter nach grosse")
    public void filterNachGrosse() {
        filterMethod(lInputGrosse, lGrasseFilterButton, "grosse");
    }

    @When("filter nach material")
    public void filterNachMaterial() {
        filterMethod(lInputMaterial,lMaterialFilterButton, "material");
    }

    @When("filter nach gender")
    public void filterNachGender() {
        filterMethod(lInputGender,lGenderFilterButton, "gender");
    }
}
