package com.herokuapp.theinternet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basetest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext cntxt) {
        String testName = cntxt.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        System.out.println("Starting");
        BrowserDriverFactory factory = new BrowserDriverFactory(log);
        driver = factory.create();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Closing");
        driver.quit();
    }
}
