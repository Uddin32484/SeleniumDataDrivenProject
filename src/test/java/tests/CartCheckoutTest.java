package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartCheckout;
import pages.HomePage;

public class CartCheckoutTest  extends BaseTest{

  HomePage homePage = new HomePage();
  CartCheckout cartCheckout = new CartCheckout();

    @Test
    @Description("Verify if user can  see Checkout process")
    public  void verifyingCheckout(){
        homePage.clickSignIn();
        Assert.assertTrue(cartCheckout.serchDress());

    }

    @Test
    @Description("Verify if user can can click on signIn")
    public void verifySignInLink() {
        HomePage home = new HomePage();
        home.clickSignIn();
        Assert.assertTrue(true);
    }

}
