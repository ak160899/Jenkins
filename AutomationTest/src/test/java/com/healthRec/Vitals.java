package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import runner.Local_Host;

public class Vitals extends LaunchBrowser {

	static Logger log;

	@Test(priority = -1)
	private void hi() throws InterruptedException {
		Local_Host.PatientModule();

	}

	@Test(priority = 0)
	private void hell() throws InterruptedException {
		if (url.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (url.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (url.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		sleep(3000);
		implicitWait(60, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement remv = driver
						.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
				visbility(driver, remv, 60);

				javascriptclick(remv);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		List<WebElement> wwe;
		while (true) {
			try {
				wwe = driver.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
				break;
			} catch (Exception e) {

			}
		}
		for (WebElement web : wwe) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				clickble(driver, web, 60);

				web.click();
				break;
			}

		}
		sleep(2000);
		try {
			WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
			visbility(driver, r7, 60);
			elementClickable(r7);
			r7.click();

		} catch (ElementClickInterceptedException e) {
			WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
			visbility(driver, r7, 60);
			elementClickable(r7);
			r7.click();
		}

	}

	public static void vitalsFeature() throws InterruptedException {
		log = Logger.getLogger(Vitals.class);

		while (true) {
			if (pom.getInstanceVitals().getVitalsAddIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceVitals().getVitalsAddIcon, 40);
				/*
				 * elementClickable(pom.getInstanceVitals().getVitalsAddIcon);
				 * click(pom.getInstanceVitals().getVitalsAddIcon);
				 */
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
