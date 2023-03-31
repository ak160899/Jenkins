package com.healthRec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.Launch.LaunchBrowser;
import org.base.*;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Tc_004_FamilyHealth extends LaunchBrowser {

	@Test
	public static void tc_005_addFamilyHealth_Edit_Save() {
		while (true) {
			if (pom.getInstanceFamilyHaelth().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceFamilyHaelth().addIcon, 30);

				clickIntercept(pom.getInstanceFamilyHaelth().addIcon, 30);
				break;
			} else {
				if (!pom.getInstanceFamilyHaelth().addIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceFamilyHaelth().addIcon);
				}
			}

		}
		visbility(driver, pom.getInstanceFamilyHaelth().selectFHType, 30);

		dropDown("text", pom.getInstanceFamilyHaelth().selectFHType, "Half Brother");

		visbility(driver, pom.getInstanceFamilyHaelth().icdDiscriptionbox, 30);
		sendkeys(pom.getInstanceFamilyHaelth().icdDiscriptionbox, "2478100");

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			Tc_004_FamilyHealth.familyHealthIcd();
		}
		clickIntercept(pom.getInstanceFamilyHaelth().save, 30);

		for (WebElement w : pom.getInstanceFamilyHaelth().saveDropdown) {

			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);

				break;
			}

		}

		sleep(3000);

	}

	public static void familyHealthIcd() {
		boolean check = false;

		try {

			if (pom.getInstanceFamilyHaelth().icdDropdown.size() <= 2) {
				System.out.println(">=2 " + pom.getInstanceFamilyHaelth().icdDropdown.size());
				check = true;

			}
		} catch (Exception e) {

		}

		// System.out.println("exit fh");

		if (check == true) {
			for (WebElement web : pom.getInstanceFamilyHaelth().icdDropdown) {
				System.out.println("ENTER");
				System.out.println(web.getText());
				if (web.getText().equals("ICD10 : F40.2 | SNOMED : 247810008") && web.isDisplayed()) {
					visbility(driver, web, 60);
					clickIntercept(web, 30);
					System.out.println("FAMILY HEALTH ");
					check = true;
					break;
				}

			}
		}
		if (check == false) {
			familyHealthIcd();
		}

	}

}
