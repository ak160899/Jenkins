package SubscriptionFeatures;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
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

public class Dr_login_basicFeatures extends Base {

	public static WebDriver driver;
	PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid = "";

	@BeforeClass
	private void LaunchBrwoser() throws InterruptedException, IOException {

		driver = setUp("chrome");
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 20);
		String ur = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();

		while (true) {
			if (ur.equals("https://localhost:8443/")) {

				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				sleep(3000);
				driver.findElement(By.id("details-button")).click();
				sleep(3000);

				driver.findElement(By.id("proceed-link")).click();
				sleep(4000);
				implicitWait(60, TimeUnit.SECONDS);

				break;
			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.get("https://www.75health.com/login.jsp");

				break;
			}

		}

		click(pom.getInstanceLoginPage().sigIn);
		sleep(2000);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);
		ww.until(ExpectedConditions.urlToBe("https://localhost:8443/health/#home"));

		implicitWait(70, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	private void home() {
		while (true) {
			try {

				WebElement ata = driver.findElement(By.xpath("(//span[contains(text(),'New Pa')])[4]//parent::button"));
				visbility(driver, ata, 60);
				ww.until(ExpectedConditions.elementToBeClickable(ata));

				j.executeScript("arguments[0].click();", ata);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
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
		} // Acc gets Created..
		click(pom.getInstanceNewPatient().CreatePatient);

		WebElement id = driver.findElement(By.xpath("//td[@id='val-kpid']"));
		visbility(driver, id, 60);
		kpid = id.getText();

	}

	@Test(priority = 1)
	private void $Ehr_features() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#list_ehr");
		while (true) {
			try {
				WebElement remv = driver
						.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
				visbility(driver, remv, 60);

				javascriptclick(remv);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		List<WebElement> wwe;
		while (true) {
			try {
				wwe = driver.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
				System.out.println(wwe.size());
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : wwe) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);

				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
		visbility(driver, r7, 60);
		r7.click();

		WebElement elipse = driver.findElement(By.xpath("(//span[@id='list_patient_needHelp'])[1]/span"));
		visbility(driver, elipse, 60);
		clickble(driver, elipse, 60);
		actions("click", elipse);

		List<WebElement> hh = driver
				.findElements(By.xpath("(//span[@id='list_patient_needHelp'])[1]/span//following::ul[1]/li"));
		for (WebElement web : hh) {
			if (web.getText().trim().equals("Reset Setting")) {
				visbility(driver, web, 60);
				web.click();
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
		while (true) {
			try {
				WebElement formaddbtn = driver.findElement(By.xpath("//div[contains(@title,'Add Forms')]"));
				actions("move to element", formaddbtn);
				visbility(driver, formaddbtn, 60);
				javascriptclick(formaddbtn);
				WebElement $closeformskpop$ = driver
						.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/div[2]/span"));
				visbility(driver, $closeformskpop$, 60);
				click($closeformskpop$);
				break;
			} catch (Exception e) {

			}
		}

		// Attach file..
		while (true) {
			try {

				WebElement attachfileAddBtn = driver.findElement(By.xpath("//div[contains(@title,'Add Attach File')]"));
				actions("move to element", attachfileAddBtn);
				visbility(driver, attachfileAddBtn, 60);
				javascriptclick(attachfileAddBtn);
				WebElement attdropdown = driver
						.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[1]/select"));
				dropDown("index", attdropdown, "3");
				WebElement $closeattachilekpop$ = driver
						.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[1]/div[2]/span[2]"));
				visbility(driver, $closeattachilekpop$, 60);
				click($closeattachilekpop$);

				break;
			} catch (Exception e) {

			}

		}

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

		// follow up custom option checking...

		while (true) {

			try {

				driver.findElement(By.xpath("(//button[contains(@title,'Add Multiple Vitals')])[1]")).click();

				driver.findElement(By.id("wresult")).sendKeys("55");
				WebElement edity = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
				visbility(driver, edity, 60);
				javascriptclick(edity);

				WebElement createfollowup = driver.findElement(By.xpath("(//button[@id='followUpAdd'])[1]/div[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(createfollowup));
				actions("click", createfollowup);
				sleep(4000);
				implicitWait(30, TimeUnit.SECONDS);
				WebElement crt = driver.findElement(
						By.xpath("//div[@id='followupEhr']/div[2]/div[3]/div[1]//following::div[2]/input"));
				actions("click", crt);
				sleep(2000);
				WebElement folowypyr = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				dropDown("text", folowypyr, "2022");
				WebElement folowupmnth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				dropDown("index", folowupmnth, "0");
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

						WebElement sm = driver.findElement(
								By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + jj + "]/div/div[2]/span[3]"));
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

				break;
			} catch (Exception e) {

			}

		}
		sleep(2000);
	}

	@Test(priority = 2)
	private void $$calendarFeatures() throws Exception {

		Calendars cal = new Calendars(driver, pom);
		cal.caledarModule();
		String url = driver.getCurrentUrl();
		cal.$calenderMod(url, kpid);
	}

	@Test(priority = 2)
	private void settings() throws InterruptedException {

		// manage yor account..

		while (true) {
			driver.navigate().to("https://localhost:8443/health/#setting");
			String s = "https://localhost:8443/health/#setting";
			if (driver.getCurrentUrl().equals(s)) {
				break;
			}
			driver.navigate().refresh();

		}

		while (true) {
			try {
				driver.findElement(By.xpath("//button[text()='Manage your Account']")).click();
				sleep(3000);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		while (true) {
			try {
				WebElement $previlegde$ = driver
						.findElement(By.xpath("//span[text()='Privileges']//following::span[1]"));
				visbility(driver, $previlegde$, 60);
				actions("click", $previlegde$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		driver.navigate().back();

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
				sleep(4000);
				break;
			} catch (Exception e) {

			}

		}
		driver.navigate().to("https://localhost:8443/health/#setting");

		// problems.

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
						// TODO: handle exception
					}
				}

				WebElement clickadditem = driver.findElement(By.xpath(
						"//div[@id='referral']//following::div[1]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, clickadditem, 60);
				click(clickadditem);
				WebElement sdf = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[2]//following::input[1]"));
				visbility(driver, sdf, 60);
				sendkeys(sdf, "test"); // .sendKeys("test");
				WebElement sdf2 = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[2]//following::input[2]"));
				visbility(driver, sdf2, 60);
				sendkeys(sdf2, "5"); // .sendKeys("5");
				WebElement saveitem = driver.findElement(
						By.xpath("//div[@id='referral']//following::div[1]/div[3]/div/div/div[2]/div[6]/div/button"));
				visbility(driver, saveitem, 60);
				javascriptclick(saveitem);

				sleep(2000);
				WebElement edititem = driver.findElement(By.xpath("//span[text()='test']"));
				visbility(driver, edititem, 60);
				actions("click", edititem);
				WebElement deleteitem = driver.findElement(
						By.xpath("//div[@id='referral']//following::div[1]/div[3]/div/div/div[1]/div[2]/span[1]"));
				visbility(driver, deleteitem, 60);
				javascriptclick(deleteitem);

				WebElement itemservicebackarrow = driver
						.findElement(By.xpath("(//div[@id='invoiceAdd'])[1]/div[1]/div[1]/span[1]"));
				visbility(driver, itemservicebackarrow, 60);
				javascriptclick(itemservicebackarrow);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			} else if (w.getText().trim().contentEquals("Message")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				WebElement addnewfavmessage = driver
						.findElement(By.xpath("(//div[@id='message'])[1]/div[1]/div//following::td[4]/span[2]"));
				visbility(driver, addnewfavmessage, 60);
				javascriptclick(addnewfavmessage);

				WebElement msf = driver.findElement(By.xpath("//textarea[@id='message1']"));

				visbility(driver, msf, 60);
				sendkeys(msf, "hello");
				WebElement savemesssage = driver
						.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
				visbility(driver, savemesssage, 60);
				javascriptclick(savemesssage);
				sleep(2500);
				WebElement editmessage = driver.findElement(By.xpath("//div[text()='hello']"));
				actions("click", editmessage);
				WebElement deletemessage = driver
						.findElement(By.xpath("//div[@id='MessageKpop2']/div[1]/div[2]/span[1]"));
				visbility(driver, deletemessage, 60);
				javascriptclick(deletemessage);

				sleep(3000);
				WebElement gobackmessage = driver
						.findElement(By.xpath("(//span[text()='Favorite Message'])[1]//following::div[1]/span"));
				visbility(driver, gobackmessage, 60);
				javascriptclick(gobackmessage);

				sleep(3000);

			}

		}
		sleep(2000);
		// notification..
		while (true) {
			try {
				WebElement $$edit$$notify$$message$$ = driver.findElement(By
						.xpath("//span[text()='Edit Notification Messages']//parent::div//parent::div[1]/label/input"));

				actions("click", $$edit$$notify$$message$$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		/*
		 * WebElement $dismisspreilde$ = driver.findElement(By.xpath(
		 * "//p[text()='No privileges to modify Notification Permissions .. Contact Administrator.']//following::div[1]/button"
		 * )); WebElement $notifytillScroll$ =
		 * driver.findElement(By.xpath("//div[@id='email-notification']/div[1]"));
		 * ScriptExecutor($notifytillScroll$); sleep(2000); visbility(driver,
		 * $dismisspreilde$, 60); click($dismisspreilde$);
		 */
	}

}
