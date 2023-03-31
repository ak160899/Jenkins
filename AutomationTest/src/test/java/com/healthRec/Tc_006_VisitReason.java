package com.healthRec;

import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjeman.PageObjMan;

public class Tc_006_VisitReason extends LaunchBrowser {

	@Test
	public static void tc_007_addVisitReason_Edit_Save() throws InterruptedException {

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

	public static void favoriteVisitReason() {
		
		while (true) {
			if (pom.getInstanceVistReason().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceVistReason().favoriteIcon, 40);
				clickIntercept(pom.getInstanceVistReason().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceVistReason().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceVistReason().favoriteIcon);
			}

		}

		try {

			visbility(driver, pom.getInstanceVistReason().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceVistReason().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addNewFavorite, 30);

		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
		}

		for (WebElement Element : pom.getInstanceVistReason().selectFavoriteAppointmnetType) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency")) {

				clickIntercept(Element, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceVistReason().favoriteDiscription, 60);
		sendkeys(pom.getInstanceVistReason().favoriteDiscription, "favorite visit reason");
		clickIntercept(pom.getInstanceVistReason().FavoriteSave, 30);
		try {

			visbility(driver, pom.getInstanceVistReason().editFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVistReason().editFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().editFavorite, 30);
		}

		try {

			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
			// System.out.println("ELEMENT CLICKED IN VISIT");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 40);
			clickIntercept(pom.getInstanceCalendar().selectAppointmentType, 30);
		}

		for (WebElement Element : pom.getInstanceVistReason().selectFavoriteAppointmnetType) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency")) {
				visbility(driver, Element, 30);
				clickIntercept(Element, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceVistReason().favoriteDiscription, 30);
		sendkeys(pom.getInstanceVistReason().favoriteDiscription, "favorite visit reason");
		clickIntercept(pom.getInstanceVistReason().FavoriteSave, 30);

		try {

			visbility(driver, pom.getInstanceVistReason().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addThisFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVistReason().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVistReason().addThisFavorite, 30);
		}
		try {
			elementClickable(pom.getInstanceVistReason().closeFavorite);
			clickIntercept(pom.getInstanceVistReason().closeFavorite, 30);
		} catch (ElementClickInterceptedException e) {
			elementClickable(pom.getInstanceVistReason().closeFavorite);
			clickIntercept(pom.getInstanceVistReason().closeFavorite, 30);
		}

	}

}
