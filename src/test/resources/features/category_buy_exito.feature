#encoding: utf-8
Feature: Escenario para comprar productos en el exito por diferente categprias

  Scenario Outline: Buy for category and subcategory
    Given navigate to exito page
    When select category <category> and subcategory <subcategory>
    And select five product randomly with unit randomly between 1 and 10
    Then validate name price and total the products aggregates to cart
    And validate number products total

    Examples:
      | category         | subcategory     |
      | tecnología       | televisores     |
      | hogar y muebles  | comedores       |