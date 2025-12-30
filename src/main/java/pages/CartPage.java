package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = ".shopping_cart")
    WebElement cart;




    public boolean isCartVisible() {
        return cart.isDisplayed();
    }
}
