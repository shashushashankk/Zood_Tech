package com.zoodel.Generic;

import com.zoodel.StepGroup.LaunchApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass extends GlobalVariable {
    LaunchApp launchApp = new LaunchApp();

    @BeforeClass
    public void LaunchTheApp() {
        launchApp.launchZoodelApp(noReset);
    }

    @AfterClass
    public void closeApp() {
        androidDriver.quit();
        log.info("App closed successfully", true);
    }
}
