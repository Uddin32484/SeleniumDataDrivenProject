package tests;

import config.ConfigLoader;
import driver.DriverFactory;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners(io.qameta.allure.testng.AllureTestNg.class)
public class BaseTest {

    @Parameters("env")
    @BeforeMethod
    public void setup(@Optional("qa") String env) throws IOException {
        ConfigLoader.load(env);
        String browser = ConfigLoader.getkeys("browser");
        String baseUrl = ConfigLoader.getkeys("url");
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(baseUrl);

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
