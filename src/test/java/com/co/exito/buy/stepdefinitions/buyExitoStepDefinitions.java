package com.co.exito.buy.stepdefinitions;

import com.co.exito.buy.task.addProductCart;
import com.co.exito.buy.utils.randomNumber;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.HashMap;
import static com.co.exito.buy.userinterfaces.Gallery.*;
import static com.co.exito.buy.userinterfaces.Menu.*;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class buyExitoStepDefinitions {

    @Managed(driver = "chrome")
    public WebDriver driver;
    private final Actor actor = Actor.named("jhon");

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        actor.can(BrowseTheWeb.with(driver));
    }
    @Given("navigate to exito page")
    public void navigateToExitoPage() {
        driver.manage().window().maximize();
        driver.get("https://www.exito.com/");
    }
    @When("^select category (.*) and subcategory (.*)$")
    public void selectCategoryAndSubcategory(String category, String subCategory) {
        actor.attemptsTo(
                Click.on(MENU),
                Click.on(MENU_CATEGORY.of(category.trim())),
                Click.on(MENU_SUBCATEGORY.of(subCategory.trim()).waitingForNoMoreThan(Duration.ofSeconds(5)))
        );
    }
    @And("select five product randomly with unit randomly between {int} and {int}")
    public void selectFiveProductRandomlyWithUnitRandomlyBetweenAnd(int min, int max) {
        randomNumber random = new randomNumber();
        //int totalProductsGallery = ITEMS.waitingForNoMoreThan(Duration.ofSeconds(5)).resolveAllFor(actor).toArray().length;
        int totalProductsGallery = 11;

        HashMap<String, String> listProducts = new HashMap<>();
        for (int i = 1; i <= 1; i++){
            int cant = random.randomNumberInt(min, max);
            int numProduct = random.randomNumberInt(1, totalProductsGallery);
            actor.attemptsTo(
                    Scroll.to(ITEM.of(String.valueOf(numProduct)).waitingForNoMoreThan(Duration.ofSeconds(3))),
                    addProductCart.select(numProduct, cant)
            );
            listProducts.put("name", NAME_PRODUCT.of(String.valueOf(numProduct)).resolveFor(actor).getText());
            listProducts.put("price", PRICE_PRODUCT.of(String.valueOf(numProduct)).resolveFor(actor).getText());
            listProducts.put("cant", String.valueOf(cant));

        }
        actor.remember("listProducts", listProducts);
    }
    @Then("validate name price and total the products aggregates to cart")
    public void validateNamePriceAndTotalTheProductsAggregatesToCart() {

    }
    @And("validate number products total")
    public void validateNumberProductsTotal() {

    }


}
