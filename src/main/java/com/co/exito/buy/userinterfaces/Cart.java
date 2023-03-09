package com.co.exito.buy.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Cart {


    public Cart() {
    }

    public static final Target CART = Target.the("").located(By.xpath("//div[@class='exito-header-3-x-minicartContainer ']"));

    public static final Target CART_ITEMS = Target.the("")
            .located(By.xpath("//*[@id='cartLoadedDiv']/div[2]/table/tbody/tr[@class='product-item']"));
    public static final Target NAME_PRODUCTS_CART = Target.the("").locatedBy("//tr[@class='product-item'][{0}]/td/a[@class='exito-checkout-product-name']");
    public static final Target PRICE_PRODUCTS_CART = Target.the("").locatedBy("//tr[@class='product-item'][{0}]/td[@class='quantity-price']/span[@class='total-selling-price']");
    public static final Target CANT_PRODUCTS_CART = Target.the("").locatedBy("//tr[@class='product-item'][{0}]/td[@class='quantity']/input");

}
