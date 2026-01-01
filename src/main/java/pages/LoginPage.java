package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "emailll")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement loginBtn;



    public void login(String user, String pass) {
        email.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
