package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ehr_FollowUp {
	public WebDriver driver;

	@FindBy(xpath = "(//button[@id='followUpAdd'])[1]/div[1]")
	public WebElement createFollowUp;

	@FindBy(xpath = "//div[@id='followupEhr']/div[2]/div[3]/div[1]//following::div[2]/input")
	public WebElement dateField;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public WebElement year;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement month;

	@FindBy(xpath = "(//a[text()='31'])")
	public WebElement date;

	@FindBy(xpath = "(//button[@id='fixAppointment'])[1]")
	public WebElement fixAppointment;

	@FindBy(xpath = "(//div[@id='date-data'])[1]")
	public WebElement totalRows;

	@FindBy(xpath = "(//div[@id='formAppointment'])[2]/div/div[2]/div[2]/div[2]/div")
	public WebElement RowsCount;

	@FindBy(xpath = "(//button[@id='followupAdmissionVal_dropdown'])[1]")
	public WebElement appointmnetType;

	@FindBy(xpath = "(//button[@id='followupAdmissionVal_dropdown'])[1]//following::ul[1]/li/a")
	public List<WebElement> appointmentTypeDropdown;

	@FindBy(xpath = "(//button[@id='followupAdmissionVal_dropdown'])[1]//following::textarea[2]")
	public WebElement discription;

	@FindBy(xpath = "(//button[@id='followupAdmissionVal_dropdown'])[1]//following::div[6]/div/div")
	public WebElement saveFollowup;

	@FindBy(xpath = "(//button[@id='fixAppointment'])[1]//following::div[1]/div[1]/span[2]")
	public WebElement deleteAppointment;

	@FindBy(xpath = "//div[@id='followupEhr']/div[1]/div/span[1]")
	public WebElement closeFollowup;

	public Ehr_FollowUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
