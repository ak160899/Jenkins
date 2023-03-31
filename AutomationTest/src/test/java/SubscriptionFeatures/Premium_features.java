package SubscriptionFeatures;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.healthRec.Tc_001_Vitals;
import com.pageObjeman.PageObjMan;

public class Premium_features extends LaunchBrowser {

	@Test(priority = 0)
	private void home() {

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

	}

	@Test(priority = 1)
	private void $Ehr_features() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#list_ehr");

		try {

			visbility(driver, pom.getInstanceHealthRec().removePrevious, 60);

			clickIntercept(pom.getInstanceHealthRec().removePrevious, 30);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceHealthRec().removePrevious, 60);

			clickIntercept(pom.getInstanceHealthRec().removePrevious, 30);
		}

		for (WebElement web : pom.getInstanceHealthRec().healthRecordSerachPatientByDropdown) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				elementClickable(web);

				clickIntercept(web, 30);
				break;
			}

		}
		sleep(2000);

		WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
		elementClickable(r7);
		clickIntercept(r7, 30);

		clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);
		/*
		 * } catch (Exception e) { visbility(driver,
		 * pom.getInstanceHealthRec().ehrEllipses, 60); clickble(driver,
		 * pom.getInstanceHealthRec().ehrEllipses, 60); actions("click",
		 * pom.getInstanceHealthRec().ehrEllipses); }
		 */

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Reset Setting")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}

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
					r8.click();
					List<WebElement> fin = driver.findElements(By.xpath("(//ul[@id='matchKey'])[2]/li/span/a"));
					driver.findElement(By.xpath("(//input[@id='optionsSearch'])[2]")).sendKeys("show");
					implicitWait(60, TimeUnit.SECONDS);

					for (WebElement web : fin) {

						if (web.getText().trim().equals("Show Custom-form")) {
							web.click();

						} else if (web.getText().trim().equals("Show Problems")) {
							web.click();
						} else if (web.getText().trim().equals("Show Symptoms")) {
							web.click();
						} else if (web.getText().trim().equals("Show Procedure")) {
							web.click();
						} else if (web.getText().trim().equals("Show Family Health")) {
							web.click();
						} else if (web.getText().trim().equals("Show Status")) {
							web.click();
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

			if (bl == true) {

				break;

			}
		}

		// check basic package form status..

		WebElement formaddbtn = driver.findElement(By.xpath("//div[contains(@title,'Add Forms')]"));
		actions("move to element", formaddbtn);
		visbility(driver, formaddbtn, 60);
		elementClickable(formaddbtn);
		clickIntercept(formaddbtn, 30);

		WebElement $closeformskpop$ = driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/div[2]/span"));
		visbility(driver, $closeformskpop$, 60);
		clickIntercept($closeformskpop$, 30);

		// Attach file..
		while (true) {
			if (pom.getInstanceAttachFile().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceAttachFile().addIcon, 30);
				clickIntercept(pom.getInstanceAttachFile().addIcon, 30);
				break;
			} else if (!pom.getInstanceAttachFile().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAttachFile().addIcon);
				sleep(2000);
			}
		}

		WebElement attdropdown = driver.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[1]/select"));
		dropDown("index", attdropdown, "3");

		WebElement $closeattachilekpop$ = driver
				.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[1]/div[2]/span[2]"));
		visbility(driver, $closeattachilekpop$, 60);
		click($closeattachilekpop$);

		// icd codes search ehr..

		// problems
		while (true) {

			if (pom.getInstanceProblems().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProblems().addIcon, 30);
				clickIntercept(pom.getInstanceProblems().addIcon, 30);
				break;
			} else if (!pom.getInstanceProblems().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProblems().addIcon);
			}
		}

		visbility(driver, pom.getInstanceProblems().icd, 30);
		sendkeys(pom.getInstanceProblems().icd, "Test");

		WebElement $canceliconprblm = driver
				.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::span[3])[1]"));
		visbility(driver, $canceliconprblm, 60);
		javascriptclick($canceliconprblm);

		// symptoms

		while (true) {
			try {

				WebElement a7 = driver.findElement(By.xpath("//div[contains(@title,'Add Symptoms')]"));

				actions("move to element", a7);
				visbility(driver, a7, 60);

				javascriptclick(a7);

				WebElement prsend = driver
						.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[2]/div[2]/input"));
				visbility(driver, prsend, 60);
				sendkeys(prsend, "R10.");
				for (int i = 1; i <= 5; i++) {

					sleep(1000);
				}
				WebElement $sympCrossicon = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::span[3])[1]"));
				visbility(driver, $sympCrossicon, 60);
				javascriptclick($sympCrossicon);
				break;
			} catch (

			Exception e) {

			}
		}
		// procedure..

		while (true) {
			try {

				WebElement b1 = driver.findElement(By.xpath("//div[contains(@title,'Add Procedure')]"));

				actions("move to element", b1);
				visbility(driver, b1, 60);
				javascriptclick(b1);

				WebElement b2 = driver.findElement(By.xpath("//select[@id='codeType']"));
				visbility(driver, b2, 60);

				click(b2);
				dropDown("text", b2, "SNOMED CT");
				WebElement ers = ww.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/div[1]/div[2]/input")));
				visbility(driver, ers, 60);
				ers.sendKeys("test");

				for (int i = 1; i <= 5; i++) {

					sleep(1000);
				}
				WebElement $Procedurecrsicon = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[3])[1]"));
				visbility(driver, $Procedurecrsicon, 60);
				javascriptclick($Procedurecrsicon);
				break;
			} catch (

			Exception e) {

			}

		}

		// status..

		while (true) {

			try {
				WebElement c5 = driver.findElement(By.xpath("//div[contains(@title,'Add Status')]"));

				actions("move to element", c5);
				visbility(driver, c5, 60);
				javascriptclick(c5);
				WebElement c6 = driver.findElement(By.xpath("(//select[@id='statusType'])[1]"));
				visbility(driver, c6, 60);
				click(c6);
				dropDown("text", c6, "Cognitive status");
				WebElement cc7 = driver.findElement(
						By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select[1]//following::div[1]/div[2]/input"));
				visbility(driver, cc7, 60);
				sendkeys(cc7, "test");
				for (int i = 1; i <= 5; i++) {
					sleep(1000);
				}
				WebElement $statuscrsicon = driver
						.findElement(By.xpath("(//div[@id='StatusKpop2']//following::span[3])[1]"));
				visbility(driver, $statuscrsicon, 60);
				javascriptclick($statuscrsicon);
				break;

			} catch (

			Exception e) {

			}
		}

		// Medication...

		while (true) {

			try {

				WebElement ci = driver.findElement(By.xpath("(//div[contains(@title,'Add Medications')])[1]"));

				actions("move to element", ci);
				visbility(driver, ci, 60);
				javascriptclick(ci);
				driver.findElement(By.id("DRUG_NAME")).sendKeys("test");
				for (int i = 1; i <= 5; i++) {

					sleep(1000);
				}
				WebElement $MedcrsIcon$ = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::span[3])[1]"));
				visbility(driver, $MedcrsIcon$, 60);
				javascriptclick($MedcrsIcon$);
				break;
			} catch (

			Exception e) {

			}
		}

		Tc_001_Vitals.tc_002_addVitals_Edit_Save();
		// follow up custom option checking...

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

	@Test(priority = 2, enabled = false)
	private void $$calendarFeatures() throws Exception {
		cal = new Calendars(driver, pom);
		cal.caledarModule();
		String curnt = driver.getCurrentUrl();
		cal.$calenderMod(curnt, kpid);
	}

	@Test(priority = 3)
	private void settings() throws InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);
		visbility(driver, pom.getInstanceSetting().basicInfoEditIcon, 40);
		clickIntercept(pom.getInstanceSetting().basicInfoEditIcon, 30);

		WebElement $smsnotifcation = driver.findElement(By.xpath("(//button[@id='smsP'])[1]"));
		visbility(driver, $smsnotifcation, 30);
		clickIntercept($smsnotifcation, 30);

		while (true) {
			try {
				List<WebElement> $smsdropdown$ = driver
						.findElements(By.xpath("(//button[@id='smsP'])[1]//following::ul[1]/li/a"));

				for (WebElement web : $smsdropdown$) {
					if (web.getText().trim().equals("ON")) {
						System.out.println("condition met");
						visbility(driver, web, 60);
						System.out.println("visible");
						clickIntercept(web, 30);
						System.out.println("clicked");

						WebElement $savebasicinfo$ = driver.findElement(
								By.xpath("(//button[@id='smsP'])[1]//following::ul[1]/li/a//following::button[3]"));
						visbility(driver, $savebasicinfo$, 60);
						clickIntercept($savebasicinfo$, 30);
						break;
					}

				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2500);
		driver.navigate().back();
		driver.navigate().refresh();

		visbility(driver, pom.getInstanceSetting().manageBrandingClick, 40);
		clickIntercept(pom.getInstanceSetting().manageBrandingClick, 30);
		for (int i = 1; i < pom.getInstanceBasic().upgradeButtonEnterpriseUi.size(); i++) {

			if (pom.getInstanceBasic().upgradeButtonEnterpriseUi.get(i).isDisplayed()) {

				clickIntercept(pom.getInstanceBasic().upgradeButtonEnterpriseUi.get(i), 30);
				break;
			}

		}
		visbility(driver, pom.getInstanceSelectYourPlan().editPlanButton, 30);
		sleep(2500);
		clickIntercept(pom.getInstanceSelectYourPlan().editPlanButton, 30);

		Select_Your_plan.verifyTheEnterprisePaymentUi();

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

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
		/*
		 * elementClickable(pom.getInstanceSetting().cdsCheckbox);
		 * click(pom.getInstanceSetting().cdsCheckbox);
		 */

		/*
		 * elementClickable(pom.getInstanceSetting().saveCds);
		 * click(pom.getInstanceSetting().saveCds);
		 */
		clickIntercept(pom.getInstanceSetting().saveCds, 30);

		sleep(3000);

		/* try { */
		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		// elementClickable(pom.getInstanceSetting().clickSettings);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);
		/*
		 * driver.navigate().to("https://localhost:8443/health/#setting"); sleep(4000);
		 * // SetFavorities..
		 * driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click(
		 * ); sleep(3000); List<WebElement> setfav1 =
		 * driver.findElements(By.xpath("//ul[@id='setfavoritesul']/li")); for
		 * (WebElement w : setfav1) { if (w.getText().trim().equals("Item/service")) {
		 * while (true) { try { visbility(driver, w, 60); w.click(); break; } catch
		 * (Exception e) {
		 * 
		 * } }
		 * 
		 * WebElement clickadditem = driver.findElement(By.xpath(
		 * "//div[@id='referral']//following::div[1]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"
		 * )); visbility(driver, clickadditem, 60); click(clickadditem); WebElement sdf
		 * = driver.findElement(By.xpath(
		 * "(//div[contains(text(),'Type or select item/service and price')])[2]//following::input[1]"
		 * )); visbility(driver, sdf, 60); sendkeys(sdf, "test"); WebElement sdf2 =
		 * driver.findElement(By.xpath(
		 * "(//div[contains(text(),'Type or select item/service and price')])[2]//following::input[2]"
		 * )); visbility(driver, sdf2, 60); sendkeys(sdf2, "5"); WebElement saveitem =
		 * driver.findElement(By .xpath(
		 * "//div[@id='referral']//following::div[1]/div[3]/div/div/div[2]/div[6]/div/button[2]"
		 * )); visbility(driver, saveitem, 60); javascriptclick(saveitem);
		 * 
		 * sleep(2000); WebElement edititem =
		 * driver.findElement(By.xpath("//span[text()='test']")); visbility(driver,
		 * edititem, 60); actions("click", edititem); while (true) { try { WebElement
		 * deleteitem = driver.findElement(By.xpath(
		 * "//div[@id='referral']//following::div[1]/div[3]/div/div/div[2]//parent::div[1]/div[1]/div[2]/span[2]"
		 * )); if (deleteitem.isDisplayed()) { click(deleteitem); break; }
		 * 
		 * } catch (Exception e) { // TODO: handle exception } }
		 * 
		 * WebElement itemservicebackarrow = driver
		 * .findElement(By.xpath("(//div[@id='invoiceAdd'])[1]/div[1]/div[1]/span[1]"));
		 * visbility(driver, itemservicebackarrow, 60);
		 * javascriptclick(itemservicebackarrow); sleep(2500); while (true) { try {
		 * driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click(
		 * ); break; } catch (Exception e) {
		 * 
		 * } }
		 * 
		 * } else if (w.getText().trim().contentEquals("Message")) { while (true) { try
		 * { visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } }
		 * 
		 * WebElement addnewfavmessage = driver .findElement(By.xpath(
		 * "(//div[@id='message'])[1]/div[1]/div//following::td[4]/span[2]"));
		 * visbility(driver, addnewfavmessage, 60); javascriptclick(addnewfavmessage);
		 * 
		 * WebElement msf = driver.findElement(By.xpath("//textarea[@id='message1']"));
		 * 
		 * visbility(driver, msf, 60); sendkeys(msf, "hello"); WebElement savemesssage =
		 * driver
		 * .findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
		 * visbility(driver, savemesssage, 60); javascriptclick(savemesssage);
		 * sleep(2500); WebElement editmessage =
		 * driver.findElement(By.xpath("//div[text()='hello']")); actions("click",
		 * editmessage); WebElement deletemessage = driver
		 * .findElement(By.xpath("//div[@id='MessageKpop2']/div[1]/div[2]/span[1]"));
		 * visbility(driver, deletemessage, 60); javascriptclick(deletemessage);
		 * 
		 * sleep(3000); WebElement gobackmessage = driver .findElement(By.
		 * xpath("(//span[text()='Favorite Message'])[1]//following::div[1]/span"));
		 * visbility(driver, gobackmessage, 60); javascriptclick(gobackmessage);
		 * 
		 * sleep(3000);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * // Set forms.. while (true) { try { WebElement f1 =
		 * driver.findElement(By.xpath("//button[@id='form-script']"));
		 * visbility(driver, f1, 60); click(f1); break; } catch (Exception e) { // TODO:
		 * handle exception } } sleep(1500); WebElement $crossiconfromskpop$ =
		 * driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/div[2]/span"));
		 * visbility(driver, $crossiconfromskpop$, 60); click($crossiconfromskpop$); //
		 * Notifications...
		 * 
		 * while (true) { try {
		 * 
		 * WebElement $$edit$$notify$$message$$ = driver.findElement(By
		 * .xpath("//span[text()='Edit Notification Messages']//parent::div//parent::div[1]/label/input"
		 * ));
		 * 
		 * actions("click", $$edit$$notify$$message$$); break; } catch (Exception e) {
		 * // TODO: handle exception } }
		 * 
		 * // market place..
		 * 
		 * /* while (true) { try {
		 * 
		 * WebElement $marketplace$ =
		 * driver.findElement(By.xpath("//button[text()='Market Place']"));
		 * 
		 * sleep(2000); visbility(driver, $marketplace$, 60); click($marketplace$);
		 * 
		 * break; } catch (Exception e) { // TODO: handle exception }
		 * 
		 * }
		 * 
		 * visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 60);
		 * javascriptclick(pom.getInstanceSetting().$eirsystembutton$);
		 * visbility(driver, pom.getInstanceSetting().$upgradenowineir$, 60);
		 * javascriptclick(pom.getInstanceSetting().$upgradenowineir$); while (true) {
		 * try { WebElement $editpln$ =
		 * driver.findElement(By.xpath("//button[@id='editPlanBtn']"));
		 * visbility(driver, $editpln$, 60); click($editpln$); break; } catch (Exception
		 * e) { // TODO: handle exception } } sleep(2500);
		 * j.executeScript("window.scrollBy(0,350)", "");
		 * 
		 * sleep(2500); driver.navigate().to("https://localhost:8443/health/#setting");
		 */
		// Audit Report...
		while (true)

		{
			try {
				WebElement rqqa = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));

				ScriptExecutor(rqqa);
				visbility(driver, rqqa, 60);
				javascriptclick(rqqa);
				sleep(2500);
				break;
			} catch (Exception et) {

			}
		}

		driver.navigate().back();

		// edit sceanrio

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $premiumimg$ = driver.findElement(By.xpath("(//span[text()='Premium'])[1]"));
				visbility(driver, $premiumimg$, 60);
				javascriptclick($premiumimg$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
