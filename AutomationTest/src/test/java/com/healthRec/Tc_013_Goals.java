package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tc_013_Goals extends LaunchBrowser {

	@Test
	public static void addGoals_Edit_Save() throws Throwable {

		while (true) {

			if (pom.getInstanceGoal().addicon.isDisplayed()) {
				visbility(driver, pom.getInstanceGoal().addicon, 40);
				clickIntercept(pom.getInstanceGoal().addicon, 30);
				break;
			} else if (!pom.getInstanceGoal().addicon.isDisplayed()) {
				actions("move to element", pom.getInstanceGoal().addicon);
			}
		}
		visbility(driver, pom.getInstanceGoal().enterGoal, 30);
		sendkeys(pom.getInstanceGoal().enterGoal, "goal1");

		try {
			visbility(driver, pom.getInstanceGoal().DateField, 30);
			clickIntercept(pom.getInstanceGoal().DateField, 30);

			System.out.println("DATE CLICKED");
		} catch (Exception e) {
			System.out.println("DATE CLICKED{catch}");
			visbility(driver, pom.getInstanceGoal().DateField, 30);
			clickIntercept(pom.getInstanceGoal().DateField, 30);

		}
		visbility(driver, pom.getInstanceGoal().selectMonth, 30);
		dropDown("index", pom.getInstanceGoal().selectMonth, "09");

		visbility(driver, pom.getInstanceGoal().chooseDate, 30);
		clickIntercept(pom.getInstanceGoal().chooseDate, 30);
		clickIntercept(pom.getInstanceGoal().save, 30);

		try {

			visbility(driver, pom.getInstanceGoal().edit, 60);
			clickIntercept(pom.getInstanceGoal().edit, 30);
		} catch (StaleElementReferenceException e) {
			System.out.println("GOALS STALE");
			visbility(driver, pom.getInstanceGoal().edit, 60);
			clickIntercept(pom.getInstanceGoal().edit, 30);
		}

		visbility(driver, pom.getInstanceGoal().enterGoal, 30);
		clear(pom.getInstanceGoal().enterGoal);
		sendkeys(pom.getInstanceGoal().enterGoal, "HELLO THIS IS GOALS MODULE.");
		clickIntercept(pom.getInstanceGoal().save, 30);
	}

	public static void $getPastGoals() throws InterruptedException {

		try {
			visbility(driver, pom.getInstanceGoal().curePast, 30);
			clickIntercept(pom.getInstanceGoal().curePast, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().curePast, 30);
			clickIntercept(pom.getInstanceGoal().curePast, 30);

		}

		try {
			visbility(driver, pom.getInstanceGoal().yesCure, 30);
			clickIntercept(pom.getInstanceGoal().yesCure, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().yesCure, 30);
			clickIntercept(pom.getInstanceGoal().yesCure, 30);
		}

		while (true) {

			if (pom.getInstanceGoal().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceGoal().ellipses, 30);
				clickIntercept(pom.getInstanceGoal().ellipses, 30);
				break;
			} else if (!pom.getInstanceGoal().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceGoal().ellipses);
			}
		}

		for (WebElement web : pom.getInstanceGoal().ellipsesList) {
			if (web.getText().trim().equals("Past Completed Goals")) {
				visbility(driver, web, 30);
				clickIntercept(web, 30);
			}

		}

		try {
			visbility(driver, pom.getInstanceGoal().addPast, 30);
			clickIntercept(pom.getInstanceGoal().addPast, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().addPast, 30);
			clickIntercept(pom.getInstanceGoal().addPast, 30);
		}

		try {
			visbility(driver, pom.getInstanceGoal().closePast, 30);
			clickIntercept(pom.getInstanceGoal().closePast, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().closePast, 30);
			clickIntercept(pom.getInstanceGoal().closePast, 30);
		}
		sleep(2000);

	}

	public static void favoriteGoals() {
		while (true) {
			if (pom.getInstanceGoal().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceGoal().favoriteIcon, 30);
				clickIntercept(pom.getInstanceGoal().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceGoal().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceGoal().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceGoal().addNewFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().addNewFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addNewFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceGoal().favoritePellContent, 30);
			clickIntercept(pom.getInstanceGoal().favoritePellContent, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().favoritePellContent, 30);
			clickIntercept(pom.getInstanceGoal().favoritePellContent, 30);
		}
		visbility(driver, pom.getInstanceGoal().favoriteDiscription, 30);
		sendkeys(pom.getInstanceGoal().favoriteDiscription, "GOALS MODULE FAVORITE");
		clickIntercept(pom.getInstanceGoal().favoritesave, 30);

		sleep(1500);
		try {

			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addThisFavorite, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceGoal().addThisFavorite, 30);
			clickIntercept(pom.getInstanceGoal().addThisFavorite, 30);
		}
		sleep(1500);
		try {

			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			clickIntercept(pom.getInstanceGoal().closeFavorite, 30);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceGoal().closeFavorite, 30);
			clickIntercept(pom.getInstanceGoal().closeFavorite, 30);
		}

	}
}
