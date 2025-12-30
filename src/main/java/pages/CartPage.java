package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(css = "[class*='shopping_cart']")
    WebElement cart;




    public void isCartVisible() {
        wait.until((ExpectedConditions.visibilityOf(cart)));

    }
}
