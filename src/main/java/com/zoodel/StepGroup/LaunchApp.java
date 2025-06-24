package com.zoodel.StepGroup;

import com.zoodel.Generic.GlobalVariable;
import com.zoodel.POM.BaseScreen;
import com.zoodel.Utility.AndroidDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.net.URL;
import java.time.Duration;

public class LaunchApp extends GlobalVariable {
    public void launchZoodelApp(boolean noReset){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName","android");
        capabilities.setCapability("appium:automationName","uiAutomator2");
        capabilities.setCapability("appium:appPackage",appPackage);
        capabilities.setCapability("appium:appActivity",appActivity);
//        capabilities.setCapability("appium:app",appFilePath);
        capabilities.setCapability("appium:noReset",noReset);
        capabilities.setCapability("appium:autoGrantPermissions",autograntPermission);
        try {
            androidDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
            System.out.println("Application launched successfully");
            log.info("Application launched successfully", true);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            log.info("Failed to launch the App. Reason is " + e.getLocalizedMessage(), true);
        }
        Assert.assertNotNull(androidDriver);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        baseScreen = new BaseScreen(androidDriver);
        androidDriverUtility = new AndroidDriverUtility(androidDriver);
        wait= new WebDriverWait(androidDriver, Duration.ofSeconds(explicitWait));
    }

}
