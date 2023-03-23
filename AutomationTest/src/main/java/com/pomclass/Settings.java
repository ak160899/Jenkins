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

	// manage your account elements
	@FindBy(xpath = "//button[text()='Manage your Account']")
	public WebElement manageYorAccount;

	@FindBy(xpath = "(//span[@title='Edit'])[2]")
	public WebElement basicInfoEditIcon;

	@FindBy(id = "hospitalName")
	public WebElement hosipitalName;

	@FindBy(xpath = "//button[@title='Administrator Title']")
	public WebElement basicInfoTitle;

	@FindBy(xpath = "//button[@title='Administrator Title']//following::ul[1]/li")
	public List<WebElement> basicInfoTitleDropdown;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(xpath = "//button[@id='hospitalActiveId']")
	public WebElement basicInfoAdminstatus;

	@FindBy(xpath = "(//ul[@id='advBillType_Dropdown'])[2]/li")
	public List<WebElement> basicInfoAdminstatusDropdown;

	@FindBy(xpath = "(//button[@id='smsP'])[1]")
	public WebElement basicInfoSmsNotication;

	@FindBy(xpath = "//ul[@id='Smsul']/li")
	public List<WebElement> basicInfoSmsNoticationDropdown;

	@FindBy(xpath = "(//button[@id='save-btn'])[3]")
	public WebElement basicInfoSave;

	@FindBy(xpath = "(//button[@id='save-btn'])[4]")
	public WebElement basicInfoSavedrLogin;
	// contact info

	@FindBy(xpath = "(//span[text()='Contact'])[1]//following::div[1]")
	public WebElement conatctInfoEditIcon;

	@FindBy(xpath = "(//input[@id='address1'])[1]")
	public WebElement contactInfoAddressLine1;

	@FindBy(xpath = "(//input[@id='address2'])[1]")
	public WebElement contactInfoAddressLine2;

	@FindBy(xpath = "(//input[@id='city'])[1]")
	public WebElement contactInfoCity;

	@FindBy(xpath = "(//select[@id='countryGeoId'])[1]")
	public WebElement contactInfoCountry;

	@FindBy(xpath = "(//select[@id='stateProvinceGeoId'])[1]")
	public WebElement contactInfoState;

	@FindBy(xpath = "(//div[@class='selected-flag'])[2]")
	public WebElement contactInfoPhone1Flag;

	@FindBy(id = "phone1")
	public WebElement contactInfoPhone1field;

	@FindBy(id = "phone2")
	public WebElement contactInfoPhone2field;

	@FindBy(xpath = "(//div[@class='selected-flag'])[2]//following::ul[1]/li/span[2]")
	public List<WebElement> contactInfoPh1FlagDropdown;

	@FindBy(xpath = "(//div[@class='selected-flag'])[3]")
	public WebElement contactInfoPhone2Flag;

	@FindBy(xpath = "(//div[@class='selected-flag'])[3]//following::ul[1]/li/span[2]")
	public List<WebElement> contactInfoPh2FlagDropdown;

	@FindBy(xpath = "(//input[@id='postalCode'])[1]")
	public WebElement contactInfoPostalCode;

	@FindBy(xpath = "(//button[@id='save-btn'])[5]")
	public WebElement contactInfoSave;

	// speciality

	@FindBy(xpath = "(//div[@id='add-btn'])[3]")
	public WebElement specialtyAddIcon;

	@FindBy(xpath = "(//div[@id='add-btn'])[1]")
	public WebElement specialtyAddIcondrLogin;

	@FindBy(id = "spec-search")
	public WebElement specialtyEnter;

	@FindBy(xpath = "(//div[@id='desktop'])[4]/button[2]")
	public WebElement specialtySave;

	@FindBy(xpath = "(//button[@onclick='Page.goBack()'])[1]")
	public WebElement managerYouraccBack;

	// patientInfo

	@FindBy(xpath = "(//span[@id='edit-btn'])[1]")
	public WebElement patientInfoeditIcon;

	@FindBy(xpath = "(//button[@id='gender'])[1]")
	public WebElement patientInfoGender;

	@FindBy(xpath = "(//button[@id='gender'])[1]//following::ul[1]/li")
	public List<WebElement> patientInfoGenderDrop;

	@FindBy(xpath = "(//input[@id='educationform'])[1]")
	public WebElement patinetInfoEducation;

	@FindBy(xpath = "(//input[@id='licensenum'])[1]")
	public WebElement patientInfoLicense;

	@FindBy(xpath = "(//button[@id='save-btn'])[1]")
	public WebElement patientInfoSave;

	@FindBy(xpath = "(//button[@id='save-btn'])[2]")
	public WebElement patientInfoSavedrLogin;

	// manage user

	@FindBy(xpath = "(//button[@onclick='setting.userList()'])[1]")
	public WebElement manageuser;

	@FindBy(xpath = "(//button[@id='new'])[1]")
	public WebElement manageuserAddNewUser;

	@FindBy(xpath = "//input[@id='Firstname']")
	public WebElement MangerUserFirstName;

	@FindBy(xpath = "(//button[@id='createButton'])[2]")
	public WebElement createuser;

	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement ManageUserLastNmae;

	@FindBy(xpath = "//input[@id='UserLoginId']")
	public WebElement manageuserEmailId;

	@FindBy(xpath = "//button[@id='user_dropdown']")
	public WebElement manageUserType;

	@FindBy(xpath = "//button[@id='user_dropdown']//following::ul[1]/li")
	public List<WebElement> manageUserTypeDrop;

	@FindBy(xpath = "//input[@id='PhonE']")
	public WebElement manageUserPhonefield;

	@FindBy(xpath = "(//div[@class='selected-flag'])[4]")
	public WebElement manageUserPhoneFlag;

	@FindBy(xpath = "(//div[@class='selected-flag'])[4]//following::ul[1]/li/span[2]")
	public List<WebElement> manageUserPhoneFlagDrop;

