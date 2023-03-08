package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inpatient {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Inpatient')]")
	public WebElement addIcon;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement selectMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public WebElement selectYear;

	@FindBy(xpath = "//div[@id='InpatientKpop2']/div[2]/div[1]/select")
	public WebElement selectType;

	@FindBy(id = "rmNo")
	public WebElement roomNo;

	@FindBy(id = "dischargeSummary")
	public WebElement discharge;

	@FindBy(xpath = "//div[@id='InpatientKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "//a[text()='21']")
	public WebElement chooseDate;
	
	@FindBy(id = "dischargeiid")
	public WebElement dischargeIdField;

	public Inpatient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
