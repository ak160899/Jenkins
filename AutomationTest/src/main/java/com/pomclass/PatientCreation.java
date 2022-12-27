package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class PatientCreation {
	public WebDriver driver;

	@FindBy(xpath = "(//button[@title='Add new Patient'])[1]")
	public WebElement addNewPatient;

	@FindBy(id = "firstname")
	public WebElement firstName;

	@FindBy(id = "lastname")
	public WebElement lastname;

	@FindBy(xpath = "(//button[@id='gender_dropdown'])[1]")
	public WebElement clickGenderIcon;

	@FindBy(xpath = "(//ul[@id='genderDropdown'])[1]")
	public WebElement chooseGender;

	@FindBy(id = "birthDate2")
	public WebElement dateOfBirth;

	@FindBy(xpath = "//td[text()='Patient']")
	public WebElement $patienmod;

	@FindBy(id = "userloginId")
	public WebElement emailId;

	@FindBy(xpath = "(//button[@id='advanceIcon'])[1]")
	public WebElement patientmodReport;

	@FindBy(xpath = "(//input[@id='patient-aname'])[1]")
	public WebElement patientReportSerachNametxtBox;

	@FindBy(xpath = "(//div[@id='list_patient']//following::span[3])[1]")
	public WebElement ellipses;

	@FindBy(xpath = "(//div[@id='list_patient']//following::span[3])[1]//following::ul[1]/li")
	public List<WebElement> ellipsesOptions;

	@FindBy(xpath = "(//ul[@class='dropdown-menu settings-buttonColor settings-heading'])[3]/li")
	public List<WebElement> $ccdImport;

	@FindBy(xpath = "//span[text()='Import Health Record']/following::div[1]/span")
	public WebElement $closeCcdImport;

	@FindBy(id = "Phone")
	private WebElement phoneNumber;

	@FindBy(xpath = "(//button[@id='cancel-btn'])[1]")
	public WebElement cancel;

	@FindBy(id = "createPatient")
	public WebElement CreatePatient;

	@FindBy(xpath = "//button[@title='Unlink patient from hospital']")
	public WebElement deletePatient;

	@FindBy(xpath = "//button[@id='new-video-visit']")
	public WebElement videoChat;

	@FindBy(xpath = "(//button[@id='print'])[3]")
	public WebElement printId;
	@FindBy(xpath = "(//button[@onclick='Page.goBack()'])[3]")
	public WebElement goBack;

	@FindBy(xpath = "//button[@id='new-health-record']")
	public WebElement newHealthRecordCreation;

	@FindBy(xpath = "//div[@id='p-address-phone']/div/div/div[1]/div[1]//following::div[1]/div[1]/div")
	public WebElement addContactIcon;

	@FindBy(xpath = "//div[@id='p-address-phone']/div/div/div[2]/div/div[1]/div[2]/input[4]")
	public WebElement Addressline1;

	@FindBy(xpath = "//div[@id='p-address-phone']/div/div/div[2]/div/div[1]/div[2]/input[5]")
	public WebElement Addressline2;

	@FindBy(xpath = "//div[@id='p-address-phone']/div/div/div[2]/div/div[1]/div[2]/input[6]")
	public WebElement City;

	@FindBy(xpath = "//select[@class='edit-select country']")
	public WebElement selectCountry;

	@FindBy(xpath = "//select[@class='edit-select country']//following::label[1]//following::select[1]")
	public WebElement selectState;

	@FindBy(xpath = "//div[@id='p-address-phone']/div/div/div[2]/div/div[1]/div[2]/input[7]")
	public WebElement zipCode;

	@FindBy(xpath = "(//span[text()='Alternate Contact'])[2]//following::input[2]//parent::div/div/div")
	public WebElement selectFlag;

	@FindBy(xpath = "(//input[@id='phone1'])[2]")
	public WebElement enterPhoneNumber;


	@FindBy(xpath = "(//textarea[@id='notes'])[1]")
	public WebElement enterNotes;

	@FindBy(xpath = "//div[@id='p-address-phone']/div/div/div[2]/div/div[2]/div[1]/div[1]/button[2]")
	public WebElement saveContactInfo;

	@FindBy(xpath = "(//div[@id='family-health-patient']/div/div/div[1]/div[1]//following::div[1]/div[1])[1]")
	public WebElement AlternateContactIcon;

	@FindBy(xpath = "(//span[text()='Alternate Contact'])[2]//following::input[1]")
	public WebElement alternateContactFullName;

	@FindBy(xpath = "(//span[text()='Alternate Contact'])[2]//following::input[2]")
	public WebElement alternateContactPhNumber;

	@FindBy(xpath = "(//span[text()='Alternate Contact'])[2]//following::div[1]/img[1]")
	public WebElement alternatecontactSaveicon;

	@FindBy(xpath = "(//span[text()='Alternate Contact'])[2]//following::input[2]//parent::div[1]/div/div//following::ul[1]/li/span[2]")
	public List<WebElement> $countrycode;

	@FindBy(xpath = "//div[@id='patientInfo']/div[1]/span[2]")
	public WebElement addPatientInfoIcon;

	@FindBy(xpath = "//label[text()='Occupation']//following::div[1]/input")
	public WebElement addOccupation;

	@FindBy(xpath = "(//span[text()='Patient Info '])//following::div[1]/img[1]")
	public WebElement savePatientinfo;

	@FindBy(xpath = "(//ul[@id='genderDropdown'])[1]/li")
	public List<WebElement> genderDrop;

	public PatientCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
