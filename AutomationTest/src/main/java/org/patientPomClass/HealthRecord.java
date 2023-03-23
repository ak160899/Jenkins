package org.patientPomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthRecord {

	public WebDriver driver;

	@FindBy(xpath = "//td[text()='Health Record']")
	public WebElement clickHealthRecord;

	@FindBy(xpath = "(//div[@id='list_ehr_needHelp'])[2]/span[3]/span")
	public WebElement ellipses;

	@FindBy(xpath = "(//div[@id='list_ehr_needHelp'])[2]/span[3]/span//following::ul[1]/li/a")
	public List<WebElement> ellipsesDropdown;

	@FindBy(xpath = "(//div[@id='date-created'])[1]/div[1]/button")
	public WebElement dateCreated;

	@FindBy(xpath = "(//div[@id='date-created'])[1]/div[1]/button//following::ul[1]/li/a")
	public List<WebElement> dateCreatedDropdown;

	@FindBy(id = "accept-btn")
	public WebElement apply;

	public HealthRecord(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
