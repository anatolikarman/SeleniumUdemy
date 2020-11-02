package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTabPageObject extends BasePageObject {
    private By clickHereLinkLocator = By.linkText("Click Here");

    public NewTabPageObject(WebDriver driver) {
        super(driver);
    }

    public void openNewTab(){
        System.out.println("Opening new tab shit");
        click(clickHereLinkLocator);
    }

    public NewOpenedTabObject switchToNewTab(){
        System.out.println("Switching to new Tab shit");
switchToWindowWithTitle("New Window");
 return new NewOpenedTabObject(driver);

    }
}
