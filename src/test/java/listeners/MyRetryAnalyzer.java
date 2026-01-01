package listeners;


import driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class MyRetryAnalyzer implements IRetryAnalyzer{
    private int retryCount = 0;
    private static final int maxRetryCount = 3;


    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying " + result.getName() + " (attempt " + retryCount + ")");
            attachScreenshot(retryCount);
            return true;
        }else{
            result.setStatus(ITestResult.FAILURE); // ensure TestNG sees it as failure
        }
        return false;
    }



    @Attachment(value = "Screenshot Retry #{0}", type = "image/png")
    public byte [] attachScreenshot(int attempt) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } else {
            return new byte[0]; // Return empty if WebDriver doesn't support screenshots
        }
    }
}
