package com.zoodel.Utility;

import com.zoodel.Generic.GlobalVariable;
import com.zoodel.StepGroup.LaunchApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUtility extends GlobalVariable {
    LaunchApp launchApp = new LaunchApp();
    @BeforeClass
    void LaunchTheApp(){
        launchApp.launchZoodelApp(noReset);
    }
    @AfterClass
    void closeApp(){
        androidDriver.quit();
        log.info("App closed successfully", true);
    }
}
