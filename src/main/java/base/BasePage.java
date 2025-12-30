package base;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;
    protected BasePage() {
// Fetch the driver from your Factory
        this.driver = DriverFactory.getDriver();

        // Safety check: if driver is still null, throw a clear message
        if (this.driver == null) {
            throw new RuntimeException("Driver has not been initialized. " +
                    "Make sure DriverFactory.initDriver() is called in @BeforeMethod.");
        }

        // Now 'driver' is guaranteed to be set, so WebDriverWait won't crash
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Initialize PageFactory elements if you are using @FindBy
        PageFactory.initElements(driver, this);
    }


    public void selectItem(By locator, String item) {
        // Corrected: added the missing ')' for the Select constructor
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByVisibleText(item);
    }

    public void selectItem(By locator, int item) {
        // Corrected: added the missing ')' for the Select constructor
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByIndex(item);
    }
}
