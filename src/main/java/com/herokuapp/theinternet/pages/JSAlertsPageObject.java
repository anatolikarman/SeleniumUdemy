package com.herokuapp.theinternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSAlertsPageObject extends BasePageObject {
    private By jsAlertLocator = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
    private By jsConfirmLocator = By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']");
    private By jsPromptLocator = By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']");
    private By result = By.id("result");
    public JSAlertsPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickOnAler(){
        click(jsAlertLocator);
    }
    public void clickOnConfirm(){
        click(jsConfirmLocator);
    }
    public void clickOnPrompt(){
        click(jsPromptLocator);
    }
    public String getAlerText(){
        Alert alert = switchToAlert();
       return alert.getText();
    }

    public void acceptAlert(){
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert(){
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public void sendTestToAlert(String text){
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText(){
        return find(result).getText();
    }

}
