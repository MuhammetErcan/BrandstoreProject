package stepdefs;

import Hook.Hook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Homepage;
import pages.Locators;
import utils.ExcelUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStepdefs3 extends Homepage {
    @When("add and delete favorite random")
    public void addAndDeleteFavoriteRandom() {
        addToFavoriteRandomMethod();
        deleteFavoriteMethod();

    }


    @When("search product on menu and left")
    public void searchProductOnMenuAndLeft() {
        searchProductOnMenuMethod("DNK");
        clickTo(lAlleProdukte);
        searchProductLeft("DNK");
    }


    @When("product comparison")
    public void productComparison() {
        productComparisonMethod();

    }


}
