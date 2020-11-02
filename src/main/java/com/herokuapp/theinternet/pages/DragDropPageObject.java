package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragDropPageObject extends BasePageObject {
    private By columnALocator = By.id("column-a");
    private By columnBLocator = By.id("column-b");

    public DragDropPageObject(WebDriver driver) {
        super(driver);
    }

    public void dragAtoB(){
dragAndDrop(columnALocator,columnBLocator);
    }

    public void dragBtoA(){
        dragAndDrop(columnBLocator, columnALocator);

    }
}
