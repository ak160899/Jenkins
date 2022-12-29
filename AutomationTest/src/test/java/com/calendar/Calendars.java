package com.calendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.base.*;
import com.pageObjeman.PageObjMan;

public class Calendars extends Base {

	WebDriver driver;
	PageObjMan pom;
	String kpid;
	String s;
	public int cnt;

	public Calendars(WebDriver driver, PageObjMan pm) {

		this.driver = driver;
		pom = pm;

	}

	public void caledarModule() throws Exception {

		/*
		 * if (cal.driver != null) { // System.out.println("Driver not null"); } else {
		 * System.out.println("null"); }
		 */
		for (int i = 1; i <= 7; i++) {
			try {
				if (pom.getInstanceCalendar().clickCalendar.isDisplayed()) {
					click(pom.getInstanceCalendar().clickCalendar);
					break;
				}
			} catch (Exception e) {
				// System.out.println(e);
			}

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
			int count = 1;
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
					if (count > 1) {
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
				$delAppointmentSchedule(i, cnt);
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
				// TODO: handle exception
			}
		}

	}

	public void $choosePatient(int i, String id) {

		WebElement prp = driver.findElement(By.xpath("(//input[@id='AppointmentPatientName'])[" + i + "]"));
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

		sleep(1000);

		WebElement ez = driver.findElement(By.xpath("//span[text()='" + kpid + "']"));
		visbility(driver, ez, 60);
		javascriptclick(ez);

		sleep(2000);
		// goto ehr..
		WebElement ehr = driver.findElement(By.xpath("(//button[@id='cancel-btn1'])[1]"));
		visbility(driver, ehr, 60);
		click(ehr);// .click();

		sleep(3000);

		while (true) {
			try {
				if (ss.equals("https://localhost:8443/health/#home")) {
					driver.navigate().back();
					driver.navigate().refresh();
					break;
				}
				click(pom.getInstanceCalendar().clickCalendar);
				driver.navigate().refresh();
				break;
			} catch (Exception e) {
				// TODO: handle exception
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

	public void $delAppointmentSchedule(int i, int c) throws InterruptedException {

		System.out.println("ENTER DEL APP");

		List<WebElement> $deletepaitentAppoint;
		while (true) {
			boolean b = false;
			try {
				// (//span[text()='" + kpid + "'])
				$deletepaitentAppoint = driver.findElements(By.xpath("//span[@id='kpId']"));

				for (WebElement web : $deletepaitentAppoint) {
					System.out.println(web.getText());

					if (web.getText().equals(kpid)) {
						b = true;
						click(web);
						break;

					}

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			if (b == false) {

				$nextsetOfDays(c);
				System.out.println("DONE");
				// $delAppointmentSchedule(i);
				System.out.println("EXIT HERE");

			} else if (b == true) {
				System.out.println("TRUE...");
				break;
			}
		}

		for (int in = 1; in <= 7; in++) {
			try {
				if (s.equals("https://localhost:8443/health/#home")) {

					WebElement wtw = driver.findElement(By.xpath("(//span[@id='del-btn'])[1]"));
					System.out.println("Hello del:" + wtw);
					if (wtw.isDisplayed()) {
						click(wtw);
						System.out.println("EXIT APPOIN");
						break;
					}

				} else {
					WebElement wtw = driver.findElement(By.xpath("(//span[@id='del-btn'])[1]"));
					System.out.println("Hello del:" + wtw);
					if (wtw.isDisplayed()) {
						click(wtw);
						System.out.println("EXIT APPOIN");

					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		WebElement delappp = driver
				.findElement(By.xpath("//div[@id='AppointmentCreateMessage']/div[2]/div[2]/button[2]"));
		visbility(driver, delappp, 60);
		javascriptclick(delappp);

	}

	public void $dayDrop(String s) throws InterruptedException {
		while (true) {

			try {
				if (s.equals("https://localhost:8443/health/#home")) {
					this.s = s;

					WebElement clbtn = driver.findElement(By.xpath("(//button[@id='calendar-day-month'])[2]"));
					cnt = 2;
					if (clbtn.isDisplayed()) {
						click(clbtn);
					}
				} else if (s.equals("https://localhost:8443/health/#calendar")) {
					this.s = s;
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
