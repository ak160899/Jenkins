package runner;

import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.healthRec.*;
import org.Launch.LaunchBrowser;
import org.apache.commons.lang.RandomStringUtils;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.healthRec.Forms;
import com.healthRec.Goals;
import com.healthRec.Medication;
import com.healthRec.Problems;
import com.healthRec.Procedure;
import com.healthRec.Symptoms;
import com.healthRec.Vaccine;
import com.healthRec.Vitals;
import com.pageObjeman.PageObjMan;
import com.pomclass.VisitReason;

public class Local_Host extends Base {

	public PageObjMan pom;
	public JavascriptExecutor j;
	public WebDriverWait ww;
	public WebDriver driver;
	public String kpid = "";
	public String ur;
	Calendars cal;
	String $current;

	@BeforeClass(groups = "before")
	public void LaunchBrwoser() throws Exception {

		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");
		driver = (WebDriver) getConnection.get("driver");

	}

	@Test(priority = 0, groups = "home")
	public void HomeModule() throws Exception {

		try {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 40);

			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			click(pom.getInstanceHomeModule().$patientCreationButton);

		} catch (ElementClickInterceptedException e) {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 40);
			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			click(pom.getInstanceHomeModule().$patientCreationButton);
		}

		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		click(pom.getInstanceNewPatient().clickGenderIcon);

		List<WebElement> genders = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));

		for (WebElement opt : genders) {

			if (opt.getText().equals("Male")) {

				driver.findElement(By.xpath("(//ul[@id='genderDropdown'])[1]/li")).click();

			}
			break;
		}

		// String character = RandomStringUtils.randomAlphabetic(12);

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		click(pom.getInstanceHomeModule().selectFlagPhoneNumField);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				click(flag);
				break;
			}
		}

		// String numericRand = RandomStringUtils.randomNumeric(5);
		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));

		// Acc gets Created..
		click(pom.getInstanceNewPatient().CreatePatient);

		while (true) {
			try {
				WebElement $patietcreateid$ = driver.findElement(By.xpath("//td[@id='val-kpid']"));
				if ($patietcreateid$.isDisplayed()) {
					kpid = $patietcreateid$.getText();
					System.out.println("HOME PATIENT" + kpid);

					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/*
		 * navigateback(2);
		 * 
		 * $current = driver.getCurrentUrl(); cal.$dayDrop($current);
		 * cal.$calenderMod($current, kpid);
		 */

	}

	@Test(priority = 1, groups = "patient")
	public void PatientModule() throws InterruptedException {

		try {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 50);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 50);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
		}
		implicitWait(60, TimeUnit.SECONDS);

		try {
			visbility(driver, pom.getInstanceNewPatient().addNewPatient, 60);
			elementClickable(pom.getInstanceNewPatient().addNewPatient);
			click(pom.getInstanceNewPatient().addNewPatient);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNewPatient().addNewPatient, 60);
			elementClickable(pom.getInstanceNewPatient().addNewPatient);
			click(pom.getInstanceNewPatient().addNewPatient);
		}

		visbility(driver, pom.getInstanceNewPatient().firstName, 60);
		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		visbility(driver, pom.getInstanceNewPatient().lastname, 60);
		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		visbility(driver, pom.getInstanceNewPatient().clickGenderIcon, 60);
		elementClickable(pom.getInstanceNewPatient().clickGenderIcon);
		click(pom.getInstanceNewPatient().clickGenderIcon);

		for (WebElement opt : pom.getInstanceNewPatient().genderDrop) {

			if (opt.getText().equals("Male")) {

				click(opt);
				break;

			}

		}

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));

		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		click(pom.getInstanceHomeModule().selectFlagPhoneNumField);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				click(flag);
				break;
			}
		}

		// String numericRand = RandomStringUtils.randomNumeric(5);
		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));

		// Acc gets Created..
		elementClickable(pom.getInstanceNewPatient().CreatePatient);
		click(pom.getInstanceNewPatient().CreatePatient);
		sleep(2000);

		try {
			WebElement es = driver.findElement(By.xpath("//td[@id='val-kpid']"));
			visbility(driver, es, 60);
			kpid = es.getText();

		} catch (Exception e) {
			WebElement es = driver.findElement(By.xpath("//td[@id='val-kpid']"));
			visbility(driver, es, 60);
			kpid = es.getText();
		}

		try {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 40);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 40);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
			System.out.println(e);
		}

		try {
			WebElement s = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[2]"));
			visbility(driver, s, 60);
			s.sendKeys(kpid);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			WebElement s = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[2]"));
			visbility(driver, s, 60);
			s.sendKeys(kpid);
		}
		try {
			WebElement kp = driver.findElement(By.xpath("//div[text()=" + "'" + kpid + "']"));
			elementClickable(kp);
			click(kp);

		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			WebElement kp = driver.findElement(By.xpath("//div[text()=" + "'" + kpid + "']"));
			elementClickable(kp);
			click(kp);
		}

		sleep(2000);

		// med info..

		/*
		 * WebElement ed =
		 * driver.findElement(By.xpath("//div[@id='basicinfo-div']/div/span[2]"));
		 * ww.until(ExpectedConditions.elementToBeClickable(ed)); actions("click", ed);
		 * 
		 * WebElement fname = driver.findElement(By.
		 * xpath("//span[text()='Medical Info ']//following::div[2]/input[2]"));
		 * fname.clear(); fname.sendKeys("Rolls"); WebElement lname =
		 * driver.findElement(By.
		 * xpath("//span[text()='Medical Info ']//following::div[2]/input[3]"));
		 * lname.clear(); lname.sendKeys("Royals");
		 */

		/*
		 * driver.findElement(By.
		 * xpath("//span[text()='Medical Info ']//following::div[2]/input[4]")).click();
		 * sleep(4000);
		 * 
		 * WebElement mnth =
		 * driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		 * mnth.click(); Select s = new Select(mnth); s.selectByIndex(5);
		 * 
		 * WebElement yr =
		 * driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")); Select
		 * ss = new Select(yr); ss.selectByIndex(9);
		 */
		/*
		 * List<WebElement> bldgrp = driver .findElements(By.
		 * xpath("//span[text()='Medical Info ']//following::div[3]/ul/li/a")); for
		 * (WebElement web : bldgrp) { if (web.getText().trim().equals("O Positive")) {
		 * web.click(); break; }
		 * 
		 * }
		 * 
		 * driver.findElement(By.
		 * xpath("//span[text()='Medical Info ']//following::div[3]//following::input[1]"
		 * )) .sendKeys("ins12234"); driver.findElement(By.
		 * xpath("//span[text()='Medical Info ']//following::div[3]//following::input[2]"
		 * )) .sendKeys("Riseup sTRONGER"); WebElement sav =
		 * driver.findElement(By.xpath(
		 * "//div[@id='p_previousname']/div//following::div[5]/button[2]"));
		 * ww.until(ExpectedConditions.elementToBeClickable(sav)); javascriptclick(sav);
		 * sleep(2000);
		 */

		// contact info

		try {

			elementClickable(pom.getInstanceNewPatient().addContactIcon);
			click(pom.getInstanceNewPatient().addContactIcon);

		} catch (ElementClickInterceptedException e) {
			elementClickable(pom.getInstanceNewPatient().addContactIcon);
			click(pom.getInstanceNewPatient().addContactIcon);
		}

		visbility(driver, pom.getInstanceNewPatient().Addressline1, 40);
		sendkeys(pom.getInstanceNewPatient().Addressline1, "no.224 watson");
		visbility(driver, pom.getInstanceNewPatient().Addressline2, 30);
		sendkeys(pom.getInstanceNewPatient().Addressline2, "Arizona");
		visbility(driver, pom.getInstanceNewPatient().City, 30);
		sendkeys(pom.getInstanceNewPatient().City, "WWF");

		try {

			visbility(driver, pom.getInstanceNewPatient().selectCountry, 40);
			dropDown("index", pom.getInstanceNewPatient().selectCountry, "03");

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNewPatient().selectCountry, 40);
			dropDown("index", pom.getInstanceNewPatient().selectCountry, "03");
			System.out.println(e);
		}

		try {

			visbility(driver, pom.getInstanceNewPatient().selectState, 40);
			dropDown("index", pom.getInstanceNewPatient().selectState, "05");

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNewPatient().selectState, 40);
			dropDown("index", pom.getInstanceNewPatient().selectState, "05");
			System.out.println(e);
		}

		visbility(driver, pom.getInstanceNewPatient().zipCode, 40);

		sendkeys(pom.getInstanceNewPatient().zipCode, "600110");

		elementClickable(pom.getInstanceNewPatient().saveContactInfo);
		click(pom.getInstanceNewPatient().saveContactInfo);

		// alternate contact info...

		try {
			visbility(driver, pom.getInstanceNewPatient().AlternateContactIcon, 40);
			elementClickable(pom.getInstanceNewPatient().AlternateContactIcon);
			click(pom.getInstanceNewPatient().AlternateContactIcon);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().AlternateContactIcon, 40);
			elementClickable(pom.getInstanceNewPatient().AlternateContactIcon);
			click(pom.getInstanceNewPatient().AlternateContactIcon);

		}
		visbility(driver, pom.getInstanceNewPatient().alternateContactFullName, 40);
		sendkeys(pom.getInstanceNewPatient().alternateContactFullName, "Kaaspro");

		/* while (true) { */
		try {
			// if (pom.getInstanceNewPatient().selectFlag.isDisplayed()) {
			visbility(driver, pom.getInstanceNewPatient().selectFlag, 40);
			elementClickable(pom.getInstanceNewPatient().selectFlag);
			click(pom.getInstanceNewPatient().selectFlag);
			// break;
			// }
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNewPatient().selectFlag, 40);
			elementClickable(pom.getInstanceNewPatient().selectFlag);
			click(pom.getInstanceNewPatient().selectFlag);
			System.out.println(e);
		}
		// }

		for (WebElement w : pom.getInstanceNewPatient().$countrycode) {

			if (w.getText().equals("+91")) {
				click(w);
				break;
			}

		}
		visbility(driver, pom.getInstanceNewPatient().alternateContactPhNumber, 0);
		sendkeys(pom.getInstanceNewPatient().alternateContactPhNumber, "9098674534");

		elementClickable(pom.getInstanceNewPatient().alternatecontactSaveicon);
		click(pom.getInstanceNewPatient().alternatecontactSaveicon);

		sleep(2000);

		// patient info..

		try {
			visbility(driver, pom.getInstanceNewPatient().addPatientInfoIcon, 40);
			elementClickable(pom.getInstanceNewPatient().addPatientInfoIcon);
			click(pom.getInstanceNewPatient().addPatientInfoIcon);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().addPatientInfoIcon, 40);
			elementClickable(pom.getInstanceNewPatient().addPatientInfoIcon);
			click(pom.getInstanceNewPatient().addPatientInfoIcon);
		}

		visbility(driver, pom.getInstanceNewPatient().addOccupation, 30);
		sendkeys(pom.getInstanceNewPatient().addOccupation, "Software tester");
		try {
			visbility(driver, pom.getInstanceNewPatient().savePatientinfo, 40);
			elementClickable(pom.getInstanceNewPatient().savePatientinfo);
			click(pom.getInstanceNewPatient().savePatientinfo);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().savePatientinfo, 40);
			elementClickable(pom.getInstanceNewPatient().savePatientinfo);
			click(pom.getInstanceNewPatient().savePatientinfo);
		}
		try {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 40);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 40);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
		}

		// driver.navigate().to("https://localhost:8443/health/#list_patient");
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		try {
			visbility(driver, pom.getInstanceNewPatient().patientmodReport, 40);
			elementClickable(pom.getInstanceNewPatient().patientmodReport);
			click(pom.getInstanceNewPatient().patientmodReport);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().patientmodReport, 40);
			elementClickable(pom.getInstanceNewPatient().patientmodReport);
			click(pom.getInstanceNewPatient().patientmodReport);
		}

		try {
			visbility(driver, pom.getInstanceNewPatient().patientReportSerachNametxtBox, 40);
			sendkeys(pom.getInstanceNewPatient().patientReportSerachNametxtBox, "Kaaspro");
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().patientReportSerachNametxtBox, 40);
			sendkeys(pom.getInstanceNewPatient().patientReportSerachNametxtBox, "Kaaspro");
		}
		while (true) {
			try {
				if (pom.getInstanceNewPatient().ellipses.isDisplayed()) {
					click(pom.getInstanceNewPatient().ellipses);
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		for (WebElement t : pom.getInstanceNewPatient().ellipsesOptions) {
			if (t.getText().trim().equals("Import") && t.isDisplayed()) {
				click(t);
				break;
			}

		}

		sleep(2000);

		for (WebElement w : pom.getInstanceNewPatient().$ccdImport) {
			if (w.getText().trim().equals("CCD Import") && w.isDisplayed()) {
				click(w);
				break;
			}

		}
		while (true) {
			try {

				if (pom.getInstanceNewPatient().$closeCcdImport.isDisplayed()) {
					click(pom.getInstanceNewPatient().$closeCcdImport);
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	@Test(priority = 2, groups = "healthrec")
	public void HealthRec() throws Exception {

		if (ur.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (ur.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (ur.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		sleep(3000);
		implicitWait(60, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement remv = driver
						.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
				visbility(driver, remv, 60);

				javascriptclick(remv);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		List<WebElement> wwe;
		while (true) {
			try {
				wwe = driver.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
				break;
			} catch (Exception e) {

			}
		}
		for (WebElement web : wwe) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				clickble(driver, web, 60);

				web.click();
				break;
			}

		}
		sleep(2000);
		try {
			WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
			visbility(driver, r7, 60);
			elementClickable(r7);
			r7.click();
		} catch (ElementClickInterceptedException e) {
			WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
			visbility(driver, r7, 60);
			elementClickable(r7);
			r7.click();
		}

		/*
		 * WebElement elipse =
		 * driver.findElement(By.xpath("(//span[@id='list_patient_needHelp'])[1]/span"))
		 * ; visbility(driver, elipse, 60); clickble(driver, elipse, 60);
		 * actions("click", elipse);
		 * 
		 * List<WebElement> hh = driver .findElements(By.xpath(
		 * "(//span[@id='list_patient_needHelp'])[1]/span//following::ul[1]/li")); for
		 * (WebElement web : hh) { if (web.getText().trim().equals("Reset Setting")) {
		 * visbility(driver, web, 60); web.click(); break; }
		 * 
		 * }
		 */

		implicitWait(60, TimeUnit.SECONDS);

		sleep(3000);
		List<WebElement> rowfor = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div"));

		int ehrrow = rowfor.size();

		boolean bl = false;
		for (int i = 1; i <= ehrrow; i++) {

			List<WebElement> ds = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div"));

			for (int b = 1; b < ds.size(); b++) {

				WebElement sf = driver.findElement(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div[" + b + "]"));

				if (sf.isDisplayed() == false) {

					bl = true;
					WebElement r8 = driver.findElement(By.xpath("(//button[@id='options-img'])[1]"));
					visbility(driver, r8, 60);
					ww.until(ExpectedConditions.elementToBeClickable(r8));
					r8.click();
					List<WebElement> fin = driver.findElements(By.xpath("(//ul[@id='matchKey'])[2]/li/span/a"));
					driver.findElement(By.xpath("(//input[@id='optionsSearch'])[2]")).sendKeys("show");
					implicitWait(60, TimeUnit.SECONDS);

					for (WebElement web : fin) {

						if (web.getText().trim().equals("Show Allergy")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Alert")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Social History")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Family Health")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Symptoms")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Problems")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Vital")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Visit Reason")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Procedure")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Medications")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Test Order")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Note")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Vaccine")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Attach File")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Inpatient")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Referral")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Custom-form")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Goals")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Amendment")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Implantable Devices")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Advance Directives")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Physical Examination")) {

							actions("click", web);

						} else if (web.getText().trim().equals("Show Status")) {

							actions("click", web);

						} else {

							continue;
						}

					}

				}

			}
			if (bl == true) {
				WebElement bb2 = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div[2]/button"));
				visbility(driver, bb2, 60);
				bb2.click();
				break;
			}
		}

		// vitals

		for (int i = 1; i <= ehrrow; i++) {

			List<WebElement> qf = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div"));
			for (int j = 1; j <= qf.size(); j++) {

				WebElement gettag = driver
						.findElement(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div[" + j + "]"));
				visbility(driver, gettag, 60);

				String tagnames = gettag.getAttribute("id");

				if (tagnames.equals("vital")) {
					// Vitals v = new Vitals();
					Vitals.vitalsFeature();

				} else if (tagnames.equals("visit-reason")) {
					com.healthRec.VisitReason.visit();

				} else if (tagnames.equals("alert-allergy")) {

					while (true) {
						if (pom.getInstanceAllerygy().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAllerygy().addIcon, 30);
							elementClickable(pom.getInstanceAllerygy().addIcon);
							click(pom.getInstanceAllerygy().addIcon);
							break;
						} else {
							if (!pom.getInstanceAllerygy().addIcon.isDisplayed()) {
								actions("move to element", pom.getInstanceAllerygy().addIcon);
							}
						}
					}

					visbility(driver, pom.getInstanceAllerygy().selectAllergyType, 30);
					elementClickable(pom.getInstanceAllerygy().selectAllergyType);
					click(pom.getInstanceAllerygy().selectAllergyType);
					dropDown("text", pom.getInstanceAllerygy().selectAllergyType, "Food Allergy");
					visbility(driver, pom.getInstanceAllerygy().allergenDiscription, 30);
					sendkeys(pom.getInstanceAllerygy().allergenDiscription, "food1");

					visbility(driver, pom.getInstanceAllerygy().reactionDiscription, 30);
					sendkeys(pom.getInstanceAllerygy().reactionDiscription, "stomach pain");

					elementClickable(pom.getInstanceAllerygy().more);
					click(pom.getInstanceAllerygy().more);

					for (WebElement w : pom.getInstanceAllerygy().chooseFromDropdown) {
						if (w.getText().trim().equals("Show Severity")) {
							w.click();
							break;
						}

					}
					sleep(2000);
					try {
						elementClickable(pom.getInstanceAllerygy().more);
						click(pom.getInstanceAllerygy().more);
					} catch (ElementClickInterceptedException e) {
						elementClickable(pom.getInstanceAllerygy().more);
						click(pom.getInstanceAllerygy().more);
					}

					for (WebElement w : pom.getInstanceAllerygy().chooseFromDropdown) {
						if (w.getText().trim().equals("Show Status")) {
							visbility(driver, w, 30);
							elementClickable(w);
							click(w);
							break;
						}

					}

					visbility(driver, pom.getInstanceAllerygy().severityDiscription, 30);

					dropDown("text", pom.getInstanceAllerygy().severityDiscription, "Mild");

					sleep(2000);
					visbility(driver, pom.getInstanceAllerygy().statusDiscription, 30);

					dropDown("text", pom.getInstanceAllerygy().statusDiscription, "Inactive");

					elementClickable(pom.getInstanceAllerygy().saveButton);
					click(pom.getInstanceAllerygy().saveButton);

					for (WebElement w : pom.getInstanceAllerygy().saveDropdown) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							elementClickable(w);
							click(w);
							break;
						}

					}
					try {
						WebElement edit = driver.findElement(By.xpath("//span[text()='food1']"));
						visbility(driver, edit, 60);
						elementClickable(edit);
						click(edit);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						WebElement edit = driver.findElement(By.xpath("//span[text()='food1']"));
						visbility(driver, edit, 60);
						elementClickable(edit);
						click(edit);
					}

					visbility(driver, pom.getInstanceAllerygy().allergenDiscription, 40);
					clear(pom.getInstanceAllerygy().allergenDiscription);
					sendkeys(pom.getInstanceAllerygy().allergenDiscription, "st");
					sleep(2000);
					WebElement scq = driver.findElement(By.xpath("//div[text()='Strawberry ']"));
					visbility(driver, scq, 60);
					elementClickable(scq);
					actions("click", scq);

					elementClickable(pom.getInstanceAllerygy().saveButton);
					click(pom.getInstanceAllerygy().saveButton);

					for (WebElement w : pom.getInstanceAllerygy().saveDropdown) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							elementClickable(w);
							click(w);
							break;
						}

					}

					sleep(3000);

					// Social history....
					while (true) {
						if (pom.getInstanceSocialHistory().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceSocialHistory().addIcon, 30);
							elementClickable(pom.getInstanceSocialHistory().addIcon);
							click(pom.getInstanceSocialHistory().addIcon);
							break;

						} else {
							if (!pom.getInstanceSocialHistory().addIcon.isDisplayed()) {
								actions("move to element", pom.getInstanceSocialHistory().addIcon);
							}
						}
					}

					visbility(driver, pom.getInstanceSocialHistory().selectShType, 30);

					dropDown("text", pom.getInstanceSocialHistory().selectShType, "Alcohol");
					visbility(driver, pom.getInstanceSocialHistory().discription, 30);
					sendkeys(pom.getInstanceSocialHistory().discription, "social histry");

					elementClickable(pom.getInstanceSocialHistory().save);
					click(pom.getInstanceSocialHistory().save);
					try {
						WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
						visbility(driver, jj, 60);

						elementClickable(jj);
						click(jj);
					} catch (StaleElementReferenceException e) {
						WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
						visbility(driver, jj, 60);

						elementClickable(jj);
						click(jj);
					}
					visbility(driver, pom.getInstanceSocialHistory().discription, 30);
					clear(pom.getInstanceSocialHistory().discription);

					sendkeys(pom.getInstanceSocialHistory().discription, "KAASPRO ENTERPRISES");
					elementClickable(pom.getInstanceSocialHistory().save);
					click(pom.getInstanceSocialHistory().save);

					// Family Health...

					while (true) {
						if (pom.getInstanceFamilyHaelth().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceFamilyHaelth().addIcon, 30);
							elementClickable(pom.getInstanceFamilyHaelth().addIcon);
							click(pom.getInstanceFamilyHaelth().addIcon);
							break;
						} else {
							if (!pom.getInstanceFamilyHaelth().addIcon.isDisplayed()) {
								actions("move to element", pom.getInstanceFamilyHaelth().addIcon);
							}
						}

					}
					visbility(driver, pom.getInstanceFamilyHaelth().selectFHType, 30);

					dropDown("text", pom.getInstanceFamilyHaelth().selectFHType, "Half Brother");

					visbility(driver, pom.getInstanceFamilyHaelth().icdDiscriptionbox, 30);
					sendkeys(pom.getInstanceFamilyHaelth().icdDiscriptionbox, "2478100");

					FamilyHealth.familyHealthIcd();

					elementClickable(pom.getInstanceFamilyHaelth().save);
					click(pom.getInstanceFamilyHaelth().save);

					for (WebElement w : pom.getInstanceFamilyHaelth().saveDropdown) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

					sleep(3000);
					// Alert...
					WebElement $alert$;
					while (true) {

						if (pom.getInstanceAlert().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAlert().addIcon, 30);
							elementClickable(pom.getInstanceAlert().addIcon);
							click(pom.getInstanceAlert().addIcon);
							break;
						} else {
							if (!pom.getInstanceAlert().addIcon.isDisplayed()) {
								actions("move to element", pom.getInstanceAlert().addIcon);
							}
						}
					}

					visbility(driver, pom.getInstanceAlert().discription, 30);
					sendkeys(pom.getInstanceAlert().discription, "hello");

					elementClickable(pom.getInstanceAlert().visbility);
					click(pom.getInstanceAlert().visbility);

					for (WebElement web : pom.getInstanceAlert().visbilityDropDown) {

						if (web.getText().trim().equals("Everyone")) {
							visbility(driver, web, 30);
							click(web);
							break;
						}

					}
					elementClickable(pom.getInstanceAlert().save);
					click(pom.getInstanceAlert().save);

					try {
						visbility(driver, pom.getInstanceAlert().edit, 40);

						elementClickable(pom.getInstanceAlert().edit);
						click(pom.getInstanceAlert().edit);

					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						System.out.println("stale");
						visbility(driver, pom.getInstanceAlert().edit, 40);
						elementClickable(pom.getInstanceAlert().edit);
						click(pom.getInstanceAlert().edit);

					}

					visbility(driver, pom.getInstanceAlert().discription, 30);
					clear(pom.getInstanceAlert().discription);
					sendkeys(pom.getInstanceAlert().discription, "wELCOME");

					elementClickable(pom.getInstanceAlert().save);
					click(pom.getInstanceAlert().save);
					sleep(3000);
				} else if (tagnames.equals("vaccine")) {

					while (true) {

						if (pom.getInstanceVaccine().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceVaccine().addIcon, 30);
							elementClickable(pom.getInstanceVaccine().addIcon);
							click(pom.getInstanceVaccine().addIcon);
							break;
						} else if (!pom.getInstanceVaccine().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceVaccine().addIcon);
						}
					}

					visbility(driver, pom.getInstanceVaccine().selectDateType, 30);

					dropDown("text", pom.getInstanceVaccine().selectDateType, "Taken Date");

					visbility(driver, pom.getInstanceVaccine().vaccineCvx, 30);
					sendkeys(pom.getInstanceVaccine().vaccineCvx, "kaaspro");
					visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
					sendkeys(pom.getInstanceVaccine().vaccineName, "TT");

					visbility(driver, pom.getInstanceVaccine().save, 30);
					elementClickable(pom.getInstanceVaccine().save);
					click(pom.getInstanceVaccine().save);

					try {

						visbility(driver, pom.getInstanceVaccine().edit, 40);
						elementClickable(pom.getInstanceVaccine().edit);
						click(pom.getInstanceVaccine().edit);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						visbility(driver, pom.getInstanceVaccine().edit, 40);
						elementClickable(pom.getInstanceVaccine().edit);
						click(pom.getInstanceVaccine().edit);
					}

					visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
					clear(pom.getInstanceVaccine().vaccineName);
					sendkeys(pom.getInstanceVaccine().vaccineName, "TT INJECTION");

					elementClickable(pom.getInstanceVaccine().save);
					click(pom.getInstanceVaccine().save);
					sleep(3000);

				} else if (tagnames.equals("implantable-devices")) {

					while (true) {

						if (pom.getInstanceImplantableDevice().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceImplantableDevice().addIcon, 30);
							elementClickable(pom.getInstanceImplantableDevice().addIcon);
							click(pom.getInstanceImplantableDevice().addIcon);
							break;
						} else if (!pom.getInstanceImplantableDevice().addIcon.isDisplayed()) {

							actions("move to element", pom.getInstanceImplantableDevice().addIcon);
						}
					}

					visbility(driver, pom.getInstanceImplantableDevice().udi, 30);
					sendkeys(pom.getInstanceImplantableDevice().udi, "(01)00844588003288");

					elementClickable(pom.getInstanceImplantableDevice().verifyButton);
					click(pom.getInstanceImplantableDevice().verifyButton);

					while (true) {
						if (pom.getInstanceImplantableDevice().verifiedTick.isDisplayed()) {
							break;
						}
					}

					visbility(driver, pom.getInstanceImplantableDevice().note, 30);
					sendkeys(pom.getInstanceImplantableDevice().note, "hello123");

					elementClickable(pom.getInstanceImplantableDevice().save);
					click(pom.getInstanceImplantableDevice().save);
					sleep(2000);
					try {
						WebElement edit = driver
								.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
						visbility(driver, edit, 60);
						elementClickable(edit);
						click(edit);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						WebElement edit = driver
								.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
						visbility(driver, edit, 60);
						elementClickable(edit);
						click(edit);
					}
					visbility(driver, pom.getInstanceImplantableDevice().note, 30);
					clear(pom.getInstanceImplantableDevice().note);
					sendkeys(pom.getInstanceImplantableDevice().note, "JUst Rise up..");

					elementClickable(pom.getInstanceImplantableDevice().save);
					click(pom.getInstanceImplantableDevice().save);

				} else if (tagnames.equals("amendment")) {

					while (true) {

						if (pom.getInstanceAmendment().addIcon.isDisplayed()) {

							visbility(driver, pom.getInstanceAmendment().addIcon, 30);
							elementClickable(pom.getInstanceAmendment().addIcon);
							click(pom.getInstanceAmendment().addIcon);
							break;
						} else if (!pom.getInstanceAmendment().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceAmendment().addIcon);
						}

					}

					visbility(driver, pom.getInstanceAmendment().selectSource, 30);
					dropDown("text", pom.getInstanceAmendment().selectSource, "Patient");
					visbility(driver, pom.getInstanceAmendment().discription, 30);
					sendkeys(pom.getInstanceAmendment().discription, "Akash");

					visbility(driver, pom.getInstanceAmendment().selectStatus, 30);
					dropDown("text", pom.getInstanceAmendment().selectStatus, "Accept");
					visbility(driver, pom.getInstanceAmendment().reasonDiscription, 30);
					sendkeys(pom.getInstanceAmendment().reasonDiscription, "whats up...");
					elementClickable(pom.getInstanceAmendment().save);
					click(pom.getInstanceAmendment().save);

					try {
						WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
						visbility(driver, ac, 60);
						elementClickable(ac);
						click(ac);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
						visbility(driver, ac, 60);
						elementClickable(ac);
						click(ac);
					}
					sleep(2000);

					visbility(driver, pom.getInstanceAmendment().reasonDiscription, 30);
					clear(pom.getInstanceAmendment().reasonDiscription);
					sendkeys(pom.getInstanceAmendment().reasonDiscription, "warrior");

					elementClickable(pom.getInstanceAmendment().save);
					click(pom.getInstanceAmendment().save);
					sleep(3000);

				} else if (tagnames.equals("diagnosis")) {

					Problems.Addproblems();

				} else if (tagnames.equals("symptom")) {

					while (true) {
						if (pom.getInstanceSymptom().addicon.isDisplayed()) {
							visbility(driver, pom.getInstanceSymptom().addicon, 30);
							elementClickable(pom.getInstanceSymptom().addicon);
							click(pom.getInstanceSymptom().addicon);
							break;
						} else if (!pom.getInstanceSymptom().addicon.isDisplayed()) {
							actions("move to element", pom.getInstanceSymptom().addicon);
						}
					}
					visbility(driver, pom.getInstanceSymptom().icd, 30);
					sendkeys(pom.getInstanceSymptom().icd, "test");
					implicitWait(30, TimeUnit.SECONDS);

					while (true) {
						try {

							if (pom.getInstanceSymptom().icdList.size() > 5) {
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (WebElement web : pom.getInstanceSymptom().icdList) {
						if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
							visbility(driver, web, 60);
							elementClickable(web);
							click(web);
							break;
						}

					}
					visbility(driver, pom.getInstanceSymptom().symptoms, 30);
					sendkeys(pom.getInstanceSymptom().symptoms, "fever");
					elementClickable(pom.getInstanceSymptom().save);
					click(pom.getInstanceSymptom().save);
					try {
						WebElement a8 = driver.findElement(
								By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
						visbility(driver, a8, 40);
						elementClickable(a8);
						click(a8);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						WebElement a8 = driver.findElement(
								By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
						visbility(driver, a8, 40);
						elementClickable(a8);
						click(a8);

					}

					visbility(driver, pom.getInstanceSymptom().symptoms, 40);
					clear(pom.getInstanceSymptom().symptoms);
					sendkeys(pom.getInstanceSymptom().symptoms, "covid");

					elementClickable(pom.getInstanceSymptom().save);
					click(pom.getInstanceSymptom().save);

					sleep(4000);

				} else if (tagnames.equals("procedure")) {

					while (true) {

						if (pom.getInstanceProcedure().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceProcedure().addIcon, 40);
							elementClickable(pom.getInstanceProcedure().addIcon);
							click(pom.getInstanceProcedure().addIcon);
							break;
						} else if (!pom.getInstanceProcedure().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceProcedure().addIcon);
						}
					}

					visbility(driver, pom.getInstanceProcedure().selectCodeType, 40);
					dropDown("text", pom.getInstanceProcedure().selectCodeType, "SNOMED CT");
					visbility(driver, pom.getInstanceProcedure().icd, 30);
					sendkeys(pom.getInstanceProcedure().icd, "test");

					while (true) {
						try {

							if (pom.getInstanceProcedure().icdList.size() > 5) {
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (WebElement web : pom.getInstanceProcedure().icdList) {

						if (web.getText().trim().equals("SNOMED : 134287002")) {

							visbility(driver, web, 40);
							elementClickable(web);
							click(web);
							break;

						}

					}
					visbility(driver, pom.getInstanceProcedure().procedure, 40);
					sendkeys(pom.getInstanceProcedure().procedure, "gdgdg");
					elementClickable(pom.getInstanceProcedure().save);
					click(pom.getInstanceProcedure().save);

					for (WebElement w : pom.getInstanceProcedure().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();

							break;
						}

					}

					try {
						// System.out.println("ENTER PROCEUER EDIT {try}");
						WebElement edit = driver.findElement(
								By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
						visbility(driver, edit, 60);
						elementClickable(edit);
						click(edit);

					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						// System.out.println("ENTER PROCEUER EDIT{catch}");
						WebElement edit = driver.findElement(
								By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
						visbility(driver, edit, 60);
						elementClickable(edit);
						click(edit);
						// System.out.println("CLICKED EDIT PRO");
					}
					// System.out.println("edit procedure");
					sleep(2500);
					try {
						// System.out.println("1234");
						visbility(driver, pom.getInstanceProcedure().procedure, 40);
						clear(pom.getInstanceProcedure().procedure);
						sendkeys(pom.getInstanceProcedure().procedure, "LARA");
					} catch (NoSuchElementException e) {
						System.out.println("5678");
						System.out.println("ecception in proceudre");
						visbility(driver, pom.getInstanceProcedure().procedure, 40);
						clear(pom.getInstanceProcedure().procedure);
						sendkeys(pom.getInstanceProcedure().procedure, "LARA");
					}
					elementClickable(pom.getInstanceProcedure().save);
					click(pom.getInstanceProcedure().save);

					for (WebElement w : pom.getInstanceProcedure().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

				} else if (tagnames.equals("goals")) {
					while (true) {

						if (pom.getInstanceGoal().addicon.isDisplayed()) {
							visbility(driver, pom.getInstanceGoal().addicon, 40);
							elementClickable(pom.getInstanceGoal().addicon);
							click(pom.getInstanceGoal().addicon);
							break;
						} else if (!pom.getInstanceGoal().addicon.isDisplayed()) {
							actions("move to element", pom.getInstanceGoal().addicon);
						}
					}
					visbility(driver, pom.getInstanceGoal().enterGoal, 30);
					sendkeys(pom.getInstanceGoal().enterGoal, "goal1");
					sleep(3000);
					try {
						visbility(driver, pom.getInstanceGoal().DateField, 30);
						elementClickable(pom.getInstanceGoal().DateField);
						click(pom.getInstanceGoal().DateField);
						;
						System.out.println("DATE CLICKED");
					} catch (Exception e) {
						System.out.println("DATE CLICKED{catch}");
						visbility(driver, pom.getInstanceGoal().DateField, 30);
						System.out.println("vis");
						elementClickable(pom.getInstanceGoal().DateField);
						System.out.println("clickable");
						click(pom.getInstanceGoal().DateField);
						System.out.println("clcik");

					}
					visbility(driver, pom.getInstanceGoal().selectMonth, 30);
					dropDown("index", pom.getInstanceGoal().selectMonth, "09");

					visbility(driver, pom.getInstanceGoal().chooseDate, 30);
					elementClickable(pom.getInstanceGoal().chooseDate);
					click(pom.getInstanceGoal().chooseDate);

					elementClickable(pom.getInstanceGoal().save);
					click(pom.getInstanceGoal().save);

					try {

						visbility(driver, pom.getInstanceGoal().edit, 60);
						elementClickable(pom.getInstanceGoal().edit);
						click(pom.getInstanceGoal().edit);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {

						visbility(driver, pom.getInstanceGoal().edit, 60);
						elementClickable(pom.getInstanceGoal().edit);
						click(pom.getInstanceGoal().edit);
					}

					visbility(driver, pom.getInstanceGoal().enterGoal, 30);
					clear(pom.getInstanceGoal().enterGoal);
					sendkeys(pom.getInstanceGoal().enterGoal, "HELLO THIS IS GOALS MODULE.");

					elementClickable(pom.getInstanceGoal().save);
					click(pom.getInstanceGoal().save);

					sleep(4000);

				} else if (tagnames.equals("directives")) {

					while (true) {
						if (pom.getInstanceAdvanceDirective().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAdvanceDirective().addIcon, 30);
							elementClickable(pom.getInstanceAdvanceDirective().addIcon);
							click(pom.getInstanceAdvanceDirective().addIcon);
							break;
						} else if (!pom.getInstanceAdvanceDirective().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceAdvanceDirective().addIcon);
						}
					}

					visbility(driver, pom.getInstanceAdvanceDirective().selectType, 30);
					dropDown("text", pom.getInstanceAdvanceDirective().selectType, "Assessment");

					visbility(driver, pom.getInstanceAdvanceDirective().assesment, 30);
					sendkeys(pom.getInstanceAdvanceDirective().assesment, "lets hope");

					elementClickable(pom.getInstanceAdvanceDirective().save);
					click(pom.getInstanceAdvanceDirective().save);
					try {
						WebElement edit = driver.findElement(By.xpath("//div[text()='lets hope']"));
						visbility(driver, edit, 30);
						elementClickable(edit);
						click(edit);

					} catch (StaleElementReferenceException e) {
						WebElement edit = driver.findElement(By.xpath("//div[text()='lets hope']"));

						visbility(driver, edit, 30);
						elementClickable(edit);
						click(edit);

					}

					visbility(driver, pom.getInstanceAdvanceDirective().assesment, 30);
					sendkeys(pom.getInstanceAdvanceDirective().assesment, "Advance directives");

					elementClickable(pom.getInstanceAdvanceDirective().save);
					click(pom.getInstanceAdvanceDirective().save);
					sleep(3000);

				} else if (tagnames.equals("status-module")) {

					while (true) {
						if (pom.getInstanceStatus().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceStatus().addIcon, 30);
							elementClickable(pom.getInstanceStatus().addIcon);
							click(pom.getInstanceStatus().addIcon);
							break;
						} else if (!pom.getInstanceStatus().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceStatus().addIcon);
						}
					}

					visbility(driver, pom.getInstanceStatus().selectType, 40);
					dropDown("text", pom.getInstanceStatus().selectType, "Cognitive status");

					visbility(driver, pom.getInstanceStatus().icd, 40);
					sendkeys(pom.getInstanceStatus().icd, "test");

					while (true) {
						try {

							if (pom.getInstanceStatus().icdList.size() > 5) {

								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (WebElement we : pom.getInstanceStatus().icdList) {
						if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality")) {
							visbility(driver, we, 60);
							elementClickable(we);
							click(we);
							break;
						}

					}

					elementClickable(pom.getInstanceStatus().save);
					click(pom.getInstanceStatus().save);

					try {
						WebElement $editstatus$ = driver.findElement(
								By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
						visbility(driver, $editstatus$, 60);
						elementClickable($editstatus$);
						click($editstatus$);
						visbility(driver, pom.getInstanceStatus().removeStatus, 30);
						elementClickable(pom.getInstanceStatus().removeStatus);
						click(pom.getInstanceStatus().removeStatus);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						WebElement $editstatus$ = driver.findElement(
								By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
						try {
							visbility(driver, $editstatus$, 60);
							elementClickable($editstatus$);
							click($editstatus$);
						} catch (ElementClickInterceptedException t) {
							visbility(driver, $editstatus$, 60);
							elementClickable($editstatus$);
							click($editstatus$);
						}
						try {
							visbility(driver, pom.getInstanceStatus().removeStatus, 30);
							elementClickable(pom.getInstanceStatus().removeStatus);
							click(pom.getInstanceStatus().removeStatus);
						} catch (ElementClickInterceptedException d) {
							visbility(driver, pom.getInstanceStatus().removeStatus, 30);
							elementClickable(pom.getInstanceStatus().removeStatus);
							click(pom.getInstanceStatus().removeStatus);
						}
					}

					visbility(driver, pom.getInstanceStatus().icd, 30);
					sendkeys(pom.getInstanceStatus().icd, "yang");

					while (true) {
						try {

							if (pom.getInstanceStatus().icdList.size() >= 2) {
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (WebElement we : pom.getInstanceStatus().icdList) {
						if (we.getText().trim().equals("370534002: Yang deficiency")) {
							visbility(driver, we, 60);
							elementClickable(we);
							click(we);
							break;
						}

					}

					elementClickable(pom.getInstanceStatus().save);
					click(pom.getInstanceStatus().save);
					sleep(3000);

				} else if (tagnames.equals("test-order")) {

					while (true) {
						if (pom.getInstanceTestOrder().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceTestOrder().addIcon, 30);
							elementClickable(pom.getInstanceTestOrder().addIcon);
							click(pom.getInstanceTestOrder().addIcon);
							break;
						} else if (!pom.getInstanceTestOrder().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceTestOrder().addIcon);
						}
					}

					visbility(driver, pom.getInstanceTestOrder().icd, 30);
					sendkeys(pom.getInstanceTestOrder().icd, "test");

					while (true) {
						try {

							if (pom.getInstanceTestOrder().icdList.size() >= 1) {
								System.out.println("ENTER");
								break;

							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					if (ur.equals("https://localhost:8443/") | ur.equals("https://www.75health.com/login.jsp")) {
						try {

							WebElement edit = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
							visbility(driver, edit, 30);
							elementClickable(edit);
							click(edit);
						} catch (StaleElementReferenceException e) {
							WebElement edit = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
							try {
								visbility(driver, edit, 30);
								elementClickable(edit);
								click(edit);
							} catch (ElementClickInterceptedException h) {
								visbility(driver, edit, 30);
								elementClickable(edit);
								click(edit);
							}
						}

					} /*
						 * else if (ur.equals("https://www.75health.com/login.jsp")) { try { WebElement
						 * edit = driver.findElement(By.xpath("(//div[text()='test'])[2]"));
						 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
						 * (StaleElementReferenceException e) { WebElement edit =
						 * driver.findElement(By.xpath("(//div[text()='test'])[2]")); try {
						 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
						 * (ElementClickInterceptedException t) {
						 * 
						 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } }
						 * 
						 * }
						 */

					elementClickable(pom.getInstanceTestOrder().more);
					click(pom.getInstanceTestOrder().more);

					for (WebElement w : pom.getInstanceTestOrder().moreDropdown) {

						if (w.getText().trim().equals("Show Notes")) {
							visbility(driver, w, 30);
							elementClickable(w);
							click(w);
							break;
						}

					}
					visbility(driver, pom.getInstanceTestOrder().notes, 40);
					sendkeys(pom.getInstanceTestOrder().notes, "ERROR");

					elementClickable(pom.getInstanceTestOrder().save);
					click(pom.getInstanceTestOrder().save);
					for (WebElement w : pom.getInstanceTestOrder().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 30);
							elementClickable(w);
							w.click();
							break;
						}

					}

					try {
						WebElement edit = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));
						visbility(driver, edit, 30);
						elementClickable(edit);
						click(edit);

					} catch (StaleElementReferenceException e) {
						WebElement edit = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));
						try {
							visbility(driver, edit, 30);
							click(edit);
							click(edit);
						} catch (ElementClickInterceptedException r) {
							visbility(driver, edit, 30);
							click(edit);
							click(edit);
						}
					}

					visbility(driver, pom.getInstanceTestOrder().notes, 30);
					clear(pom.getInstanceTestOrder().notes);
					sendkeys(pom.getInstanceTestOrder().notes, "Test order..");

					elementClickable(pom.getInstanceTestOrder().save);
					click(pom.getInstanceTestOrder().save);
					for (WebElement w : pom.getInstanceTestOrder().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 30);
							elementClickable(w);
							w.click();
							break;
						}

					}

				} else if (tagnames.equals("drug")) {

					while (true) {

						if (pom.getInstanceMedication().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceMedication().addIcon, 40);
							elementClickable(pom.getInstanceMedication().addIcon);
							click(pom.getInstanceMedication().addIcon);
							break;
						} else if (!pom.getInstanceMedication().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceMedication().addIcon);
						}
					}

					visbility(driver, pom.getInstanceMedication().drugName, 30);
					sendkeys(pom.getInstanceMedication().drugName, "tata");
					visbility(driver, pom.getInstanceMedication().strenghth, 30);
					sendkeys(pom.getInstanceMedication().strenghth, "str");
					visbility(driver, pom.getInstanceMedication().quantity, 30);
					sendkeys(pom.getInstanceMedication().quantity, "1");
					visbility(driver, pom.getInstanceMedication().direction, 30);
					sendkeys(pom.getInstanceMedication().direction, "q1");

					for (WebElement web : pom.getInstanceMedication().directionDropDown) {
						if (web.getText().trim().equals("q12h - Every twelve hours")) {
							visbility(driver, web, 60);
							elementClickable(web);
							click(web);
							break;
						}

					}

					elementClickable(pom.getInstanceMedication().save);
					click(pom.getInstanceMedication().save);

					for (WebElement w : pom.getInstanceMedication().saveDropdown) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							elementClickable(w);
							w.click();
							break;
						}

					}

					try {
						visbility(driver, pom.getInstanceMedication().edit, 30);
						elementClickable(pom.getInstanceMedication().edit);
						click(pom.getInstanceMedication().edit);
						sleep(2000);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceMedication().edit, 30);
						elementClickable(pom.getInstanceMedication().edit);
						click(pom.getInstanceMedication().edit);
					}
					try {
						visbility(driver, pom.getInstanceMedication().removeMedication, 30);
						elementClickable(pom.getInstanceMedication().removeMedication);
						click(pom.getInstanceMedication().removeMedication);
					} catch (ElementClickInterceptedException e) {
						visbility(driver, pom.getInstanceMedication().removeMedication, 30);
						elementClickable(pom.getInstanceMedication().removeMedication);
						click(pom.getInstanceMedication().removeMedication);
					}

					visbility(driver, pom.getInstanceMedication().drugName, 30);
					sendkeys(pom.getInstanceMedication().drugName, "1009");

					while (true) {
						try {

							if (pom.getInstanceMedication().icdlist.size() > 5) {
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					for (WebElement we : pom.getInstanceMedication().icdlist) {
						System.out.println(we.getText());
						if (we.getText().trim().equals("RXNORM : 1009145")) {

							visbility(driver, we, 60);
							elementClickable(we);
							click(we);
							break;

						}

					}
					visbility(driver, pom.getInstanceMedication().quantity, 30);
					sendkeys(pom.getInstanceMedication().quantity, "1");
					visbility(driver, pom.getInstanceMedication().direction, 30);
					sendkeys(pom.getInstanceMedication().direction, "12");

					for (WebElement web : pom.getInstanceMedication().directionDropDown) {
						if (web.getText().trim().equals("q12h - Every twelve hours")) {
							visbility(driver, web, 60);
							elementClickable(web);
							web.click();
							break;
						}

					}

					elementClickable(pom.getInstanceMedication().save);
					click(pom.getInstanceMedication().save);

					for (WebElement w : pom.getInstanceMedication().saveDropdown) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							elementClickable(w);
							w.click();
							break;
						}

					}

					sleep(3000);
				} else if (tagnames.equals("delivery-note")) {

					while (true) {
						if (pom.getInstanceNotes().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceNotes().addIcon, 30);
							elementClickable(pom.getInstanceNotes().addIcon);
							click(pom.getInstanceNotes().addIcon);
							break;
						} else if (!pom.getInstanceNotes().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceNotes().addIcon);
						}
					}

					visbility(driver, pom.getInstanceNotes().enterNote, 30);
					sendkeys(pom.getInstanceNotes().enterNote, "hell");
					elementClickable(pom.getInstanceNotes().save);
					click(pom.getInstanceNotes().save);
					try {
						visbility(driver, pom.getInstanceNotes().edit, 30);
						elementClickable(pom.getInstanceNotes().edit);
						click(pom.getInstanceNotes().edit);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceNotes().edit, 30);
						elementClickable(pom.getInstanceNotes().edit);
						click(pom.getInstanceNotes().edit);
					}

					visbility(driver, pom.getInstanceNotes().enterNote, 30);
					sendkeys(pom.getInstanceNotes().enterNote, "NOTES--MMM");
					elementClickable(pom.getInstanceNotes().save);
					click(pom.getInstanceNotes().save);

				} else if (tagnames.equals("physical-examination")) {

					while (true) {

						if (pom.getInstancePhysicalExam().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstancePhysicalExam().addIcon, 30);
							elementClickable(pom.getInstancePhysicalExam().addIcon);
							click(pom.getInstancePhysicalExam().addIcon);
							break;
						} else if (!pom.getInstancePhysicalExam().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstancePhysicalExam().addIcon);
						}

					}
					visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
					sendkeys(pom.getInstancePhysicalExam().organItem, "hello");
					visbility(driver, pom.getInstancePhysicalExam().finding, 30);
					sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");

					try {
						elementClickable(pom.getInstancePhysicalExam().more);
						click(pom.getInstancePhysicalExam().more);
					} catch (Exception e) {
						elementClickable(pom.getInstancePhysicalExam().more);
						click(pom.getInstancePhysicalExam().more);
					}
					for (WebElement w : pom.getInstancePhysicalExam().moreDropDown) {
						if (w.getText().trim().equals("Show Notes")) {
							visbility(driver, w, 60);
							elementClickable(w);
							w.click();
							break;
						}

					}

					visbility(driver, pom.getInstancePhysicalExam().notes, 30);
					sendkeys(pom.getInstancePhysicalExam().notes, "lets goo");
					elementClickable(pom.getInstancePhysicalExam().save);
					click(pom.getInstancePhysicalExam().save);
					try {
						visbility(driver, pom.getInstancePhysicalExam().edit, 30);
						elementClickable(pom.getInstancePhysicalExam().edit);
						click(pom.getInstancePhysicalExam().edit);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstancePhysicalExam().edit, 30);
						elementClickable(pom.getInstancePhysicalExam().edit);
						click(pom.getInstancePhysicalExam().edit);
					}

					visbility(driver, pom.getInstancePhysicalExam().notes, 30);
					clear(pom.getInstancePhysicalExam().notes);
					sendkeys(pom.getInstancePhysicalExam().notes, "physical condition");

					elementClickable(pom.getInstancePhysicalExam().save);
					click(pom.getInstancePhysicalExam().save);

				} else if (tagnames.equals("custom-form")) {

					Forms form = new Forms();
					try {
						form.$addForm(driver);
					} catch (Throwable e) {

						e.printStackTrace();
					}

				} else if (tagnames.equals("attachFile")) {

					while (true) {
						if (pom.getInstanceAttachFile().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAttachFile().addIcon, 30);
							elementClickable(pom.getInstanceAttachFile().addIcon);
							click(pom.getInstanceAttachFile().addIcon);
							break;
						} else if (!pom.getInstanceAttachFile().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceAttachFile().addIcon);
						}
					}

					visbility(driver, pom.getInstanceAttachFile().selectType, 30);
					dropDown("text", pom.getInstanceAttachFile().selectType, "Web link");

					visbility(driver, pom.getInstanceAttachFile().link, 30);
					sendkeys(pom.getInstanceAttachFile().link, "https://www.75health.com/");

					elementClickable(pom.getInstanceAttachFile().save);
					click(pom.getInstanceAttachFile().save);

					try {
						visbility(driver, pom.getInstanceAttachFile().edit, 30);
						elementClickable(pom.getInstanceAttachFile().edit);
						click(pom.getInstanceAttachFile().edit);

					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceAttachFile().edit, 30);
						elementClickable(pom.getInstanceAttachFile().edit);
						click(pom.getInstanceAttachFile().edit);
					}

					visbility(driver, pom.getInstanceAttachFile().link, 30);
					clear(pom.getInstanceAttachFile().link);
					sendkeys(pom.getInstanceAttachFile().link, "https://www.75health.com/");
					elementClickable(pom.getInstanceAttachFile().save);
					click(pom.getInstanceAttachFile().save);

					sleep(3000);
				} else if (tagnames.equals("inpatient")) {

					while (true) {
						if (pom.getInstanceInpatient().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceInpatient().addIcon, 30);
							elementClickable(pom.getInstanceInpatient().addIcon);
							click(pom.getInstanceInpatient().addIcon);
							break;
						} else if (!pom.getInstanceInpatient().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceInpatient().addIcon);
						}
					}

					visbility(driver, pom.getInstanceInpatient().selectMonth, 40);
					dropDown("index", pom.getInstanceInpatient().selectMonth, "08");
					visbility(driver, pom.getInstanceInpatient().selectYear, 40);
					dropDown("text", pom.getInstanceInpatient().selectYear, "2022");

					visbility(driver, pom.getInstanceInpatient().chooseDate, 30);
					elementClickable(pom.getInstanceInpatient().chooseDate);
					click(pom.getInstanceInpatient().chooseDate);

					sleep(2000);
					elementClickable(pom.getInstanceInpatient().dischargeIdField);
					click(pom.getInstanceInpatient().dischargeIdField);
					visbility(driver, pom.getInstanceInpatient().selectMonth, 40);
					dropDown("index", pom.getInstanceInpatient().selectMonth, "10");
					visbility(driver, pom.getInstanceInpatient().selectYear, 40);
					dropDown("text", pom.getInstanceInpatient().selectYear, "2022");
					visbility(driver, pom.getInstanceInpatient().chooseDate, 30);
					elementClickable(pom.getInstanceInpatient().chooseDate);
					click(pom.getInstanceInpatient().chooseDate);

					visbility(driver, pom.getInstanceInpatient().selectType, 40);
					dropDown("text", pom.getInstanceInpatient().selectType, "Urgent");
					visbility(driver, pom.getInstanceInpatient().roomNo, 30);
					sendkeys(pom.getInstanceInpatient().roomNo, "777");
					visbility(driver, pom.getInstanceInpatient().discharge, 30);
					sendkeys(pom.getInstanceInpatient().discharge, "okay");
					elementClickable(pom.getInstanceInpatient().save);
					click(pom.getInstanceInpatient().save);

					sleep(3000);

				} /*
					 * else if (tagnames.equals("refer")) {
					 * 
					 * WebElement ju =
					 * driver.findElement(By.xpath("//div[contains(@title,'Add Referral')]"));
					 * actions("move to element", ju); actions("click", ju); WebElement uk = driver
					 * .findElement(By.xpath(
					 * "//div[@id='ReferralKpop2']/div[2]/div/div[2]/div[2]/input"));
					 * uk.sendKeys(ConfigManager.getconfigManager().getInstanceConfigReader().
					 * doctorKpid());// kpid mention // dr... sleep(3000); List<WebElement> rwr =
					 * driver.findElements(By.xpath(
					 * "//div[@id='ReferralKpop2']/div[2]/div[2]//following::ul[1]/li/a/table[1]/tbody/tr/td[2]"
					 * )); for (WebElement w : rwr) { if (w.getText()
					 * .contains(ConfigManager.getconfigManager().getInstanceConfigReader().
					 * doctorKpid())) { w.click(); break;
					 * 
					 * }
					 * 
					 * }
					 * 
					 * sleep(4000); //
					 * driver.findElement(By.xpath("(//input[@id='phone'])[5]")).sendKeys(
					 * "201-525-2236"); sleep(2000); driver.findElement(By.xpath(
					 * "//div[@id='ReferralKpop2']/div[2]/div[1]/div[6]/div[2]/input"))
					 * .sendKeys("hello"); WebElement cv = driver.findElement(By.xpath(
					 * "//div[@id='ReferralKpop2']/div[2]/div[2]/button[2]")); javascriptclick(cv);
					 * sleep(2000);
					 * 
					 * WebElement df = driver.findElement(By.xpath("//div[text()='hello']"));
					 * actions("click", df); WebElement ssf = driver.findElement(By.xpath(
					 * "//div[@id='ReferralKpop2']/div[1]/div[2]/span[1]")); javascriptclick(ssf);
					 * 
					 * 
					 * }
					 */
			}

		}

		implicitWait(30, TimeUnit.SECONDS);
		sleep(2000);

		visbility(driver, pom.getInstanceHealthRec().generateBill, 30);
		elementClickable(pom.getInstanceHealthRec().generateBill);
		click(pom.getInstanceHealthRec().generateBill);

		for (WebElement we : pom.getInstanceHealthRec().genratebillDropdown) {
			if (we.getText().trim().equals("Generate Bill from EHR")) {
				visbility(driver, we, 60);
				elementClickable(we);
				click(we);
				break;
			}

		}
		sleep(4000);

		sleep(3000);
		if (ur.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (ur.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (ur.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		while (true) {
			try {
				driver.findElement(By.id("newMedicalRecordButton")).click();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		sleep(3000);
		// past cured...

		Vaccine vac = new Vaccine(driver);
		try {
			vac.$getPastVaccine();
		} catch (Throwable e1) {

			e1.printStackTrace();
		}

		// Problems pro = new Problems();
		// pro.getPastProblem();

		Symptoms s = new Symptoms(driver);
		s.getPastSymptom();
		Procedure pr = new Procedure(driver);
		pr.getPastProcedure();
		Goals g = new Goals(driver);
		g.$getPastGoals();

		Medication med = new Medication(driver);
		med.$getPastMedication();

		// Salt options Scenarios...

		for (int i = 1; i <= ehrrow; i++) {

			List<WebElement> qf = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div"));
			for (int j = 1; j <= qf.size(); j++) {
				sleep(2000);

				WebElement gettag = driver
						.findElement(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div[" + j + "]"));

				String tagnames = gettag.getAttribute("id");

				if (tagnames.equals("vital")) {

					WebElement vitalsal = driver
							.findElement(By.xpath("//div[@id='vital']/div[1]/div[1]/div/div[2]/div[1]"));

					actions("click", vitalsal);

				} else if (tagnames.equals("visit-reason")) {
					WebElement vistsal = driver
							.findElement(By.xpath("(//div[@id='visit-reason'])[2]/div/div[1]/div/div[2]/div[1]"));
					actions("click", vistsal);

				} else if (tagnames.equals("diagnosis")) {

					WebElement prbsal = driver.findElement(By.xpath("//div[contains(@title,'SALT Problems')]"));
					actions("click", prbsal);

				} else if (tagnames.equals("symptom")) {

					WebElement symsalt = driver.findElement(By.xpath("//div[contains(@title,'SALT Symptoms')]"));
					actions("click", symsalt);

				} else if (tagnames.equals("procedure")) {

					WebElement prosalt = driver.findElement(By.xpath("//div[contains(@title,'SALT Procedure')]"));
					actions("click", prosalt);
				} else if (tagnames.equals("goals")) {

					WebElement goalsalt = driver.findElement(By.xpath("//div[contains(@title,'SALT Goals')]"));
					actions("click", goalsalt);
				} else if (tagnames.equals("directives")) {

					WebElement advsalt = driver
							.findElement(By.xpath("//div[contains(@title,'SALT Advance directives')]"));
					actions("click", advsalt);
				} else if (tagnames.equals("status-module")) {

					WebElement statussalt = driver.findElement(By.xpath("//div[contains(@title,'SALT Status')]"));
					actions("click", statussalt);
				} else if (tagnames.equals("drug")) {

					WebElement medsalt = driver.findElement(By.xpath("//div[contains(@title,'SALT Medications')]"));
					actions("click", medsalt);
				} else if (tagnames.equals("delivery-note")) {
					WebElement notesalt = driver.findElement(By.xpath("//div[contains(@title,'SALT Notes')]"));
					actions("click", notesalt);
				}

			}
		}

		// ehr favorites...

		// vist reason

		while (true) {
			if (pom.getInstanceVistReason().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceVistReason().favoriteIcon, 40);
				elementClickable(pom.getInstanceVistReason().favoriteIcon);
				click(pom.getInstanceVistReason().favoriteIcon);
				break;
			} else if (!pom.getInstanceVistReason().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceVistReason().favoriteIcon);
			}

		}

		try {

			visbility(driver, pom.getInstanceVistReason().addNewFavorite, 30);
			elementClickable(pom.getInstanceVistReason().addNewFavorite);
			click(pom.getInstanceVistReason().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceVistReason().addNewFavorite, 30);
			elementClickable(pom.getInstanceVistReason().addNewFavorite);
			click(pom.getInstanceVistReason().addNewFavorite);

		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			click(pom.getInstanceCalendar().selectAppointmentType);
			System.out.println("ELEMENT CLICKED IN VISIT");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			click(pom.getInstanceCalendar().selectAppointmentType);
		}

		for (WebElement Element : pom.getInstanceVistReason().selectFavoriteAppointmnetType) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency")) {

				click(Element);
				break;
			}

		}

		visbility(driver, pom.getInstanceVistReason().favoriteDiscription, 60);
		sendkeys(pom.getInstanceVistReason().favoriteDiscription, "favorite visit reason");
		elementClickable(pom.getInstanceVistReason().FavoriteSave);
		click(pom.getInstanceVistReason().FavoriteSave);

		try {

			visbility(driver, pom.getInstanceVistReason().editFavorite, 30);
			elementClickable(pom.getInstanceVistReason().editFavorite);
			click(pom.getInstanceVistReason().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceVistReason().editFavorite, 30);
			elementClickable(pom.getInstanceVistReason().editFavorite);
			click(pom.getInstanceVistReason().editFavorite);
		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			click(pom.getInstanceCalendar().selectAppointmentType);
			System.out.println("ELEMENT CLICKED IN VISIT");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			click(pom.getInstanceCalendar().selectAppointmentType);
		}

		for (WebElement Element : pom.getInstanceVistReason().selectFavoriteAppointmnetType) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency")) {
				visbility(driver, Element, 30);
				elementClickable(Element);
				click(Element);
				break;
			}

		}

		visbility(driver, pom.getInstanceVistReason().favoriteDiscription, 30);
		sendkeys(pom.getInstanceVistReason().favoriteDiscription, "favorite visit reason");

		elementClickable(pom.getInstanceVistReason().FavoriteSave);
		click(pom.getInstanceVistReason().FavoriteSave);

		try {

			visbility(driver, pom.getInstanceVistReason().addThisFavorite, 30);
			elementClickable(pom.getInstanceVistReason().addThisFavorite);
			click(pom.getInstanceVistReason().addThisFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceVistReason().addThisFavorite, 30);
			elementClickable(pom.getInstanceVistReason().addThisFavorite);
			click(pom.getInstanceVistReason().addThisFavorite);
		}
		try {
			elementClickable(pom.getInstanceVistReason().closeFavorite);
			click(pom.getInstanceVistReason().closeFavorite);
		} catch (ElementClickInterceptedException e) {
			elementClickable(pom.getInstanceVistReason().closeFavorite);
			click(pom.getInstanceVistReason().closeFavorite);
		}

		sleep(2000);

		// $$$$$$$$//

		// vaccine

		while (true) {

			if (pom.getInstanceVaccine().favoriteicon.isDisplayed()) {
				visbility(driver, pom.getInstanceVaccine().favoriteicon, 30);
				elementClickable(pom.getInstanceVaccine().favoriteicon);
				click(pom.getInstanceVaccine().favoriteicon);
				break;
			} else if (!pom.getInstanceVaccine().favoriteicon.isDisplayed()) {
				actions("move to element", pom.getInstanceVaccine().favoriteicon);
			}
		}

		try {
			visbility(driver, pom.getInstanceVaccine().addNewFavorite, 30);
			elementClickable(pom.getInstanceVaccine().addNewFavorite);
			click(pom.getInstanceVaccine().addNewFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().addNewFavorite, 30);
			elementClickable(pom.getInstanceVaccine().addNewFavorite);
			click(pom.getInstanceVaccine().addNewFavorite);
		}

		visbility(driver, pom.getInstanceVaccine().favoriteVaccineCvx, 30);
		sendkeys(pom.getInstanceVaccine().favoriteVaccineCvx, "vacc");

		while (true) {

			if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {
				// System.out.println(vc4.size());
				break;
			}
		}

		for (WebElement web : pom.getInstanceVaccine().favoriteIcdList) {
			// System.out.println(web.getText());

			if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
				web.click();
				break;
			}

		}

		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		sendkeys(pom.getInstanceVaccine().vaccineName, "vacine favorite");

		elementClickable(pom.getInstanceVaccine().favoriteSave);
		click(pom.getInstanceVaccine().favoriteSave);

		try {

			visbility(driver, pom.getInstanceVaccine().editFavorite, 30);
			elementClickable(pom.getInstanceVaccine().editFavorite);
			click(pom.getInstanceVaccine().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceVaccine().editFavorite, 30);
			elementClickable(pom.getInstanceVaccine().editFavorite);
			click(pom.getInstanceVaccine().editFavorite);
		}

		try {
			visbility(driver, pom.getInstanceVaccine().removeFavoriteIcd, 30);
			elementClickable(pom.getInstanceVaccine().removeFavoriteIcd);
			click(pom.getInstanceVaccine().removeFavoriteIcd);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().removeFavoriteIcd, 30);
			elementClickable(pom.getInstanceVaccine().removeFavoriteIcd);
			click(pom.getInstanceVaccine().removeFavoriteIcd);
		}

		visbility(driver, pom.getInstanceVaccine().favoriteVaccineCvx, 30);
		sendkeys(pom.getInstanceVaccine().favoriteVaccineCvx, "vacc");

		while (true) {

			if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {
				break;
			}
		}

		for (WebElement we : pom.getInstanceVaccine().favoriteIcdList) {

			if (we.getText().trim().equals("vaccinia immune globulin")) {

				visbility(driver, we, 40);
				elementClickable(we);
				click(we);

				break;
			}

		}

		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		clear(pom.getInstanceVaccine().vaccineName);
		sendkeys(pom.getInstanceVaccine().vaccineName, "vacine module");
		elementClickable(pom.getInstanceVaccine().favoriteSave);
		click(pom.getInstanceVaccine().favoriteSave);

		try {

			visbility(driver, pom.getInstanceVaccine().addThisFavorite, 30);
			elementClickable(pom.getInstanceVaccine().addThisFavorite);
			click(pom.getInstanceVaccine().addThisFavorite);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceVaccine().addThisFavorite, 30);
			elementClickable(pom.getInstanceVaccine().addThisFavorite);
			click(pom.getInstanceVaccine().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstanceVaccine().closeFavorite, 30);
			elementClickable(pom.getInstanceVaccine().closeFavorite);
			click(pom.getInstanceVaccine().closeFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().closeFavorite, 30);
			elementClickable(pom.getInstanceVaccine().closeFavorite);
			click(pom.getInstanceVaccine().closeFavorite);
		}

		// $$$$$$$$$symptoms$$$$$

		while (true) {

			if (pom.getInstanceSymptom().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceSymptom().favoriteIcon, 30);
				elementClickable(pom.getInstanceSymptom().favoriteIcon);
				click(pom.getInstanceSymptom().favoriteIcon);
				break;
			} else if (!pom.getInstanceSymptom().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceSymptom().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceSymptom().addNewFavorite, 30);
			elementClickable(pom.getInstanceSymptom().addNewFavorite);
			click(pom.getInstanceSymptom().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addNewFavorite, 30);
			elementClickable(pom.getInstanceSymptom().addNewFavorite);
			click(pom.getInstanceSymptom().addNewFavorite);
		}

		visbility(driver, pom.getInstanceSymptom().favoriteicd, 30);
		sendkeys(pom.getInstanceSymptom().favoriteicd, "test");

		while (true) {
			try {

				if (pom.getInstanceSymptom().favoriteicdList.size() > 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (WebElement web : pom.getInstanceSymptom().favoriteicdList) {
			if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);

				break;
			}

		}

		visbility(driver, pom.getInstanceSymptom().favoriteSymptom, 30);
		sendkeys(pom.getInstanceSymptom().favoriteSymptom, "symptoms favorite");

		elementClickable(pom.getInstanceSymptom().favoriteSave);
		click(pom.getInstanceSymptom().favoriteSave);

		try {

			visbility(driver, pom.getInstanceSymptom().editFavorite, 40);
			elementClickable(pom.getInstanceSymptom().editFavorite);
			click(pom.getInstanceSymptom().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceSymptom().editFavorite, 40);
			elementClickable(pom.getInstanceSymptom().editFavorite);
			click(pom.getInstanceSymptom().editFavorite);
		}

		try {
			visbility(driver, pom.getInstanceSymptom().removeFavoriteIcd, 30);
			elementClickable(pom.getInstanceSymptom().removeFavoriteIcd);
			click(pom.getInstanceSymptom().removeFavoriteIcd);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().removeFavoriteIcd, 30);
			elementClickable(pom.getInstanceSymptom().removeFavoriteIcd);
			click(pom.getInstanceSymptom().removeFavoriteIcd);
		}

		visbility(driver, pom.getInstanceSymptom().favoriteicd, 30);
		sendkeys(pom.getInstanceSymptom().favoriteicd, "test");

		while (true) {
			try {

				if (pom.getInstanceSymptom().favoriteicdList.size() > 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (WebElement web : pom.getInstanceSymptom().favoriteicdList) {
			if (web.getText().trim().equals("R85.81: Anal high risk human papillomavirus (HPV) DNA test positive")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);
				break;
			}

		}
		visbility(driver, pom.getInstanceSymptom().favoriteSymptom, 30);
		clear(pom.getInstanceSymptom().favoriteSymptom);
		sendkeys(pom.getInstanceSymptom().favoriteSymptom, "symptoms favorite kpop2");

		elementClickable(pom.getInstanceSymptom().favoriteSave);
		click(pom.getInstanceSymptom().favoriteSave);

		try {
			visbility(driver, pom.getInstanceSymptom().addThisFavorite, 30);
			elementClickable(pom.getInstanceSymptom().addThisFavorite);
			click(pom.getInstanceSymptom().addThisFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addThisFavorite, 30);
			elementClickable(pom.getInstanceSymptom().addThisFavorite);
			click(pom.getInstanceSymptom().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstanceSymptom().closeFavorite, 30);
			elementClickable(pom.getInstanceSymptom().closeFavorite);
			click(pom.getInstanceSymptom().closeFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().closeFavorite, 30);
			elementClickable(pom.getInstanceSymptom().closeFavorite);
			click(pom.getInstanceSymptom().closeFavorite);
		}

		// $$$$$$procedure$$$$

		while (true) {
			if (pom.getInstanceProcedure().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProcedure().favoriteIcon, 40);
				elementClickable(pom.getInstanceProcedure().favoriteIcon);
				click(pom.getInstanceProcedure().favoriteIcon);
				break;
			} else if (!pom.getInstanceProcedure().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProcedure().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceProcedure().addNewFavorite, 30);
			elementClickable(pom.getInstanceProcedure().addNewFavorite);
			click(pom.getInstanceProcedure().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addNewFavorite, 30);
			elementClickable(pom.getInstanceProcedure().addNewFavorite);
			click(pom.getInstanceProcedure().addNewFavorite);
		}

		visbility(driver, pom.getInstanceProcedure().favoriteCodeType, 30);
		dropDown("index", pom.getInstanceProcedure().favoriteCodeType, "2");

		visbility(driver, pom.getInstanceProcedure().favoriteIcd, 30);
		sendkeys(pom.getInstanceProcedure().favoriteIcd, "test");

		while (true) {
			try {

				if (pom.getInstanceProcedure().favoriteIcdList.size() > 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (WebElement web : pom.getInstanceProcedure().favoriteIcdList) {

			if (web.getText().trim().equals("SNOMED : 134287002")) {

				visbility(driver, web, 60);
				elementClickable(web);
				click(web);

				break;

			}

		}

		visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 60);
		sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure favorite");

		elementClickable(pom.getInstanceProcedure().favoriteSave);
		click(pom.getInstanceProcedure().favoriteSave);

		for (WebElement web : pom.getInstanceProcedure().favoriteSaveMore) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);

				break;
			}

		}

		try {

			visbility(driver, pom.getInstanceProcedure().editFavorite, 30);
			elementClickable(pom.getInstanceProcedure().editFavorite);
			click(pom.getInstanceProcedure().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {

			visbility(driver, pom.getInstanceProcedure().editFavorite, 30);
			elementClickable(pom.getInstanceProcedure().editFavorite);
			click(pom.getInstanceProcedure().editFavorite);
		}

		try {
			visbility(driver, pom.getInstanceProcedure().removeFavoriteCode, 30);
			elementClickable(pom.getInstanceProcedure().removeFavoriteCode);
			click(pom.getInstanceProcedure().removeFavoriteCode);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().removeFavoriteCode, 30);
			elementClickable(pom.getInstanceProcedure().removeFavoriteCode);
			click(pom.getInstanceProcedure().removeFavoriteCode);

		}

		visbility(driver, pom.getInstanceProcedure().favoriteIcd, 30);
		sendkeys(pom.getInstanceProcedure().favoriteIcd, "test");

		while (true) {
			try {

				if (pom.getInstanceProcedure().favIcdList2.size() > 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (WebElement web : pom.getInstanceProcedure().favIcdList2) {

			if (web.getText().trim().equals("Platelet adhesiveness test (procedure)")) {

				visbility(driver, web, 60);
				elementClickable(web);
				click(web);

				break;

			}

		}

		visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 30);
		sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure kpop2 favorite");

		elementClickable(pom.getInstanceProcedure().favoriteSave);
		click(pom.getInstanceProcedure().favoriteSave);

		for (WebElement web : pom.getInstanceProcedure().favoriteSaveMore) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);
				break;
			}

		}

		try {
			visbility(driver, pom.getInstanceProcedure().addThisFavorite, 30);
			elementClickable(pom.getInstanceProcedure().addThisFavorite);
			click(pom.getInstanceProcedure().addThisFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addThisFavorite, 30);
			elementClickable(pom.getInstanceProcedure().addThisFavorite);
			click(pom.getInstanceProcedure().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstanceProcedure().closeFavorite, 30);
			elementClickable(pom.getInstanceProcedure().closeFavorite);
			click(pom.getInstanceProcedure().closeFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().closeFavorite, 30);
			elementClickable(pom.getInstanceProcedure().closeFavorite);
			click(pom.getInstanceProcedure().closeFavorite);
		}
		sleep(2000);
		//

		// $$$$$$$Goals

		while (true) {
			if (pom.getInstanceGoal().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceGoal().favoriteIcon, 30);
				elementClickable(pom.getInstanceGoal().favoriteIcon);
				click(pom.getInstanceGoal().favoriteIcon);
				break;
			} else if (!pom.getInstanceGoal().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceGoal().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceGoal().addNewFavorite, 30);
			elementClickable(pom.getInstanceGoal().addNewFavorite);
			click(pom.getInstanceGoal().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().addNewFavorite, 30);
			elementClickable(pom.getInstanceGoal().addNewFavorite);
			click(pom.getInstanceGoal().addNewFavorite);
		}

		try {
			visbility(driver, pom.getInstanceGoal().favoritePellContent, 30);
			elementClickable(pom.getInstanceGoal().favoritePellContent);
			click(pom.getInstanceGoal().favoritePellContent);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().favoritePellContent, 30);
			elementClickable(pom.getInstanceGoal().favoritePellContent);
			click(pom.getInstanceGoal().favoritePellContent);
		}
		visbility(driver, pom.getInstanceGoal().favoriteDiscription, 30);
		sendkeys(pom.getInstanceGoal().favoriteDiscription, "GOALS MODULE FAVORITE");

		elementClickable(pom.getInstanceGoal().favoritesave);
		click(pom.getInstanceGoal().favoritesave);

		try {

			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			elementClickable(pom.getInstanceGoal().addThisFavorite);
			click(pom.getInstanceGoal().addThisFavorite);

		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			elementClickable(pom.getInstanceGoal().addThisFavorite);
			click(pom.getInstanceGoal().addThisFavorite);
		}

		try {

			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			elementClickable(pom.getInstanceGoal().closeFavorite);
			click(pom.getInstanceGoal().closeFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			elementClickable(pom.getInstanceGoal().closeFavorite);
			click(pom.getInstanceGoal().closeFavorite);
		}

		// $$$$$status

		while (true) {
			if (pom.getInstanceStatus().favoriteicon.isDisplayed()) {
				visbility(driver, pom.getInstanceStatus().favoriteicon, 30);
				elementClickable(pom.getInstanceStatus().favoriteicon);
				click(pom.getInstanceStatus().favoriteicon);
				break;
			} else if (!pom.getInstanceStatus().favoriteicon.isDisplayed()) {
				actions("move to element", pom.getInstanceStatus().favoriteicon);
			}
		}

		try {

			visbility(driver, pom.getInstanceStatus().addNewFavorite, 30);
			elementClickable(pom.getInstanceStatus().addNewFavorite);
			click(pom.getInstanceStatus().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().addNewFavorite, 30);
			elementClickable(pom.getInstanceStatus().addNewFavorite);
			click(pom.getInstanceStatus().addNewFavorite);
		}

		visbility(driver, pom.getInstanceStatus().favoritesStatusType, 30);
		dropDown("index", pom.getInstanceStatus().favoritesStatusType, "2");

		visbility(driver, pom.getInstanceStatus().favoriteIcd, 30);

		sendkeys(pom.getInstanceStatus().favoriteIcd, "test");

		while (true) {
			try {

				if (pom.getInstanceStatus().favoriteicdList.size() > 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (WebElement we : pom.getInstanceStatus().favoriteicdList) {
			if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality (finding)")) {
				visbility(driver, we, 60);
				elementClickable(we);
				click(we);

				break;
			}

		}

		elementClickable(pom.getInstanceStatus().favoriteSave);
		click(pom.getInstanceStatus().favoriteSave);

		try {

			visbility(driver, pom.getInstanceStatus().editFavorite, 30);
			elementClickable(pom.getInstanceStatus().editFavorite);
			click(pom.getInstanceStatus().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceStatus().editFavorite, 30);
			elementClickable(pom.getInstanceStatus().editFavorite);
			click(pom.getInstanceStatus().editFavorite);

		}

		try {
			visbility(driver, pom.getInstanceStatus().removeFavoriteCode, 60);
			elementClickable(pom.getInstanceStatus().removeFavoriteCode);
			click(pom.getInstanceStatus().removeFavoriteCode);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().removeFavoriteCode, 60);
			elementClickable(pom.getInstanceStatus().removeFavoriteCode);
			click(pom.getInstanceStatus().removeFavoriteCode);
		}
		visbility(driver, pom.getInstanceStatus().favoriteIcd, 30);

		sendkeys(pom.getInstanceStatus().favoriteIcd, "test");

		while (true) {
			try {

				if (pom.getInstanceStatus().favoriteicdList.size() > 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (WebElement we : pom.getInstanceStatus().favoriteicdList) {
			if (we.getText().trim().equals("134376008: Hearing test right abnormality (finding)")) {
				visbility(driver, we, 60);
				elementClickable(we);
				click(we);

				break;
			}

		}
		elementClickable(pom.getInstanceStatus().favoriteSave);
		click(pom.getInstanceStatus().favoriteSave);

		try {

			visbility(driver, pom.getInstanceStatus().addThisFavorite, 30);
			elementClickable(pom.getInstanceStatus().addThisFavorite);
			click(pom.getInstanceStatus().addThisFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().addThisFavorite, 30);
			elementClickable(pom.getInstanceStatus().addThisFavorite);
			click(pom.getInstanceStatus().addThisFavorite);
		}

		try {

			visbility(driver, pom.getInstanceStatus().closeFavorite, 30);
			elementClickable(pom.getInstanceStatus().closeFavorite);
			click(pom.getInstanceStatus().closeFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().closeFavorite, 30);
			elementClickable(pom.getInstanceStatus().closeFavorite);
			click(pom.getInstanceStatus().closeFavorite);
		}

		// $$$$$$problems$$$$$$$

		Problems.favoriteProblemAddIcon();

		sleep(2000);

		//
		// $$$$$medication

		/*
		 * for (int i = 1; i <= 5; i++) { try { WebElement medfav = driver
		 * .findElement(By.
		 * xpath("(//div[contains(@title,'Show my favorite Medications list ')])[1]"));
		 * actions("move to element", medfav); visbility(driver, medfav, 60);
		 * javascriptclick(medfav); break; } catch (Exception e) { // TODO: handle
		 * exception }
		 * 
		 * } sleep(2000); WebElement medaddbtn = driver.findElement( By.xpath(
		 * "//div[@id='MedicationsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"
		 * )); visbility(driver, medaddbtn, 60); javascriptclick(medaddbtn); WebElement
		 * meddisbox = driver .findElement(By.xpath(
		 * "//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[2]/input"));
		 * visbility(driver, meddisbox, 60); sendkeys(meddisbox, "test"); sleep(2000);
		 * List<WebElement> $med$drop$down$ = null; boolean $msd$ = false;
		 * 
		 * while (true) { try { $med$drop$down$ = driver.findElements( By.xpath(
		 * "//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em"
		 * )); if ($med$drop$down$.size() > 8) { break;
		 * 
		 * }
		 * 
		 * } catch (Exception e) { // TODO: handle exception }
		 * 
		 * }
		 * 
		 * for (WebElement we : $med$drop$down$) { //System.out.println(we.getText());
		 * if (we.getText().trim().equals("RXNORM == 1009480")) { //
		 * System.out.println("med cond met"); visbility(driver, we, 60);
		 * javascriptclick(we); break;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * if ($msd$ == true) {
		 * 
		 * WebElement savemed = driver .findElement(By.xpath(
		 * "//div[@id='addfav-div']/div/div/div[4]//following::button[3]"));
		 * visbility(driver, savemed, 60); javascriptclick(savemed); } sleep(2000); //
		 * edit acenario... for (int i = 1; i <= 5; i++) { try { WebElement $editmed$ =
		 * driver.findElement(By.xpath("(//span[text()='RXNORM : 1009480: '])[1]"));
		 * visbility(driver, $editmed$, 60); javascriptclick($editmed$); break; } catch
		 * (Exception e) { // TODO: handle exception } }
		 * 
		 * WebElement $crossicon$ =
		 * driver.findElement(By.xpath("//div[@title='Remove this Medication']"));
		 * visbility(driver, $crossicon$, 60); javascriptclick($crossicon$);
		 * 
		 * for (int i = 1; i <= 5; i++) { try { WebElement $meddisbox$ = driver
		 * .findElement(By.xpath(
		 * "//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[2]/input"));
		 * 
		 * sendkeys($meddisbox$, "test"); sleep(2000); break; } catch (Exception e) { //
		 * TODO: handle exception } } List<WebElement> $med$drop$downs$;
		 * 
		 * while (true) { try { $med$drop$downs$ = driver.findElements( By.xpath(
		 * "//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em"
		 * )); if ($med$drop$downs$.size() > 8) {
		 * System.out.println($med$drop$down$.size()); break; } } catch (Exception e) {
		 * // TODO: handle exception } } boolean medcond = false; for (WebElement we :
		 * $med$drop$downs$) { System.out.println(we.getText()); if
		 * (we.getText().trim().equals("RXNORM == 1010630")) { medcond = true;
		 * visbility(driver, we, 60); javascriptclick(we); break;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * if (medcond == true) { WebElement $savemeds$ = driver .findElement(By.xpath(
		 * "//div[@id='addfav-div']/div/div/div[4]//following::button[3]"));
		 * visbility(driver, $savemeds$, 60); javascriptclick($savemeds$);
		 * 
		 * for (int i = 1; i <= 5; i++) { try {
		 * 
		 * WebElement addmedtolist = driver.findElement( By.
		 * xpath("(//span[contains(@title,'Add this medication to prescription')])[1]"))
		 * ; visbility(driver, addmedtolist, 60); javascriptclick(addmedtolist); break;
		 * } catch (Exception e) { // TODO: handle exception } } sleep(2000); for (int i
		 * = 1; i <= 5; i++) { try { WebElement cancel = driver.findElement(
		 * By.xpath("//div[@id='MedicationsFavKpop2']/div[1]/div[1]//following::span[1]"
		 * )); visbility(driver, cancel, 60); javascriptclick(cancel); break; } catch
		 * (Exception e) { // TODO: handle exception } }
		 * 
		 * }
		 */
		sleep(2000);

		// $$$$$advance directives

		while (true) {

			if (pom.getInstanceAdvanceDirective().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceAdvanceDirective().favoriteIcon, 30);
				elementClickable(pom.getInstanceAdvanceDirective().favoriteIcon);
				click(pom.getInstanceAdvanceDirective().favoriteIcon);
				break;
			} else if (!pom.getInstanceAdvanceDirective().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAdvanceDirective().favoriteIcon);
			}

		}
		try {
			visbility(driver, pom.getInstanceAdvanceDirective().addNewFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().addNewFavorite);
			click(pom.getInstanceAdvanceDirective().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().addNewFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().addNewFavorite);
			click(pom.getInstanceAdvanceDirective().addNewFavorite);

		}

		visbility(driver, pom.getInstanceAdvanceDirective().favoriteStatusType, 30);
		dropDown("text", pom.getInstanceAdvanceDirective().favoriteStatusType, "Assessment");
		visbility(driver, pom.getInstanceAdvanceDirective().favoriteDiscription, 40);
		sendkeys(pom.getInstanceAdvanceDirective().favoriteDiscription, "Advance directives");
		elementClickable(pom.getInstanceAdvanceDirective().favoriteSave);
		click(pom.getInstanceAdvanceDirective().favoriteSave);

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().editFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().editFavorite);

			click(pom.getInstanceAdvanceDirective().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceAdvanceDirective().editFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().editFavorite);

			click(pom.getInstanceAdvanceDirective().editFavorite);
		}

		visbility(driver, pom.getInstanceAdvanceDirective().favoriteDiscription, 40);
		clear(pom.getInstanceAdvanceDirective().favoriteDiscription);
		sendkeys(pom.getInstanceAdvanceDirective().favoriteDiscription, "Advance directives");
		elementClickable(pom.getInstanceAdvanceDirective().favoriteSave);
		click(pom.getInstanceAdvanceDirective().favoriteSave);

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().addThisFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().addThisFavorite);
			click(pom.getInstanceAdvanceDirective().addThisFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().addThisFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().addThisFavorite);
			click(pom.getInstanceAdvanceDirective().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().closeFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().closeFavorite);
			click(pom.getInstanceAdvanceDirective().closeFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().closeFavorite, 30);
			elementClickable(pom.getInstanceAdvanceDirective().closeFavorite);
			click(pom.getInstanceAdvanceDirective().closeFavorite);
		}

		// $$$$notes

		while (true) {
			if (pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceNotes().favoriteIcon, 40);
				elementClickable(pom.getInstanceNotes().favoriteIcon);
				click(pom.getInstanceNotes().favoriteIcon);
				break;
			} else if (!pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceNotes().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			elementClickable(pom.getInstanceNotes().addNewFavorite);
			click(pom.getInstanceNotes().addNewFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			elementClickable(pom.getInstanceNotes().addNewFavorite);
			click(pom.getInstanceNotes().addNewFavorite);
		}

		visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
		sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes module");
		elementClickable(pom.getInstanceNotes().favoriteSave);
		click(pom.getInstanceNotes().favoriteSave);

		try {

			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			elementClickable(pom.getInstanceNotes().editFavorite);
			click(pom.getInstanceNotes().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			elementClickable(pom.getInstanceNotes().editFavorite);
			click(pom.getInstanceNotes().editFavorite);
		}

		visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
		clear(pom.getInstanceNotes().favoriteDiscription);
		sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");

		elementClickable(pom.getInstanceNotes().favoriteSave);
		click(pom.getInstanceNotes().favoriteSave);

		try {

			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			elementClickable(pom.getInstanceNotes().addThisFavorite);
			click(pom.getInstanceNotes().addThisFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			elementClickable(pom.getInstanceNotes().addThisFavorite);
			click(pom.getInstanceNotes().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			elementClickable(pom.getInstanceNotes().closeFavorite);
			click(pom.getInstanceNotes().closeFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			elementClickable(pom.getInstanceNotes().closeFavorite);
			click(pom.getInstanceNotes().closeFavorite);
		}

		// $$$physical exam
		while (true) {

			if (pom.getInstancePhysicalExam().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstancePhysicalExam().favoriteIcon, 40);
				elementClickable(pom.getInstancePhysicalExam().favoriteIcon);
				click(pom.getInstancePhysicalExam().favoriteIcon);
				break;
			} else if (!pom.getInstancePhysicalExam().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstancePhysicalExam().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstancePhysicalExam().addNewFavorite, 40);
			elementClickable(pom.getInstancePhysicalExam().addNewFavorite);
			click(pom.getInstancePhysicalExam().addNewFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().addNewFavorite, 40);
			elementClickable(pom.getInstancePhysicalExam().addNewFavorite);
			click(pom.getInstancePhysicalExam().addNewFavorite);
		}

		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");

		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");
		visbility(driver, pom.getInstancePhysicalExam().favoriteNotes, 30);
		sendkeys(pom.getInstancePhysicalExam().favoriteNotes, "Physical Examination modules");

		elementClickable(pom.getInstancePhysicalExam().favoriteSave);
		click(pom.getInstancePhysicalExam().favoriteSave);

		try {
			visbility(driver, pom.getInstancePhysicalExam().editFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().editFavorite);
			click(pom.getInstancePhysicalExam().editFavorite);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstancePhysicalExam().editFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().editFavorite);
			click(pom.getInstancePhysicalExam().editFavorite);
		}

		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		clear(pom.getInstancePhysicalExam().organItem);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");

		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		clear(pom.getInstancePhysicalExam().finding);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");

		elementClickable(pom.getInstancePhysicalExam().favoriteSave);
		click(pom.getInstancePhysicalExam().favoriteSave);

		try {
			visbility(driver, pom.getInstancePhysicalExam().addThisFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().addThisFavorite);
			click(pom.getInstancePhysicalExam().addThisFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().addThisFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().addThisFavorite);
			click(pom.getInstancePhysicalExam().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().closeFavorite);
			click(pom.getInstancePhysicalExam().closeFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().closeFavorite);
			click(pom.getInstancePhysicalExam().closeFavorite);
		}
		sleep(2000);

		j.executeScript("window.scrollBy(0,-750)", "");
		try {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 30);
			elementClickable(pom.getInstanceHealthRec().ehrEllipses);
			click(pom.getInstanceHealthRec().ehrEllipses);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 40);
			elementClickable(pom.getInstanceHealthRec().ehrEllipses);
			click(pom.getInstanceHealthRec().ehrEllipses);
		}

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Show Timestamp")) {
				visbility(wd, web, 30);
				elementClickable(web);
				web.click();
				break;
			}

		}
		implicitWait(30, TimeUnit.SECONDS);
		sleep(2500);
		// follow up creation...
		j.executeScript("window.scroll(0,0)");
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement createfollowup = driver.findElement(By.xpath("(//button[@id='followUpAdd'])[1]/div[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(createfollowup));
				actions("click", createfollowup);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(4000);
		implicitWait(30, TimeUnit.SECONDS);
		WebElement crt = driver
				.findElement(By.xpath("//div[@id='followupEhr']/div[2]/div[3]/div[1]//following::div[2]/input"));
		actions("click", crt);
		sleep(2000);
		WebElement folowypyr = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		dropDown("text", folowypyr, "2023");
		WebElement folowupmnth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		dropDown("text", folowupmnth, "Dec");
		driver.findElement(By.xpath("(//a[text()='31'])")).click();
		WebElement fixappo = driver.findElement(By.xpath("(//button[@id='fixAppointment'])[1]"));

		sleep(3000);
		javascriptclick(fixappo);

		List<WebElement> tot = driver.findElements(By.xpath("(//div[@id='date-data'])[1]"));
		int totaly = tot.size();
		// System.out.println("found you>>>" + totaly);
		implicitWait(30, TimeUnit.SECONDS);

		boolean b = false;
		for (int i = 1; i <= totaly; i++) {
			sleep(3000);
			List<WebElement> rqq = driver
					.findElements(By.xpath("(//div[@id='formAppointment'])[2]/div/div[2]/div[2]/div[2]/div"));

			// System.out.println("total number of displayed time in the list:" +
			// rqq.size());
			for (int jj = 1; jj <= rqq.size(); jj++) {

				WebElement checkcn = driver
						.findElement(By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + jj + "]/div/div[1]"));
				// System.out.println(checkcn.getText());

				WebElement sm = driver
						.findElement(By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + jj + "]/div/div[2]/span[3]"));
				// System.out.println(sm.getText().isEmpty());

				if (checkcn.isDisplayed() == true && sm.getText().isEmpty() == true) {
					b = true;
					checkcn.click();
					break;

				}

			}
			if (b == true) {
				WebElement $foloupBtn = driver
						.findElement(By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]"));
				visbility(driver, $foloupBtn, 40);
				click($foloupBtn);
				List<WebElement> $followupDropButton = driver.findElements(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::ul[1]/li/a"));
				for (WebElement webElement : $followupDropButton) {

					if (webElement.getText().equals("Emergency")) {

						visbility(driver, webElement, 60);
						click(webElement);
					}

				}

				driver.findElement(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::textarea[2]")).clear();
				driver.findElement(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::textarea[2]"))
						.sendKeys("yes follow");

				driver.findElement(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::div[6]/div/div"))
						.click();
				sleep(3000);
				WebElement delfolup = driver
						.findElement(By.xpath("(//button[@id='fixAppointment'])[1]//following::div[1]/div[1]/span[2]"));
				actions("move to element", delfolup);
				actions("click", delfolup);
				WebElement bckfl = driver.findElement(By.xpath("//div[@id='followupEhr']/div[1]/div/span[1]"));
				javascriptclick(bckfl);
				break;
			}
		}

		sleep(2000);
		WebElement delehrf = driver.findElement(By.xpath("(//button[contains(@title,'Delete Health Record')])[1]"));
		javascriptclick(delehrf);
		sleep(2000);
		WebElement zr = driver
				.findElement(By.xpath("//span[text()='Delete Health Record']//following::div[4]/button[2]"));
		javascriptclick(zr);
		sleep(4000);
	}

	@Test(priority = 3, groups = "calendar")

	public void calendar() throws Exception {

		cal.caledarModule();

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);

	}

	@Test(priority = 4, groups = "billing")
	public void BillingModule() throws InterruptedException {

		visbility(driver, pom.getInstanceBilling().clickBill, 60);
		ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().clickBill));
		click(pom.getInstanceBilling().clickBill);

		driver.navigate().refresh();
		implicitWait(50, TimeUnit.SECONDS);
		sleep(3000);
		while (true) {
			try {
				visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
				click(pom.getInstanceBilling().clickCreateNewBill);
				break;
			} catch (Exception e) {

			}
		}

		try {
			visbility(driver, pom.getInstanceBilling().addItem, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().addItem));
			click(pom.getInstanceBilling().addItem);
			visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceBilling().addItem, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().addItem));
			click(pom.getInstanceBilling().addItem);
			visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		}
		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo"); //
		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		sendkeys(pom.getInstanceBilling().addPrice, "10"); //
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		clear(pom.getInstanceBilling().addQuantity); //
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		sendkeys(pom.getInstanceBilling().addQuantity, "2");

		visbility(driver, pom.getInstanceBilling().saveItem, 60);
		ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().saveItem));
		click(pom.getInstanceBilling().saveItem);
		sleep(3000);
		/*
		 * while (true) { try {
		 */

		try {
			System.out.println("ENTER TRY BLOCK BILL");
			WebElement billingFavoritesideview = driver.findElement(By.xpath("//div[@id='assign-side']/div[1]/div"));
			visbility(driver, billingFavoritesideview, 40);
			ww.until(ExpectedConditions.elementToBeClickable(billingFavoritesideview));
			click(billingFavoritesideview);
		} catch (StaleElementReferenceException e) {
			WebElement billingFavoritesideview = driver.findElement(By.xpath("//div[@id='assign-side']/div[1]/div"));
			visbility(driver, billingFavoritesideview, 50);
			System.out.println("visbile billing side view");
			ww.until(ExpectedConditions.elementToBeClickable(billingFavoritesideview));
			click(billingFavoritesideview);
			System.out.println("side view favorite clicked");
		}

		/*
		 * if (r.isDisplayed()) { visbility(driver, r, 60); click(r);
		 */
		// break;
		// }

		/*
		 * } catch (Exception e) {
		 * 
		 * } }
		 */

		/*
		 * while (true) { try {
		 */

		try {
			WebElement addiconfavorite = driver
					.findElement(By.xpath("//div[@id='assign-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
			visbility(driver, addiconfavorite, 40);
			ww.until(ExpectedConditions.elementToBeClickable(addiconfavorite));
			click(addiconfavorite);
		} catch (StaleElementReferenceException e) {
			WebElement addiconfavorite = driver
					.findElement(By.xpath("//div[@id='assign-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
			visbility(driver, addiconfavorite, 60);
			ww.until(ExpectedConditions.elementToBeClickable(addiconfavorite));
			click(addiconfavorite);
		}

		/*
		 * break; } catch (Exception e) {
		 * 
		 * } }
		 * 
		 */ while (true) {
			try {
				WebElement favdes = driver.findElement(
						By.xpath("//div[@id='assign-side']/div[3]/div/div/div[2]/div[3]/div[2]/div/input"));
				visbility(driver, favdes, 60);
				favdes.sendKeys("Kaaspro");
				break;
			} catch (Exception e) {

			}
		}
		WebElement ree = driver
				.findElement(By.xpath("//div[@id='assign-side']/div[3]/div/div/div[2]/div[4]/div[2]/input"));
		visbility(driver, ree, 60);
		ree.sendKeys("3");
		WebElement savefav = driver.findElement(By.xpath(
				"//div[@id='assign-side']/div[3]/div/div/div[2]/div[4]/div[2]//following::div[1]/div/div[4]//following::div[1]/div/button[2]"));
		visbility(driver, savefav, 60);
		javascriptclick(savefav);
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		sleep(2500);
		WebElement until;
		while (true) {
			try {
				until = driver.findElement(By.xpath(
						"(//span[text()='Kaaspro']//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1])[1]"));
				break;
			} catch (Exception e) {

			}
		}

		actions("click", until);
		sleep(2000);
		while (true) {
			try {
				WebElement edi = driver.findElement(
						By.xpath("(//span[text()='Kaaspro']//parent::div//parent::div[1]//parent::div[1]/div[2])[1]"));
				visbility(driver, edi, 60);
				actions("click", edi);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		while (true) {
			try {
				WebElement delfav = driver
						.findElement(By.xpath("//div[@id='assign-side']/div[3]/div/div/div[1]/div[2]/span[2]"));

				visbility(driver, delfav, 60);
				actions("click", delfav);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2500);
		while (true) {
			try {
				WebElement itser = driver.findElement(By.xpath("//div[@id='item-code-side']/div[1]/div"));
				visbility(driver, itser, 60);

				actions("click", itser);
				break;
			} catch (Exception e) {

			}
		}

		while (true) {
			try {
				WebElement additser = driver.findElement(
						By.xpath("//div[@id='item-code-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"));
				visbility(driver, additser, 60);

				javascriptclick(additser);
				break;
			} catch (Exception e) {

			}
		}
		while (true) {
			try {
				WebElement wrr = driver
						.findElement(By.xpath("//div[@id='item-code-side']/div[3]/div/div/div[2]/div[3]/input"));
				visbility(driver, wrr, 60);
				sendkeys(wrr, "product001");// .sendKeys("product001");
				break;
			} catch (Exception e) {

			}
		}
		WebElement err = driver
				.findElement(By.xpath("//div[@id='item-code-side']/div[3]/div/div/div[2]/div[4]/textarea"));
		visbility(driver, err, 60);
		sendkeys(err, "sr");// .sendKeys("sr");
		WebElement weq = driver.findElement(By.xpath("//div[@id='item-code-side']/div[3]/div/div/div[2]/div[5]/input"));
		visbility(driver, weq, 60);
		sendkeys(weq, "5");// .sendKeys("5");
		while (true) {
			try {
				WebElement itersav = driver.findElement(
						By.xpath("//div[@id='item-code-side']/div[3]/div/div/div[2]/div[7]/div/button[2]"));
				visbility(driver, itersav, 60);
				javascriptclick(itersav);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ft = driver.findElement(
						By.xpath("//div[text()='PRODUCT001']//parent::div[1]//parent::div[1]/div[1]/span"));
				visbility(driver, ft, 60);

				javascriptclick(ft);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement edititser = driver.findElement(By.xpath("//div[text()='PRODUCT001']"));
				visbility(driver, edititser, 60);

				actions("click", edititser);
				break;
			} catch (Exception e) {

			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement delitser = driver
						.findElement(By.xpath("//div[@id='item-code-side']/div[3]/div/div/div[1]/div[2]/span[2]"));
				visbility(driver, delitser, 60);

				javascriptclick(delitser);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);

		// service/charge tax..
		while (true) {
			try {

				WebElement sct = driver.findElement(By.xpath("//div[@id='tax-side']/div[1]/div/span[3]"));
				visbility(driver, sct, 60);

				actions("click", sct);
				break;
			} catch (Exception e) {

			}
		}

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement sctadd = driver
						.findElement(By.xpath("//div[@id='tax-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"));
				visbility(driver, sctadd, 60);

				javascriptclick(sctadd);
				break;
			} catch (Exception e) {

			}
		}
		WebElement tre = driver.findElement(By.xpath("//div[@id='tax-side']/div[3]/div/div/div[2]/div[3]/input"));
		visbility(driver, tre, 60);
		sendkeys(tre, "service charge<>"); // .sendKeys("service charge<>");
		WebElement tp1 = driver.findElement(By.xpath("//div[@id='tax-side']/div[3]/div/div/div[2]/div[4]/input"));
		visbility(driver, tp1, 60);
		sendkeys(tp1, "5");// .sendKeys("5");
		WebElement sctsav = driver
				.findElement(By.xpath("//div[@id='tax-side']/div[3]/div/div/div[2]/div[6]/div/button[2]"));
		visbility(driver, sctsav, 60);
		for (int i = 1; i <= 5; i++) {
			try {

				javascriptclick(sctsav);
				WebElement adsct = driver.findElement(
						By.xpath("//div[text()='service charge<>']//parent::div[1]//parent::div[1]/div/span"));
				visbility(driver, adsct, 60);

				actions("click", adsct);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {

				WebElement edsct = driver.findElement(By.xpath("//div[text()='service charge<>']"));
				visbility(driver, edsct, 60);

				actions("click", edsct);
				break;
			} catch (Exception e) {

			}
		}
		for (int i = 1; i <= 5; i++) {
			try {

				WebElement delsct = driver
						.findElement(By.xpath("//div[@id='tax-side']/div[3]/div/div/div[1]/div[2]/span[2]"));
				visbility(driver, delsct, 60);
				javascriptclick(delsct);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		// discount..
		for (int i = 1; i <= 5; i++) {
			try {

				WebElement dis = driver.findElement(By.xpath("//div[@id='discount-side']/div[1]/div"));
				visbility(driver, dis, 60);

				actions("click", dis);
				break;
			} catch (Exception e) {

			}
		}

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement addds = driver.findElement(
						By.xpath("//div[@id='discount-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"));
				visbility(driver, addds, 60);

				javascriptclick(addds);
				break;
			} catch (Exception e) {

			}
		}
		WebElement trp3 = driver.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[3]/input"));
		visbility(driver, trp3, 60);
		sendkeys(trp3, "Discnt");// .sendKeys("Discnt");
		WebElement cldrpdis = driver
				.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[4]/div/button"));
		visbility(driver, cldrpdis, 60);
		javascriptclick(cldrpdis);
		List<WebElement> dispercen = null;
		for (int i = 1; i <= 5; i++) {
			try {

				dispercen = driver
						.findElements(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[4]/div/ul/li/a"));
				break;
			} catch (Exception e) {

			}
		}
		for (WebElement we : dispercen) {
			if (we.getText().trim().equals("Percentage Discount")) {
				visbility(driver, we, 60);
				we.click();
				break;
			}

		}
		WebElement trp6 = driver
				.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[5]/div/input"));
		visbility(driver, trp6, 60);
		sendkeys(trp6, "5");// .sendKeys("5");
		WebElement dissav = driver
				.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[8]/div/button[2]"));
		visbility(driver, dissav, 60);
		javascriptclick(dissav);
		WebElement adddiscc = driver
				.findElement(By.xpath("//div[text()='Discnt']//parent::div[1]//parent::div/div/span"));
		visbility(driver, adddiscc, 60);

		actions("click", adddiscc);
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editdis = driver.findElement(By.xpath("//div[text()='Discnt']"));
				visbility(driver, editdis, 60);

				actions("click", editdis);
				break;
			} catch (Exception e) {

			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement deldis = driver
						.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[1]/div[2]/span[2]"));
				visbility(driver, deldis, 60);
				javascriptclick(deldis);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ee = driver.findElement(By.xpath("(//button[@id='add-payment-btn'])[1]"));
				visbility(driver, ee, 60);
				javascriptclick(ee);
				break;
			} catch (Exception e) {

			}
		}
		// driver.findElement(By.xpath("(//button[@id='add-payment-btn'])[1]")).click();
		WebElement trp8 = driver.findElement(By.xpath("(//span[@id='paymentMethodTypeSelectValue'])[2]"));
		visbility(driver, trp8, 60);
		click(trp8);
		// .click();
		sleep(2000);
		List<WebElement> choosepy = driver
				.findElements(By.xpath("(//span[@id='paymentMethodTypeSelectValue'])[2]//following::ul[1]/li"));
		for (WebElement w : choosepy) {
			if (w.getText().trim().equals("Cash Payment")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		WebElement dsp1 = driver
				.findElement(By.xpath("(//button[@id='paymentMethodTypeId'])[2]//following::textarea[1]"));
		visbility(driver, dsp1, 60);
		actions("click", dsp1);
		sleep(2000);
		dsp1.sendKeys("cash pay+++++++++");

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement tet = driver.findElement(By.xpath("(//button[@title='Make Payment'])[3]"));
				visbility(driver, tet, 60);
				j.executeScript("arguments[0].click();", tet);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fnls = driver.findElement(By.xpath("//button[@id='finalize-bill']"));
				visbility(driver, fnls, 60);

				javascriptclick(fnls);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		WebElement dz = driver.findElement(By.xpath("(//button[@title='Finalize'])[1]"));
		visbility(driver, dz, 60);

		javascriptclick(dz);
		sleep(2000);
		WebElement trp7 = driver.findElement(By.xpath("//button[@id='finalize-bill']//following::button[2]"));// .click();
		visbility(driver, trp7, 60);
		javascriptclick(trp7);
		sleep(2000);
		WebElement delbil = driver.findElement(
				By.xpath("//center[text()='Do you like to delete Invoice?']//following::div[1]/button[2]"));
		visbility(driver, delbil, 60);
		javascriptclick(delbil);
		sleep(2000);
		// driver.navigate().to("https://localhost:8443/health/#bill_report");
		while (true) {
			try {
				click(pom.getInstanceBilling().clickBill);
				break;
			} catch (Exception e) {

			}
		}
		driver.navigate().refresh();
		WebElement trp9;
		while (true) {
			try {

				trp9 = driver.findElement(By.xpath(
						"//div[@id='bill_report']/div[1]/div[2]//following::div[1]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[1]//following::div[1]/input"));
				visbility(driver, trp9, 60);
				break;
			} catch (Exception e) {

			}
		}
		sendkeys(trp9, kpid);
		// .sendKeys(kpid);
		sleep(2000);
		List<WebElement> billdrp;
		while (true) {
			try {
				billdrp = driver.findElements(By.xpath(
						"//div[@id='dmain']/div[4]/div[2]//following::div[2]//following::ul[3]/li/a/table/tbody/tr/td[2]"));
				break;
			} catch (Exception e) {

			}
		}
		for (WebElement we : billdrp) {
			if (we.getText().trim().equals(kpid)) {
				visbility(driver, we, 60);
				we.click();
				break;
			}

		}
		visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
		click(pom.getInstanceBilling().clickCreateNewBill);

		sleep(2000);
		visbility(driver, pom.getInstanceBilling().addItem, 60);
		click(pom.getInstanceBilling().addItem);
		sleep(2000);
		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo"); //
		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		sendkeys(pom.getInstanceBilling().addPrice, "10"); //
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		clear(pom.getInstanceBilling().addQuantity); //
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		sendkeys(pom.getInstanceBilling().addQuantity, "2");
		sleep(3000);
		visbility(driver, pom.getInstanceBilling().saveItem, 60);
		click(pom.getInstanceBilling().saveItem);
		sleep(2000);
		String inc;
		while (true) {
			try {
				WebElement getinc = driver.findElement(By.xpath("//span[@id='receiptId']"));
				visbility(driver, getinc, 60);
				inc = getinc.getText();
				System.out.println(inc);
				break;
			} catch (Exception e) {

			}
		}

		sleep(3000);

		driver.navigate().back();

		while (true) {
			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#bill_report")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#bill_report")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#bill_report")) {
				break;
			}
		}

		while (true) {
			try {
				WebElement rqs = driver.findElement(By.xpath("//div[text()='" + inc + "']"));
				visbility(driver, rqs, 60);

				actions("click", rqs);
				break;
			} catch (Exception e) {

			}
		}
		sleep(1000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editit = driver.findElement(By.xpath("//div[text()='dolo']"));
				visbility(driver, editit, 60);
				javascriptclick(editit);
				break;
			} catch (Exception e) {

			}
		}
		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		clear(pom.getInstanceBilling().enterTheItem);

		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		sendkeys(pom.getInstanceBilling().enterTheItem, "Paracetamal");

		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		clear(pom.getInstanceBilling().addPrice);
		sendkeys(pom.getInstanceBilling().addPrice, "90");

		WebElement saveit = driver.findElement(
				By.xpath("//div[text()='dolo']//following::div[6]/div[2]//following::div[1]/div[2]/div[1]/button[3]"));
		visbility(driver, saveit, 60);
		javascriptclick(saveit);

	}

	@Test(priority = 5, groups = "teledoctor")
	public void TeleDoctor() throws InterruptedException {

		try {
			visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceTeleDoctor().clickTeleDoctor));
			click(pom.getInstanceTeleDoctor().clickTeleDoctor);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceTeleDoctor().clickTeleDoctor));
			click(pom.getInstanceTeleDoctor().clickTeleDoctor);

		}
		driver.navigate().refresh();

		implicitWait(60, TimeUnit.SECONDS);

		try {
			WebElement np1 = driver.findElement(By.xpath("//button[@title='Create new Patinet']"));
			visbility(driver, np1, 60);
			ww.until(ExpectedConditions.elementToBeClickable(np1));
			j.executeScript("arguments[0].click();", np1);

		} catch (ElementClickInterceptedException e) {

			WebElement np1 = driver.findElement(By.xpath("//button[@title='Create new Patinet']"));
			visbility(driver, np1, 60);
			ww.until(ExpectedConditions.elementToBeClickable(np1));
			j.executeScript("arguments[0].click();", np1);
		}
		WebElement np2 = driver.findElement(By.id("firstname"));
		visbility(driver, np2, 60);
		sendkeys(np2, "Ayyyyyi");// .sendKeys("Abigazi");
		WebElement np3 = driver.findElement(By.id("lastname"));
		visbility(driver, np3, 60);
		sendkeys(np3, "ghghgjg");// .sendKeys("Ak");
		WebElement gn1 = driver.findElement(By.xpath("(//button[@id='gender_dropdown'])[1]"));
		visbility(driver, gn1, 60);
		javascriptclick(gn1);

		List<WebElement> jj = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));
		for (WebElement w : jj) {
			if (w.getText().trim().equals("Male")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));

		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		click(pom.getInstanceHomeModule().selectFlagPhoneNumField);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				click(flag);
				break;
			}
		}

		// String numericRand = RandomStringUtils.randomNumeric(5);
		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));

		WebElement cp1 = driver.findElement(By.xpath("//div[@id='createPatient']"));
		visbility(driver, cp1, 60);
		ww.until(ExpectedConditions.elementToBeClickable(cp1));
		click(cp1);

		implicitWait(30, TimeUnit.SECONDS);

		try {
			ScriptExecutor(pom.getInstanceNewPatient().deletePatient);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceNewPatient().deletePatient));
			click(pom.getInstanceNewPatient().deletePatient);
		} catch (ElementClickInterceptedException e) {
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceNewPatient().deletePatient));
			click(pom.getInstanceNewPatient().deletePatient);
		}

		while (true) {
			try {

				WebElement $delpat$ = driver.findElement(By.xpath("//button[text()='Delete']"));
				javascriptclick($delpat$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		implicitWait(60, TimeUnit.SECONDS);

		while (true) {
			WebElement $addne;
			try {

				$addne = driver.findElement(By.xpath("(//BUTTON[@title='Add new Patient'])[3]"));

				if ($addne.isDisplayed()) {
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		if (ur.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#call_history");
		} else if (ur.equals("")) {

		} else if (ur.equals("")) {

		}

		while (true) {
			try {
				visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
				javascriptclick(pom.getInstanceTeleDoctor().clickTeleDoctor);
				break;
			} catch (Exception e) {

			}
		}
		// System.out.println("done");
		while (true) {
			try {
				visbility(driver, pom.getInstanceTeleDoctor().searchPatient, 60);
				sendkeys(pom.getInstanceTeleDoctor().searchPatient, kpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		while (true) {
			try {
				WebElement pstl = driver.findElement(By.xpath("//td[@id='nameh']//following::td[1]"));
				visbility(driver, pstl, 60);
				actions("click", pstl);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// ScriptExecutor(pom.getInstanceCalendar().saveAppointment);
		while (true) {
			try {
				WebElement clickpatie = driver.findElement(By.xpath("(//div[@title='Click to view'])[4]"));

				visbility(driver, clickpatie, 60);
				actions("click", clickpatie);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(3000);

	}

	@Test(priority = 6, groups = "message")
	public void Message() throws InterruptedException {

		try {
			visbility(driver, pom.getInstanceMessage().clickMessage, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceMessage().clickMessage));
			click(pom.getInstanceMessage().clickMessage);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceMessage().clickMessage, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceMessage().clickMessage));
			click(pom.getInstanceMessage().clickMessage);
		}

		try {
			visbility(driver, pom.getInstanceMessage().clickComposemMessage, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceMessage().clickComposemMessage));
			click(pom.getInstanceMessage().clickComposemMessage);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceMessage().clickComposemMessage, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceMessage().clickComposemMessage));
			click(pom.getInstanceMessage().clickComposemMessage);
		}
		for (int i = 1; i <= 5; i++) {
			try {
				sendkeys(pom.getInstanceMessage().search, kpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000); //

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
				if (msg.isDisplayed()) {
					click(msg);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		visbility(driver, pom.getInstanceMessage().enterSubject, 60);
		sendkeys(pom.getInstanceMessage().enterSubject, "GOOD MORNING");

		sendkeys(pom.getInstanceMessage().enterMessage, "hello welcome to chennai");
		visbility(driver, pom.getInstanceMessage().sendMessage, 60);
		click(pom.getInstanceMessage().sendMessage);
		while (true) {
			try {
				visbility(driver, pom.getInstanceMessage().seeSentMessage, 60);
				click(pom.getInstanceMessage().seeSentMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(3000);

		while (true) {
			try {
				WebElement $msgtext = driver.findElement(By.xpath("(//div[text()='hello welcome to chennai'])[1]"));
				visbility(driver, $msgtext, 60);
				click($msgtext);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement $del = driver.findElement(By.xpath("(//span[@id='msg-del-btn'])[2]"));
				if ($del.isDisplayed()) {
					System.out.println("MESSAGE FIND");
					click($del);

					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement $delmsgTickIcon = driver
						.findElement(By.xpath("(//span[@id='msg-del-btn'])[2]//following::span[1]"));
				if ($delmsgTickIcon.isDisplayed()) {
					click($delmsgTickIcon);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// Favorite message kpop

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement $showFavMesageKpopIcon = driver
						.findElement(By.xpath("//div[@id='message_list']/div[1]/div[1]/div[2]/i"));

				if ($showFavMesageKpopIcon.isDisplayed()) {
					click($showFavMesageKpopIcon);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		WebElement $favmsgAddicon = driver
				.findElement(By.xpath("//div[@id='MessageFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
		visbility(driver, $favmsgAddicon, 60);
		click($favmsgAddicon);

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement $msgTextbox = driver.findElement(By.xpath("//textarea[@id='message1']"));
				if ($msgTextbox.isDisplayed()) {
					sendkeys($msgTextbox, "FAVORITE MESSAGE KPOP");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		WebElement $savefavmsg = driver.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
		visbility(driver, $savefavmsg, 40);
		click($savefavmsg);

		while (true) {
			try {
				WebElement $addfavMsgToListIcon = driver.findElement(By
						.xpath("(//div[text()='FAVORITE MESSAGE KPOP'])[1]//parent::div[1]//parent::div[1]/div/span"));
				if ($addfavMsgToListIcon.isDisplayed()) {
					click($addfavMsgToListIcon);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				sendkeys(pom.getInstanceMessage().search, kpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000); //

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
				if (msg.isDisplayed()) {
					click(msg);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		click(pom.getInstanceMessage().sendMessage);

	}

	@Test(priority = 7, groups = "settings")
	public void Settings() throws InterruptedException, IOException {

		while (true) {

			if (ur.equals("https://localhost:8443/")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				driver.navigate().refresh();
				break;

			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.navigate().to("https://www.75health.com/health/#setting");
				driver.navigate().refresh();
				break;
			} else if (ur.equals("https://www.test.75health.com/")) {
				javascriptclick(pom.getInstanceSetting().clickSettings);
				driver.navigate().refresh();
				break;
			}

		}
		implicitWait(40, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {
			try {
				WebElement $manageaccount$ = driver.findElement(By.xpath("//button[text()='Manage your Account']"));
				visbility(driver, $manageaccount$, 60);
				click($manageaccount$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(3000);
		WebElement Basicinfo = driver.findElement(By.xpath("(//span[@title='Edit'])[2]"));
		visbility(driver, Basicinfo, 60);
		javascriptclick(Basicinfo);

		WebElement set1 = driver.findElement(By.id("hospitalName"));
		visbility(driver, set1, 60);
		clear(set1);// .clear();
		sleep(2000);
		WebElement set2 = driver.findElement(By.id("hospitalName"));
		visbility(driver, set2, 60);
		sendkeys(set2, "75health organisation");// .sendKeys("75health organisation");
		sleep(3000);
		WebElement set3 = driver.findElement(By.xpath("//button[@title='Administrator Title']"));// .click();
		visbility(driver, set3, 60);
		click(set3);
		sleep(3000);
		List<WebElement> titledrp = driver
				.findElements(By.xpath("//button[@title='Administrator Title']//following::ul[1]/li"));
		for (WebElement choose : titledrp) {
			if (choose.getText().trim().equals("Dr")) {
				visbility(driver, set3, 60);
				choose.click();
				break;
			}

		}
		WebElement Firstnname = driver.findElement(By.id("firstName"));
		visbility(driver, Firstnname, 60);
		Firstnname.clear();

		Firstnname.sendKeys("Automation Acc");

		WebElement lastname = driver.findElement(By.id("lastName"));
		visbility(driver, lastname, 60);
		lastname.clear();
		lastname.sendKeys("Account");
		sleep(3000);
		WebElement hospitalActive = driver.findElement(By.xpath("//button[@id='hospitalActiveId']"));
		visbility(driver, hospitalActive, 60);
		j.executeScript("arguments[0].click();", hospitalActive);
		sleep(2000);
		List<WebElement> Adminstatus = driver.findElements(By.xpath("(//ul[@id='advBillType_Dropdown'])[2]/li"));
		for (WebElement Ch1 : Adminstatus) {
			if (Ch1.getText().trim().equals("ACTIVE")) {
				Ch1.click();
				break;
			}

		}
		sleep(2000);

		WebElement em = driver.findElement(By.xpath("(//button[@id='smsP'])[1]"));
		visbility(driver, em, 60);
		j.executeScript("arguments[0].click();", em);

		sleep(2000);
		List<WebElement> smsnotification = driver.findElements(By.xpath("//ul[@id='Smsul']/li"));
		for (WebElement web : smsnotification) {
			if (web.getText().trim().equals("ON")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);
		WebElement fint = driver.findElement(By.xpath("(//button[@id='save-btn'])[3]"));
		visbility(driver, fint, 60);
		j.executeScript("arguments[0].click();", fint);
		sleep(3000);

		// Contact info..
		while (true) {
			try {
				WebElement contactinfoadd = driver
						.findElement(By.xpath("(//span[text()='Contact'])[1]//following::div[1]"));
				visbility(driver, contactinfoadd, 60);
				actions("click", contactinfoadd);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement add1 = driver.findElement(By.xpath("(//input[@id='address1'])[1]"));
		visbility(driver, add1, 60);
		add1.clear();
		add1.sendKeys("no.224,Main avenue");
		WebElement add2 = driver.findElement(By.xpath("(//input[@id='address2'])[1]"));
		visbility(driver, add2, 60);
		add2.clear();
		add2.sendKeys("watson street usa");
		sleep(2000);
		WebElement city = driver.findElement(By.xpath("(//input[@id='city'])[1]"));
		visbility(driver, city, 60);
		city.clear();
		city.sendKeys("usa");
		sleep(2000);
		WebElement set = driver.findElement(By.xpath("(//select[@id='countryGeoId'])[1]"));
		visbility(driver, set, 60);
		click(set);// .click();
		sleep(2000);
		WebElement selectcountry = driver.findElement(By.xpath("(//select[@id='countryGeoId'])[1]"));
		visbility(driver, selectcountry, 60);
		dropDown("text", selectcountry, "Germany");
		sleep(2000);
		WebElement selectstate = driver.findElement(By.xpath("(//select[@id='stateProvinceGeoId'])[1]"));
		visbility(driver, selectstate, 60);
		dropDown("text", selectstate, "Berlin");
		sleep(2000);
		WebElement trp6 = driver.findElement(By.xpath("(//input[@id='postalCode'])[1]"));// .sendKeys("2001143");
		visbility(driver, trp6, 60);
		sendkeys(trp6, "2001143");
		WebElement savecontactinfo = driver.findElement(By.xpath("(//button[@id='save-btn'])[5]"));
		visbility(driver, savecontactinfo, 60);
		j.executeScript("arguments[0].click();", savecontactinfo);

		// specailaity

		/*
		 * WebElement add = driver.findElement(By.xpath("(//div[@id='add-btn'])[3]"));
		 * 
		 * sleep(2000); js.executeScript("arguments[0].click();", add); WebElement rr =
		 * driver.findElement(By.
		 * xpath("(//input[@placeholder='Select or Enter Specialty'])[1]"));
		 * sleep(2000); actions("click", rr); sleep(2000);
		 * rr.sendKeys("abdominal surgery"); sleep(3000); WebElement splm =
		 * driver.findElement(By.xpath("//span[text()='Abdominal Surgery']"));
		 * actions("click", splm);
		 * driver.findElement(By.xpath("(//button[@id='save-btn'])[7]")).click();
		 * sleep(3000); WebElement splrem =
		 * driver.findElement(By.xpath("//div[text()='Abdominal Surgery']"));
		 * actions("click", splrem); sleep(3000); WebElement spldel =
		 * driver.findElement(By.xpath("(//img[@id='del-btn'])[1]"));
		 * j.executeScript("arguments[0].click();", spldel);
		 * 
		 */ sleep(2000);

		// patient info
		while (true) {
			try {
				WebElement patientinfoedit = driver.findElement(By.xpath("(//span[@id='edit-btn'])[1]"));
				visbility(driver, patientinfoedit, 60);
				actions("click", patientinfoedit);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement gender = driver.findElement(By.xpath("(//button[@id='gender'])[1]"));
		visbility(driver, gender, 60);
		j.executeScript("arguments[0].click();", gender);
		List<WebElement> genderdropdown = driver
				.findElements(By.xpath("(//button[@id='gender'])[1]//following::ul[1]/li"));
		for (WebElement web : genderdropdown) {
			if (web.getText().trim().equals("Male")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		WebElement education = driver.findElement(By.xpath("(//input[@id='educationform'])[1]"));
		visbility(driver, education, 60);
		education.clear();
		education.sendKeys("B.tech");
		sleep(2000);
		WebElement license = driver.findElement(By.xpath("(//input[@id='licensenum'])[1]"));
		visbility(driver, license, 60);
		license.clear();

		license.sendKeys("trt43534");
		sleep(2000);
		WebElement saveadmininfo = driver.findElement(By.xpath("(//button[@id='save-btn'])[1]"));
		visbility(driver, saveadmininfo, 60);
		j.executeScript("arguments[0].click();", saveadmininfo);
		while (true) {
			try {
				WebElement trp7 = driver.findElement(By.xpath("(//button[@onclick='Page.goBack()'])[1]"));
				visbility(driver, trp7, 60);
				click(trp7);
				break;
			} catch (Exception e) {

			}
		}

		/*
		 * WebElement trp9 =
		 * driver.findElement(By.xpath("//button[@onclick='setting.changep()']"));
		 * visbility(driver, trp9, 60); click(trp9);// .click(); WebElement trp10 =
		 * driver.findElement(By.id("currentPassword")); visbility(driver, trp10, 60);
		 * sendkeys(trp10,
		 * ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		 * WebElement trp11 = driver.findElement(By.id("newPassword"));
		 * visbility(driver, trp11, 60); sendkeys(trp11,
		 * ConfigManager.getconfigManager().getInstanceConfigReader().newpassword());
		 * WebElement trp12 = driver.findElement(By.id("confirmNewPassword"));
		 * visbility(driver, trp12, 60); sendkeys(trp12,
		 * ConfigManager.getconfigManager().getInstanceConfigReader().newpassword());
		 * 
		 * WebElement trp13 = driver.findElement(By.id("save-submitform"));
		 * visbility(driver, trp13, 60); click(trp13);// .click();
		 */
		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#setting")) {
				break;
			}
		}

		// Manage users...
		/*
		 * while (true) { try {
		 */
		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		ww.until(ExpectedConditions.elementToBeClickable(manageuser));
		click(manageuser);

		/*
		 * break; } catch (Exception e) { // TODO: handle exception } }
		 */
		sleep(2000);

		try {
			WebElement adduser = driver.findElement(By.xpath("(//button[@id='new'])[1]"));
			visbility(driver, adduser, 60);
			elementClickable(adduser);
			click(adduser);
		} catch (ElementClickInterceptedException e) {
			WebElement adduser = driver.findElement(By.xpath("(//button[@id='new'])[1]"));
			visbility(driver, adduser, 60);
			elementClickable(adduser);
			click(adduser);
		}
		System.out.println("ADD NEW USER CLICKED");
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, "Akash");// .sendKeys("Akash");
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, "N");// .sendKeys("N");
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, "Akashn1212@gmail.com");// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);
		WebElement phone = driver.findElement(By.xpath("//input[@id='PhonE']"));

		phone.sendKeys("2013556237");
		sleep(2000);
		// WebElement createuser =
		// driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		canceluser.click(); // createuser.click(); sleep(3000);
		click(pom.getInstanceSetting().clickSettings);
		sleep(5000);

		WebElement frs = driver.findElement(By.xpath("//button[@id='auto-logout-time']"));
		visbility(driver, frs, 60);
		click(frs);// .click();
		sleep(2000);
		List<WebElement> time = driver.findElements(By.xpath("//ul[@id='logoutt']/li"));
		for (WebElement w : time) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}
		sleep(2000);

		WebElement s1 = driver.findElement(By.xpath("//button[@id='taxbutton']"));
		visbility(driver, s1, 60);
		click(s1);// .click();

		WebElement cl = driver.findElement(By.xpath(
				"/html/body/div[4]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[2]/div/div[6]/div[8]/div/div[1]/div[1]/div[6]/div[1]/div/div[3]/div[1]/ul/li/a"));
		visbility(driver, cl, 60);
		actions("click", cl);
		sleep(3000);
		WebElement s2 = driver.findElement(By.xpath("(//span[@id='plus-add'])[1]"));
		visbility(driver, s2, 60);
		click(s2);// .click();
		sleep(4000);
		WebElement s3 = driver.findElement(By.xpath("(//input[@id='description'])[2]"));
		visbility(driver, s3, 60);
		sendkeys(s3, "DK");// .sendKeys("DK");
		WebElement s4 = driver.findElement(By.xpath("(//input[@id='percentage'])[2]"));
		visbility(driver, s4, 60);
		sendkeys(s4, "5");// .sendKeys("5");

		WebElement s5 = driver.findElement(By.xpath("(//button[@id='save-btn'])[11]"));
		visbility(driver, s5, 60);
		ww.until(ExpectedConditions.elementToBeClickable(s5));
		click(s5);// .click();
		sleep(3000);
		WebElement mn = driver.findElement(By.xpath("//div[text()='DK']"));
		visbility(driver, mn, 60);
		actions("click", mn);
		sleep(3000);
		WebElement s6 = driver.findElement(By.xpath("(//span[@id='del-btn'])[2]"));
		visbility(driver, s6, 60);
		click(s6);// .click();
		sleep(2000);
		WebElement s7 = driver.findElement(By.xpath("(//span[@title='Cancel'])[2]"));
		visbility(driver, s7, 60);
		ww.until(ExpectedConditions.elementToBeClickable(s7));
		click(s7);// .click();
		sleep(3000);

		// cds
		WebElement cdsclick = driver.findElement(By.xpath("//button[contains(text(),'Clinical Decision')]"));
		visbility(driver, cdsclick, 60);
		ww.until(ExpectedConditions.elementToBeClickable(cdsclick));
		click(cdsclick);
		sleep(2000);
		WebElement newcds = driver.findElement(By.xpath("//span[contains(text(),'New Clinical')]"));
		visbility(driver, newcds, 60);
		ww.until(ExpectedConditions.elementToBeClickable(newcds));
		click(newcds);

		sleep(2000);
		WebElement s8 = driver.findElement(By.xpath("(//input[@id='description'])[3]"));
		visbility(driver, s8, 60);
		sendkeys(s8, "Akash");// .sendKeys("Akash");
		sleep(2000);
		WebElement scrolltill = driver.findElement(By.xpath("//input[@id='weight_from']"));
		ScriptExecutor(scrolltill);
		sleep(2000);
		visbility(driver, scrolltill, 60);
		WebElement s9 = driver.findElement(By.xpath("(//input[@id='problem_icd_10'])[2]"));
		visbility(driver, s9, 60);
		sendkeys(s9, "test");// .sendKeys("test");
		sleep(3000);
		WebElement actionproblem = driver.findElement(By.xpath("//div[text()='Malignant neoplasm of testis']"));
		visbility(driver, actionproblem, 60);
		actions("click", actionproblem);
		sleep(2000);
		WebElement activecheck = driver.findElement(By.xpath("//input[@id='active']"));
		visbility(driver, activecheck, 60);
		actions("click", activecheck);
		sleep(2000);
		WebElement savecds = driver.findElement(By.xpath("//input[@id='active']//following::div[4]/div/button"));
		visbility(driver, savecds, 60);
		javascriptclick(savecds);

		sleep(4000);

		WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
		visbility(driver, clicksett, 60);
		javascriptclick(clicksett);
		visbility(driver, cdsclick, 60);
		ScriptExecutor(cdsclick);

		sleep(3000);

		// Set Favorities..

		driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
		sleep(3000);
		List<WebElement> setfav1 = driver.findElements(By.xpath("//ul[@id='setfavoritesul']/li"));
		for (WebElement w : setfav1) {
			if (w.getText().trim().equals("Item/service")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement clickadditem = driver.findElement(By.xpath(
						"//div[@id='referral']//following::div[4]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, clickadditem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(clickadditem));
				click(clickadditem);
				WebElement sdf = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[1]"));
				visbility(driver, sdf, 60);
				sendkeys(sdf, "test");
				WebElement sdf2 = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[2]"));
				visbility(driver, sdf2, 60);
				sendkeys(sdf2, "5");
				WebElement saveitem = driver.findElement(By.xpath("(//div[@id='ItemKpop2']//following::button[2])[1]"));
				visbility(driver, saveitem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(saveitem));
				click(saveitem);

				sleep(2000);
				WebElement edititem = driver.findElement(By.xpath("//span[text()='test']"));
				visbility(driver, edititem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(edititem));
				actions("click", edititem);
				while (true) {
					try {
						WebElement deleteitem = driver
								.findElement(By.xpath("//div[@id='ItemKpop2']/div[1]/div[2]/span[1]"));
						if (deleteitem.isDisplayed()) {
							click(deleteitem);
							break;
						}

					} catch (Exception e) {

					}
				}

				WebElement itemservicebackarrow = driver
						.findElement(By.xpath("//div[@id='ItemFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, itemservicebackarrow, 60);
				ww.until(ExpectedConditions.elementToBeClickable(itemservicebackarrow));
				javascriptclick(itemservicebackarrow);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().contentEquals("Message")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement addnewfavmessage = driver
						.findElement(By.xpath("(//div[@id='message'])[1]/div[1]/div//following::td[4]/span[2]"));
				visbility(driver, addnewfavmessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(addnewfavmessage));
				javascriptclick(addnewfavmessage);

				WebElement msf = driver.findElement(By.xpath("//textarea[@id='message1']"));

				visbility(driver, msf, 60);
				sendkeys(msf, "hello");
				WebElement savemesssage = driver
						.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
				visbility(driver, savemesssage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(savemesssage));
				javascriptclick(savemesssage);
				sleep(2500);
				WebElement editmessage = driver.findElement(By.xpath("//div[text()='hello']"));
				ww.until(ExpectedConditions.elementToBeClickable(editmessage));
				actions("click", editmessage);
				WebElement deletemessage = driver
						.findElement(By.xpath("//div[@id='MessageKpop2']/div[1]/div[2]/span[1]"));
				visbility(driver, deletemessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(deletemessage));
				javascriptclick(deletemessage);

				sleep(3000);
				WebElement gobackmessage = driver
						.findElement(By.xpath("(//span[text()='Favorite Message'])[1]//following::div[1]/span"));
				visbility(driver, gobackmessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(gobackmessage));
				javascriptclick(gobackmessage);

				sleep(3000);

			} else if (w.getText().trim().equals("Symptoms")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement symptomsAddIcon = driver
						.findElement(By.xpath("(//div[@id='SymptomsFavKpop2']//following::span[5])[1]"));
				visbility(driver, symptomsAddIcon, 30);
				ww.until(ExpectedConditions.elementToBeClickable(symptomsAddIcon));
				click(symptomsAddIcon);

				WebElement SymptomIcdTextBox = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::input[1])[1]"));
				visbility(driver, SymptomIcdTextBox, 40);
				sendkeys(SymptomIcdTextBox, "test");

				List<WebElement> symptomsdrop;
				while (true) {
					try {
						symptomsdrop = driver.findElements(By.xpath(
								"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
						if (symptomsdrop.size() > 5) {
							break;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				for (WebElement web : symptomsdrop) {
					if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
						visbility(driver, web, 60);
						javascriptclick(web);
						break;
					}

				}

				WebElement SymptomDisBox = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::input[2])[1]"));
				visbility(driver, SymptomDisBox, 40);
				sendkeys(SymptomDisBox, "Symptoms");

				WebElement saveSymptom = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::button[2])[1]"));
				visbility(driver, saveSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(saveSymptom));
				click(saveSymptom);
				sleep(2500);
				WebElement editSymptom;
				while (true) {
					try {
						editSymptom = driver.findElement(
								By.xpath("(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]"));
						break;
					} catch (StaleElementReferenceException e) {
						e.printStackTrace();
					}
				}
				visbility(driver, editSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(editSymptom));
				click(editSymptom);

				WebElement deleteSymptom = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::span[2])[1]"));
				visbility(driver, deleteSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(deleteSymptom));
				click(deleteSymptom);
				WebElement closeSymptomIcon = driver
						.findElement(By.xpath("(//div[@id='SymptomsFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeSymptomIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(closeSymptomIcon));
				click(closeSymptomIcon);

				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().equals("Problems")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				WebElement ProblemsAddIcon = driver
						.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']//following::span[5])[1]"));
				visbility(driver, ProblemsAddIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(ProblemsAddIcon));
				click(ProblemsAddIcon);

				WebElement ProblemsIcdBox = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[1])[1]"));
				visbility(driver, ProblemsIcdBox, 40);
				sendkeys(ProblemsIcdBox, "test");
				try {
					Problems problem = new Problems();
					problem.$favproblemsIcdCode();
				} catch (Exception e) {

					e.printStackTrace();
				}
				WebElement problemTextBox = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[2])[1]"));
				visbility(driver, problemTextBox, 40);
				sendkeys(problemTextBox, "Problems");
				WebElement saveProblem = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::button[2])[1]"));
				visbility(driver, saveProblem, 40);
				ww.until(ExpectedConditions.elementToBeClickable(saveProblem));
				click(saveProblem);
				sleep(2500);
				WebElement editProblem = driver
						.findElement(By.xpath("(//span[text()='Malignant neoplasm of testis'])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(editProblem));
				click(editProblem);
				sleep(2000);
				WebElement deleteProblem = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteProblem));
				click(deleteProblem);
				WebElement closeProblemIcon = driver
						.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeProblemIcon));
				click(closeProblemIcon);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Visit Reason")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				try {
					WebElement VisitReasonAddIcon = driver
							.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]"));
					visbility(driver, VisitReasonAddIcon, 40);
					elementClickable(VisitReasonAddIcon);
					click(VisitReasonAddIcon);
				} catch (ElementClickInterceptedException e) {
					WebElement VisitReasonAddIcon = driver
							.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]"));
					visbility(driver, VisitReasonAddIcon, 40);
					elementClickable(VisitReasonAddIcon);
					click(VisitReasonAddIcon);
				}
				ww.until(ExpectedConditions
						.elementToBeClickable(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav));
				click(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav);
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])[1]//following::ul[1]/li/a"));

				for (WebElement Element : $TypeDropdown) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						click(Element);
						break;
					}

				}
				WebElement VisitReasonDiscription = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
				visbility(driver, VisitReasonDiscription, 40);
				sendkeys(VisitReasonDiscription, "VisitReason");

				WebElement saveVisitReason = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveVisitReason));
				click(saveVisitReason);
				sleep(2500);
				WebElement editVisitReason = driver.findElement(By.xpath("(//div[text()='VisitReason'])[1]"));
				visbility(driver, editVisitReason, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editVisitReason));
				click(editVisitReason);
				WebElement deleteVisitReason = driver
						.findElement(By.xpath("(//div[@id='Visit_ReasonKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteVisitReason));
				click(deleteVisitReason);

				WebElement closeVisitReason = driver
						.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeVisitReason));
				click(closeVisitReason);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Procedure")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				WebElement PreocedureSetFavAddIcon = driver
						.findElement(By.xpath("(//div[@id='ProcedureFavKpop2']//following::span[5])[1]"));
				visbility(driver, PreocedureSetFavAddIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(PreocedureSetFavAddIcon));
				click(PreocedureSetFavAddIcon);

				WebElement SetfavprocedureCodeTypeDropdown = driver.findElement(By.xpath("//select[@id='codeType']"));
				visbility(driver, SetfavprocedureCodeTypeDropdown, 60);
				ww.until(ExpectedConditions.elementToBeClickable(SetfavprocedureCodeTypeDropdown));
				click(SetfavprocedureCodeTypeDropdown);

				dropDown("text", SetfavprocedureCodeTypeDropdown, "SNOMED CT");

				WebElement SetfavProcedureIcdBox = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::input[1])[1]"));
				visbility(driver, SetfavProcedureIcdBox, 40);
				sendkeys(SetfavProcedureIcdBox, "test");

				List<WebElement> prcddropdwn;
				;
				while (true) {
					try {
						prcddropdwn = driver.findElements(By.xpath(
								"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div/small/em"));
						if (prcddropdwn.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}
				for (WebElement web : prcddropdwn) {

					if (web.getText().trim().equals("SNOMED : 134287002")) {
						// System.out.println("procedure met..");
						visbility(driver, web, 60);
						javascriptclick(web);
						break;

					}

				}

				WebElement SetFavProcedureTextbox = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::input[2])[1]"));
				visbility(driver, SetFavProcedureTextbox, 40);
				sendkeys(SetFavProcedureTextbox, "procedure");

				WebElement saveSetFavProcedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::button[2])[1]"));
				visbility(driver, saveSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(saveSetFavProcedure));
				click(saveSetFavProcedure);
				sleep(2500);

				WebElement editSetFavProcedure = driver.findElement(
						By.xpath("(//div[text()='134287002: Cytomegalovirus antigen test (procedure)'])[1]"));
				visbility(driver, editSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editSetFavProcedure));
				click(editSetFavProcedure);

				WebElement deleteProcedureSetFav = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteProcedureSetFav));
				click(deleteProcedureSetFav);

				WebElement closeSetFavProcedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(closeSetFavProcedure));
				click(closeSetFavProcedure);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().equals("Medications")) {
				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement MedicationAddIcon = driver
						.findElement(By.xpath("(//div[@id='MedicationsFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(MedicationAddIcon));
				click(MedicationAddIcon);

				WebElement MedicationIcdBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[1])[1]"));
				visbility(driver, MedicationIcdBoxSetfav, 40);
				sendkeys(MedicationIcdBoxSetfav, "100");
				// 00);
				visbility(driver, MedicationIcdBoxSetfav, 40);

				sendkeys(MedicationIcdBoxSetfav, "9");
				List<WebElement> $med$drop$down$;

				while (true) {
					try {
						$med$drop$down$ = driver.findElements(By.xpath(
								"//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[2]/li/a/div/small/em"));
						if ($med$drop$down$.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}

				for (WebElement we : $med$drop$down$) {
					System.out.println(we.getText());
					if (we.getText().trim().equals("RXNORM : 1009145")) {
						System.out.println("med cond met");
						visbility(driver, we, 60);
						elementClickable(we);
						click(we);
						break;

					}

				}

				WebElement savemedicationSetFav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::button[3])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(savemedicationSetFav));
				click(savemedicationSetFav);
				sleep(2500);
				if (ur.equals("https://www.75health.com/login.jsp")) {
					WebElement editmedicationSetFav = driver.findElement(By.xpath(
							"(//div[text()='amphetamine aspartate 1.875 MG / amphetamine sulfate 1.875 MG / dextroamphetamine saccharate 1.875 MG / dextroamphetamine sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]"));
					visbility(driver, editmedicationSetFav, 50);
					elementClickable(editmedicationSetFav);
					click(editmedicationSetFav);
				} else if (ur.equals("https://localhost:8443/")) {
					WebElement editmedicationSetFav = driver.findElement(By.xpath(
							"(//div[text()='Amphetamine aspartate 1.875 MG / Amphetamine Sulfate 1.875 MG / Dextroamphetamine saccharate 1.875 MG / Dextroamphetamine Sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]"));
					visbility(driver, editmedicationSetFav, 50);
					elementClickable(editmedicationSetFav);
					click(editmedicationSetFav);

				}

				WebElement deletemedsetfav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deletemedsetfav));
				click(deletemedsetfav);

				WebElement closemedicationSetFav = driver
						.findElement(By.xpath("(//div[@id='MedicationsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closemedicationSetFav));
				click(closemedicationSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Test Order")) {

				try {
					visbility(driver, w, 60);
					elementClickable(w);
					click(w);
				} catch (ElementClickInterceptedException e) {
					visbility(driver, w, 60);
					elementClickable(w);
					click(w);
				}
				WebElement TestOrderAddIcon = driver
						.findElement(By.xpath("(//div[@id='Test_OrderFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(TestOrderAddIcon));
				click(TestOrderAddIcon);

				WebElement TestOrderIcdBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::input[1])[1]"));
				visbility(driver, TestOrderIcdBoxSetfav, 40);
				sendkeys(TestOrderIcdBoxSetfav, "test");

				WebElement saveTestOrderSetFav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveTestOrderSetFav));
				click(saveTestOrderSetFav);
				sleep(2500);
				WebElement editTestOrderSetFav = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
				visbility(driver, editTestOrderSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editTestOrderSetFav));
				click(editTestOrderSetFav);

				WebElement deleteTestOrdersetfav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteTestOrdersetfav));
				click(deleteTestOrdersetfav);

				WebElement closeTestOrderSetFav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeTestOrderSetFav, 50);
				ww.until(ExpectedConditions.elementToBeClickable(closeTestOrderSetFav));
				click(closeTestOrderSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Vaccine")) {

				try {
					visbility(driver, w, 60);
					elementClickable(w);
					click(w);
				} catch (ElementClickInterceptedException e) {
					visbility(driver, w, 60);
					elementClickable(w);
					click(w);
				}

				WebElement VaccineAddIcon = driver
						.findElement(By.xpath("(//div[@id='VaccineFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(VaccineAddIcon));
				click(VaccineAddIcon);

				WebElement vaccineIcdTextBox = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::input[1])[1]"));
				visbility(driver, vaccineIcdTextBox, 40);
				sendkeys(vaccineIcdTextBox, "vacc");

				List<WebElement> vc4;
				while (true) {

					vc4 = driver.findElements(By.xpath(
							//// div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[2]/li/a/span[2]

							"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));

					if (vc4.size() >= 5) {
						System.out.println(vc4.size());
						break;
					}
				}

				for (WebElement web : vc4) {
					System.out.println(web.getText());

					if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
						web.click();
						break;
					}

				}

				WebElement VaccDisBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::input[2])[1]"));
				visbility(driver, VaccDisBoxSetfav, 40);
				sendkeys(VaccDisBoxSetfav, "vaccine");

				WebElement saveVaccineSetFav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveVaccineSetFav));
				click(saveVaccineSetFav);
				sleep(2500);
				WebElement editVaccSetFav = driver
						.findElement(By.xpath("(//div[text()='105: vaccinia (smallpox) diluted'])[1]"));
				visbility(driver, editVaccSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editVaccSetFav));
				click(editVaccSetFav);

				WebElement deleteVaccsetfav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteVaccsetfav));
				click(deleteVaccsetfav);

				WebElement closeVaccSetFav = driver
						.findElement(By.xpath("(//div[@id='VaccineFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeVaccSetFav));
				click(closeVaccSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Goals")) {

				try {
					visbility(driver, w, 60);
					elementClickable(w);
					click(w);
				} catch (ElementClickInterceptedException e) {
					visbility(driver, w, 60);
					elementClickable(w);
					click(w);
				}

				WebElement GoalsAddIcon = driver
						.findElement(By.xpath("(//div[@id='GoalsFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(GoalsAddIcon));
				click(GoalsAddIcon);

				WebElement GoalsTextBox = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]"));
				visbility(driver, GoalsTextBox, 40);
				sendkeys(GoalsTextBox, "goals");

				WebElement saveGoalSetFav = driver
						.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]//following::button[2]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveGoalSetFav));
				click(saveGoalSetFav);
				sleep(2500);
				WebElement editGoalSetFav = driver.findElement(By.xpath("(//div[text()='goals'])[1]"));
				visbility(driver, editGoalSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editGoalSetFav));
				click(editGoalSetFav);

				WebElement deleteGoalssetfav = driver
						.findElement(By.xpath("(//div[@id='GoalsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteGoalssetfav));
				click(deleteGoalssetfav);

				WebElement closeGoalsSetFav = driver
						.findElement(By.xpath("(//div[@id='GoalsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeGoalsSetFav));
				click(closeGoalsSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			}

		}
		// driver.navigate().refresh();
		sleep(2500);
		// Hospital codes... // Item/service code...

		/*
		 * visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton);
		 * 
		 * for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) { if
		 * (w.getText().trim().equals("Item/Service Code")) { while (true) { try {
		 * visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } }
		 * 
		 * sleep(4000);
		 * 
		 * WebElement itemcodeadd = driver.findElement( By.xpath(
		 * "//div[@id='Item_ServiceHosKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"
		 * )); visbility(driver, itemcodeadd, 60); elementClickable(itemcodeadd);
		 * click(itemcodeadd);
		 * 
		 * WebElement itemdis = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[2])[1]"));
		 * visbility(driver, itemdis, 60); sendkeys(itemdis, "160899");
		 * 
		 * WebElement code2 = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[3])[1]"));
		 * visbility(driver, code2, 60); sendkeys(code2, "Birthday");
		 * 
		 * WebElement code3 = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[4])[1]"));
		 * visbility(driver, code3, 60); sendkeys(code3, "5");
		 * 
		 * WebElement hg = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::button[2])[1]"));
		 * 
		 * visbility(driver, hg, 60); elementClickable(hg); click(hg);
		 * 
		 * sleep(3000);
		 * 
		 * try { WebElement cc = driver.findElement(By.xpath("//div[text()='160899']"));
		 * visbility(driver, cc, 40); elementClickable(cc); click(cc);
		 * 
		 * } catch (Exception e) { WebElement cc =
		 * driver.findElement(By.xpath("//div[text()='160899']")); visbility(driver, cc,
		 * 40); elementClickable(cc); click(cc); }
		 * 
		 * try { WebElement vv = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceKpop2']//following::span[2])[1]"));
		 * visbility(driver, vv, 40); elementClickable(vv); click(vv); } catch
		 * (ElementClickInterceptedException e) { WebElement vv = driver
		 * .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceKpop2']//following::span[2])[1]"));
		 * visbility(driver, vv, 40); elementClickable(vv); click(vv); } WebElement th =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']//following::span[1])[1]"));
		 * visbility(driver, th, 60); elementClickable(th); click(th); sleep(2500);
		 * 
		 * implicitWait(30, TimeUnit.SECONDS); try { System.out.println("ENTER ");
		 * visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton); } catch
		 * (StaleElementReferenceException | ElementClickInterceptedException a) {
		 * System.out.println("item service exp"); visbility(driver,
		 * pom.getInstanceSetting().hospitalcodeButton, 50);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton);
		 * System.out.println("click hospital code");
		 * 
		 * } break; } }
		 */

		/*
		 * for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) { if
		 * (w.getText().trim().equals("Procedure Code")) { while (true) { try {
		 * visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } } sleep(3000); try { WebElement addnewprocedurecode = driver
		 * .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::span[6])[1]"));
		 * visbility(driver, addnewprocedurecode, 60);
		 * elementClickable(addnewprocedurecode); click(addnewprocedurecode); } catch
		 * (StaleElementReferenceException | ElementClickInterceptedException e) {
		 * WebElement addnewprocedurecode = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::span[6])[1]"));
		 * visbility(driver, addnewprocedurecode, 60);
		 * elementClickable(addnewprocedurecode); click(addnewprocedurecode); }
		 * WebElement prcd2 = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::input[2])[1]"));
		 * visbility(driver, prcd2, 60); sendkeys(prcd2, "Procedure12");
		 * 
		 * WebElement prcd3 = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::input[3])[1]"));
		 * visbility(driver, prcd3, 60); sendkeys(prcd3, "medicine"); WebElement prcd4 =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::input[4])[1]"));
		 * visbility(driver, prcd4, 60); sendkeys(prcd4, "2");
		 * 
		 * WebElement saveprocedure = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::button[2])[1]"));
		 * visbility(driver, saveprocedure, 60); elementClickable(saveprocedure);
		 * click(saveprocedure);
		 * 
		 * sleep(3000);
		 * 
		 * try { WebElement editprocedure =
		 * driver.findElement(By.xpath("//div[text()='PROCEDURE12']"));
		 * visbility(driver, editprocedure, 60); elementClickable(editprocedure);
		 * click(editprocedure);
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 * 
		 * WebElement delprocd = driver
		 * .findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[2])[1]")
		 * ); visbility(driver, delprocd, 60); elementClickable(delprocd);
		 * click(delprocd);
		 * 
		 * WebElement gobackproced = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::span[1])[1]"));
		 * visbility(driver, gobackproced, 60); elementClickable(gobackproced);
		 * click(gobackproced);
		 * 
		 * sleep(2500);
		 * 
		 * try { visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 40);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton);
		 * 
		 * } catch (Exception e) { visbility(driver,
		 * pom.getInstanceSetting().hospitalcodeButton, 40);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton); } break; }
		 * 
		 * }
		 */
		/*
		 * for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) { if
		 * (w.getText().trim().equals("Medication Code")) { while (true) { try {
		 * visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } } sleep(3000); WebElement clickaddmedd = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsHosKpop2']//following::span[6])[1]"));
		 * visbility(driver, clickaddmedd, 60); elementClickable(clickaddmedd);
		 * click(clickaddmedd);
		 * 
		 * WebElement md2 = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[1])[1]"));
		 * visbility(driver, md2, 60); sendkeys(md2, "MED1"); WebElement med3 = driver
		 * .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[2])[1]"));
		 * visbility(driver, med3, 60); sendkeys(med3, "medication med"); WebElement
		 * med4 = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[3])[1]"));
		 * visbility(driver, med4, 60); sendkeys(med4, "powerful"); WebElement med5 =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[4])[1]"));
		 * visbility(driver, med5, 60); sendkeys(med5, "kaaspro"); WebElement med6 =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[5])[1]"));
		 * visbility(driver, med6, 60); sendkeys(med6, "3"); WebElement savemedication =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::button[2])[1]"));
		 * visbility(driver, savemedication, 60); elementClickable(savemedication);
		 * click(savemedication); sleep(3000);
		 * 
		 * try { WebElement editmedication =
		 * driver.findElement(By.xpath("(//div[text()='MED1'])[1]")); visbility(driver,
		 * editmedication, 60); elementClickable(editmedication); click(editmedication);
		 * 
		 * } catch (Exception e) { WebElement editmedication =
		 * driver.findElement(By.xpath("(//div[text()='MED1'])[1]")); visbility(driver,
		 * editmedication, 60); elementClickable(editmedication); click(editmedication);
		 * }
		 * 
		 * sleep(3000); WebElement delmed = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::span[2])[1]")); visbility(driver,
		 * delmed, 60); elementClickable(delmed); click(delmed);
		 * 
		 * WebElement gobackmed = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsHosKpop2']//following::span[1])[1]"));
		 * visbility(driver, gobackmed, 60); elementClickable(gobackmed);
		 * click(gobackmed); sleep(3000); break;
		 * 
		 * }
		 * 
		 * }
		 */

		// forms...

		WebElement f1 = driver.findElement(By.xpath("//button[@id='form-script']"));

		visbility(driver, f1, 60);
		click(f1);// .click();
		sleep(5000);

		List<WebElement> numberofformspresent = driver
				.findElements(By.xpath("//div[@id='FormsKpop2']/div[2]/div/div[1]/div[1]/span[2]"));

		int ffs = numberofformspresent.size();
		System.out.println(ffs);

		for (WebElement web : numberofformspresent) {

			if (web.getText().isEmpty()) {

				continue;
			}

			else if (web.getText().trim().equals("form800")) {

				System.out.println("condition met the form");

				visbility(driver, web, 60);
				web.click();
				WebElement jsp = driver.findElement(By.xpath("(//span[@id='del-form'])[1]"));
				visbility(driver, jsp, 60);
				javascriptclick(jsp);
				driver.navigate().refresh();
				WebElement jspq = driver.findElement(By.xpath("//button[@id='form-script']"));
				visbility(driver, jspq, 60);
				javascriptclick(jspq);

				break;
			}

		}

		WebElement addfrm = driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/span"));
		visbility(driver, addfrm, 60);
		actions("click", addfrm);

		sleep(4000);
		WebElement f2 = driver.findElement(By.xpath("(//label[text()='Form Title*'])[1]//following::input[1]"));
		visbility(driver, f2, 60);
		sendkeys(f2, "form800");

		List<WebElement> drk = driver.findElements(By.xpath("(//div[@id='build-wrap'])[1]/div[1]/div[2]/ul/li"));

		for (WebElement web : drk) {

			if (web.getText().trim().equals("Checkbox Group")) {

				WebElement drop = driver.findElement(
						By.xpath("(//div[contains(@data-content,'Drag a field from the right to this area')])[1]/ul"));

				Actions ac = new Actions(driver);
				ac.dragAndDrop(web, drop).build().perform();
				WebElement f3 = driver.findElement(By.xpath("//label[text()='Label']//following::div[1]/input"));
				visbility(driver, f3, 60);
				clear(f3);
				WebElement f4 = driver.findElement(By.xpath("//label[text()='Label']//following::div[1]/input"));
				visbility(driver, f4, 60);
				sendkeys(f4, "Kaaspro Enterprise");
				WebElement f5 = driver.findElement(
						By.xpath("(//div[@id='build-wrap'])[1]/div[1]/div[2]/ul//following::div[1]/button"));
				visbility(driver, f5, 60);
				click(f5);

				sleep(3000);

				break;
			}

		}

		sleep(3000); // edit preference....

		WebElement s10 = driver.findElement(By.xpath("//button[@id='edit-print-preference']"));
		visbility(driver, s10, 60);
		ww.until(ExpectedConditions.elementToBeClickable(s10));
		click(s10);
		sleep(3000);
		WebElement s11 = driver.findElement(By.xpath("(//div[@id='setupPrintPreference']//following::button[2])"));
		visbility(driver, s11, 60);
		ww.until(ExpectedConditions.elementToBeClickable(s11));
		click(s11);
		sleep(3000);
		WebElement s12 = driver.findElement(By.xpath("//button[@title='Reset All Your Setting']"));
		visbility(driver, s12, 60);
		ww.until(ExpectedConditions.elementToBeClickable(s12));
		click(s12);
		sleep(2000);
		WebElement df = driver.findElement(By.xpath("(//span[text()='Reset All Settings'])[1]//following::button[2]"));
		visbility(driver, df, 60);
		ww.until(ExpectedConditions.elementToBeClickable(df));
		javascriptclick(df);

		sleep(3000);

		// notification

		WebElement notify = driver.findElement(By.xpath("//button[@id='custom-notify']"));

		boolean b = true;
		while (b) {

			if (!notify.isDisplayed()) {
				WebElement uip = driver
						.findElement(By.xpath("//input[@id='all-notification-mess']//following::span[1]"));

				elementClickable(uip);
				actions("click", uip);
				ww.until(ExpectedConditions.elementToBeClickable(notify));
				javascriptclick(notify);
				WebElement sd = driver.findElement(By.xpath("(//span[@class='slider1 round1'])[4]"));
				ScriptExecutor(sd);
				sleep(2000);
				js.executeScript("window.scrollBy(0,0)");

			}

			b = false;
		}
		sleep(1500);
		while (true) {
			try {
				if (pom.getInstanceSetting().clickSettings.isDisplayed()) {
					click(pom.getInstanceSetting().clickSettings);
					break;
				}
			} catch (Exception e) {

			}
		}

		// notify ehr complte...
		WebElement ntfyehr = driver.findElement(By

				.xpath("//span[text()='Notify user when EHR is completed.']//parent::div//parent::div[1]/label/input"));
		ScriptExecutor(ntfyehr);
		// ww.until(ExpectedConditions.elementToBeClickable(ntfyehr));
		actions("click", ntfyehr);

		// set interval time for emial...

		WebElement rr = driver.findElement(By
				.xpath("//span[text()='Set interval for receiving emails.']//parent::div//parent::div[1]/label/input"));
		// ww.until(ExpectedConditions.elementToBeClickable(rr));
		actions("click", rr);

		// Audit Report...

		sleep(3000);
		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		click(pom.getInstanceSetting().clickSettings);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.navigate().refresh();
		sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='setting.audit()']")));
		WebElement rqqa = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
		ScriptExecutor(rqqa);
		visbility(driver, rqqa, 60);
		javascriptclick(rqqa);
		sleep(3000);
		WebElement s13 = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[1]"));
		visbility(driver, s13, 60);
		sendkeys(s13, kpid);
		sleep(3000);
		List<WebElement> patdr = driver
				.findElements(By.xpath("//div[@id='vvid']//following::ul[1]/li/a/table/tbody/tr[1]/td[2]"));
		for (WebElement we : patdr) {

			if (we.getText().contains(kpid)) {
				visbility(driver, we, 60);
				we.click();
				break;
			}

		}

		sleep(3000);

		WebElement seldate = driver.findElement(By.xpath("//select[@id='byDate']"));
		visbility(driver, seldate, 60);
		dropDown("text", seldate, "All");
		sleep(4000);
		WebElement selmod = driver.findElement(By.xpath("//select[@id='auditEventModule']"));
		visbility(driver, selmod, 60);
		dropDown("text", selmod, "Allergy");
		sleep(3000);
		navigateback(1);
		/*
		 * WebElement s14 =
		 * driver.findElement(By.xpath("//button[@id='advanceSearching']"));
		 * visbility(driver, s14, 60); elementClickable(s14); click(s14);
		 */
		driver.navigate().refresh();

		sleep(3000);
		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		elementClickable(pom.getInstanceSetting().clickSettings);
		click(pom.getInstanceSetting().clickSettings);
		sleep(2000);

		// Dashboard
		WebElement dashboard;

		try {
			dashboard = driver.findElement(By.xpath("(//div[@id='option-setting'])[1]/div/img"));
			visbility(driver, dashboard, 50);
			elementClickable(dashboard);
			click(dashboard);

		} catch (Exception e) {
			dashboard = driver.findElement(By.xpath("(//div[@id='option-setting'])[1]/div/img"));
			visbility(driver, dashboard, 50);
			elementClickable(dashboard);
			click(dashboard);
		}
		List<WebElement> ths = driver
				.findElements(By.xpath("(//div[@id='option-setting'])[1]/div/img//following::ul[1]/li"));

		while (true) {

			for (WebElement st : ths) {
				if (st.getText().trim().equals("Home")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					sleep(2000);
					visbility(driver, dashboard, 50);
					elementClickable(dashboard);
					click(dashboard);
				} else if (st.getText().trim().equals("Dashboard")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					sleep(2000);
					visbility(driver, dashboard, 50);
					elementClickable(dashboard);
					click(dashboard);
				} else if (st.getText().trim().equals("Quick Tour")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					WebElement cncltr = driver.findElement(By.xpath("(//li[text()='NO, CANCEL TOUR'])[1]"));
					visbility(driver, cncltr, 50);
					elementClickable(cncltr);
					sleep(2000);
					click(cncltr);
				} else if (st.getText().trim().equals("Settings")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					sleep(2000);
					visbility(driver, dashboard, 50);
					elementClickable(dashboard);
					click(dashboard);
				} else if (st.getText().trim().equals("Migration Services")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					WebElement clmgr = driver
							.findElement(By.xpath("//h4[text()='Migration Services']//parent::div/button"));
					sleep(2000);
					visbility(driver, clmgr, 50);
					elementClickable(clmgr);
					click(clmgr);
					sleep(2000);
					visbility(driver, dashboard, 50);
					elementClickable(dashboard);
					click(dashboard);
				} else if (st.getText().trim().equals("Sign out")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);

					break;
				}

			}
			break;
		}

	}

}