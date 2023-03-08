package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImplantableDevice {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Implantable')]")
	public WebElement addIcon;

	@FindBy(id = "udi")
	public WebElement udi;

	@FindBy(xpath = "//button[@id='verify-btn']")
	public WebElement verifyButton;

	@FindBy(id = "deviceNote")
	public WebElement note;

	@FindBy(xpath = "//span[@title='Verified']")
	public WebElement verifiedTick;

	@FindBy(xpath = "//div[@id='Implantable_DevicesKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	public ImplantableDevice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
