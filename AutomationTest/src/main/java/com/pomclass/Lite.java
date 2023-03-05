package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lite {

	public WebDriver driver;

	@FindBy(xpath = "//div[@id='payment-card-cvc-element']/div/iframe")
	public WebElement switchToCvcfieldFrame;

	@FindBy(xpath = "//button[@id='update-subscription-btn']")
	public WebElement updateSubscription;

	@FindBy(xpath = "(//button[@id='update-card-btn'])[2]")
	public WebElement cardFieldEdit;

	@FindBy(xpath = "//button[@onclick='allVasPremiumThankyou.setting();']")
	public WebElement finishLite;

	public Lite(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
