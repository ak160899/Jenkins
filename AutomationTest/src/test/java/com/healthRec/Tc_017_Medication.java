package com.healthRec;

import org.Launch.LaunchBrowser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Tc_017_Medication extends LaunchBrowser {

	@Test
	public static void addMedication_Edit_Save() throws Throwable {

		while (true) {

			if (pom.getInstanceMedication().addIcon.isDisplayed()) {

				actions("moe to element", pom.getInstanceMedication().addIcon);
				clickIntercept(pom.getInstanceMedication().addIcon, 30);
				break;

			} else if (!pom.getInstanceMedication().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceMedication().addIcon);
				sleep(1500);
			}
		}

		sleep(2000);

		sendkeys(pom.getInstanceMedication().drugName, "tata");
		sendkeys(pom.getInstanceMedication().strenghth, "str");
		sendkeys(pom.getInstanceMedication().quantity, "1");
		sendkeys(pom.getInstanceMedication().direction, "q1");

		for (WebElement web : pom.getInstanceMedication().directionDropDown) {
			if (web.getText().trim().equals("q12h - Every twelve hours")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}

		clickIntercept(pom.getInstanceMedication().save, 30);

		for (WebElement save : pom.getInstanceMedication().saveDropdown) {

			if (save.getText().trim().equals("Save")) {
				visbility(driver, save, 60);
				clickIntercept(save, 30);
				break;
			}

		}

		sleep(3000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			visbility(driver, pom.getInstanceMedication().edit, 30);
			clickIntercept(pom.getInstanceMedication().edit, 30);
			sleep(2000);
			visbility(driver, pom.getInstanceMedication().removeMedication, 30);

			clickIntercept(pom.getInstanceMedication().removeMedication, 30);

			sleep(2000);
			sendkeys(pom.getInstanceMedication().drugName, "1009");

			while (true) {
				try {

					if (pom.getInstanceMedication().icdlist.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (WebElement med : pom.getInstanceMedication().icdlist) {
				// System.out.println(med.getText());
				if (med.getText().trim().equals("RXNORM : 1009145")) {

					visbility(driver, med, 60);
					javascriptclick(med);
					break;

				}

			}

			sendkeys(pom.getInstanceMedication().quantity, "1");
			sendkeys(pom.getInstanceMedication().direction, "12");

			for (WebElement web : pom.getInstanceMedication().directionDropDown) {
				if (web.getText().trim().equals("q12h - Every twelve hours")) {
					visbility(driver, web, 60);
					web.click();
					break;
				}

			}

			clickIntercept(pom.getInstanceMedication().save, 30);

			for (WebElement save : pom.getInstanceMedication().saveDropdown) {

				if (save.getText().trim().equals("Save")) {
					visbility(driver, save, 60);
					clickIntercept(save, 30);
					break;
				}

			}
			sleep(3000);
		}

	}

	public static void $getPastMedication() throws InterruptedException {
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {
				visbility(driver, pom.getInstanceMedication().clickTocure, 30);
				clickIntercept(pom.getInstanceMedication().clickTocure, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceMedication().clickTocure, 30);
				clickIntercept(pom.getInstanceMedication().clickTocure, 30);
			}
		} else {
			try {
				for (int i = 0; i < pom.getInstanceMedication().clickTocureBasic.size(); i++) {
					if (pom.getInstanceMedication().clickTocureBasic.get(i).isDisplayed()) {

						visbility(driver, pom.getInstanceMedication().clickTocureBasic.get(i), 30);
						clickIntercept(pom.getInstanceMedication().clickTocureBasic.get(i), 30);
						break;
					}
				}
			} catch (Exception e) {
				for (int i = 0; i < pom.getInstanceMedication().clickTocureBasic.size(); i++) {
					if (pom.getInstanceMedication().clickTocureBasic.get(i).isDisplayed()) {

						visbility(driver, pom.getInstanceMedication().clickTocureBasic.get(i), 30);
						clickIntercept(pom.getInstanceMedication().clickTocureBasic.get(i), 30);
						break;
					}
				}
			}
		}

		for (int i = 0; i < pom.getInstanceSymptom().yesCureBasic.size(); i++) {
			if (pom.getInstanceSymptom().yesCureBasic.get(i).isDisplayed()) {
				visbility(driver, pom.getInstanceSymptom().yesCureBasic.get(i), 30);
				clickIntercept(pom.getInstanceSymptom().yesCureBasic.get(i), 30);
				break;
			}
		}

		sleep(1000);

		while (true) {

			if (pom.getInstanceMedication().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceMedication().ellipses, 30);
				actions("move to element", pom.getInstanceMedication().ellipses);
				clickIntercept(pom.getInstanceMedication().ellipses, 30);
				break;

			} else if (!pom.getInstanceMedication().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceMedication().ellipses);
			}
		}

		for (WebElement web : pom.getInstanceMedication().clickPastEndedFromEllipses) {

			if (web.getText().trim().equals("Past Ended Medication")) {
				visbility(driver, web, 20);
				clickIntercept(web, 30);
				break;
			}

		}
		sleep(1500);

		try {
			visbility(driver, pom.getInstanceMedication().addPastMedicationToEhr, 30);
			clickIntercept(pom.getInstanceMedication().addPastMedicationToEhr, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceMedication().addPastMedicationToEhr, 30);
			clickIntercept(pom.getInstanceMedication().addPastMedicationToEhr, 30);
		}

		sleep(1500);

		visbility(driver, pom.getInstanceMedication().closePastWinow, 30);
		clickIntercept(pom.getInstanceMedication().closePastWinow, 30);

	}
}
