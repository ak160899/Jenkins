package org.PageModules;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class TeleDoctor extends LaunchBrowser {

	public static void navigateToTeleDoctor() {
		clickIntercept(pom.getInstanceTeleDoctor().clickTeleDoctor, 30);

	}

	@Test(priority = 1)
	public static void createNewPatient() {
		navigateToTeleDoctor();
		for (int i = 1; i < pom.getInstanceTeleDoctor().createPatientButton.size(); i++) {
			if (pom.getInstanceTeleDoctor().createPatientButton.get(i).isDisplayed()) {
				visbility(driver, pom.getInstanceTeleDoctor().createPatientButton.get(i), 30);
				clickIntercept(pom.getInstanceTeleDoctor().createPatientButton.get(i), 30);
				break;
			}
		}

		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		log.info("first name entered");

		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		log.info("last name entered");

		for (int i = 0; i < pom.getInstanceTeleDoctor().genderButton.size(); i++) {
			if (pom.getInstanceTeleDoctor().genderButton.get(i).isDisplayed()) {
				visbility(driver, pom.getInstanceTeleDoctor().genderButton.get(i), 30);
				clickIntercept(pom.getInstanceTeleDoctor().genderButton.get(i), 30);
				break;
			}
		}

		for (int i = 0; i < pom.getInstanceTeleDoctor().genderDropdown.size(); i++) {
			if (pom.getInstanceTeleDoctor().genderDropdown.get(i).getText().equalsIgnoreCase("Male")
					&& pom.getInstanceTeleDoctor().genderDropdown.get(i).isDisplayed()) {
				visbility(driver, pom.getInstanceTeleDoctor().genderDropdown.get(i), 30);
				clickIntercept(pom.getInstanceTeleDoctor().genderDropdown.get(i), 30);
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		clickIntercept(pom.getInstanceHomeModule().selectFlagPhoneNumField, 30);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				visbility(driver, flag, 30);
				clickIntercept(flag, 30);
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));

		visbility(driver, pom.getInstanceTeleDoctor().createPatient, 60);
		clickIntercept(pom.getInstanceTeleDoctor().createPatient, 30);

		while (true) {
			try {
				WebElement $patietcreateid$ = driver.findElement(By.xpath("//td[@id='val-kpid']"));
				if ($patietcreateid$.isDisplayed()) {
					kpid = $patietcreateid$.getText();
					log.info(kpid);

					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		navigateToTeleDoctor();
		refresh();
		sleep(1500);

	}

	@Test(priority = 2)
	public static void callPatient() {
		navigateToTeleDoctor();
		visbility(driver, pom.getInstanceTeleDoctor().searchPatient, 60);
		sendkeys(pom.getInstanceTeleDoctor().searchPatient, kpid);

		try {
			WebElement pstl = driver.findElement(By.xpath("//td[@id='nameh']//following::td[1]"));
			visbility(driver, pstl, 60);
			clickIntercept(pstl, 30);
		} catch (StaleElementReferenceException e) {
			WebElement pstl = driver.findElement(By.xpath("//td[@id='nameh']//following::td[1]"));
			visbility(driver, pstl, 60);
			clickIntercept(pstl, 30);
		}

		try {
			WebElement clickpatie = driver.findElement(By.xpath("(//div[@title='Click to view'])[5]/div"));

			visbility(driver, clickpatie, 60);
			clickIntercept(clickpatie, 30);
		} catch (StaleElementReferenceException e) {
			WebElement clickpatie = driver.findElement(By.xpath("(//div[@title='Click to view'])[5]/div"));

			visbility(driver, clickpatie, 60);
			clickIntercept(clickpatie, 30);
		}

	}

	public static void callPatientVerfiyOff_Online() {

		for (int i = 1; i < pom.getInstanceTeleDoctor().teleDoctorContactList.size(); i++) {
			boolean check = false;
			if (pom.getInstanceTeleDoctor().teleDoctorContactList.get(i).isDisplayed()) {

				List<WebElement> listOfContact = driver
						.findElements(By.xpath("(//div[@id='listTableBody'])[" + i + "]/div"));
				System.out.println(listOfContact);

				for (int j = 1; j < listOfContact.size(); j++) {

					WebElement verifyThePatientAvalaibilty = driver.findElement(By
							.xpath("(//div[@id='listTableBody'])[" + i + "]/div[" + j + "]/div/table/tbody/tr/td[3]"));
					System.out.println(verifyThePatientAvalaibilty.getText());
					if (verifyThePatientAvalaibilty.getText().equalsIgnoreCase(kpid)
							&& verifyThePatientAvalaibilty.isDisplayed()) {
						visbility(driver, verifyThePatientAvalaibilty, 30);
						clickIntercept(verifyThePatientAvalaibilty, 30);
						System.out.println("CLICKED TO VIEW TELE CALL");
						check = true;
						break;
					}

				}
				if (check == true) {
					break;
				}
			}
		}

	}

}
