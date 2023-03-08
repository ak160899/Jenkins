package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alert {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Alert')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@title='Enter the description of the alert ']")
	public WebElement discription;

	@FindBy(xpath = "//button[@id='visibility']")
	public WebElement visbility;

	@FindBy(xpath = "//button[@id='visibility']//following::ul[1]/li/a")
	public List<WebElement> visbilityDropDown;
	
	@FindBy(xpath = "//div[text()='hello']")
	public WebElement edit;

	@FindBy(xpath = "//div[@id='AlertKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	public Alert(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
