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

public class Tc_011_Symptoms extends LaunchBrowser {

	@Test
	public static void addSymptoms_Edit_Save() throws Throwable {
		while (true) {
			if (pom.getInstanceSymptom().addicon.isDisplayed()) {
				visbility(driver, pom.getInstanceSymptom().addicon, 30);
				clickIntercept(pom.getInstanceSymptom().addicon, 30);
				break;
			} else if (!pom.getInstanceSymptom().addicon.isDisplayed()) {
				actions("move to element", pom.getInstanceSymptom().addicon);
			}
		}
		visbility(driver, pom.getInstanceSymptom().icd, 30);
		sendkeys(pom.getInstanceSymptom().icd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceSymptom().icdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement web : pom.getInstanceSymptom().icdList) {
				if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
					visbility(driver, web, 60);
					javascriptclick(web);
					break;
				}

			}

		}
		visbility(driver, pom.getInstanceSymptom().symptoms, 30);
		sendkeys(pom.getInstanceSymptom().symptoms, "fever");

		clickIntercept(pom.getInstanceSymptom().save, 30);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {
				WebElement edit = driver
						.findElement(By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
				visbility(driver, edit, 40);
				clickIntercept(edit, 30);
			} catch (StaleElementReferenceException e) {
				WebElement edit = driver
						.findElement(By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
				visbility(driver, edit, 40);
				clickIntercept(edit, 30);

			}
		} else {
			try {
				List<WebElement> edit = driver.findElements(By.xpath("//div[text()='fever']"));
				for (int i = 0; i < edit.size(); i++) {
					if (edit.get(i).isDisplayed()) {
						clickIntercept(edit.get(i), 30);
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> edit = driver.findElements(By.xpath("//div[text()='fever']"));
				for (int i = 0; i < edit.size(); i++) {
					if (edit.get(i).isDisplayed()) {
						clickIntercept(edit.get(i), 30);
						break;
					}
				}
			}

		}

		visbility(driver, pom.getInstanceSymptom().symptoms, 40);
		clear(pom.getInstanceSymptom().symptoms);
		sendkeys(pom.getInstanceSymptom().symptoms, "covid");
		clickIntercept(pom.getInstanceSymptom().save, 30);

	}

	public static void getPastSymptom() throws InterruptedException {
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {
				visbility(driver, pom.getInstanceSymptom().curePast, 30);
				clickIntercept(pom.getInstanceSymptom().curePast, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSymptom().curePast, 30);
				clickIntercept(pom.getInstanceSymptom().curePast, 30);
			}
		} else {
			try {
				for (int i = 0; i < pom.getInstanceSymptom().curePastBasic.size(); i++) {
					if (pom.getInstanceSymptom().curePastBasic.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceSymptom().curePastBasic.get(i), 30);
						clickIntercept(pom.getInstanceSymptom().curePastBasic.get(i), 30);
					}
				}
			} catch (Exception e) {
				for (int i = 0; i < pom.getInstanceSymptom().curePastBasic.size(); i++) {
					if (pom.getInstanceSymptom().curePastBasic.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceSymptom().curePastBasic.get(i), 30);
						clickIntercept(pom.getInstanceSymptom().curePastBasic.get(i), 30);
					}
				}
			}
		}
		sleep(1500);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {
				visbility(driver, pom.getInstanceSymptom().yesCure, 30);
				clickIntercept(pom.getInstanceSymptom().yesCure, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSymptom().yesCure, 30);
				clickIntercept(pom.getInstanceSymptom().yesCure, 30);
			}
		} else {
			try {
				for (int i = 0; i < pom.getInstanceSymptom().yesCureBasic.size(); i++) {
					if (pom.getInstanceSymptom().yesCureBasic.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceSymptom().yesCureBasic.get(i), 30);
						clickIntercept(pom.getInstanceSymptom().yesCureBasic.get(i), 30);
						break;
					}
				}
			} catch (Exception e) {
				for (int i = 0; i < pom.getInstanceSymptom().yesCureBasic.size(); i++) {
					if (pom.getInstanceSymptom().yesCureBasic.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceSymptom().yesCureBasic.get(i), 30);
						clickIntercept(pom.getInstanceSymptom().yesCureBasic.get(i), 30);
						break;
					}
				}
			}
		}

		while (true) {

			if (pom.getInstanceSymptom().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceSymptom().ellipses, 30);
				clickIntercept(pom.getInstanceSymptom().ellipses, 30);
				break;
			} else if (!pom.getInstanceSymptom().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceSymptom().ellipses);
			}
		}

		for (WebElement web : pom.getInstanceSymptom().ellipsesList) {

			if (web.getText().trim().equals("Past Cured Symptom")) {

				visbility(driver, web, 30);
				clickIntercept(web, 30);
				break;
			}

		}

		try {
			visbility(driver, pom.getInstanceSymptom().addPast, 40);
			clickIntercept(pom.getInstanceSymptom().addPast, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addPast, 40);
			clickIntercept(pom.getInstanceSymptom().addPast, 30);
		}

		try {
			visbility(driver, pom.getInstanceSymptom().closePast, 30);
			clickIntercept(pom.getInstanceSymptom().closePast, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().closePast, 30);
			clickIntercept(pom.getInstanceSymptom().closePast, 30);
		}

	}

	public static void favoriteSymptoms() {
		while (true) {

			if (pom.getInstanceSymptom().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceSymptom().favoriteIcon, 30);
				clickIntercept(pom.getInstanceSymptom().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceSymptom().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceSymptom().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceSymptom().addNewFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addNewFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceSymptom().favoriteicd, 30);
		sendkeys(pom.getInstanceSymptom().favoriteicd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceSymptom().favoriteicdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement web : pom.getInstanceSymptom().favoriteicdList) {
				if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
					visbility(driver, web, 60);
					clickIntercept(web, 30);

					break;
				}

			}
		}
		visbility(driver, pom.getInstanceSymptom().favoriteSymptom, 30);
		sendkeys(pom.getInstanceSymptom().favoriteSymptom, "symptoms favorite");
		clickIntercept(pom.getInstanceSymptom().favoriteSave, 30);
		sleep(2500);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {

				visbility(driver, pom.getInstanceSymptom().editFavorite, 40);
				clickIntercept(pom.getInstanceSymptom().editFavorite, 30);

			} catch (StaleElementReferenceException e) {
				visbility(driver, pom.getInstanceSymptom().editFavorite, 40);
				clickIntercept(pom.getInstanceSymptom().editFavorite, 30);
			}

			try {
				visbility(driver, pom.getInstanceSymptom().removeFavoriteIcd, 30);
				clickIntercept(pom.getInstanceSymptom().removeFavoriteIcd, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSymptom().removeFavoriteIcd, 30);
				clickIntercept(pom.getInstanceSymptom().removeFavoriteIcd, 30);
			}
		} else {
			try {
				for (int i = 0; i < pom.getInstanceSymptom().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceSymptom().editFavoriteBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceSymptom().editFavoriteBasic.get(i), 30);
						System.out.println("FAVorite edit sym");
						break;
					}
				}
			} catch (Exception e) {
				for (int i = 0; i < pom.getInstanceSymptom().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceSymptom().editFavoriteBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceSymptom().editFavoriteBasic.get(i), 30);
						System.out.println("FAVorite edit sym");
						break;
					}
				}
			}

		}
		visbility(driver, pom.getInstanceSymptom().favoriteicd, 30);
		sendkeys(pom.getInstanceSymptom().favoriteicd, "test");

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceSymptom().favoriteicdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement web : pom.getInstanceSymptom().favoriteicdList) {
				if (web.getText().trim()
						.equals("R85.81: Anal high risk human papillomavirus (HPV) DNA test positive")) {
					visbility(driver, web, 60);
					clickIntercept(web, 30);
					break;
				}

			}
		}
		visbility(driver, pom.getInstanceSymptom().favoriteSymptom, 30);
		clear(pom.getInstanceSymptom().favoriteSymptom);
		sendkeys(pom.getInstanceSymptom().favoriteSymptom, "symptoms favorite kpop2");
		clickIntercept(pom.getInstanceSymptom().favoriteSave, 30);

		try {
			visbility(driver, pom.getInstanceSymptom().addThisFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addThisFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().addThisFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceSymptom().closeFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().closeFavorite, 30);
			clickIntercept(pom.getInstanceSymptom().closeFavorite, 30);
		}

	}

}
