package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Tc_007_Vaccine extends LaunchBrowser {

	@Test
	public static void tc_008_addVaccine_Edit_Save() throws Exception {
		while (true) {

			if (pom.getInstanceVaccine().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceVaccine().addIcon, 30);

				clickIntercept(pom.getInstanceVaccine().addIcon, 30);
				break;
			} else if (!pom.getInstanceVaccine().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceVaccine().addIcon);
			}
		}

		visbility(driver, pom.getInstanceVaccine().selectDateType, 30);

		dropDown("text", pom.getInstanceVaccine().selectDateType, "Taken Date");

		visbility(driver, pom.getInstanceVaccine().vaccineCvx, 30);
		sendkeys(pom.getInstanceVaccine().vaccineCvx, "kaaspro");
		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		sendkeys(pom.getInstanceVaccine().vaccineName, "TT");

		visbility(driver, pom.getInstanceVaccine().save, 30);
		clickIntercept(pom.getInstanceVaccine().save, 30);

		try {

			visbility(driver, pom.getInstanceVaccine().edit, 40);

			clickIntercept(pom.getInstanceVaccine().edit, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceVaccine().edit, 40);
			clickIntercept(pom.getInstanceVaccine().edit, 30);
		}

		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		clear(pom.getInstanceVaccine().vaccineName);
		sendkeys(pom.getInstanceVaccine().vaccineName, "TT INJECTION");

		clickIntercept(pom.getInstanceVaccine().save, 30);

	}

	private static void curePastTaken() throws InterruptedException {
		sleep(1500);

		try {

			visbility(driver, pom.getInstanceVaccine().curePast, 40);
			elementClickable(pom.getInstanceVaccine().curePast);
			click(pom.getInstanceVaccine().curePast);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().curePast, 40);
			elementClickable(pom.getInstanceVaccine().curePast);
			click(pom.getInstanceVaccine().curePast);

		}
		try {
			visbility(driver, pom.getInstanceVaccine().yesCure, 30);
			elementClickable(pom.getInstanceVaccine().yesCure);
			click(pom.getInstanceVaccine().yesCure);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().yesCure, 30);
			elementClickable(pom.getInstanceVaccine().yesCure);
			click(pom.getInstanceVaccine().yesCure);
		}

	}

	public static void $getPastVaccine() throws Throwable {
		curePastTaken();

		sleep(1500);

		while (true) {
			if (pom.getInstanceVaccine().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceVaccine().ellipses, 30);
				clickIntercept(pom.getInstanceVaccine().ellipses, 30);
				break;
			} else if (!pom.getInstanceVaccine().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceVaccine().ellipses);
				sleep(1500);
			}
		}

		for (WebElement web : pom.getInstanceVaccine().ellipsesList) {

			if (web.getText().trim().equals("Past Taken Vaccine")) {
				visbility(driver, web, 30);
				clickIntercept(web, 30);
				break;

			}

		}

		try {

			visbility(driver, pom.getInstanceVaccine().addThisVaccine, 40);
			clickIntercept(pom.getInstanceVaccine().addThisVaccine, 30);
		} catch (Exception e) {

			visbility(driver, pom.getInstanceVaccine().addThisVaccine, 40);
			clickIntercept(pom.getInstanceVaccine().addThisVaccine, 30);
		}

		try {
			visbility(driver, pom.getInstanceVaccine().cancelPastTaken, 30);
			clickIntercept(pom.getInstanceVaccine().cancelPastTaken, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().cancelPastTaken, 30);
			clickIntercept(pom.getInstanceVaccine().cancelPastTaken, 30);
		}

	}

	public static void favoriteVaccine() {
		while (true) {

			if (pom.getInstanceVaccine().favoriteicon.isDisplayed()) {
				visbility(driver, pom.getInstanceVaccine().favoriteicon, 30);
				clickIntercept(pom.getInstanceVaccine().favoriteicon, 30);
				break;
			} else if (!pom.getInstanceVaccine().favoriteicon.isDisplayed()) {
				actions("move to element", pom.getInstanceVaccine().favoriteicon);
			}
		}

		try {
			visbility(driver, pom.getInstanceVaccine().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addNewFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().addNewFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceVaccine().favoriteVaccineCvx, 30);
		sendkeys(pom.getInstanceVaccine().favoriteVaccineCvx, "vacc");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {

				if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {

					break;
				}
			}

			for (WebElement web : pom.getInstanceVaccine().favoriteIcdList) {

				if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
					clickIntercept(web, 30);
					break;
				}

			}
		}

		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		sendkeys(pom.getInstanceVaccine().vaccineName, "vacine favorite");
		clickIntercept(pom.getInstanceVaccine().favoriteSave, 30);
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {

				visbility(driver, pom.getInstanceVaccine().editFavorite, 30);
				clickIntercept(pom.getInstanceVaccine().editFavorite, 30);

			} catch (StaleElementReferenceException e) {
				visbility(driver, pom.getInstanceVaccine().editFavorite, 30);
				clickIntercept(pom.getInstanceVaccine().editFavorite, 30);
			}

			try {
				visbility(driver, pom.getInstanceVaccine().removeFavoriteIcd, 30);
				clickIntercept(pom.getInstanceVaccine().removeFavoriteIcd, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceVaccine().removeFavoriteIcd, 30);
				clickIntercept(pom.getInstanceVaccine().removeFavoriteIcd, 30);
			}
		} else {

			try {
				for (int i = 0; i < pom.getInstanceVaccine().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceVaccine().editFavoriteBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceVaccine().editFavoriteBasic.get(i), 30);
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				for (int i = 0; i < pom.getInstanceVaccine().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceVaccine().editFavoriteBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceVaccine().editFavoriteBasic.get(i), 30);
						break;
					}
				}
			}
		}
		visbility(driver, pom.getInstanceVaccine().favoriteVaccineCvx, 30);
		sendkeys(pom.getInstanceVaccine().favoriteVaccineCvx, "vacc");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {

				if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {
					break;
				}
			}

			for (WebElement we : pom.getInstanceVaccine().favoriteIcdList) {

				if (we.getText().trim().equals("vaccinia immune globulin")) {

					visbility(driver, we, 40);
					clickIntercept(we, 30);

					break;
				}

			}
		}
		visbility(driver, pom.getInstanceVaccine().vaccineName, 30);
		clear(pom.getInstanceVaccine().vaccineName);
		sendkeys(pom.getInstanceVaccine().vaccineName, "vacine module");
		clickIntercept(pom.getInstanceVaccine().favoriteSave, 30);
		sleep(2500);

		try {

			visbility(driver, pom.getInstanceVaccine().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addThisFavorite, 30);

		} catch (StaleElementReferenceException e) {

			visbility(driver, pom.getInstanceVaccine().addThisFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceVaccine().closeFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().closeFavorite, 30);
			clickIntercept(pom.getInstanceVaccine().closeFavorite, 30);
		}

	}

}
