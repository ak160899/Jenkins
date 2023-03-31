package org.SmokeTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.data.ConfigManager;
import com.healthRec.Tc_004_FamilyHealth;
import com.healthRec.Tc_020_Forms;
import com.healthRec.Tc_013_Goals;
import com.healthRec.Tc_017_Medication;
import com.healthRec.Tc_010Problems;
import com.healthRec.Tc_012_Procedure;
import com.healthRec.Tc_011_Symptoms;
import com.healthRec.Tc_007_Vaccine;
import com.healthRec.Tc_001_Vitals;

public class Health_Record extends LaunchBrowser {

	@Test
	public void tc_001_verifyclickHealthRecordAndAddNewHaelthRecord() {

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
				clickIntercept(remv, 30);
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
				clickIntercept(web, 30);
				break;
			}

		}
		sleep(2000);

		visbility(driver, pom.getInstanceHealthRec().clickAddIconHealthRec, 60);
		clickIntercept(pom.getInstanceHealthRec().clickAddIconHealthRec, 30);

	}

	@Test
	public void tc_002_verifyClickEllipsesAndshowAllModules() {
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

	}

	@Test
	public void tc_003_addVitalsAndEdit() {
		try {
			Tc_001_Vitals.tc_002_addVitals_Edit_Save();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	public void tc_004_addAllergyAndEdit() {

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

	}

	@Test
	public void tc_005_addSocialHistoryAndEdit() {
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
	}

	@Test
	public void tc_006_addFamilHealthAndEdit() {
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

	}

	@Test
	public void tc_007_addAlertAndEdit() {

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

	}

	@Test
	public void tc_008_addVistReasonAndEdit()  {
		try {
			com.healthRec.Tc_006_VisitReason.tc_007_addVisitReason_Edit_Save();;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	public void tc_009_addVaccineEditAndSave() {

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

		clickIntercept(pom.getInstanceVaccine().save, 30);
	}

	@Test
	public void tc_010_addImplantableDeviceEditAndSave() {
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
			WebElement edit = driver.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);
		} catch (StaleElementReferenceException e) {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);

		}
		visbility(driver, pom.getInstanceImplantableDevice().note, 30);
		clear(pom.getInstanceImplantableDevice().note);
		sendkeys(pom.getInstanceImplantableDevice().note, "JUst Rise up..");

		clickIntercept(pom.getInstanceImplantableDevice().save, 30);

	}

	@Test
	public void tc_011_addAmendmentEditAndSave() {
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

	}

	@Test
	public void tc_012_addProblemsEditAndSave() {
		try {
			Tc_010Problems.addproblems_Edit_Save();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	public void tc_013_addSymptomsEditAndSave() {
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
			WebElement a8 = driver
					.findElement(By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
			visbility(driver, a8, 40);
			clickIntercept(a8, 30);
		} catch (StaleElementReferenceException e) {
			WebElement a8 = driver
					.findElement(By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
			visbility(driver, a8, 40);
			clickIntercept(a8, 30);

		}

		visbility(driver, pom.getInstanceSymptom().symptoms, 40);
		clear(pom.getInstanceSymptom().symptoms);
		sendkeys(pom.getInstanceSymptom().symptoms, "covid");
		clickIntercept(pom.getInstanceSymptom().save, 30);

	}

	@Test
	public void tc_014_addProceudreEditAndSave() {

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

			WebElement edit = driver
					.findElement(By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);

		} catch (StaleElementReferenceException e) {

			WebElement edit = driver
					.findElement(By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
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

	}

	@Test
	public void tc_016_addGoalsEditAndSave() {
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

	}

	@Test
	public void tc_017_addAdvanceDirectivesEditAndSave() {
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

	}

	@Test
	public void tc_018_addStatusEditAndSave() {
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
			WebElement $editstatus$ = driver
					.findElement(By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
			visbility(driver, $editstatus$, 60);
			clickIntercept($editstatus$, 30);
			visbility(driver, pom.getInstanceStatus().removeStatus, 30);
			clickIntercept(pom.getInstanceStatus().removeStatus, 30);
		} catch (StaleElementReferenceException e) {
			WebElement $editstatus$ = driver
					.findElement(By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
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

	}

	@Test
	public void tc_019_addTestOrderEditAndSave() {
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

	}

	@Test
	public void tc_020_addMedicationEditAndSave() {
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

	}

	@Test
	public void tc_021_addNotesEditAndSave() {
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

	}

	@Test
	public void tc_022_addPhysicalExaminationEditAndSAve() {
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
	}

	@Test
	public void tc_023_addFormsAndDelete() {
		
		try {
			Tc_020_Forms.$addForm();
		} catch (Throwable e) {

			e.printStackTrace();
		}
	}

	@Test
	public void tc_024_addAttachFileEditAndSave() {
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

	}

	@Test
	public void tc_025_addInpatientEditAndSave() {

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

	}

	@Test
	public void tc_026_generateBillFromEhr() {
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

	}

	@Test
	public void tc_027_pastCuredVaccine() {
		
		try {
			Tc_007_Vaccine.$getPastVaccine();
		} catch (Throwable e1) {

			e1.printStackTrace();
		}

	}

	@Test
	public void tc_028_pastCuredSymptoms()   {
		Tc_011_Symptoms s = new Tc_011_Symptoms();
		try {
			s.getPastSymptom();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	public void tc_029_pastCuredProcedure() {
		Tc_012_Procedure pr = new Tc_012_Procedure();
		pr.getPastProcedure();

	}

	@Test
	public void tc_030_pastGoals() {
		Tc_013_Goals g = new Tc_013_Goals();
		try {
			g.$getPastGoals();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void tc_031_pastMedication() {
		Tc_017_Medication med = new Tc_017_Medication();
		try {
			med.$getPastMedication();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void tc_032_verifyTheSaltOptions() {
		List<WebElement> rowfor = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div"));

		int ehrrow = rowfor.size();

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

	}

	@Test
	public void tc_033_FavoriteVisitReason() {
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

	}

	@Test
	public void tc_034_FavoriteVaccine() {
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

	}

	@Test
	public void tc_035_FavoriteSymptoms() {
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

	}

	@Test
	public void tc_036_FavoriteProcedure() {
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

	}

	@Test
	public void tc_037_FavoriteGoals() {
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

	}

	@Test
	public void tc_038_FavoriteStatus() {
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

	}

	@Test
	public void tc_039_FavoriteProblems() {
		try {
			Tc_010Problems.favoriteProblemAddIcon();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void tc_040_FavoriteAdvanceDirectives() {
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

	}

	@Test
	public void tc_041_FavoriteNotes() {
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

	}

	@Test
	public void tc_042_FavoritePhysicalExamination() {
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

	}

	@Test
	public void tc_043_followUpCreation() {
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

	}

	@Test
	public void tc_044_deleteEhr() {
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			WebElement delehrf = driver.findElement(By.xpath("(//button[contains(@title,'Delete Health Record')])[1]"));
			clickIntercept(delehrf, 30);
			sleep(2000);
			WebElement zr = driver
					.findElement(By.xpath("//span[text()='Delete Health Record']//following::div[4]/button[2]"));
			clickIntercept(zr, 30);
		}

	}

}
