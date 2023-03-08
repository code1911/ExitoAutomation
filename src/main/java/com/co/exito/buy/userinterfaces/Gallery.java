package com.co.exito.buy.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Gallery {

    public Gallery() {
    }

    public static final Target ITEMS = Target.the("").located(By.xpath("//*[@id='gallery-layout-container']/div"));
    public static final Target ITEM = Target.the("").locatedBy("//*[@id='gallery-layout-container']/div[{0}]");
    public static final Target PRICE_PRODUCT = Target.the("").locatedBy("//*[@id='gallery-layout-container']/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[1]/div/div/div[4]/div[2]/div/span");
    public static final Target NAME_PRODUCT = Target.the("").locatedBy("//*[@id='gallery-layout-container']/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[1]/div/div/div[3]/div/div/div/h3/span");
    //public static final Target BUTTON_SELECT_PRODUCT = Target.the("").locatedBy("//*[@id='gallery-layout-container']/div[{0}]//span[contains (text(),'Compra') or text() = 'Agregar']");
    public static final Target BUTTON_SELECT_PRODUCT = Target.the("").locatedBy(" //*[@id='gallery-layout-container']/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/button");

    public static final Target BUTTON_SELECT_CANT_PRODUCT = Target.the("").locatedBy("//*[@id='gallery-layout-container']/div[{0}]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/button/span[contains (@class, 'more')]");
//*[@id="gallery-layout-container"]/div[11]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/span
//*[@id="gallery-layout-container"]/div[11]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/span
//*[@id="gallery-layout-container"]/div[11]/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/button/span
}