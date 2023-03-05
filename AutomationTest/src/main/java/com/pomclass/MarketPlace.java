package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPlace {

	public WebDriver driver;

	@FindBy(xpath = "//button[@onclick='eirIntegration.formSubmit();']")
	public WebElement Activate;

	@FindBy(id = "hospitalMobileNo")
	public WebElement mobileNumber;

	@FindBy(id = "hospitalFaxNo")
	public WebElement faxNo;

	@FindBy(id = "deaNumber")
	public WebElement deaNumber;

	@FindBy(id = "userAddress1")
	public WebElement Address1;

	@FindBy(id = "userAddress2")
	public WebElement Address2;

	@FindBy(id = "userCity")
	public WebElement city;

	@FindBy(id = "add-user-inside")
	public WebElement addUsers;

	@FindBy(xpath = "(//input[@id='userPartyName'])[3]")
	public WebElement doctorUserSerachField;

	@FindBy(id = "userFname")
	public WebElement firstName;

	@FindBy(id = "userMname")
	public WebElement middleName;

	@FindBy(id = "userLname")
	public WebElement lastName;

	@FindBy(id = "UserBirthdate")
	public WebElement birtdateField;

	@FindBy(id = "userTaxId")
	public WebElement taxId;

	@FindBy(id = "SSN")
	public WebElement ssn;

	@FindBy(id = "userFaxNo")
	public WebElement userFaxNo;

	@FindBy(id = "userDeaNum")
	public WebElement userDeaNumber;

	@FindBy(id = "userNPInum")
	public WebElement userNpiNumber;

	@FindBy(id = "checkbox-button__control")
	public WebElement userCheckBox;

	@FindBy(id = "continue-btn")
	public WebElement saveUser;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public WebElement selectYear;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement selectMonth;

	@FindBy(xpath = "//a[text()='31']")
	public WebElement chooseDate;

	@FindBy(id = "userStateProvinceId")
	public WebElement state;

	@FindBy(id = "userPostalCode")
	public WebElement postalcode;

	@FindBy(xpath = "//button[@onclick='eprescribingIntakeForm.AddUsers()']")
	public WebElement continueButton;

	public MarketPlace(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
