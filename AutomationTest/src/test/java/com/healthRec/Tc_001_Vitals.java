package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_001_Vitals extends LaunchBrowser {

	@Test
	public static void tc_002_addVitals_Edit_Save() throws InterruptedException {

		log = Logger.getLogger(Tc_001_Vitals.class);

		while (true) {
			if (pom.getInstanceVitals().getVitalsAddIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceVitals().getVitalsAddIcon, 40);

				clickIntercept(pom.getInstanceVitals().getVitalsAddIcon, 30);
				log.info("vitals add icon clicked");
				break;
			} else if (!pom.getInstanceVitals().getVitalsAddIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceVitals().getVitalsAddIcon);
			}
		}

		visbility(driver, pom.getInstanceVitals().weight, 30);
		sendkeys(pom.getInstanceVitals().weight, "55");
		log.info("weight entered");
		clickIntercept(pom.getInstanceVitals().selectWeightUnit, 30);

		dropDown("text", pom.getInstanceVitals().selectWeightUnit, "kilograms");
		log.info("weight unit selected");
		sendkeys(pom.getInstanceVitals().height, "7'7");
		log.info("height entered");
		clickIntercept(pom.getInstanceVitals().selectHeightUnit, 30);

		dropDown("text", pom.getInstanceVitals().selectHeightUnit, "ft-in");
		log.info("height unit selected");
		elementClickable(pom.getInstanceVitals().saveVitals);
		click(pom.getInstanceVitals().saveVitals);
		log.info("vitals saved");
		try {

			visbility(driver, pom.getInstanceVitals().edit, 40);
			clickIntercept(pom.getInstanceVitals().edit, 30);

			log.info("vitals edit clicked");

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVitals().edit, 40);
			clickIntercept(pom.getInstanceVitals().edit, 30);
			log.info("vitals edit clicked");
		}

		visbility(driver, pom.getInstanceVitals().weight, 40);
		clear(pom.getInstanceVitals().weight);
		log.info("vitals weight cleared");
		sendkeys(pom.getInstanceVitals().weight, "59");
		log.info("vitals weight added");

		clickIntercept(pom.getInstanceVitals().saveVitals, 30);
		log.info("vitals edit and save complete");

	}

	public void $vitalsSalt() {

		actions("click", pom.getInstanceVitals().vitalsSaltIcon);

	}
}
