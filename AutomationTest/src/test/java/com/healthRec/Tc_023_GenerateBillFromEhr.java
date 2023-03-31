package com.healthRec;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tc_023_GenerateBillFromEhr extends LaunchBrowser {

	@Test
	public static void verifyTheGenerteBill() {
		visbility(driver, pom.getInstanceHealthRec().generateBill, 30);
		clickIntercept(pom.getInstanceHealthRec().generateBill, 30);

		for (WebElement we : pom.getInstanceHealthRec().genratebillDropdown) {
			if (we.getText().trim().equals("Generate Bill from EHR")) {
				visbility(driver, we, 60);
				clickIntercept(we, 30);
				break;
			}

		}
		sleep(4000);

		sleep(3000);
		if (url.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (url.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (url.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		visbility(driver, pom.getInstanceHealthRec().clickAddIconHealthRec, 30);
		clickIntercept(pom.getInstanceHealthRec().clickAddIconHealthRec, 30);

	}

}
