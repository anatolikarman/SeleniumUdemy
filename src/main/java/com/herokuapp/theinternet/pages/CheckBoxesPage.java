package com.herokuapp.theinternet.pages;

import javafx.scene.control.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPage extends BasePageObject {
    private By checkBoxLocator = By.xpath("//input[@type='checkbox']");

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }


    public void selectCheckBoxes() {
        List<WebElement> allCheckBoxes = findAll(checkBoxLocator);
        for (WebElement checkbox : allCheckBoxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean checkCheckBoxesChecked() {
        List<WebElement> allCheckBoxes = findAll(checkBoxLocator);
        for (WebElement checkbox : allCheckBoxes) {
            if (!checkbox.isSelected())
                return false;

        }
        return true;
    }


}


