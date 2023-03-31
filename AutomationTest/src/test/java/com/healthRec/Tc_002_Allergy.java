package com.healthRec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.Launch.LaunchBrowser;
import org.base.*;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Tc_002_Allergy extends LaunchBrowser {

	@Test
	public static void tc_003_addAllergy_Edit_Save() throws Exception {

		while (true) {
			if (pom.getInstanceAllerygy().addIcon.isDisplayed()) {

				visbility(driver, pom.getInstanceAllerygy().addIcon, 30);

				clickIntercept(pom.getInstanceAllerygy().addIcon, 30);
				break;
			} else {
				if (!pom.getInstanceAllerygy().addIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceAllerygy().addIcon);
				}
			}
		}

		visbility(driver, pom.getInstanceAllerygy().selectAllergyType, 30);

		clickIntercept(pom.getInstanceAllerygy().selectAllergyType, 30);
		dropDown("text", pom.getInstanceAllerygy().selectAllergyType, "Food Allergy");
		visbility(driver, pom.getInstanceAllerygy().allergenDiscription, 30);
		sendkeys(pom.getInstanceAllerygy().allergenDiscription, "food1");

		visbility(driver, pom.getInstanceAllerygy().reactionDiscription, 30);
		sendkeys(pom.getInstanceAllerygy().reactionDiscription, "stomach pain");

		clickIntercept(pom.getInstanceAllerygy().more, 30);

		for (WebElement w : pom.getInstanceAllerygy().chooseFromDropdown) {
			if (w.getText().trim().equals("Show Severity")) {
				clickIntercept(w, 30);
				break;
			}

		}

		clickIntercept(pom.getInstanceAllerygy().more, 30);

		for (WebElement w : pom.getInstanceAllerygy().chooseFromDropdown) {
			if (w.getText().trim().equals("Show Status")) {
				visbility(driver, w, 30);
				clickIntercept(w, 30);

				break;
			}

		}

		visbility(driver, pom.getInstanceAllerygy().severityDiscription, 30);

		dropDown("text", pom.getInstanceAllerygy().severityDiscription, "Mild");

		visbility(driver, pom.getInstanceAllerygy().statusDiscription, 30);

		dropDown("text", pom.getInstanceAllerygy().statusDiscription, "Inactive");

		clickIntercept(pom.getInstanceAllerygy().saveButton, 30);

		for (WebElement w : pom.getInstanceAllerygy().saveDropdown) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 30);
				clickIntercept(w, 30);
				break;
			}

		}
		try {
			WebElement edit = driver.findElement(By.xpath("//span[text()='food1']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);
		} catch (StaleElementReferenceException e) {
			WebElement edit = driver.findElement(By.xpath("//span[text()='food1']"));

			clickIntercept(edit, 30);
		}

		visbility(driver, pom.getInstanceAllerygy().allergenDiscription, 40);
		clear(pom.getInstanceAllerygy().allergenDiscription);
		sendkeys(pom.getInstanceAllerygy().allergenDiscription, "st");
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			WebElement scq = driver.findElement(By.xpath("//div[text()='Strawberry ']"));
			visbility(driver, scq, 60);

			clickIntercept(scq, 30);
		}

		clickIntercept(pom.getInstanceAllerygy().saveButton, 30);

		for (WebElement w : pom.getInstanceAllerygy().saveDropdown) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);

				clickIntercept(w, 30);
				break;
			}

		}
	}

}
