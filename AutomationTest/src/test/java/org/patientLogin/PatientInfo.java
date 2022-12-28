package org.patientLogin;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class PatientInfo extends Base {

	public static WebDriver driver;
	static PageObjMan pom;
	static JavascriptExecutor js;
	WebDriverWait ww;
	String ur;
	Calendars cal;
	String $current;

	@BeforeClass
	private void Login() throws Exception {
		Map<String, Object> getConnection = LaunchBrowser.openConnection();
		pom = (PageObjMan) getConnection.get("pom");
		js = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");
		driver = (WebDriver) getConnection.get("driver");
		System.out.println("before");

	}

	@Test(priority = 0, enabled = false)
	private void healthRecord() throws InterruptedException {
		System.out.println("1");

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement hr = driver.findElement(By.xpath("//td[text()='Health Record']"));
				if (hr.isDisplayed()) {
					System.out.println("1");
					click(hr);
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		System.out.println("exit");
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement ehr_ellpises = driver
						.findElement(By.xpath("(//div[@id='list_ehr_needHelp'])[2]/span[3]/span"));

				if (ehr_ellpises.isDisplayed()) {
					System.out.println("ENTER");
					click(ehr_ellpises);
					break;
				}
			} catch (Exception e) {

			}

		}
		List<WebElement> hs = driver
				.findElements(By.xpath("(//div[@id='list_ehr_needHelp'])[2]/span[3]/span//following::ul[1]/li/a"));
		for (WebElement w : hs) {
			if (w.getText().trim().equals("Filter")) {
				w.click();
				break;
			}

		}
		sleep(2000);

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement dateCreatedButton = driver
						.findElement(By.xpath("(//div[@id='date-created'])[1]/div[1]/button"));
				if (dateCreatedButton.isDisplayed()) {
					click(dateCreatedButton);
					break;
				}
			} catch (Exception e) {
			}
		}

		List<WebElement> createdDropDown = driver
				.findElements(By.xpath("(//div[@id='date-created'])[1]/div[1]/button//following::ul[1]/li/a"));
		for (WebElement webE : createdDropDown) {
			if (webE.getText().trim().equals("Today")) {
				click(webE);
				break;
			}

		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement ApplyButton = driver.findElement(By
						.xpath("(//div[@id='date-created'])[1]/div[1]/button//following::ul[1]//following::button[7]"));
				if (ApplyButton.isDisplayed()) {
					click(ApplyButton);
					break;
				}
			} catch (Exception e) {

			}
		}

	}

	@Test(priority = 1)
	private void appointmentPatient() throws InterruptedException {
		implicitWait(30, TimeUnit.SECONDS);
		sleep(3000);
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement appointment = driver.findElement(By.xpath("//td[text()='Appointment']"));
				click(appointment);
				break;

			} catch (Exception e) {

			}
		}
		sleep(3000);
		driver.findElement(By.xpath("//input[@id='doctorPartyName-cal']")).sendKeys("308-8426");
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement clicdoctr = driver.findElement(By.xpath("//td[text()='308-8426']"));
				if (clicdoctr.isDisplayed()) {
					click(clicdoctr);
					break;
				}

			} catch (Exception e) {

			}
		}
		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
	}

	@Test(priority = 2)
	private void appointment() throws InterruptedException {
		PatietAppoint patient = new PatietAppoint();
		patient.bookAppointment(driver, cal);

	}

	@Test(priority = 3,enabled = false)
	private void billing() throws InterruptedException {

		implicitWait(30, TimeUnit.SECONDS);
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement blinng = driver.findElement(By.xpath("//td[text()='Billing']"));
				if (blinng.isDisplayed()) {
					click(blinng);
					break;
				}

			} catch (Exception e) {

			}
		}
		sleep(3000);
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement pr1 = driver.findElement(By.xpath("//i[@onclick='bill_report.print();']"));
				if (pr1.isDisplayed()) {
					click(pr1);
					break;
				}

			} catch (Exception e) {

			}

		}
		sleep(3000);
		driver.navigate().refresh();

	}

	@Test(priority = 4,enabled = false)
	private void message() throws InterruptedException {

		while (true) {
			try {
				visbility(driver, pom.getInstanceMessage().clickMessage, 60);
				click(pom.getInstanceMessage().clickMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, pom.getInstanceMessage().clickComposemMessage, 60);
				click(pom.getInstanceMessage().clickComposemMessage); //
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				sendkeys(pom.getInstanceMessage().search, "308-8426");
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

		/*
		 * WebElement msg = driver.findElement(By.xpath("//td[text()='Message ']"));
		 * js.executeScript("arguments[0].click();", msg); sleep(3000);
		 * 
		 * WebElement ms1 = driver.findElement(By.xpath("//button[@id='compose-btn']"));
		 * js.executeScript("arguments[0].click();", ms1); sleep(3000);
		 * driver.findElement(By.xpath("(//input[@id='emailSearch'])[1]")).sendKeys(
		 * "3087-516"); sleep(3000); WebElement id1 =
		 * driver.findElement(By.xpath("//span[text()='us acc']"));
		 * js.executeScript("arguments[0].click();", id1); sleep(2000);
		 * driver.findElement(By.xpath("(//input[@id='subject'])[1]")).sendKeys("hello")
		 * ; sleep(3000); WebElement tr =
		 * driver.findElement(By.xpath("//div[@id='pell-content']"));
		 * js.executeScript("arguments[0].click();", tr); sleep(3000); WebElement bld =
		 * driver.findElement(By.xpath("//button[@title='Bold']"));
		 * js.executeScript("arguments[0].click();", bld); sleep(3000);
		 * driver.findElement(By.xpath("//div[@id='pell-content']")).
		 * sendKeys("welcome to kaaspro");
		 * driver.findElement(By.xpath("(//button[@id='send-btn'])[1]")).click();
		 * sleep(4000);
		 */
	}

	@Test(priority = 7,enabled = false)
	private void Settings() throws InterruptedException, IOException {

		while (true) {

			if (ur.equals("https://localhost:8443/")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				driver.navigate().refresh();
				break;

			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.navigate().to("https://www.75health.com/health/#setting");
				driver.navigate().refresh();
				break;
			} else if (ur.equals("https://www.test.75health.com/")) {
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
				click($manageaccount$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// medical info

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement medicalinfo = driver
						.findElement(By.xpath("//span[text()='Medical Information    ']//following::span[1]"));
				if (medicalinfo.isDisplayed()) {
					click(medicalinfo);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
				if (firstname.isDisplayed()) {
					clear(firstname);
					sendkeys(firstname, "Kaaspro");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement lasttname = driver.findElement(By.xpath("//input[@id='lastName']"));
				if (lasttname.isDisplayed()) {
					clear(lasttname);
					sendkeys(lasttname, "ENTERPRISES");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement bloodgrp = driver.findElement(By.xpath("//input[@id='lastName']//following::button[1]"));
				if (bloodgrp.isDisplayed()) {
					click(bloodgrp);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> bloodgrpDropdown = driver
				.findElements(By.xpath("//input[@id='lastName']//following::button[1]//following::ul[1]/li/a"));
		for (WebElement webElement : bloodgrpDropdown) {
			if (webElement.getText().trim().equals("O Positive")) {
				click(webElement);
				break;
			}

		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement id = driver.findElement(By.xpath("//input[@id='national-id']"));
				if (id.isDisplayed()) {
					clear(id);
					sendkeys(id, "ehr based");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement insurance = driver.findElement(By.xpath("//input[@id='insurance-info']"));
				if (insurance.isDisplayed()) {
					clear(insurance);
					sendkeys(insurance, "ehr based");
					break;
				}
			} catch (Exception e) {

			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement saveMedicalinfo = driver
						.findElement(By.xpath("//input[@id='insurance-info']//following::button[5]"));
				if (saveMedicalinfo.isDisplayed()) {
					click(saveMedicalinfo);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.navigate().refresh();
		// contact info
		while (true) {
			try {
				WebElement contactIcon = driver.findElement(By
						.xpath("//div[@id='p-address-phone']/div/div/div[1]/div[1]//following::div[1]/div[2]/div/div"));
				if (contactIcon.isDisplayed()) {
					click(contactIcon);
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		visbility(driver, pom.getInstanceNewPatient().Addressline1, 40);
		sendkeys(pom.getInstanceNewPatient().Addressline1, "no.224 watson");
		visbility(driver, pom.getInstanceNewPatient().Addressline2, 30);
		sendkeys(pom.getInstanceNewPatient().Addressline2, "Arizona");
		visbility(driver, pom.getInstanceNewPatient().City, 30);
		sendkeys(pom.getInstanceNewPatient().City, "WWF");

		while (true) {
			try {

				visbility(driver, pom.getInstanceNewPatient().selectCountry, 40);
				dropDown("index", pom.getInstanceNewPatient().selectCountry, "03");
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		while (true) {
			try {

				visbility(driver, pom.getInstanceNewPatient().selectState, 40);
				dropDown("index", pom.getInstanceNewPatient().selectState, "05");
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		visbility(driver, pom.getInstanceNewPatient().zipCode, 40);

		sendkeys(pom.getInstanceNewPatient().zipCode, "600110");

		visbility(driver, pom.getInstanceNewPatient().saveContactInfo, 40);

		javascriptclick(pom.getInstanceNewPatient().saveContactInfo);
		/*
		 * // alternate contact info...
		 * 
		 * while (true) { try {
		 * 
		 * if (pom.getInstanceNewPatient().AlternateContactIcon.isDisplayed()) {
		 * click(pom.getInstanceNewPatient().AlternateContactIcon); break; } } catch
		 * (Exception e) { System.out.println(e); } }
		 * 
		 * while (true) { try { WebElement fullname = driver .findElement(By.
		 * xpath("(//span[text()='Alternate Contact'])[4]//following::input[1]")); if
		 * (fullname.isDisplayed()) { sendkeys(fullname, "Kaaspro"); break; } } catch
		 * (Exception e) { System.out.println(e); } }
		 * 
		 * while (true) { WebElement flag = driver.findElement(By.xpath(
		 * "(//span[text()='Alternate Contact'])[4]//following::input[1]//following::div[1]/div/div/div"
		 * )); try { if (flag.isDisplayed()) { click(flag); break; } } catch (Exception
		 * e) {
		 * 
		 * } }
		 * 
		 * List<WebElement> countrycode = driver.findElements(By.xpath(
		 * "(//span[text()='Alternate Contact'])[4]//following::input[2]//parent::div[1]/div/div//following::ul[1]/li/span[2]"
		 * )); for (WebElement w : countrycode) {
		 * 
		 * if (w.getText().equals("+91")) { click(w); break; }
		 * 
		 * } WebElement numberfield = driver .findElement(By.
		 * xpath("(//span[text()='Alternate Contact'])[4]//following::input[2]"));
		 * visbility(driver, numberfield, 40); sendkeys(numberfield, "9087674532");
		 * while (true) { try { WebElement savealtrnate = driver .findElement(By.
		 * xpath("(//span[text()='Alternate Contact'])[4]//following::div[1]/img[1]"));
		 * if (savealtrnate.isDisplayed()) { click(savealtrnate); break; } } catch
		 * (Exception e) { System.out.println(e); } }
		 */
		sleep(2000);

		// patient info..
		while (true) {
			try {
				if (pom.getInstanceNewPatient().addPatientInfoIcon.isDisplayed()) {
					click(pom.getInstanceNewPatient().addPatientInfoIcon);
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		while (true) {
			try {

				visbility(driver, pom.getInstanceNewPatient().addOccupation, 30);
				sendkeys(pom.getInstanceNewPatient().addOccupation, "Software tester");
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		while (true) {
			try {

				if (pom.getInstanceNewPatient().savePatientinfo.isDisplayed()) {
					click(pom.getInstanceNewPatient().savePatientinfo);
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		for (int i = 1; i <= 7; i++) {

			try {
				if (pom.getInstanceSetting().clickSettings.isDisplayed()) {
					javascriptclick(pom.getInstanceSetting().clickSettings);
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		sleep(3000);
		WebElement trp9 = driver.findElement(By.xpath("//button[@onclick='setting.changep()']"));
		visbility(driver, trp9, 60);
		click(trp9);// .click();
		WebElement trp10 = driver.findElement(By.id("currentPassword"));
		visbility(driver, trp10, 60);
		sendkeys(trp10, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		WebElement trp11 = driver.findElement(By.id("newPassword"));
		visbility(driver, trp11, 60);
		sendkeys(trp11, ConfigManager.getconfigManager().getInstanceConfigReader().newpassword());
		WebElement trp12 = driver.findElement(By.id("confirmNewPassword"));
		visbility(driver, trp12, 60);
		sendkeys(trp12, ConfigManager.getconfigManager().getInstanceConfigReader().newpassword());

		WebElement trp13 = driver.findElement(By.id("save-submitform"));
		visbility(driver, trp13, 60);
		click(trp13);// .click();

		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#setting")) {
				break;
			}
		}

		for (int i = 1; i <= 7; i++) {
			try {
				WebElement autoLogout = driver.findElement(By.xpath("//button[@id='auto-logout-time']"));
				if (autoLogout.isDisplayed()) {

					click(autoLogout);
					break;
				}

			} catch (Exception e) {

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

		/*
		 * WebElement st1 = driver.findElement(By.xpath("//td[text()='Settings']"));
		 * js.executeScript("arguments[0].click();", st1); sleep(4000); WebElement mu =
		 * driver.findElement(By.xpath("//button[text()='Manage your Account']"));
		 * js.executeScript("arguments[0].click();", mu); sleep(3000); WebElement addbtn
		 * =
		 * driver.findElement(By.xpath("(//button[@title='Add Contact Information'])"));
		 * js.executeScript("arguments[0].click();", addbtn); sleep(2000);
		 * driver.findElement(By.xpath("(//input[@id='address1'])")).sendKeys("no.224");
		 * sleep(2000);
		 * driver.findElement(By.xpath("(//input[@id='address2'])[1]")).sendKeys(
		 * "arizona"); sleep(2000);
		 * driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("dont know"
		 * ); sleep(2000); WebElement sel2 =
		 * driver.findElement(By.xpath("(//select[@id='countryGeoId'])[1]"));
		 * sel2.click(); dropDown("text", sel2, "India"); sleep(3000);
		 * driver.findElement(By.xpath("(//input[@id='postalCode'])[1]")).sendKeys(
		 * "600011"); sleep(3000); WebElement ph1 =
		 * driver.findElement(By.xpath("(//input[@id='phone1'])[1]")); ph1.clear();
		 * ph1.sendKeys("+918072326751"); sleep(3000);
		 * driver.findElement(By.xpath("(//textarea[@id='notes'])[1]")).
		 * sendKeys("all is well"); sleep(3000);
		 * driver.findElement(By.xpath("(//div[@id='save-btn'])[7]")).click();
		 * 
		 * sleep(2000);
		 * driver.findElement(By.xpath("(//button[@onclick='Page.goBack()'])[1]")).click
		 * (); sleep(3000); // change password
		 * driver.findElement(By.xpath("//button[@onclick='setting.changep()']")).click(
		 * ); sleep(2000);
		 * driver.findElement(By.xpath("(//input[@id='currentPassword'])[1]")).sendKeys(
		 * "1"); sleep(3000);
		 * driver.findElement(By.xpath("(//input[@id='newPassword'])[1]")).sendKeys("1")
		 * ; driver.findElement(By.xpath("(//input[@id='confirmNewPassword'])[1]")).
		 * sendKeys("1"); sleep(2000); WebElement sv1 =
		 * driver.findElement(By.xpath("//button[@id='save']"));
		 * js.executeScript("arguments[0].click();", sv1);
		 */
		// sleep(3000);
		/*
		 * WebElement cl1 =
		 * driver.findElement(By.xpath("//button[@id='auto-logout-time']"));
		 * js.executeScript("arguments[0].click();", cl1); sleep(2000); List<WebElement>
		 * drp = driver.findElements(By.xpath("//ul[@id='logoutt']/li")); for
		 * (WebElement w : drp) { if (w.getText().trim().equals("4 Hour")) { w.click();
		 * break; }
		 * 
		 * }
		 */
		sleep(3000);
		WebElement dateformat = driver.findElement(By.xpath("//button[@id='date-format']"));
		js.executeScript("arguments[0].click();", dateformat);
		sleep(3000);
		List<WebElement> sel3 = driver.findElements(By.xpath("//ul[@id='Dateformatscroll']/li"));
		for (WebElement w : sel3) {

			if (w.getText().trim().equals("YYYY-MM-DD")) {
				w.click();
				break;
			}

		}
	}
}
