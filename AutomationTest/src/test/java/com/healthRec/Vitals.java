package com.healthRec;

import org.Launch.LaunchBrowser;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebElement;

public class Vitals extends LaunchBrowser {

	static Logger log;

	public static void vitalsFeature() throws InterruptedException {
		log = Logger.getLogger(Vitals.class);

		visbility(driver, pom.getInstanceVitals().getVitalsAddIcon, 40);
		elementClickable(pom.getInstanceVitals().getVitalsAddIcon);
		click(pom.getInstanceVitals().getVitalsAddIcon);
		log.info("vitals add icon clicked");
		visbility(driver, pom.getInstanceVitals().weight, 30);
		sendkeys(pom.getInstanceVitals().weight, "55");
		log.info("weight entered");
		elementClickable(pom.getInstanceVitals().selectWeightUnit);

		click(pom.getInstanceVitals().selectWeightUnit);

		dropDown("text", pom.getInstanceVitals().selectWeightUnit, "kilograms");
		log.info("weight unit selected");
		sendkeys(pom.getInstanceVitals().height, "7'7");
		log.info("height entered");
		elementClickable(pom.getInstanceVitals().selectHeightUnit);

		click(pom.getInstanceVitals().selectHeightUnit);

		dropDown("text", pom.getInstanceVitals().selectHeightUnit, "ft-in");
		log.info("height unit selected");
		elementClickable(pom.getInstanceVitals().saveVitals);
		click(pom.getInstanceVitals().saveVitals);
		log.info("vitals saved");
		try {
			WebElement edicon = driver.findElement(By.xpath("(//span[text()='55 kilograms'])[1]"));
			visbility(driver, edicon, 40);
			elementClickable(edicon);
			click(edicon);
			log.info("vitals edit clicked");
		} catch (StaleElementReferenceException e) {
			WebElement edicon = driver.findElement(By.xpath("(//span[text()='55 kilograms'])[1]"));
			visbility(driver, edicon, 40);
			elementClickable(edicon);
			click(edicon);
			log.info("vitals edit clicked");
		}

		visbility(driver, pom.getInstanceVitals().weight, 40);
		clear(pom.getInstanceVitals().weight);
		log.info("vitals weight cleared");
		sendkeys(pom.getInstanceVitals().weight, "59");
		log.info("vitals weight added");
		elementClickable(pom.getInstanceVitals().saveVitals);
		click(pom.getInstanceVitals().saveVitals);
		log.info("vitals edit and save complete");

	}

	public void $vitalsSalt() {

		actions("click", pom.getInstanceVitals().vitalsSaltIcon);

	}
}
