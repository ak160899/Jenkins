package org.patientPomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings {

	public WebDriver driver;

	@FindBy(xpath = "//span[text()='Medical Information    ']//following::span[1]")
	public WebElement medicalInfoEditIcon;

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement medFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement medLastName;

	@FindBy(xpath = "//input[@id='lastName']//following::button[1]")
	public WebElement bloodGroup;

	@FindBy(xpath = "//input[@id='lastName']//following::button[1]//following::ul[1]/li/a")
	public List<WebElement> bloodGroupDropdown;

	@FindBy(xpath = "//input[@id='national-id']")
	public WebElement Nationalid;

	@FindBy(xpath = "//input[@id='insurance-info']")
	public WebElement insurance;

	@FindBy(xpath = "//input[@id='insurance-info']//following::button[5]")
	public WebElement saveMedicalInfo;

	@FindBy(id = "edit-btn")
	public WebElement contacteditIcon;

	@FindBy(id = "add-btn")
	public WebElement alternateContactAddIcon;

	@FindBy(xpath = "//button[@id='date-format']")
	public WebElement dateFormat;

	@FindBy(xpath = "//button[@id='date-format']//following::ul[1]/li")
	public List<WebElement> dateformatDropdown;

	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
