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
				elementClickable(pom.getInstanceVistReason().AddIcon);
				click(pom.getInstanceVistReason().AddIcon);
				break;
			} else {
				if (!pom.getInstanceVistReason().AddIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceVistReason().AddIcon);

				}
			}
		}

		try {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 60);
			click(pom.getInstanceCalendar().selectAppointmentType);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 60);
			click(pom.getInstanceCalendar().selectAppointmentType);
		}

		for (WebElement chooseAppType : pom.getInstanceVistReason().appointmentTypeDropDown) {
			if (chooseAppType.getText().equals("Emergency") && chooseAppType.isDisplayed()) {
				click(chooseAppType);
				break;
			}
		}

		visbility(driver, pom.getInstanceVistReason().discription, 30);
		sendkeys(pom.getInstanceVistReason().discription, "cold");

		elementClickable(pom.getInstanceVistReason().save);
		click(pom.getInstanceVistReason().save);
		WebElement edit;
		try {
			visbility(driver, pom.getInstanceVistReason().edit, 30);
			elementClickable(pom.getInstanceVistReason().edit);
			click(pom.getInstanceVistReason().edit);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVistReason().edit, 30);
			elementClickable(pom.getInstanceVistReason().edit);
			click(pom.getInstanceVistReason().edit);

		}

		visbility(driver, pom.getInstanceVistReason().discription, 30);
		clear(pom.getInstanceVistReason().discription);
		sendkeys(pom.getInstanceVistReason().discription, "Kaaspro");

		elementClickable(pom.getInstanceVistReason().discription);
		click(pom.getInstanceVistReason().discription);

		elementClickable(pom.getInstanceVistReason().save);
		click(pom.getInstanceVistReason().save);

	}

}
