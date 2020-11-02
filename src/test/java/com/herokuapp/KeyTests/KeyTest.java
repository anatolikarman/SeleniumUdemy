package com.herokuapp.KeyTests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyTest extends TestUtilities {

    @Test
    public void keyTest(){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        KeyPageObject keyPageObject = welcomePageObject.clcikOnKeyPage();
        keyPageObject.pressKeyWithAction(Keys.ARROW_DOWN);
        Assert.assertTrue(keyPageObject.getResultText().equals("You entered: DOWN"));
    }
}
