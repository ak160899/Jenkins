package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allergy {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Allergy')]")
	public WebElement addIcon;

	@FindBy(xpath = "//select[@id='codeType']")
	public WebElement selectAllergyType;

	@FindBy(xpath = "//div[@id='AllergyKpop2']/div[2]/div[1]/div[2]/div[2]/input")
	public WebElement allergenDiscription;

	@FindBy(xpath = "//input[@placeholder='Reaction']")
	public WebElement reactionDiscription;

	@FindBy(xpath = "//div[@id='AllergyKpop2']/div[2]/div[2]/div/button")
	public WebElement more;

	@FindBy(xpath = "//div[@id='smore-btn']/ul/li")
	public List<WebElement> chooseFromDropdown;

	@FindBy(xpath = "//select[@id='severity']")
	public WebElement severityDiscription;

	@FindBy(xpath = "//select[@id='status']")
	public WebElement statusDiscription;

	@FindBy(xpath = "//div[@id='saveadd-btn']/button")
	public WebElement saveButton;

	@FindBy(xpath = "//div[@id='saveadd-btn']/ul/li")
	public List<WebElement> saveDropdown;

	public Allergy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
