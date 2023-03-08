package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyHealth {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Family Health')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@id='Family_HealthKpop2']/div[2]/div/select")
	public WebElement selectFHType;

	@FindBy(xpath = "//div[@id='Family_HealthKpop2']/div[2]/div/select//following::div[1]/div[2]/input")
	public WebElement icdDiscriptionbox;

	@FindBy(xpath = "//div[@id='Family_HealthKpop2']/div[2]/ul/li/a/div/small")
	public List<WebElement> icdDropdown;
	
	@FindBy(xpath = "//button[@id='btnSaveAdd']")
	public WebElement save;
	
	
	@FindBy(xpath = "//div[@id='saveadd-btn']/ul/li")
	public List<WebElement> saveDropdown;

	public FamilyHealth(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
