package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = ".product-name")
    WebElement product;



    public boolean isProductDisplayed() {
        return product.isDisplayed();


    }
}
