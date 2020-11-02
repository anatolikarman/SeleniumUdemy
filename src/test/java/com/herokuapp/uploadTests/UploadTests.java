package com.herokuapp.uploadTests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.UploadPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {


    @Test(dataProvider = "files")
    public void uploadMessageTest(int testNum, String fileName){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        UploadPageObject uploadPageObject = welcomePageObject.clickOnPageObject();
        uploadPageObject.selectFiles(fileName);
        uploadPageObject.pushUploadButton();
        Assert.assertTrue(uploadPageObject.getUploadedFilesNames().contains(fileName));
    }

}
