package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

public class CartTests extends BaseTest {

    @Test
    @Description("Verify if user can  see cart Page")
    public void cartIconVisible() {
        new HomePage().clickSignIn();
        Assert.assertTrue(new CartPage().isCartVisible());
    }

}