//manage branding

	@FindBy(id = "org-name")
	public WebElement manageBrandingOrgNameDiscription;

	@FindBy(xpath = "//button[@onclick='setting.brand()']")
	public WebElement manageBrandingClick;

	@FindBy(xpath = "//div[@id='setOrgName']/button")
	public WebElement manageBrandingSetName;

	@FindBy(id = "select-email-preview")
	public WebElement manageBrandingEmailPreview;

	@FindBy(xpath = "//button[@id='select-email-preview']//following::ul[1]/li/a")
	public List<WebElement> manageBrandingEmailPreviewDropdown;

	@FindBy(xpath = "//button[@onclick='Health.emailPreview()']")
	public WebElement manageBrandingPreviewClick;

	@FindBy(id = "cancel-btn")
	public WebElement manageBrandingCancelWindow;
	//

	// Auto Logout

	@FindBy(xpath = "//button[@id='auto-logout-time']")
	public WebElement autoLogoutclick;

	@FindBy(xpath = "//button[@id='auto-logout-time']//following::ul[1]/li")
	public List<WebElement> autoLogoutDrop;

	//

	// hospital servce charge tax

	@FindBy(xpath = "//button[@id='taxbutton']")
	public WebElement hospitalServiceChargeTaxclick;

	@FindBy(xpath = "//a[normalize-space()='Service Charges/ Tax']")
	public WebElement hospitalServiceChargeTaxdropclick;

	@FindBy(xpath = "(//span[@id='plus-add'])[1]")

	public WebElement hospitalTaxAddnewTax;

	@FindBy(xpath = "(//input[@id='description'])[2]")
	public WebElement hospitalTaxdiscription;

	@FindBy(xpath = "(//input[@id='percentage'])[2]")
	public WebElement hospitalTaxPercentage;

	@FindBy(xpath = "(//button[@id='save-btn'])[11]")
	public WebElement hospitaltaxSave;

	@FindBy(xpath = "//div[text()='DK']")
	public WebElement editHospitalTax;

	@FindBy(xpath = "(//span[@id='del-btn'])[2]")
	public WebElement deleteHospitalTAX;

	@FindBy(xpath = "(//span[@title='Cancel'])[2]")
	public WebElement closeHospitalTax;
	//

	// cds

	@FindBy(xpath = "//button[contains(text(),'Clinical Decision')]")
	public WebElement cdsClick;

	@FindBy(xpath = "//span[contains(text(),'New Clinical')]")
	public WebElement addnewCds;

	@FindBy(xpath = "(//div[@id='cds_forms']//following::input[1])[1]")
	public WebElement enterCds;

	@FindBy(xpath = "(//input[@id='problem_icd_10'])[2]")
	public WebElement cdsIcd;

	@FindBy(xpath = "//div[text()='Malignant neoplasm of testis']")
	public WebElement CdsicdList;

	@FindBy(xpath = "//input[@id='active']")
	public WebElement cdsCheckbox;

	@FindBy(xpath = "//input[@id='active']//following::div[4]/div/button")
	public WebElement saveCds;

	//

	// set favorites

	@FindBy(xpath = "//button[@onclick='setfavdropdown();']")
	public WebElement setFavoritesClick;

	@FindBy(xpath = "//ul[@id='setfavoritesul']/li")
	public List<WebElement> setFavoriteListDrop;

	@FindBy(xpath = "//div[@id='referral']//following::div[4]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement setfavoritesItemServiceAddIcon;

	@FindBy(xpath = "(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[1]")
	public WebElement setFavoritesItemServiceDiscription;

	@FindBy(xpath = "(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[2]")
	public WebElement setFavoritesItemServicePrice;

	@FindBy(xpath = "(//div[@id='ItemKpop2']//following::button[2])[1]")
	public WebElement setFavoritesItemServiceSave;

	@FindBy(xpath = "//span[text()='test']")
	public WebElement setFavoritesItemServiceEdit;

	@FindBy(xpath = "//div[@id='ItemKpop2']/div[1]/div[2]/span[1]")
	public WebElement setFavoritesItemServiceDelete;

	@FindBy(xpath = "//div[@id='ItemFavKpop2']/div[1]/div[2]/span")
	public WebElement setFavoritesItemServiceClose;

	// message

	@FindBy(xpath = "(//div[@id='message'])[1]/div[1]/div//following::td[4]/span[2]")
	public WebElement setFavoritesMessageAddIcon;

	@FindBy(xpath = "//textarea[@id='message1']")
	public WebElement setFavoritesMessageDiscription;

	@FindBy(xpath = "//textarea[@id='message1']//following::button[2]")
	public WebElement setFavoritesMessageSave;

	@FindBy(xpath = "//div[text()='hello']")
	public WebElement setFavoritesMessageEdit;

	@FindBy(xpath = "//div[@id='MessageKpop2']/div[1]/div[2]/span[1]")
	public WebElement setFavoritesMessageDelete;

	@FindBy(xpath = "(//span[text()='Favorite Message'])[1]//following::div[1]/span")
	public WebElement setFavoritesMessageClose;
	//

	@FindBy(xpath = "(//div[@id='SymptomsFavKpop2']//following::span[5])[1]")
	public WebElement setFavoritesSymptomsAddIcon;

	@FindBy(xpath = "(//div[@id='SymptomsKpop2']//following::input[1])[1]")
	public WebElement setFavoritesSymptomsIcd;

	@FindBy(xpath = "(//div[@id='SymptomsKpop2']//following::input[2])[1]")
	public WebElement setFavoritesSymotomsdiscription;

	@FindBy(xpath = "(//div[@id='SymptomsKpop2']//following::button[2])[1]")
	public WebElement setFavoritesSymptomsSave;

	@FindBy(xpath = "(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]")
	public WebElement setFavoritesSymptomsedit;

	@FindBy(xpath = "(//div[@id='SymptomsKpop2']//following::span[2])[1]")
	public WebElement setFavoriteSymtomsDelete;

	@FindBy(xpath = "(//div[@id='SymptomsFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteSymtomsClose;
	//

	// problems

	@FindBy(xpath = "(//div[@id='ProblemsFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteProblemsAddIcon;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::input[1])[1]")
	public WebElement setFavoriteProblemsIcd;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::input[2])[1]")
	public WebElement setFavoriteProblemsDiscription;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::button[2])[1]")
	public WebElement setFavoriteProblemsSave;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::span[2])[1]")
	public WebElement setFavoriteProblemsDelete;

	@FindBy(xpath = "(//div[@id='ProblemsFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteProblemsClose;

	//

	// visit

	@FindBy(xpath = "(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteVisitReasonAddIcon;

	@FindBy(xpath = "(//button[@id='admissionVal_dropdown'])[1]//following::ul[1]/li/a")
	public List<WebElement> setFavoriteVisitReasonTypeDrop;

	@FindBy(xpath = "//div[@id='Visit_ReasonPellVal']/div[2]")
	public WebElement setFavoriteVisitReasonDiscription;

	@FindBy(xpath = "//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]")
	public WebElement setFavoriteVisitReasonSave;

	@FindBy(xpath = "(//div[text()='VisitReason'])[1]")
	public WebElement setFavoriteVisitReasonEdit;

	@FindBy(xpath = "(//div[@id='Visit_ReasonKpop2']//following::span[2])[1]")
	public WebElement setFavoriteVisitReasondelete;

	@FindBy(xpath = "(//div[@id='Visit_ReasonFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteVisitReasonClose;

	// proceudre

	@FindBy(xpath = "(//div[@id='ProcedureFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteProcedureAddIcon;

	@FindBy(xpath = "(//div[@id='ProcedureKpop2']//following::button[2])[1]")
	public WebElement setFavoriteProcedureSave;

	@FindBy(xpath = "(//div[text()='134287002: Cytomegalovirus antigen test (procedure)'])[1]")
	public WebElement setFavoriteProcedureEdit;

	@FindBy(xpath = "(//div[@id='ProcedureKpop2']//following::span[2])[1]")
	public WebElement setFavoriteProcedureDelete;

	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div/small/em")
	public List<WebElement> setFavoriteProcedureIcdList;

	@FindBy(xpath = "(//div[@id='ProcedureFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteProcedureClose;

	// medication

	@FindBy(xpath = "(//div[@id='MedicationsFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteMedicationAddIcon;

	@FindBy(xpath = "(//div[@id='MedicationsKpop2']//following::input[1])[1]")
	public WebElement setFavoriteMedicationIcd;

	@FindBy(xpath = "//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[2]/li/a/div/small/em")
	public List<WebElement> setFavoriteMedicationIcdList;

	@FindBy(xpath = "(//div[@id='MedicationsKpop2']//following::button[3])[1]")
	public WebElement setFavoriteMedicationSave;

	@FindBy(xpath = "(//div[text()='amphetamine aspartate 1.875 MG / amphetamine sulfate 1.875 MG / dextroamphetamine saccharate 1.875 MG / dextroamphetamine sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]")
	public WebElement setFavoriteMedicationEdit;

	@FindBy(xpath = "(//div[text()='Amphetamine aspartate 1.875 MG / Amphetamine Sulfate 1.875 MG / Dextroamphetamine saccharate 1.875 MG / Dextroamphetamine Sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]")
	public WebElement setFavoriteMedicationEditLh;

	@FindBy(xpath = "(//span[text()='Amphetamine aspartate 1.875 MG / Amphetamine Sulfate 1.875 MG / Dextroamphetamine saccharate 1.875 MG / Dextroamphetamine Sulfate 1.875 MG Oral Tablet | 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]")
	public WebElement setFAoriteeditTestSer;
	@FindBy(xpath = "(//div[@id='MedicationsKpop2']//following::span[2])[1]")
	public WebElement setFavoriteMedicationDelete;

	@FindBy(xpath = "(//div[@id='MedicationsFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteMedicationClose;

	// Test Order

	@FindBy(xpath = "(//div[@id='Test_OrderFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteTestOrderAddIcon;

	@FindBy(xpath = "(//div[@id='Test_OrderKpop2']//following::input[1])[1]")
	public WebElement setFavoriteTestOrderIcd;

	@FindBy(xpath = "(//div[@id='Test_OrderKpop2']//following::button[2])[1]")
	public WebElement setFavoriteTestOrderSave;

	@FindBy(xpath = "(//div[text()='test'])[1]")
	public WebElement setFavoriteTestOrderEdit;

	@FindBy(xpath = "(//div[@id='Test_OrderKpop2']//following::span[2])[1]")
	public WebElement setFavoriteTestOrderDelete;

	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::ul[1]/li/a/div")
	public List<WebElement> setFavoriteTestOrderIcdList;

	@FindBy(xpath = "(//div[@id='Test_OrderFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteTestOrderClose;

	// Vaccine

	@FindBy(xpath = "(//div[@id='VaccineFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteVaccineAddIcon;

	@FindBy(xpath = "(//div[@id='VaccineKpop2']//following::input[1])[1]")
	public WebElement setFavoriteVaccineIcd;

	@FindBy(xpath = "(//div[@id='VaccineKpop2']//following::input[2])[1]")
	public WebElement setFavoriteVaccineDiscription;

	@FindBy(xpath = "(//div[text()='105: vaccinia (smallpox) diluted'])[1]")
	public WebElement setFavoriteVaccineEdit;

	@FindBy(xpath = "(//div[@id='VaccineKpop2']//following::span[2])[1]")
	public WebElement setFavoriteVaccinedelete;

	@FindBy(xpath = "(//div[@id='VaccineFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteVaccineClose;

	//

	// Goals

	@FindBy(xpath = "(//div[@id='GoalsFavKpop2']//following::span[5])[1]")
	public WebElement setFavoriteGoalsAddIcon;

	@FindBy(xpath = "//div[@id='GoalsPellVal']/div[2]")
	public WebElement setFavoriteGoalDiscription;

	@FindBy(xpath = "//div[@id='GoalsPellVal']/div[2]//following::button[2]")
	public WebElement setFavoriteGoalSave;

	@FindBy(xpath = "(//div[text()='goals'])[1]")
	public WebElement setFavoriteGoalEdit;

	@FindBy(xpath = "(//div[@id='GoalsKpop2']//following::span[2])[1]")
	public WebElement setFavoriteGoalDelete;

	@FindBy(xpath = "(//div[@id='GoalsFavKpop2']//following::span[1])[1]")
	public WebElement setFavoriteGoalClose;

	// form

	@FindBy(xpath = "//button[@id='form-script']")
	public WebElement customForm;

	@FindBy(xpath = "//div[@id='FormsKpop2']/div[1]/span")
	public WebElement addNewform;

	@FindBy(xpath = "(//label[text()='Form Title*'])[1]//following::input[1]")
	public WebElement formTitleDiscription;

	@FindBy(xpath = "(//div[@id='build-wrap'])[1]/div[1]/div[2]/ul/li")
	public List<WebElement> fromdropDown;

	@FindBy(xpath = "(//div[contains(@data-content,'Drag a field from the right to this area')])[1]/ul")
	public WebElement dropForm;

	@FindBy(xpath = "//label[text()='Label']//following::div[1]/input")
	public WebElement formClearLabel;

	@FindBy(xpath = "(//div[@id='build-wrap'])[1]/div[1]/div[2]/ul//following::div[1]/button")
	public WebElement saveForm;

	// edit reference

	@FindBy(xpath = "//button[@id='edit-print-preference']")
	public WebElement printSettingsClick;

	@FindBy(xpath = "(//div[@id='setupPrintPreference']//following::button[2])")
	public WebElement cancelPrintpreference;

	// Reset

	@FindBy(xpath = "//button[@title='Reset All Your Setting']")
	public WebElement resetSettingClick;

	@FindBy(xpath = "(//span[text()='Reset All Settings'])[1]//following::button[2]")
	public WebElement confirmResetSetting;

	// custom notification
	@FindBy(xpath = "//button[@id='custom-notify']")
	public WebElement customizeMessage;

	@FindBy(xpath = "//input[@id='all-notification-mess']//following::span[1]")
	public WebElement customizeToggle;

	@FindBy(xpath = "(//span[@class='slider1 round1'])[4]")
	public WebElement abovePrefernceToggle;

	// notify ehr

	@FindBy(xpath = "//span[text()='Notify user when EHR is completed.']//parent::div//parent::div[1]/label/input")
	public WebElement notifyEhrToggle;

	// set interval

	@FindBy(xpath = "//span[text()='Set interval for receiving emails.']//parent::div//parent::div[1]/label/input")
	public WebElement setIntervalToggle;

	// Audit report

	@FindBy(xpath = "//button[@onclick='setting.audit()']")
	public WebElement auditReport;

	@FindBy(xpath = "(//input[@id='patientPartyName'])[1]")
	public WebElement AuditReportPatientSerachField;

	@FindBy(xpath = "//div[@id='vvid']//following::ul[1]/li/a/table/tbody/tr[1]/td[2]")
	public List<WebElement> AuditReportPatientDropdown;

	@FindBy(xpath = "//select[@id='byDate']")
	public WebElement selectDate;

	@FindBy(xpath = "//select[@id='auditEventModule']")
	public WebElement selectType;

	@FindBy(xpath = "//button[@id='trash-btn']")
	public WebElement scrollTillDelete;

	@FindBy(xpath = "(//div[@id='AlertMessage']//following::button[1])[1]")
	public WebElement dismiss;

	@FindBy(xpath = "((//div[@id='active-users'])[3]//following::span[1])[1]")
	public WebElement UsersUiActiveUsrPage;

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

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-chevron-right'])[5]")
	public WebElement $Carosel$;
	//// a[@id='rightCarArrow']

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
