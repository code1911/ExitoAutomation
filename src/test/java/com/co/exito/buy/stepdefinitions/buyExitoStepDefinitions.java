package com.co.exito.buy.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.get("https://www.exito.com/");
        driver.manage().window().maximize();
    }
    @When("select category (.*) and subcategory (.*)")
    public void selectCategoryTecnologiaAndSubcategoryTelevisores(String category, String subcategory) {

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
