package com.herokuapp.theinternet;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverFactory {
    private Logger log;

    public BrowserDriverFactory(Logger log) {
        this.log = log;
    }

    public WebDriver create(){
        ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Course_1\\src\\main\\resources\\chromedriver.exe");
        driver.set(new ChromeDriver());
        return driver.get();
    }
}
