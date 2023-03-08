package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medication {
	public WebDriver driver;

	@FindBy(xpath = "(//div[contains(@title,'Add Medications')])[1]")
	public WebElement addIcon;

	@FindBy(id = "DRUG_NAME")
	public WebElement drugName;

	@FindBy(id = "STRENGTH")
	public WebElement strenghth;

	@FindBy(id = "DISP_QUANTITY")
	public WebElement quantity;

	@FindBy(id = "SIG_DIRECTIONS")
	public WebElement direction;

	@FindBy(xpath = "//div[@id='addfav-div']//following::ul[1]/li/a/div")
	public List<WebElement> directionDropDown;

	@FindBy(xpath = "//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button")
	public WebElement save;

	@FindBy(xpath = "//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button//following::ul[1]/li")
	public List<WebElement> saveDropdown;

	@FindBy(xpath = "//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[3]/table/tbody/tr/td[2]/div")
	public WebElement removeMedication;
	
	@FindBy(xpath = "//div[text()='q12h - Every twelve hours']")
	public WebElement edit;
	
	@FindBy(xpath = "//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em")
	public List<WebElement> icdlist;

	public Medication(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
