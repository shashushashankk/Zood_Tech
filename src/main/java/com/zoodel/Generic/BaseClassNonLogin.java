package com.zoodel.Generic;

import com.zoodel.POM.BaseScreen;
import com.zoodel.StepGroup.LaunchApp;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.time.Duration;
@Listeners(com.zoodel.Generic.Listners.class)
public class BaseClassNonLogin extends GlobalVariable {

    LaunchApp launchApp = new LaunchApp();
    @BeforeClass
    public void LaunchTheApp(){
        launchApp.launchZoodelApp(noReset);
    }

    @AfterClass
    public void closeApp() {
        androidDriver.quit();
        log.info("App closed successfully", true);
    }
}
