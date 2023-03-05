package com.calendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.base.*;
import com.pageObjeman.PageObjMan;

public class Calendars extends Base {

	WebDriver driver;
	PageObjMan pom;
	String kpid;
	String s;
	public int cnt;
	int count = 2;

	public Calendars(WebDriver driver, PageObjMan pm) {

		this.driver = driver;
		pom = pm;

	}

	public void caledarModule() throws Exception {

		try {
			visbility(driver, pom.getInstanceCalendar().clickCalendar, 50);
			elementClickable(pom.getInstanceCalendar().clickCalendar);
			click(pom.getInstanceCalendar().clickCalendar);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceCalendar().clickCalendar, 50);
			elementClickable(pom.getInstanceCalendar().clickCalendar);
			click(pom.getInstanceCalendar().clickCalendar);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceCalendar().clickCalendar, 50);
			elementClickable(pom.getInstanceCalendar().clickCalendar);
			click(pom.getInstanceCalendar().clickCalendar);
		}
		implicitWait(60, TimeUnit.SECONDS);

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	public void $calenderMod(String s, String id) throws Exception {
		sleep(2000);
		kpid = id;

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));
		int totalr = totalnumberrowdy.size();
		// System.out.println("found you>>>" + totalr);

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {
			int a = 1 + i;

			$checkDoctorUserStatus(i);

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
						$choosePatient(count, kpid);
					} else {
						$choosePatient(i, kpid);
					}
					break;

				} else if (tp.getText().isEmpty() && tp.isDisplayed()) {

					count = count + 1;
					continue;

				}

			}
			System.out.println("COUTN SIZE IS :" + count);

			if (cond == true) {
				System.out.println("BOOKING APPOINTMENT SLOT");

				if (count > 1) {
					$bookAppointmnet(count, s);
					System.out.println("1ST");

				} else {
					$bookAppointmnet(i, s);
					System.out.println("2ND");

				}

			}
			System.out.println("HELLO END");

			if (cond == true) {
				System.out.println("DELETE");
				$delAppointmentSchedule(count, cnt, s);
				break;
			}
			if (cond == false) {
				$nextsetOfDays(cnt);
				$calenderMod(s, id);
			}
		}

		sleep(2000);

	}

	public void $checkDoctorUserStatus(int i) throws InterruptedException {

		WebElement ss = driver.findElement(By.xpath("//div[@id='date-data'][" + i + "]/div[2]/div[2]/div"));
		// System.out.println(ss);
		if (ss.getText().equals("Doctor/User not working")) {
			System.out.println("yes doctor not working for the:" + i);
			WebElement abcd = driver.findElement(By.xpath("(//span[@id='editCalendar'])[" + i + "]"));
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

	}

	public void $nextsetOfDays(int cn) {
		for (int i = 1; i <= 7; i++) {
			// System.out.println("URL NO:" + cn);
			try {
				WebElement $nextSetdays = driver.findElement(

						By.xpath("(//button[@id='calendar-day-month'])[" + cn
								+ "]//parent::div//parent::div[1]/div[2]/button"));

				// System.out.println("NEXT SET DAYS:" + $nextSetdays);
				if ($nextSetdays.isDisplayed()) {

					click($nextSetdays);
					break;
				}
			} catch (Exception e) {

			}
		}

	}

	public void $choosePatient(int i, String id) {

		WebElement prp = driver.findElement(By.xpath("(//input[@id='AppointmentPatientName'])[" + i + "]"));
		System.out.println(prp);
		visbility(driver, prp, 60);
		sendkeys(prp, id);
		System.out.println("EXIT");

	}

	public void $bookAppointmnet(int i, String ss) throws InterruptedException {
		System.out.println("BOOKING FUNCTION CALLED WITH :" + i);

		sleep(2000);
		implicitWait(30, TimeUnit.SECONDS);
		List<WebElement> choosepatient = driver.findElements(
				By.xpath("//div[@id='AppointmentMessage']/div[2]//following::ul[6]/li/a/table[1]/tbody/tr/td[2]"));
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
					.findElement(By.xpath("(//button[@id='admissionVal_dropdown'])[" + i + "]"));
			visbility(driver, $selectappType, 40);
			click($selectappType);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<WebElement> $TypeDropdown = driver
				.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])//following::ul[1]/li/a"));
		for (WebElement Element : $TypeDropdown) {
			if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
				click(Element);
				break;
			}

		}

		WebElement qt = driver.findElement(By.xpath("(//textarea[@id='description'])[" + i + "]"));
		visbility(driver, qt, 60);
		qt.sendKeys("no worries...");
		WebElement utt = driver.findElement(By.xpath("(//button[@id='statusId_dropdown'])[" + i + "]"));
		visbility(driver, utt, 60);
		javascriptclick(utt);

		List<WebElement> lop = driver.findElements(By.xpath("(//ul[@id='statusIdDropdown'])[" + i + "]/li"));
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

		sleep(3000);

		while (true) {
			try {
				WebElement ez = driver.findElement(By.xpath("//span[text()='" + kpid + "']"));
				if (ez.isDisplayed()) {

					visbility(driver, ez, 40);
					elementClickable(ez);
					click(ez);
					break;
				} else {
					WebElement locateKpid = driver.findElement(By.xpath("(//span[text()='" + kpid + "'])[2]"));
					if (locateKpid.isDisplayed()) {
						visbility(driver, locateKpid, 40);
						elementClickable(locateKpid);
						click(locateKpid);
						break;
					}
					System.out.println("not visble ");
				}
			} catch (Exception e) {
				System.out.println("exception in click on kpid");
			}
		}

		sleep(2000);
		// goto ehr..
		WebElement ehr = driver.findElement(By.id("goEhrButton"));

		visbility(driver, ehr, 60);
		click(ehr);// .click();

		sleep(3000);

		while (true) {
			try {
				if (ss.equals("https://localhost:8443/health/#home")
						|| ss.equals("https://www.75health.com/health/#home")) {
					driver.navigate().back();
					driver.navigate().refresh();
					break;
				}
				click(pom.getInstanceCalendar().clickCalendar);
				driver.navigate().refresh();
				break;
			} catch (Exception e) {

			}
		}

		$dayDrop(ss);

		/*
		 * visbility(driver, $deletepaitentAppoint, 60); click($deletepaitentAppoint);
		 */
		sleep(1000);

		/*
		 * List<WebElement> rtr = driver .findElements(By.xpath(
		 * "(//span[@id='del-btn'])[1]//following::ul[1]/li/div/div[2]/span"));
		 * 
		 * for (WebElement web : rtr) { if (web.getAttribute("id").equals("yes-btn")) {
		 * // System.out.println("yes it is deleted"); implicitWait(30,
		 * TimeUnit.SECONDS); actions("click", web);
		 * 
		 * break; }
		 * 
		 * }
		 */
		// cal.$delAppointment(i);
		System.out.println("EXIT BOOK APP");

	}

	public void $delAppointmentSchedule(int count, int c, String currenturl) throws InterruptedException {

		System.out.println("ENTER DEL APP");

		List<WebElement> $deletepaitentAppoint = null;

		while (true) {
			boolean b = false;
			try {

				$deletepaitentAppoint = driver.findElements(By.xpath("//span[@id='kpId']"));

			} catch (Exception e) {

				System.out.println("exception in delete appointment");
			}

			for (WebElement web : $deletepaitentAppoint) {
				// System.out.println(web.getText());

				if (web.getText().equals(kpid)) {
					b = true;
					visbility(driver, web, 40);
					WebDriverWait wait = new WebDriverWait(driver, 45);
					wait.until(ExpectedConditions.elementToBeClickable(web));
					click(web);
					System.out.println("del appointment button clicked");

					break;

				}

			}

			if (b == false) {

				if (currenturl.equals("https://www.75health.com/health/#home")) {
					WebElement nextsetdays = driver.findElement(By.xpath("(//div[@id='unii'])[2]/div[2]/button"));
					visbility(driver, nextsetdays, 40);
					WebDriverWait wait = new WebDriverWait(driver, 40);
					wait.until(ExpectedConditions.elementToBeClickable(nextsetdays));
					click(nextsetdays);
					// System.out.println("");
				} else if (currenturl.equals("https://www.75health.com/health/#calendar")) {

					WebElement nextsetdays = driver.findElement(By.xpath("(//div[@id='unii'])[1]/div[2]/button"));
					visbility(driver, nextsetdays, 40);
					WebDriverWait wait = new WebDriverWait(driver, 40);
					wait.until(ExpectedConditions.elementToBeClickable(nextsetdays));
					click(nextsetdays);

				}

				System.out.println("EXIT HERE");
				sleep(3000);

			} else if (b == true) {
				System.out.println("TRUE...");
				break;
			}
		}

		for (int in = 1; in <= 7; in++) {
			try {
				if (s.equals("https://localhost:8443/health/#home") || s.equals("https://www.75health.com/health/#home")
						|| s.equals("https://www.75health.com/health/#calendar")
						|| s.equals("https://localhost:8443/health/#calendar")) {

					if (count > 1) {
						count = count - 1;
						WebElement wtw = driver.findElement(By.xpath("(//span[@id='del-btn'])[" + count + "]"));
						System.out.println("Hello del:" + wtw);
						if (wtw.isDisplayed()) {
							click(wtw);
							System.out.println("EXIT APPOIN");
							break;
						}
					}

				} /*
					 * else { WebElement wtw =
					 * driver.findElement(By.xpath("(//span[@id='del-btn'])[1]"));
					 * System.out.println("Hello del:" + wtw); if (wtw.isDisplayed()) { click(wtw);
					 * System.out.println("EXIT APPOIN"); break;
					 * 
					 * } }
					 */
			} catch (Exception e) {

			}
		}

		sleep(2000);
		while (true) {
			try {

				WebElement delappp = driver
						.findElement(By.xpath("//div[@id='AppointmentCreateMessage']/div[2]/div[2]/button[2]"));
				if (delappp.isDisplayed()) {
					visbility(driver, delappp, 60);
					javascriptclick(delappp);
					break;
				}
			} catch (Exception e) {
				System.out.println("");
			}
		}

	}

	public void $dayDrop(String s) throws InterruptedException {
		while (true) {

			try {
				if (s.equals("https://localhost:8443/health/#home")
						|| s.equals("https://www.75health.com/health/#home")) {
					this.s = s;

					WebElement clbtn = driver.findElement(By.xpath("(//button[@id='calendar-day-month'])[2]"));
					cnt = 2;
					System.out.println("HOME Appointment");
					if (clbtn.isDisplayed()) {
						click(clbtn);
					}
				} else if (s.equals("https://localhost:8443/health/#calendar")
						|| s.equals("https://www.75health.com/health/#calendar")) {
					this.s = s;
					System.out.println("Calendar appointmnet");
					WebElement clbtn = driver.findElement(By.xpath("(//button[@id='calendar-day-month'])[1]"));
					cnt = 1;
					if (clbtn.isDisplayed()) {
						click(clbtn);
					}
				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(3000);
		List<WebElement> choose = driver
				.findElements(By.xpath("(//button[@id='calendar-day-month'])[" + cnt + "]//following::ul[1]/li/a"));

		for (WebElement web : choose) {
			if (web.getText().equals("Today") && web.isDisplayed()) {
				click(web);
				break;
			}
		}

	}

}
