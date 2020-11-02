package com.herokuapp.newWindowTests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.NewOpenedTabObject;
import com.herokuapp.theinternet.pages.NewTabPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWindowTests extends TestUtilities {

    @Test
    public void newWindowTest() {
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        NewTabPageObject newTabPageObject = welcomePageObject.clickOnNewTabPageObject();
        newTabPageObject.openNewTab();
        NewOpenedTabObject newOpenedTabObject = newTabPageObject.switchToNewTab();
        Assert.assertTrue(newOpenedTabObject.getCurrentPageSource().contains("New Window"));


    }
}
