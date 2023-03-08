package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialHistory {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Social History')]")
	public WebElement addIcon;

	@FindBy(xpath = "//select[@id='habitType']")
	public WebElement selectShType;

	@FindBy(xpath = "//select[@id='habitType']//following::div[3]/input")
	public WebElement discription;

	@FindBy(xpath = "(//button[@id='accept-btn'])[1]")
	public WebElement save;

	public SocialHistory(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

}
