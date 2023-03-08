package runner;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.github.dockerjava.api.model.SELContext;
import com.healthRec.Forms;
import com.healthRec.Goals;
import com.healthRec.Medication;
import com.healthRec.Problems;
import com.healthRec.Procedure;
import com.healthRec.Symptoms;
import com.healthRec.Vaccine;
import com.healthRec.Vitals;
import com.pageObjeman.PageObjMan;

public class Dr_userLogin extends Base {

	public static WebDriver driver;
	static PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid;
	String ur;
	Calendars cal;
	String $current;

	@BeforeClass
	public void LaunchBrwoser() throws Exception {

		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");
		driver = (WebDriver) getConnection.get("driver");
	}

	@Test(priority = 0,enabled = false)
	public void HomeModule() throws Exception {

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

		navigateback(2);

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);

	}

	@Test(priority = 1)
	public void PatientModule() throws InterruptedException {
		try {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 50);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
		} catch (ElementClickInterceptedException e) {
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

		WebElement s = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[2]"));
		visbility(driver, s, 60);
		s.sendKeys(kpid);

		try {
			WebElement kp = driver.findElement(By.xpath("//div[text()=" + "'" + kpid + "']"));
			elementClickable(kp);
			click(kp);

		} catch (ElementClickInterceptedException e) {
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

		sleep(2500);

		// alternate contact info...

		try {
			visbility(driver, pom.getInstanceNewPatient().AlternateContactIcon, 40);
			elementClickable(pom.getInstanceNewPatient().AlternateContactIcon);
			click(pom.getInstanceNewPatient().AlternateContactIcon);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().AlternateContactIcon, 40);
			elementClickable(pom.getInstanceNewPatient().AlternateContactIcon);
			click(pom.getInstanceNewPatient().AlternateContactIcon);

		} catch (StaleElementReferenceException e) {
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
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceNewPatient().addPatientInfoIcon, 40);
			elementClickable(pom.getInstanceNewPatient().addPatientInfoIcon);
			click(pom.getInstanceNewPatient().addPatientInfoIcon);
		}

		visbility(driver, pom.getInstanceNewPatient().addOccupation, 30);
		sendkeys(pom.getInstanceNewPatient().addOccupation, "Software tester");

		elementClickable(pom.getInstanceNewPatient().savePatientinfo);
		click(pom.getInstanceNewPatient().savePatientinfo);

		try {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 40);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().$patienmod, 40);
			elementClickable(pom.getInstanceNewPatient().$patienmod);
			click(pom.getInstanceNewPatient().$patienmod);
		} catch (StaleElementReferenceException e) {
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
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceNewPatient().patientmodReport, 40);
			elementClickable(pom.getInstanceNewPatient().patientmodReport);
			click(pom.getInstanceNewPatient().patientmodReport);
		}
		visbility(driver, pom.getInstanceNewPatient().patientReportSerachNametxtBox, 40);
		sendkeys(pom.getInstanceNewPatient().patientReportSerachNametxtBox, "Kaaspro");

	}

	@Test(priority = 2)
	public void HealthRec() throws Exception {

		if (ur.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (ur.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (ur.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
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

		WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
		visbility(driver, r7, 60);
		r7.click();

		/*
		 * WebElement elipse =
		 * driver.findElement(By.xpath("(//span[@id='list_patient_needHelp'])[1]/span"))
		 * ; visbility(driver, elipse, 60); clickble(driver, elipse, 60);
		 * actions("click", elipse);
		 * 
		 * List<WebElement> hh = driver .findElements(By.xpath(
		 * "(//span[@id='list_patient_needHelp'])[1]/span//following::ul[1]/li")); for
		 * (WebElement web : hh) { if (web.getText().trim().equals("Reset Setting")) {
		 * visbility(driver, web, 60); web.click(); break; }
		 * 
		 * }
		 */

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

		for (int i = 1; i <= ehrrow; i++) {

			List<WebElement> qf = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div"));
			for (int j = 1; j <= qf.size(); j++) {

				WebElement gettag = driver
						.findElement(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div[" + j + "]"));
				visbility(driver, gettag, 60);

				String tagnames = gettag.getAttribute("id");

				if (tagnames.equals("vital")) {
					//Vitals v = new Vitals(driver);
				//	v.vitalsFeature();

				} else if (tagnames.equals("visit-reason")) {
					implicitWait(60, TimeUnit.SECONDS);

					WebElement u = driver.findElement(By.xpath("//div[contains(@title,'Add Visit R')]"));

					if (u.isDisplayed()) {
						click(u);
					} else {
						if (!u.isDisplayed()) {
							actions("move to element", u);
							click(u);
						}
					}

					try {
						visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 60);
						click(pom.getInstanceCalendar().selectAppointmentType);

					} catch (Exception e) {
						System.out.println(e);
					}

					List<WebElement> $TypeDropdown = driver.findElements(
							By.xpath("(//button[@id='admissionVal_dropdown'])[2]//following::ul[1]/li/a"));

					for (WebElement Element : $TypeDropdown) {
						System.out.println(Element.getText());
						if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
							click(Element);
							break;
						}

					}
					sleep(2000);
					WebElement mj = driver
							.findElement(By.xpath("//div[@title='Enter the description of the patient visit']"));
					visbility(driver, mj, 60);
					mj.sendKeys("cold");

					WebElement svg = driver
							.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, svg, 60);
					//// div[@title='Enter the description of the patient
					//// visit']//following::div[28]/button[2]
					ww.until(ExpectedConditions.elementToBeClickable(svg));
					svg.click();
					sleep(2000);
					WebElement afk = driver.findElement(By.xpath("(//div[text()='cold'])[1]"));
					visbility(driver, afk, 60);
					ww.until(ExpectedConditions.elementToBeClickable(afk));
					actions("click", afk);

					implicitWait(30, TimeUnit.SECONDS);
					WebElement mjj = driver
							.findElement(By.xpath("//div[@title='Enter the description of the patient visit']"));
					visbility(driver, mjj, 60);
					ww.until(ExpectedConditions.elementToBeClickable(mjj));
					mjj.clear();
					mjj.sendKeys("KAASPRO");

					WebElement svg1 = driver
							.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, svg1, 60);
					svg1.click();

					/*
					 * WebElement delvis = driver
					 * .findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[1]/div[2]/span"));
					 * javascriptclick(delvis);
					 */
					sleep(3000);

				} else if (tagnames.equals("alert-allergy")) {

					WebElement add = driver.findElement(By.xpath("//div[contains(@title,'Add Allergy')]"));

					actions("move to element", add);
					visbility(driver, add, 60);
					ww.until(ExpectedConditions.elementToBeClickable(add));
					actions("click", add);
					WebElement se = driver.findElement(By.xpath("//select[@id='codeType']"));
					visbility(driver, se, 60);
					ww.until(ExpectedConditions.elementToBeClickable(se));
					se.click();
					dropDown("text", se, "Food Allergy");

					/* WebElement alcl = */ WebElement fd1 = driver
							.findElement(By.xpath("//div[@id='AllergyKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
					visbility(driver, fd1, 60);
					fd1.sendKeys("food1");

					sleep(2000);
					WebElement alrgy = driver.findElement(By.xpath("//input[@placeholder='Reaction']"));
					visbility(driver, alrgy, 60);
					alrgy.sendKeys("stomach pain");

					WebElement rer = driver.findElement(By.xpath("//div[@id='AllergyKpop2']/div[2]/div[2]/div/button"));
					visbility(driver, rer, 60);
					ww.until(ExpectedConditions.elementToBeClickable(rer));

					javascriptclick(rer);

					sleep(3000);
					List<WebElement> wtw = driver.findElements(By.xpath("//div[@id='smore-btn']/ul/li"));
					for (WebElement w : wtw) {
						if (w.getText().trim().equals("Show Severity")) {
							w.click();
							break;
						}

					}
					sleep(2000);

					javascriptclick(rer);

					for (WebElement w : wtw) {
						if (w.getText().trim().equals("Show Status")) {
							visbility(driver, rer, 60);
							w.click();
							break;
						}

					}
					WebElement s = driver.findElement(By.xpath("//select[@id='severity']"));

					dropDown("text", s, "Mild");
					sleep(2000);
					WebElement ss = driver.findElement(By.xpath("//select[@id='status']"));

					dropDown("text", ss, "Inactive");

					WebElement cl2 = driver.findElement(By.xpath("//div[@id='saveadd-btn']/button"));
					visbility(driver, cl2, 60);
					cl2.click();
					List<WebElement> sss = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
					for (WebElement w : sss) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}
					sleep(2000);
					WebElement mk = driver.findElement(By.xpath("//span[text()='food1']"));
					visbility(driver, mk, 60);
					ww.until(ExpectedConditions.elementToBeClickable(mk));
					actions("click", mk);
					sleep(2000);
					WebElement jk = driver
							.findElement(By.xpath("//div[@id='AllergyKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
					visbility(driver, jk, 60);
					jk.clear();
					jk.sendKeys("st");
					sleep(2000);
					WebElement scq = driver.findElement(By.xpath("//div[text()='Strawberry ']"));
					visbility(driver, scq, 60);
					ww.until(ExpectedConditions.elementToBeClickable(scq));
					actions("click", scq);

					WebElement cl5 = driver.findElement(By.xpath("//div[@id='saveadd-btn']/button"));
					visbility(driver, cl5, 60);
					cl5.click();
					List<WebElement> ssss = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
					for (WebElement w : ssss) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

					sleep(3000);
					/*
					 * WebElement cc = driver.findElement(By.xpath("//span[text()='Strawberry ']"));
					 * actions("click", cc); sleep(3000);
					 * driver.findElement(By.xpath("(//span[@id='del-btn'])[1]")).click();
					 * sleep(4000);
					 */

					// Social history....

					// WebElement sh = driver.findElement(By.xpath("//div[contains(@title,'Add
					// Social History')]"));

					/*
					 * WebElement sctag = driver.findElement(By.xpath(
					 * "//div[contains(@title,'Add Social History')]//parent::div[1]//parent::div//parent::div//parent::div//parent::div[@id='social-history']"
					 * ));
					 */

					WebElement sh = ww.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//div[contains(@title,'Add Social History')]")));
					actions("move to element", sh);
					visbility(driver, sh, 60);
					actions("click", sh);
					sleep(2000);
					WebElement ssc = driver.findElement(By.xpath("//select[@id='habitType']"));
					visbility(driver, ssc, 60);
					ssc.click();
					dropDown("text", ssc, "Alcohol");
					WebElement hbt = driver.findElement(By.xpath("//select[@id='habitType']//following::div[3]/input"));
					visbility(driver, hbt, 60);
					hbt.sendKeys("social histry");

					WebElement hbt2 = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
					visbility(driver, hbt2, 60);
					hbt2.click();
					sleep(2000);
					WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
					visbility(driver, jj, 60);

					actions("click", jj);
					sleep(2000);
					WebElement hbt4 = driver
							.findElement(By.xpath("//select[@id='habitType']//following::div[3]/input"));
					visbility(driver, hbt4, 60);
					hbt4.clear();
					// .clear();
					WebElement kspr = driver
							.findElement(By.xpath("//select[@id='habitType']//following::div[3]/input"));
					visbility(driver, kspr, 60);
					kspr.sendKeys("Kaaspro");
					WebElement hbt5 = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
					visbility(driver, hbt5, 60);
					hbt5.click();

					sleep(3000);

					/*
					 * WebElement shdel =
					 * driver.findElement(By.xpath("(//span[@id='del-btn'])[1]"));
					 * javascriptclick(shdel); sleep(4000);
					 */

					// Family Health...

					WebElement a = driver.findElement(By.xpath("//div[contains(@title,'Add Family Health')]"));

					actions("move to element", a);
					visbility(driver, a, 60);

					actions("click", a);
					WebElement ee = driver.findElement(By.xpath("//div[@id='Family_HealthKpop2']/div[2]/div/select"));
					visbility(driver, ee, 60);
					ee.click();
					dropDown("text", ee, "Half Brother");

					WebElement fh = driver.findElement(By.xpath(
							"//div[@id='Family_HealthKpop2']/div[2]/div/select//following::div[1]/div[2]/input"));
					visbility(driver, fh, 60);
					fh.sendKeys("24781");
					List<WebElement> fhkpop = null;

					while (true) {
						try {
							fhkpop = driver
									.findElements(By.xpath("//div[@id='Family_HealthKpop2']/div[2]/ul/li/a/div/small"));
							System.out.println("family health");
							// System.out.println("element has been finded.." + "size is:" + fhkpop.size());
							if (fhkpop.size() > 5) {
								System.out.println(">=2 " + fhkpop.size());
								break;
							}
						} catch (Exception e) {
							System.out.println("");
						}

					}
					boolean $familcond$ = false;
					for (WebElement web : fhkpop) {

						if (web.getText().trim().equals("ICD10 : F40.2 | SNOMED : 247810008")) {
							$familcond$ = true;
							visbility(driver, web, 60);
							click(web);

							break;
						}

					}
					if ($familcond$ == true) {
						WebElement atf = driver.findElement(By.xpath("//button[@id='btnSaveAdd']"));
						visbility(driver, atf, 60);
						javascriptclick(atf);
						List<WebElement> rr = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
						for (WebElement w : rr) {

							if (w.getText().trim().equals("Save")) {
								visbility(driver, w, 60);
								w.click();
								break;
							}

						}
					}

					sleep(3000);
					// Alert...
					WebElement $alert$;
					while (true) {
						try {

							$alert$ = driver.findElement(By.xpath("//div[contains(@title,'Add Alert')]"));

							// System.out.println("finded the alert icon");

							break;
						} catch (StaleElementReferenceException e) {
							// TODO: handle exception
						}
					}

					while (true) {

						try {
							actions("move to element", $alert$);

							// System.out.println("element is visble able to click");
							break;
						} catch (Exception e) {

						}
					}
					while (true) {
						try {
							// System.out.println("hello exception occurs here...");
							actions("click", $alert$);
							;
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

					while (true) {
						try {
							WebElement fh2 = driver
									.findElement(By.xpath("//div[@title='Enter the description of the alert ']"));
							visbility(driver, fh2, 60);
							fh2.sendKeys("hello");
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					WebElement r = driver.findElement(By.xpath("//button[@id='visibility']"));

					click(r);

					List<WebElement> $alertdrop$ = driver
							.findElements(By.xpath("//button[@id='visibility']//following::ul[1]/li/a"));
					for (WebElement web : $alertdrop$) {

						if (web.getText().trim().equals("Everyone")) {
							click(web);
							break;
						}

					}
					WebElement hbt6 = driver.findElement(By.xpath("//div[@id='AlertKpop2']/div[2]/div[2]/button[2]"));// .click();
					visbility(driver, hbt6, 60);
					click(hbt6);
					sleep(3000);
					WebElement $alertContent$;
					while (true) {
						try {
							$alertContent$ = driver.findElement(By.xpath("//div[text()='hello']"));
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

					visbility(driver, $alertContent$, 60);

					javascriptclick($alertContent$);
					WebElement $contentchng$ = null;
					while (true) {
						try {
							$contentchng$ = driver
									.findElement(By.xpath("//div[@title='Enter the description of the alert ']"));
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					visbility(driver, $contentchng$, 60);
					clear($contentchng$);
					WebElement alrt2 = driver
							.findElement(By.xpath("//div[@title='Enter the description of the alert ']"));
					visbility(driver, alrt2, 60);
					sendkeys(alrt2, "wELCOME");
					WebElement alrt3 = driver.findElement(By.xpath("//div[@id='AlertKpop2']/div[2]/div[2]/button[2]"));// .click();
					visbility(driver, alrt3, 60);
					click(alrt3);
					sleep(3000);
				} else if (tagnames.equals("vaccine")) {

					WebElement k = driver.findElement(By.xpath("//div[contains(@title,'Add Vaccine')]"));
					actions("move to element", k);
					visbility(driver, k, 60);
					ww.until(ExpectedConditions.elementToBeClickable(k));
					actions("click", k);
					WebElement x = driver.findElement(By.xpath("//select[@id='date-type']"));
					visbility(driver, x, 60);
					x.click();
					dropDown("text", x, "Taken Date");
					WebElement vcne = driver.findElement(By.id("vaccine-cvx"));
					visbility(driver, vcne, 60);
					vcne.sendKeys("kaaspro");

					WebElement vcne2 = driver.findElement(By.id("vaccineName"));
					visbility(driver, vcne2, 60);
					vcne2.sendKeys("TT");
					WebElement sv = driver
							.findElement(By.xpath("//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']"));
					visbility(driver, sv, 60);
					javascriptclick(sv);
					sleep(3000);
					WebElement l = driver.findElement(By.xpath("//div[text()='TT']"));
					visbility(driver, l, 60);
					actions("click", l);

					WebElement vcna = driver.findElement(By.id("vaccineName"));// .clear();
					visbility(driver, vcna, 60);
					vcna.clear();
					WebElement vcna1 = driver.findElement(By.id("vaccineName"));// .sendKeys("TT INJECTION");
					visbility(driver, vcna1, 60);
					sendkeys(vcna1, "TT INJECTION");
					implicitWait(60, TimeUnit.SECONDS);
					/*
					 * WebElement delvc = driver .findElement(By.xpath(
					 * "(//div[@id='VaccineKpop2']//following::div[1]/span[1])[1]"));
					 * javascriptclick(delvc);
					 */
					WebElement vcc = driver
							.findElement(By.xpath("//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']"));
					visbility(driver, vcc, 60);
					click(vcc);

					sleep(3000);

				} else if (tagnames.equals("implantable-devices")) {

					WebElement b = driver.findElement(By.xpath("//div[contains(@title,'Add Implantable')]"));
					actions("move to element", b);
					visbility(driver, b, 60);
					actions("click", b);
					WebElement impl = driver.findElement(By.id("udi"));// .sendKeys("(01)00844588003288");
					visbility(driver, impl, 60);
					sendkeys(impl, "(01)00844588003288");
					WebElement svimpl = driver.findElement(By.xpath("//button[@id='verify-btn']"));// .click();
					visbility(driver, svimpl, 60);
					click(svimpl);
					sleep(3000);
					driver.findElement(By.id("deviceactive"));

					WebElement a1 = driver.findElement(By.id("deviceNote"));
					visbility(driver, a1, 60);
					sleep(1000);
					a1.sendKeys("hello123");
					WebElement savimp = driver
							.findElement(By.xpath("//div[@id='Implantable_DevicesKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, savimp, 60);
					javascriptclick(savimp);

					sleep(2000);
					WebElement a2 = driver
							.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
					visbility(driver, a2, 60);
					ww.until(ExpectedConditions.elementToBeClickable(a2));
					actions("click", a2);
					WebElement a26 = driver.findElement(By.id("deviceNote"));
					ScriptExecutor(a26);
					visbility(driver, a26, 60);
					a26.clear();
					a26.sendKeys("JUst Rise up..");
					WebElement savimp1 = driver
							.findElement(By.xpath("//div[@id='Implantable_DevicesKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, savimp1, 60);
					javascriptclick(savimp1);

					/*
					 * driver.findElement(By.xpath("//div[@title='Remove UDI']")).click();
					 * WebElement delimp = driver .findElement(By.xpath(
					 * "//div[@id='Implantable_DevicesKpop2']/div/div[2]/span[1]"));
					 * javascriptclick(delimp);
					 */
					sleep(3000);

				} else if (tagnames.equals("amendment")) {

					WebElement d = driver.findElement(By.xpath("//div[contains(@title,'Add Amendment')]"));

					actions("move to element", d);
					visbility(driver, d, 60);
					clickble(driver, d, 25);
					actions("click", d);
					WebElement s1 = driver.findElement(By.xpath("//select[@id='source']"));
					visbility(driver, s1, 60);
					s1.click();
					dropDown("text", s1, "Patient");
					WebElement amd = driver
							.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[2]/div/div[2]/div[2]/input"));
					visbility(driver, amd, 60);
					sendkeys(amd, "Akash");// .sendKeys("Akash");

					WebElement s2 = driver.findElement(By.xpath("//select[@id='status']"));
					visbility(driver, s2, 60);
					s2.click();
					dropDown("text", s2, "Accept");
					WebElement vs = driver.findElement(By.xpath("//input[@id='reason']"));
					visbility(driver, vs, 60);
					sendkeys(vs, "whats up...");// .sendKeys("whats up...");
					WebElement svamen = driver
							.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, svamen, 60);

					javascriptclick(svamen);
					sleep(3000);
					WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
					visbility(driver, ac, 60);
					actions("click", ac);
					sleep(2000);
					WebElement clr = driver.findElement(By.xpath("//input[@id='reason']"));
					visbility(driver, clr, 60);
					clear(clr);// .clear();

					WebElement ips = driver.findElement(By.xpath("//input[@id='reason']"));
					visbility(driver, ips, 60);

					sendkeys(ips, "warrior");// .sendKeys("warrior");
					WebElement iis = driver.findElement(By.xpath("//input[@id='reason']"));// .sendKeys("WAR BEGINS");
					visbility(driver, iis, 60);
					sendkeys(iis, "WAR BEGINS");
					WebElement svamen1 = driver
							.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, svamen1, 60);
					javascriptclick(svamen1);
					// driver.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[1]/div[2]/span[1]")).click();
					sleep(3000);

				} else if (tagnames.equals("diagnosis")) {

					Problems pro = new Problems(driver);
					pro.Addproblems();

				} else if (tagnames.equals("symptom")) {

					WebElement a7 = driver.findElement(By.xpath("//div[contains(@title,'Add Symptoms')]"));

					actions("move to element", a7);
					visbility(driver, a7, 60);

					actions("click", a7);
					WebElement prsend = driver
							.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[2]/div[2]/input"));
					visbility(driver, prsend, 60);
					sendkeys(prsend, "test");// .sendKeys("R10.12:");
					implicitWait(30, TimeUnit.SECONDS);
					List<WebElement> symptomsdrop;
					while (true) {
						try {
							symptomsdrop = driver.findElements(By.xpath(
									"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
							if (symptomsdrop.size() > 5) {
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					for (WebElement web : symptomsdrop) {
						if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
							visbility(driver, web, 60);
							javascriptclick(web);
							break;
						}

					}
					sleep(2000);
					WebElement sydes = driver
							.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"));
					// driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"))
					visbility(driver, sydes, 60);
					sydes.sendKeys("fever");
					WebElement svsymp = driver
							.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, svsymp, 60);
					javascriptclick(svsymp);
					sleep(3000);
					WebElement a8 = driver.findElement(
							By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
					visbility(driver, a8, 60);

					actions("click", a8);
					WebElement smp1 = driver
							.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"));
					visbility(driver, smp1, 60);
					clear(smp1);// .clear();

					sleep(2000);
					WebElement smp2 = driver
							.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"));
					visbility(driver, smp2, 60);
					sendkeys(smp2, "covid");// .sendKeys("covid");

					WebElement svsymp1 = driver
							.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, svsymp1, 60);

					javascriptclick(svsymp1);
					// driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div/div[2]/span[1]")).click();
					sleep(4000);

				} else if (tagnames.equals("procedure")) {

					WebElement b1 = driver.findElement(By.xpath("//div[contains(@title,'Add Procedure')]"));
					actions("move to element", b1);
					visbility(driver, b1, 60);

					actions("click", b1);
					WebElement b2;
					while (true) {
						try {
							b2 = driver.findElement(By.xpath("//select[@id='codeType']"));
							visbility(driver, b2, 60);
							javascriptclick(b2);
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					dropDown("text", b2, "SNOMED CT");
					WebElement ers = driver
							.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/div[1]/div[2]/input"));
					visbility(driver, ers, 60);
					// driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/div[1]/div[2]/input"))
					ers.sendKeys("test");
					List<WebElement> prcddropdwn;
					;
					while (true) {
						try {
							prcddropdwn = driver.findElements(By.xpath(
									"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/small/em"));
							if (prcddropdwn.size() > 5) {
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					for (WebElement web : prcddropdwn) {

						if (web.getText().trim().equals("SNOMED : 134287002")) {
							// System.out.println("procedure met..");
							visbility(driver, web, 60);
							javascriptclick(web);
							break;

						}

					}
					WebElement smp3 = driver
							.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input"));
					visbility(driver, smp3, 60);
					sendkeys(smp3, "gdgdg");// .sendKeys("gdgdg");

					WebElement svprcd1 = driver.findElement(By.id("btnSaveAdd"));
					visbility(driver, svprcd1, 60);
					click(svprcd1);// .click();
					sleep(2000);
					List<WebElement> b6 = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
					for (WebElement w : b6) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();

							break;
						}

					}
					sleep(3000);
					while (true) {
						try {
							WebElement b7 = driver.findElement(
									By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
							visbility(driver, b7, 60);
							javascriptclick(b7);
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					// actions("click", b7);
					sleep(2000);
					WebElement clrprc = driver
							.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input"));
					visbility(driver, clrprc, 60);
					clear(clrprc);// .clear();
					WebElement prcd3 = driver
							.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input"));
					visbility(driver, prcd3, 60);

					sendkeys(prcd3, "LARA");// .sendKeys("LARA");

					WebElement prcd4 = driver.findElement(By.id("btnSaveAdd"));
					visbility(driver, prcd4, 60);
					click(prcd4);// .click();
					sleep(3000);
					List<WebElement> b64 = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
					for (WebElement w : b64) {
						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

					// driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[1]/div[2]/span[1]")).click();
					sleep(2500);

				} else if (tagnames.equals("goals")) {
					implicitWait(30, TimeUnit.SECONDS);
					WebElement b8 = driver.findElement(By.xpath("//div[contains(@title,'Add Goals')]"));
					actions("move to element", b8);
					visbility(driver, b8, 60);
					ww.until(ExpectedConditions.elementToBeClickable(b8));
					actions("click", b8);
					sleep(2000);
					WebElement gl1 = driver.findElement(By.xpath("//div[@title='Enter goal']"));
					visbility(driver, gl1, 60);
					sendkeys(gl1, "goal1");// .sendKeys("goal1");

					WebElement gl2 = driver
							.findElement(By.xpath("//div[@id='GoalsKpop2']/div[2]/div[1]/div[2]/div/input"));// .click();
					visbility(driver, gl2, 60);
					click(gl2);
					sleep(2000);
					WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

					implicitWait(30, TimeUnit.SECONDS);

					dropDown("index", month, "09");

					WebElement uyr = driver.findElement(By.xpath("//a[text()='14']"));// .click();
					visbility(driver, uyr, 60);
					click(uyr);
					sleep(2000);
					WebElement hk = driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, hk, 60);
					javascriptclick(hk);
					sleep(3000);
					WebElement b10 = driver.findElement(By.xpath("//div[text()='goal1']"));
					visbility(driver, b10, 60);
					ww.until(ExpectedConditions.elementToBeClickable(b10));
					actions("click", b10);
					implicitWait(60, TimeUnit.SECONDS);

					WebElement ft = driver.findElement(By.xpath("//div[@title='Enter goal']"));// .clear();
					visbility(driver, ft, 60);
					clear(ft);
					WebElement glr1 = driver.findElement(By.xpath("//div[@title='Enter goal']"));
					// .sendKeys("HELLO THIS IS GOALS MODULE.");
					visbility(driver, glr1, 60);
					sendkeys(glr1, "HELLO THIS IS GOALS MODULE.");
					WebElement hk1 = driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, hk1, 60);
					javascriptclick(hk1);

					/*
					 * WebElement jl =
					 * driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div/div[2]/span[1]"));
					 * 
					 * javascriptclick(jl);
					 */
					sleep(4000);

				} else if (tagnames.equals("directives")) {

					WebElement c1 = driver.findElement(By.xpath("//div[contains(@title,'Add Advance directives')]"));
					actions("move to element", c1);
					visbility(driver, c1, 60);
					ww.until(ExpectedConditions.elementToBeClickable(c1));
					actions("click", c1);

					WebElement c2 = driver.findElement(By.xpath("//div[@id='Assessment-div']/select"));
					visbility(driver, c2, 60);
					c2.click();
					dropDown("text", c2, "Assessment");
					WebElement cc1 = driver.findElement(By.xpath("//input[@id='directive_desc']"));
					visbility(driver, cc1, 60);
					sendkeys(cc1, "lets hope");// .sendKeys("lets hope");
					WebElement cc2 = driver
							.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, cc2, 60);
					click(cc2);// .click();
					sleep(3000);
					WebElement c4 = driver.findElement(By.xpath("//div[text()='lets hope']"));
					visbility(driver, c4, 60);
					actions("click", c4);
					sleep(2000);
					WebElement cc5 = driver.findElement(By.xpath("//input[@id='directive_desc']"));
					visbility(driver, cc5, 60);
					sendkeys(cc5, "Advance directives");// .sendKeys("Advance directives");
					WebElement cc6 = driver
							.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, cc6, 60);
					click(cc6);// .click();

					/*
					 * WebElement deladvfac = driver .findElement(By.xpath(
					 * "//div[@id='Advance_DirectivesKpop2']/div/div[2]/span[1]"));
					 * javascriptclick(deladvfac);
					 */
					sleep(3000);

				} else if (tagnames.equals("status-module")) {

					WebElement c5 = driver.findElement(By.xpath("//div[contains(@title,'Add Status')]"));
					actions("move to element", c5);
					visbility(driver, c5, 60);

					actions("click", c5);
					while (true) {
						try {
							WebElement c6 = driver.findElement(By.xpath("(//select[@id='statusType'])[1]"));
							visbility(driver, c6, 60);
							javascriptclick(c6);
							dropDown("text", c6, "Cognitive status");
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					WebElement cc7 = driver.findElement(By
							.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select[1]//following::div[1]/div[2]/input"));
					visbility(driver, cc7, 60);
					sendkeys(cc7, "test");// .sendKeys("test");
					sleep(2000);
					List<WebElement> $statusicddrp$;
					;
					while (true) {
						try {
							$statusicddrp$ = driver.findElements(By.xpath(
									"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
							System.out.println($statusicddrp$.size());
							if ($statusicddrp$.size() > 5) {

								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					for (WebElement we : $statusicddrp$) {
						if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality")) {
							visbility(driver, we, 60);
							javascriptclick(we);
							break;
						}

					}
					WebElement cc8 = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));// .click();
					visbility(driver, cc8, 60);
					click(cc8);
					sleep(2000);
					for (int in = 1; in <= 5; in++) {
						try {
							WebElement $editstatus$ = driver.findElement(
									By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
							visbility(driver, $editstatus$, 60);
							;
							javascriptclick($editstatus$);
							break;
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					sleep(3000);
					WebElement hjj = driver
							.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select//following::span[5]"));
					visbility(driver, hjj, 60);
					actions("click", hjj);
					WebElement cc9 = driver.findElement(By
							.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select[1]//following::div[1]/div[2]/input"));
					visbility(driver, cc9, 60);
					sendkeys(cc9, "yang");// .sendKeys("yang");

					List<WebElement> $statusicddrp1$;
					;
					while (true) {
						try {
							$statusicddrp1$ = driver.findElements(By.xpath(
									"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
							if ($statusicddrp1$.size() >= 2) {
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					for (WebElement we : $statusicddrp1$) {
						if (we.getText().trim().equals("370534002: Yang deficiency")) {
							visbility(driver, we, 60);
							javascriptclick(we);
							break;
						}

					}

					WebElement cc10 = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));// .click();
					visbility(driver, cc10, 60);
					click(cc10);
					/*
					 * WebElement delsmd =
					 * driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[1]/div[2]/span[1]")
					 * ); javascriptclick(delsmd);
					 */
					sleep(3000);

				} else if (tagnames.equals("test-order")) {

					WebElement ad1 = driver.findElement(By.xpath("//div[contains(@title,'Add Test Order')]"));

					actions("move to element", ad1);
					actions("click", ad1);
					driver.findElement(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]/input"))
							.sendKeys("test");

					while (true) {
						try {

							List<WebElement> $testOrderDropDown = driver.findElements(By.xpath(
									"//div[@id='Test_OrderKpop2']/div[2]/div[4]/div/button//following::ul[2]/li/a"));

							if ($testOrderDropDown.size() >= 1) {
								System.out.println("ENTER");
								break;

							}

						} catch (Exception e) {
							// TODO: handle exception
						}
					}

					// sleep(4000);

					for (int in = 1; in <= 10; in++) {
						try {
							if (ur.equals("https://localhost:8443/")) {
								WebElement b = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
								if (b.isDisplayed()) {
									click(b);
									break;
								}
							} else if (ur.equals("https://www.75health.com/login.jsp")) {

								if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType()
										.equals("dr")
										|| ConfigManager.getconfigManager().getInstanceConfigReader().accountType()
												.equals("user")) {
									WebElement c = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
									if (c.isDisplayed()) {
										click(c);
										break;
									}
								} else {
									WebElement b = driver.findElement(By.xpath("(//div[text()='test'])[2]"));
									if (b.isDisplayed()) {
										click(b);
										break;
									}
								}

							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

					/*
					 * List<WebElement> tyr = driver.findElements( By.xpath(
					 * "//div[@id='Test_OrderKpop2']/div[2]/div[1]//following::ul[3]/li/a/div/span")
					 * ); for (WebElement webE : tyr) { if
					 * (webE.getText().contains("LOINC NUM :5802-4")) { webE.click(); break; }
					 * 
					 * }
					 */

					sleep(2000);

					driver.findElement(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div/button")).click();
					List<WebElement> chs = driver.findElements(
							By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div/button//following::ul[1]/li"));
					for (WebElement w : chs) {

						if (w.getText().trim().equals("Show Notes")) {
							w.click();
							break;
						}

					}

					sleep(3000);
					driver.findElement(By.xpath(

							"//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input"))
							.sendKeys("ERROR");
					driver.findElement(
							By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button"))
							.click();
					List<WebElement> dss = driver.findElements(By.xpath(
							"//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button//following::ul[1]/li"));
					for (WebElement w : dss) {
						if (w.getText().trim().equals("Save")) {

							w.click();
							break;
						}

					}
					while (true) {
						try {
							WebElement testorder = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));

							if (testorder.isDisplayed()) {
								click(testorder);
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

					driver.findElement(By.xpath(

							"//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input"))
							.clear();
					driver.findElement(By.xpath(

							"//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input"))
							.sendKeys("Test order..");

					driver.findElement(
							By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button"))
							.click();
					List<WebElement> dsss = driver.findElements(By.xpath(
							"//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button//following::ul[1]/li"));
					for (WebElement w : dsss) {
						if (w.getText().trim().equals("Save")) {

							w.click();
							break;
						}

					}

					sleep(3000);

				} else if (tagnames.equals("drug")) {
					WebElement ci = driver.findElement(By.xpath("(//div[contains(@title,'Add Medications')])[1]"));
					actions("move to element", ci);
					visbility(driver, ci, 60);

					actions("click", ci);
					sleep(2000);
					driver.findElement(By.id("DRUG_NAME")).sendKeys("tata");
					driver.findElement(By.id("STRENGTH")).sendKeys("str");
					driver.findElement(By.id("DISP_QUANTITY")).sendKeys("1");
					driver.findElement(By.id("SIG_DIRECTIONS")).sendKeys("q1");
					List<WebElement> medq = driver
							.findElements(By.xpath("//div[@id='addfav-div']//following::ul[1]/li/a/div"));
					for (WebElement web : medq) {
						if (web.getText().trim().equals("q12h - Every twelve hours")) {
							visbility(driver, web, 60);
							javascriptclick(web);
							break;
						}

					}
					// driver.findElement(By.id("startdateiid")).sendKeys("2022-07-20");
					// driver.findElement(By.id("enddateiid")).sendKeys("2022-07-22");
					WebElement dd1 = driver
							.findElement(By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button"));// .click();
					visbility(driver, dd1, 60);
					click(dd1);
					sleep(2000);
					List<WebElement> d1 = driver.findElements(
							By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button//following::ul[1]/li"));
					for (WebElement w : d1) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

					sleep(3000);
					WebElement d3 = driver.findElement(By.xpath("//div[text()='q12h - Every twelve hours']"));
					visbility(driver, d3, 60);

					actions("click", d3);
					sleep(2000);

					/*
					 * WebElement delmed = driver
					 * .findElement(By.xpath("//div[@id='MedicationsKpop2']/div[1]/div[2]/span[1]"))
					 * ; javascriptclick(delmed);
					 */
					WebElement rqw = driver.findElement(By.xpath(
							"//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[3]/table/tbody/tr/td[2]/div"));
					visbility(driver, rqw, 60);
					javascriptclick(rqw);
					sleep(2000);
					WebElement jsk = driver.findElement(By.id("DRUG_NAME"));
					visbility(driver, jsk, 60);
					sendkeys(jsk, "1009");

					List<WebElement> $med$drop$down$;

					while (true) {
						try {
							$med$drop$down$ = driver.findElements(By.xpath(
									"//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em"));
							if ($med$drop$down$.size() > 5) {
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

					for (WebElement we : $med$drop$down$) {
						System.out.println(we.getText());
						if (we.getText().trim().equals("RXNORM : 1009145")) {
							// System.out.println("med cond met");
							visbility(driver, we, 60);
							javascriptclick(we);
							break;

						}

					}

					/*
					 * WebElement rt = driver.findElement(
					 * By.xpath("//b[text()='testosterone enanthate 100 MG/ML Injectable Solution']"
					 * )); visbility(driver, rt, 60); javascriptclick(rt);
					 */

					driver.findElement(By.id("DISP_QUANTITY")).sendKeys("1");
					driver.findElement(By.id("SIG_DIRECTIONS")).sendKeys("12");

					List<WebElement> med2 = driver
							.findElements(By.xpath("//div[@id='addfav-div']//following::ul[1]/li/a/div"));
					for (WebElement web : med2) {
						if (web.getText().trim().equals("q12h - Every twelve hours")) {
							visbility(driver, web, 60);
							web.click();
							break;
						}

					}

					WebElement dd2 = driver
							.findElement(By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button"));// .click();
					visbility(driver, dd2, 60);
					click(dd2);
					sleep(2000);
					List<WebElement> d2 = driver.findElements(
							By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button//following::ul[1]/li"));
					for (WebElement w : d2) {

						if (w.getText().trim().equals("Save")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

					sleep(3000);
				} else if (tagnames.equals("delivery-note")) {
					WebElement kk = driver.findElement(By.xpath("//div[contains(@title,'Add Notes')]"));
					actions("move to element", kk);
					visbility(driver, kk, 60);
					ww.until(ExpectedConditions.elementToBeClickable(kk));
					actions("click", kk);
					WebElement kk1 = driver
							.findElement(By.xpath("//div[@title='Enter the notes description of the patient visit']"));
					visbility(driver, kk1, 60);
					sendkeys(kk1, "hell");// .sendKeys("hell");
					WebElement zv = driver.findElement(By.xpath("//div[@id='NotesKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, zv, 60);
					javascriptclick(zv);
					sleep(3000);
					WebElement jl = driver.findElement(By.xpath("//div[text()='hell']"));
					visbility(driver, jl, 60);
					actions("click", jl);
					WebElement kk2 = driver
							.findElement(By.xpath("//div[@title='Enter the notes description of the patient visit']"));
					visbility(driver, kk2, 60);
					clear(kk2);// .clear();
					WebElement kk3 = driver
							.findElement(By.xpath("//div[@title='Enter the notes description of the patient visit']"));
					visbility(driver, kk3, 60);
					sendkeys(kk3, "NOTES--MMM");// .sendKeys("NOTES--MMM");
					WebElement zv1 = driver.findElement(By.xpath("//div[@id='NotesKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, zv1, 60);
					javascriptclick(zv1);

					/*
					 * WebElement fg =
					 * driver.findElement(By.xpath("//div[@id='NotesKpop2']/div/div[2]/span[1]"));
					 * javascriptclick(fg);
					 */
					sleep(3000);

				} else if (tagnames.equals("physical-examination")) {

					WebElement x1 = driver.findElement(By.xpath("//div[contains(@title,'Add Physical Examination')]"));
					actions("move to element", x1);
					visbility(driver, x1, 60);
					ww.until(ExpectedConditions.elementToBeClickable(x1));

					actions("click", x1);
					WebElement x2 = driver.findElement(By.id("bodyParts"));
					visbility(driver, x2, 60);
					sendkeys(x2, "hello");// .sendKeys("hello");

					WebElement x3 = driver.findElement(By.id("finding"));
					visbility(driver, x3, 60);
					sendkeys(x3, "hw are you");// .sendKeys("hw are you");
					sleep(2000);

					WebElement abc = driver
							.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/div/button"));
					visbility(driver, abc, 60);
					ww.until(ExpectedConditions.elementToBeClickable(abc));
					javascriptclick(abc);
					List<WebElement> abcd = driver.findElements(By.xpath(
							"//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/div/button//following::ul[1]/li"));
					for (WebElement w : abcd) {
						if (w.getText().trim().equals("Show Notes")) {
							visbility(driver, w, 60);
							w.click();
							break;
						}

					}

					sleep(2000);
					WebElement x5 = driver.findElement(By.xpath("//input[@id='notes']"));
					visbility(driver, x5, 60);
					sendkeys(x5, "lets goo");// .sendKeys("lets goo");
					//// div[@id='Physical_ExaminationsKpop2']/div[2]/div[1]/div[5]/div[2]/input
					sleep(2000);
					WebElement nn = driver
							.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[3]/button[2]"));
					visbility(driver, nn, 60);
					javascriptclick(nn);
					sleep(3000);
					WebElement et = driver.findElement(By.xpath("//div[text()='lets goo']"));
					visbility(driver, et, 60);
					actions("click", et);
					/*
					 * WebElement sf = driver .findElement(By.xpath(
					 * "//div[@id='Physical_ExaminationsKpop2']/div[1]/div[2]/span[1]"));
					 * javascriptclick(sf);
					 */

					WebElement x7 = driver.findElement(By.xpath("//input[@id='notes']"));
					visbility(driver, x7, 60);
					clear(x7);// .clear();
					WebElement x8 = driver.findElement(By.xpath("//input[@id='notes']"));
					visbility(driver, x8, 60);
					sendkeys(x8, "physical condition");// .sendKeys("physical condition");
					WebElement nnn = driver
							.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[3]/button[2]"));
					visbility(driver, nnn, 60);
					javascriptclick(nnn);
					sleep(4000);

				} else if (tagnames.equals("custom-form")) {

					Forms form = new Forms();
					try {
						form.$addForm(driver);
					} catch (Throwable e) {

						e.printStackTrace();
					}

				} else if (tagnames.equals("attachFile")) {

					WebElement ar = driver.findElement(By.xpath("//div[contains(@title,'Add Attach File')]"));
					actions("move to element", ar);
					visbility(driver, ar, 60);
					ww.until(ExpectedConditions.elementToBeClickable(ar));
					actions("click", ar);

					WebElement selweb = driver
							.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[1]/select"));
					visbility(driver, selweb, 60);
					dropDown("text", selweb, "Web link");
					WebElement y1 = driver.findElement(
							By.xpath("(//div[@id='Attach_FileKpop2']/div[2]/div[1]//following::div[3]/input[1])[1]"));
					visbility(driver, y1, 60);
					sendkeys(y1, "https://www.75health.com/");// .sendKeys("https://www.75health.com/");
					WebElement ps1 = driver
							.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[3]/button[2]"));
					visbility(driver, ps1, 60);
					javascriptclick(ps1);
					sleep(2000);

					while (true) {

						try {
							WebElement $editAttachfileIcon = driver.findElement(By.xpath(
									"(//a[text()='Web link : (https://www.75health.com/)'])[1]//parent::div/span[1]"));
							if ($editAttachfileIcon.isDisplayed()) {

								click($editAttachfileIcon);
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}

					}

					WebElement y2 = driver.findElement(
							By.xpath("(//div[@id='Attach_FileKpop2']/div[2]/div[1]//following::div[3]/input[1])[1]"));
					visbility(driver, y2, 60);
					clear(y2);
					sendkeys(y2, "https://www.75health.com/");

					for (int in = 1; in <= 7; in++) {
						try {

							WebElement $delAttachFile = driver
									.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[1]/div[2]/span[1]"));
							if ($delAttachFile.isDisplayed()) {
								click($delAttachFile);
								break;
							}
						} catch (Exception e) {

						}
					}
					sleep(4000);
				} else if (tagnames.equals("inpatient")) {

					WebElement qq = driver.findElement(By.xpath("//div[contains(@title,'Add Inpatient')]"));
					actions("move to element", qq);
					visbility(driver, qq, 60);
					elementClickable(qq);
					click(qq);

					WebElement inpmnth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
					visbility(driver, inpmnth, 60);
					dropDown("index", inpmnth, "08");

					WebElement ipmyr = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
					visbility(driver, ipmyr, 60);
					dropDown("text", ipmyr, "2022");
					WebElement y2 = driver.findElement(By.xpath("//a[text()='21']"));// .click();
					visbility(driver, y2, 60);
					click(y2);

					sleep(2000);
					driver.findElement(By.id("dischargeiid")).click();
					WebElement inpmnth1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
					visbility(driver, inpmnth1, 60);
					dropDown("index", inpmnth1, "10");
					WebElement ipmyr1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
					visbility(driver, ipmyr1, 60);
					dropDown("text", ipmyr1, "2022");
					WebElement y3 = driver.findElement(By.xpath("//a[text()='26']"));
					visbility(driver, y3, 60);
					click(y3);// .click();

					sleep(2000);
					WebElement re = driver.findElement(By.xpath("//div[@id='InpatientKpop2']/div[2]/div[1]/select"));
					visbility(driver, re, 60);
					// (//select[@id='admissionType'])[1]
					ww.until(ExpectedConditions.elementToBeClickable(re));
					javascriptclick(re);
					dropDown("text", re, "Urgent");
					driver.findElement(By.id("rmNo")).sendKeys("777");
					WebElement y4 = driver.findElement(By.id("dischargeSummary"));
					visbility(driver, y4, 60);
					sendkeys(y4, "okay");// .sendKeys("okay");
					WebElement yt = driver.findElement(By.xpath("//div[@id='InpatientKpop2']/div[2]/div[2]/button[2]"));
					visbility(driver, yt, 60);
					javascriptclick(yt);

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
		WebElement gnbill = driver.findElement(By.xpath("(//div[@id='generate_bill'])[1]/button[2]"));
		visbility(driver, gnbill, 60);
		javascriptclick(gnbill);
		List<WebElement> yjj = driver
				.findElements(By.xpath("(//div[@id='generate_bill'])[1]/button[2]//following::ul[1]/li"));
		for (WebElement we : yjj) {
			if (we.getText().trim().equals("Generate Bill from EHR")) {
				visbility(driver, we, 60);
				we.click();
				break;
			}

		}
		sleep(4000);

		/*
		 * for (int i = 1; i <= 5; i++) { try { WebElement rds =
		 * ww.until(ExpectedConditions.presenceOfElementLocated( By.
		 * xpath("//div[text()='RXNORM: 24 HR Testosterone 0.0833 MG/HR Transdermal System-2']"
		 * ))); visbility(driver, rds, 60);
		 * ww.until(ExpectedConditions.elementToBeClickable(rds)); actions("click",
		 * rds); break; } catch (Exception e) { // TODO: handle exception } } //
		 * WebElement = // driver.findElement(By.xpath(
		 * "//div[text()='MEDICATION-str']//following::div[6]/div[2]//following::div[1]/div[1]/div[5]/div[2]/input"
		 * )); WebElement rdss; while (true) { try { rdss =
		 * ww.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//div[text()='RXNORM: 24 HR Testosterone 0.0833 MG/HR Transdermal System-2']//following::div[6]/div[2]//following::div[1]/div[1]/div[5]/div[2]/input"
		 * ))); visbility(driver, rdss, 60); rdss.clear(); break; } catch (Exception e)
		 * { // TODO: handle exception } } rdss.sendKeys("500");
		 * 
		 * for (int i = 1; i <= 5; i++) { try { WebElement sql =
		 * driver.findElement(By.xpath(
		 * "//div[text()='RXNORM: 24 HR Testosterone 0.0833 MG/HR Transdermal System-2']//following::div[6]/div[2]//following::div[1]/div[2]/div[1]/button[3]"
		 * )); visbility(driver, sql, 60); javascriptclick(sql); break; } catch
		 * (Exception e) { // TODO: handle exception } }
		 * 
		 * /// sleep(2000);
		 * 
		 * for (int i = 1; i <= 5; i++) { try { WebElement ee = ww.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//button[@id='add-payment-btn'])[1]"))); visbility(driver, ee, 60);
		 * javascriptclick(ee); break; } catch (Exception e) { // TODO: handle exception
		 * } } //
		 * driver.findElement(By.xpath("(//button[@id='add-payment-btn'])[1]")).click();
		 * WebElement ddr =
		 * driver.findElement(By.xpath("(//span[@id='paymentMethodTypeSelectValue'])[2]"
		 * )); visbility(driver, ddr, 60); click(ddr);// .click(); sleep(2000);
		 * List<WebElement> choosepy = driver .findElements(By.xpath(
		 * "(//span[@id='paymentMethodTypeSelectValue'])[2]//following::ul[1]/li")); for
		 * (WebElement w : choosepy) { if (w.getText().trim().equals("Cash Payment")) {
		 * visbility(driver, w, 60); w.click(); break; }
		 * 
		 * }
		 * 
		 * WebElement dsp1 = driver.findElement(By.xpath(
		 * "(//button[@id='paymentMethodTypeId'])[2]/span[2]//following::div[4]/div[4]//following::div[2]//following::div[1]/div[2]/textarea"
		 * )); actions("click", dsp1); sleep(2000); dsp1.sendKeys("cash pay+++++++++");
		 * 
		 * WebElement tet =
		 * driver.findElement(By.xpath("(//button[@title='Make Payment'])[3]"));
		 * 
		 * j.executeScript("arguments[0].click();", tet);
		 * 
		 * WebElement fnls =
		 * driver.findElement(By.xpath("//button[@id='finalize-bill']"));
		 * ww.until(ExpectedConditions.elementToBeClickable(fnls));
		 * javascriptclick(fnls);
		 * 
		 * WebElement dz =
		 * driver.findElement(By.xpath("(//button[@title='Finalize'])[1]"));
		 * ww.until(ExpectedConditions.elementToBeClickable(dz)); javascriptclick(dz);
		 * sleep(2000);
		 * 
		 * driver.findElement(By.xpath(
		 * "//button[@id='finalize-bill']//following::button[2]")).click(); sleep(2000);
		 * 
		 * 
		 * WebElement delbil = driver.findElement( By.
		 * xpath("//center[text()='Do you like to delete Invoice?']//following::div[1]/button[2]"
		 * )); javascriptclick(delbil);
		 * 
		 */
		WebElement backtoehr = driver.findElement(By.xpath("//div[@id='paymentMadeInfull']//following::button[1]"));
		clickble(driver, backtoehr, 25);
		javascriptclick(backtoehr);
		WebElement complteehr = driver
				.findElement(By.xpath("(//button[contains(@title,'Complete Health Record')])[1]/span[2]"));
		javascriptclick(complteehr);
		sleep(2000);
		driver.findElement(By.xpath(
				"(//span[contains(text(),'Past date health record entry')])[1]//parent::div//parent::div[1]/div[3]/div/div[1]/div[1]/input"))
				.sendKeys(ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		WebElement cmpehr = driver.findElement(
				By.xpath("(//span[contains(text(),'Past date health record entry')])[1]//following::div[4]/button[2]"));
		javascriptclick(cmpehr);
		///
		/*
		 * WebElement backtoehr =
		 * driver.findElement(By.xpath("//button[@onclick='window.history.back();']"));
		 * javascriptclick(backtoehr);
		 */
		sleep(3000);
		if (ur.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (ur.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (ur.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		/*
		 * while (true) { try { click(pom.getInstanceHealthRec().clickHealthRec);
		 * implicitWait(30, TimeUnit.SECONDS); break; } catch (Exception e) { // TODO:
		 * handle exception } }
		 */
		while (true) {
			try {
				driver.findElement(By.id("newMedicalRecordButton")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(3000);
		// past cured...

		Vaccine vac = new Vaccine(driver);
		try {
			vac.$getPastVaccine();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Problems pro = new Problems(driver);
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
		sleep(3000);

		// ehr favorites...

		// vist reason
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fvvis = driver.findElement(By.xpath("//div[contains(@title,'Show my favorite Visit ')]"));
				actions("move to element", fvvis);
				visbility(driver, fvvis, 60);
				javascriptclick(fvvis);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addfv = driver.findElement(
						By.xpath("//div[@id='Visit_ReasonFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, addfv, 60);
				javascriptclick(addfv);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			click(pom.getInstanceCalendar().selectAppointmentType);
			System.out.println("ELEMENT CLICKED IN VISIT");
		} catch (Exception e) {
			System.out.println(e);
		}

		while (true) {
			try {
				List<WebElement> $TypeDropdown = driver.findElements(
						By.xpath("(//button[@id='admissionVal_dropdown'])[2]//following::ul[1]/li/a/span[2]"));
				for (WebElement Element : $TypeDropdown) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency")) {

						click(Element);
						break;
					}

				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement fv2 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
		visbility(driver, fv2, 60);
		sendkeys(fv2, "favorite visit reason");

		WebElement fv3 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPell']//following::button[2]"));
		visbility(driver, fv3, 60);
		javascriptclick(fv3);
		sleep(2500);

		for (int i = 1; i <= 5; i++) {

			try {

				WebElement fv4 = driver.findElement(By.xpath("(//div[text()='favorite visit reason'])[1]"));
				visbility(driver, fv4, 60);
				javascriptclick(fv4);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			click(pom.getInstanceCalendar().selectAppointmentType);
			System.out.println("ELEMENT CLICKED IN VISIT");
		} catch (Exception e) {
			// TODO: handle exception
		}

		while (true) {
			try {
				List<WebElement> $TypeDropdown = driver.findElements(
						By.xpath("(//button[@id='admissionVal_dropdown'])[1]//following::ul[1]/li/a/span[2]"));
				for (WebElement Element : $TypeDropdown) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency")) {

						click(Element);
						break;
					}

				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement fv6 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
		visbility(driver, fv6, 60);
		clear(fv6);
		sendkeys(fv6, "Vist fav");

		WebElement fv7 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPell']//following::button[2]"));
		visbility(driver, fv7, 60);
		javascriptclick(fv7);
		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fv8 = driver.findElement(By.xpath("(//span[@title='Add this visit reason'])[1]"));
				visbility(driver, fv8, 60);
				javascriptclick(fv8);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fv9 = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonFavKpop2']/div[1]/div[1]//following::span[1]"));
				visbility(driver, fv9, 60);
				javascriptclick(fv9);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);

		// $$$$$$$$//

		// vaccine

		for (int i = 1; i <= 5; i++) {

			try {
				WebElement vc1 = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Vaccine list ')]"));
				actions("move to element", vc1);
				visbility(driver, vc1, 60);
				javascriptclick(vc1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		WebElement vc2 = driver
				.findElement(By.xpath("//div[@id='VaccineFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
		visbility(driver, vc2, 60);
		javascriptclick(vc2);

		WebElement vc3 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[1]"));
		visbility(driver, vc3, 60);
		sendkeys(vc3, "vacc");
		List<WebElement> vc4;
		while (true) {

			vc4 = driver.findElements(By.xpath(
					//// div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[2]/li/a/span[2]

					"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));

			if (vc4.size() >= 5) {
				System.out.println(vc4.size());
				break;
			}
		}

		for (WebElement web : vc4) {
			System.out.println(web.getText());

			if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
				web.click();
				break;
			}

		}

		WebElement vc5 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]"));

		visbility(driver, vc5, 60);
		sendkeys(vc5, "vacine favorite");

		WebElement vc6 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::button[2]"));
		visbility(driver, vc6, 60);
		javascriptclick(vc6);
		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement vc7 = driver
						.findElement(By.xpath("(//span[@title='Add this vaccine'])[1]//following::div[1]/div[2]"));
				visbility(driver, vc7, 60);
				javascriptclick(vc7);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement vc8 = driver.findElement(By.xpath("//input[@id='vaccine-cvx']//following::span[3]"));
		javascriptclick(vc8);

		WebElement vc9 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[1]"));
		visbility(driver, vc9, 60);
		sendkeys(vc9, "vacc");
		List<WebElement> vc10;
		while (true) {

			vc10 = driver.findElements(By.xpath(
					"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));
			if (vc10.size() >= 5) {
				break;
			}
		}

		for (WebElement we : vc10) {

			if (we.getText().trim().equals("vaccinia immune globulin")) {

				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}

		WebElement vc11 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]"));
		visbility(driver, vc11, 60);
		clear(vc11);
		sendkeys(vc11, "vacine module");

		WebElement vc12 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::button[2]"));
		visbility(driver, vc12, 60);
		javascriptclick(vc12);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement vc13 = driver.findElement(By.xpath("(//span[@title='Add this vaccine'])[1]"));
				visbility(driver, vc13, 60);
				javascriptclick(vc13);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		WebElement vc14 = driver
				.findElement(By.xpath("//div[@id='VaccineFavKpop2']/div[1]/div[1]//following::span[1]"));
		visbility(driver, vc14, 60);
		javascriptclick(vc14);
		sleep(2500);

		//
		// $$$$$$$$$symptoms$$$$$

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement sypmtomfavicon = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Symptoms list fo')]"));
				actions("move to element", sypmtomfavicon);
				visbility(driver, sypmtomfavicon, 60);
				javascriptclick(sypmtomfavicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addnewsympfav = driver.findElement(
						By.xpath("//div[@id='SymptomsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, addnewsympfav, 60);
				javascriptclick(addnewsympfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement sympicdbox = driver
				.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
		visbility(driver, sympicdbox, 60);
		sendkeys(sympicdbox, "test");
		List<WebElement> symptomsdrop;
		while (true) {
			try {
				symptomsdrop = driver.findElements(By
						.xpath("//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
				if (symptomsdrop.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : symptomsdrop) {
			if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		WebElement symptsdis = driver.findElement(By.xpath("//div[@id='Symptom-div']/div[2]/input"));
		visbility(driver, symptsdis, 60);
		sendkeys(symptsdis, "symptoms favorite");
		WebElement savesymptfav = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savesymptfav, 60);
		javascriptclick(savesymptfav);
		sleep(3000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editsympfav = driver
						.findElement(By.xpath("(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[2]"));
				visbility(driver, editsympfav, 60);
				javascriptclick(editsympfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement crossicon = driver.findElement(By.xpath("//span[text()='R76.1']//following::span[1]"));
		visbility(driver, crossicon, 60);
		javascriptclick(crossicon);

		WebElement sympicdbox2 = driver
				.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
		visbility(driver, sympicdbox2, 60);
		sendkeys(sympicdbox2, "test");
		List<WebElement> symptomsdrop2;

		while (true) {
			try {

				symptomsdrop2 = driver.findElements(By
						.xpath("//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
				if (symptomsdrop2.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : symptomsdrop2) {
			if (web.getText().trim().equals("R85.81: Anal high risk human papillomavirus (HPV) DNA test positive")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}

		WebElement symptsdis2 = driver.findElement(By.xpath("//div[@id='Symptom-div']/div[2]/input"));
		visbility(driver, symptsdis2, 60);
		clear(symptsdis2);
		sendkeys(symptsdis2, "symptoms favorite kpop2");

		WebElement savesymptfav2 = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savesymptfav2, 60);
		javascriptclick(savesymptfav2);
		sleep(3000);

		WebElement addsymptolist = driver.findElement(By.xpath("(//span[contains(@title,'Add this symptom')])[1]"));
		visbility(driver, addsymptolist, 60);
		javascriptclick(addsymptolist);
		sleep(2000);

		WebElement closefavkpopwin = driver
				.findElement(By.xpath("//div[@id='SymptomsFavKpop2']/div[1]/div[1]//following::span[1]"));
		visbility(driver, closefavkpopwin, 60);
		javascriptclick(closefavkpopwin);
		sleep(2500);
		//
		// $$$$$$procedure$$$$

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfav = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Procedure li')]"));
				actions("move to element", prcdfav);
				visbility(driver, prcdfav, 60);
				javascriptclick(prcdfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfaviconadd = driver.findElement(
						By.xpath("//div[@id='ProcedureFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, prcdfaviconadd, 60);
				javascriptclick(prcdfaviconadd);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement selectprcddrop = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select"));
		visbility(driver, selectprcddrop, 60);
		dropDown("index", selectprcddrop, "2");

		WebElement prcddis = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, prcddis, 60);
		sendkeys(prcddis, "test");
		List<WebElement> prcddropdwn;

		while (true) {
			try {
				prcddropdwn = driver.findElements(By.xpath(
						"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/small/em"));
				if (prcddropdwn.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : prcddropdwn) {

			if (web.getText().trim().equals("SNOMED : 134287002")) {
				// System.out.println("procedure met..");
				visbility(driver, web, 60);
				javascriptclick(web);
				break;

			}

		}
		WebElement prcddisbox = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[2]"));
		visbility(driver, prcddisbox, 60);
		sendkeys(prcddisbox, "procedure favorite");

		WebElement prcdsavefav = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button"));
		visbility(driver, prcdsavefav, 60);
		javascriptclick(prcdsavefav);

		List<WebElement> svcs = driver
				.findElements(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button//following::ul[1]/li/a"));
		for (WebElement web : svcs) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfvlist = driver
						.findElement(By.xpath("(//span[@title='Add this procedure'])[1]//following::div[1]/div[2]"));
				visbility(driver, prcdfvlist, 60);
				javascriptclick(prcdfvlist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement crossiconprcd = driver.findElement(By.xpath("//span[text()='134287002']//following::span[1]"));
		visbility(driver, crossiconprcd, 60);
		javascriptclick(crossiconprcd);

		WebElement prcddis2 = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, prcddis2, 60);

		sendkeys(prcddis2, "test");
		List<WebElement> prcddropdwn2;
		while (true) {
			try {
				prcddropdwn2 = driver.findElements(By.xpath(
						"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/b"));
				if (prcddropdwn2.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : prcddropdwn2) {

			if (web.getText().trim().equals("Platelet adhesiveness test (procedure)")) {

				visbility(driver, web, 60);
				javascriptclick(web);
				break;

			}

		}

		WebElement prcddisbox2 = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[2]"));
		visbility(driver, prcddisbox2, 60);
		clear(prcddisbox2);
		sendkeys(prcddisbox2, "procedure kpop2 favorite");

		WebElement prcdsavefav2 = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button"));
		visbility(driver, prcdsavefav2, 60);
		javascriptclick(prcdsavefav2);

		List<WebElement> svcs1 = driver
				.findElements(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button//following::ul[1]/li/a"));
		for (WebElement web : svcs1) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdaddtplost = driver
						.findElement(By.xpath("(//span[contains(@title,'Add this procedure')])[1]"));

				visbility(driver, prcdaddtplost, 60);
				javascriptclick(prcdaddtplost);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfavkpopcl = driver
						.findElement(By.xpath("//div[@id='ProcedureFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, prcdfavkpopcl, 60);
				javascriptclick(prcdfavkpopcl);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		//

		// $$$$$$$Goals

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement goalsfavicon = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Goals list for ')]"));
				actions("move to element", goalsfavicon);
				visbility(driver, goalsfavicon, 60);
				javascriptclick(goalsfavicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement goaslfavaddicon = driver.findElement(
						By.xpath("//div[@id='GoalsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, goaslfavaddicon, 60);
				javascriptclick(goaslfavaddicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement pellcontenticon = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[1]/button[1]"));
		visbility(driver, pellcontenticon, 60);
		javascriptclick(pellcontenticon);
		WebElement goasldis = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]"));
		visbility(driver, goasldis, 60);
		sendkeys(goasldis, "GOALS MODULE FAVORITE");

		WebElement goaslfavsave = driver.findElement(By.xpath("//div[@id='addfav-div']/div[1]//following::button[2]"));
		visbility(driver, goaslfavsave, 60);
		javascriptclick(goaslfavsave);
		sleep(1500);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addgoasltolist = driver
						.findElement(By.xpath("(//span[contains(@title,'Add this goal')])[1]"));
				visbility(driver, addgoasltolist, 60);
				javascriptclick(addgoasltolist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement closegoaslfavwin = driver
						.findElement(By.xpath("//div[@id='GoalsFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, closegoaslfavwin, 60);
				javascriptclick(closegoaslfavwin);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		//
		// $$$$$status

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement statusfavicon = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Status list for ')]"));
				actions("move to element", statusfavicon);
				visbility(driver, statusfavicon, 60);
				javascriptclick(statusfavicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $statusEhrFavAdd$ = driver.findElement(
						By.xpath("//div[@id='StatusFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, $statusEhrFavAdd$, 60);
				javascriptclick($statusEhrFavAdd$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement statusdropdwn = driver
						.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select"));
				visbility(driver, statusdropdwn, 60);
				dropDown("index", statusdropdwn, "2");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement statusdis = driver
				.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, statusdis, 60);

		sendkeys(statusdis, "test");
		List<WebElement> $statusicddrp$;
		;
		while (true) {
			try {
				$statusicddrp$ = driver.findElements(By.xpath(
						"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
				if ($statusicddrp$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement we : $statusicddrp$) {
			if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality (finding)")) {
				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}
		WebElement savestatus = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savestatus, 60);
		javascriptclick(savestatus);
		sleep(2000);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement editstatus = driver
						.findElement(By.xpath("(//div[contains(text(),'134374006: Hearing test bilateral')])[1]"));

				visbility(driver, editstatus, 60);
				javascriptclick(editstatus);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement crossiconstatus = driver
				.findElement(By.xpath("(//span[text()='134374006'])[1]//following::span[1]"));
		visbility(driver, crossiconstatus, 60);
		javascriptclick(crossiconstatus);

		WebElement statusdis2 = driver
				.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, statusdis2, 60);
		sendkeys(statusdis2, "test");
		List<WebElement> $stsdrp$;
		while (true) {
			try {
				$stsdrp$ = driver.findElements(By.xpath(
						"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
				if ($stsdrp$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement we : $stsdrp$) {
			if (we.getText().trim().equals("134376008: Hearing test right abnormality (finding)")) {
				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}
		WebElement savestatus2 = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savestatus2, 60);
		javascriptclick(savestatus2);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement addstatus = driver.findElement(By.xpath("(//span[contains(@title,'Add this status')])[1]"));
				visbility(driver, addstatus, 60);
				javascriptclick(addstatus);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement statusclose = driver.findElement(By.xpath("//div[@id='StatusFavKpop2']/div[1]/div[2]/span"));

				visbility(driver, statusclose, 60);
				javascriptclick(statusclose);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		//
		// $$$$$$problems$$$$$$$

		pro.favoriteProblemAddIcon();

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
		sleep(4000);
		//
		// $$$$$advance directives

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addnewfavadv = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Advance directives list ')]"));
				actions("move to element", addnewfavadv);
				visbility(driver, addnewfavadv, 60);
				elementClickable(addnewfavadv);
				click(addnewfavadv);
				break;
			} catch (Exception e) {
				WebElement addnewfavadv = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Advance directives list ')]"));
				actions("move to element", addnewfavadv);
				visbility(driver, addnewfavadv, 60);
				elementClickable(addnewfavadv);
				click(addnewfavadv);
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $Advnce_Dir_Add$ = driver.findElement(By.xpath(
						"//div[@id='Advance_DirectivesFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				click($Advnce_Dir_Add$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $adv_dir_drop$ = driver
						.findElement(By.xpath("(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]"));
				dropDown("text", $adv_dir_drop$, "Assessment");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $adv_dis$ = driver.findElement(
				By.xpath("(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]//following::input[1]"));
		sendkeys($adv_dis$, "Advance directives");

		WebElement $save_adv$ = driver
				.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
		click($save_adv$);
		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $edit_adv$ = driver.findElement(By.xpath("(//span[text()='Assessment'])[1]"));
				click($edit_adv$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $adv_dis2$ = driver.findElement(
				By.xpath("(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]//following::input[1]"));
		clear($adv_dis2$);
		sendkeys($adv_dis2$, "Advance directives");

		WebElement $save_adv1$ = driver
				.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
		click($save_adv1$);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $add_dirToList$ = driver.findElement(By.xpath(
						"((//span[text()='Assessment'])[1]//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1])[1]"));
				click($add_dirToList$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		WebElement $closeIconAdvFavKpop$ = driver
				.findElement(By.xpath("//div[@id='Advance_DirectivesFavKpop2']/div[1]/div[2]/span"));
		click($closeIconAdvFavKpop$);
		sleep(2000);
		//

		// $$$$notes

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement notefav = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Notes list ')]"));
				actions("move to element", notefav);

				javascriptclick(notefav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		WebElement addnotetn = driver
				.findElement(By.xpath("//div[@id='NotesFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));

		visbility(driver, addnotetn, 60);
		javascriptclick(addnotetn);
		WebElement notesdis = driver.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]"));
		visbility(driver, notesdis, 60);
		sendkeys(notesdis, "Notes module");
		WebElement savenotesfav = driver
				.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]//following::button[2]"));
		visbility(driver, savenotesfav, 60);
		javascriptclick(savenotesfav);
		sleep(1500);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editnt = driver.findElement(By.xpath("(//div[text()='Notes module'])[1]"));
				visbility(driver, editnt, 60);
				javascriptclick(editnt);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement notesdis2 = driver.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]"));
				clear(notesdis2);
				sendkeys(notesdis2, "Notes");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement savenotesfav2 = driver
				.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]//following::button[2]"));
		visbility(driver, savenotesfav2, 60);
		javascriptclick(savenotesfav2);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addtolist = driver.findElement(By.xpath("(//span[contains(@title,'Add this note')])[2]"));
				visbility(driver, addtolist, 60);
				javascriptclick(addtolist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement cancelnote = driver.findElement(By.xpath("//div[@id='NotesFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, cancelnote, 60);
				javascriptclick(cancelnote);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		//
		// $$$physical exam
		for (int i = 1; i <= 5; i++) {
			try {

				WebElement pysaddfav = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Physical Examination list')]"));
				actions("move to element", pysaddfav);
				visbility(driver, pysaddfav, 60);

				javascriptclick(pysaddfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $addPhysExam$ = driver.findElement(By.xpath(
						"//div[@id='Physical_ExaminationsFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));

				javascriptclick($addPhysExam$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement x2 = driver.findElement(By.id("bodyParts"));
		visbility(driver, x2, 60);
		sendkeys(x2, "hello");// .sendKeys("hello");

		WebElement x3 = driver.findElement(By.id("finding"));
		visbility(driver, x3, 60);
		sendkeys(x3, "hw are you");// .sendKeys("hw are you");

		WebElement x4 = driver.findElement(By.xpath("//div[@id='pNotes']/div[2]/input"));
		visbility(driver, x4, 60);
		sendkeys(x4, "Physical Examination modules");// .sendKeys("Physical Examination modules");
		WebElement abc = driver
				.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, abc, 60);
		ww.until(ExpectedConditions.elementToBeClickable(abc));
		javascriptclick(abc);
		sleep(2000);

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $editPhysc$ = driver.findElement(By.xpath("(//div[text()='hello'])[1]"));
				javascriptclick($editPhysc$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement pysc1 = driver.findElement(By.id("bodyParts"));
		visbility(driver, pysc1, 60);
		clear(pysc1);
		sendkeys(pysc1, "hello");// .sendKeys("hello");

		WebElement pysc2 = driver.findElement(By.id("finding"));
		visbility(driver, pysc2, 60);
		clear(pysc2);
		sendkeys(pysc2, "hw are you");// .sendKeys("hw are you");

		WebElement $savePysc$ = driver
				.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, $savePysc$, 60);
		ww.until(ExpectedConditions.elementToBeClickable($savePysc$));
		javascriptclick($savePysc$);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $addPyscTolist$ = driver.findElement(
						By.xpath("(//div[text()='hello'])[1]//parent::div[1]//parent::div[1]/div[1]/span[1]"));
				click($addPyscTolist$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $closePyscKpop2$ = driver
						.findElement(By.xpath("//span[text()='Favorite Physical Examinations']//following::span[1]"));
				click($closePyscKpop2$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);

		WebElement printehr = driver.findElement(By.xpath("//i[@onclick='ehr.ehrShowPrintOptions();']"));
		ScriptExecutor(printehr);
		WebElement timest = driver
				.findElement(By.xpath("//i[@onclick='ehr.ehrShowPrintOptions();']//following::span[3]"));

		visbility(driver, timest, 25);
		javascriptclick(timest);

		List<WebElement> stmp = driver.findElements(
				By.xpath("//i[@onclick='ehr.ehrShowPrintOptions();']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : stmp) {
			if (web.getText().trim().equals("Show Timestamp")) {
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
		dropDown("index", folowupmnth, "0");
		driver.findElement(By.xpath("(//a[text()='28'])")).click();
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

		//sleep(2000);
		/*
		 * WebElement delehrf = driver.findElement(By.
		 * xpath("(//button[contains(@title,'Delete Health Record')])[1]"));
		 * javascriptclick(delehrf); sleep(2000); WebElement zr = driver
		 * .findElement(By.
		 * xpath("//span[text()='Delete Health Record']//following::div[4]/button[2]"));
		 * javascriptclick(zr);
		 */
		sleep(4000);
		
	}

	@Test(priority = 3,enabled = false)

	public void calendar() throws Exception {
		cal.caledarModule();

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);
	}

	@Test(priority = 4,enabled = false)
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

		/*
		 * if (r.isDisplayed()) { visbility(driver, r, 60); click(r);
		 */
		// break;
		// }

		/*
		 * } catch (Exception e) {
		 * 
		 * } }
		 */

		/*
		 * while (true) { try {
		 */

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

		/*
		 * break; } catch (Exception e) {
		 * 
		 * } }
		 * 
		 */ while (true) {
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
				WebElement edi = driver.findElement(
						By.xpath("(//span[text()='Kaaspro']//parent::div//parent::div[1]//parent::div[1]/div[2])[1]"));
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
		// driver.navigate().to("https://localhost:8443/health/#bill_report");
		if (ur.equals("https://www.test.75health.com/")) {

			driver.navigate().to("https://www.test.75health.com/health/#bill_report");

		} else if (ur.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#bill_report");
		} else if (ur.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#bill_report");
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
				// TODO: handle exception
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
				// TODO: handle exception
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
		String inc;
		while (true) {
			try {
				WebElement getinc = driver.findElement(By.xpath("//span[@id='receiptId']"));
				visbility(driver, getinc, 60);
				inc = getinc.getText();
				System.out.println(inc);
				break;
			} catch (Exception e) {

			}
		}

		sleep(3000);

		driver.navigate().back();

		while (true) {
			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#bill_report")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#bill_report")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#bill_report")) {
				break;
			}
		}

		while (true) {
			try {
				WebElement rqs = driver.findElement(By.xpath("//div[text()='" + inc + "']"));
				visbility(driver, rqs, 60);

				actions("click", rqs);
				break;
			} catch (Exception e) {

			}
		}
		sleep(1000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editit = driver.findElement(By.xpath("//div[text()='dolo']"));
				visbility(driver, editit, 60);
				javascriptclick(editit);
				break;
			} catch (Exception e) {

			}
		}
		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		clear(pom.getInstanceBilling().enterTheItem);

		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		sendkeys(pom.getInstanceBilling().enterTheItem, "Paracetamal");

		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		clear(pom.getInstanceBilling().addPrice);
		sendkeys(pom.getInstanceBilling().addPrice, "90");

		WebElement saveit = driver.findElement(
				By.xpath("//div[text()='dolo']//following::div[6]/div[2]//following::div[1]/div[2]/div[1]/button[3]"));
		visbility(driver, saveit, 60);
		javascriptclick(saveit);

	}

	@Test(priority = 5,enabled = false)
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
			visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
			elementClickable(pom.getInstanceTeleDoctor().clickTeleDoctor);
			click(pom.getInstanceTeleDoctor().clickTeleDoctor);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);
			elementClickable(pom.getInstanceTeleDoctor().clickTeleDoctor);
			click(pom.getInstanceTeleDoctor().clickTeleDoctor);
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

	@Test(priority = 6,enabled = false)
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

	@Test(priority = 7,enabled = false)
	public void Settings() throws InterruptedException, IOException {

		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;

			} else if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				driver.navigate().refresh();
				break;
			} else if (!driver.getCurrentUrl().equals("https://www.test.75health.com/health/#setting")) {
				javascriptclick(pom.getInstanceSetting().clickSettings);
				driver.navigate().refresh();
				break;
			}

		}
		implicitWait(40, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {
			try {
				WebElement $manageaccount$ = driver.findElement(By.xpath("//button[text()='Manage your Account']"));
				visbility(driver, $manageaccount$, 60);
				elementClickable($manageaccount$);
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

		WebElement set1 = driver.findElement(By.id("firstName"));
		visbility(driver, set1, 60);
		clear(set1);// .clear();
		sleep(2000);
		sendkeys(set1, "hello doctor");
		WebElement set2 = driver.findElement(By.id("lastName"));
		visbility(driver, set2, 60);
		set2.clear();
		sleep(2000);
		sendkeys(set2, "health organisation");
		sleep(3000);
		WebElement fint = driver.findElement(By.xpath("(//button[@id='save-btn'])[4]"));
		visbility(driver, fint, 60);
		j.executeScript("arguments[0].click();", fint);
		sleep(3000);

		// patient info
		while (true) {
			try {
				WebElement patientinfoedit = driver.findElement(By.xpath("(//span[@id='edit-btn'])[1]"));
				if (patientinfoedit.isDisplayed()) {
					visbility(driver, patientinfoedit, 50);
					actions("click", patientinfoedit);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement gender = driver.findElement(By.xpath("(//button[@id='gender'])[1]"));
		visbility(driver, gender, 60);
		j.executeScript("arguments[0].click();", gender);
		List<WebElement> genderdropdown = driver
				.findElements(By.xpath("(//button[@id='gender'])[1]//following::ul[1]/li"));
		for (WebElement web : genderdropdown) {
			if (web.getText().trim().equals("Male")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().contentEquals("dr")) {
			WebElement education = driver.findElement(By.xpath("(//input[@id='educationform'])[1]"));
			visbility(driver, education, 60);
			education.clear();
			education.sendKeys("B.tech");
			sleep(2000);
			WebElement license = driver.findElement(By.xpath("(//input[@id='licensenum'])[1]"));
			visbility(driver, license, 60);
			license.clear();

			license.sendKeys("trt43534");
		}

		sleep(2000);
		WebElement saveadmininfo = driver.findElement(By.xpath("(//button[@id='save-btn'])[2]"));
		visbility(driver, saveadmininfo, 60);
		j.executeScript("arguments[0].click();", saveadmininfo);
		while (true) {
			try {
				WebElement trp7 = driver.findElement(By.xpath("(//button[@onclick='Page.goBack()'])[1]"));
				visbility(driver, trp7, 60);
				click(trp7);
				break;
			} catch (Exception e) {

			}
		}

		/*
		 * while (true) { try { WebElement trp9 =
		 * driver.findElement(By.xpath("//button[@onclick='setting.changep()']"));
		 * visbility(driver, trp9, 60); click(trp9);// .click(); break; } catch
		 * (Exception e) { // TODO: handle exception } } WebElement trp10 =
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
		 * WebElement trp13 =
		 * driver.findElement(By.xpath("//button[@id='save-submitform']"));
		 * visbility(driver, trp13, 60); javascriptclick(trp13);// .click();
		 * sleep(3000);
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

		sleep(4000);
		while (true) {
			try {

				WebElement frs = driver.findElement(By.xpath("//button[@id='auto-logout-time']"));
				visbility(driver, frs, 60);
				elementClickable(frs);
				click(frs);// .click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2000);
		List<WebElement> time = driver.findElements(By.xpath("//ul[@id='logoutt']/li"));
		for (WebElement w : time) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}
		sleep(4000);
		// WebElement cdsclick;
		// cds
		WebElement cdsclick = driver.findElement(By.xpath("//button[contains(text(),'Clinical Decision')]"));
		visbility(driver, cdsclick, 60);
		elementClickable(cdsclick);
		click(cdsclick);
		sleep(2000);
		WebElement newcds = driver.findElement(By.xpath("//span[contains(text(),'New Clinical')]"));
		visbility(driver, newcds, 60);
		elementClickable(newcds);
		click(newcds);

		sleep(3000);
		try {
			WebElement s8 = driver.findElement(By.xpath("(//input[@id='description'])[1]"));
			visbility(driver, s8, 60);
			sendkeys(s8, "Akash");// .sendKeys("Akash");
		} catch (Exception e) {
			WebElement s8 = driver.findElement(By.xpath("(//input[@id='description'])[1]"));
			visbility(driver, s8, 60);
			sendkeys(s8, "Akash");
		}
		sleep(2000);
		WebElement scrolltill = driver.findElement(By.xpath("//input[@id='weight_from']"));
		ScriptExecutor(scrolltill);
		sleep(2000);
		visbility(driver, scrolltill, 60);
		WebElement s9 = driver.findElement(By.xpath("(//input[@id='problem_icd_10'])[2]"));
		visbility(driver, s9, 60);
		sendkeys(s9, "test");// .sendKeys("test");
		sleep(3000);
		WebElement actionproblem = driver.findElement(By.xpath("//div[text()='Malignant neoplasm of testis']"));
		visbility(driver, actionproblem, 60);
		actions("click", actionproblem);
		sleep(2000);
		WebElement activecheck = driver.findElement(By.xpath("//input[@id='active']"));
		visbility(driver, activecheck, 60);
		actions("click", activecheck);
		sleep(2000);
		WebElement savecds = driver.findElement(By.xpath("//input[@id='active']//following::div[4]/div/button"));
		visbility(driver, savecds, 60);
		javascriptclick(savecds);
		sleep(4000);

		try {
			WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
			visbility(driver, clicksett, 60);
			elementClickable(clicksett);
			click(clicksett);
		} catch (Exception e) {
			WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
			visbility(driver, clicksett, 60);
			elementClickable(clicksett);
			click(clicksett);
		}
		visbility(driver, cdsclick, 60);
		ScriptExecutor(cdsclick);

		// favorrites..

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

			} else if (w.getText().trim().equals("Symptoms")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement symptomsAddIcon = driver
						.findElement(By.xpath("(//div[@id='SymptomsFavKpop2']//following::span[5])[1]"));
				visbility(driver, symptomsAddIcon, 30);
				ww.until(ExpectedConditions.elementToBeClickable(symptomsAddIcon));
				click(symptomsAddIcon);

				WebElement SymptomIcdTextBox = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::input[1])[1]"));
				visbility(driver, SymptomIcdTextBox, 40);
				sendkeys(SymptomIcdTextBox, "test");

				List<WebElement> symptomsdrop;
				while (true) {
					try {
						symptomsdrop = driver.findElements(By.xpath(
								"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
						if (symptomsdrop.size() > 5) {
							break;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				for (WebElement web : symptomsdrop) {
					if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
						visbility(driver, web, 60);
						javascriptclick(web);
						break;
					}

				}

				WebElement SymptomDisBox = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::input[2])[1]"));
				visbility(driver, SymptomDisBox, 40);
				sendkeys(SymptomDisBox, "Symptoms");

				WebElement saveSymptom = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::button[2])[1]"));
				visbility(driver, saveSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(saveSymptom));
				click(saveSymptom);
				sleep(2500);
				WebElement editSymptom;
				while (true) {
					try {
						editSymptom = driver.findElement(
								By.xpath("(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]"));
						break;
					} catch (StaleElementReferenceException e) {
						e.printStackTrace();
					}
				}
				visbility(driver, editSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(editSymptom));
				click(editSymptom);

				WebElement deleteSymptom = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::span[2])[1]"));
				visbility(driver, deleteSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(deleteSymptom));
				click(deleteSymptom);
				WebElement closeSymptomIcon = driver
						.findElement(By.xpath("(//div[@id='SymptomsFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeSymptomIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(closeSymptomIcon));
				click(closeSymptomIcon);

				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().equals("Problems")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				WebElement ProblemsAddIcon = driver
						.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']//following::span[5])[1]"));
				visbility(driver, ProblemsAddIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(ProblemsAddIcon));
				click(ProblemsAddIcon);

				WebElement ProblemsIcdBox = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[1])[1]"));
				visbility(driver, ProblemsIcdBox, 40);
				sendkeys(ProblemsIcdBox, "test");
				try {
					Problems problem = new Problems(driver);
					problem.$favproblemsIcdCode();
				} catch (Exception e) {

					e.printStackTrace();
				}
				WebElement problemTextBox = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[2])[1]"));
				visbility(driver, problemTextBox, 40);
				sendkeys(problemTextBox, "Problems");
				WebElement saveProblem = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::button[2])[1]"));
				visbility(driver, saveProblem, 40);
				ww.until(ExpectedConditions.elementToBeClickable(saveProblem));
				click(saveProblem);
				sleep(2500);
				WebElement editProblem = driver
						.findElement(By.xpath("(//span[text()='Malignant neoplasm of testis'])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(editProblem));
				click(editProblem);
				sleep(2000);
				WebElement deleteProblem = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteProblem));
				click(deleteProblem);
				WebElement closeProblemIcon = driver
						.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeProblemIcon));
				click(closeProblemIcon);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Visit Reason")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				try {
					WebElement VisitReasonAddIcon = driver
							.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]"));
					visbility(driver, VisitReasonAddIcon, 40);
					elementClickable(VisitReasonAddIcon);
					click(VisitReasonAddIcon);
				} catch (ElementClickInterceptedException e) {
					WebElement VisitReasonAddIcon = driver
							.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]"));
					visbility(driver, VisitReasonAddIcon, 40);
					elementClickable(VisitReasonAddIcon);
					click(VisitReasonAddIcon);
				}
				ww.until(ExpectedConditions
						.elementToBeClickable(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav));
				click(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav);
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])[1]//following::ul[1]/li/a"));

				for (WebElement Element : $TypeDropdown) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						visbility(driver, Element, 50);
						elementClickable(Element);
						click(Element);
						break;
					}

				}
				WebElement VisitReasonDiscription = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
				visbility(driver, VisitReasonDiscription, 40);
				sendkeys(VisitReasonDiscription, "VisitReason");

				WebElement saveVisitReason = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveVisitReason));
				click(saveVisitReason);
				sleep(2500);
				WebElement editVisitReason = driver.findElement(By.xpath("(//div[text()='VisitReason'])[1]"));
				visbility(driver, editVisitReason, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editVisitReason));
				click(editVisitReason);
				WebElement deleteVisitReason = driver
						.findElement(By.xpath("(//div[@id='Visit_ReasonKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteVisitReason));
				click(deleteVisitReason);

				WebElement closeVisitReason = driver
						.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeVisitReason));
				click(closeVisitReason);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Procedure")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				WebElement PreocedureSetFavAddIcon = driver
						.findElement(By.xpath("(//div[@id='ProcedureFavKpop2']//following::span[5])[1]"));
				visbility(driver, PreocedureSetFavAddIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(PreocedureSetFavAddIcon));
				click(PreocedureSetFavAddIcon);

				WebElement SetfavprocedureCodeTypeDropdown = driver.findElement(By.xpath("//select[@id='codeType']"));
				visbility(driver, SetfavprocedureCodeTypeDropdown, 60);
				ww.until(ExpectedConditions.elementToBeClickable(SetfavprocedureCodeTypeDropdown));
				click(SetfavprocedureCodeTypeDropdown);

				dropDown("text", SetfavprocedureCodeTypeDropdown, "SNOMED CT");

				WebElement SetfavProcedureIcdBox = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::input[1])[1]"));
				visbility(driver, SetfavProcedureIcdBox, 40);
				sendkeys(SetfavProcedureIcdBox, "test");

				List<WebElement> prcddropdwn;
				;
				while (true) {
					try {
						prcddropdwn = driver.findElements(By.xpath(
								"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div/small/em"));
						if (prcddropdwn.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}
				for (WebElement web : prcddropdwn) {

					if (web.getText().trim().equals("SNOMED : 134287002")) {
						// System.out.println("procedure met..");
						visbility(driver, web, 60);
						javascriptclick(web);
						break;

					}

				}

				WebElement SetFavProcedureTextbox = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::input[2])[1]"));
				visbility(driver, SetFavProcedureTextbox, 40);
				sendkeys(SetFavProcedureTextbox, "procedure");

				WebElement saveSetFavProcedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::button[2])[1]"));
				visbility(driver, saveSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(saveSetFavProcedure));
				click(saveSetFavProcedure);
				sleep(2500);

				WebElement editSetFavProcedure = driver.findElement(
						By.xpath("(//div[text()='134287002: Cytomegalovirus antigen test (procedure)'])[1]"));
				visbility(driver, editSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editSetFavProcedure));
				click(editSetFavProcedure);

				WebElement deleteProcedureSetFav = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteProcedureSetFav));
				click(deleteProcedureSetFav);

				WebElement closeSetFavProcedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(closeSetFavProcedure));
				click(closeSetFavProcedure);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().equals("Medications")) {
				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement MedicationAddIcon = driver
						.findElement(By.xpath("(//div[@id='MedicationsFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(MedicationAddIcon));
				click(MedicationAddIcon);

				WebElement MedicationIcdBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[1])[1]"));
				visbility(driver, MedicationIcdBoxSetfav, 40);
				sendkeys(MedicationIcdBoxSetfav, "1009");
				visbility(driver, MedicationIcdBoxSetfav, 40);
				clear(MedicationIcdBoxSetfav);
				sendkeys(MedicationIcdBoxSetfav, "1009");
				List<WebElement> $med$drop$down$;

				while (true) {
					try {
						$med$drop$down$ = driver.findElements(By.xpath(
								"//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[2]/li/a/div/small/em"));
						if ($med$drop$down$.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}

				for (WebElement we : $med$drop$down$) {
					System.out.println(we.getText());
					if (we.getText().trim().equals("RXNORM : 1009145")) {
						// System.out.println("med cond met");
						visbility(driver, we, 60);
						javascriptclick(we);
						break;

					}

				}

				WebElement savemedicationSetFav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::button[3])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(savemedicationSetFav));
				click(savemedicationSetFav);
				sleep(2500);

				if (ur.equals("https://www.75health.com/login.jsp")) {
					WebElement editmedicationSetFav = driver.findElement(By.xpath(
							"(//div[text()='amphetamine aspartate 1.875 MG / amphetamine sulfate 1.875 MG / dextroamphetamine saccharate 1.875 MG / dextroamphetamine sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]"));
					visbility(driver, editmedicationSetFav, 50);
					elementClickable(editmedicationSetFav);
					click(editmedicationSetFav);
				} else if (ur.equals("https://localhost:8443/")) {
					WebElement editmedicationSetFav = driver.findElement(By.xpath(
							"(//div[text()='Amphetamine aspartate 1.875 MG / Amphetamine Sulfate 1.875 MG / Dextroamphetamine saccharate 1.875 MG / Dextroamphetamine Sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]"));
					visbility(driver, editmedicationSetFav, 50);
					elementClickable(editmedicationSetFav);
					click(editmedicationSetFav);

				}
				WebElement deletemedsetfav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deletemedsetfav));
				click(deletemedsetfav);

				WebElement closemedicationSetFav = driver
						.findElement(By.xpath("(//div[@id='MedicationsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closemedicationSetFav));
				click(closemedicationSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Test Order")) {
				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement TestOrderAddIcon = driver
						.findElement(By.xpath("(//div[@id='Test_OrderFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(TestOrderAddIcon));
				click(TestOrderAddIcon);

				WebElement TestOrderIcdBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::input[1])[1]"));
				visbility(driver, TestOrderIcdBoxSetfav, 40);
				sendkeys(TestOrderIcdBoxSetfav, "test");

				WebElement saveTestOrderSetFav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveTestOrderSetFav));
				click(saveTestOrderSetFav);
				sleep(2500);
				WebElement editTestOrderSetFav = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
				visbility(driver, editTestOrderSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editTestOrderSetFav));
				click(editTestOrderSetFav);

				WebElement deleteTestOrdersetfav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteTestOrdersetfav));
				click(deleteTestOrdersetfav);

				WebElement closeTestOrderSetFav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeTestOrderSetFav, 50);
				ww.until(ExpectedConditions.elementToBeClickable(closeTestOrderSetFav));
				click(closeTestOrderSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Vaccine")) {

				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement VaccineAddIcon = driver
						.findElement(By.xpath("(//div[@id='VaccineFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(VaccineAddIcon));
				click(VaccineAddIcon);

				WebElement vaccineIcdTextBox = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::input[1])[1]"));
				visbility(driver, vaccineIcdTextBox, 40);
				sendkeys(vaccineIcdTextBox, "vacc");

				List<WebElement> vc4;
				while (true) {

					vc4 = driver.findElements(By.xpath(
							//// div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[2]/li/a/span[2]

							"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));

					if (vc4.size() >= 5) {
						System.out.println(vc4.size());
						break;
					}
				}

				for (WebElement web : vc4) {
					System.out.println(web.getText());

					if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
						web.click();
						break;
					}

				}

				WebElement VaccDisBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::input[2])[1]"));
				visbility(driver, VaccDisBoxSetfav, 40);
				sendkeys(VaccDisBoxSetfav, "vaccine");

				WebElement saveVaccineSetFav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveVaccineSetFav));
				click(saveVaccineSetFav);
				sleep(2500);
				WebElement editVaccSetFav = driver
						.findElement(By.xpath("(//div[text()='105: vaccinia (smallpox) diluted'])[1]"));
				visbility(driver, editVaccSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editVaccSetFav));
				click(editVaccSetFav);

				WebElement deleteVaccsetfav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteVaccsetfav));
				click(deleteVaccsetfav);

				WebElement closeVaccSetFav = driver
						.findElement(By.xpath("(//div[@id='VaccineFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeVaccSetFav));
				click(closeVaccSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Goals")) {

				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement GoalsAddIcon = driver
						.findElement(By.xpath("(//div[@id='GoalsFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(GoalsAddIcon));
				click(GoalsAddIcon);

				WebElement GoalsTextBox = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]"));
				visbility(driver, GoalsTextBox, 40);
				sendkeys(GoalsTextBox, "goals");

				WebElement saveGoalSetFav = driver
						.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]//following::button[2]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveGoalSetFav));
				click(saveGoalSetFav);
				sleep(2500);
				WebElement editGoalSetFav = driver.findElement(By.xpath("(//div[text()='goals'])[1]"));
				visbility(driver, editGoalSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editGoalSetFav));
				click(editGoalSetFav);

				WebElement deleteGoalssetfav = driver
						.findElement(By.xpath("(//div[@id='GoalsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteGoalssetfav));
				click(deleteGoalssetfav);

				WebElement closeGoalsSetFav = driver
						.findElement(By.xpath("(//div[@id='GoalsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeGoalsSetFav));
				click(closeGoalsSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			}

		}
		sleep(2500);
		try {
			WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
			visbility(driver, clicksett, 60);
			elementClickable(clicksett);
			click(clicksett);
		} catch (Exception e) {
			WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
			visbility(driver, clicksett, 60);
			elementClickable(clicksett);
			click(clicksett);
		}
		visbility(driver, cdsclick, 60);
		ScriptExecutor(cdsclick);

		sleep(3000);

		// edit preference....
		while (true) {
			try {
				WebElement s10 = driver.findElement(By.xpath("//button[@id='edit-print-preference']"));
				visbility(driver, s10, 60);
				click(s10);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(3000);
		WebElement s11 = driver.findElement(By.xpath("//button[@title='Cancel Preferences']"));
		visbility(driver, s11, 60);
		click(s11);
		sleep(3000);
		WebElement s12 = driver.findElement(By.xpath("//button[@title='Reset All Your Setting']"));
		visbility(driver, s12, 60);
		click(s12);// .click();
		sleep(2000);
		WebElement df = driver.findElement(By.xpath("(//button[@id='resetbtn'])[1]"));
		for (int i = 1; i <= 7; i++) {

			if (df.isDisplayed()) {
				click(df);
				break;
			}
		}

		sleep(3000);
		while (true) {
			try {
				click(pom.getInstanceSetting().clickSettings);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// notification
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().contentEquals("dr")) {

			while (true) {
				try {

					WebElement rr = driver.findElement(By.xpath(
							"//span[text()='Set interval for receiving emails.']//parent::div//parent::div[1]/label/input"));
					// visbility(driver, rr, 60);
					actions("click", rr);
					break;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		driver.navigate().refresh();

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

		List<WebElement> dashboardDropdown = driver
				.findElements(By.xpath("(//div[@id='option-setting'])[1]/div/img//following::ul[1]/li"));

		for (WebElement st : dashboardDropdown) {
			if (st.getText().trim().equals("Home")) {
				visbility(driver, st, 50);
				elementClickable(st);
				click(st);
				sleep(2000);
				visbility(driver, dashboard, 50);
				elementClickable(dashboard);
				click(dashboard);
			} else if (st.getText().trim().equals("Dashboard")) {
				visbility(driver, st, 50);
				elementClickable(st);
				click(st);
				sleep(2000);
				visbility(driver, dashboard, 50);
				elementClickable(dashboard);
				click(dashboard);
			} else if (st.getText().trim().equals("Quick Tour")) {
				visbility(driver, st, 50);
				elementClickable(st);
				click(st);
				sleep(2000);
				WebElement cncltr = driver.findElement(By.xpath("(//li[text()='NO, CANCEL TOUR'])[1]"));
				visbility(driver, cncltr, 50);
				elementClickable(cncltr);
				click(cncltr);
				sleep(2000);
				visbility(driver, dashboard, 50);
				elementClickable(dashboard);
				click(dashboard);
			} else if (st.getText().trim().equals("Settings")) {
				visbility(driver, st, 50);
				elementClickable(st);
				click(st);
				sleep(2000);
				visbility(driver, dashboard, 50);
				elementClickable(dashboard);
				click(dashboard);

			} else if (st.getText().trim().equals("Sign out")) {
				visbility(driver, st, 50);
				elementClickable(st);
				click(st);

				break;
			}

		}

	}

}
