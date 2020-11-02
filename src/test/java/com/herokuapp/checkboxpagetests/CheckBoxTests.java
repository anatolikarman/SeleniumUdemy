package com.herokuapp.checkboxpagetests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.CheckBoxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTests extends TestUtilities {

    @Test
    public void selectingTwoCheckBoxesTest() {
        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();

        //open checkboxpage
       CheckBoxesPage checkBoxesPage =  welcomePageObject.clickOnCB();

        //check all checkboxes
       checkBoxesPage.selectCheckBoxes();

        //check checkBoxes checked
        Assert.assertTrue(checkBoxesPage.checkCheckBoxesChecked(), "Not all checkboxes checked");

    }
}
