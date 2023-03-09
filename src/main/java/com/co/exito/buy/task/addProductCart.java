package com.co.exito.buy.task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.time.Duration;

import static com.co.exito.buy.userinterfaces.Gallery.*;

public class addProductCart implements Task {

    public int numProduct;
    public int cant;

    public addProductCart(int numProduct, int cant) {
        this.numProduct = numProduct;
        this.cant = cant;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(PRICE_PRODUCT.of(String.valueOf(numProduct)).waitingForNoMoreThan(Duration.ofSeconds(3))),
                Click.on(BUTTON_SELECT_PRODUCT.of(String.valueOf(numProduct)))
        );
        for (int i = 1; i < cant; i++){
            actor.attemptsTo(
                    Click.on(BUTTON_SELECT_CANT_PRODUCT.of(String.valueOf(numProduct))
                            .waitingForNoMoreThan(Duration.ofSeconds(3)))
            );
        }
    }

    public static addProductCart select(int numProduct, int cant){
        return instrumented(addProductCart.class, numProduct, cant);
    }

}
