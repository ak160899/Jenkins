package com.healthRec;

import org.Launch.LaunchBrowser;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Tc_022_Inpatient extends LaunchBrowser {

	@Test
	public static void addInpatient_Edit_Save() throws Throwable {
		while (true) {
			if (pom.getInstanceInpatient().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceInpatient().addIcon, 30);
				clickIntercept(pom.getInstanceInpatient().addIcon, 30);
				break;
			} else if (!pom.getInstanceInpatient().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceInpatient().addIcon);
			}
		}

		visbility(driver, pom.getInstanceInpatient().selectMonth, 40);
		dropDown("index", pom.getInstanceInpatient().selectMonth, "08");
		visbility(driver, pom.getInstanceInpatient().selectYear, 40);
		dropDown("text", pom.getInstanceInpatient().selectYear, "2022");

		visbility(driver, pom.getInstanceInpatient().chooseDate, 30);
		clickIntercept(pom.getInstanceInpatient().chooseDate, 30);

		sleep(2000);
		clickIntercept(pom.getInstanceInpatient().dischargeIdField, 30);

		visbility(driver, pom.getInstanceInpatient().selectMonth, 40);
		dropDown("index", pom.getInstanceInpatient().selectMonth, "10");
		visbility(driver, pom.getInstanceInpatient().selectYear, 40);
		dropDown("text", pom.getInstanceInpatient().selectYear, "2022");
		visbility(driver, pom.getInstanceInpatient().chooseDate, 30);
		clickIntercept(pom.getInstanceInpatient().chooseDate, 30);

		visbility(driver, pom.getInstanceInpatient().selectType, 40);
		dropDown("text", pom.getInstanceInpatient().selectType, "Urgent");
		visbility(driver, pom.getInstanceInpatient().roomNo, 30);
		sendkeys(pom.getInstanceInpatient().roomNo, "777");
		visbility(driver, pom.getInstanceInpatient().discharge, 30);
		sendkeys(pom.getInstanceInpatient().discharge, "okay");
		clickIntercept(pom.getInstanceInpatient().save, 30);

	}

}
