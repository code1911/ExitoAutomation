package com.co.exito.buy.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Menu {

  public Menu() {
  }

  public static final Target MENU = Target.the("").located(By.xpath("//div[@class='exito-category-menu-3-x-button']/button"));
  public static final Target MENU_CATEGORY = Target.the("").locatedBy("//p[text()='{0}']");
  public static final Target MENU_SUBCATEGORY = Target.the("").locatedBy("//*[text()='{0}']");


}
