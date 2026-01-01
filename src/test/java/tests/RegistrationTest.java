package tests;

import config.ExcelDataStore;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FormRegistarion;
import pages.HomePage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, listeners.TestExecutionListener.class})
public class RegistrationTest extends BaseTest {
    HomePage home;
    FormRegistarion reg;


    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataStore.class)
    @Description("Verify if user can  register with  valid information")
    public void registrationTest(String firstname, String lastName, String password, String day, String month, String year){
        reg = new FormRegistarion();
        home = new HomePage();
        home.clickSignIn();
        String newEmail = reg.getFakeEmail();
        System.out.println("DEBUG: newEmail=" + newEmail);
        Assert.assertTrue(reg.validateEmail( newEmail));
        reg.clickCreateAccount();
        reg.fillRegistrationForm(firstname, lastName, password, day, month, year);


    }


}





