package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPageObject extends BasePageObject {
    private By submitButtonLocator = By.id("file-submit");
    private By uploadLocator = By.id("file-upload");
    private By uploadedFilesListLocator = By.id("uploaded-files");

    public UploadPageObject(WebDriver driver) {
        super(driver);
    }

    public void pushUploadButton() {
        click(submitButtonLocator);
        System.out.println("Funny meme deployed");
    }

    public void selectFiles(String fileName) {
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(uploadLocator, filePath);
        System.out.println("Path to the funny meme is set");
    }

    public String getUploadedFilesNames(){
        return find(uploadedFilesListLocator).getText();
    }
}
