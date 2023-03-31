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
import com.pageObjeman.PageObjMan;

public class Lite_package extends LaunchBrowser {

	@Test(priority = 1)
	private void home() throws InterruptedException {

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
		sleep(4000);

		driver.navigate().to("https://localhost:8443/health/#home");

		// home appointment...
		String hkpid = kpid;

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));

		int totalr = totalnumberrowdy.size();

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {
			int a = 1 + i;
			WebElement ss = driver.findElement(By.xpath("//div[@id='date-data'][" + i + "]/div[2]/div[2]/div"));
			if (ss.getText().equals("Doctor/User not working")) {

				WebElement abcd = driver.findElement(By.xpath("(//span[@id='editCalendar'])[" + a + "]"));
				visbility(driver, abcd, 60);
				actions("click", abcd);
				sleep(3000);
				WebElement checkbx = driver.findElement(By.xpath("(//input[@id='is-working-day'])[1]"));
				visbility(driver, checkbx, 60);

				actions("click", checkbx);
				WebElement ampm = driver.findElement(By.xpath("(//div[@id='thru-ampm'])[1]"));
				visbility(driver, ampm, 60);
				actions("click", ampm);
				driver.findElement(By.xpath("(//div[@id='save-btn'])[1]")).click();
				sleep(5000);

			}

			// represent total in a part..
			List<WebElement> rchange = driver
					.findElements(By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div/div[1]/div[1]/div[1])"));
			int avaiable = rchange.size();

			for (int b = 1; b <= avaiable; b++) {

				WebElement tp = driver.findElement(
						// represent the row change and time..
						By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div[" + b + "]/div[1]/div[1]/div[1])"));

				//String tr = tp.getText();
				//System.out.println(tr);
				boolean trp = tp.isDisplayed();
				String rrs = tp.getAttribute("id");

				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed() && !tp.getText().isEmpty()) {

					cond = true;
					visbility(driver, tp, 60);
					clickIntercept(tp, 30);

					WebElement qrs = driver.findElement(By.xpath("(//input[@id='AppointmentPatientName'])[" + a + "]"));
					visbility(driver, qrs, 60);
					qrs.sendKeys(hkpid);
					break;
				}

			}

			if (cond == true) {
				sleep(2000);
				implicitWait(60, TimeUnit.SECONDS);
				sleep(2000);
				implicitWait(30, TimeUnit.SECONDS);
				List<WebElement> choosepatient = driver.findElements(By.xpath(
						"//div[@id='AppointmentMessage']/div[2]//following::ul[6]/li/a/table[1]/tbody/tr/td[2]"));
				
				for (WebElement web : choosepatient) {
					if (web.getText().trim().equals(kpid)) {
						visbility(driver, web, 60);
						clickIntercept(web, 30);
						break;
					}

				}

				try {
					WebElement $selectappType = driver
							.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + a + "]"));
					System.out.println($selectappType);
					visbility(driver, $selectappType, 40);
					
					clickIntercept($selectappType,30);
				} catch (Exception e) {
					WebElement $selectappType = driver
							.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + a + "]"));
					System.out.println($selectappType);
					visbility(driver, $selectappType, 40);
					
					clickIntercept($selectappType,30);
				}
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])//following::ul[1]/li/a"));
				for (WebElement Element : $TypeDropdown) {
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						clickIntercept(Element,30);
						break;
					}

				}

				sleep(4000);

				visbility(driver, pom.getInstanceSetting().dismiss, 40);
				elementClickable(pom.getInstanceSetting().dismiss);
				clickIntercept(pom.getInstanceSetting().dismiss,30);

				WebElement qt = driver.findElement(By.xpath("(//textarea[@id='description'])[" + a + "]"));
				visbility(driver, qt, 60);
				qt.sendKeys("no worries...");
				WebElement utt = driver.findElement(By.xpath("(//button[@id='statusId_dropdown'])[" + a + "]"));
				clickIntercept(utt, 30);

				List<WebElement> lop = driver.findElements(By.xpath("(//ul[@id='statusIdDropdown'])[" + a + "]/li"));
				for (WebElement w : lop) {
					if (w.getText().trim().equals("In Progress")) {
						clickIntercept(w,30);
						break;
					}

				}

				WebElement vcv = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
				visbility(driver, vcv, 60);
				clickIntercept(vcv, 30);

				WebElement pip = driver.findElement(By.xpath("//span[text()='" + hkpid + "']"));
				visbility(driver, pip, 60);
				clickIntercept(pip, 30);

				sleep(2000);
				WebElement wtw = driver.findElement(By.xpath("(//span[@id='del-btn'])[" + i + "]"));
				clickble(driver, wtw, 60);
				clickIntercept(wtw, 30);

				WebElement delapp = driver
						.findElement(By.xpath("//div[@id='AppointmentCreateMessage']/div[2]/div[2]/button[2]"));
				clickble(driver, delapp, 60);
				clickIntercept(delapp, 30);

				break;
			}
		}

	}

	@Test(priority = 2)
	private void patient_modules() {
		try {
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
		} catch (ElementClickInterceptedException e) {
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
		driver.findElement(By.id("userloginId")).sendKeys("abcdefg@gmail.com");
		WebElement countryFlagButon = driver.findElement(By.xpath("(//div[@class='selected-flag'])[1]"));
		visbility(driver, countryFlagButon, 50);
		elementClickable(countryFlagButon);
		click(countryFlagButon);

		List<WebElement> flagchoose = driver
				.findElements(By.xpath("(//div[@class='selected-flag'])[1]//following::ul[1]/li/span[2]"));
		for (WebElement flagcode : flagchoose) {
			if (flagcode.getText().trim().equals("+91")) {

				elementClickable(flagcode);
				click(flagcode);
				break;
			}

		}

		driver.findElement(By.id("Phone")).sendKeys("9551824155");

		// Acc gets Created..
		visbility(driver, pom.getInstanceNewPatient().CreatePatient, 60);
		click(pom.getInstanceNewPatient().CreatePatient);

		try {
			WebElement patientinfoeditButton = driver
					.findElement(By.xpath("(//span[@class='profile-info'])[3]//following::span[1]"));
			visbility(driver, patientinfoeditButton, 50);
			elementClickable(patientinfoeditButton);
			click(patientinfoeditButton);
		} catch (ElementClickInterceptedException e) {
			WebElement patientinfoeditButton = driver
					.findElement(By.xpath("(//span[@class='profile-info'])[3]//following::span[1]"));
			visbility(driver, patientinfoeditButton, 50);
			elementClickable(patientinfoeditButton);
			click(patientinfoeditButton);
		}
		WebElement emailField = driver.findElement(By.xpath("(//input[@id='userLoginId'])[3]"));
		visbility(driver, emailField, 50);
		clear(emailField);

		WebElement phonefield = driver.findElement(By.xpath("(//input[@id='phone'])[3]"));
		visbility(driver, phonefield, 50);
		clear(phonefield);

		elementClickable(pom.getInstanceNewPatient().savePatientinfo);
		click(pom.getInstanceNewPatient().savePatientinfo);

		while (true) {
			try {
				WebElement es = driver.findElement(By.xpath("//td[@id='val-kpid']"));
				visbility(driver, es, 60);
				kpid = es.getText();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(priority = 3)
	private void ehr_module() throws InterruptedException {
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
		clickIntercept(formaddbtn,30);

		WebElement clickupgradebtninfrm = driver.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
		elementClickable(clickupgradebtninfrm);
		clickIntercept(clickupgradebtninfrm,30);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		clickIntercept(pom.getInstanceSetting().$editplan$, 30);
		sleep(2000);
		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int b = 1; b <= 2; b++) {
					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);
				}
			}
		}

		driver.navigate().back();

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
		WebElement clickupgradebtninattach = driver.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
		elementClickable(clickupgradebtninattach);
		clickIntercept(clickupgradebtninattach, 30);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		clickIntercept(pom.getInstanceSetting().$editplan$, 30);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}

		driver.navigate().back();

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
		clickIntercept($canceliconprblm, 30);

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

				clickIntercept(b2, 30);
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
				e.printStackTrace();
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
				clickIntercept(c6, 30);
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
				e.printStackTrace();
			}
		}

		driver.findElement(By.xpath("(//button[contains(@title,'Add Multiple Vitals')])[1]")).click();

		driver.findElement(By.id("wresult")).sendKeys("55");
		WebElement edity = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		visbility(driver, edity, 60);
		elementClickable(edity);
		clickIntercept(edity, 30);

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

			for (int jj = 1; jj <= rqq.size(); jj++) {

				WebElement checkcn = driver
						.findElement(By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + jj + "]/div/div[1]"));

				WebElement sm = driver
						.findElement(By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + jj + "]/div/div[2]/span[3]"));

				if (checkcn.isDisplayed() && sm.getText().isEmpty()) {
					b = true;
					clickIntercept(checkcn, 30);
					sleep(3000);
					break;

				}

			}
			if (b == true) {
				WebElement $foloupBtn = driver
						.findElement(By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]"));
				visbility(driver, $foloupBtn, 40);
				clickIntercept($foloupBtn, 30);

				List<WebElement> folloupAppointmentDropDown = driver.findElements(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::ul[1]/li/a/span[2]"));
				for (WebElement chooseType : folloupAppointmentDropDown) {
					if (chooseType.getText().trim().equals("Emergency")) {
						visbility(driver, chooseType, 40);
						elementClickable(chooseType);
						clickIntercept(chooseType, 30);
						break;
					}
				}
				break;

			}
		}

		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		clickIntercept(pom.getInstanceSetting().subscribe, 30);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}

		driver.navigate().back();

		sleep(4000);

	}

	@Test(priority = 4)
	private void calendar_module() throws Exception {

		cal.caledarModule();
		$current = driver.getCurrentUrl();

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));
		int totalr = totalnumberrowdy.size();

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {
			int a = 1 + i;

			cal.$checkDoctorUserStatus(i);

			// represent total in a part..
			List<WebElement> rchange = driver
					.findElements(By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div/div[1]/div[1]/div[1])"));
			int avaiable = rchange.size();
			int count = 2;
			for (int b = 1; b <= avaiable; b++) {

				WebElement tp = driver.findElement(

						By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div[" + b + "]/div[1]/div[1]/div[1])"));

				
				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed() && !tp.getText().isEmpty()) {

					cond = true;
					visbility(driver, tp, 60);
					javascriptclick(tp);
					if (count >= 2) {
						cal.$choosePatient(count, kpid);
					} else {
						cal.$choosePatient(i, kpid);
					}
					break;

				} else if (tp.getText().isEmpty() && tp.isDisplayed()) {

					count = count + 1;
					continue;

				}

			}

			if (cond == true) {
				sleep(2000);
				implicitWait(30, TimeUnit.SECONDS);
				List<WebElement> choosepatient = driver.findElements(By.xpath(
						"//div[@id='AppointmentMessage']/div[2]//following::ul[6]/li/a/table[1]/tbody/tr/td[2]"));

				for (WebElement web : choosepatient) {
					if (web.getText().trim().equals(kpid)) {
						visbility(driver, web, 60);
						clickIntercept(web, 30);
						break;
					}

				}
				sleep(3000);

				try {
					WebElement $selectappType = driver
							.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + count + "]"));
					visbility(driver, $selectappType, 40);
					clickIntercept($selectappType, 30);
				} catch (Exception e) {
					e.printStackTrace();
				}
				sleep(3000);
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])//following::ul[1]/li/a"));
				for (WebElement Element : $TypeDropdown) {
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						clickIntercept(Element, 30);
						break;
					}

				}

				for (int in = 1; in <= 5; in++) {
					try {
						WebElement $dismiss = driver
								.findElement(By.xpath("//span[text()='Premium Subscription']//following::button[1]"));

						if ($dismiss.isDisplayed()) {
							clickIntercept($dismiss, 30);
							break;
						}
					} catch (Exception e) {

					}
				}

				WebElement qt = driver.findElement(By.xpath("(//textarea[@id='description'])[" + count + "]"));
				visbility(driver, qt, 60);
				qt.sendKeys("no worries...");
				WebElement utt = driver.findElement(By.xpath("(//button[@id='statusId_dropdown'])[" + count + "]"));
				visbility(driver, utt, 60);
				clickIntercept(utt, 30);

				List<WebElement> lop = driver
						.findElements(By.xpath("(//ul[@id='statusIdDropdown'])[" + count + "]/li"));
				for (WebElement w : lop) {
					if (w.getText().trim().equals("In Progress")) {
						visbility(driver, w, 60);
						clickIntercept(w, 30);
						break;
					}

				}

				WebElement vcv = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
				visbility(driver, vcv, 60);
				ScriptExecutor(vcv);

				clickIntercept(vcv, 30);

				sleep(1000);

				WebElement ez = driver.findElement(By.xpath("//span[text()='" + kpid + "']"));
				visbility(driver, ez, 60);
				clickIntercept(ez, 30);

				sleep(2000);
				// goto ehr..
				WebElement ehr = driver.findElement(By.id("goEhrButton"));

				visbility(driver, ehr, 60);
				elementClickable(ehr);
				clickIntercept(ehr, 30);

				sleep(3000);

				try {
					visbility(driver, pom.getInstanceCalendar().clickCalendar, 40);
					elementClickable(pom.getInstanceCalendar().clickCalendar);
					clickIntercept(pom.getInstanceCalendar().clickCalendar,30);
					driver.navigate().refresh();

				} catch (ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceCalendar().clickCalendar, 40);
					elementClickable(pom.getInstanceCalendar().clickCalendar);
					clickIntercept(pom.getInstanceCalendar().clickCalendar,30);
					driver.navigate().refresh();
				}

				break;

			}

		}
	}

	@Test(priority = 5)
	private void billing_module() throws InterruptedException {
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
	}

	@Test(priority = 6)
	private void tele_doctor() throws InterruptedException {
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
		sendkeys(np2, "Abigazi");// .sendKeys("Abigazi");
		WebElement np3 = driver.findElement(By.id("lastname"));
		visbility(driver, np3, 60);
		sendkeys(np3, "Ak");// .sendKeys("Ak");
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

		if (url.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#call_history");
		} else if (url.equals("")) {

		} else if (url.equals("")) {

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

	@Test(priority = 7)
	private void settings_Module() throws InterruptedException, IOException {
		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);
		sleep(3000);
		clickIntercept(pom.getInstanceSetting().basicInfoEditIcon, 30);

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
	

	visbility(driver, pom.getInstanceSetting().firstName, 40);
	clear(pom.getInstanceSetting().firstName);
	sendkeys(pom.getInstanceSetting().firstName, "Automation Acc");

	visbility(driver, pom.getInstanceSetting().lastName, 40);
	clear(pom.getInstanceSetting().lastName);
	sendkeys(pom.getInstanceSetting().lastName, "Automation Acc");
		sleep(3000);
		clickIntercept(pom.getInstanceSetting().basicInfoAdminstatus, 30);

		for (WebElement status : pom.getInstanceSetting().basicInfoAdminstatusDropdown) {
			if (status.getText().trim().equals("ACTIVE")) {
				visbility(driver, status, 40);
				clickIntercept(status, 30);

				break;
			}

		}

		sleep(2000);
		clickIntercept(pom.getInstanceSetting().basicInfoSmsNotication, 30);

		visbility(driver, pom.getInstanceSetting().subscribe, 50);
		elementClickable(pom.getInstanceSetting().subscribe);
		clickIntercept(pom.getInstanceSetting().subscribe,30);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		clickIntercept(pom.getInstanceSetting().$editplan$,30);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				elementClickable(pom.getInstanceSetting().$Carosel$);
				
				System.out.println("carosel clicked");
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

				for (int iN = 1; iN <= 3; iN++) {

					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					elementClickable(pom.getInstanceSetting().$Carosel$);
					actions("click", pom.getInstanceSetting().$Carosel$);
				}
				System.out.println(e);
			}
		}
		navigateback(2);

		while (true) {
			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (!driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				break;
			}
		}

		// cds


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

		// setforms

		WebElement f1 = driver.findElement(By.xpath("//button[@id='form-script']"));

		visbility(driver, f1, 60);
		elementClickable(f1);
		clickIntercept(f1,30);

		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		clickIntercept(pom.getInstanceSetting().subscribe,30);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		clickIntercept(pom.getInstanceSetting().$editplan$,30);
		System.out.println("ENTER CAROSEL");

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				elementClickable(pom.getInstanceSetting().$Carosel$);
			
				System.out.println("carosel clicked");
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

				for (int iN = 1; iN <= 3; iN++) {

					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					elementClickable(pom.getInstanceSetting().$Carosel$);
					actions("click", pom.getInstanceSetting().$Carosel$);
				}
				System.out.println(e);
			}
		}
		driver.navigate().back();
		sleep(5000);

		// market place

		WebElement $mrktplace$ = driver.findElement(By.xpath("//button[text()='Market Place']"));
		visbility(driver, $mrktplace$, 60);
		elementClickable($mrktplace$);
		clickIntercept($mrktplace$,30);

		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 40);
		elementClickable(pom.getInstanceSetting().$eirsystembutton$);
		clickIntercept(pom.getInstanceSetting().$eirsystembutton$,30);

		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		clickIntercept(pom.getInstanceSetting().subscribe,30);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				elementClickable(pom.getInstanceSetting().$Carosel$);
				
				System.out.println("carosel clicked");
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

				for (int iN = 1; iN <= 3; iN++) {

					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					elementClickable(pom.getInstanceSetting().$Carosel$);
					actions("click", pom.getInstanceSetting().$Carosel$);
				}
				System.out.println(e);
			}
		}

		navigateback(2);
		System.out.println("exit market place");

		ScriptExecutor($mrktplace$);
		
		try {

			WebElement $$edit$$notify$$message$$ = driver
					.findElement(By.xpath("//input[@id='all-notification-mess']//following::span[1]"));
			elementClickable($$edit$$notify$$message$$);
			actions("click", $$edit$$notify$$message$$);
			System.out.println("clicked Notication toggle button");

		} catch (Exception e) {
			WebElement $$edit$$notify$$message$$ = driver
					.findElement(By.xpath("(//span[@class='slider1 round1'])[10]"));
			elementClickable($$edit$$notify$$message$$);
			actions("click", $$edit$$notify$$message$$);

		}
		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		click(pom.getInstanceSetting().subscribe);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int in = 1; in <= 2; in++) {
					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);
					sleep(2500);
				}
			}
		}
		sleep(2500);
		driver.navigate().back();

		// Audit Report
		try {
			WebElement auditReport = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
			// ScriptExecutor(auditReport);
			visbility(driver, auditReport, 60);
			elementClickable(auditReport);
			clickIntercept(auditReport,30);
		} catch (Exception e) {
			WebElement auditReport = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
			// ScriptExecutor(auditReport);
			visbility(driver, auditReport, 60);
			elementClickable(auditReport);
			clickIntercept(auditReport,30);
		}
		visbility(driver, pom.getInstanceSetting().subscribe, 50);
		elementClickable(pom.getInstanceSetting().subscribe);
		clickIntercept(pom.getInstanceSetting().subscribe,30);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		clickIntercept(pom.getInstanceSetting().$editplan$,30);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int in = 1; in <= 2; in++) {
					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);
					sleep(2500);
				}
			}
		}

		j.executeScript("window.scrollBy(0,350)", "");
		sleep(4000);
		driver.navigate().back();

	}
}
