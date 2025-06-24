package Login;

import com.zoodel.Generic.BaseClassNonLogin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginNegetive extends BaseClassNonLogin {
    @Test
    void validatePhoneNumber() {
        WebElement countryOption = baseScreen.countryScreen.getCountryOption("Uzbekistan");
        wait.until(ExpectedConditions.elementToBeClickable(countryOption));
        androidDriverUtility.clickOnElement(countryOption);
        Reporter.log("Navigated to Country screen", true);
        log.info("Navigated to Country screen",true);
        WebElement continueButton = baseScreen.countryScreen.getContinueButton();
        androidDriverUtility.clickOnElement(continueButton);
        Reporter.log("Successfully searched the Continue button element", true);
        WebElement selectLanguageText = baseScreen.selectLanguageBottomScreen.getselectLanguageText();
        wait.until(ExpectedConditions.visibilityOf(selectLanguageText));
        WebElement languageOption = baseScreen.selectLanguageBottomScreen.languageOption("English");
        androidDriverUtility.clickOnElement(languageOption);
        Reporter.log("Navigated to educational screen", true);
        log.info("Language selected and navigated to Educational screen");
        WebElement loginButton = baseScreen.educationalBannerScreen.getLogInButton();
        androidDriverUtility.clickOnElement(loginButton);
        WebElement phoneNumberTextfield = baseScreen.loginScreen.getPhoneNumberTextfield();
        androidDriverUtility.enterInputIntoElement(phoneNumberTextfield,"000000000");
        softAssert.assertFalse(phoneNumberTextfield.isEnabled());
        androidDriverUtility.enterInputIntoElement(phoneNumberTextfield,"12548963");
        softAssert.assertFalse(phoneNumberTextfield.isEnabled());
        androidDriverUtility.enterInputIntoElement(phoneNumberTextfield,"12548963598");
        softAssert.assertFalse(phoneNumberTextfield.isEnabled());
        androidDriverUtility.enterInputIntoElement(phoneNumberTextfield,"951357456");
        softAssert.assertTrue(phoneNumberTextfield.isEnabled());
        softAssert.assertAll();
    }
    @Test(dependsOnMethods = "validatePhoneNumber")
    void emailAndPasswordTextfield(){
        WebElement loginWithEmailButton = baseScreen.loginScreen.getLoginWithEmailButton();
        wait.until(ExpectedConditions.elementToBeClickable(loginWithEmailButton));
        androidDriverUtility.clickOnElement(loginWithEmailButton);
//        WebElement emailTextfiled = baseScreen.getem
    }

//    @Test(dependsOnMethods = "navigateToLoginScreen")
    void validateMobileNumberTextfieldTest() {

    }
}
