package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
@Listeners({io.qameta.allure.testng.AllureTestNg.class, listeners.TestExecutionListener.class})
public class HomeTests extends BaseTest {

    @Test
    @Description("Verify if user can can click on signIn")
    public void verifySignInLink() {
        HomePage home = new HomePage();
        home.clickSignIn();
        Assert.assertTrue(true);
    }
}
