package com.zoodel.POM;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryScreen {
	AndroidDriver androidDriver;
	public CountryScreen(AndroidDriver driver) {
		this.androidDriver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//android.widget.TextView[@text='Country']"),
			@FindBy(xpath = "//android.widget.TextView[normalize-space(@text)='Country']") })
	WebElement countryText;

	@FindAll({ @FindBy(xpath = "//android.widget.Button[@text='Continue']"),
			@FindBy(xpath = "//android.widget.Button[normalize-space(@text)='Continue']") })
	WebElement continueButton;

	public WebElement getCountryText() {
		return countryText;
	}

	public WebElement getContinueButton() {
//		return continueButton;
		return androidDriver.findElement(By.xpath("//android.widget.Button[@text='Continue']"));
	}

	public WebElement getCountryOption(String countryNmae) {
		String countryXpath = "//android.widget.TextView[contains(@text,"+countryNmae+")]/..";
		return androidDriver.findElement(By.xpath(countryXpath));
	}
}