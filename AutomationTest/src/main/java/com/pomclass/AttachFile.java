package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttachFile {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Attach File')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@id='Attach_FileKpop2']/div[2]/div[1]/select")
	public WebElement selectType;

	@FindBy(xpath = "(//div[@id='Attach_FileKpop2']/div[2]/div[1]//following::div[3]/input[1])[1]")
	public WebElement link;

	@FindBy(xpath = "//div[@id='Attach_FileKpop2']/div[2]/div[3]/button[2]")
	public WebElement save;

	@FindBy(xpath = "(//a[text()='Web link : (https://www.75health.com/)'])[1]//parent::div/span[1]")
	public WebElement edit;

	public AttachFile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
