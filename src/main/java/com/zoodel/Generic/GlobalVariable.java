package com.zoodel.Generic;

import com.zoodel.POM.BaseScreen;
import com.zoodel.Utility.AndroidDriverUtility;
import com.zoodel.Utility.ExcelUtility;
import com.zoodel.Utility.JavaUtility;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class GlobalVariable implements FrameWorkConstant {
    public static SoftAssert softAssert = new SoftAssert();
    public static AndroidDriver androidDriver;
    public static boolean autograntPermission = true;
    public static boolean noReset = false;
    public static Logger log = LogManager.getLogger("automation.logs");
    public static int implicitWait = 20;
    public static int explicitWait = 20;
    public static BaseScreen baseScreen;
    public static WebDriverWait wait;
    public static AndroidDriverUtility androidDriverUtility;
    public static JavaUtility javaUtility = new JavaUtility();
    public static ExcelUtility excelUtility = new ExcelUtility();


}
