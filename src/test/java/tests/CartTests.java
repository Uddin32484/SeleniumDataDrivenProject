package tests;

import io.qameta.allure.Description;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;


public class CartTests extends BaseTest {

    @Test
    @Description("Verify if user can  see cart Page")
    public void cartIconVisible() {
        new HomePage().clickSignIn();
      new CartPage().isCartVisible();
    }

}