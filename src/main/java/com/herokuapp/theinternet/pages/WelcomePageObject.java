package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class WelcomePageObject extends BasePageObject {

    private By formAuthLinkLocator = By.linkText("Form Authentication");
    private By checkBoxLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By jsAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By newWindowLinkLocator = By.linkText("Multiple Windows");
    private By editorWindowLocator = By.linkText("WYSIWYG Editor");
    private By keyPageLinkLocator = By.linkText("Key Presses");
    private By uploadPageLinkLocator = By.linkText("File Upload");
    private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
    String url = "http://the-internet.herokuapp.com/";

    public WelcomePageObject(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openURL(url);
        System.out.println("Main page is opened.");
    }

    public LoginPage clickOnFA() {
        System.out.println("Opening auth shit");
        click(formAuthLinkLocator);
        return new LoginPage(driver);
    }

    public CheckBoxesPage clickOnCB() {
        System.out.println("Opening checkbox shit");
        click(checkBoxLinkLocator);
        return new CheckBoxesPage(driver);
    }

    public DropdownPage clickOnDP() {
        System.out.println("Opening dropdown shit");
        click(dropdownLinkLocator);
        return new DropdownPage(driver);
    }

    public JSAlertsPageObject clickOnJSAlertPage() {
        System.out.println("Opening JSAlert shit");
        click(jsAlertsLinkLocator);
        return new JSAlertsPageObject(driver);
    }

    public NewTabPageObject clickOnNewTabPageObject() {
        System.out.println("Opening NewWindow shit");
        click(newWindowLinkLocator);
        return new NewTabPageObject(driver);
    }

    public EditorPageObject clickOnNewEditorPageObject(){
        click(editorWindowLocator);
        return new EditorPageObject(driver);
    }

    public KeyPageObject clcikOnKeyPage(){
        click(keyPageLinkLocator);
        return new KeyPageObject(driver);
    }
    public UploadPageObject clickOnPageObject(){
        click(uploadPageLinkLocator);
        return new UploadPageObject(driver);
    }

    public DragDropPageObject clickOnDragAndDrop(){
        click(dragAndDropLinkLocator);
        return new DragDropPageObject(driver);
    }




}
