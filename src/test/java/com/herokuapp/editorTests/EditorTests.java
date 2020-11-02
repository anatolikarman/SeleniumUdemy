package com.herokuapp.editorTests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultValueEditorTest() {
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        EditorPageObject editorPageObject = welcomePageObject.clickOnNewEditorPageObject();
String actualEditorText = editorPageObject.getEditorText();
        Assert.assertTrue(actualEditorText.equals("Your content goes here."));

    }
}
