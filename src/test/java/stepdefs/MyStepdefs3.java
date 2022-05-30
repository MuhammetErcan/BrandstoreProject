package stepdefs;

import io.cucumber.java.en.When;
import pages.Homepage;


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
