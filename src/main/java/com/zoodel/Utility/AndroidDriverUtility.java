package com.zoodel.Utility;

import com.zoodel.Generic.GlobalVariable;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AndroidDriverUtility extends GlobalVariable {
    AndroidDriver androidDriver;

    public AndroidDriverUtility(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    Logger log = LogManager.getLogger(this.getClass());

    public void clickOnElement(WebElement ele) {
        ele.click();
        log.info("Successfully clicked on the element");
    }

    public void clickOnElement(String eleXpath) {
        androidDriver.findElement(By.xpath(eleXpath)).click();
        log.info("Successfully clicked on the element");
    }

    public void enterInputIntoElement(WebElement ele, String val) {
        ele.sendKeys(val);
        log.info("Successfully clicked on the element");
    }

    public void enterInputIntoElement(String eleXpath, String val) {
        androidDriver.findElement(By.xpath(eleXpath)).sendKeys(val);
        log.info("Successfully clicked on the element");
    }

    public void hideKeyBoard() {
        if (androidDriver.isKeyboardShown()) {
            androidDriver.hideKeyboard();
        }
        log.info("Successfully hide the keyboard");
    }
    public String getScreenShot(String filePath, String screenshotName)  {
        TakesScreenshot takesScreenshot = (TakesScreenshot) androidDriver;
        File temp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest  = new File(filePath+screenshotName+".png");
        try{
            Files.copy(temp.toPath(),dest.toPath());
        } catch (IOException e){
            log.error("Failed to copy to destination "+e.getLocalizedMessage());
        }
        log.debug("Screenshot captured successfully");
        return  dest.getAbsolutePath();
    }
}