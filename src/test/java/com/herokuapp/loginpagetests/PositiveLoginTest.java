package com.herokuapp.loginpagetests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PositiveLoginTest extends TestUtilities {
    @Test
    public void logInTest() {

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver);
        welcomePage.openPage();


        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickOnFA();

        // Log in
        SecureAreaPage securePage = loginPage.logIn("tomsmith", "SuperSecretPassword!");


        // verifications
        // new url
        Assert.assertEquals(securePage.returnExpectedUrl(), securePage.getCurrentUrl());

        // log out button is visible
        Assert.assertTrue(securePage.isLogOutVisible(),
                "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = securePage.returnActualMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

    }
}

