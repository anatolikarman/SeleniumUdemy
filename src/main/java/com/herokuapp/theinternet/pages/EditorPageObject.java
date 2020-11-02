package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPageObject extends BasePageObject {
    private By editorLocator =By.id("tinymce");
    private By iframeLocator = By.tagName("iframe");
    public EditorPageObject(WebDriver driver) {
        super(driver);
    }

    public String getEditorText(){
        switchToFrame(iframeLocator);
        return find(editorLocator).getText();
    }
}
