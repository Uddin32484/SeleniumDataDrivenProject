package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Import this!
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                // Check if running on GitHub Actions (CI)
                if (System.getenv("CI") != null) {
                    options.addArguments("--headless=new"); // New headless mode
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--window-size=1920,1080");
                    // Hide "Chrome is being controlled by automated test software"
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    // Optional: remove "Chrome is being controlled" infobar
                    options.setExperimentalOption("useAutomationExtension", false);
                    // Optional: disable infobars and notifications
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--remote-allow-origins=*"); //
                } // Good practice for headless

                driver.set(new ChromeDriver(options)); // Pass options here
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup(); // Fixed your setup here
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
        }

        if (!browser.equalsIgnoreCase("chrome")) {
            driver.get().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}