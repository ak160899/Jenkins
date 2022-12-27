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

public class Lite_package extends Base {

	public WebDriver driver;
	PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid;

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
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		/*
		 * while (true) { if
		 * (!driver.getCurrentUrl().equals("https://localhost:8443/health/#home")) {
		 * click(pom.getInstanceLoginPage().login); break; } else { break; } }
		 */
		sleep(3000);

		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		implicitWait(70, TimeUnit.SECONDS);

	}

	@Test(priority = 1, enabled = false)
	private void home() throws InterruptedException {

		WebElement ata = driver.findElement(By.xpath("(//span[contains(text(),'New Pa')])[4]//parent::button"));
		visbility(driver, ata, 60);
		ww.until(ExpectedConditions.elementToBeClickable(ata));

		j.executeScript("arguments[0].click();", ata);
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

					WebElement qrs = driver.findElement(By.xpath("(//input[@id='AppointmentPatientName'])[" + i + "]"));
					visbility(driver, qrs, 60);
					qrs.sendKeys(hkpid);
					break;
				}

			}

			if (cond == true) {
				sleep(2000);
				implicitWait(60, TimeUnit.SECONDS);
				WebElement choosepatient = driver
						.findElement(By.xpath("(//td[text()='" + hkpid + "'])[2]//parent::td"));
				visbility(driver, choosepatient, 60);
				ww.until(ExpectedConditions.elementToBeClickable(choosepatient));
				actions("click", choosepatient);

				WebElement qt = driver.findElement(By.xpath("(//textarea[@id='description'])[" + i + "]"));
				visbility(driver, qt, 60);
				qt.sendKeys("no worries...");
				WebElement utt = driver.findElement(By.xpath("(//button[@id='statusId_dropdown'])[" + i + "]"));
				clickble(driver, utt, 60);
				j.executeScript("arguments[0].click();", utt);

				List<WebElement> lop = driver.findElements(By.xpath("(//ul[@id='statusIdDropdown'])[" + i + "]/li"));
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
		WebElement pit = driver.findElement(By.xpath("//td[text()='Patient']"));
		visbility(driver, pit, 60);
		j.executeScript("arguments[0].click();", pit);

		implicitWait(60, TimeUnit.SECONDS);
		WebElement ata = driver.findElement(By.xpath("(//button[@title='Add new Patient'])[1]"));
		visbility(driver, ata, 60);
		j.executeScript("arguments[0].click();", ata);
		visbility(driver, pom.getInstanceNewPatient().firstName, 60);
		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		visbility(driver, pom.getInstanceNewPatient().lastname, 60);
		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		visbility(driver, pom.getInstanceNewPatient().clickGenderIcon, 60);
		click(pom.getInstanceNewPatient().clickGenderIcon);

		List<WebElement> genders = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));
		for (WebElement opt : genders) {

			if (opt.getText().equals("Male")) {

				driver.findElement(By.xpath("(//ul[@id='genderDropdown'])[1]/li")).click();

			}
			break;
		}

		// Acc gets Created..
		visbility(driver, pom.getInstanceNewPatient().CreatePatient, 60);
		click(pom.getInstanceNewPatient().CreatePatient);

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

	@Test(priority = 3, enabled = false)
	private void ehr_module() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#list_ehr");
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
				// TODO: handle exception
			}
		}
		sleep(2000);
		List<WebElement> wwe = driver
				.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
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

		while (true) {
			try {

				driver.findElement(By.xpath("(//button[contains(@title,'Add Multiple Vitals')])[1]")).click();

				driver.findElement(By.id("wresult")).sendKeys("55");

				WebElement sel = driver.findElement(By.xpath("(//select[@id='unit'])[1]"));
				click(sel);
				sleep(2000);
				dropDown("text", sel, "kilograms");
				WebElement edity = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
				visbility(driver, edity, 60);
				click(edity);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(priority = 4)
	private void calendar_module() throws Exception {

		driver.navigate().to("https://localhost:8443/health/#calendar");
		implicitWait(60, TimeUnit.SECONDS);

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		WebElement clbtn = driver.findElement(By.xpath("(//button[@id='calendar-day-month'])[1]"));

		visbility(driver, clbtn, 60);
		clickble(driver, clbtn, 60);
		clbtn.click();
		sleep(3000);
		List<WebElement> choose = driver.findElements(By.xpath("//ul[@id='calendarul']/li"));

		for (WebElement web : choose) {
			if (web.getText().equals("Today")) {
				driver.findElement(By.xpath("//ul[@id='calendarul']/li")).click();
				break;
			}
		}
		sleep(2000);

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));
		int totalr = totalnumberrowdy.size();
		// System.out.println("found you>>>" + totalr);

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {
			int a = 1 + i;
			WebElement ss = driver.findElement(By.xpath("//div[@id='date-data'][" + i + "]/div[2]/div[2]/div"));
			if (ss.getText().equals("Doctor/User not working")) {
				System.out.println("yes doctor not working for the:" + i);
				WebElement abcd = driver.findElement(By.xpath("(//span[@id='editCalendar'])[" + a + "]"));
				visbility(driver, abcd, 60);
				actions("click", abcd);
				sleep(3000);
				WebElement checkbx = driver.findElement(By.xpath("(//input[@id='is-working-day'])[1]"));
				System.out.println("(//input[@id='is-working-day'])[" + i + "]");
				visbility(driver, checkbx, 60);
				actions("click", checkbx);
				WebElement ampm = driver.findElement(By.xpath("(//div[@id='thru-ampm'])[1]"));
				visbility(driver, ampm, 60);
				actions("click", ampm);
				WebElement rre = driver.findElement(By.xpath("(//div[@id='save-btn'])[1]"));
				visbility(driver, rre, 60);
				javascriptclick(rre);// .click();
				sleep(5000);

			}

			// represent total in a part..
			List<WebElement> rchange = driver
					.findElements(By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div/div[1]/div[1]/div[1])"));
			int avaiable = rchange.size();

			for (int b = 1; b <= avaiable; b++) {

				WebElement tp = driver.findElement(

						By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div[" + b + "]/div[1]/div[1]/div[1])"));

				String tr = tp.getText();
				boolean trp = tp.isDisplayed();

				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed()) {

					cond = true;
					visbility(driver, tp, 60);
					javascriptclick(tp);

					WebElement prp = driver.findElement(By.xpath("(//input[@id='AppointmentPatientName'])[" + i + "]"));
					visbility(driver, prp, 60);
					sendkeys(prp, kpid);// .sendKeys(kpid);
					break;
				}

			}
			if (cond == true) {
				sleep(2000);
				implicitWait(30, TimeUnit.SECONDS);
				List<WebElement> choosepatient = driver
						.findElements(By.xpath("//ul[@id='ui-id-2']/li/a/table/tbody/tr/td[2]"));
				// (//td[text()='" + kpid + "'])[2]//parent::td
				for (WebElement web : choosepatient) {
					if (web.getText().trim().equals(kpid)) {
						visbility(driver, web, 60);
						web.click();
						break;
					}

				}
				sleep(3000);

				WebElement ut = driver.findElement(By.xpath("(//select[@id='triage-appointment'])[" + i + "]"));
				visbility(driver, ut, 60);
				// ut.click();
				dropDown("text", ut, "Emergency");

				WebElement $subscribe = driver
						.findElement(By.xpath("//span[text()='Premium Subscription']//following::button[2]"));
				visbility(driver, $subscribe, 30);
				click($subscribe);

				for (int in = 1; in <= 3; in++) {
					try {
						visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
						actions("click", pom.getInstanceSetting().$Carosel$);
						sleep(2500);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				driver.navigate().back();

				break;
			}
		}
		sleep(2000);
	}

	@Test(priority = 5)
	private void billing_module() throws InterruptedException {
		while (true) {
			try {

				visbility(driver, pom.getInstanceBilling().clickBill, 60);
				click(pom.getInstanceBilling().clickBill);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().refresh();
		implicitWait(50, TimeUnit.SECONDS);
		sleep(3000);

		visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
		click(pom.getInstanceBilling().clickCreateNewBill);
		visbility(driver, pom.getInstanceBilling().addItem, 60);

		click(pom.getInstanceBilling().addItem);
		visbility(driver, pom.getInstanceBilling().enterTheItem, 60);

		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo"); //
		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		sendkeys(pom.getInstanceBilling().addPrice, "10"); //
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		clear(pom.getInstanceBilling().addQuantity); //
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		sendkeys(pom.getInstanceBilling().addQuantity, "2");

		visbility(driver, pom.getInstanceBilling().saveItem, 60);
		click(pom.getInstanceBilling().saveItem);
		sleep(3000);

	}

	@Test(priority = 6)
	private void tele_doctor() {
		while (true) {
			try {
				visbility(driver, pom.getInstanceTeleDoctor().clickTeleDoctor, 60);

				click(pom.getInstanceTeleDoctor().clickTeleDoctor);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().refresh();
		implicitWait(60, TimeUnit.SECONDS);

		WebElement np1 = driver.findElement(By.xpath("//button[@title='Create new Patinet']"));
		visbility(driver, np1, 60);
		j.executeScript("arguments[0].click();", np1);
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
		javascriptclick(cp1);

		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#call_history")) {
				break;

			} else if (!driver.getCurrentUrl().equals("https://localhost:8443/health/#call_history")) {
				driver.navigate().to("https://localhost:8443/health/#call_history");
				break;
			}
		}

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

		// manage users..

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		sleep(2000);
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, "Akash");// .sendKeys("Akash");
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, "N");// .sendKeys("N");
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, "Akashn12128077659@gmail.com");// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}

		sleep(3000);
		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		click(createuser);

		while (true) {
			try {
				if (driver.getCurrentUrl().equals("https://localhost:8443/health/#user")) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		while (true) {
			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (!driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				break;
			}
		}

		WebElement $managesub$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		click($managesub$);

		WebElement $createUserFromManageuser$ = driver
				.findElement(By.xpath("//span[text()='Subscription']//following::i[1]"));
		visbility(driver, $createUserFromManageuser$, 60);
		javascriptclick($createUserFromManageuser$);

		WebElement $fisrtName$ = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, $fisrtName$, 60);
		sendkeys($fisrtName$, "sandy");
		WebElement $LastName$ = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, $LastName$, 60);
		sendkeys($LastName$, "san");
		sleep(2000);
		WebElement $email_id$ = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, $email_id$, 60);
		sendkeys($email_id$, "lesthopefosssrgoodone2@gmail.com");

		sleep(2000);
		WebElement $dr_user_drp$ = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, $dr_user_drp$, 60);
		click(trp17);// .click();
		List<WebElement> usserdrps = driver
				.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrps) {
			if (web.getText().trim().equals("Doctor")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement $_createuser$ = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);
		sleep(3000);
		click($_createuser$);
		while (true) {
			try {
				if (driver.getCurrentUrl().equals("https://localhost:8443/health/#user")) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("manage sub");

		driver.navigate().to("https://localhost:8443/health/#setting");

		// market place

		WebElement $mrktplace$ = driver.findElement(By.xpath("//button[text()='Market Place']"));
		visbility(driver, $mrktplace$, 60);
		click($mrktplace$);
		ScriptExecutor($mrktplace$);
		// notification
		WebElement $$edit$$notify$$message$$;
		while (true) {
			try {
				$$edit$$notify$$message$$ = driver.findElement(By
						.xpath("//span[text()='Edit Notification Messages']//parent::div//parent::div[1]/label/input"));

				actions("click", $$edit$$notify$$message$$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		visbility(driver, pom.getInstanceSetting().$upgradeNow, 60);
		click(pom.getInstanceSetting().$upgradeNow);
		/*
		 * visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		 * click(pom.getInstanceSetting().$editplnCrossIcon$);
		 */
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(2500);
		driver.navigate().back();

		// Audit Report

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
	}
}
