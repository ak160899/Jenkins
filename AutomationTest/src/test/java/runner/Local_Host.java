package runner;

import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.healthRec.*;
import org.Launch.LaunchBrowser;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
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
import com.pomclass.Basic;
import com.pomclass.VisitReason;

public class Local_Host extends LaunchBrowser {

	static Logger log;

	@Test(priority = 0, groups = "home")
	public void HomeModule() throws Exception {
		log = Logger.getLogger(Local_Host.class);
		BasicConfigurator.configure();

		try {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 50);

			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			click(pom.getInstanceHomeModule().$patientCreationButton);
			log.info("patient create button clicked");
		} catch (ElementClickInterceptedException e) {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 50);
			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			click(pom.getInstanceHomeModule().$patientCreationButton);
			log.info("patient create button clicked");
		}

		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		log.info("first name entered");
		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		log.info("last name entered");
		click(pom.getInstanceNewPatient().clickGenderIcon);
		log.info("gender clicked");
		List<WebElement> genders = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));

		for (WebElement opt : genders) {

			if (opt.getText().equals("Male")) {

				driver.findElement(By.xpath("(//ul[@id='genderDropdown'])[1]/li")).click();
				log.info("gender Choosed");

			}
			break;
		}

		// String character = RandomStringUtils.randomAlphabetic(12);

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		log.info("email id entered");
		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		click(pom.getInstanceHomeModule().selectFlagPhoneNumField);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				click(flag);
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));
		log.info("phone number entered");
		// Acc gets Created..
		click(pom.getInstanceNewPatient().CreatePatient);
		log.info("patient created ");

		while (true) {
			try {
				WebElement $patietcreateid$ = driver.findElement(By.xpath("//td[@id='val-kpid']"));
				if ($patietcreateid$.isDisplayed()) {
					kpid = $patietcreateid$.getText();
					log.info(kpid);

					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		navigateback(2);
		refresh();

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);
		log.info("Appointment booked and deleted");

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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
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

	}

	@Test(priority = 2, groups = "healthrec")
	public void HealthRec() throws Exception {

		if (url.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (url.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (url.equals("https://www.75health.com/login.jsp")) {
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

		try {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 60);
			clickble(driver, pom.getInstanceHealthRec().ehrEllipses, 60);
			actions("click", pom.getInstanceHealthRec().ehrEllipses);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 60);
			clickble(driver, pom.getInstanceHealthRec().ehrEllipses, 60);
			actions("click", pom.getInstanceHealthRec().ehrEllipses);
		}

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Reset Setting")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}

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
					sleep(1500);

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
					} catch (Exception e) {
						System.out.println("GOALS STALE");
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

					for (WebElement web : pom.getInstanceTestOrder().icdList) {
						if (web.getText().trim().equals("test")) {
							visbility(driver, web, 30);
							elementClickable(web);
							click(web);
						}

					}

					/*
					 * if (url.equals("https://localhost:8443/") |
					 * url.equals("https://www.75health.com/login.jsp")) { try {
					 * 
					 * WebElement edit = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
					 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
					 * (StaleElementReferenceException e) { WebElement edit =
					 * driver.findElement(By.xpath("(//div[text()='test'])[1]")); try {
					 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
					 * (ElementClickInterceptedException h) { visbility(driver, edit, 30);
					 * elementClickable(edit); click(edit); } }
					 * 
					 * }
					 */ /*
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
					sleep(1500);
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
		if (url.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (url.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (url.equals("https://www.75health.com/login.jsp")) {
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
		sleep(1500);
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
		sleep(1500);
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
		sleep(1500);
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
		sleep(1500);
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
		sleep(1500);
		try {

			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			elementClickable(pom.getInstanceGoal().addThisFavorite);
			click(pom.getInstanceGoal().addThisFavorite);

		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			elementClickable(pom.getInstanceGoal().addThisFavorite);
			click(pom.getInstanceGoal().addThisFavorite);
		}
		sleep(1500);
		try {

			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			elementClickable(pom.getInstanceGoal().closeFavorite);
			click(pom.getInstanceGoal().closeFavorite);

		} catch (ElementClickInterceptedException e) {
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
		sleep(1500);
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
		sleep(1500);
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
		sleep(1500);
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
		} catch (ElementClickInterceptedException e) {
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
		sleep(1500);
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
		sleep(2000);
		try {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			elementClickable(pom.getInstancePhysicalExam().closeFavorite);
			click(pom.getInstancePhysicalExam().closeFavorite);

		} catch (ElementClickInterceptedException e) {
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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			WebElement delehrf = driver.findElement(By.xpath("(//button[contains(@title,'Delete Health Record')])[1]"));
			javascriptclick(delehrf);
			sleep(2000);
			WebElement zr = driver
					.findElement(By.xpath("//span[text()='Delete Health Record']//following::div[4]/button[2]"));
			javascriptclick(zr);
		}
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

		while (true) {
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
				// (//span[text()='Kaaspro']//parent::div//parent::div[1]//parent::div[1]/div[2])[1]

				WebElement edi = driver.findElement(By.xpath("(//span[text()='Kaaspro'])[2]"));
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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")) {
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
			WebElement weq = driver
					.findElement(By.xpath("//div[@id='item-code-side']/div[3]/div/div/div[2]/div[5]/input"));
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

					WebElement sctadd = driver.findElement(
							By.xpath("//div[@id='tax-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"));
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
			WebElement trp3 = driver
					.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[3]/input"));
			visbility(driver, trp3, 60);
			sendkeys(trp3, "Discnt");// .sendKeys("Discnt");
			WebElement cldrpdis = driver
					.findElement(By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[4]/div/button"));
			visbility(driver, cldrpdis, 60);
			javascriptclick(cldrpdis);
			List<WebElement> dispercen = null;
			for (int i = 1; i <= 5; i++) {
				try {

					dispercen = driver.findElements(
							By.xpath("//div[@id='discount-side']/div[3]/div/div/div[2]/div[4]/div/ul/li/a"));
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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			WebElement trp7 = driver.findElement(By.xpath("//button[@id='finalize-bill']//following::button[2]"));// .click();
			visbility(driver, trp7, 60);
			javascriptclick(trp7);
			sleep(2000);
			WebElement delbil = driver.findElement(
					By.xpath("//center[text()='Do you like to delete Invoice?']//following::div[1]/button[2]"));
			visbility(driver, delbil, 60);
			javascriptclick(delbil);
		}
		sleep(2000);

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
		/*
		 * String inc; while (true) { try { WebElement getinc =
		 * driver.findElement(By.xpath("//span[@id='receiptId']")); visbility(driver,
		 * getinc, 60); inc = getinc.getText(); System.out.println(inc); break; } catch
		 * (Exception e) {
		 * 
		 * } }
		 * 
		 * sleep(3000);
		 * 
		 * driver.navigate().back();
		 * 
		 * while (true) { if
		 * (driver.getCurrentUrl().equals("https://localhost:8443/health/#bill_report"))
		 * { break; } else if (driver.getCurrentUrl().equals(
		 * "https://www.test.75health.com/health/#bill_report")) { break; } else if
		 * (driver.getCurrentUrl().equals("https://www.75health.com/health/#bill_report"
		 * )) { break; } }
		 * 
		 * while (true) { try { WebElement rqs =
		 * driver.findElement(By.xpath("//div[text()='" + inc + "']"));
		 * visbility(driver, rqs, 60);
		 * 
		 * actions("click", rqs); break; } catch (Exception e) {
		 * 
		 * } } sleep(1000); for (int i = 1; i <= 5; i++) { try { WebElement editit =
		 * driver.findElement(By.xpath("//div[text()='dolo']")); visbility(driver,
		 * editit, 60); javascriptclick(editit); break; } catch (Exception e) {
		 * 
		 * } } visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		 * clear(pom.getInstanceBilling().enterTheItem);
		 * 
		 * visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		 * sendkeys(pom.getInstanceBilling().enterTheItem, "Paracetamal");
		 * 
		 * visbility(driver, pom.getInstanceBilling().addPrice, 60);
		 * clear(pom.getInstanceBilling().addPrice);
		 * sendkeys(pom.getInstanceBilling().addPrice, "90");
		 * 
		 * WebElement saveit = driver.findElement( By.xpath(
		 * "//div[text()='dolo']//following::div[6]/div[2]//following::div[1]/div[2]/div[1]/button[3]"
		 * )); visbility(driver, saveit, 60); javascriptclick(saveit);
		 */

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
	//	driver.navigate().refresh();

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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
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
		}
		if (url.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#call_history");
		} else if (url.equals("")) {

		} else if (url.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#call_history");
		}

		try {
			visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
			elementClickable(pom.getInstanceTeleDoctor().clickTeleDoctor);
			click(pom.getInstanceTeleDoctor().clickTeleDoctor);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
			elementClickable(pom.getInstanceTeleDoctor().clickTeleDoctor);
			click(pom.getInstanceTeleDoctor().clickTeleDoctor);
		}

		while (true) {
			try {
				visbility(driver, pom.getInstanceTeleDoctor().searchPatient, 60);
				sendkeys(pom.getInstanceTeleDoctor().searchPatient, kpid);
				break;
			} catch (Exception e) {

			}
		}

		while (true) {
			try {
				WebElement pstl = driver.findElement(By.xpath("//td[@id='nameh']//following::td[1]"));
				visbility(driver, pstl, 60);
				actions("click", pstl);
				break;
			} catch (Exception e) {

			}
		}

		while (true) {
			try {
				WebElement clickpatie = driver.findElement(By.xpath("(//div[@title='Click to view'])[4]"));

				visbility(driver, clickpatie, 60);
				actions("click", clickpatie);
				break;
			} catch (Exception e) {
				e.printStackTrace();
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

		try {
			visbility(driver, pom.getInstanceSetting().clickSettings, 40);
			elementClickable(pom.getInstanceSetting().clickSettings);
			click(pom.getInstanceSetting().clickSettings);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().clickSettings, 40);
			elementClickable(pom.getInstanceSetting().clickSettings);
			click(pom.getInstanceSetting().clickSettings);
		}
		try {

			visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
			elementClickable(pom.getInstanceSetting().manageYorAccount);
			click(pom.getInstanceSetting().manageYorAccount);

		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
			elementClickable(pom.getInstanceSetting().manageYorAccount);
			click(pom.getInstanceSetting().manageYorAccount);
		}
		sleep(2000);
		try {
			visbility(driver, pom.getInstanceSetting().basicInfoEditIcon, 40);
			elementClickable(pom.getInstanceSetting().basicInfoEditIcon);
			click(pom.getInstanceSetting().basicInfoEditIcon);
			// log.info("basic info edit clicked");
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceSetting().basicInfoEditIcon, 40);
			elementClickable(pom.getInstanceSetting().basicInfoEditIcon);
			click(pom.getInstanceSetting().basicInfoEditIcon);
			// log.info("basic info edit clicked");
		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")) {
			visbility(driver, pom.getInstanceSetting().hosipitalName, 40);
			clear(pom.getInstanceSetting().hosipitalName);
			sendkeys(pom.getInstanceSetting().hosipitalName, "75health organisation");
			elementClickable(pom.getInstanceSetting().basicInfoTitle);
			click(pom.getInstanceSetting().basicInfoTitle);

			for (WebElement choose : pom.getInstanceSetting().basicInfoTitleDropdown) {
				if (choose.getText().trim().equals("Dr")) {

					visbility(driver, choose, 60);
					elementClickable(choose);
					click(choose);
					break;
				}

			}
		}

		visbility(driver, pom.getInstanceSetting().firstName, 40);
		clear(pom.getInstanceSetting().firstName);
		sendkeys(pom.getInstanceSetting().firstName, "Automation Acc");

		visbility(driver, pom.getInstanceSetting().lastName, 40);
		clear(pom.getInstanceSetting().lastName);
		sendkeys(pom.getInstanceSetting().lastName, "Automation Acc");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")) {
			elementClickable(pom.getInstanceSetting().basicInfoAdminstatus);
			click(pom.getInstanceSetting().basicInfoAdminstatus);

			for (WebElement status : pom.getInstanceSetting().basicInfoAdminstatusDropdown) {
				if (status.getText().trim().equals("ACTIVE")) {
					visbility(driver, status, 40);
					elementClickable(status);
					click(status);
					break;
				}

			}

			elementClickable(pom.getInstanceSetting().basicInfoSmsNotication);
			click(pom.getInstanceSetting().basicInfoSmsNotication);

			for (WebElement web : pom.getInstanceSetting().basicInfoSmsNoticationDropdown) {
				if (web.getText().trim().equals("ON")) {
					visbility(driver, web, 60);
					elementClickable(web);
					click(web);
					break;
				}

			}

			elementClickable(pom.getInstanceSetting().basicInfoSave);
			click(pom.getInstanceSetting().basicInfoSave);
		} else {
			elementClickable(pom.getInstanceSetting().basicInfoSavedrLogin);
			click(pom.getInstanceSetting().basicInfoSavedrLogin);
		}
		log.info("basic info saved");
		sleep(1000);

		// Contact info..
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")) {
			try {
				visbility(driver, pom.getInstanceSetting().conatctInfoEditIcon, 40);
				elementClickable(pom.getInstanceSetting().conatctInfoEditIcon);
				click(pom.getInstanceSetting().conatctInfoEditIcon);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().conatctInfoEditIcon, 40);
				elementClickable(pom.getInstanceSetting().conatctInfoEditIcon);
				click(pom.getInstanceSetting().conatctInfoEditIcon);
			}

			visbility(driver, pom.getInstanceSetting().contactInfoAddressLine1, 40);
			clear(pom.getInstanceSetting().contactInfoAddressLine1);
			sendkeys(pom.getInstanceSetting().contactInfoAddressLine1, "no.224,Main avenue");
			visbility(driver, pom.getInstanceSetting().contactInfoAddressLine2, 40);
			clear(pom.getInstanceSetting().contactInfoAddressLine2);
			sendkeys(pom.getInstanceSetting().contactInfoAddressLine2, "watson street usa");

			visbility(driver, pom.getInstanceSetting().contactInfoCity, 40);
			clear(pom.getInstanceSetting().contactInfoCity);
			sendkeys(pom.getInstanceSetting().contactInfoCity, "usa");
			visbility(driver, pom.getInstanceSetting().contactInfoCountry, 40);
			dropDown("text", pom.getInstanceSetting().contactInfoCountry, "Germany");
			visbility(driver, pom.getInstanceSetting().contactInfoState, 40);
			dropDown("text", pom.getInstanceSetting().contactInfoState, "Berlin");
			visbility(driver, pom.getInstanceSetting().contactInfoPostalCode, 30);
			clear(pom.getInstanceSetting().contactInfoPostalCode);
			sendkeys(pom.getInstanceSetting().contactInfoPostalCode, "2001143");

			elementClickable(pom.getInstanceSetting().contactInfoPhone1Flag);
			click(pom.getInstanceSetting().contactInfoPhone1Flag);
			for (WebElement flag : pom.getInstanceSetting().contactInfoPh1FlagDropdown) {
				if (flag.getText().trim().equals("+91")) {
					visbility(driver, flag, 30);
					elementClickable(flag);
					click(flag);
				}

			}

			visbility(driver, pom.getInstanceSetting().contactInfoPhone1field, 30);
			clear(pom.getInstanceSetting().contactInfoPhone1field);
			sendkeys(pom.getInstanceSetting().contactInfoPhone1field, "9898764536");

			elementClickable(pom.getInstanceSetting().contactInfoPhone2Flag);
			click(pom.getInstanceSetting().contactInfoPhone2Flag);
			for (WebElement flag : pom.getInstanceSetting().contactInfoPh2FlagDropdown) {
				if (flag.getText().trim().equals("+91")) {
					visbility(driver, flag, 30);
					elementClickable(flag);
					click(flag);
				}

			}
			visbility(driver, pom.getInstanceSetting().contactInfoPhone2field, 30);
			clear(pom.getInstanceSetting().contactInfoPhone2field);
			sendkeys(pom.getInstanceSetting().contactInfoPhone2field, "9898764536");

			elementClickable(pom.getInstanceSetting().contactInfoSave);
			click(pom.getInstanceSetting().contactInfoSave);

		}
		// specailaity
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")) {

			try {

				visbility(driver, pom.getInstanceSetting().specialtyAddIcon, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcon);
				click(pom.getInstanceSetting().specialtyAddIcon);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().specialtyAddIcon, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcon);
				click(pom.getInstanceSetting().specialtyAddIcon);
			}
		} else if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("dr")) {
			try {

				visbility(driver, pom.getInstanceSetting().specialtyAddIcondrLogin, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcondrLogin);
				click(pom.getInstanceSetting().specialtyAddIcondrLogin);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().specialtyAddIcondrLogin, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcondrLogin);
				click(pom.getInstanceSetting().specialtyAddIcondrLogin);
			}
		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")) {
			visbility(driver, pom.getInstanceSetting().specialtyEnter, 40);

			String rand = RandomStringUtils.randomAlphabetic(20);
			sendkeys(pom.getInstanceSetting().specialtyEnter, rand);
			try {
				elementClickable(pom.getInstanceSetting().specialtySave);
				click(pom.getInstanceSetting().specialtySave);
			} catch (Exception e) {
				elementClickable(pom.getInstanceSetting().specialtySave);
				click(pom.getInstanceSetting().specialtySave);
			}
		}
		// patient info
		try {
			visbility(driver, pom.getInstanceSetting().patientInfoeditIcon, 30);
			elementClickable(pom.getInstanceSetting().patientInfoeditIcon);
			click(pom.getInstanceSetting().patientInfoeditIcon);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().patientInfoeditIcon, 30);
			elementClickable(pom.getInstanceSetting().patientInfoeditIcon);
			click(pom.getInstanceSetting().patientInfoeditIcon);
		}

		try {
			elementClickable(pom.getInstanceSetting().patientInfoGender);
			click(pom.getInstanceSetting().patientInfoGender);
		} catch (Exception e) {
			elementClickable(pom.getInstanceSetting().patientInfoGender);
			click(pom.getInstanceSetting().patientInfoGender);
		}

		for (WebElement web : pom.getInstanceSetting().patientInfoGenderDrop) {
			if (web.getText().trim().equals("Male")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);
				break;
			}

		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")) {
			visbility(driver, pom.getInstanceSetting().patinetInfoEducation, 30);
			clear(pom.getInstanceSetting().patinetInfoEducation);
			sendkeys(pom.getInstanceSetting().patinetInfoEducation, "B.tech");

			visbility(driver, pom.getInstanceSetting().patientInfoLicense, 30);
			clear(pom.getInstanceSetting().patientInfoLicense);
			sendkeys(pom.getInstanceSetting().patientInfoLicense, "trt43534");
		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			elementClickable(pom.getInstanceSetting().patientInfoSave);
			click(pom.getInstanceSetting().patientInfoSave);
		} else {
			elementClickable(pom.getInstanceSetting().patientInfoSavedrLogin);
			click(pom.getInstanceSetting().patientInfoSavedrLogin);
		}

		try {
			javascriptclick(pom.getInstanceSetting().managerYouraccBack);

			System.out.println("Try");
		} catch (Exception e) {
			javascriptclick(pom.getInstanceSetting().managerYouraccBack);
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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			try {
				visbility(driver, pom.getInstanceSetting().manageuser, 30);
				elementClickable(pom.getInstanceSetting().manageuser);
				click(pom.getInstanceSetting().manageuser);
				log.info("manage user clicked");
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().manageuser, 30);
				elementClickable(pom.getInstanceSetting().manageuser);
				click(pom.getInstanceSetting().manageuser);
				log.info("manage user clicked");
			}
			try {

				visbility(driver, pom.getInstanceSetting().manageuserAddNewUser, 60);
				elementClickable(pom.getInstanceSetting().manageuserAddNewUser);
				click(pom.getInstanceSetting().manageuserAddNewUser);
			} catch (ElementClickInterceptedException e) {

				visbility(driver, pom.getInstanceSetting().manageuserAddNewUser, 60);
				elementClickable(pom.getInstanceSetting().manageuserAddNewUser);
				click(pom.getInstanceSetting().manageuserAddNewUser);
			}
			visbility(driver, pom.getInstanceSetting().MangerUserFirstName, 30);
			sendkeys(pom.getInstanceSetting().MangerUserFirstName, "KAASPRO");
			visbility(driver, pom.getInstanceSetting().ManageUserLastNmae, 30);
			sendkeys(pom.getInstanceSetting().ManageUserLastNmae, "ENTERPRISES");

			String random = RandomStringUtils.randomAlphabetic(25);
			visbility(driver, pom.getInstanceSetting().manageuserEmailId, 30);
			sendkeys(pom.getInstanceSetting().manageuserEmailId, random + "@gmail.com");
			try {

				elementClickable(pom.getInstanceSetting().manageUserType);
				click(pom.getInstanceSetting().manageUserType);
			} catch (ElementClickInterceptedException e) {
				elementClickable(pom.getInstanceSetting().manageUserType);
				click(pom.getInstanceSetting().manageUserType);
			}
			for (WebElement web : pom.getInstanceSetting().manageUserTypeDrop) {
				if (web.getText().trim().equals("Standard User")) {
					visbility(driver, web, 60);
					elementClickable(web);
					click(web);
					break;
				}

			}
			/*
			 * elementClickable(pom.getInstanceSetting().manageUserPhoneFlag);
			 * click(pom.getInstanceSetting().manageUserPhoneFlag); sleep(2000); for
			 * (WebElement flag : pom.getInstanceSetting().manageUserPhoneFlagDrop) { if
			 * (flag.getText().trim().equals("+1")) { visbility(driver, flag, 30);
			 * elementClickable(flag); click(flag); } }
			 * 
			 * visbility(driver, pom.getInstanceSetting().manageUserPhonefield, 30); String
			 * numeric = RandomStringUtils.randomNumeric(8);
			 * 
			 * sendkeys(pom.getInstanceSetting().manageUserPhonefield, "23" + numeric);
			 */
			try {
				elementClickable(pom.getInstanceSetting().createuser);
				click(pom.getInstanceSetting().createuser);
			} catch (Exception e) {
				elementClickable(pom.getInstanceSetting().createuser);
				click(pom.getInstanceSetting().createuser);
			}
			sleep(2500);

			while (true) {
				if (driver.getCurrentUrl().equals("https://localhost:8443/health/#user")) {
					break;
				} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#user")) {
					break;
				} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#user")) {
					break;
				}
			}

			if (url.equals("https://localhost:8443/")) {
				driver.navigate().to("https://localhost:8443/health/#setting");

			} else if (url.equals("https://www.75health.com/login.jsp")) {
				driver.navigate().to("https://www.75health.com/health/#setting");
			} else if (url.equals("https://www.test.75health.com/")) {
				driver.navigate().to("https://www.test.75health.com/health/#setting");
			}
		}
		for (WebElement w : pom.getInstanceSetting().autoLogoutDrop) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				elementClickable(w);
				click(w);
				break;
			}

		}
		sleep(1000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			try {
				elementClickable(pom.getInstanceSetting().hospitalServiceChargeTaxclick);
				click(pom.getInstanceSetting().hospitalServiceChargeTaxclick);
			} catch (Exception e) {
				elementClickable(pom.getInstanceSetting().hospitalServiceChargeTaxclick);
				click(pom.getInstanceSetting().hospitalServiceChargeTaxclick);
			}

			visbility(driver, pom.getInstanceSetting().hospitalServiceChargeTaxdropclick, 40);
			elementClickable(pom.getInstanceSetting().hospitalServiceChargeTaxdropclick);
			click(pom.getInstanceSetting().hospitalServiceChargeTaxdropclick);

			try {

				visbility(driver, pom.getInstanceSetting().hospitalTaxAddnewTax, 30);
				elementClickable(pom.getInstanceSetting().hospitalTaxAddnewTax);
				click(pom.getInstanceSetting().hospitalTaxAddnewTax);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().hospitalTaxAddnewTax, 30);
				elementClickable(pom.getInstanceSetting().hospitalTaxAddnewTax);
				click(pom.getInstanceSetting().hospitalTaxAddnewTax);
			}
			visbility(driver, pom.getInstanceSetting().hospitalTaxdiscription, 30);
			sendkeys(pom.getInstanceSetting().hospitalTaxdiscription, "DK");

			visbility(driver, pom.getInstanceSetting().hospitalTaxPercentage, 30);
			sendkeys(pom.getInstanceSetting().hospitalTaxPercentage, "5");
			try {
				elementClickable(pom.getInstanceSetting().hospitaltaxSave);
				click(pom.getInstanceSetting().hospitaltaxSave);
			} catch (Exception e) {
				elementClickable(pom.getInstanceSetting().hospitaltaxSave);
				click(pom.getInstanceSetting().hospitaltaxSave);
			}
			try {
				visbility(driver, pom.getInstanceSetting().editHospitalTax, 30);
				elementClickable(pom.getInstanceSetting().editHospitalTax);
				click(pom.getInstanceSetting().editHospitalTax);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().editHospitalTax, 30);
				elementClickable(pom.getInstanceSetting().editHospitalTax);
				click(pom.getInstanceSetting().editHospitalTax);
			}

			try {
				visbility(driver, pom.getInstanceSetting().deleteHospitalTAX, 30);
				elementClickable(pom.getInstanceSetting().deleteHospitalTAX);
				click(pom.getInstanceSetting().deleteHospitalTAX);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().deleteHospitalTAX, 30);
				elementClickable(pom.getInstanceSetting().deleteHospitalTAX);
				click(pom.getInstanceSetting().deleteHospitalTAX);
			}

			try {
				visbility(driver, pom.getInstanceSetting().closeHospitalTax, 30);
				elementClickable(pom.getInstanceSetting().closeHospitalTax);
				click(pom.getInstanceSetting().closeHospitalTax);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().closeHospitalTax, 30);
				elementClickable(pom.getInstanceSetting().closeHospitalTax);
				click(pom.getInstanceSetting().closeHospitalTax);
			}
		}
		// cds

		try {
			visbility(driver, pom.getInstanceSetting().cdsClick, 30);
			elementClickable(pom.getInstanceSetting().cdsClick);
			click(pom.getInstanceSetting().cdsClick);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().cdsClick, 30);
			elementClickable(pom.getInstanceSetting().cdsClick);
			click(pom.getInstanceSetting().cdsClick);
		}

		try {
			visbility(driver, pom.getInstanceSetting().addnewCds, 30);
			elementClickable(pom.getInstanceSetting().addnewCds);
			click(pom.getInstanceSetting().addnewCds);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().addnewCds, 30);
			elementClickable(pom.getInstanceSetting().addnewCds);
			click(pom.getInstanceSetting().addnewCds);
		}

		visbility(driver, pom.getInstanceSetting().enterCds, 30);
		sendkeys(pom.getInstanceSetting().enterCds, "Akash");

		sleep(2000);
		WebElement scrolltill = driver.findElement(By.xpath("//input[@id='weight_from']"));
		ScriptExecutor(scrolltill);

		sleep(2000);
		visbility(driver, pom.getInstanceSetting().cdsIcd, 30);
		sendkeys(pom.getInstanceSetting().cdsIcd, "test");
		sleep(3000);
		visbility(driver, pom.getInstanceSetting().CdsicdList, 30);
		elementClickable(pom.getInstanceSetting().CdsicdList);
		click(pom.getInstanceSetting().CdsicdList);

		visbility(driver, pom.getInstanceSetting().cdsCheckbox, 30);
		elementClickable(pom.getInstanceSetting().cdsCheckbox);
		click(pom.getInstanceSetting().cdsCheckbox);

		elementClickable(pom.getInstanceSetting().saveCds);
		click(pom.getInstanceSetting().saveCds);

		sleep(3000);

		try {
			visbility(driver, pom.getInstanceSetting().clickSettings, 40);
			elementClickable(pom.getInstanceSetting().clickSettings);
			click(pom.getInstanceSetting().clickSettings);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().clickSettings, 40);
			elementClickable(pom.getInstanceSetting().clickSettings);
			click(pom.getInstanceSetting().clickSettings);
		}
		sleep(1000);
		ScriptExecutor(pom.getInstanceSetting().cdsClick);

		// Set Favorities..

		try {
			visbility(driver, pom.getInstanceSetting().setFavoritesClick, 40);
			elementClickable(pom.getInstanceSetting().setFavoritesClick);
			click(pom.getInstanceSetting().setFavoritesClick);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().setFavoritesClick, 40);
			elementClickable(pom.getInstanceSetting().setFavoritesClick);
			click(pom.getInstanceSetting().setFavoritesClick);
		}

		for (WebElement w : pom.getInstanceSetting().setFavoriteListDrop) {
			if (w.getText().trim().equals("Item/service")) {

				visbility(driver, w, 60);
				elementClickable(w);
				click(w);

				try {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setfavoritesItemServiceAddIcon);
					click(pom.getInstanceSetting().setfavoritesItemServiceAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setfavoritesItemServiceAddIcon);
					click(pom.getInstanceSetting().setfavoritesItemServiceAddIcon);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDiscription, 60);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServiceDiscription, "test");
				visbility(driver, pom.getInstanceSetting().setFavoritesItemServicePrice, 40);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServicePrice, "5");
				elementClickable(pom.getInstanceSetting().setFavoritesItemServiceSave);
				click(pom.getInstanceSetting().setFavoritesItemServiceSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceEdit);
					click(pom.getInstanceSetting().setFavoritesItemServiceEdit);

				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceEdit);
					click(pom.getInstanceSetting().setFavoritesItemServiceEdit);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceDelete);
					click(pom.getInstanceSetting().setFavoritesItemServiceDelete);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceDelete);
					click(pom.getInstanceSetting().setFavoritesItemServiceDelete);
				}

				try {
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceClose);
					click(pom.getInstanceSetting().setFavoritesItemServiceClose);
				} catch (Exception e) {
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceClose);
					click(pom.getInstanceSetting().setFavoritesItemServiceClose);
				}

				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);

			} else if (w.getText().trim().contentEquals("Message")) {
				visbility(driver, w, 40);
				elementClickable(w);
				click(w);

				try {

					visbility(driver, pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageAddIcon);
					click(pom.getInstanceSetting().setFavoritesMessageAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageAddIcon);
					click(pom.getInstanceSetting().setFavoritesMessageAddIcon);
				}
				visbility(driver, pom.getInstanceSetting().setFavoritesMessageDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesMessageDiscription, "hello");
				elementClickable(pom.getInstanceSetting().setFavoritesMessageSave);
				click(pom.getInstanceSetting().setFavoritesMessageSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageEdit, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageEdit);
					click(pom.getInstanceSetting().setFavoritesMessageEdit);
				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageEdit, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageEdit);
					click(pom.getInstanceSetting().setFavoritesMessageEdit);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageDelete);
					click(pom.getInstanceSetting().setFavoritesMessageDelete);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageDelete);
					click(pom.getInstanceSetting().setFavoritesMessageDelete);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageClose, 40);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageClose);
					click(pom.getInstanceSetting().setFavoritesMessageClose);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageClose, 40);
					elementClickable(pom.getInstanceSetting().setFavoritesMessageClose);
					click(pom.getInstanceSetting().setFavoritesMessageClose);
				}

			} else if (w.getText().trim().equals("Symptoms")) {

				visbility(driver, w, 40);
				elementClickable(w);
				click(w);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesSymptomsAddIcon);
					click(pom.getInstanceSetting().setFavoritesSymptomsAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesSymptomsAddIcon);
					click(pom.getInstanceSetting().setFavoritesSymptomsAddIcon);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesSymptomsIcd, "test");

				while (true) {
					try {
						/*
						 * symptomsdrop = driver.findElements(By.xpath(
						 * "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"
						 * ));
						 */
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

				visbility(driver, pom.getInstanceSetting().setFavoritesSymotomsdiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesSymotomsdiscription, "Symptoms");
				elementClickable(pom.getInstanceSetting().setFavoritesSymptomsSave);
				click(pom.getInstanceSetting().setFavoritesSymptomsSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesSymptomsedit);
					click(pom.getInstanceSetting().setFavoritesSymptomsedit);
				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
					elementClickable(pom.getInstanceSetting().setFavoritesSymptomsedit);
					click(pom.getInstanceSetting().setFavoritesSymptomsedit);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteSymtomsDelete);
					click(pom.getInstanceSetting().setFavoriteSymtomsDelete);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteSymtomsDelete);
					click(pom.getInstanceSetting().setFavoriteSymtomsDelete);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteSymtomsClose);
					click(pom.getInstanceSetting().setFavoriteSymtomsClose);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteSymtomsClose);
					click(pom.getInstanceSetting().setFavoriteSymtomsClose);
				}

				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);
			} else if (w.getText().trim().equals("Problems")) {

				visbility(driver, w, 40);
				elementClickable(w);
				click(w);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteProblemsAddIcon);
					click(pom.getInstanceSetting().setFavoriteProblemsAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteProblemsAddIcon);
					click(pom.getInstanceSetting().setFavoriteProblemsAddIcon);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteProblemsIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteProblemsIcd, "test");
				sleep(2000);
				click(pom.getInstanceSetting().setFavoriteProblemsIcd);
				try {

					Problems.$favproblemsIcdCode();
				} catch (Exception e) {

					e.printStackTrace();
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteProblemsDiscription, "Problems");
				elementClickable(pom.getInstanceSetting().setFavoriteProblemsSave);
				click(pom.getInstanceSetting().setFavoriteProblemsSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceProblems().editFavorite, 30);
					elementClickable(pom.getInstanceProblems().editFavorite);
					click(pom.getInstanceProblems().editFavorite);
				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceProblems().editFavorite, 30);
					elementClickable(pom.getInstanceProblems().editFavorite);
					click(pom.getInstanceProblems().editFavorite);
				}
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteProblemsDelete);
					click(pom.getInstanceSetting().setFavoriteProblemsDelete);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteProblemsDelete);
					click(pom.getInstanceSetting().setFavoriteProblemsDelete);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsClose, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteProblemsClose);
					click(pom.getInstanceSetting().setFavoriteProblemsClose);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsClose, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteProblemsClose);
					click(pom.getInstanceSetting().setFavoriteProblemsClose);
				}

				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);
			} else if (w.getText().trim().equals("Visit Reason")) {

				visbility(driver, w, 40);
				elementClickable(w);
				click(w);
				try {

					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon);
					click(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon);
				} catch (Exception e) {

					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon);
					click(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon);
				}
				ww.until(ExpectedConditions
						.elementToBeClickable(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav));
				click(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav);

				for (WebElement Element : pom.getInstanceSetting().setFavoriteVisitReasonTypeDrop) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						visbility(driver, Element, 30);
						elementClickable(Element);
						click(Element);
						break;
					}

				}

				visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonDiscription, 40);
				sendkeys(pom.getInstanceSetting().setFavoriteVisitReasonDiscription, "VisitReason");

				elementClickable(pom.getInstanceSetting().setFavoriteVisitReasonSave);
				click(pom.getInstanceSetting().setFavoriteVisitReasonSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVisitReasonEdit);

					click(pom.getInstanceSetting().setFavoriteVisitReasonEdit);
				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVisitReasonEdit);

					click(pom.getInstanceSetting().setFavoriteVisitReasonEdit);
				}

				elementClickable(pom.getInstanceSetting().setFavoriteVisitReasondelete);
				click(pom.getInstanceSetting().setFavoriteVisitReasondelete);
				elementClickable(pom.getInstanceSetting().setFavoriteVisitReasonClose);
				click(pom.getInstanceSetting().setFavoriteVisitReasonClose);

				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);

			} else if (w.getText().trim().equals("Procedure")) {

				visbility(driver, w, 40);
				elementClickable(w);
				click(w);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureAddIcon, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteProcedureAddIcon);
					click(pom.getInstanceSetting().setFavoriteProcedureAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureAddIcon, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteProcedureAddIcon);
					click(pom.getInstanceSetting().setFavoriteProcedureAddIcon);
				}

				visbility(driver, pom.getInstanceProcedure().favoriteCodeType, 40);

				dropDown("text", pom.getInstanceProcedure().favoriteCodeType, "SNOMED CT");

				visbility(driver, pom.getInstanceProcedure().favoriteIcd, 40);
				sendkeys(pom.getInstanceProcedure().favoriteIcd, "test");

				while (true) {

					if (pom.getInstanceSetting().setFavoriteProcedureIcdList.size() > 5) {
						break;
					}

				}
				for (WebElement web : pom.getInstanceSetting().setFavoriteProcedureIcdList) {

					if (web.getText().trim().equals("SNOMED : 134287002")) {

						visbility(driver, web, 60);
						elementClickable(web);
						click(web);
						break;

					}

				}

				visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 40);
				sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure");
				elementClickable(pom.getInstanceSetting().setFavoriteProcedureSave);

				click(pom.getInstanceSetting().setFavoriteProcedureSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteProcedureEdit);
					click(pom.getInstanceSetting().setFavoriteProcedureEdit);
				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteProcedureEdit);
					click(pom.getInstanceSetting().setFavoriteProcedureEdit);
				}
				elementClickable(pom.getInstanceSetting().setFavoriteProcedureDelete);
				click(pom.getInstanceSetting().setFavoriteProcedureDelete);
				visbility(driver, pom.getInstanceSetting().setFavoriteProcedureClose, 40);
				elementClickable(pom.getInstanceSetting().setFavoriteProcedureClose);
				click(pom.getInstanceSetting().setFavoriteProcedureClose);
				try {
					elementClickable(pom.getInstanceSetting().setFavoritesClick);
					click(pom.getInstanceSetting().setFavoritesClick);
				} catch (Exception e) {
					elementClickable(pom.getInstanceSetting().setFavoritesClick);
					click(pom.getInstanceSetting().setFavoritesClick);
				}
			} else if (w.getText().trim().equals("Medications")) {
				visbility(driver, w, 60);
				elementClickable(w);
				click(w);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteMedicationAddIcon);
					click(pom.getInstanceSetting().setFavoriteMedicationAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteMedicationAddIcon);
					click(pom.getInstanceSetting().setFavoriteMedicationAddIcon);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteMedicationIcd, 40);
				sendkeys(pom.getInstanceSetting().setFavoriteMedicationIcd, "1009");

				while (true) {
					try {

						if (pom.getInstanceSetting().setFavoriteMedicationIcdList.size() > 5) {
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				for (WebElement we : pom.getInstanceSetting().setFavoriteMedicationIcdList) {
					System.out.println(we.getText());
					if (we.getText().trim().equals("RXNORM : 1009145")) {
						// System.out.println("med cond met");
						visbility(driver, we, 60);
						elementClickable(we);
						click(we);
						break;

					}

				}
				elementClickable(pom.getInstanceSetting().setFavoriteMedicationSave);
				click(pom.getInstanceSetting().setFavoriteMedicationSave);
				if (url.equals("https://www.75health.com/login.jsp")) {
					try {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
						elementClickable(pom.getInstanceSetting().setFavoriteMedicationEdit);
						click(pom.getInstanceSetting().setFavoriteMedicationEdit);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
						elementClickable(pom.getInstanceSetting().setFavoriteMedicationEdit);
						click(pom.getInstanceSetting().setFavoriteMedicationEdit);
					}
				} else if (url.equals("https://localhost:8443/")) {

					try {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
						elementClickable(pom.getInstanceSetting().setFavoriteMedicationEditLh);
						click(pom.getInstanceSetting().setFavoriteMedicationEditLh);
					} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
						elementClickable(pom.getInstanceSetting().setFavoriteMedicationEditLh);
						click(pom.getInstanceSetting().setFavoriteMedicationEditLh);
					}
				}
				elementClickable(pom.getInstanceSetting().setFavoriteMedicationDelete);
				click(pom.getInstanceSetting().setFavoriteMedicationDelete);
				elementClickable(pom.getInstanceSetting().setFavoriteMedicationClose);
				click(pom.getInstanceSetting().setFavoriteMedicationClose);
				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);

			} else if (w.getText().trim().equals("Test Order")) {

				visbility(driver, w, 60);
				elementClickable(w);
				click(w);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteTestOrderAddIcon);
					click(pom.getInstanceSetting().setFavoriteTestOrderAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteTestOrderAddIcon);
					click(pom.getInstanceSetting().setFavoriteTestOrderAddIcon);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderIcd, 40);
				sendkeys(pom.getInstanceSetting().setFavoriteTestOrderIcd, "test");

				while (true) {
					if (pom.getInstanceSetting().setFavoriteTestOrderIcdList.size() >= 1) {
						break;
					}
				}

				for (WebElement test : pom.getInstanceSetting().setFavoriteTestOrderIcdList) {

					if (test.getText().trim().equals("test")) {
						visbility(driver, test, 40);
						elementClickable(test);
						click(test);
						break;
					}
				}

				elementClickable(pom.getInstanceSetting().setFavoriteTestOrderSave);
				click(pom.getInstanceSetting().setFavoriteTestOrderSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteTestOrderEdit);
					click(pom.getInstanceSetting().setFavoriteTestOrderEdit);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteTestOrderEdit);
					click(pom.getInstanceSetting().setFavoriteTestOrderEdit);
				}

				elementClickable(pom.getInstanceSetting().setFavoriteTestOrderDelete);
				click(pom.getInstanceSetting().setFavoriteTestOrderDelete);

				visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderClose, 50);
				elementClickable(pom.getInstanceSetting().setFavoriteTestOrderClose);
				click(pom.getInstanceSetting().setFavoriteTestOrderClose);
				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);

			} else if (w.getText().trim().equals("Vaccine")) {

				visbility(driver, w, 60);
				elementClickable(w);
				click(w);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineAddIcon, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVaccineAddIcon);
					click(pom.getInstanceSetting().setFavoriteVaccineAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineAddIcon, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVaccineAddIcon);
					click(pom.getInstanceSetting().setFavoriteVaccineAddIcon);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteVaccineIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteVaccineIcd, "vacc");

				while (true) {

					if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {

						break;
					}
				}

				for (WebElement web : pom.getInstanceVaccine().favoriteIcdList) {

					if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
						visbility(driver, web, 30);
						elementClickable(web);
						web.click();
						break;
					}

				}
				visbility(driver, pom.getInstanceSetting().setFavoriteVaccineDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteVaccineDiscription, "vaccine");

				elementClickable(pom.getInstanceVaccine().favoriteSave);
				click(pom.getInstanceVaccine().favoriteSave);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVaccineEdit);
					click(pom.getInstanceSetting().setFavoriteVaccineEdit);
				} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteVaccineEdit);
					click(pom.getInstanceSetting().setFavoriteVaccineEdit);
				}

				elementClickable(pom.getInstanceSetting().setFavoriteVaccinedelete);
				click(pom.getInstanceSetting().setFavoriteVaccinedelete);
				elementClickable(pom.getInstanceSetting().setFavoriteVaccineClose);
				click(pom.getInstanceSetting().setFavoriteVaccineClose);

				elementClickable(pom.getInstanceSetting().setFavoritesClick);
				click(pom.getInstanceSetting().setFavoritesClick);
			} else if (w.getText().trim().equals("Goals")) {

				visbility(driver, w, 60);
				elementClickable(w);
				click(w);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteGoalsAddIcon);
					click(pom.getInstanceSetting().setFavoriteGoalsAddIcon);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
					elementClickable(pom.getInstanceSetting().setFavoriteGoalsAddIcon);
					click(pom.getInstanceSetting().setFavoriteGoalsAddIcon);
				}
				visbility(driver, pom.getInstanceSetting().setFavoriteGoalDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteGoalDiscription, "goals");

				elementClickable(pom.getInstanceSetting().setFavoriteGoalSave);
				click(pom.getInstanceSetting().setFavoriteGoalSave);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteGoalEdit);
					click(pom.getInstanceSetting().setFavoriteGoalEdit);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoriteGoalEdit);
					click(pom.getInstanceSetting().setFavoriteGoalEdit);
				}

				elementClickable(pom.getInstanceSetting().setFavoriteGoalDelete);
				click(pom.getInstanceSetting().setFavoriteGoalDelete);
				elementClickable(pom.getInstanceSetting().setFavoriteGoalClose);
				click(pom.getInstanceSetting().setFavoriteGoalClose);

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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			visbility(driver, pom.getInstanceSetting().customForm, 60);
			click(pom.getInstanceSetting().customForm);
			sleep(5000);

			visbility(driver, pom.getInstanceSetting().addNewform, 60);
			actions("click", pom.getInstanceSetting().addNewform);

			sleep(4000);

			visbility(driver, pom.getInstanceSetting().formTitleDiscription, 60);
			String form = RandomStringUtils.randomAlphabetic(30);
			sendkeys(pom.getInstanceSetting().formTitleDiscription, form);

			for (WebElement web : pom.getInstanceSetting().fromdropDown) {

				if (web.getText().trim().equals("Checkbox Group")) {

					Actions ac = new Actions(driver);
					ac.dragAndDrop(web, pom.getInstanceSetting().dropForm).build().perform();

					visbility(driver, pom.getInstanceSetting().formClearLabel, 60);
					clear(pom.getInstanceSetting().formClearLabel);

					visbility(driver, pom.getInstanceSetting().formClearLabel, 60);
					sendkeys(pom.getInstanceSetting().formClearLabel, "Kaaspro Enterprise");

					visbility(driver, pom.getInstanceSetting().saveForm, 60);
					click(pom.getInstanceSetting().saveForm);

					sleep(3000);

					break;
				}

			}
			refresh();

		}
		sleep(3000); // edit preference....

		visbility(driver, pom.getInstanceSetting().printSettingsClick, 60);
		elementClickable(pom.getInstanceSetting().printSettingsClick);
		click(pom.getInstanceSetting().printSettingsClick);
		sleep(3000);

		visbility(driver, pom.getInstanceSetting().cancelPrintpreference, 60);
		elementClickable(pom.getInstanceSetting().cancelPrintpreference);
		click(pom.getInstanceSetting().cancelPrintpreference);
		sleep(3000);

		visbility(driver, pom.getInstanceSetting().resetSettingClick, 60);
		elementClickable(pom.getInstanceSetting().resetSettingClick);
		click(pom.getInstanceSetting().resetSettingClick);
		sleep(2000);

		visbility(driver, pom.getInstanceSetting().confirmResetSetting, 60);
		elementClickable(pom.getInstanceSetting().confirmResetSetting);
		javascriptclick(pom.getInstanceSetting().confirmResetSetting);

		sleep(3000);

		// notification

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			boolean b = true;
			while (b) {

				if (!pom.getInstanceSetting().customizeMessage.isDisplayed()) {

					elementClickable(pom.getInstanceSetting().customizeToggle);
					actions("click", pom.getInstanceSetting().customizeToggle);
					ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceSetting().customizeMessage));
					javascriptclick(pom.getInstanceSetting().customizeMessage);
					// WebElement sd = driver.findElement(By.xpath("(//span[@class='slider1
					// round1'])[4]"));
					ScriptExecutor(pom.getInstanceSetting().abovePrefernceToggle);
					sleep(2000);
					j.executeScript("window.scrollBy(0,0)");

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

			ScriptExecutor(pom.getInstanceSetting().notifyEhrToggle);

			actions("click", pom.getInstanceSetting().notifyEhrToggle);

		}

		// set interval time for emial...
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")) {

			actions("click", pom.getInstanceSetting().setIntervalToggle);
		}
		// Audit Report...
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")) {
			sleep(3000);
			visbility(driver, pom.getInstanceSetting().clickSettings, 60);
			click(pom.getInstanceSetting().clickSettings);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			driver.navigate().refresh();
			sleep(3000);
			elementClickable(pom.getInstanceSetting().auditReport);

			ScriptExecutor(pom.getInstanceSetting().auditReport);
			visbility(driver, pom.getInstanceSetting().auditReport, 60);
			javascriptclick(pom.getInstanceSetting().auditReport);
			sleep(3000);

			visbility(driver, pom.getInstanceSetting().AuditReportPatientSerachField, 60);
			sendkeys(pom.getInstanceSetting().AuditReportPatientSerachField, kpid);
			sleep(3000);

			for (WebElement we : pom.getInstanceSetting().AuditReportPatientDropdown) {

				if (we.getText().contains(kpid)) {
					visbility(driver, we, 60);
					elementClickable(we);
					we.click();
					break;
				}

			}

			sleep(3000);

			visbility(driver, pom.getInstanceSetting().selectDate, 60);
			dropDown("text", pom.getInstanceSetting().selectDate, "All");
			sleep(4000);

			visbility(driver, pom.getInstanceSetting().selectType, 60);
			dropDown("text", pom.getInstanceSetting().selectType, "Allergy");
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
		}
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
					try {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					} catch (ElementClickInterceptedException e) {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					}
				} else if (st.getText().trim().equals("Dashboard")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					sleep(2000);
					try {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					} catch (ElementClickInterceptedException e) {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					}
				} else if (st.getText().trim().equals("Quick Tour")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					WebElement cncltr = driver.findElement(By.xpath("(//li[text()='NO, CANCEL TOUR'])[1]"));
					visbility(driver, cncltr, 50);
					elementClickable(cncltr);
					sleep(2000);
					click(cncltr);
					sleep(2000);
					try {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					} catch (ElementClickInterceptedException e) {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					}
				} else if (st.getText().trim().equals("Settings")) {
					visbility(driver, st, 50);
					elementClickable(st);
					click(st);
					sleep(2000);
					try {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					} catch (ElementClickInterceptedException e) {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					}
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
					try {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					} catch (ElementClickInterceptedException e) {
						visbility(driver, dashboard, 50);
						elementClickable(dashboard);
						click(dashboard);
					}
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