package com.healthRec;

import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class VisitReason extends LaunchBrowser {

	public static void visit() throws InterruptedException {

		implicitWait(60, TimeUnit.SECONDS);

		while (true) {
			if (pom.getInstanceVistReason().AddIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceVistReason().AddIcon, 40);
				clickIntercept(pom.getInstanceVistReason().AddIcon, 30);
				break;
			} else {
				if (!pom.getInstanceVistReason().AddIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceVistReason().AddIcon);

				}
			}
		}

		try {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 60);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 60);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
		}

		for (WebElement chooseAppType : pom.getInstanceVistReason().appointmentTypeDropDown) {
			if (chooseAppType.getText().equals("Emergency") && chooseAppType.isDisplayed()) {
				clickIntercept(chooseAppType, 30);
				break;
			}
		}

		visbility(driver, pom.getInstanceVistReason().discription, 30);
		sendkeys(pom.getInstanceVistReason().discription, "cold");
		clickIntercept(pom.getInstanceVistReason().save, 30);
		sleep(2000);
		try {
			visbility(driver, pom.getInstanceVistReason().edit, 30);
			clickIntercept(pom.getInstanceVistReason().edit, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVistReason().edit, 30);
			clickIntercept(pom.getInstanceVistReason().edit, 30);

		}

		visbility(driver, pom.getInstanceVistReason().discription, 30);
		clear(pom.getInstanceVistReason().discription);
		sendkeys(pom.getInstanceVistReason().discription, "Kaaspro");

		elementClickable(pom.getInstanceVistReason().discription);
		click(pom.getInstanceVistReason().discription);

		clickIntercept(pom.getInstanceVistReason().save, 30);

	}

}
