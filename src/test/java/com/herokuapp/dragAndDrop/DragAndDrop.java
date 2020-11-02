package com.herokuapp.dragAndDrop;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.DragDropPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestUtilities {
    @Test
    public void dragAtoBTest(){
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.openPage();
        DragDropPageObject dragAndDrop = welcomePageObject.clickOnDragAndDrop();
        dragAndDrop.dragAtoB();

    }
    @Test
    public void dragBtoATest(){

    }

}
