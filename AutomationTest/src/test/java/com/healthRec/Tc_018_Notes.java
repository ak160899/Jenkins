package com.healthRec;

import org.Launch.LaunchBrowser;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Tc_018_Notes extends LaunchBrowser {

	@Test
	public static void addNotes_Edit_Save() throws Throwable {
		while (true) {
			if (pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceNotes().favoriteIcon, 40);
				clickIntercept(pom.getInstanceNotes().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceNotes().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			clickIntercept(pom.getInstanceNotes().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			clickIntercept(pom.getInstanceNotes().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
		sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes module");
		clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		try {

			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			clickIntercept(pom.getInstanceNotes().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			clickIntercept(pom.getInstanceNotes().editFavorite, 30);
		}
		try {
			visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
			clear(pom.getInstanceNotes().favoriteDiscription);
			sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
			clear(pom.getInstanceNotes().favoriteDiscription);
			sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");
		}
		try {
			clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		} catch (Exception e) {
			clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		}
		try {

			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			clickIntercept(pom.getInstanceNotes().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			clickIntercept(pom.getInstanceNotes().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			clickIntercept(pom.getInstanceNotes().closeFavorite, 30);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			clickIntercept(pom.getInstanceNotes().closeFavorite, 30);
		}
	}

	public static void favoriteNotes() {
		while (true) {
			if (pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceNotes().favoriteIcon, 40);
				clickIntercept(pom.getInstanceNotes().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceNotes().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceNotes().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			clickIntercept(pom.getInstanceNotes().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addNewFavorite, 40);
			clickIntercept(pom.getInstanceNotes().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
		sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes module");
		clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		try {

			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			clickIntercept(pom.getInstanceNotes().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceNotes().editFavorite, 30);
			clickIntercept(pom.getInstanceNotes().editFavorite, 30);
		}
		try {
			visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
			clear(pom.getInstanceNotes().favoriteDiscription);
			sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().favoriteDiscription, 30);
			clear(pom.getInstanceNotes().favoriteDiscription);
			sendkeys(pom.getInstanceNotes().favoriteDiscription, "Notes");
		}
		try {
			clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		} catch (Exception e) {
			clickIntercept(pom.getInstanceNotes().favoriteSave, 30);
		}
		try {

			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			clickIntercept(pom.getInstanceNotes().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceNotes().addThisFavorite, 30);
			clickIntercept(pom.getInstanceNotes().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			clickIntercept(pom.getInstanceNotes().closeFavorite, 30);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceNotes().closeFavorite, 30);
			clickIntercept(pom.getInstanceNotes().closeFavorite, 30);
		}

	}
}
