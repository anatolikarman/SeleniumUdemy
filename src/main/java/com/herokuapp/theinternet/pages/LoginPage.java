package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By logInButtonLocator = By.tagName("button");
    private By errorMessage = By.id("flash");



    public LoginPage(WebDriver driver) {
        super (driver);
    }

    public SecureAreaPage logIn (String username, String password){
        System.out.println("Logging in with" + username + " and " + password);
        type(usernameLocator,username);
        type(passwordLocator, password);
        click(logInButtonLocator);
        return new SecureAreaPage(driver);
    }

    public String returnErrorMessage(){
        return find(errorMessage).getText();
    }

}
