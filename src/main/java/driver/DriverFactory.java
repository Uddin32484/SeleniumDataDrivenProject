package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        if (browser == null) {
            browser = "chrome";
        }

       switch ((browser.toLowerCase())){
           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver.set(new ChromeDriver());
               break;
           case "firefox":
               WebDriverManager.chromedriver().setup();
               driver.set(new FirefoxDriver());
               break;

           case "edge":
               WebDriverManager.edgedriver().setup();
               driver.set(new EdgeDriver());
               break;
       }

     driver.get().manage().window().maximize();

    };
   public static WebDriver getDriver() {
       return driver.get();
   }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
