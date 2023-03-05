package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectYourPlan {

	public WebDriver driver;

	@FindBy(xpath = "//span[text()='Time To Upgrade!']//following::button[1]")
	public WebElement dismiss;

	@FindBy(xpath = "//span[text()='$ 19']")
	public WebElement paymentpriceUi;

	@FindBy(xpath = "//button[@id='proceed_button']")
	public WebElement proceedPaymentButton;

	@FindBy(xpath = "((//div[@id='AlertMessage'])//following::button[1])[1]")
	public WebElement accept;
	
	@FindBy(xpath = "(//div[@id='AlertMessage'])//following::button[2]")
	public WebElement dismis;
	
	@FindBy(name = "postal")
	public WebElement postalCode;

	@FindBy(xpath = "//button[@id='save_btn']")
	public WebElement activateSubscription;

	public SelectYourPlan(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
