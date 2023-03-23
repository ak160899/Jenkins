package com.calendar;

import org.Launch.LaunchBrowser;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;

public class PatientCreation extends LaunchBrowser {

	public static String createPat() {
visbility(driver, pom.getInstanceCalendar().newPatientCreation, 30);
System.out.println("ENTER");
		clickIntercept(pom.getInstanceCalendar().newPatientCreation, 30);
		visbility(driver, pom.getInstanceHomeModule().firstName, 30);
		sendkeys(pom.getInstanceHomeModule().firstName, "Kaaspro");
		visbility(driver, pom.getInstanceHomeModule().lastname, 30);
		sendkeys(pom.getInstanceHomeModule().lastname, "Enterprise");
		clickIntercept(pom.getInstanceCalendar().genderClick, 30);
		for (WebElement elem : pom.getInstanceCalendar().chooseGender) {

			if (elem.getText().trim().equals("Male")) {
				visbility(driver, elem, 30);
				clickIntercept(elem, 30);
				break;

			}
		}

		visbility(driver, pom.getInstanceHomeModule().emailId, 30);
		String rand = RandomStringUtils.randomAlphabetic(30);
		sendkeys(pom.getInstanceHomeModule().emailId, rand + "@gmail.com");

		clickIntercept(pom.getInstanceCalendar().createPaitent, 30);

		kpid = pom.getInstanceCalendar().getPatientid.getAttribute("value");

		return kpid;
	}

}
