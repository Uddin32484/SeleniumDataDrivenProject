package tests;

import config.DataConfig;
import io.qameta.allure.Description;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


import java.util.HashMap;


public class LoginTests extends BaseTest {

    @Test(dataProvider = "getLoginData", dataProviderClass = DataConfig.class)
    @Description("Verify if user can login with Invalid credentials")
    public void invalidLogin(HashMap<String, String> input){
        System.out.println("Running Test Case: " + input.get("invalid"));
        new HomePage().clickSignIn();
        new LoginPage().login(input.get("email"),input.get("wrongpassword"));


    }
    @Test(dataProvider = "getLoginData", dataProviderClass = DataConfig.class)
    @Description("Verify if user can login with valid credentials")
    public void validLogin(HashMap<String, String> input) {
        System.out.println("Running Test Case: " + input.get("valid"));
        new HomePage().clickSignIn();
        new LoginPage().login(input.get("email"),input.get("password"));
    }

}

