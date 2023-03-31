package org.PageModules;

import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Patient_Module extends LaunchBrowser {

	@Test(priority = 1)
	public static void patientCreation() {

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

	}

	@Test(priority = 2)
	public static void verifyPatientSaerchAndClick() {
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

	}

	@Test(priority = 3)
	public static void contactInfo() {

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

	}

	@Test(priority = 3)
	public static void alternateContact() {
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

	}

	@Test(priority = 4)
	public static void patientInfo() {
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
	}

	@Test(priority = 5)
	public static void verifyFilterSearchAndCcdImport() {
		clickIntercept(pom.getInstanceNewPatient().$patienmod, 30);
		clickIntercept(pom.getInstanceNewPatient().patientmodReport, 30);

		visbility(driver, pom.getInstanceNewPatient().patientReportSerachNametxtBox, 40);
		sendkeys(pom.getInstanceNewPatient().patientReportSerachNametxtBox, "Kaaspro");

		visbility(driver, pom.getInstanceNewPatient().ellipses, 30);
		clickIntercept(pom.getInstanceNewPatient().ellipses, 30);

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
}
