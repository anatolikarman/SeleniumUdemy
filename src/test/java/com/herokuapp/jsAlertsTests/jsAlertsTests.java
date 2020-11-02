package com.herokuapp.jsAlertsTests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.JSAlertsPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jsAlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest(){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        JSAlertsPageObject jsAlertsPageObject = welcomePageObject.clickOnJSAlertPage();
        jsAlertsPageObject.clickOnAler();
        String alertText = jsAlertsPageObject.getAlerText();
        jsAlertsPageObject.acceptAlert();
        String resultText = jsAlertsPageObject.getResultText();
        Assert.assertTrue(alertText.equals("I am a JS Alert"));
        Assert.assertTrue(resultText.equals("You successfuly clicked an alert"));
    }

    @Test
    public void jsDismissTest(){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        JSAlertsPageObject jsAlertsPageObject = welcomePageObject.clickOnJSAlertPage();
        jsAlertsPageObject.clickOnConfirm();
        String alertText = jsAlertsPageObject.getAlerText();
        jsAlertsPageObject.dismissAlert();
        String resultText = jsAlertsPageObject.getResultText();
        Assert.assertTrue(alertText.equals("I am a JS Confirm"));
        Assert.assertTrue(resultText.equals("You clicked: Cancel"));
    }


    @Test
    public void jsPromptTest(){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        JSAlertsPageObject jsAlertsPageObject = welcomePageObject.clickOnJSAlertPage();
        jsAlertsPageObject.clickOnPrompt();
        String alertText = jsAlertsPageObject.getAlerText();
        jsAlertsPageObject.sendTestToAlert("ASS");
        String resultText = jsAlertsPageObject.getResultText();
        Assert.assertTrue(alertText.equals("I am a JS prompt"));
        Assert.assertTrue(resultText.equals("You entered: ASS"));
    }
}
