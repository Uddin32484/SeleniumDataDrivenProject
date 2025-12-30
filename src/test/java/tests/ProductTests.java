package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import tests.BaseTest;

public class ProductTests extends BaseTest {

    @Test
    @Description("Verify if user can see products")
    public void productVisible() {
      new ProductPage().isProductDisplayed();
    }


}

