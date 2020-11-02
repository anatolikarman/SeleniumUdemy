package com.herokuapp.loginpagetests;

import com.herokuapp.theinternet.Basetest;
import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.csvDataProviders;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTest extends TestUtilities {


    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = csvDataProviders.class)
    @Parameters({"username", "password", "expectedMessage"})
    public void negativeTest(Map<String, String> testData) {

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();


        // Click on Form Authentication link
        LoginPage loginPage= welcomePageObject.clickOnFA();

        // try to log in
        loginPage.logIn(username, password);


        // Verification

        Assert.assertTrue(loginPage.returnErrorMessage().contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + loginPage.returnErrorMessage());
    }




}
