package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import  driver.DriverFactory;

public class TestExecutionListener implements ITestListener {

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String testName, WebDriver driver) {
        if (driver == null) {
            return new byte[0];
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Optional: logging or actions before each test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Optional: take screenshot on success if needed
    }

    @Override
    public void onTestFailure(ITestResult result) {
//
        System.out.println("Test failed: " + result.getName());
        WebDriver driver = DriverFactory.getDriver();//
        // Attach screenshot for Allure
        if (driver != null) {
            saveScreenshot(result.getName(), driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Optional
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: before suite execution
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional: after suite execution
    }
}
