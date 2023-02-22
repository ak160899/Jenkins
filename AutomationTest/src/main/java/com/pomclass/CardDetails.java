package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetails {

	public WebDriver driver;

	@FindBy(xpath = "//div[@id='card-details']//iframe")
	public WebElement switchToCardFrame;

	@FindBy(name = "cardnumber")
	public WebElement cardNumber;

	@FindBy(name = "exp-date")
	public WebElement expirydate;

	@FindBy(name = "cvc")
	public WebElement cvc;

	@FindBy(name = "postal")
	public WebElement postalCode;

	public CardDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
