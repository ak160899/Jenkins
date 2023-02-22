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

public class Lite_package extends Base {

	public WebDriver driver;
	PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid;
	Calendars cal;
	String ur;
	String currenurl;

	@BeforeClass
	private void LaunchBrwoser() throws Exception {

		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");
		driver = (WebDriver) getConnection.get("driver");

		WebElement upgradelater = driver.findElement(By.xpath("(//div[@id='AlertMessage']//following::button[1])[1]"));
		visbility(driver, upgradelater, 40);
		elementClickable(upgradelater);
		click(upgradelater);
	}

	@Test(priority = 1)
	private void home() throws InterruptedException {

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

		driver.findElement(By.id("userloginId")).sendKeys("abcdefg@gmail.com");
		WebElement countryFlagButon = driver.findElement(By.xpath("//div[@class='selected-flag']"));
		visbility(driver, countryFlagButon, 50);
		elementClickable(countryFlagButon);
		click(countryFlagButon);

		List<WebElement> flagchoose = driver
				.findElements(By.xpath("//div[@class='selected-flag']//following::ul[1]/li/span[2]"));
		for (WebElement flagcode : flagchoose) {
			if (flagcode.getText().trim().equals("+91")) {

				elementClickable(flagcode);
				click(flagcode);
				break;
			}

		}

		driver.findElement(By.id("Phone")).sendKeys("9551824155");
		// Acc gets Created..
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

				String tr = tp.getText();
				System.out.println(tr);
				boolean trp = tp.isDisplayed();
				String rrs = tp.getAttribute("id");

				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed() && !tp.getText().isEmpty()) {

					cond = true;
					visbility(driver, tp, 60);
					javascriptclick(tp);

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
				//// ul[@id='ui-id-2']/li/a/table/tbody/tr/td[2]

				// (//td[text()='" + kpid + "'])[2]//parent::td
				for (WebElement web : choosepatient) {
					if (web.getText().trim().equals(kpid)) {
						visbility(driver, web, 60);
						web.click();
						break;
					}

				}

				try {
					WebElement $selectappType = driver
							.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + a + "]"));
					System.out.println($selectappType);
					visbility(driver, $selectappType, 40);
					elementClickable($selectappType);
					click($selectappType);
				} catch (Exception e) {
					WebElement $selectappType = driver
							.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + a + "]"));
					System.out.println($selectappType);
					visbility(driver, $selectappType, 40);
					elementClickable($selectappType);
					click($selectappType);
				}
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])//following::ul[1]/li/a"));
				for (WebElement Element : $TypeDropdown) {
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						click(Element);
						break;
					}

				}

				sleep(4000);

				visbility(driver, pom.getInstanceSetting().dismiss, 40);
				elementClickable(pom.getInstanceSetting().dismiss);
				click(pom.getInstanceSetting().dismiss);

				WebElement qt = driver.findElement(By.xpath("(//textarea[@id='description'])[" + a + "]"));
				visbility(driver, qt, 60);
				qt.sendKeys("no worries...");
				WebElement utt = driver.findElement(By.xpath("(//button[@id='statusId_dropdown'])[" + a + "]"));
				clickble(driver, utt, 60);
				j.executeScript("arguments[0].click();", utt);

				List<WebElement> lop = driver.findElements(By.xpath("(//ul[@id='statusIdDropdown'])[" + a + "]/li"));
				for (WebElement w : lop) {
					if (w.getText().trim().equals("In Progress")) {
						w.click();
						break;
					}

				}

				WebElement vcv = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
				visbility(driver, vcv, 60);
				clickble(driver, vcv, 60);
				j.executeScript("arguments[0].click();", vcv);

				WebElement pip = driver.findElement(By.xpath("//span[text()='" + hkpid + "']"));
				visbility(driver, pip, 60);
				j.executeScript("arguments[0].click();", pip);

				sleep(2000);
				WebElement wtw = driver.findElement(By.xpath("(//span[@id='del-btn'])[" + i + "]"));
				clickble(driver, wtw, 60);
				j.executeScript("arguments[0].click();", wtw);

				WebElement delapp = driver
						.findElement(By.xpath("//div[@id='AppointmentCreateMessage']/div[2]/div[2]/button[2]"));
				clickble(driver, delapp, 60);
				javascriptclick(delapp);

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
			WebElement remv = driver.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
			visbility(driver, remv, 60);

			elementClickable(remv);
			click(remv);

		} catch (ElementClickInterceptedException e) {
			System.out.println("exception in ehr");
			WebElement remv = driver.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
			visbility(driver, remv, 60);

			elementClickable(remv);
			click(remv);
		}

		List<WebElement> wwe = driver
				.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
		for (WebElement web : wwe) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				elementClickable(web);

				click(web);
				break;
			}

		}
		sleep(2000);

		WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
		elementClickable(r7);
		click(r7);

		WebElement elipse = driver.findElement(By.xpath("(//span[@id='list_patient_needHelp'])[1]/span"));
		visbility(driver, elipse, 60);
		clickble(driver, elipse, 60);
		click(elipse);

		List<WebElement> hh = driver
				.findElements(By.xpath("(//span[@id='list_patient_needHelp'])[1]/span//following::ul[1]/li"));
		for (WebElement web : hh) {
			if (web.getText().trim().equals("Reset Setting")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);
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
		click(formaddbtn);

		WebElement clickupgradebtninfrm = driver.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
		elementClickable(clickupgradebtninfrm);
		click(clickupgradebtninfrm);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);
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

		WebElement attachfileAddBtn = driver.findElement(By.xpath("//div[contains(@title,'Add Attach File')]"));
		actions("move to element", attachfileAddBtn);
		visbility(driver, attachfileAddBtn, 60);
		elementClickable(attachfileAddBtn);
		click(attachfileAddBtn);

		WebElement attdropdown = driver.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[1]/select"));
		dropDown("index", attdropdown, "3");
		WebElement clickupgradebtninattach = driver.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
		elementClickable(clickupgradebtninattach);
		click(clickupgradebtninattach);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

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

				List<WebElement> folloupAppointmentDropDown = driver.findElements(
						By.xpath("(//button[@id='followupAdmissionVal_dropdown'])[1]//following::ul[1]/li/a/span[2]"));
				for (WebElement chooseType : folloupAppointmentDropDown) {
					if (chooseType.getText().trim().equals("Emergency")) {
						visbility(driver, chooseType, 40);
						elementClickable(chooseType);
						click(chooseType);
						break;
					}
				}
				break;

			}
		}

		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		click(pom.getInstanceSetting().subscribe);

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
		currenurl = driver.getCurrentUrl();

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));
		int totalr = totalnumberrowdy.size();
		// System.out.println("found you>>>" + totalr);

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

				// String tr = tp.getText();
				// boolean trp = tp.isDisplayed();

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
				//// ul[@id='ui-id-2']/li/a/table/tbody/tr/td[2]

				// (//td[text()='" + kpid + "'])[2]//parent::td
				for (WebElement web : choosepatient) {
					if (web.getText().trim().equals(kpid)) {
						visbility(driver, web, 60);
						web.click();
						break;
					}

				}
				sleep(3000);

				try {
					WebElement $selectappType = driver
							.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + count + "]"));
					visbility(driver, $selectappType, 40);
					click($selectappType);
				} catch (Exception e) {
					// TODO: handle exception
				}
				sleep(3000);
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])//following::ul[1]/li/a"));
				for (WebElement Element : $TypeDropdown) {
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						click(Element);
						break;
					}

				}

				for (int in = 1; in <= 5; in++) {
					try {
						WebElement $dismiss = driver
								.findElement(By.xpath("//span[text()='Premium Subscription']//following::button[1]"));

						if ($dismiss.isDisplayed()) {
							click($dismiss);
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
				javascriptclick(utt);

				List<WebElement> lop = driver
						.findElements(By.xpath("(//ul[@id='statusIdDropdown'])[" + count + "]/li"));
				for (WebElement w : lop) {
					if (w.getText().trim().equals("In Progress")) {
						visbility(driver, w, 60);
						w.click();
						break;
					}

				}

				WebElement vcv = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
				visbility(driver, vcv, 60);
				ScriptExecutor(vcv);

				javascriptclick(vcv);

				sleep(1000);

				WebElement ez = driver.findElement(By.xpath("//span[text()='" + kpid + "']"));
				visbility(driver, ez, 60);
				javascriptclick(ez);

				sleep(2000);
				// goto ehr..
				WebElement ehr = driver.findElement(By.id("goEhrButton"));

				visbility(driver, ehr, 60);
				elementClickable(ehr);
				click(ehr);// .click();

				sleep(3000);
				/*
				 * driver.navigate().back(); driver.navigate().refresh();
				 */

				try {
					visbility(driver, pom.getInstanceCalendar().clickCalendar, 40);
					elementClickable(pom.getInstanceCalendar().clickCalendar);
					click(pom.getInstanceCalendar().clickCalendar);
					driver.navigate().refresh();

				} catch (ElementClickInterceptedException e) {
					visbility(driver, pom.getInstanceCalendar().clickCalendar, 40);
					elementClickable(pom.getInstanceCalendar().clickCalendar);
					click(pom.getInstanceCalendar().clickCalendar);
					driver.navigate().refresh();
				}

				break;

			}

		}
	}

	@Test(priority = 5)
	private void billing_module() throws InterruptedException {
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

	@Test(priority = 7)
	private void settings_Module() throws InterruptedException, IOException {

		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (!driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				break;
			}

		}

		// manageYour account...

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

		visbility(driver, pom.getInstanceSetting().subscribe, 50);
		elementClickable(pom.getInstanceSetting().subscribe);
		click(pom.getInstanceSetting().subscribe);

		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				elementClickable(pom.getInstanceSetting().$Carosel$);
				// click(pom.getInstanceSetting().$Carosel$);
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

		while (true) {
			try {

				WebElement cdsclick = driver.findElement(By.xpath("//button[contains(text(),'Clinical Decision')]"));
				visbility(driver, cdsclick, 60);
				click(cdsclick);

				WebElement newcds = driver.findElement(By.xpath("//span[contains(text(),'New Clinical')]"));
				visbility(driver, newcds, 60);
				click(newcds);

				WebElement scrolltill = driver.findElement(By.xpath("//input[@id='weight_from']"));
				ScriptExecutor(scrolltill);
				sleep(2000);
				visbility(driver, scrolltill, 60);
				WebElement s9 = driver.findElement(By.xpath("(//input[@id='problem_icd_10'])[2]"));
				visbility(driver, s9, 60);
				sendkeys(s9, "test");
				sleep(5000);
				break;
			} catch (Exception e) {

			}

		}
		driver.navigate().to("https://localhost:8443/health/#setting");

		// setforms

		WebElement f1 = driver.findElement(By.xpath("//button[@id='form-script']"));

		visbility(driver, f1, 60);
		elementClickable(f1);
		click(f1);

		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		click(pom.getInstanceSetting().subscribe);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);
		System.out.println("ENTER CAROSEL");

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				elementClickable(pom.getInstanceSetting().$Carosel$);
				// click(pom.getInstanceSetting().$Carosel$);
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
		click($mrktplace$);

		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 40);
		elementClickable(pom.getInstanceSetting().$eirsystembutton$);
		click(pom.getInstanceSetting().$eirsystembutton$);

		visbility(driver, pom.getInstanceSetting().subscribe, 40);
		elementClickable(pom.getInstanceSetting().subscribe);
		click(pom.getInstanceSetting().subscribe);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				elementClickable(pom.getInstanceSetting().$Carosel$);
				// click(pom.getInstanceSetting().$Carosel$);
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
		// notification
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
			click(auditReport);
		} catch (Exception e) {
			WebElement auditReport = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
			// ScriptExecutor(auditReport);
			visbility(driver, auditReport, 60);
			elementClickable(auditReport);
			click(auditReport);
		}
		visbility(driver, pom.getInstanceSetting().subscribe, 50);
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

		j.executeScript("window.scrollBy(0,350)", "");
		sleep(4000);
		driver.navigate().back();

	}
}
