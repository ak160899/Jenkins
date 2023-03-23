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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Basic_features extends LaunchBrowser {

	@Test(priority = 0)
	private void home() throws Exception {
		try {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 50);

			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			clickIntercept(pom.getInstanceHomeModule().$patientCreationButton, 30);
			log.info("patient create button clicked");
		} catch (ElementClickInterceptedException e) {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 50);
			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			clickIntercept(pom.getInstanceHomeModule().$patientCreationButton, 30);
			log.info("patient create button clicked");
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

			}
			break;
		}

		// String character = RandomStringUtils.randomAlphabetic(12);

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		log.info("email id entered");
		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		clickIntercept(pom.getInstanceHomeModule().selectFlagPhoneNumField, 30);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				clickIntercept(flag, 30);
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));
		log.info("phone number entered");
		// Acc gets Created..
		clickIntercept(pom.getInstanceNewPatient().CreatePatient, 30);
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

	@Test(priority = 1)
	private void $Ehr_features() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#list_ehr");

		try {
			WebElement remv = driver.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
			visbility(driver, remv, 60);

			elementClickable(remv);
			click(remv);

		} catch (ElementClickInterceptedException e) {
			System.out.println("exception in ehr");
			WebElement remv = driver.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
			visbility(driver, remv, 60);

			clickIntercept(remv, 30);
		}

		List<WebElement> wwe = driver
				.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
		for (WebElement web : wwe) {

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
					clickIntercept(r8, 30);
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
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);
		sleep(2000);
		Select_Your_plan.verifyThePremium55PaymentUi();
		Select_Your_plan.verifyTheEnterprisePaymentUi();

		Select_Your_plan.verifyThePremiumplusPayementUi();

		driver.navigate().back();
		sleep(2000);

		// Attach file..

		WebElement attachfileAddBtn = driver.findElement(By.xpath("//div[contains(@title,'Add Attach File')]"));
		actions("move to element", attachfileAddBtn);
		visbility(driver, attachfileAddBtn, 60);

		clickIntercept(attachfileAddBtn, 30);

		WebElement attdropdown = driver.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[1]/select"));
		dropDown("index", attdropdown, "3");
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);
		sleep(2000);
		Select_Your_plan.verifyThePremium55PaymentUi();
		Select_Your_plan.verifyTheEnterprisePaymentUi();

		Select_Your_plan.verifyThePremiumplusPayementUi();

		driver.navigate().back();
		sleep(2500);

		// icd codes search ehr..

		// problems
		while (true) {

			try {
				WebElement a3 = driver.findElement(By.xpath("//div[contains(@title,'Add Problems')]"));
				actions("move to element", a3);
				visbility(driver, a3, 60);
				javascriptclick(a3);
				WebElement ct = ww.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//div[@id='ProblemsKpop2']/div[2]/div/div[1]/div[2]/input")));
				visbility(driver, ct, 60);
				sendkeys(ct, "10299");
				for (int i = 1; i <= 5; i++) {
					sleep(1000);
				}
				WebElement $canceliconprblm = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::span[3])[1]"));
				visbility(driver, $canceliconprblm, 60);
				javascriptclick($canceliconprblm);
				break;

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

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
			} catch (Exception e) {

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
			} catch (Exception e) {

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

			} catch (Exception e) {

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
			} catch (Exception e) {

			}
		}

		driver.findElement(By.xpath("(//button[contains(@title,'Add Multiple Vitals')])[1]")).click();

		driver.findElement(By.id("wresult")).sendKeys("55");
		WebElement edity = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		visbility(driver, edity, 60);
		elementClickable(edity);
		click(edity);

		// follow up custom option checking...

		try {

			WebElement createfollowup = driver.findElement(By.xpath("(//button[@id='followUpAdd'])[1]/div[1]"));
			elementClickable(createfollowup);
			click(createfollowup);
		} catch (ElementClickInterceptedException e) {
			WebElement createfollowup = driver.findElement(By.xpath("(//button[@id='followUpAdd'])[1]/div[1]"));
			elementClickable(createfollowup);
			click(createfollowup);
		}
		sleep(4000);
		implicitWait(30, TimeUnit.SECONDS);
		WebElement crt = driver
				.findElement(By.xpath("//div[@id='followupEhr']/div[2]/div[3]/div[1]//following::div[2]/input"));
		elementClickable(crt);
		click(crt);
		sleep(2000);
		WebElement folowypyr = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		dropDown("text", folowypyr, "2023");
		WebElement folowupmnth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		dropDown("text", folowupmnth, "Dec");
		driver.findElement(By.xpath("(//a[text()='31'])")).click();
		WebElement fixappo = driver.findElement(By.xpath("(//button[@id='fixAppointment'])[1]"));
		visbility(driver, fixappo, 50);
		elementClickable(fixappo);
		click(fixappo);

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

				if (checkcn.isDisplayed() && sm.getText().isEmpty()) {
					b = true;
					checkcn.click();
					sleep(3000);
					break;

				}

			}
			if (b == true) {
				WebElement $foloupBtn = driver
						.findElement(By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]"));
				visbility(driver, $foloupBtn, 40);
				click($foloupBtn);
				break;

			}
		}

		sleep(4000);

	}

	@Test(priority = 2)
	private void $$calendarFeatures() throws Exception {

		cal.caledarModule();

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);

	}

	@Test(priority = 3)
	private void $$settings$$() throws InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);
		// Manage your Account...

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);
		visbility(driver, pom.getInstanceSetting().basicInfoEditIcon, 40);
		clickIntercept(pom.getInstanceSetting().basicInfoEditIcon, 30);

		WebElement $smsnotifcation = driver.findElement(By.xpath("(//button[@id='smsP'])[1]"));
		visbility(driver, $smsnotifcation, 30);
		clickIntercept($smsnotifcation, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		sleep(2500);
		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);
		Select_Your_plan.verifyThePremium55PaymentUi();
		Select_Your_plan.verifyTheEnterprisePaymentUi();
		Select_Your_plan.verifyThePremiumplusPayementUi();
		sleep(3000);

		driver.navigate().to("https://localhost:8443/health/#setting");

		// cds(clinical des support)

		visbility(driver, pom.getInstanceSetting().cdsClick, 30);

		clickIntercept(pom.getInstanceSetting().cdsClick, 30);

		visbility(driver, pom.getInstanceSetting().addnewCds, 30);
		clickIntercept(pom.getInstanceSetting().addnewCds, 30);

		sendkeys(pom.getInstanceSetting().enterCds, "Akash");

		sleep(2000);
		WebElement scrolltill = driver.findElement(By.xpath("//input[@id='weight_from']"));
		ScriptExecutor(scrolltill);

		sleep(2000);
		visbility(driver, pom.getInstanceSetting().cdsIcd, 30);
		sendkeys(pom.getInstanceSetting().cdsIcd, "test");
		sleep(4500);

		driver.navigate().to("https://localhost:8443/health/#setting");
		// Set Favorities..

		for (WebElement w : pom.getInstanceSetting().setFavoriteListDrop) {
			if (w.getText().trim().equals("Item/service")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					/*
					 * elementClickable(pom.getInstanceSetting().setfavoritesItemServiceAddIcon);
					 * click(pom.getInstanceSetting().setfavoritesItemServiceAddIcon);
					 */
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDiscription, 60);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServiceDiscription, "test");
				visbility(driver, pom.getInstanceSetting().setFavoritesItemServicePrice, 40);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServicePrice, "5");
				/*
				 * elementClickable(pom.getInstanceSetting().setFavoritesItemServiceSave);
				 * click(pom.getInstanceSetting().setFavoritesItemServiceSave);
				 */
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
					/*
					 * elementClickable(pom.getInstanceSetting().setFavoritesItemServiceDelete);
					 * click(pom.getInstanceSetting().setFavoritesItemServiceDelete);
					 */
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
				}

				try {
					/*
					 * elementClickable(pom.getInstanceSetting().setFavoritesItemServiceClose);
					 * click(pom.getInstanceSetting().setFavoritesItemServiceClose);
					 */
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

			}

		}
		sleep(2000);
		// Set forms..

		visbility(driver, pom.getInstanceSetting().customForm, 60);
		clickIntercept(pom.getInstanceSetting().customForm, 30);
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		sleep(2500);
		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);
		Select_Your_plan.verifyThePremium55PaymentUi();
		Select_Your_plan.verifyTheEnterprisePaymentUi();
		Select_Your_plan.verifyThePremiumplusPayementUi();
		sleep(3000);
		// market place..

		WebElement $mrktplace$ = driver.findElement(By.xpath("//button[text()='Market Place']"));
		visbility(driver, $mrktplace$, 60);
		clickIntercept($mrktplace$, 30);

		sleep(2000);

		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 30);
		clickIntercept(pom.getInstanceSetting().$eirsystembutton$, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);

		sleep(2500);

		Select_Your_plan.verifyThePremiumplusPayementUi();

		// Notifications...

		try {

			elementClickable(pom.getInstanceSetting().customizeToggle);
			actions("click", pom.getInstanceSetting().customizeToggle);
			System.out.println("clicked Notication toggle button");

		} catch (Exception e) {
			elementClickable(pom.getInstanceSetting().customizeToggle);
			actions("click", pom.getInstanceSetting().customizeToggle);

		}
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);

		Select_Your_plan.verifyThePremium55PaymentUi();
		Select_Your_plan.verifyTheEnterprisePaymentUi();

		Select_Your_plan.verifyThePremiumplusPayementUi();
		sleep(3000);
		driver.navigate().back();

		// Audit Report...

		visbility(driver, pom.getInstanceSetting().auditReport, 60);
		clickIntercept(pom.getInstanceSetting().auditReport, 30);
		sleep(3000);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		visbility(driver, pom.getInstanceBasic().editPlanButton, 40);
		clickIntercept(pom.getInstanceBasic().editPlanButton, 30);

		Select_Your_plan.verifyThePremium55PaymentUi();
		Select_Your_plan.verifyTheEnterprisePaymentUi();

		Select_Your_plan.verifyThePremiumplusPayementUi();
		sleep(3000);
		driver.navigate().back();

		// edit scenario..

	}

}
