package com.co.exito.buy.stepdefinitions;

import com.co.exito.buy.task.addProductCart;
import com.co.exito.buy.utils.randomNumber;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.*;

import static com.co.exito.buy.userinterfaces.Cart.*;
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
        int totalProductsGallery = ITEMS.resolveAllFor(actor).size();
        System.out.println(totalProductsGallery);
        HashMap<String, List<String>> listProducts = new HashMap<>();
        Set<Integer> nums = random.randomNumberIntSet(1, totalProductsGallery);
        for (int numProduct : nums){
            List<String> listProduct = new ArrayList<>();
            int cant = random.randomNumberInt(min, max);
            actor.attemptsTo(
                    Scroll.to(PRICE_PRODUCT.of(String.valueOf(numProduct)).waitingForNoMoreThan(Duration.ofSeconds(3))),
                    addProductCart.select(numProduct, cant)
            );
            listProduct.add(NAME_PRODUCT.of(String.valueOf(numProduct)).resolveFor(actor).getText());
            listProduct.add(PRICE_PRODUCT.of(String.valueOf(numProduct)).resolveFor(actor).getText());
            listProduct.add(String.valueOf(cant));
            listProducts.put("Product"+numProduct, listProduct);
        }
        actor.remember("listProducts", listProducts);
    }
    @Then("validate name price and total the products aggregates to cart")
    public void validateNamePriceAndTotalTheProductsAggregatesToCart() {
        actor.attemptsTo(
                Click.on(CART.waitingForNoMoreThan(Duration.ofSeconds(5)))
        );

    }
    @And("validate number products total")
    public void validateNumberProductsTotal() {
        int totalProductsGallery = CART_ITEMS.resolveAllFor(actor).size();
    }


}
