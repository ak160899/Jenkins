package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tc_019_PhysicalExamination extends LaunchBrowser {

	@Test
	public static void addPhysicalExamination_Edit_Save() throws Throwable {
		while (true) {

			if (pom.getInstancePhysicalExam().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstancePhysicalExam().addIcon, 30);
				clickIntercept(pom.getInstancePhysicalExam().addIcon, 30);
				break;
			} else if (!pom.getInstancePhysicalExam().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstancePhysicalExam().addIcon);
			}

		}
		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");
		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");

		try {
			javascriptclick(pom.getInstancePhysicalExam().more);

		} catch (Exception e) {
			javascriptclick(pom.getInstancePhysicalExam().more);
		}
		for (WebElement w : pom.getInstancePhysicalExam().moreDropDown) {
			if (w.getText().trim().equals("Show Notes")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				break;
			}

		}

		visbility(driver, pom.getInstancePhysicalExam().notes, 30);
		sendkeys(pom.getInstancePhysicalExam().notes, "lets goo");
		clickIntercept(pom.getInstancePhysicalExam().save, 30);

		try {
			visbility(driver, pom.getInstancePhysicalExam().edit, 30);
			clickIntercept(pom.getInstancePhysicalExam().edit, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstancePhysicalExam().edit, 30);
			clickIntercept(pom.getInstancePhysicalExam().edit, 30);
		}

		visbility(driver, pom.getInstancePhysicalExam().notes, 30);
		clear(pom.getInstancePhysicalExam().notes);
		sendkeys(pom.getInstancePhysicalExam().notes, "physical condition");
		clickIntercept(pom.getInstancePhysicalExam().save, 30);
	}

	public static void favoritePhysicalExamination() {
		while (true) {

			if (pom.getInstancePhysicalExam().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstancePhysicalExam().favoriteIcon, 40);
				clickIntercept(pom.getInstancePhysicalExam().favoriteIcon, 30);
				break;
			} else if (!pom.getInstancePhysicalExam().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstancePhysicalExam().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstancePhysicalExam().addNewFavorite, 40);
			clickIntercept(pom.getInstancePhysicalExam().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().addNewFavorite, 40);
			clickIntercept(pom.getInstancePhysicalExam().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");

		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");
		visbility(driver, pom.getInstancePhysicalExam().favoriteNotes, 30);
		sendkeys(pom.getInstancePhysicalExam().favoriteNotes, "Physical Examination modules");
		clickIntercept(pom.getInstancePhysicalExam().favoriteSave, 30);

		sleep(1500);
		try {
			visbility(driver, pom.getInstancePhysicalExam().editFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().editFavorite, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstancePhysicalExam().editFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().editFavorite, 30);
		}

		visbility(driver, pom.getInstancePhysicalExam().organItem, 30);
		clear(pom.getInstancePhysicalExam().organItem);
		sendkeys(pom.getInstancePhysicalExam().organItem, "hello");

		visbility(driver, pom.getInstancePhysicalExam().finding, 30);
		clear(pom.getInstancePhysicalExam().finding);
		sendkeys(pom.getInstancePhysicalExam().finding, "hw are you");
		clickIntercept(pom.getInstancePhysicalExam().favoriteSave, 30);

		try {
			visbility(driver, pom.getInstancePhysicalExam().addThisFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().addThisFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstancePhysicalExam().addThisFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().addThisFavorite, 30);
		}
		sleep(2000);
		try {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().closeFavorite, 30);

		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstancePhysicalExam().closeFavorite, 30);
			clickIntercept(pom.getInstancePhysicalExam().closeFavorite, 30);
		}
		sleep(2000);

		j.executeScript("window.scrollBy(0,-750)", "");
		try {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 30);
			clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceHealthRec().ehrEllipses, 30);
			clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);
		}

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Show Timestamp")) {
				visbility(wd, web, 30);
				clickIntercept(web, 30);
				break;
			}

		}

	}
}
