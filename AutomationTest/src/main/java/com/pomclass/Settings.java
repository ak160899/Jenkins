package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Settings {
	public WebDriver driver;

	@FindBy(xpath = "//td[text()='Settings']")
	public WebElement clickSettings;

	@FindBy(xpath = "//button[@id='trash-btn']")
	public WebElement scrollTillDelete;

	@FindBy(xpath = "(//div[@id='AlertMessage']//following::button[1])[1]")
	public WebElement dismiss;

	@FindBy(xpath = "(//div[@id='AlertMessage']//following::button[2])[1]")
	public WebElement subscribe;

	@FindBy(id = "editPlanCloseBtn")
	public WebElement $editplnCrossIcon$;

	@FindBy(xpath = "//span[text()='Time To Upgrade!']//following::button[1]")
	public WebElement UpgradeLaterPlanLiteKpop;

	@FindBy(xpath = "//button[@id='taxbutton']")
	public WebElement scrollTillTax;

	@FindBy(xpath = "//ul[@id='hospitalcodeul']/li")
	public List<WebElement> HosiptalCodeDropDown;

	@FindBy(xpath = "//button[@onclick='hospitalcodedropdown();']")
	public WebElement hospitalcodeButton;

	@FindBy(xpath = "//button[@onclick='hospitalcodedropdown();']")
	public WebElement scrollTillHospitalCode;

	@FindBy(xpath = "//button[@id='edit-print-preference']")
	public WebElement scrollTillPrintSettings;

	@FindBy(xpath = "//div[@id='subscription-head']")
	public WebElement scrollTillSubscription;

	@FindBy(xpath = "(//div[text()='Notification Messages'])[1]")
	public WebElement scrollTillNotification;

	@FindBy(xpath = "//button[@onclick='setting.audit()']")
	public WebElement scrollTillAuditReport;

	@FindBy(xpath = "//button[@onclick='setting.userList()']")
	public WebElement clickmanageuser;

	@FindBy(xpath = "//button[text()='Active Users']")
	public WebElement clickactiveuserpage;

	@FindBy(xpath = "//button[text()='Payment History']")
	public WebElement paymenthistorypage;

	@FindBy(xpath = "//button[@onclick='Health.user_new()']")
	public WebElement addnewuser;

	@FindBy(xpath = "//span[text()='Subscription Options']//following::button[2]")
	public WebElement $sub$scribe$;

	@FindBy(xpath = "//span[text()='Premium Upgrade']//following::button[2]")
	public WebElement $upgradeNow;

	@FindBy(xpath = "//span[text()='Subscription Options']//following::button[1]")
	public WebElement $dismissSubscribe$;

	@FindBy(xpath = "//a[@id='rightCarArrow']")
	public WebElement $Carosel$;

	@FindBy(xpath = "//button[text()='Active Users']")
	public WebElement $activeuser$;

	@FindBy(xpath = "//strong[text()='EIR Systems']")
	public WebElement $eirsystembutton$;

	@FindBy(xpath = "//button[@onclick='allPaymentServices.editUsers();']")
	public WebElement $editUserInpaymentpage;

	@FindBy(xpath = "//span[text()='Subscription']//following::i[1]")
	public WebElement $createuserButtonManagersubPage;

	@FindBy(xpath = "//button[@title='Upgrade']")
	public WebElement $upgradenowineir$;

	@FindBy(xpath = "//button[@id='stripe-feature']")
	public WebElement $marketplace;

	@FindBy(xpath = "//button[@id='editPlanBtn']")
	public WebElement $editplan$;

	@FindBy(xpath = "(//button[@id='admissionVal_dropdown'])[1]")
	public WebElement selectAppointmentTypeVisitReasonSetFav;

	public Settings(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
}
