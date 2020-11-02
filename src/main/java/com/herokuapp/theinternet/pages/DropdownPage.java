package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {
    private By dropdown = By.id("dropdown");
    private By option1 = By.xpath("//option[@value='1']");
    private By option2 = By.xpath("//option[@value='2']");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption(int i) {

        switch (i) {
            case 1:
                click(option1);

            case 2:
                click(option2);
        }
    }

    public String dpOptionSelectedConfirmation(){
        WebElement dropdownList = find(dropdown);
        Select select = new Select(dropdownList);
        String selectedOption = select.getFirstSelectedOption().getText();
        return selectedOption + " is chosen";
    }


}
