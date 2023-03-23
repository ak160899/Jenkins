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

	@FindBy(xpath = "((//div[@id='AlertMessage'])//following::button[1])[2]")
	public WebElement acceptsubscribe;

	@FindBy(xpath = "(//div[@id='AlertMessage'])//following::button[2]")
	public WebElement dismis;

	@FindBy(name = "postal")
	public WebElement postalCode;

	@FindBy(xpath = "//button[@id='save_btn']")
	public WebElement activateSubscription;

	@FindBy(xpath = "//span[@id='monthlyBasicCardPlan']")
	public WebElement basicMonthlyUi;
	
	@FindBy(id = "monthlyPremiumCardPlan")
	public WebElement premiumMonthlyui;
	
	@FindBy(id = "monthlyEnterpriseCardPlan")
	public WebElement enterpriseUi;
	
	@FindBy(id = "liteCardPlan")
	public WebElement lite;
	
	@FindBy(id = "monthlyPremiumPlusCardPlan")
	public WebElement premiumplusUi;

	@FindBy(id = "editPlanCloseBtn")
	public WebElement editplanCrossIcon;

	@FindBy(id = "editPlanBtn")
	public WebElement editPlanButton;

	public SelectYourPlan(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
