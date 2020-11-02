package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPageObject extends BasePageObject {
    private By bodyLocator = By.xpath("//body");
    private By resultLocator = By.id("result");


    public KeyPageObject(WebDriver driver) {
        super(driver);
    }

    public void pressKey(Keys key){
        pressKey(bodyLocator, key);
    }


    public String getResultText(){
        return find(resultLocator).getText();
    }
}
