package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class FormRegistarion extends BasePage {


    Random random = new Random();
    WebDriverWait wait;
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
    @FindBy(xpath= "//select[@class='form-control' and @name='days']")
    WebElement days;
    @FindBy(xpath= "//select[@class='form-control' and @name='months']")
    WebElement months;
    @FindBy(xpath= "//select[@class='form-control' and @name='years']")
    WebElement years;
    @FindBy(id = "submitAccount")
    WebElement registrationButton;
    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    WebElement successMessage;
//    static final By DAY = By.xpath("//select[@class='form-control' and @name='days']");
//    static final By MONTH = By.xpath("//select[@class='form-control' and @name='months']");
//    static final By YEAR = By.xpath("//select[@class='form-control' and @name='years']");



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
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
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
