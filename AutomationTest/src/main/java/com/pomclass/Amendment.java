package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amendment {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Amendment')]")
	public WebElement addIcon;

	@FindBy(xpath = "//select[@id='source']")
	public WebElement selectSource;

	@FindBy(xpath = "//div[@id='AmendmentKpop2']/div[2]/div/div[2]/div[2]/input")
	public WebElement discription;

	@FindBy(xpath = "//select[@id='status']")
	public WebElement selectStatus;

	@FindBy(xpath = "//input[@id='reason']")
	public WebElement reasonDiscription;

	@FindBy(xpath = "//div[@id='AmendmentKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;
	
	public Amendment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
