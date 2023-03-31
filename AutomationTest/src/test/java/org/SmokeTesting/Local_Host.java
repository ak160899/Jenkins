package org.SmokeTesting;

import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.healthRec.*;

import org.Calendar.Calendar_Test;
import org.Launch.LaunchBrowser;
import org.apache.commons.compress.archivers.sevenz.CLI;
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
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.calendar.Calendars;
import com.data.ConfigManager;
import com.healthRec.Tc_020_Forms;
import com.healthRec.Tc_013_Goals;
import com.healthRec.Tc_017_Medication;
import com.healthRec.Tc_010Problems;
import com.healthRec.Tc_012_Procedure;
import com.healthRec.Tc_011_Symptoms;
import com.healthRec.Tc_007_Vaccine;
import com.healthRec.Tc_001_Vitals;
import com.pageObjeman.PageObjMan;
import com.pomclass.Basic;
import com.pomclass.VisitReason;

public class Local_Host extends LaunchBrowser {

	@Test(priority = 0, groups = "home")
	public void HomeModule() throws Exception {

		try {
			clickIntercept(pom.getInstanceHomeModule().$patientCreationButton, 30);
		} catch (Exception e) {
			click(pom.getInstanceHomeModule().$patientCreationButton);

		}

		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		log.info("first name entered");

		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		log.info("last name entered");

		clickIntercept(pom.getInstanceNewPatient().clickGenderIcon, 30);
		log.info("gender clicked");

		List<WebElement> genders = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));

		for (WebElement opt : genders) {

			if (opt.getText().equals("Male")) {

				driver.findElement(By.xpath("(//ul[@id='genderDropdown'])[1]/li")).click();
				log.info("gender Choosed");
				// extentTest.log(Status.INFO, "<b>GENDER CHOOSED</b>:" + opt.getText());

			}
			break;
		}

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		log.info("email id entered");
		// extentTest.log(Status.INFO, "EMAIL ENTERED");
		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		clickIntercept(pom.getInstanceHomeModule().selectFlagPhoneNumField, 30);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				clickIntercept(flag, 30);
				// extentTest.log(Status.INFO, "<b>COUNTRY CODE CHOOSED</b>: " +
				// flag.getText());
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));
		log.info("phone number entered");
		// extentTest.log(Status.INFO, "<b>PHONE NUMBER ENTERED</b>");
		// Acc gets Created..
		clickIntercept(pom.getInstanceNewPatient().CreatePatient, 30);
		log.info("patient created ");
		// extentTest.log(Status.INFO, "<b>CREATE PATIENT CLICKED</b>");

		while (true) {
			try {
				WebElement $patietcreateid$ = driver.findElement(By.xpath("//td[@id='val-kpid']"));
				if ($patietcreateid$.isDisplayed()) {
					kpid = $patietcreateid$.getText();
					log.info(kpid);

					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		navigateback(2);
		refresh();

		Calendar_Test.bookAppointment();

		/*
		 * $current = driver.getCurrentUrl(); cal.$dayDrop($current);
		 * cal.$calenderMod($current, kpid); log.info("Appointment booked and deleted");
		 */

		// extentTest.generateLog(Status.PASS, "TEST IS PASSED");
		// extentTest.addScreenCaptureFromPath(Screenshot("Home"));

	}

	@Test(priority = 1, groups = "patient")
	public void PatientModule() throws InterruptedException {

		clickIntercept(pom.getInstanceNewPatient().$patienmod, 1000);

		implicitWait(60, TimeUnit.SECONDS);

		clickIntercept(pom.getInstanceNewPatient().addNewPatient, 1000);

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

		visbility(driver, pom.getInstanceNewPatient().$patienmod, 30);
		clickIntercept(pom.getInstanceNewPatient().$patienmod, 30);

		try {
			WebElement s = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[2]"));
			visbility(driver, s, 60);
			s.sendKeys(kpid);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			WebElement s = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[2]"));
			visbility(driver, s, 60);
			s.sendKeys(kpid);
		}

		// sleep(8000);

		try {
			WebElement kp = driver.findElement(By.xpath("(//div[text()=" + "'" + kpid + "'])[1]"));

			clickIntercept(kp, 30);
			System.out.println(kp);

		} catch (Exception e) {
			WebElement kp = driver.findElement(By.xpath("(//div[text()=" + "'" + kpid + "'])[1]"));
			clickIntercept(kp, 30);
			System.out.println(kp);
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

		clickIntercept(pom.getInstanceNewPatient().addContactIcon, 1000);

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

		clickIntercept(pom.getInstanceNewPatient().saveContactInfo, 30);

		// alternate contact info...

		clickIntercept(pom.getInstanceNewPatient().AlternateContactIcon, 30);

		visbility(driver, pom.getInstanceNewPatient().alternateContactFullName, 40);
		sendkeys(pom.getInstanceNewPatient().alternateContactFullName, "Kaaspro");

		clickIntercept(pom.getInstanceNewPatient().selectFlag, 30);

		for (WebElement w : pom.getInstanceNewPatient().$countrycode) {

			if (w.getText().equals("+91")) {
				clickIntercept(w, 30);
				break;
			}

		}
		visbility(driver, pom.getInstanceNewPatient().alternateContactPhNumber, 0);
		sendkeys(pom.getInstanceNewPatient().alternateContactPhNumber, "9098674534");

		clickIntercept(pom.getInstanceNewPatient().alternatecontactSaveicon, 30);

		sleep(2000);

		// patient info..

		clickIntercept(pom.getInstanceNewPatient().addPatientInfoIcon, 30);

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
		clickIntercept(pom.getInstanceNewPatient().$patienmod, 30);
		clickIntercept(pom.getInstanceNewPatient().patientmodReport, 30);

		visbility(driver, pom.getInstanceNewPatient().patientReportSerachNametxtBox, 40);
		sendkeys(pom.getInstanceNewPatient().patientReportSerachNametxtBox, "Kaaspro");

		/*
		 * while (true) { try {
		 */
		/* if (pom.getInstanceNewPatient().ellipses.isDisplayed()) { */
		visbility(driver, pom.getInstanceNewPatient().ellipses, 30);
		clickIntercept(pom.getInstanceNewPatient().ellipses, 30);
		/*
		 * break; } } catch (Exception e) { System.out.println(e); } }
		 */
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			for (WebElement t : pom.getInstanceNewPatient().ellipsesOptions) {
				if (t.getText().trim().equals("Import") && t.isDisplayed()) {
					clickIntercept(t, 30);
					break;
				}

			}

			sleep(2000);

			for (WebElement w : pom.getInstanceNewPatient().$ccdImport) {
				if (w.getText().trim().equals("CCD Import") && w.isDisplayed()) {
					clickIntercept(w, 30);
					break;
				}

			}

			clickIntercept(pom.getInstanceNewPatient().$closeCcdImport, 30);

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

		try {

			clickIntercept(pom.getInstanceHealthRec().removePrevious, 30);

		} catch (Exception e) {
			clickIntercept(pom.getInstanceHealthRec().removePrevious, 30);
		}
		sleep(2000);

		for (WebElement web : pom.getInstanceHealthRec().healthRecordSerachPatientByDropdown) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}
		sleep(2000);

		WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
		visbility(driver, r7, 60);
		clickIntercept(r7, 30);

		clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Reset Setting")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);
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

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Alert")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Social History")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Family Health")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Symptoms")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Problems")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Vital")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Visit Reason")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Procedure")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Medications")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Test Order")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Note")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Vaccine")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Attach File")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Inpatient")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Referral")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Custom-form")) {
							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Goals")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Amendment")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Implantable Devices")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Advance Directives")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Physical Examination")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Status")) {

							clickIntercept(web, 30);

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
					Tc_001_Vitals.tc_002_addVitals_Edit_Save();
					;

				} else if (tagnames.equals("visit-reason")) {
					com.healthRec.Tc_006_VisitReason.tc_007_addVisitReason_Edit_Save();
					;

				} else if (tagnames.equals("alert-allergy")) {

					while (true) {
						if (pom.getInstanceAllerygy().addIcon.isDisplayed()) {

							visbility(driver, pom.getInstanceAllerygy().addIcon, 30);

							clickIntercept(pom.getInstanceAllerygy().addIcon, 30);
							break;
						} else {
							if (!pom.getInstanceAllerygy().addIcon.isDisplayed()) {
								actions("move to element", pom.getInstanceAllerygy().addIcon);
							}
						}
					}

					visbility(driver, pom.getInstanceAllerygy().selectAllergyType, 30);

					clickIntercept(pom.getInstanceAllerygy().selectAllergyType, 30);
					dropDown("text", pom.getInstanceAllerygy().selectAllergyType, "Food Allergy");
					visbility(driver, pom.getInstanceAllerygy().allergenDiscription, 30);
					sendkeys(pom.getInstanceAllerygy().allergenDiscription, "food1");

					visbility(driver, pom.getInstanceAllerygy().reactionDiscription, 30);
					sendkeys(pom.getInstanceAllerygy().reactionDiscription, "stomach pain");

					clickIntercept(pom.getInstanceAllerygy().more, 30);

					for (WebElement w : pom.getInstanceAllerygy().chooseFromDropdown) {
						if (w.getText().trim().equals("Show Severity")) {
							clickIntercept(w, 30);
							break;
						}

					}

					clickIntercept(pom.getInstanceAllerygy().more, 30);

					for (WebElement w : pom.getInstanceAllerygy().chooseFromDropdown) {
						if (w.getText().trim().equals("Show Status")) {
							visbility(driver, w, 30);
							clickIntercept(w, 30);

							break;
						}

					}

					visbility(driver, pom.getInstanceAllerygy().severityDiscription, 30);

					dropDown("text", pom.getInstanceAllerygy().severityDiscription, "Mild");

					// sleep(2000);
					visbility(driver, pom.getInstanceAllerygy().statusDiscription, 30);

					dropDown("text", pom.getInstanceAllerygy().statusDiscription, "Inactive");

					clickIntercept(pom.getInstanceAllerygy().saveButton, 30);

					for (WebElement w : pom.getInstanceAllerygy().saveDropdown) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 30);
							clickIntercept(w, 30);
							break;
						}

					}
					try {
						WebElement edit = driver.findElement(By.xpath("//span[text()='food1']"));
						visbility(driver, edit, 60);
						clickIntercept(edit, 30);
					} catch (StaleElementReferenceException e) {
						WebElement edit = driver.findElement(By.xpath("//span[text()='food1']"));

						clickIntercept(edit, 30);
					}

					visbility(driver, pom.getInstanceAllerygy().allergenDiscription, 40);
					clear(pom.getInstanceAllerygy().allergenDiscription);
					sendkeys(pom.getInstanceAllerygy().allergenDiscription, "st");
					sleep(2000);
					WebElement scq = driver.findElement(By.xpath("//div[text()='Strawberry ']"));
					visbility(driver, scq, 60);

					clickIntercept(scq, 30);

					clickIntercept(pom.getInstanceAllerygy().saveButton, 30);

					for (WebElement w : pom.getInstanceAllerygy().saveDropdown) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);

							clickIntercept(w, 30);
							break;
						}

					}

					sleep(3000);

					// Social history....
					while (true) {
						if (pom.getInstanceSocialHistory().addIcon.isDisplayed()) {

							visbility(driver, pom.getInstanceSocialHistory().addIcon, 30);

							clickIntercept(pom.getInstanceSocialHistory().addIcon, 30);
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

					clickIntercept(pom.getInstanceSocialHistory().save, 30);
					try {
						WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
						visbility(driver, jj, 60);

						clickIntercept(jj, 30);
					} catch (StaleElementReferenceException e) {
						WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
						visbility(driver, jj, 60);
						clickIntercept(jj, 30);

					}
					visbility(driver, pom.getInstanceSocialHistory().discription, 30);
					clear(pom.getInstanceSocialHistory().discription);

					sendkeys(pom.getInstanceSocialHistory().discription, "KAASPRO ENTERPRISES");

					clickIntercept(pom.getInstanceSocialHistory().save, 30);

					// Family Health...

					while (true) {
						if (pom.getInstanceFamilyHaelth().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceFamilyHaelth().addIcon, 30);

							clickIntercept(pom.getInstanceFamilyHaelth().addIcon, 30);
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

					Tc_004_FamilyHealth.familyHealthIcd();

					clickIntercept(pom.getInstanceFamilyHaelth().save, 30);

					for (WebElement w : pom.getInstanceFamilyHaelth().saveDropdown) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							clickIntercept(w, 30);

							break;
						}

					}

					// Alert...

					while (true) {

						if (pom.getInstanceAlert().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAlert().addIcon, 30);

							clickIntercept(pom.getInstanceAlert().addIcon, 30);
							break;
						} else {
							if (!pom.getInstanceAlert().addIcon.isDisplayed()) {
								actions("move to element", pom.getInstanceAlert().addIcon);
							}
						}
					}

					visbility(driver, pom.getInstanceAlert().discription, 30);
					sendkeys(pom.getInstanceAlert().discription, "hello");

					clickIntercept(pom.getInstanceAlert().visbility, 30);

					for (WebElement web : pom.getInstanceAlert().visbilityDropDown) {

						if (web.getText().trim().equals("Everyone")) {
							visbility(driver, web, 30);
							clickIntercept(web, 30);

							break;
						}

					}

					clickIntercept(pom.getInstanceAlert().save, 30);

					try {
						visbility(driver, pom.getInstanceAlert().edit, 40);

						clickIntercept(pom.getInstanceAlert().edit, 30);

					} catch (StaleElementReferenceException e) {
						System.out.println("stale");
						visbility(driver, pom.getInstanceAlert().edit, 40);
						clickIntercept(pom.getInstanceAlert().edit, 30);

					}

					visbility(driver, pom.getInstanceAlert().discription, 30);
					clear(pom.getInstanceAlert().discription);
					sendkeys(pom.getInstanceAlert().discription, "wELCOME");

					clickIntercept(pom.getInstanceAlert().save, 30);

				} else if (tagnames.equals("vaccine")) {

					while (true) {

						if (pom.getInstanceVaccine().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceVaccine().addIcon, 30);

							clickIntercept(pom.getInstanceVaccine().addIcon, 30);
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
					clickIntercept(pom.getInstanceVaccine().save, 30);

					try {

						visbility(driver, pom.getInstanceVaccine().edit, 40);

						clickIntercept(pom.getInstanceVaccine().edit, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceVaccine().edit, 40);
						clickIntercept(pom.getInstanceVaccine().edit, 30);
					}

					visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
					clear(pom.getInstanceVaccine().vaccineName);
					sendkeys(pom.getInstanceVaccine().vaccineName, "TT INJECTION");

					// elementClickable(pom.getInstanceVaccine().save);
					clickIntercept(pom.getInstanceVaccine().save, 30);

				} else if (tagnames.equals("implantable-devices")) {

					while (true) {

						if (pom.getInstanceImplantableDevice().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceImplantableDevice().addIcon, 30);

							clickIntercept(pom.getInstanceImplantableDevice().addIcon, 30);
							break;
						} else if (!pom.getInstanceImplantableDevice().addIcon.isDisplayed()) {

							actions("move to element", pom.getInstanceImplantableDevice().addIcon);
						}
					}

					visbility(driver, pom.getInstanceImplantableDevice().udi, 30);
					sendkeys(pom.getInstanceImplantableDevice().udi, "(01)00844588003288");

					clickIntercept(pom.getInstanceImplantableDevice().verifyButton, 30);

					while (true) {
						if (pom.getInstanceImplantableDevice().verifiedTick.isDisplayed()) {
							break;
						}
					}

					visbility(driver, pom.getInstanceImplantableDevice().note, 30);
					sendkeys(pom.getInstanceImplantableDevice().note, "hello123");

					clickIntercept(pom.getInstanceImplantableDevice().save, 30);

					try {
						WebElement edit = driver
								.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
						visbility(driver, edit, 60);
						clickIntercept(edit, 30);
					} catch (StaleElementReferenceException e) {
						WebElement edit = driver
								.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
						visbility(driver, edit, 60);
						clickIntercept(edit, 30);

					}
					visbility(driver, pom.getInstanceImplantableDevice().note, 30);
					clear(pom.getInstanceImplantableDevice().note);
					sendkeys(pom.getInstanceImplantableDevice().note, "JUst Rise up..");

					clickIntercept(pom.getInstanceImplantableDevice().save, 30);

				} else if (tagnames.equals("amendment")) {

					while (true) {

						if (pom.getInstanceAmendment().addIcon.isDisplayed()) {

							visbility(driver, pom.getInstanceAmendment().addIcon, 30);
							clickIntercept(pom.getInstanceAmendment().addIcon, 30);
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

					clickIntercept(pom.getInstanceAmendment().save, 30);

					try {
						WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
						visbility(driver, ac, 60);
						clickIntercept(ac, 30);
					} catch (StaleElementReferenceException e) {
						WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
						visbility(driver, ac, 60);
						clickIntercept(ac, 30);
					}

					visbility(driver, pom.getInstanceAmendment().reasonDiscription, 30);
					clear(pom.getInstanceAmendment().reasonDiscription);
					sendkeys(pom.getInstanceAmendment().reasonDiscription, "warrior");
					clickIntercept(pom.getInstanceAmendment().save, 30);

				} else if (tagnames.equals("diagnosis")) {

					Tc_010Problems.addproblems_Edit_Save();
					;

				} else if (tagnames.equals("symptom")) {

					while (true) {
						if (pom.getInstanceSymptom().addicon.isDisplayed()) {
							visbility(driver, pom.getInstanceSymptom().addicon, 30);
							clickIntercept(pom.getInstanceSymptom().addicon, 30);
							break;
						} else if (!pom.getInstanceSymptom().addicon.isDisplayed()) {
							actions("move to element", pom.getInstanceSymptom().addicon);
						}
					}
					visbility(driver, pom.getInstanceSymptom().icd, 30);
					sendkeys(pom.getInstanceSymptom().icd, "test");

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
							clickIntercept(web, 30);
							break;
						}

					}
					visbility(driver, pom.getInstanceSymptom().symptoms, 30);
					sendkeys(pom.getInstanceSymptom().symptoms, "fever");

					clickIntercept(pom.getInstanceSymptom().save, 30);

					try {
						WebElement a8 = driver.findElement(
								By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
						visbility(driver, a8, 40);
						clickIntercept(a8, 30);
					} catch (StaleElementReferenceException e) {
						WebElement a8 = driver.findElement(
								By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
						visbility(driver, a8, 40);
						clickIntercept(a8, 30);

					}

					visbility(driver, pom.getInstanceSymptom().symptoms, 40);
					clear(pom.getInstanceSymptom().symptoms);
					sendkeys(pom.getInstanceSymptom().symptoms, "covid");
					clickIntercept(pom.getInstanceSymptom().save, 30);

				} else if (tagnames.equals("procedure")) {

					while (true) {

						if (pom.getInstanceProcedure().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceProcedure().addIcon, 40);
							clickIntercept(pom.getInstanceProcedure().addIcon, 30);
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
							clickIntercept(web, 30);
							break;

						}

					}
					visbility(driver, pom.getInstanceProcedure().procedure, 40);
					sendkeys(pom.getInstanceProcedure().procedure, "gdgdg");
					clickIntercept(pom.getInstanceProcedure().save, 30);

					for (WebElement w : pom.getInstanceProcedure().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							clickIntercept(w, 30);

							break;
						}

					}

					try {

						WebElement edit = driver.findElement(
								By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
						visbility(driver, edit, 60);
						clickIntercept(edit, 30);

					} catch (StaleElementReferenceException e) {

						WebElement edit = driver.findElement(
								By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
						visbility(driver, edit, 60);
						clickIntercept(edit, 30);

					}

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

					clickIntercept(pom.getInstanceProcedure().save, 30);

					for (WebElement w : pom.getInstanceProcedure().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							clickIntercept(w, 30);
							break;
						}

					}

				} else if (tagnames.equals("goals")) {
					while (true) {

						if (pom.getInstanceGoal().addicon.isDisplayed()) {
							visbility(driver, pom.getInstanceGoal().addicon, 40);
							clickIntercept(pom.getInstanceGoal().addicon, 30);
							break;
						} else if (!pom.getInstanceGoal().addicon.isDisplayed()) {
							actions("move to element", pom.getInstanceGoal().addicon);
						}
					}
					visbility(driver, pom.getInstanceGoal().enterGoal, 30);
					sendkeys(pom.getInstanceGoal().enterGoal, "goal1");
					// sleep(3000);
					try {
						visbility(driver, pom.getInstanceGoal().DateField, 30);
						clickIntercept(pom.getInstanceGoal().DateField, 30);

						System.out.println("DATE CLICKED");
					} catch (Exception e) {
						System.out.println("DATE CLICKED{catch}");
						visbility(driver, pom.getInstanceGoal().DateField, 30);
						clickIntercept(pom.getInstanceGoal().DateField, 30);

					}
					visbility(driver, pom.getInstanceGoal().selectMonth, 30);
					dropDown("index", pom.getInstanceGoal().selectMonth, "09");

					visbility(driver, pom.getInstanceGoal().chooseDate, 30);
					clickIntercept(pom.getInstanceGoal().chooseDate, 30);
					clickIntercept(pom.getInstanceGoal().save, 30);

					try {

						visbility(driver, pom.getInstanceGoal().edit, 60);
						clickIntercept(pom.getInstanceGoal().edit, 30);
					} catch (StaleElementReferenceException e) {
						System.out.println("GOALS STALE");
						visbility(driver, pom.getInstanceGoal().edit, 60);
						clickIntercept(pom.getInstanceGoal().edit, 30);
					}

					visbility(driver, pom.getInstanceGoal().enterGoal, 30);
					clear(pom.getInstanceGoal().enterGoal);
					sendkeys(pom.getInstanceGoal().enterGoal, "HELLO THIS IS GOALS MODULE.");
					clickIntercept(pom.getInstanceGoal().save, 30);

				} else if (tagnames.equals("directives")) {

					while (true) {
						if (pom.getInstanceAdvanceDirective().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAdvanceDirective().addIcon, 30);
							clickIntercept(pom.getInstanceAdvanceDirective().addIcon, 30);
							break;
						} else if (!pom.getInstanceAdvanceDirective().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceAdvanceDirective().addIcon);
						}
					}

					visbility(driver, pom.getInstanceAdvanceDirective().selectType, 30);
					dropDown("text", pom.getInstanceAdvanceDirective().selectType, "Assessment");

					visbility(driver, pom.getInstanceAdvanceDirective().assesment, 30);
					sendkeys(pom.getInstanceAdvanceDirective().assesment, "lets hope");
					clickIntercept(pom.getInstanceAdvanceDirective().save, 30);

					try {
						WebElement edit = driver.findElement(By.xpath("//div[text()='lets hope']"));
						visbility(driver, edit, 30);
						clickIntercept(edit, 30);

					} catch (StaleElementReferenceException e) {
						WebElement edit = driver.findElement(By.xpath("//div[text()='lets hope']"));

						visbility(driver, edit, 30);
						clickIntercept(edit, 30);

					}

					visbility(driver, pom.getInstanceAdvanceDirective().assesment, 30);
					sendkeys(pom.getInstanceAdvanceDirective().assesment, "Advance directives");
					clickIntercept(pom.getInstanceAdvanceDirective().save, 30);

				} else if (tagnames.equals("status-module")) {

					while (true) {
						if (pom.getInstanceStatus().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceStatus().addIcon, 30);
							clickIntercept(pom.getInstanceStatus().addIcon, 30);
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
							clickIntercept(we, 30);
							break;
						}

					}
					clickIntercept(pom.getInstanceStatus().save, 30);

					try {
						WebElement $editstatus$ = driver.findElement(
								By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
						visbility(driver, $editstatus$, 60);
						clickIntercept($editstatus$, 30);
						visbility(driver, pom.getInstanceStatus().removeStatus, 30);
						clickIntercept(pom.getInstanceStatus().removeStatus, 30);
					} catch (StaleElementReferenceException e) {
						WebElement $editstatus$ = driver.findElement(
								By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
						clickIntercept($editstatus$, 30);
						clickIntercept(pom.getInstanceStatus().removeStatus, 30);
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
							clickIntercept(we, 30);
							break;
						}

					}
					clickIntercept(pom.getInstanceStatus().save, 30);

				} else if (tagnames.equals("test-order")) {

					while (true) {
						if (pom.getInstanceTestOrder().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceTestOrder().addIcon, 30);
							clickIntercept(pom.getInstanceTestOrder().addIcon, 30);
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
							clickIntercept(web, 30);
							System.out.println("Test Order ICD");
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

					clickIntercept(pom.getInstanceTestOrder().more, 30);

					for (WebElement w : pom.getInstanceTestOrder().moreDropdown) {

						if (w.getText().trim().equals("Show Notes")) {
							visbility(driver, w, 30);
							clickIntercept(w, 30);
							break;
						}

					}
					visbility(driver, pom.getInstanceTestOrder().notes, 40);
					sendkeys(pom.getInstanceTestOrder().notes, "ERROR");
					clickIntercept(pom.getInstanceTestOrder().save, 30);

					for (WebElement w : pom.getInstanceTestOrder().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 30);
							clickIntercept(w, 30);
							break;
						}

					}

					try {
						WebElement edit = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));
						visbility(driver, edit, 30);
						clickIntercept(edit, 30);

					} catch (StaleElementReferenceException e) {
						WebElement edit = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));
						clickIntercept(edit, 30);
					}

					visbility(driver, pom.getInstanceTestOrder().notes, 30);
					clear(pom.getInstanceTestOrder().notes);
					sendkeys(pom.getInstanceTestOrder().notes, "Test order..");
					clickIntercept(pom.getInstanceTestOrder().save, 30);

					for (WebElement w : pom.getInstanceTestOrder().saveMore) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 30);
							clickIntercept(w, 30);
							break;
						}

					}

				} else if (tagnames.equals("drug")) {

					while (true) {

						if (pom.getInstanceMedication().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceMedication().addIcon, 40);
							clickIntercept(pom.getInstanceMedication().addIcon, 30);
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
							clickIntercept(web, 30);
							break;
						}

					}
					clickIntercept(pom.getInstanceMedication().save, 30);

					for (WebElement w : pom.getInstanceMedication().saveDropdown) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							clickIntercept(w, 30);
							break;
						}

					}

					try {
						visbility(driver, pom.getInstanceMedication().edit, 30);
						clickIntercept(pom.getInstanceMedication().edit, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceMedication().edit, 30);
						clickIntercept(pom.getInstanceMedication().edit, 30);
					}
					clickIntercept(pom.getInstanceMedication().removeMedication, 30);

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
							clickIntercept(we, 30);
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
							clickIntercept(web, 30);
							break;
						}

					}
					clickIntercept(pom.getInstanceMedication().save, 30);

					for (WebElement w : pom.getInstanceMedication().saveDropdown) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							clickIntercept(w, 30);
							break;
						}

					}

					sleep(2000);
				} else if (tagnames.equals("delivery-note")) {

					while (true) {
						if (pom.getInstanceNotes().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceNotes().addIcon, 30);
							clickIntercept(pom.getInstanceNotes().addIcon, 30);
							break;
						} else if (!pom.getInstanceNotes().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceNotes().addIcon);
						}
					}

					visbility(driver, pom.getInstanceNotes().enterNote, 30);
					sendkeys(pom.getInstanceNotes().enterNote, "hell");
					clickIntercept(pom.getInstanceNotes().save, 30);

					sleep(1500);
					try {
						visbility(driver, pom.getInstanceNotes().edit, 30);
						clickIntercept(pom.getInstanceNotes().edit, 30);

					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceNotes().edit, 30);
						clickIntercept(pom.getInstanceNotes().edit, 30);
					}

					visbility(driver, pom.getInstanceNotes().enterNote, 30);
					sendkeys(pom.getInstanceNotes().enterNote, "NOTES--MMM");
					clickIntercept(pom.getInstanceNotes().save, 30);

				} else if (tagnames.equals("physical-examination")) {

					while (true) {

						if (pom.getInstancePhysicalExam().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstancePhysicalExam().addIcon, 30);
							clickIntercept(pom.getInstancePhysicalExam().addIcon, 30);
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
						clickIntercept(pom.getInstancePhysicalExam().more, 30);

					} catch (Exception e) {
						clickIntercept(pom.getInstancePhysicalExam().more, 30);
					}
					for (WebElement w : pom.getInstancePhysicalExam().moreDropDown) {
						if (w.getText().trim().equals("Show Notes")) {
							visbility(driver, w, 60);
							clickIntercept(w, 30);
							break;
						}

					}

					visbility(driver, pom.getInstancePhysicalExam().notes, 30);
					sendkeys(pom.getInstancePhysicalExam().notes, "lets goo");
					clickIntercept(pom.getInstancePhysicalExam().save, 30);

					try {
						visbility(driver, pom.getInstancePhysicalExam().edit, 30);
						clickIntercept(pom.getInstancePhysicalExam().edit, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstancePhysicalExam().edit, 30);
						clickIntercept(pom.getInstancePhysicalExam().edit, 30);
					}

					visbility(driver, pom.getInstancePhysicalExam().notes, 30);
					clear(pom.getInstancePhysicalExam().notes);
					sendkeys(pom.getInstancePhysicalExam().notes, "physical condition");
					clickIntercept(pom.getInstancePhysicalExam().save, 30);

				} else if (tagnames.equals("custom-form")) {

					Tc_020_Forms form = new Tc_020_Forms();
					try {
						form.$addForm();
					} catch (Throwable e) {

						e.printStackTrace();
					}

				} else if (tagnames.equals("attachFile")) {

					while (true) {
						if (pom.getInstanceAttachFile().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceAttachFile().addIcon, 30);
							clickIntercept(pom.getInstanceAttachFile().addIcon, 30);
							break;
						} else if (!pom.getInstanceAttachFile().addIcon.isDisplayed()) {
							actions("move to element", pom.getInstanceAttachFile().addIcon);
						}
					}

					visbility(driver, pom.getInstanceAttachFile().selectType, 30);
					dropDown("text", pom.getInstanceAttachFile().selectType, "Web link");

					visbility(driver, pom.getInstanceAttachFile().link, 30);
					sendkeys(pom.getInstanceAttachFile().link, "https://www.75health.com/");
					clickIntercept(pom.getInstanceAttachFile().save, 30);

					try {
						visbility(driver, pom.getInstanceAttachFile().edit, 30);
						clickIntercept(pom.getInstanceAttachFile().edit, 30);

					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceAttachFile().edit, 30);
						clickIntercept(pom.getInstanceAttachFile().edit, 30);
					}

					visbility(driver, pom.getInstanceAttachFile().link, 30);
					clear(pom.getInstanceAttachFile().link);
					sendkeys(pom.getInstanceAttachFile().link, "https://www.75health.com/");
					clickIntercept(pom.getInstanceAttachFile().save, 30);

					sleep(3000);
				} else if (tagnames.equals("inpatient")) {

					while (true) {
						if (pom.getInstanceInpatient().addIcon.isDisplayed()) {
							visbility(driver, pom.getInstanceInpatient().addIcon, 30);
							clickIntercept(pom.getInstanceInpatient().addIcon, 30);
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
					clickIntercept(pom.getInstanceInpatient().chooseDate, 30);

					sleep(2000);
					clickIntercept(pom.getInstanceInpatient().dischargeIdField, 30);

					visbility(driver, pom.getInstanceInpatient().selectMonth, 40);
					dropDown("index", pom.getInstanceInpatient().selectMonth, "10");
					visbility(driver, pom.getInstanceInpatient().selectYear, 40);
					dropDown("text", pom.getInstanceInpatient().selectYear, "2022");
					visbility(driver, pom.getInstanceInpatient().chooseDate, 30);
					clickIntercept(pom.getInstanceInpatient().chooseDate, 30);

					visbility(driver, pom.getInstanceInpatient().selectType, 40);
					dropDown("text", pom.getInstanceInpatient().selectType, "Urgent");
					visbility(driver, pom.getInstanceInpatient().roomNo, 30);
					sendkeys(pom.getInstanceInpatient().roomNo, "777");
					visbility(driver, pom.getInstanceInpatient().discharge, 30);
					sendkeys(pom.getInstanceInpatient().discharge, "okay");
					clickIntercept(pom.getInstanceInpatient().save, 30);

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

		visbility(driver, pom.getInstanceHealthRec().generateBill, 30);
		clickIntercept(pom.getInstanceHealthRec().generateBill, 30);

		for (WebElement we : pom.getInstanceHealthRec().genratebillDropdown) {
			if (we.getText().trim().equals("Generate Bill from EHR")) {
				visbility(driver, we, 60);
				clickIntercept(we, 30);
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

		visbility(driver, pom.getInstanceHealthRec().clickAddIconHealthRec, 30);
		clickIntercept(pom.getInstanceHealthRec().clickAddIconHealthRec, 30);

		// past cured...

		try {
			Tc_007_Vaccine.$getPastVaccine();
		} catch (Throwable e1) {

			e1.printStackTrace();
		}

		// Problems pro = new Problems();
		// pro.getPastProblem();

		Tc_011_Symptoms s = new Tc_011_Symptoms();
		s.getPastSymptom();
		Tc_012_Procedure pr = new Tc_012_Procedure();
		pr.getPastProcedure();
		Tc_013_Goals g = new Tc_013_Goals();
		g.$getPastGoals();

		Tc_017_Medication med = new Tc_017_Medication();
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
				clickIntercept(pom.getInstanceVistReason().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceVistReason().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceVistReason().favoriteIcon);
			}

		}

		try {

			visbility(driver, pom.getInstanceVistReason().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceVistReason().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addNewFavorite, 30);

		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
		}

		for (WebElement Element : pom.getInstanceVistReason().selectFavoriteAppointmnetType) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency")) {

				clickIntercept(Element, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceVistReason().favoriteDiscription, 60);
		sendkeys(pom.getInstanceVistReason().favoriteDiscription, "favorite visit reason");
		clickIntercept(pom.getInstanceVistReason().FavoriteSave, 30);
		try {

			visbility(driver, pom.getInstanceVistReason().editFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVistReason().editFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().editFavorite, 30);
		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
			// System.out.println("ELEMENT CLICKED IN VISIT");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
		}

		for (WebElement Element : pom.getInstanceVistReason().selectFavoriteAppointmnetType) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency")) {
				visbility(driver, Element, 30);
				clickIntercept(Element, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceVistReason().favoriteDiscription, 30);
		sendkeys(pom.getInstanceVistReason().favoriteDiscription, "favorite visit reason");
		clickIntercept(pom.getInstanceVistReason().FavoriteSave, 30);

		try {

			visbility(driver, pom.getInstanceVistReason().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addThisFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVistReason().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addThisFavorite, 30);
		}
		try {
			elementClickable(pom.getInstanceVistReason().closeFavorite);
			clickIntercept(pom.getInstanceVistReason().closeFavorite, 30);
		} catch (ElementClickInterceptedException e) {
			elementClickable(pom.getInstanceVistReason().closeFavorite);
			clickIntercept(pom.getInstanceVistReason().closeFavorite, 30);
		}

		sleep(2000);

		// $$$$$$$$//

		// vaccine

		while (true) {

			if (pom.getInstanceVaccine().favoriteicon.isDisplayed()) {
				visbility(driver, pom.getInstanceVaccine().favoriteicon, 30);
				clickIntercept(pom.getInstanceVaccine().favoriteicon, 30);
				break;
			} else if (!pom.getInstanceVaccine().favoriteicon.isDisplayed()) {
				actions("move to element", pom.getInstanceVaccine().favoriteicon);
			}
		}

		try {
			visbility(driver, pom.getInstanceVaccine().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceVaccine().favoriteVaccineCvx, 30);
		sendkeys(pom.getInstanceVaccine().favoriteVaccineCvx, "vacc");

		while (true) {

			if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {

				break;
			}
		}

		for (WebElement web : pom.getInstanceVaccine().favoriteIcdList) {

			if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
				clickIntercept(web, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		sendkeys(pom.getInstanceVaccine().vaccineName, "vacine favorite");
		clickIntercept(pom.getInstanceVaccine().favoriteSave, 30);
		try {

			visbility(driver, pom.getInstanceVaccine().editFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVaccine().editFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().editFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceVaccine().removeFavoriteIcd, 30);
			clickIntercept(pom.getInstanceVaccine().removeFavoriteIcd, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().removeFavoriteIcd, 30);
			clickIntercept(pom.getInstanceVaccine().removeFavoriteIcd, 30);
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
				clickIntercept(we, 30);

				break;
			}

		}

		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		clear(pom.getInstanceVaccine().vaccineName);
		sendkeys(pom.getInstanceVaccine().vaccineName, "vacine module");
		clickIntercept(pom.getInstanceVaccine().favoriteSave, 30);

		try {

			visbility(driver, pom.getInstanceVaccine().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addThisFavorite, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceVaccine().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceVaccine().closeFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().closeFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().closeFavorite, 30);
		}

		// $$$$$$$$$symptoms$$$$$

		while (true) {

			if (pom.getInstanceSymptom().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceSymptom().favoriteIcon, 30);
				clickIntercept(pom.getInstanceSymptom().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceSymptom().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceSymptom().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceSymptom().addNewFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addNewFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceSymptom().favoriteicd, 30);
		sendkeys(pom.getInstanceSymptom().favoriteicd, "test");

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().contains("premium")) {
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
					clickIntercept(web, 30);

					break;
				}

			}
		}

		visbility(driver, pom.getInstanceSymptom().favoriteSymptom, 30);
		sendkeys(pom.getInstanceSymptom().favoriteSymptom, "symptoms favorite");
		clickIntercept(pom.getInstanceSymptom().favoriteSave, 30);

		try {

			visbility(driver, pom.getInstanceSymptom().editFavorite, 40);
			clickIntercept(pom.getInstanceSymptom().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceSymptom().editFavorite, 40);
			clickIntercept(pom.getInstanceSymptom().editFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceSymptom().removeFavoriteIcd, 30);
			clickIntercept(pom.getInstanceSymptom().removeFavoriteIcd, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().removeFavoriteIcd, 30);
			clickIntercept(pom.getInstanceSymptom().removeFavoriteIcd, 30);
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
				clickIntercept(web, 30);
				break;
			}

		}
		visbility(driver, pom.getInstanceSymptom().favoriteSymptom, 30);
		clear(pom.getInstanceSymptom().favoriteSymptom);
		sendkeys(pom.getInstanceSymptom().favoriteSymptom, "symptoms favorite kpop2");
		clickIntercept(pom.getInstanceSymptom().favoriteSave, 30);

		try {
			visbility(driver, pom.getInstanceSymptom().addThisFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addThisFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addThisFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceSymptom().closeFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().closeFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().closeFavorite, 30);
		}

		// $$$$$$procedure$$$$

		while (true) {
			if (pom.getInstanceProcedure().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProcedure().favoriteIcon, 40);
				clickIntercept(pom.getInstanceProcedure().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceProcedure().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProcedure().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceProcedure().addNewFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addNewFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addNewFavorite, 30);
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
				clickIntercept(web, 30);

				break;

			}

		}

		visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 60);
		sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure favorite");
		clickIntercept(pom.getInstanceProcedure().favoriteSave, 30);

		for (WebElement web : pom.getInstanceProcedure().favoriteSaveMore) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);

				break;
			}

		}

		try {

			visbility(driver, pom.getInstanceProcedure().editFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().editFavorite, 30);
		} catch (StaleElementReferenceException e) {

			visbility(driver, pom.getInstanceProcedure().editFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().editFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceProcedure().removeFavoriteCode, 30);
			clickIntercept(pom.getInstanceProcedure().removeFavoriteCode, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().removeFavoriteCode, 30);
			clickIntercept(pom.getInstanceProcedure().removeFavoriteCode, 30);

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
				clickIntercept(web, 30);

				break;

			}

		}

		visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 30);
		sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure kpop2 favorite");
		clickIntercept(pom.getInstanceProcedure().favoriteSave, 30);

		for (WebElement web : pom.getInstanceProcedure().favoriteSaveMore) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}

		try {
			visbility(driver, pom.getInstanceProcedure().addThisFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addThisFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceProcedure().closeFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().closeFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().closeFavorite, 30);
		}
		sleep(2000);
		//

		// $$$$$$$Goals

		while (true) {
			if (pom.getInstanceGoal().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceGoal().favoriteIcon, 30);
				clickIntercept(pom.getInstanceGoal().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceGoal().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceGoal().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceGoal().addNewFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().addNewFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addNewFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceGoal().favoritePellContent, 30);
			clickIntercept(pom.getInstanceGoal().favoritePellContent, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().favoritePellContent, 30);
			clickIntercept(pom.getInstanceGoal().favoritePellContent, 30);
		}
		visbility(driver, pom.getInstanceGoal().favoriteDiscription, 30);
		sendkeys(pom.getInstanceGoal().favoriteDiscription, "GOALS MODULE FAVORITE");
		clickIntercept(pom.getInstanceGoal().favoritesave, 30);

		sleep(1500);
		try {

			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addThisFavorite, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addThisFavorite, 30);
		}
		sleep(1500);
		try {

			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			clickIntercept(pom.getInstanceGoal().closeFavorite, 30);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			clickIntercept(pom.getInstanceGoal().closeFavorite, 30);
		}

		// $$$$$status

		while (true) {
			if (pom.getInstanceStatus().favoriteicon.isDisplayed()) {
				visbility(driver, pom.getInstanceStatus().favoriteicon, 30);
				clickIntercept(pom.getInstanceStatus().favoriteicon, 30);
				break;
			} else if (!pom.getInstanceStatus().favoriteicon.isDisplayed()) {
				actions("move to element", pom.getInstanceStatus().favoriteicon);
			}
		}

		try {

			visbility(driver, pom.getInstanceStatus().addNewFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().addNewFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addNewFavorite, 30);
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
				clickIntercept(we, 30);

				break;
			}

		}
		clickIntercept(pom.getInstanceStatus().favoriteSave, 30);

		sleep(1500);
		try {

			visbility(driver, pom.getInstanceStatus().editFavorite, 30);
			clickIntercept(pom.getInstanceStatus().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceStatus().editFavorite, 30);
			clickIntercept(pom.getInstanceStatus().editFavorite, 30);

		}

		try {
			visbility(driver, pom.getInstanceStatus().removeFavoriteCode, 60);
			clickIntercept(pom.getInstanceStatus().removeFavoriteCode, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().removeFavoriteCode, 60);
			clickIntercept(pom.getInstanceStatus().removeFavoriteCode, 30);
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
				clickIntercept(we, 30);
				break;
			}

		}

		clickIntercept(pom.getInstanceStatus().favoriteSave, 30);

		try {

			visbility(driver, pom.getInstanceStatus().addThisFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().addThisFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addThisFavorite, 30);
		}

		try {

			visbility(driver, pom.getInstanceStatus().closeFavorite, 30);
			clickIntercept(pom.getInstanceStatus().closeFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().closeFavorite, 30);
			clickIntercept(pom.getInstanceStatus().closeFavorite, 30);
		}

		// $$$$$$problems$$$$$$$

		Tc_010Problems.favoriteProblemAddIcon();

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
				clickIntercept(pom.getInstanceAdvanceDirective().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceAdvanceDirective().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAdvanceDirective().favoriteIcon);
			}

		}
		try {
			visbility(driver, pom.getInstanceAdvanceDirective().addNewFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().addNewFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addNewFavorite, 30);

		}

		visbility(driver, pom.getInstanceAdvanceDirective().favoriteStatusType, 30);
		dropDown("text", pom.getInstanceAdvanceDirective().favoriteStatusType, "Assessment");
		visbility(driver, pom.getInstanceAdvanceDirective().favoriteDiscription, 40);
		sendkeys(pom.getInstanceAdvanceDirective().favoriteDiscription, "Advance directives");
		clickIntercept(pom.getInstanceAdvanceDirective().favoriteSave, 30);

		sleep(1500);
		try {
			visbility(driver, pom.getInstanceAdvanceDirective().editFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceAdvanceDirective().editFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().editFavorite, 30);
		}

		visbility(driver, pom.getInstanceAdvanceDirective().favoriteDiscription, 40);
		clear(pom.getInstanceAdvanceDirective().favoriteDiscription);
		sendkeys(pom.getInstanceAdvanceDirective().favoriteDiscription, "Advance directives");
		clickIntercept(pom.getInstanceAdvanceDirective().favoriteSave, 30);

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().addThisFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().addThisFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().closeFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().closeFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().closeFavorite, 30);
		}

		// $$$$notes

		while (true) {
			if (pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceNotes().favoriteIcon, 40);
				clickIntercept(pom.getInstanceNotes().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceNotes().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			clickIntercept(pom.getInstanceNotes().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			clickIntercept(pom.getInstanceNotes().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
		sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes module");
		clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		try {

			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			clickIntercept(pom.getInstanceNotes().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			clickIntercept(pom.getInstanceNotes().editFavorite, 30);
		}
		try {
			visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
			clear(pom.getInstanceNotes().favoriteDiscription);
			sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
			clear(pom.getInstanceNotes().favoriteDiscription);
			sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");
		}
		try {
			clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		} catch (Exception e) {
			clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		}
		try {

			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			clickIntercept(pom.getInstanceNotes().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			clickIntercept(pom.getInstanceNotes().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			clickIntercept(pom.getInstanceNotes().closeFavorite, 30);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			clickIntercept(pom.getInstanceNotes().closeFavorite, 30);
		}

		// $$$physical exam
		while (true) {

			if (pom.getInstancePhysicalExam().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstancePhysicalExam().favoriteIcon, 40);
				clickIntercept(pom.getInstancePhysicalExam().favoriteIcon, 30);
				break;
			} else if (!pom.getInstancePhysicalExam().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstancePhysicalExam().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstancePhysicalExam().addNewFavorite, 40);
			clickIntercept(pom.getInstancePhysicalExam().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().addNewFavorite, 40);
			clickIntercept(pom.getInstancePhysicalExam().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");

		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");
		visbility(driver, pom.getInstancePhysicalExam().favoriteNotes, 30);
		sendkeys(pom.getInstancePhysicalExam().favoriteNotes, "Physical Examination modules");
		clickIntercept(pom.getInstancePhysicalExam().favoriteSave, 30);

		sleep(1500);
		try {
			visbility(driver, pom.getInstancePhysicalExam().editFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().editFavorite, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstancePhysicalExam().editFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().editFavorite, 30);
		}

		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		clear(pom.getInstancePhysicalExam().organItem);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");

		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		clear(pom.getInstancePhysicalExam().finding);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");
		clickIntercept(pom.getInstancePhysicalExam().favoriteSave, 30);

		try {
			visbility(driver, pom.getInstancePhysicalExam().addThisFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().addThisFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().addThisFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().addThisFavorite, 30);
		}
		sleep(2000);
		try {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().closeFavorite, 30);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().closeFavorite, 30);
		}
		sleep(2000);

		j.executeScript("window.scrollBy(0,-750)", "");
		try {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 30);
			clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 30);
			clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);
		}

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Show Timestamp")) {
				visbility(wd, web, 30);
				clickIntercept(web, 30);
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

				clickIntercept(createfollowup, 30);
				break;
			} catch (Exception e) {
				WebElement createfollowup = driver.findElement(By.xpath("(//button[@id='followUpAdd'])[1]/div[1]"));

				clickIntercept(createfollowup, 30);
			}
		}
		sleep(4000);
		implicitWait(30, TimeUnit.SECONDS);
		WebElement crt = driver
				.findElement(By.xpath("//div[@id='followupEhr']/div[2]/div[3]/div[1]//following::div[2]/input"));
		clickIntercept(crt, 30);
		// actions("click", crt);
		sleep(2000);
		WebElement folowypyr = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		dropDown("text", folowypyr, "2023");
		WebElement folowupmnth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		dropDown("text", folowupmnth, "Dec");
		driver.findElement(By.xpath("(//a[text()='31'])")).click();
		WebElement fixappo = driver.findElement(By.xpath("(//button[@id='fixAppointment'])[1]"));

		sleep(3000);
		clickIntercept(fixappo, 30);

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
					clickIntercept(checkcn, 30);
					break;

				}

			}
			if (b == true) {
				WebElement $foloupBtn = driver
						.findElement(By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]"));
				visbility(driver, $foloupBtn, 40);
				clickIntercept($foloupBtn, 30);
				List<WebElement> $followupDropButton = driver.findElements(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::ul[1]/li/a"));
				for (WebElement webElement : $followupDropButton) {

					if (webElement.getText().equals("Emergency")) {

						visbility(driver, webElement, 60);
						clickIntercept(webElement, 30);
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
				clickIntercept(delfolup, 30);
				WebElement bckfl = driver.findElement(By.xpath("//div[@id='followupEhr']/div[1]/div/span[1]"));
				clickIntercept(bckfl, 30);
				break;
			}
		}

		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			WebElement delehrf = driver.findElement(By.xpath("(//button[contains(@title,'Delete Health Record')])[1]"));
			clickIntercept(delehrf, 30);
			sleep(2000);
			WebElement zr = driver
					.findElement(By.xpath("//span[text()='Delete Health Record']//following::div[4]/button[2]"));
			clickIntercept(zr, 30);
		}
		sleep(4000);
	}

	@Test(priority = 3, groups = "calendar")

	public void calendar() throws Exception {

		cal.caledarModule();

		Calendar_Test.bookAppointment();

		/*
		 * $current = driver.getCurrentUrl(); System.out.println($current);
		 * cal.$dayDrop($current); cal.$calenderMod($current, kpid);
		 */

	}

	@Test(priority = 4, groups = "billing")
	public void BillingModule() throws InterruptedException {

		visbility(driver, pom.getInstanceBilling().clickBill, 60);

		clickIntercept(pom.getInstanceBilling().clickBill, 30);

		driver.navigate().refresh();
		implicitWait(50, TimeUnit.SECONDS);
		sleep(3000);

		try {
			visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
			clickIntercept(pom.getInstanceBilling().clickCreateNewBill, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
			clickIntercept(pom.getInstanceBilling().clickCreateNewBill, 30);
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
		clickIntercept(pom.getInstanceBilling().saveItem, 30);
		sleep(3000);

		try {

			visbility(driver, pom.getInstanceBilling().favoriteItemServiceUi, 40);
			clickIntercept(pom.getInstanceBilling().favoriteItemServiceUi, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceBilling().favoriteItemServiceUi, 40);
			clickIntercept(pom.getInstanceBilling().favoriteItemServiceUi, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 40);
			clickIntercept(pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 30);
		} catch (StaleElementReferenceException e) {

			visbility(driver, pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 60);
			clickIntercept(pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 30);
		}

		visbility(driver, pom.getInstanceBilling().favoriteItemServiceDiscription, 60);
		sendkeys(pom.getInstanceBilling().favoriteItemServiceDiscription, "Kaaspro");

		visbility(driver, pom.getInstanceBilling().favoriteItemServicePriceField, 60);
		sendkeys(pom.getInstanceBilling().favoriteItemServicePriceField, "3");

		visbility(driver, pom.getInstanceBilling().favoriteItemServiceSave, 60);
		clickIntercept(pom.getInstanceBilling().favoriteItemServiceSave, 30);

		sleep(2500);

		try {

			clickIntercept(pom.getInstanceBilling().addFavoriteItemserviceToBillList, 30);
		} catch (Exception e) {
			clickIntercept(pom.getInstanceBilling().addFavoriteItemserviceToBillList, 30);

		}

		try {

			visbility(driver, pom.getInstanceBilling().editFavoriteItemservice, 60);
			clickIntercept(pom.getInstanceBilling().editFavoriteItemservice, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().editFavoriteItemservice, 60);
			clickIntercept(pom.getInstanceBilling().editFavoriteItemservice, 30);
		}

		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().deleteFavoriteItemService, 60);
			clickIntercept(pom.getInstanceBilling().deleteFavoriteItemService, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().deleteFavoriteItemService, 60);
			clickIntercept(pom.getInstanceBilling().deleteFavoriteItemService, 30);
		}

		sleep(2500);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			try {

				visbility(driver, pom.getInstanceBilling().favoriteItemseriveCodeUi, 60);

				clickIntercept(pom.getInstanceBilling().favoriteItemseriveCodeUi, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().favoriteItemseriveCodeUi, 60);

				clickIntercept(pom.getInstanceBilling().favoriteItemseriveCodeUi, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().itemServiceCodeAddIcon, 60);

				clickIntercept(pom.getInstanceBilling().itemServiceCodeAddIcon, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemServiceCodeAddIcon, 60);

				clickIntercept(pom.getInstanceBilling().itemServiceCodeAddIcon, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().enterItemServiceCode, 60);
				sendkeys(pom.getInstanceBilling().enterItemServiceCode, "product001");

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().enterItemServiceCode, 60);
				sendkeys(pom.getInstanceBilling().enterItemServiceCode, "product001");
			}

			visbility(driver, pom.getInstanceBilling().itemserviceCodeDiscription, 60);
			sendkeys(pom.getInstanceBilling().itemserviceCodeDiscription, "sr");

			visbility(driver, pom.getInstanceBilling().itemservicecodePrice, 60);
			sendkeys(pom.getInstanceBilling().itemservicecodePrice, "5");

			try {

				visbility(driver, pom.getInstanceBilling().itemservicecodeSave, 60);
				clickIntercept(pom.getInstanceBilling().itemservicecodeSave, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceBilling().itemservicecodeSave, 60);
				clickIntercept(pom.getInstanceBilling().itemservicecodeSave, 30);
			}

			sleep(2000);

			try {

				visbility(driver, pom.getInstanceBilling().itemservicecodeAddToBillList, 60);

				clickIntercept(pom.getInstanceBilling().itemservicecodeAddToBillList, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemservicecodeAddToBillList, 60);

				clickIntercept(pom.getInstanceBilling().itemservicecodeAddToBillList, 30);
			}

			sleep(2000);

			try {

				visbility(driver, pom.getInstanceBilling().itemservicecodeEdit, 60);

				clickIntercept(pom.getInstanceBilling().itemservicecodeEdit, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemservicecodeEdit, 60);

				clickIntercept(pom.getInstanceBilling().itemservicecodeEdit, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().itemservicecodeDelete, 60);

				clickIntercept(pom.getInstanceBilling().itemservicecodeDelete, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemservicecodeDelete, 60);

				clickIntercept(pom.getInstanceBilling().itemservicecodeDelete, 30);

			}

			sleep(2000);

			// service/charge tax..

			try {

				visbility(driver, pom.getInstanceBilling().itemservicechargesUi, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesUi, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemservicechargesUi, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesUi, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().itemservicechargesAddIcon, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesAddIcon, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceBilling().itemservicechargesAddIcon, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesAddIcon, 30);
			}

			visbility(driver, pom.getInstanceBilling().itemservicechargesDiscription, 60);
			sendkeys(pom.getInstanceBilling().itemservicechargesDiscription, "service charge<>");

			visbility(driver, pom.getInstanceBilling().itemservicechargesPrice, 60);
			sendkeys(pom.getInstanceBilling().itemservicechargesPrice, "5");
			try {

				visbility(driver, pom.getInstanceBilling().itemservicechargesSave, 60);
				clickIntercept(pom.getInstanceBilling().itemservicechargesSave, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceBilling().itemservicechargesSave, 60);
				clickIntercept(pom.getInstanceBilling().itemservicechargesSave, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().itemservicechargesAddToBillList, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesAddToBillList, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceBilling().itemservicechargesAddToBillList, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesAddToBillList, 30);
			}

			sleep(2000);

			try {

				visbility(driver, pom.getInstanceBilling().itemservicechargesEdit, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesEdit, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemservicechargesEdit, 60);

				clickIntercept(pom.getInstanceBilling().itemservicechargesEdit, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().itemservicechargesDelete, 60);
				clickIntercept(pom.getInstanceBilling().itemservicechargesDelete, 30);
			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().itemservicechargesDelete, 60);
				clickIntercept(pom.getInstanceBilling().itemservicechargesDelete, 30);
			}

			sleep(2000);

			// discount..

			try {

				visbility(driver, pom.getInstanceBilling().discountUi, 60);

				clickIntercept(pom.getInstanceBilling().discountUi, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().discountUi, 60);

				clickIntercept(pom.getInstanceBilling().discountUi, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().discountAddIcon, 60);

				clickIntercept(pom.getInstanceBilling().discountAddIcon, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().discountAddIcon, 60);

				clickIntercept(pom.getInstanceBilling().discountAddIcon, 30);
			}

			visbility(driver, pom.getInstanceBilling().discountDiscription, 60);
			sendkeys(pom.getInstanceBilling().discountDiscription, "Discnt");

			visbility(driver, pom.getInstanceBilling().discountType, 60);
			clickIntercept(pom.getInstanceBilling().discountType, 30);

			for (WebElement we : pom.getInstanceBilling().discountDropDown) {
				if (we.getText().trim().equals("Percentage Discount")) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);
					break;
				}

			}

			visbility(driver, pom.getInstanceBilling().discountPercentage, 60);
			sendkeys(pom.getInstanceBilling().discountPercentage, "5");
			try {

				visbility(driver, pom.getInstanceBilling().saveDiscount, 60);
				clickIntercept(pom.getInstanceBilling().saveDiscount, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceBilling().saveDiscount, 60);
				clickIntercept(pom.getInstanceBilling().saveDiscount, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().addDiscountToBillList, 60);
				clickIntercept(pom.getInstanceBilling().addDiscountToBillList, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().addDiscountToBillList, 60);
				clickIntercept(pom.getInstanceBilling().addDiscountToBillList, 30);
			}
			sleep(2000);

			try {

				visbility(driver, pom.getInstanceBilling().editDiscount, 60);

				clickIntercept(pom.getInstanceBilling().editDiscount, 30);

			} catch (Exception e) {

				visbility(driver, pom.getInstanceBilling().editDiscount, 60);

				clickIntercept(pom.getInstanceBilling().editDiscount, 30);
			}

			try {

				visbility(driver, pom.getInstanceBilling().deleteDiscount, 60);
				clickIntercept(pom.getInstanceBilling().deleteDiscount, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceBilling().deleteDiscount, 60);
				clickIntercept(pom.getInstanceBilling().deleteDiscount, 30);
			}

		}
		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().addPayment, 60);
			clickIntercept(pom.getInstanceBilling().addPayment, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().addPayment, 60);
			clickIntercept(pom.getInstanceBilling().addPayment, 30);
		}

		visbility(driver, pom.getInstanceBilling().selectPayment, 60);
		clickIntercept(pom.getInstanceBilling().selectPayment, 30);
		sleep(2000);

		for (WebElement w : pom.getInstanceBilling().selectPayemntDropdown) {
			if (w.getText().trim().equals("Cash Payment")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceBilling().paymentDiscription, 60);
		clickIntercept(pom.getInstanceBilling().paymentDiscription, 30);
		sleep(2000);
		sendkeys(pom.getInstanceBilling().paymentDiscription, "CASH PAYMENT DONE");

		try {

			visbility(driver, pom.getInstanceBilling().makePayment, 60);
			clickIntercept(pom.getInstanceBilling().makePayment, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().makePayment, 60);
			clickIntercept(pom.getInstanceBilling().makePayment, 30);
		}

		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().finalizBill, 60);

			clickIntercept(pom.getInstanceBilling().finalizBill, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().finalizBill, 60);

			clickIntercept(pom.getInstanceBilling().finalizBill, 30);
		}

		sleep(2000);

		visbility(driver, pom.getInstanceBilling().finalizeBillConfirmationKpop, 60);

		clickIntercept(pom.getInstanceBilling().finalizeBillConfirmationKpop, 30);
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			visbility(driver, pom.getInstanceBilling().deleteInvoice, 60);
			clickIntercept(pom.getInstanceBilling().deleteInvoice, 30);
			sleep(2000);

			visbility(driver, pom.getInstanceBilling().deleteInvoiceConfirmationKpop, 60);
			clickIntercept(pom.getInstanceBilling().deleteInvoiceConfirmationKpop, 30);
		}
		sleep(2000);

		clickIntercept(pom.getInstanceBilling().clickBill, 30);

		driver.navigate().refresh();

		try {

			visbility(driver, pom.getInstanceBilling().searchPatientBy, 60);
			sendkeys(pom.getInstanceBilling().searchPatientBy, kpid);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().searchPatientBy, 60);
			sendkeys(pom.getInstanceBilling().searchPatientBy, kpid);
		}

		sleep(2000);

		for (WebElement we : pom.getInstanceBilling().searchPatientDropdown) {
			if (we.getText().trim().equals(kpid)) {
				visbility(driver, we, 60);
				clickIntercept(we, 30);
				break;
			}

		}
		visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
		clickIntercept(pom.getInstanceBilling().clickCreateNewBill, 30);

		sleep(2000);
		visbility(driver, pom.getInstanceBilling().addItem, 60);
		clickIntercept(pom.getInstanceBilling().addItem, 30);
		sleep(2000);
		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo");
		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		sendkeys(pom.getInstanceBilling().addPrice, "10");
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		clear(pom.getInstanceBilling().addQuantity);
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		sendkeys(pom.getInstanceBilling().addQuantity, "2");
		sleep(3000);
		visbility(driver, pom.getInstanceBilling().saveItem, 60);
		clickIntercept(pom.getInstanceBilling().saveItem, 30);
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
		clickIntercept(pom.getInstanceTeleDoctor().clickTeleDoctor, 30);

		WebElement np1 = driver.findElement(By.xpath("//button[@title='Create new Patinet']"));

		clickIntercept(np1, 30);

		WebElement np2 = driver.findElement(By.id("firstname"));
		visbility(driver, np2, 60);
		sendkeys(np2, "Ayyyyyi");
		WebElement np3 = driver.findElement(By.id("lastname"));
		visbility(driver, np3, 60);
		sendkeys(np3, "ghghgjg");
		WebElement gn1 = driver.findElement(By.xpath("(//button[@id='gender_dropdown'])[1]"));
		visbility(driver, gn1, 60);
		clickIntercept(gn1, 30);

		List<WebElement> jj = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));
		for (WebElement w : jj) {
			if (w.getText().trim().equals("Male")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		clickIntercept(pom.getInstanceHomeModule().selectFlagPhoneNumField, 30);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				visbility(driver, flag, 30);
				clickIntercept(flag, 30);
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));

		WebElement cp1 = driver.findElement(By.xpath("//div[@id='createPatient']"));
		visbility(driver, cp1, 60);
		clickIntercept(cp1, 30);

		implicitWait(30, TimeUnit.SECONDS);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			clickIntercept(pom.getInstanceNewPatient().deletePatient, 30);

			WebElement $delpat$ = driver.findElement(By.xpath("//button[text()='Delete']"));
			clickIntercept($delpat$, 30);

		}

		try {
			clickIntercept(pom.getInstanceTeleDoctor().clickTeleDoctor, 30);
		} catch (StaleElementReferenceException e) {
			clickIntercept(pom.getInstanceTeleDoctor().clickTeleDoctor, 30);
		}
		refresh();

		visbility(driver, pom.getInstanceTeleDoctor().searchPatient, 60);
		sendkeys(pom.getInstanceTeleDoctor().searchPatient, kpid);

		try {
			WebElement pstl = driver.findElement(By.xpath("//td[@id='nameh']//following::td[1]"));
			visbility(driver, pstl, 60);
			clickIntercept(pstl, 30);
		} catch (StaleElementReferenceException e) {
			WebElement pstl = driver.findElement(By.xpath("//td[@id='nameh']//following::td[1]"));
			visbility(driver, pstl, 60);
			clickIntercept(pstl, 30);
		}

		try {
			WebElement clickpatie = driver.findElement(By.xpath("(//div[@title='Click to view'])[5]/div"));

			visbility(driver, clickpatie, 60);
			clickIntercept(clickpatie, 30);
		} catch (StaleElementReferenceException e) {
			WebElement clickpatie = driver.findElement(By.xpath("(//div[@title='Click to view'])[5]/div"));

			visbility(driver, clickpatie, 60);
			clickIntercept(clickpatie, 30);
		}

	}

	@Test(priority = 6, groups = "message")
	public void Message() throws InterruptedException {

		clickIntercept(pom.getInstanceMessage().clickMessage, 30);
		clickIntercept(pom.getInstanceMessage().clickComposemMessage, 30);

		try {
			visbility(driver, pom.getInstanceMessage().search, 40);
			sendkeys(pom.getInstanceMessage().search, kpid);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceMessage().search, 40);
			sendkeys(pom.getInstanceMessage().search, kpid);
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
				if (msg.isDisplayed()) {
					clickIntercept(msg, 30);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		visbility(driver, pom.getInstanceMessage().enterSubject, 60);
		sendkeys(pom.getInstanceMessage().enterSubject, "GOOD MORNING");

		sendkeys(pom.getInstanceMessage().enterMessage, "hello welcome to chennai");
		visbility(driver, pom.getInstanceMessage().sendMessage, 60);
		clickIntercept(pom.getInstanceMessage().sendMessage, 30);
		sleep(2500);

		visbility(driver, pom.getInstanceMessage().seeSentMessage, 60);
		clickIntercept(pom.getInstanceMessage().seeSentMessage, 30);

		sleep(3000);

		WebElement $msgtext = driver.findElement(By.xpath("(//div[text()='hello welcome to chennai'])[1]"));
		visbility(driver, $msgtext, 60);
		clickIntercept($msgtext, 30);

		WebElement $del = driver.findElement(By.xpath("(//span[@id='msg-del-btn'])[2]"));

		System.out.println("MESSAGE FIND");
		visbility(driver, $del, 30);
		clickIntercept($del, 30);

		WebElement $delmsgTickIcon = driver.findElement(By.xpath("(//span[@id='msg-del-btn'])[2]//following::span[1]"));

		clickIntercept($delmsgTickIcon, 30);

		WebElement $showFavMesageKpopIcon = driver
				.findElement(By.xpath("//div[@id='message_list']/div[1]/div[1]/div[2]/i"));

		visbility(driver, $showFavMesageKpopIcon, 30);
		clickIntercept($showFavMesageKpopIcon, 30);

		WebElement $favmsgAddicon = driver
				.findElement(By.xpath("//div[@id='MessageFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
		visbility(driver, $favmsgAddicon, 60);
		clickIntercept($favmsgAddicon, 30);

		WebElement $msgTextbox = driver.findElement(By.xpath("//textarea[@id='message1']"));
		visbility(driver, $msgTextbox, 40);
		sendkeys($msgTextbox, "FAVORITE MESSAGE KPOP");

		WebElement $savefavmsg = driver.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
		visbility(driver, $savefavmsg, 40);
		clickIntercept($savefavmsg, 30);

		try {
			WebElement $addfavMsgToListIcon = driver.findElement(
					By.xpath("(//div[text()='FAVORITE MESSAGE KPOP'])[1]//parent::div[1]//parent::div[1]/div/span"));
			visbility(driver, $addfavMsgToListIcon, 40);
			clickIntercept($addfavMsgToListIcon, 30);
		} catch (StaleElementReferenceException e) {
			WebElement $addfavMsgToListIcon = driver.findElement(
					By.xpath("(//div[text()='FAVORITE MESSAGE KPOP'])[1]//parent::div[1]//parent::div[1]/div/span"));
			visbility(driver, $addfavMsgToListIcon, 40);
			clickIntercept($addfavMsgToListIcon, 30);
		}

		visbility(driver, pom.getInstanceMessage().search, 40);
		sendkeys(pom.getInstanceMessage().search, kpid);

		sleep(2000);

		WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
		visbility(driver, msg, 30);
		clickIntercept(msg, 30);

		clickIntercept(pom.getInstanceMessage().sendMessage, 30);

	}

	@Test(priority = 7, groups = "settings")
	public void Settings() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);

		clickIntercept(pom.getInstanceSetting().basicInfoEditIcon, 30);

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			System.out.println("ENTER HOSPITAL NAME");
			visbility(driver, pom.getInstanceSetting().hosipitalName, 40);
			clear(pom.getInstanceSetting().hosipitalName);
			sendkeys(pom.getInstanceSetting().hosipitalName, "75health organisation");
			clickIntercept(pom.getInstanceSetting().basicInfoTitle, 30);

			for (WebElement choose : pom.getInstanceSetting().basicInfoTitleDropdown) {
				if (choose.getText().trim().equals("Dr")) {

					visbility(driver, choose, 60);
					clickIntercept(choose, 30);

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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			clickIntercept(pom.getInstanceSetting().basicInfoAdminstatus, 30);

			for (WebElement status : pom.getInstanceSetting().basicInfoAdminstatusDropdown) {
				if (status.getText().trim().equals("ACTIVE")) {
					visbility(driver, status, 40);
					clickIntercept(status, 30);

					break;
				}

			}

			clickIntercept(pom.getInstanceSetting().basicInfoSmsNotication, 30);

			for (WebElement web : pom.getInstanceSetting().basicInfoSmsNoticationDropdown) {
				if (web.getText().trim().equals("ON")) {
					visbility(driver, web, 60);
					clickIntercept(web, 30);

					break;
				}

			}
			clickIntercept(pom.getInstanceSetting().basicInfoSave, 30);

		} else {

			clickIntercept(pom.getInstanceSetting().basicInfoSavedrLogin, 30);
		}
		log.info("basic info saved");
		sleep(1000);

		// Contact info..
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			try {
				visbility(driver, pom.getInstanceSetting().conatctInfoEditIcon, 40);
				clickIntercept(pom.getInstanceSetting().conatctInfoEditIcon, 30);

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
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			try {

				visbility(driver, pom.getInstanceSetting().specialtyAddIcon, 40);
				clickIntercept(pom.getInstanceSetting().specialtyAddIcon, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().specialtyAddIcon, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcon);
				click(pom.getInstanceSetting().specialtyAddIcon);
			}
		} else if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")) {
			try {

				visbility(driver, pom.getInstanceSetting().specialtyAddIcondrLogin, 40);
				clickIntercept(pom.getInstanceSetting().specialtyAddIcondrLogin, 30);

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
			clickIntercept(pom.getInstanceSetting().patientInfoeditIcon, 30);

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
		} else if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("user")) {
			elementClickable(pom.getInstanceSetting().patientInfoSavedrLogin);
			click(pom.getInstanceSetting().patientInfoSavedrLogin);
		}

		navigateback(1);
		log.info("back t0 settings");

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
		 * if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().
		 * equalsIgnoreCase("admin")) { try { visbility(driver,
		 * pom.getInstanceSetting().manageuser, 40);
		 * clickIntercept(pom.getInstanceSetting().manageuser, 30);
		 * 
		 * log.info("manage user clicked"); } catch (Exception e) { visbility(driver,
		 * pom.getInstanceSetting().manageuser, 40);
		 * elementClickable(pom.getInstanceSetting().manageuser);
		 * click(pom.getInstanceSetting().manageuser); log.info("manage user clicked");
		 * } try {
		 * 
		 * visbility(driver, pom.getInstanceSetting().manageuserAddNewUser, 60);
		 * clickIntercept(pom.getInstanceSetting().manageuserAddNewUser, 30);
		 * 
		 * } catch (ElementClickInterceptedException e) {
		 * 
		 * visbility(driver, pom.getInstanceSetting().manageuserAddNewUser, 60);
		 * elementClickable(pom.getInstanceSetting().manageuserAddNewUser);
		 * click(pom.getInstanceSetting().manageuserAddNewUser); } visbility(driver,
		 * pom.getInstanceSetting().MangerUserFirstName, 30);
		 * sendkeys(pom.getInstanceSetting().MangerUserFirstName, "KAASPRO");
		 * visbility(driver, pom.getInstanceSetting().ManageUserLastNmae, 30);
		 * sendkeys(pom.getInstanceSetting().ManageUserLastNmae, "ENTERPRISES");
		 * 
		 * String random = RandomStringUtils.randomAlphabetic(25); visbility(driver,
		 * pom.getInstanceSetting().manageuserEmailId, 30);
		 * sendkeys(pom.getInstanceSetting().manageuserEmailId, random + "@gmail.com");
		 * try {
		 * 
		 * elementClickable(pom.getInstanceSetting().manageUserType);
		 * clickIntercept(pom.getInstanceSetting().manageUserType, 30); } catch
		 * (ElementClickInterceptedException e) {
		 * elementClickable(pom.getInstanceSetting().manageUserType);
		 * clickIntercept(pom.getInstanceSetting().manageUserType, 30); } for
		 * (WebElement web : pom.getInstanceSetting().manageUserTypeDrop) { if
		 * (web.getText().trim().equals("Standard User")) { visbility(driver, web, 60);
		 * elementClickable(web); clickIntercept(web, 30); break; }
		 * 
		 * }
		 * 
		 * clickIntercept(pom.getInstanceSetting().createuser, 30);
		 * 
		 * while (true) { if
		 * (driver.getCurrentUrl().equals("https://localhost:8443/health/#user")) {
		 * break; } else if
		 * (driver.getCurrentUrl().equals("https://www.75health.com/health/#user")) {
		 * break; } else if
		 * (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#user"))
		 * { break; } }
		 * 
		 * if (url.equals("https://localhost:8443/")) {
		 * driver.navigate().to("https://localhost:8443/health/#setting");
		 * 
		 * } else if (url.equals("https://www.75health.com/login.jsp")) {
		 * driver.navigate().to("https://www.75health.com/health/#setting"); } else if
		 * (url.equals("https://www.test.75health.com/")) {
		 * driver.navigate().to("https://www.test.75health.com/health/#setting"); } }
		 */

		// manage Branding (enterprise)
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().equalsIgnoreCase("premium70")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			visbility(driver, pom.getInstanceSetting().manageBrandingClick, 40);
			clickIntercept(pom.getInstanceSetting().manageBrandingClick, 30);

			visbility(driver, pom.getInstanceSetting().manageBrandingOrgNameDiscription, 30);
			clear(pom.getInstanceSetting().manageBrandingOrgNameDiscription);
			sendkeys(pom.getInstanceSetting().manageBrandingOrgNameDiscription, "75 Health Organisation");

			clickIntercept(pom.getInstanceSetting().manageBrandingSetName, 30);

			clickIntercept(pom.getInstanceSetting().manageBrandingEmailPreview, 30);

			for (WebElement mb : pom.getInstanceSetting().manageBrandingEmailPreviewDropdown) {
				System.out.println(mb);

				if (mb.getText().trim().equals("Patient Account Creation")
						| mb.getText().trim().equals("Patient Account Re-Activation")
						| mb.getText().trim().equals("Doctor appointment send patient")
						| mb.getText().trim().equals("Doctor appointment cancel")
						| mb.getText().trim().equals("Doctor appointment reject")
						| mb.getText().trim().equals("Appointment request send patient")
						| mb.getText().trim().equals("Patient referral notification")
						| mb.getText().trim().equals("Patient lab detail email")
						| mb.getText().trim().equals("Patient pharmacy detail email")
						| mb.getText().trim().equals("Completed health record")) {
					visbility(driver, mb, 40);
					clickIntercept(mb, 30);

					sleep(2000);

					clickIntercept(pom.getInstanceSetting().manageBrandingPreviewClick, 30);
					sleep(2000);
					clickIntercept(pom.getInstanceSetting().manageBrandingCancelWindow, 30);
					sleep(2000);
					clickIntercept(pom.getInstanceSetting().manageBrandingEmailPreview, 30);
				}

			}
			navigateback(1);
		}
		for (WebElement w : pom.getInstanceSetting().autoLogoutDrop) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);

				break;
			}

		}
		sleep(1000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			clickIntercept(pom.getInstanceSetting().hospitalServiceChargeTaxclick, 30);

			visbility(driver, pom.getInstanceSetting().hospitalServiceChargeTaxdropclick, 40);

			clickIntercept(pom.getInstanceSetting().hospitalServiceChargeTaxdropclick, 30);

			visbility(driver, pom.getInstanceSetting().hospitalTaxAddnewTax, 30);

			clickIntercept(pom.getInstanceSetting().hospitalTaxAddnewTax, 30);

			visbility(driver, pom.getInstanceSetting().hospitalTaxdiscription, 30);
			sendkeys(pom.getInstanceSetting().hospitalTaxdiscription, "DK");

			visbility(driver, pom.getInstanceSetting().hospitalTaxPercentage, 30);
			sendkeys(pom.getInstanceSetting().hospitalTaxPercentage, "5");

			clickIntercept(pom.getInstanceSetting().hospitaltaxSave, 30);

			try {
				visbility(driver, pom.getInstanceSetting().editHospitalTax, 30);
				clickIntercept(pom.getInstanceSetting().editHospitalTax, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().editHospitalTax, 30);
				clickIntercept(pom.getInstanceSetting().editHospitalTax, 30);
			}

			try {
				visbility(driver, pom.getInstanceSetting().deleteHospitalTAX, 30);
				clickIntercept(pom.getInstanceSetting().deleteHospitalTAX, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().deleteHospitalTAX, 30);
				clickIntercept(pom.getInstanceSetting().deleteHospitalTAX, 30);
			}

			visbility(driver, pom.getInstanceSetting().closeHospitalTax, 30);
			clickIntercept(pom.getInstanceSetting().closeHospitalTax, 30);

		}
		sleep(2500);
		// cds

		visbility(driver, pom.getInstanceSetting().cdsClick, 30);

		clickIntercept(pom.getInstanceSetting().cdsClick, 30);

		visbility(driver, pom.getInstanceSetting().addnewCds, 30);
		clickIntercept(pom.getInstanceSetting().addnewCds, 30);

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
		clickIntercept(pom.getInstanceSetting().cdsCheckbox, 30);

		clickIntercept(pom.getInstanceSetting().saveCds, 30);

		sleep(3000);

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);

		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		sleep(1000);
		ScriptExecutor(pom.getInstanceSetting().cdsClick);

		// Set Favorities..

		visbility(driver, pom.getInstanceSetting().setFavoritesClick, 40);
		clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

		for (WebElement w : pom.getInstanceSetting().setFavoriteListDrop) {
			if (w.getText().trim().equals("Item/service")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDiscription, 60);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServiceDiscription, "test");
				visbility(driver, pom.getInstanceSetting().setFavoritesItemServicePrice, 40);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServicePrice, "5");

				clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceEdit, 40);
					/* elementClickable(pom.getInstanceSetting().setFavoritesItemServiceEdit); */
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceEdit, 30);

				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceEdit);
					click(pom.getInstanceSetting().setFavoritesItemServiceEdit);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
				}

				try {

					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceClose, 30);
				} catch (Exception e) {
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceClose, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().contentEquals("Message")) {
				visbility(driver, w, 40);
				clickIntercept(w, 30);

				try {

					visbility(driver, pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
				}
				visbility(driver, pom.getInstanceSetting().setFavoritesMessageDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesMessageDiscription, "hello");

				clickIntercept(pom.getInstanceSetting().setFavoritesMessageSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageEdit, 30);

					clickIntercept(pom.getInstanceSetting().setFavoritesMessageEdit, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageEdit, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageEdit, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageDelete, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageDelete, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageClose, 40);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageClose, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageClose, 40);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageClose, 30);
				}

			} else if (w.getText().trim().equals("Symptoms")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesSymptomsIcd, "test");

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
						clickIntercept(web, 30);
						break;
					}

				}

				visbility(driver, pom.getInstanceSetting().setFavoritesSymotomsdiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesSymotomsdiscription, "Symptoms");

				clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsedit, 30);

				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
			} else if (w.getText().trim().equals("Problems")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteProblemsIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteProblemsIcd, "test");
				sleep(2000);
				clickIntercept(pom.getInstanceSetting().setFavoriteProblemsIcd, 30);
				try {

					Tc_010Problems.$favproblemsIcdCode();
				} catch (Exception e) {

					e.printStackTrace();
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteProblemsDiscription, "Problems");

				clickIntercept(pom.getInstanceSetting().setFavoriteProblemsSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceProblems().editFavorite, 30);

					clickIntercept(pom.getInstanceProblems().editFavorite, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceProblems().editFavorite, 30);
					clickIntercept(pom.getInstanceProblems().editFavorite, 30);
				}
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsDelete, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsClose, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsClose, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
			} else if (w.getText().trim().equals("Visit Reason")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);
				try {

					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 30);

				} catch (Exception e) {

					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 30);
				}
				ww.until(ExpectedConditions
						.elementToBeClickable(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav));
				clickIntercept(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav, 30);

				for (WebElement Element : pom.getInstanceSetting().setFavoriteVisitReasonTypeDrop) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						visbility(driver, Element, 30);
						clickIntercept(Element, 30);
						break;
					}

				}

				visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonDiscription, 40);
				sendkeys(pom.getInstanceSetting().setFavoriteVisitReasonDiscription, "VisitReason");

				clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonEdit, 40);

					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonEdit, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasondelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("Procedure")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureAddIcon, 30);
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
						clickIntercept(web, 30);
						break;

					}

				}

				visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 40);
				sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure");

				clickIntercept(pom.getInstanceSetting().setFavoriteProcedureSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureEdit, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteProcedureDelete, 30);
				visbility(driver, pom.getInstanceSetting().setFavoriteProcedureClose, 40);

				clickIntercept(pom.getInstanceSetting().setFavoriteProcedureClose, 30);
				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("djfhjdfhjdfh")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
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

						visbility(driver, we, 60);
						clickIntercept(we, 30);
						break;

					}

				}

				clickIntercept(pom.getInstanceSetting().setFavoriteMedicationSave, 30);
				if (url.equals("https://www.75health.com/login.jsp")) {
					try {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
						clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
						clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
					}
				} else if (url.equals("https://localhost:8443/")) {

					try {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
						clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
						clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
					}
				} else if (url.equals("https://www.test.75health.com/")) {
					try {
						visbility(driver, pom.getInstanceSetting().setFAoriteeditTestSer, 30);
						clickIntercept(pom.getInstanceSetting().setFAoriteeditTestSer, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceSetting().setFAoriteeditTestSer, 30);
						clickIntercept(pom.getInstanceSetting().setFAoriteeditTestSer, 30);
					}

				}

				clickIntercept(pom.getInstanceSetting().setFavoriteMedicationDelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteMedicationClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("Test Order")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
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
						clickIntercept(test, 30);
						break;
					}
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderEdit, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderDelete, 30);

				visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderClose, 50);

				clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("Vaccine")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVaccineAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVaccineAddIcon, 30);
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
						clickIntercept(web, 30);
						break;
					}

				}
				visbility(driver, pom.getInstanceSetting().setFavoriteVaccineDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteVaccineDiscription, "vaccine");

				clickIntercept(pom.getInstanceVaccine().favoriteSave, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVaccineEdit, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVaccineEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteVaccinedelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteVaccineClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
			} else if (w.getText().trim().equals("Goals")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
				}
				visbility(driver, pom.getInstanceSetting().setFavoriteGoalDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteGoalDiscription, "goals");

				clickIntercept(pom.getInstanceSetting().setFavoriteGoalSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalEdit, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteGoalDelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteGoalClose, 30);

			}

		}

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
			clickIntercept(pom.getInstanceSetting().customForm, 30);
			sleep(5000);

			visbility(driver, pom.getInstanceSetting().addNewform, 60);
			clickIntercept(pom.getInstanceSetting().addNewform, 30);
			// actions("click", pom.getInstanceSetting().addNewform);

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
					clickIntercept(pom.getInstanceSetting().saveForm, 30);

					sleep(3000);

					break;
				}

			}
			refresh();

		}
		// sleep(3000); // edit preference....

		visbility(driver, pom.getInstanceSetting().printSettingsClick, 60);
		clickIntercept(pom.getInstanceSetting().printSettingsClick, 30);
		sleep(3000);

		visbility(driver, pom.getInstanceSetting().cancelPrintpreference, 60);
		clickIntercept(pom.getInstanceSetting().cancelPrintpreference, 30);

		visbility(driver, pom.getInstanceSetting().resetSettingClick, 60);
		clickIntercept(pom.getInstanceSetting().resetSettingClick, 30);

		visbility(driver, pom.getInstanceSetting().confirmResetSetting, 60);
		clickIntercept(pom.getInstanceSetting().confirmResetSetting, 30);

		sleep(3000);

		// notification

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			boolean b = true;
			while (b) {

				if (!pom.getInstanceSetting().customizeMessage.isDisplayed()) {

					elementClickable(pom.getInstanceSetting().customizeToggle);
					actions("click", pom.getInstanceSetting().customizeToggle);

					clickIntercept(pom.getInstanceSetting().customizeMessage, 30);

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
						clickIntercept(pom.getInstanceSetting().clickSettings, 30);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
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

			visbility(driver, pom.getInstanceSetting().clickSettings, 60);
			clickIntercept(pom.getInstanceSetting().clickSettings, 30);

			driver.navigate().refresh();

			visbility(driver, pom.getInstanceSetting().auditReport, 60);
			clickIntercept(pom.getInstanceSetting().auditReport, 30);
			sleep(3000);

			visbility(driver, pom.getInstanceSetting().AuditReportPatientSerachField, 60);
			sendkeys(pom.getInstanceSetting().AuditReportPatientSerachField, kpid);
			sleep(3000);

			for (WebElement we : pom.getInstanceSetting().AuditReportPatientDropdown) {

				if (we.getText().contains(kpid)) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);
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

			driver.navigate().refresh();

			visbility(driver, pom.getInstanceSetting().clickSettings, 60);
			clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		}
		// Dashboard
		WebElement dashboard;

		try {
			dashboard = driver.findElement(By.xpath("(//div[@id='option-setting'])[1]/div/img"));
			visbility(driver, dashboard, 50);
			clickIntercept(dashboard, 30);

		} catch (Exception e) {
			dashboard = driver.findElement(By.xpath("(//div[@id='option-setting'])[1]/div/img"));
			visbility(driver, dashboard, 50);
			clickIntercept(dashboard, 30);
		}
		List<WebElement> ths = driver
				.findElements(By.xpath("(//div[@id='option-setting'])[1]/div/img//following::ul[1]/li"));

		while (true) {

			for (WebElement st : ths) {
				if (st.getText().trim().equals("Home")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Dashboard")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Quick Tour")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					WebElement cncltr = driver.findElement(By.xpath("(//li[text()='NO, CANCEL TOUR'])[1]"));
					visbility(driver, cncltr, 50);
					clickIntercept(cncltr, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Settings")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Migration Services")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					WebElement clmgr = driver
							.findElement(By.xpath("//h4[text()='Migration Services']//parent::div/button"));
					sleep(2000);
					visbility(driver, clmgr, 50);
					clickIntercept(clmgr, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Sign out")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);

					break;
				}

			}
			break;
		}
	}

}