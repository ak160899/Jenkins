package com.healthRec;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.Launch.LaunchBrowser;

public class Tc_009_Amendment extends LaunchBrowser {

	@Test
	public static void tc_010_addAmendent_Edit_Save() throws Throwable {
		while (true) {

			if (pom.getInstanceAmendment().addIcon.isDisplayed()) {

				visbility(driver, pom.getInstanceAmendment().addIcon, 30);
				clickIntercept(pom.getInstanceAmendment().addIcon, 30);
				break;
			} else if (!pom.getInstanceAmendment().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAmendment().addIcon);
			}

		}

		visbility(driver, pom.getInstanceAmendment().selectSource, 30);
		dropDown("text", pom.getInstanceAmendment().selectSource, "Patient");
		visbility(driver, pom.getInstanceAmendment().discription, 30);
		sendkeys(pom.getInstanceAmendment().discription, "Akash");

		visbility(driver, pom.getInstanceAmendment().selectStatus, 30);
		dropDown("text", pom.getInstanceAmendment().selectStatus, "Accept");
		visbility(driver, pom.getInstanceAmendment().reasonDiscription, 30);
		sendkeys(pom.getInstanceAmendment().reasonDiscription, "whats up...");

		clickIntercept(pom.getInstanceAmendment().save, 30);

		try {
			WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
			visbility(driver, ac, 60);
			clickIntercept(ac, 30);
		} catch (StaleElementReferenceException e) {
			WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
			visbility(driver, ac, 60);
			clickIntercept(ac, 30);
		}

		visbility(driver, pom.getInstanceAmendment().reasonDiscription, 30);
		clear(pom.getInstanceAmendment().reasonDiscription);
		sendkeys(pom.getInstanceAmendment().reasonDiscription, "warrior");
		clickIntercept(pom.getInstanceAmendment().save, 30);
	}

}
