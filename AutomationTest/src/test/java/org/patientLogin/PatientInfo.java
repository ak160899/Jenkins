package org.patientLogin;

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
import org.patientPomClass.PageObjectManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class PatientInfo extends LaunchBrowser {

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
				clickIntercept(webE, 30);
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

	@Test(priority = 1, enabled = false)
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
		driver.findElement(By.xpath("//input[@id='doctorPartyName-cal']")).sendKeys("324-0024");
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement clicdoctr = driver.findElement(By.xpath("//td[text()='324-0024']"));
				if (clicdoctr.isDisplayed()) {
					clickIntercept(clicdoctr, 30);
					break;
				}

			} catch (Exception e) {

			}
		}
		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		System.out.println("exit ...");
		sleep(4000);
	}

	@Test(priority = 2, enabled = false)
	private void appointment() throws InterruptedException {
		PatietAppoint patient = new PatietAppoint();
		patient.bookAppointment(driver, cal);

	}

	@Test(priority = 3, enabled = false)
	private void billing() throws InterruptedException {

		implicitWait(30, TimeUnit.SECONDS);
		visbility(driver, pom.getInstanceBilling().clickBill, 60);
		ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().clickBill));
		clickIntercept(pom.getInstanceBilling().clickBill, 30);
		sleep(3000);

		WebElement printbilling = driver.findElement(By.xpath("//i[@onclick='bill_report.print();']"));
		visbility(driver, printbilling, 50);
		elementClickable(printbilling);
		click(printbilling);

		sleep(3000);
		driver.navigate().refresh();

	}

	@Test(priority = 4, enabled = false)
	private void message() throws InterruptedException {

		clickIntercept(pom.getInstanceMessage().clickMessage, 30);
		clickIntercept(pom.getInstanceMessage().clickComposemMessage, 30);

		sendkeys(pom.getInstanceMessage().search, "308-8426");

		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
				if (msg.isDisplayed()) {
					clickIntercept(msg, 30);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		visbility(driver, pom.getInstanceMessage().enterSubject, 60);
		sendkeys(pom.getInstanceMessage().enterSubject, "GOOD MORNING");

		sendkeys(pom.getInstanceMessage().enterMessage, "hello welcome to chennai");
		visbility(driver, pom.getInstanceMessage().sendMessage, 60);
		clickIntercept(pom.getInstanceMessage().sendMessage, 30);
		sleep(2000);
		visbility(driver, pom.getInstanceMessage().seeSentMessage, 60);
		clickIntercept(pom.getInstanceMessage().seeSentMessage, 30);

	}

	@Test(priority = 7)
	private void Settings() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		implicitWait(40, TimeUnit.SECONDS);

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);

		// medical info

		visbility(driver, pm.getInstanceSettings().medicalInfoEditIcon, 40);

		clickIntercept(pm.getInstanceSettings().medicalInfoEditIcon, 30);

		clear(pm.getInstanceSettings().medFirstName);
		sendkeys(pm.getInstanceSettings().medFirstName, "Kaaspro");

		clear(pm.getInstanceSettings().medLastName);
		sendkeys(pm.getInstanceSettings().medLastName, "ENTERPRISES");

		clickIntercept(pm.getInstanceSettings().bloodGroup, 30);

		for (WebElement webElement : pm.getInstanceSettings().bloodGroupDropdown) {
			if (webElement.getText().trim().equals("O Positive")) {
				clickIntercept(webElement, 30);
				break;
			}

		}
		visbility(driver, pm.getInstanceSettings().Nationalid, 30);
		clear(pm.getInstanceSettings().Nationalid);
		sendkeys(pm.getInstanceSettings().Nationalid, "ehr based");
		visbility(driver, pm.getInstanceSettings().insurance, 30);
		clear(pm.getInstanceSettings().insurance);
		sendkeys(pm.getInstanceSettings().insurance, "ehr based");

		clickIntercept(pm.getInstanceSettings().saveMedicalInfo, 30);

		driver.navigate().refresh();
		// contact info

		try {
			WebElement contactIcon = driver.findElement(
					By.xpath("//div[@id='p-address-phone']/div/div/div[1]/div[1]//following::div[1]/div[2]/div/div"));
			visbility(driver, contactIcon, 50);

			clickIntercept(contactIcon, 30);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			WebElement contactIcon = driver.findElement(
					By.xpath("//div[@id='p-address-phone']/div/div/div[1]/div[1]//following::div[1]/div[2]/div/div"));
			visbility(driver, contactIcon, 50);
			clickIntercept(contactIcon, 30);
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

		visbility(driver, pom.getInstanceNewPatient().saveContactInfo, 40);

		elementClickable(pom.getInstanceNewPatient().saveContactInfo);
		click(pom.getInstanceNewPatient().saveContactInfo);

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
		try {
			visbility(driver, pom.getInstanceNewPatient().addPatientInfoIcon, 40);
			elementClickable(pom.getInstanceNewPatient().addPatientInfoIcon);
			click(pom.getInstanceNewPatient().addPatientInfoIcon);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNewPatient().addPatientInfoIcon, 40);
			elementClickable(pom.getInstanceNewPatient().addPatientInfoIcon);
			click(pom.getInstanceNewPatient().addPatientInfoIcon);
		}

		visbility(driver, pom.getInstanceNewPatient().addOccupation, 30);
		sendkeys(pom.getInstanceNewPatient().addOccupation, "Software tester");

		elementClickable(pom.getInstanceNewPatient().savePatientinfo);
		click(pom.getInstanceNewPatient().savePatientinfo);
		System.out.println("ENTER");
		driver.navigate().refresh();

		visbility(driver, pom.getInstanceSetting().clickSettings, 50);

		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		// System.out.println("EXIT");

		sleep(3000);

		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#setting")) {
				break;
			}
		}

		for (WebElement w : pom.getInstanceSetting().autoLogoutDrop) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				/*
				 * elementClickable(w); click(w);
				 */
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

		visbility(driver, pm.getInstanceSettings().dateFormat, 40);

		clickIntercept(pm.getInstanceSettings().dateFormat, 30);
		sleep(3000);

		for (WebElement w : pm.getInstanceSettings().dateformatDropdown) {

			if (w.getText().trim().equals("YYYY-MM-DD")) {
				clickIntercept(w, 30);
				break;
			}

		}
	}

}
