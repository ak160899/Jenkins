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

public class Basic_features extends Base {

	public static WebDriver driver;
	PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	static String kpid = "";
	public static String url;
	static Calendars cal;
	String $current;
	public String ur;

	@BeforeClass
	private void LaunchBrwoser() throws Exception {
		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");

		driver = (WebDriver) getConnection.get("driver");
	}

	@Test(priority = 0)
	private void home() throws Exception {
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

		try {
			WebElement $patietcreateid$ = driver.findElement(By.xpath("//td[@id='val-kpid']"));
			visbility(driver, $patietcreateid$, 40);
			kpid = $patietcreateid$.getText();
			System.out.println("HOME PATIENT" + kpid);

		} catch (Exception e) {
			WebElement $patietcreateid$ = driver.findElement(By.xpath("//td[@id='val-kpid']"));
			visbility(driver, $patietcreateid$, 40);
			kpid = $patietcreateid$.getText();
			System.out.println("HOME PATIENT" + kpid);
		}

		navigateback(2);
		$current = driver.getCurrentUrl();
		cal = new Calendars(driver, pom);
		cal.$calenderMod($current, kpid);
	}

	@Test(priority = 1, enabled = false)
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
				break;

			}
		}

		sleep(4000);

	}

	@Test(priority = 2, enabled = false)
	private void $$calendarFeatures() throws Exception {

		Calendars cal = new Calendars(driver, pom);
		cal.caledarModule();
		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);

	}

	@Test(priority = 3)
	private void $$settings$$() throws InterruptedException {

		while (true) {
			driver.navigate().to("https://localhost:8443/health/#setting");
			String s = "https://localhost:8443/health/#setting";
			if (driver.getCurrentUrl().equals(s)) {
				break;
			}
			driver.navigate().refresh();

		}

		// Manage your Account...

		while (true) {
			try {

				driver.findElement(By.xpath("//button[text()='Manage your Account']")).click();

				while (true) {
					try {
						WebElement Basicinfo = driver.findElement(By.xpath("(//span[@title='Edit'])[2]"));
						visbility(driver, Basicinfo, 60);
						javascriptclick(Basicinfo);
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				WebElement $$smsnotifcation$ = driver.findElement(By.xpath("(//button[@id='smsP'])[1]"));
				visbility(driver, $$smsnotifcation$, 60);
				javascriptclick($$smsnotifcation$);

				WebElement $$setformsupgrdaebtn$$ = driver
						.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
				visbility(driver, $$setformsupgrdaebtn$$, 60);
				click($$setformsupgrdaebtn$$);
				WebElement $click$edit$plan$ = driver.findElement(By.xpath("//button[@id='editPlanBtn']"));
				visbility(driver, $click$edit$plan$, 60);
				javascriptclick($click$edit$plan$);

				for (int i = 1; i <= 2; i++) {
					try {
						visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
						actions("click", pom.getInstanceSetting().$Carosel$);
						sleep(2500);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				sleep(3000);
				j.executeScript("window.scrollBy(0,350)", "");
				sleep(4000);
				driver.navigate().to("https://localhost:8443/health/#setting");

				break;
			} catch (Exception e) {

			}
		}
		// cds(clinical des support)

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

			}

		}
		// Set forms..

		WebElement f1 = driver.findElement(By.xpath("//button[@id='form-script']"));
		visbility(driver, f1, 60);
		click(f1);// .click();

		WebElement $$setformsupgrdaebtn$$ = driver.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
		visbility(driver, $$setformsupgrdaebtn$$, 60);
		click($$setformsupgrdaebtn$$);
		while (true) {
			try {

				if (driver.getCurrentUrl().equals("https://localhost:8443/health/#allPaymentServices")) {

					WebElement $click$edit$plan$ = driver.findElement(By.xpath("//button[@id='editPlanBtn']"));
					visbility(driver, $click$edit$plan$, 60);
					click($click$edit$plan$);
					sleep(2000);
					for (int i = 1; i <= 2; i++) {
						try {
							visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
							actions("click", pom.getInstanceSetting().$Carosel$);
							sleep(2500);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					j.executeScript("window.scrollBy(0,350)", "");
					sleep(4000);
					driver.navigate().back();
					break;

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// market place..
		WebElement $marketplace$;
		while (true) {
			try {

				$marketplace$ = driver.findElement(By.xpath("//button[text()='Market Place']"));

				sleep(2000);
				visbility(driver, $marketplace$, 60);
				click($marketplace$);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		driver.navigate().back();
		sleep(2000);

		try {
			ScriptExecutor($marketplace$);
			sleep(2500);
		} catch (Exception e) {
			ScriptExecutor($marketplace$);
			sleep(2500);
		}

		// Notifications...

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
		WebElement $$plnupgrd$$detaisl$ = driver.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
		visbility(driver, $$plnupgrd$$detaisl$, 60);
		click($$plnupgrd$$detaisl$);

		j.executeScript("window.scrollBy(0,350)", "");
		sleep(4000);
		WebElement $click$edit$planz$ = driver.findElement(By.xpath("//button[@id='editPlanBtn']"));
		ScriptExecutor($click$edit$planz$);
		visbility(driver, $click$edit$planz$, 60);
		javascriptclick($click$edit$planz$);
		sleep(4000);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				click(pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}

		sleep(3000);
		driver.navigate().back();

		// Audit Report...
		while (true) {
			try {
				WebElement rqqa = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
				ScriptExecutor(rqqa);
				visbility(driver, rqqa, 60);
				javascriptclick(rqqa);

				WebElement $$plnupgrd$$detail$ = driver
						.findElement(By.xpath("(//button[contains(@title,'Upgrade')])[3]"));
				visbility(driver, $$plnupgrd$$detail$, 60);
				click($$plnupgrd$$detail$);
				WebElement $click$edit$plan$ = driver.findElement(By.xpath("//button[@id='editPlanBtn']"));
				visbility(driver, $click$edit$plan$, 60);
				javascriptclick($click$edit$plan$);
				for (int i = 1; i <= 2; i++) {
					try {
						visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
						click(pom.getInstanceSetting().$Carosel$);
						sleep(2500);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				sleep(3000);
				j.executeScript("window.scrollBy(0,350)", "");
				sleep(4000);
				driver.navigate().back();
				break;
			} catch (Exception e) {

			}
		}

		// edit scenario..

		while (true) {
			try {
				WebElement $basicfe$ = driver.findElement(By.xpath("(//span[text()='Basic'])[1]"));
				if ($basicfe$.isDisplayed()) {
					visbility(driver, $basicfe$, 60);
					javascriptclick($basicfe$);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
