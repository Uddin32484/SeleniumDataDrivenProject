package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath= "//a[@class='login']")
    WebElement signIn;




    public void clickSignIn() {
        signIn.click();
    }
}
