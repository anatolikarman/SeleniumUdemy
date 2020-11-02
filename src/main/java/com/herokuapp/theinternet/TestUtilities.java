package com.herokuapp.theinternet;

import org.testng.annotations.DataProvider;

public class TestUtilities extends Basetest {

    @DataProvider(name = "files")
    protected static Object[][] files(){
        return new Object[][]{
                {1, "funny_meme.jpg"},
                {2, "haha.txt"}
        };

        }
    }

