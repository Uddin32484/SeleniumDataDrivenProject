package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends BaseTest {

    @Test
    @Description("Verify if user can can click on signIn")
    public void verifySignInLink() {
        HomePage home = new HomePage();
        home.clickSignIn();
        Assert.assertTrue(true);
    }
}
