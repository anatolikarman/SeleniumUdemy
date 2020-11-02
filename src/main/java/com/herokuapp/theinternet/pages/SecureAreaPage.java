package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private By actualSuccessMessage = By.id("flash-messages");
    private By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
    private String expectedUrl = "http://the-internet.herokuapp.com/secure";



    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String returnExpectedUrl (){
        return expectedUrl;
    }

    public boolean isLogOutVisible(){
        return find(logOutButtonLocator).isDisplayed();
    }

    public String returnActualMessage(){
        return find(actualSuccessMessage).getText();
    }


}
