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

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Select_Your_plan extends Base {
	public static WebDriver driver;
	static PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid = "3090-160";

	@BeforeClass()
	private void LaunchBrwoser() throws Exception {
		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");

		driver = (WebDriver) getConnection.get("driver");
	}

	@Test(priority = 1)
	private void Home() throws InterruptedException {

		/* for (int i = 1; i <= 7; i++) { */
		try {
			WebElement $$subscribe = driver.findElement(By.xpath("(//button[contains(@title,'Subscribe Now')])[1]"));
			/* if ($$subs$cribe$$.isDisplayed()) { */
			elementClickable($$subscribe);
			click($$subscribe);
			// break;
		} catch (ElementClickInterceptedException e) {
			WebElement $$subscribe = driver.findElement(By.xpath("(//button[contains(@title,'Subscribe Now')])[1]"));
			/* if ($$subs$cribe$$.isDisplayed()) { */
			elementClickable($$subscribe);
			click($$subscribe);
		}

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
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

		sleep(3000);

		try {

			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			click(pom.getInstanceHomeModule().$patientCreationButton);

		} catch (Exception e) {
			elementClickable(pom.getInstanceHomeModule().$patientCreationButton);
			click(pom.getInstanceHomeModule().$patientCreationButton);
		}

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int b = 1; b <= 3; b++) {

					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);
					sleep(2500);
				}
			}
		}
		driver.navigate().back();

		sleep(4000);

		String hkpid = kpid;
		// home modules appointment...

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

					break;
				}

				if (cond == true) {
					break;
				}

			}
			if (cond == true) {
				break;
			}
		}

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}

		sleep(2500);
	}

	@Test(priority = 2, enabled = false)
	private void patient_Module$() {

		driver.navigate().to("https://localhost:8443/health/#list_patient");

		WebElement $new_patient_cr$ = driver.findElement(By.xpath("(//button[@title='Add new Patient'])[2]"));
		visbility(driver, $new_patient_cr$, 60);
		j.executeScript("arguments[0].click();", $new_patient_cr$);
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);
		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().back();

		// patient search ..

		WebElement s = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[2]"));
		visbility(driver, s, 60);
		sendkeys(s, kpid);
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();

	}

	@Test(priority = 3, enabled = false)
	private void e_h_r() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#list_ehr");

		WebElement remv = driver.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
		visbility(driver, remv, 60);

		javascriptclick(remv);
		sleep(2000);
		List<WebElement> wwe = driver
				.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
		for (WebElement web : wwe) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				clickble(driver, web, 60);

				web.click();
				break;
			}

		}

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
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

		WebElement $new$medical$rec$ = driver.findElement(By.id("newMedicalRecordButton"));
		visbility(driver, $new$medical$rec$, 60);
		click($new$medical$rec$);

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().back();

	}

	@Test(priority = 4, enabled = false)
	private void calendar$$$() throws InterruptedException {

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

					break;
				}

				if (cond == true) {
					break;
				}
			}
			if (cond == true) {
				break;
			}
		}

		sleep(2000);

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);
		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().back();

	}

	@Test(priority = 5, enabled = false)
	private void billing_$() {

		try {
			visbility(driver, pom.getInstanceBilling().clickBill, 60);
			elementClickable(pom.getInstanceBilling().clickBill);
			click(pom.getInstanceBilling().clickBill);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().clickBill, 60);
			elementClickable(pom.getInstanceBilling().clickBill);
			click(pom.getInstanceBilling().clickBill);
		}

		visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
		click(pom.getInstanceBilling().clickCreateNewBill);

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		elementClickable(pom.getInstanceSetting().$sub$scribe$);
		click(pom.getInstanceSetting().$sub$scribe$);

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}

		driver.navigate().to("https://localhost:8443/health/#bill_report");

		try {
			elementClickable(pom.getInstanceSetting().$dismissSubscribe$);
			click(pom.getInstanceSetting().$dismissSubscribe$);
		} catch (Exception e) {
			elementClickable(pom.getInstanceSetting().$dismissSubscribe$);
			click(pom.getInstanceSetting().$dismissSubscribe$);
		}
		WebElement $filterButton$ = driver.findElement(By.xpath("//button[@onclick='bill_report.filter();']"));
		visbility(driver, $filterButton$, 60);
		elementClickable($filterButton$);
		click($filterButton$);
		WebElement $applybutton$ = driver.findElement(By.xpath("(//button[@title='Apply filter'])[1]"));
		visbility(driver, $applybutton$, 60);
		elementClickable($applybutton$);
		click($applybutton$);

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		elementClickable(pom.getInstanceSetting().$sub$scribe$);
		click(pom.getInstanceSetting().$sub$scribe$);
		try {
			elementClickable(pom.getInstanceSetting().$dismissSubscribe$);
			click(pom.getInstanceSetting().$dismissSubscribe$);
		} catch (Exception e) {
			elementClickable(pom.getInstanceSetting().$dismissSubscribe$);
			click(pom.getInstanceSetting().$dismissSubscribe$);
		}

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int c = 1; c <= 3; c++) {

					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);

				}
			}
		}

		driver.navigate().back();

	}

	@Test(priority = 6, enabled = false)
	private void $teleDoctor$() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#call_history");

		visbility(driver, pom.getInstanceTeleDoctor().searchPatient, 60);
		sendkeys(pom.getInstanceTeleDoctor().searchPatient, "ydshjjf");

		try {
			visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
			elementClickable(pom.getInstanceSetting().$sub$scribe$);
			click(pom.getInstanceSetting().$sub$scribe$);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
			elementClickable(pom.getInstanceSetting().$sub$scribe$);
			click(pom.getInstanceSetting().$sub$scribe$);

		}

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int b = 1; b <= 3; b++) {
					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);
				}
			}
		}
		driver.navigate().back();
		sleep(2500);

		WebElement np1 = driver.findElement(By.xpath("//button[@title='Create new Patinet']"));
		elementClickable(np1);
		click(np1);
		elementClickable(pom.getInstanceSetting().$sub$scribe$);
		click(pom.getInstanceSetting().$sub$scribe$);

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);

		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}
		driver.navigate().back();

	}

	@Test(priority = 7, enabled = false)
	private void message() {

		driver.navigate().to("https://localhost:8443/health/#message_list");
		visbility(driver, pom.getInstanceMessage().clickComposemMessage, 60);
		elementClickable(pom.getInstanceMessage().clickComposemMessage);
		click(pom.getInstanceMessage().clickComposemMessage);

		elementClickable(pom.getInstanceSetting().$sub$scribe$);
		click(pom.getInstanceSetting().$sub$scribe$);

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				for (int c = 1; c <= 3; c++) {
					visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
					actions("click", pom.getInstanceSetting().$Carosel$);
				}
			}
		}
		driver.navigate().back();

	}

	@Test(priority = 8)
	private void settings() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#setting");

		// manage your account..

		try {
			WebElement ManageurAccount = driver.findElement(By.xpath("//button[text()='Manage your Account']"));
			elementClickable(ManageurAccount);
			click(ManageurAccount);
			sleep(3000);

		} catch (Exception e) {
			WebElement ManageurAccount = driver.findElement(By.xpath("//button[text()='Manage your Account']"));
			elementClickable(ManageurAccount);
			click(ManageurAccount);
		}

		WebElement Basicinfo = driver.findElement(By.xpath("(//span[@title='Edit'])[2]"));
		visbility(driver, Basicinfo, 60);
		elementClickable(Basicinfo);
		click(Basicinfo);

		WebElement $smsnotifcation = driver.findElement(By.xpath("(//button[@id='smsP'])[1]"));
		elementClickable($smsnotifcation);
		click($smsnotifcation);

		WebElement $subscribenow$ = driver.findElement(By.xpath("//button[@title='Subscribe']"));
		elementClickable($subscribenow$);
		click($subscribenow$);

		sleep(2500);
		WebElement $click$edit$plan$ = driver.findElement(By.xpath("//button[@id='editPlanBtn']"));
		elementClickable($click$edit$plan$);
		click($click$edit$plan$);

		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);

				sleep(2500);
			} catch (Exception e) {

			}
		}
		driver.navigate().to("https://localhost:8443/health/#setting");

		// change password...
		WebElement changepassword = driver.findElement(By.xpath("//button[@onclick='setting.changep()']"));
		elementClickable(changepassword);
		click(changepassword);

		elementClickable(pom.getInstanceSetting().$sub$scribe$);
		click(pom.getInstanceSetting().$sub$scribe$);

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);

		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}
		driver.navigate().back();

		// manage users..

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		elementClickable(manageuser);
		click(manageuser);

		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		elementClickable(adduser);
		click(adduser);

		elementClickable(pom.getInstanceSetting().$sub$scribe$);
		click(pom.getInstanceSetting().$sub$scribe$);

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		elementClickable(pom.getInstanceSetting().$editplan$);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}
		driver.navigate().to("https://localhost:8443/health/#setting");

		// set logo

		WebElement $setlogo$ = driver.findElement(By.xpath("//button[text()='Set Logo']"));
		visbility(driver, $setlogo$, 60);
		click($setlogo$);

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().back();

		WebElement $setsign$ = driver.findElement(By.xpath("//button[text()='Set Signature']"));
		visbility(driver, $setsign$, 60);
		click($setsign$);
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();

		// auto logout time

		WebElement frs = driver.findElement(By.xpath("//button[@id='auto-logout-time']"));
		ScriptExecutor($setsign$);
		sleep(2000);
		visbility(driver, frs, 60);
		click(frs);
		sleep(2000);
		List<WebElement> time = driver.findElements(By.xpath("//ul[@id='logoutt']/li"));
		for (WebElement w : time) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();

		// hospital charges..

		WebElement s1 = driver.findElement(By.xpath("//button[@id='taxbutton']"));
		visbility(driver, s1, 60);
		click(s1);// .click();

		WebElement cl = driver.findElement(By.xpath(
				"/html/body/div[4]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[2]/div/div[6]/div[8]/div/div[1]/div[1]/div[6]/div[1]/div/div[3]/div[1]/ul/li/a"));
		visbility(driver, cl, 60);
		actions("click", cl);

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();

		// cds

		WebElement cdsclick = driver.findElement(By.xpath("//button[contains(text(),'Clinical Decision')]"));
		ScriptExecutor(s1);
		visbility(driver, cdsclick, 60);
		click(cdsclick);
		sleep(2000);
		WebElement newcds = driver.findElement(By.xpath("//span[contains(text(),'New Clinical')]"));
		visbility(driver, newcds, 60);
		click(newcds);
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().to("https://localhost:8443/health/#setting");
		ScriptExecutor(cdsclick);

		// set favorites..
		sleep(2500);
		WebElement $setfavui$ = driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']"));
		click($setfavui$);
		sleep(3000);
		List<WebElement> setfav1 = driver.findElements(By.xpath("//ul[@id='setfavoritesul']/li"));
		for (WebElement w : setfav1) {
			if (w.getText().trim().equals("Problems")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}
		}
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();
		ScriptExecutor($setfavui$);

		// Hospital codes..
		sleep(2500);
		WebElement $hospitalcodeui$ = driver.findElement(By.xpath("//button[@onclick='hospitalcodedropdown();']"));
		click($hospitalcodeui$);// .click();
		List<WebElement> fh = driver.findElements(By.xpath("//ul[@id='hospitalcodeul']/li"));
		for (WebElement w : fh) {
			if (w.getText().trim().equals("Item/Service Code")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}
		}
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();
		ScriptExecutor($hospitalcodeui$);

		// Set forms
		WebElement f1 = driver.findElement(By.xpath("//button[@id='form-script']"));
		visbility(driver, f1, 60);
		click(f1);
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();
		ScriptExecutor(f1);

		// print preferenece
		sleep(2500);
		WebElement s10 = driver.findElement(By.xpath("//button[@id='edit-print-preference']"));
		visbility(driver, s10, 60);
		click(s10);
		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		javascriptclick(pom.getInstanceSetting().$sub$scribe$);
		driver.navigate().back();

		// subscription

		WebElement $subscribe$ = driver.findElement(By.xpath("//button[text()='Subscribe']"));
		visbility(driver, $subscribe$, 60);
		click($subscribe$);
		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		driver.navigate().back();
		ScriptExecutor($subscribe$);

		// market place..

		WebElement $mrktplace$ = driver.findElement(By.xpath("//button[text()='Market Place']"));
		visbility(driver, $mrktplace$, 60);
		click($mrktplace$);
		ScriptExecutor($mrktplace$);
		WebElement $$edit$$notify$$message$$;
		// notifications

		try {
			$$edit$$notify$$message$$ = driver.findElement(
					By.xpath("//span[text()='Edit Notification Messages']//parent::div//parent::div[1]/label/input"));

			actions("click", $$edit$$notify$$message$$);

		} catch (Exception e) {
			System.out.println("Noticication :" + e);
			$$edit$$notify$$message$$ = driver.findElement(
					By.xpath("//span[text()='Edit Notification Messages']//parent::div//parent::div[1]/label/input"));

			actions("click", $$edit$$notify$$message$$);
		}

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);
		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 60);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);

		for (int i = 1; i <= 3; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}
		sleep(2500);
		driver.navigate().back();
		ScriptExecutor($$edit$$notify$$message$$);
		sleep(2000);

		WebElement $ehrcomplete$;
		// notify when ehr is completed
		while (true) {
			try {
				$ehrcomplete$ = driver.findElement(By.xpath(
						"//div[text()='Notification is sent when EHR is completed for the below selected Users.']//following::input[1]"));
				actions("click", $ehrcomplete$);
				break;
			} catch (Exception e) {

			}
		}

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);
		sleep(2500);
		driver.navigate().back();
		ScriptExecutor($ehrcomplete$);

		// push notifcations..
		WebElement $pushnotification$;
		while (true) {
			try {

				$pushnotification$ = driver.findElement(By.xpath(
						"//span[text()=' Enable Push Notifications for the user.']//parent::div//parent::div[1]/label/input"));
				actions("click", $pushnotification$);
				break;
			} catch (Exception e) {

			}
		}

		visbility(driver, pom.getInstanceSetting().$sub$scribe$, 60);
		click(pom.getInstanceSetting().$sub$scribe$);
		sleep(2500);
		driver.navigate().back();

		try {
			WebElement $auditreport$ = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
			elementClickable($auditreport$);
			click($auditreport$);

		} catch (Exception e) {
			WebElement $auditreport$ = driver.findElement(By.xpath("//button[@onclick='setting.audit()']"));
			elementClickable($auditreport$);
			click($auditreport$);
		}

		WebElement $subscribepremium$ = driver.findElement(By.xpath("//button[@title='Subscribe']"));
		visbility(driver, $subscribepremium$, 60);
		elementClickable($subscribepremium$);

		click($subscribepremium$);

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		sleep(2500);
		for (int i = 1; i <= 2; i++) {
			try {
				visbility(driver, pom.getInstanceSetting().$Carosel$, 60);
				actions("click", pom.getInstanceSetting().$Carosel$);
				sleep(2500);
			} catch (Exception e) {

			}
		}
		sleep(2000);
		driver.navigate().back();

	}
}
