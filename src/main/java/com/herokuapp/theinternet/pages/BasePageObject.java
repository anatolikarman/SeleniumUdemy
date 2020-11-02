package com.herokuapp.theinternet.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePageObject {
    protected WebDriver driver;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void openURL(String url) {
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        waitForVisibility(locator, null);
        find(locator).click();
    }

    protected void type(By locator, String keys){
        waitForVisibility(locator, null);
        find(locator).sendKeys(keys);
    }


    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut) {
        timeOut = timeOut != null ? timeOut : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    private void waitForVisibility(By locator, Integer timeOut) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), null);
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();

            }
            attempts++;
        }
    }

    protected Alert switchToAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();

    }

    public String getCurrentPageSource(){
        return  driver.getPageSource();
    }

    protected void switchToWindowWithTitle(String expectedTitle) {
        String firstTab = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();
        while (windowsIterator.hasNext()){
            String windowHandle = windowsIterator.next();
            if (!windowHandle.equals(firstTab)){
                driver.switchTo().window(windowHandle);
                if(driver.getTitle().equals(expectedTitle)){
                    break;
                }
            }
        }
    }
    protected void switchToFrame(By locator){
        driver.switchTo().frame(find(locator));
    }

    protected void pressKey(By locator, Keys key){
        find(locator).sendKeys(key);
    }

    public void pressKeyWithAction(Keys key){
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();

    }

    public void scrollDown(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void dragAndDrop(By from, By to){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                find(from), find(to));
    }
    }

