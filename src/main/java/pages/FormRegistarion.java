package pages;

import base.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.Random;

public class FormRegistarion extends BasePage {


    Random random = new Random();

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    WebElement createAccountText;
    @FindBy(css = "#email_create")
    WebElement createAccountEmail;

    @FindBy(css = "[name*='SubmitCreate'][type='submit']")
    WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id='id_gender1']")
    WebElement male;
    @FindBy(id= "customer_firstname")
    WebElement firstName;
    @FindBy(id= "customer_lastname")
    WebElement lastName;
    @FindBy(id= "passwd")
    WebElement password;
    @FindBy(xpath= "//select[@class='form-control' and @id='days']")
    WebElement days;
    @FindBy(xpath= "//div[@class='row']//select[@id='months']")
    WebElement months;
    @FindBy(xpath= "//div[@class='row']//select[@id='years']")
    WebElement years;
    @FindBy(id = "submitAccount")
    WebElement registrationButton;
    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    WebElement successMessage;




    public void setEmail(String email) {
        createAccountEmail.sendKeys(email);
    }
    public void clickCreateAccount() {
        createAccountBtn.click();
    }
    public boolean isCreateAccountTextDisplayed() {
        return createAccountText.isDisplayed();
    }

    public boolean validateEmail(String email) {

         boolean displayed = isCreateAccountTextDisplayed();
         wait.until(ExpectedConditions.visibilityOf(createAccountEmail)).sendKeys(email);
         clickCreateAccount();
         return displayed;

    }

    public void fillRegistrationForm(String firstname, String lastname, String pass,String day, String month, String year ) {

        wait.until(ExpectedConditions.elementToBeClickable(male)).click();
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(firstname);
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(lastname);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(days));
        new Select(days).selectByValue(String.valueOf(day));
        wait.until(ExpectedConditions.elementToBeClickable(months));
        new Select(months).selectByIndex(Integer.parseInt(month));
        wait.until(ExpectedConditions.elementToBeClickable(years));
        new Select(years).selectByValue((year));
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
       wait.until((ExpectedConditions.visibilityOf(successMessage))).isDisplayed();





    }



    public String getFakeEmail() {
        String[] names = {"alex", "john", "emma", "mike", "lisa"};
        String name = names[random.nextInt(names.length)];
        int number = 100 + random.nextInt(900);
        return name + number + "@gmail.com";
    }

}
