package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Tc_012_Procedure extends LaunchBrowser {

	@Test
	public static void addProcedure_Edit_Save() throws Throwable {
		while (true) {

			if (pom.getInstanceProcedure().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProcedure().addIcon, 40);
				clickIntercept(pom.getInstanceProcedure().addIcon, 30);
				break;
			} else if (!pom.getInstanceProcedure().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProcedure().addIcon);
			}
		}

		visbility(driver, pom.getInstanceProcedure().selectCodeType, 40);
		dropDown("text", pom.getInstanceProcedure().selectCodeType, "SNOMED CT");
		visbility(driver, pom.getInstanceProcedure().icd, 30);
		sendkeys(pom.getInstanceProcedure().icd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceProcedure().icdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement web : pom.getInstanceProcedure().icdList) {

				if (web.getText().trim().equals("SNOMED : 134287002")) {

					visbility(driver, web, 40);
					clickIntercept(web, 30);
					break;

				}

			}

		}
		visbility(driver, pom.getInstanceProcedure().procedure, 40);
		sendkeys(pom.getInstanceProcedure().procedure, "procedure");
		clickIntercept(pom.getInstanceProcedure().save, 30);

		for (WebElement w : pom.getInstanceProcedure().saveMore) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);

				break;
			}

		}

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {

				WebElement edit = driver
						.findElement(By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
				visbility(driver, edit, 60);
				clickIntercept(edit, 30);

			} catch (StaleElementReferenceException e) {

				WebElement edit = driver
						.findElement(By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
				visbility(driver, edit, 60);
				clickIntercept(edit, 30);

			}
		} else {
			try {
				List<WebElement> edit = driver.findElements(By.xpath("//div[text()='procedure']"));
				for (int i = 0; i < edit.size(); i++) {
					if (edit.get(i).isDisplayed()) {
						clickIntercept(edit.get(i), 30);
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> edit = driver.findElements(By.xpath("//div[text()='procedure']"));
				for (int i = 0; i < edit.size(); i++) {
					if (edit.get(i).isDisplayed()) {
						clickIntercept(edit.get(i), 30);
						break;
					}
				}
			}
		}

		sleep(2500);
		try {
			// System.out.println("1234");
			visbility(driver, pom.getInstanceProcedure().procedure, 40);
			clear(pom.getInstanceProcedure().procedure);
			sendkeys(pom.getInstanceProcedure().procedure, "LARA");
		} catch (NoSuchElementException e) {
			System.out.println("5678");
			System.out.println("ecception in proceudre");
			visbility(driver, pom.getInstanceProcedure().procedure, 40);
			clear(pom.getInstanceProcedure().procedure);
			sendkeys(pom.getInstanceProcedure().procedure, "LARA");
		}

		clickIntercept(pom.getInstanceProcedure().save, 30);

		for (WebElement w : pom.getInstanceProcedure().saveMore) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				break;
			}

		}
	}

	public static void getPastProcedure() {

		while (true) {
			if (pom.getInstanceProcedure().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceProcedure().ellipses, 30);
				clickIntercept(pom.getInstanceProcedure().ellipses, 30);
				break;
			} else if (!pom.getInstanceProcedure().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceProcedure().ellipses);
				sleep(2000);
			}
		}

		// sleep(2000);

		for (WebElement we : pom.getInstanceProcedure().ellipsesList) {

			if (we.getText().trim().equals("Past Procedure")) {
				visbility(driver, we, 60);
				clickIntercept(we, 30);
				break;
			}

		}

		try {

			visbility(driver, pom.getInstanceProcedure().addPast, 30);
			clickIntercept(pom.getInstanceProcedure().addPast, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addPast, 30);
			clickIntercept(pom.getInstanceProcedure().addPast, 30);
		}

		try {

			visbility(driver, pom.getInstanceProcedure().closePast, 30);
			clickIntercept(pom.getInstanceProcedure().closePast, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().closePast, 30);
			clickIntercept(pom.getInstanceProcedure().closePast, 30);
		}

	}

	public static void favoriteProcedure() {
		while (true) {
			if (pom.getInstanceProcedure().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProcedure().favoriteIcon, 40);
				clickIntercept(pom.getInstanceProcedure().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceProcedure().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProcedure().favoriteIcon);
			}
		}

		try {

			visbility(driver, pom.getInstanceProcedure().addNewFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addNewFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceProcedure().favoriteCodeType, 30);
		dropDown("index", pom.getInstanceProcedure().favoriteCodeType, "2");

		visbility(driver, pom.getInstanceProcedure().favoriteIcd, 30);
		sendkeys(pom.getInstanceProcedure().favoriteIcd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceProcedure().favoriteIcdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement web : pom.getInstanceProcedure().favoriteIcdList) {

				if (web.getText().trim().equals("SNOMED : 134287002")) {

					visbility(driver, web, 60);
					clickIntercept(web, 30);

					break;

				}

			}
		}

		visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 60);
		sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure favorite");
		clickIntercept(pom.getInstanceProcedure().favoriteSave, 30);

		for (WebElement web : pom.getInstanceProcedure().favoriteSaveMore) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);

				break;
			}

		}
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {

				visbility(driver, pom.getInstanceProcedure().editFavorite, 30);
				clickIntercept(pom.getInstanceProcedure().editFavorite, 30);
			} catch (StaleElementReferenceException e) {

				visbility(driver, pom.getInstanceProcedure().editFavorite, 30);
				clickIntercept(pom.getInstanceProcedure().editFavorite, 30);
			}

			try {
				visbility(driver, pom.getInstanceProcedure().removeFavoriteCode, 30);
				clickIntercept(pom.getInstanceProcedure().removeFavoriteCode, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceProcedure().removeFavoriteCode, 30);
				clickIntercept(pom.getInstanceProcedure().removeFavoriteCode, 30);

			}
		} else {

			try {
				for (int i = 0; i < pom.getInstanceProcedure().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceProcedure().editFavoriteBasic.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
						clickIntercept(pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				for (int i = 0; i < pom.getInstanceProcedure().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceProcedure().editFavoriteBasic.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
						clickIntercept(pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
						break;
					}
				}
			}
		}

		visbility(driver, pom.getInstanceProcedure().favoriteIcd, 30);
		sendkeys(pom.getInstanceProcedure().favoriteIcd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceProcedure().favIcdList2.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement web : pom.getInstanceProcedure().favIcdList2) {

				if (web.getText().trim().equals("Platelet adhesiveness test (procedure)")) {

					visbility(driver, web, 60);
					clickIntercept(web, 30);

					break;

				}

			}
		}

		visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 30);
		sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure kpop2 favorite");
		clickIntercept(pom.getInstanceProcedure().favoriteSave, 30);

		for (WebElement web : pom.getInstanceProcedure().favoriteSaveMore) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}

		try {
			visbility(driver, pom.getInstanceProcedure().addThisFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addThisFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceProcedure().closeFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().closeFavorite, 30);
			clickIntercept(pom.getInstanceProcedure().closeFavorite, 30);
		}
		sleep(2000);

	}
}
