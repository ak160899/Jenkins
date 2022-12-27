package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeModule {

	public WebDriver driver;

	@FindBy(xpath = "(//span[contains(text(),'New Pa')])[4]//parent::button")
	public WebElement $patientCreationButton;

	@FindBy(id = "firstname")
	public WebElement firstName;

	@FindBy(id = "lastname")
	public WebElement lastname;

	@FindBy(xpath = "(//button[@id='gender_dropdown'])[1]")
	public WebElement clickGenderIcon;

	@FindBy(xpath = "(//ul[@id='genderDropdown'])[1]")
	public WebElement chooseGender;

	@FindBy(id = "createPatient")
	public WebElement CreatePatient;

	public HomeModule() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

}
