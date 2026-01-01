package tests;

import io.qameta.allure.Description;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ProductPage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, listeners.TestExecutionListener.class})
public class ProductTests extends BaseTest {

    @Test
    @Description("Verify if user can see products")
    public void productVisible() {
      new ProductPage().isProductDisplayed();
    }


}

