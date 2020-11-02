package com.herokuapp.dropdowntests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {


    @Test
    public void optionTwoTest() {
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        DropdownPage dropdownPage = welcomePageObject.clickOnDP();


        dropdownPage.selectOption(2);

        System.out.println(dropdownPage.dpOptionSelectedConfirmation());
    }

}
