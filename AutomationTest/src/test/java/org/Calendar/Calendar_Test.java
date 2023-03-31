package org.Calendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Calendar_Test extends LaunchBrowser {

	// public static List<WebElement> numberOfTimeSlotDisplayed;

	public static void navigateToCalendar() {
		if (driver.getCurrentUrl().contains("calendar")) {

			try {
				visbility(driver, pom.getInstanceCalendar().clickCalendar, 50);
				clickIntercept(pom.getInstanceCalendar().clickCalendar, 30);

			} catch (StaleElementReferenceException e) {
				visbility(driver, pom.getInstanceCalendar().clickCalendar, 50);
				clickIntercept(pom.getInstanceCalendar().clickCalendar, 30);
			}
			implicitWait(60, TimeUnit.SECONDS);

			driver.navigate().refresh();

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		}

	}

	@Test
	public static void bookAppointment() {
		navigateToCalendar();

		boolean slotResult = false;
		sleep(2000);
		doctorUserNotWorking();

		for (int i = 0; i < pom.getInstanceCalendar().numberOfTimeSlotDisplayed.size(); i++) {
			System.out.println("ENTER LOOP");
			System.out.println(pom.getInstanceCalendar().numberOfTimeSlotDisplayed.size());

			if (pom.getInstanceCalendar().numberOfTimeSlotDisplayed.get(i).isDisplayed()
					&& pom.getInstanceCalendar().statusType.get(i).getText().isEmpty()) {
				slotResult = true;
				System.out.println(pom.getInstanceCalendar().numberOfTimeSlotDisplayed.get(i).getText());
				clickIntercept(pom.getInstanceCalendar().numberOfTimeSlotDisplayed.get(i), 30);

				passValueToSearchField();
				List<WebElement> choosepatient = driver.findElements(By.xpath(
						"//div[@id='AppointmentMessage']/div[2]//following::ul[6]/li/a/table[1]/tbody/tr/td[2]"));

				for (WebElement web : choosepatient) {
					System.out.println(web.getText());
					if (web.getText().trim().equals(kpid)) {
						visbility(driver, web, 60);
						clickIntercept(web, 30);
						System.out.println("clicked kpid");
						break;
					}

				}
				clickAppoiynmentType();
				passDiscription();
				clickStatus();
				selectStatus();
				clickAccept();
				System.out.println("APPOINMENT SAVED");
				editAppointment();

				WebElement ehr = driver.findElement(By.id("goEhrButton"));

				visbility(driver, ehr, 60);
				clickIntercept(ehr, 30);

				WebElement backToPre = driver.findElement(By.xpath("//button[@onclick=' window.history.back();']"));
				visbility(driver, backToPre, 40);
				clickIntercept(backToPre, 30);
				editAppointment();
				deleteAppintment();
				break;

			}
		}

		if (slotResult == false) {
			nextDays();
			bookAppointment();

		}

	}

	public static void nextDays() {

		if (driver.getCurrentUrl().equals("https://www.75health.com/health/#home")) {
			List<WebElement> hmNextSetDay = driver.findElements(By.cssSelector("div#rightbox"));
			for (int i = 1; i < hmNextSetDay.size(); i++) {

				if (hmNextSetDay.get(i).isDisplayed()) {
					clickIntercept(hmNextSetDay.get(i), 30);
					break;
				}
			}

		} else {
			WebElement nextDay = driver.findElement(By.cssSelector("div#rightbox"));
			clickIntercept(nextDay, 30);
		}

	}

	public static void clickAppoiynmentType() {
		List<WebElement> appointmentType = driver.findElements(By.cssSelector("button#admissionVal_dropdown"));

		for (int i = 1; i < pom.getInstanceCalendar().numberOfTimeSlotDisplayed.size() - 1; i++) {
			if (appointmentType.get(i).isDisplayed()) {
				clickIntercept(appointmentType.get(i), 30);
				chooseApointmentType();
				break;
			}

		}

	}

	public static void chooseApointmentType() {

		List<WebElement> appointmentType = driver.findElements(By.cssSelector("ul#admissionValDropdown li a"));
		for (int i = 1; i < pom.getInstanceCalendar().numberOfTimeSlotDisplayed.size(); i++) {

			if (appointmentType.get(i).isDisplayed() && appointmentType.get(i).getText().equals("Emergency")) {

				clickIntercept(appointmentType.get(i), 30);
				break;
			}

		}

	}

	public static void passValueToSearchField() {
		List<WebElement> serachField = driver.findElements(By.cssSelector("input#AppointmentPatientName"));

		for (int i = 1; i < pom.getInstanceCalendar().numberOfTimeSlotDisplayed.size(); i++) {

			if (serachField.get(i).isDisplayed()) {
				sendkeys(serachField.get(i), kpid);
				break;
			}

		}

	}

	public static void passDiscription() {

		List<WebElement> discription = driver.findElements(By.cssSelector("textarea#description"));

		for (int i = 1; i < discription.size(); i++) {

			if (discription.get(i).isDisplayed()) {
				// System.out.println("DIS:" + i);
				sendkeys(discription.get(i), "no worries...");
				break;
			}
		}

	}

	public static void clickStatus() {
		List<WebElement> statusType = driver.findElements(By.cssSelector("button#statusId_dropdown"));
		for (int i = 1; i < statusType.size(); i++) {
			if (statusType.get(i).isDisplayed()) {
				clickIntercept(statusType.get(i), 30);
				break;
			}

		}

	}

	public static void selectStatus() {

		List<WebElement> selectState = driver.findElements(By.cssSelector("ul#statusIdDropdown li a"));
		for (int b = 1; b < selectState.size(); b++) {

			if (selectState.get(b).isDisplayed() && selectState.get(b).getText().trim().equals("In Progress")) {

				clickIntercept(selectState.get(b), 30);
				break;
			}
		}

	}

	public static void clickAccept() {

		WebElement vcv = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		visbility(driver, vcv, 60);
		clickIntercept(vcv, 30);
	}

	public static void editAppointment() {

		sleep(3000);
		try {
			List<WebElement> edit = driver.findElements(By.cssSelector("span#kpId"));
			System.out.println("edit size:" + edit.size());
			for (int i = 0; i < edit.size(); i++) {
				System.out.println(edit.get(i).getText());
				if (edit.get(i).getText().equals(kpid)) {

					visbility(driver, edit.get(i), 30);
					clickIntercept(edit.get(i), 30);
					System.out.println("EDIT THE APPOINTMENT");
					break;
				}

			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> edit = driver.findElements(By.cssSelector("span#kpId"));

			for (int i = 1; i < edit.size(); i++) {

				if (edit.get(i).getText().equals(kpid)) {

					visbility(driver, edit.get(i), 30);
					clickIntercept(edit.get(i), 30);
					System.out.println("EDIT THE APPOINTMENT");
					break;
				}

			}

		}
	}

	public static void deleteAppintment() {

		try {
			List<WebElement> delete = driver.findElements(By.cssSelector("span#del-btn"));
			for (int b = 1; b < delete.size(); b++) {

				if (delete.get(b).isDisplayed()) {
					clickIntercept(delete.get(b), 30);
					System.out.println("DELETED");
					break;
				}
			}

		} catch (StaleElementReferenceException e) {
			List<WebElement> delete = driver.findElements(By.cssSelector("span#del-btn"));
			for (int b = 1; b < delete.size(); b++) {

				if (delete.get(b).isDisplayed()) {
					clickIntercept(delete.get(b), 30);
					break;
				}
			}

		}

		List<WebElement> confirmKpop = driver.findElements(By.cssSelector("button#accept-btn"));
		for (int c = 1; c < confirmKpop.size(); c++) {
			if (confirmKpop.get(c).isDisplayed()) {
				clickIntercept(confirmKpop.get(c), 30);
				break;
			}
		}

	}

	public static void doctorUserNotWorking() {
		boolean status = false;
		System.out.println("Dr user Not working");
		List<WebElement> checkUserStatus = driver.findElements(By.cssSelector(".msg.alert.alert-info"));
		System.out.println(checkUserStatus.size());

		for (int i = 0; i < checkUserStatus.size(); i++) {

			if (checkUserStatus.get(i).isDisplayed()) {
				System.out.println("USER ENTER TO OPEN WORKING STATUS");
				status = true;
				break;

			}

		}

		if (status == true) {

			List<WebElement> setDoctorUserSchedule = driver.findElements(By.cssSelector("span#editCalendar"));
			for (int i = 0; i < setDoctorUserSchedule.size(); i++) {
				if (setDoctorUserSchedule.get(i).isDisplayed()) {
					clickIntercept(setDoctorUserSchedule.get(i+1), 30);
					break;
				}
			}
		}

	}

}
