package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basic {

	public WebDriver driver;

	@FindBy(xpath = "//div[@id='payment-cvc-element']/div/iframe")
	public WebElement switchToCvcFrame;

	@FindBy(id = "update_basic_btn")
	public WebElement upgradePlan;

	@FindBy(xpath = "//div[@id='AlertMessage']/div[2]/div[1]/p")
	public WebElement verifyAlertcvc;

	@FindBy(id = "update-card-btn")
	public WebElement editCard;

	@FindBy(id = "upgrade_btn")
	public WebElement upgradeDetails;
	
	
	@FindBy(xpath = "//button[@onclick='Health.upgradeEnterpriseNow()']")
	public List<WebElement> upgradeButtonEnterpriseUi;
	
	
	@FindBy(id="editPlanBtn")
	public WebElement editPlanButton;

	public Basic(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

}
