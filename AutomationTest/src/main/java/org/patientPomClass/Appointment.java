package org.patientPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Appointment {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//td[text()='Appointment']")
	public WebElement appointmentClick;
	
	
	@FindBy(xpath = "//input[@id='doctorPartyName-cal']")
	public WebElement doctorSearchField;
	

}
