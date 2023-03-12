package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vitals {

	public WebDriver driver;

	String s = "";

	@FindBy(xpath = "(//button[contains(@title,'Add Multiple Vitals')])[1]")
	public WebElement getVitalsAddIcon;

	@FindBy(id = "wresult")
	public WebElement weight;

	@FindBy(xpath = "(//select[@id='unit'])[1]")
	public WebElement selectWeightUnit;

	@FindBy(id = "hresult")
	public WebElement height;

	@FindBy(xpath = "//div[@id='vital']/div[1]/div[1]/div/div[2]/div[1]")
	public WebElement vitalsSaltIcon;
	
	@FindBy(xpath = "(//span[text()='55 kilograms'])[1]")
	public WebElement edit;

	@FindBy(xpath = "(//select[@id='unit'])[2]")
	public WebElement selectHeightUnit;

	@FindBy(xpath = "(//button[@id='accept-btn'])[1]")
	public WebElement saveVitals;
	
	public Vitals(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
