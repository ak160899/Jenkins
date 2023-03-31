package org.SmokeTesting;

import java.lang.reflect.Method;
import java.util.List;

import org.Launch.LaunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Home_Module extends LaunchBrowser {

	@Test(priority = 0)
	public void patientCreation(Method m) {

		try {
			clickIntercept(pom.getInstanceHomeModule().$patientCreationButton, 30);
			extentTest.info("NEW PATIENT CREATION BUTTON CLICKED");
		} catch (Exception e) {
			click(pom.getInstanceHomeModule().$patientCreationButton);

		}

		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		log.info("first name entered");
		extentTest.log(Status.INFO, "FIRST NAME ENTERED");
		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		log.info("last name entered");
		extentTest.log(Status.INFO, "LAST NAME ENTERED");
		clickIntercept(pom.getInstanceNewPatient().clickGenderIcon, 30);
		log.info("gender clicked");
		extentTest.log(Status.INFO, "GENDER CLICKED");
		List<WebElement> genders = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));

		for (WebElement opt : genders) {

			if (opt.getText().equals("Male")) {

				driver.findElement(By.xpath("(//ul[@id='genderDropdown'])[1]/li")).click();
				log.info("gender Choosed");
				extentTest.log(Status.INFO, "GENDER CHOOSED:" + opt.getText());

			}
			break;
		}

		// String character = RandomStringUtils.randomAlphabetic(12);

		visbility(driver, pom.getInstanceHomeModule().emailId, 40);
		sendkeys(pom.getInstanceHomeModule().emailId, generateRandom("letter"));
		log.info("email id entered");
		extentTest.log(Status.INFO, "EMAIL ENTERED");
		visbility(driver, pom.getInstanceHomeModule().selectFlagPhoneNumField, 50);
		elementClickable(pom.getInstanceHomeModule().selectFlagPhoneNumField);
		clickIntercept(pom.getInstanceHomeModule().selectFlagPhoneNumField, 30);

		for (WebElement flag : pom.getInstanceHomeModule().chooseCountrycodeFlag) {
			if (flag.getText().trim().equals("+91")) {
				clickIntercept(flag, 30);
				extentTest.log(Status.INFO, "COUNTRY CODE CHOOSED: " + flag.getText());
				break;
			}
		}

		visbility(driver, pom.getInstanceHomeModule().phoneNumberField, 40);
		sendkeys(pom.getInstanceHomeModule().phoneNumberField, "95518" + generateRandom("number"));
		log.info("phone number entered");
		extentTest.log(Status.INFO, "PHONE NUMBER ENTERED");
		// Acc gets Created..
		clickIntercept(pom.getInstanceNewPatient().CreatePatient, 30);
		log.info("patient created ");
		extentTest.log(Status.INFO, "CREATE PATIENT CLICKED");

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

		navigateback(2);

	}

	@Test(priority = 1)
	public void bookAppointment() throws Throwable {

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		cal.$calenderMod($current, kpid);
		log.info("Appointment booked and deleted");

	}

	

}
