package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartCheckout  extends BasePage {
    ;
    @FindBy(xpath = "//ul[contains(@class,'menu-content')]/li/a[@title='Dresses']")
    WebElement menuDresses;
    @FindBy(xpath = "(//a[@class='quick-view'])[2]")
    WebElement secondProduct;


public boolean serchDress(){
    menuDresses.click();
  return   secondProduct.isDisplayed();

}
}
