package com.co.exito.buy.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

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
        System.out.println(category);
        actor.attemptsTo(
                Click.on(MENU),
                Click.on(MENU_CATEGORY.of(category.trim())),
                Click.on(MENU_SUBCATEGORY.of(subCategory.trim()).waitingForNoMoreThan(Duration.ofSeconds(5))),
                Click.on(BUTTON_SELECT_PRODUCT.waitingForNoMoreThan(Duration.ofSeconds(5)))
        );
    }
    @And("select five product randomly with unit randomly between {int} and {int}")
    public void selectFiveProductRandomlyWithUnitRandomlyBetweenAnd(int min, int max) {

    }
    @Then("validate name price and total the products aggregates to cart")
    public void validateNamePriceAndTotalTheProductsAggregatesToCart() {

    }
    @And("validate number products total")
    public void validateNumberProductsTotal() {

    }


}
