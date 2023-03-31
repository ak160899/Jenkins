package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Tc_015_Status extends LaunchBrowser {

	@Test
	public static void addStatus_Edit_Save() throws Throwable {

		while (true) {
			if (pom.getInstanceStatus().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceStatus().addIcon, 30);
				clickIntercept(pom.getInstanceStatus().addIcon, 30);
				break;
			} else if (!pom.getInstanceStatus().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceStatus().addIcon);
			}
		}

		visbility(driver, pom.getInstanceStatus().selectType, 40);
		dropDown("text", pom.getInstanceStatus().selectType, "Cognitive status");

		visbility(driver, pom.getInstanceStatus().icd, 40);
		sendkeys(pom.getInstanceStatus().icd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceStatus().icdList.size() > 5) {

						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement we : pom.getInstanceStatus().icdList) {
				if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality")) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);
					break;
				}

			}

		}
		clickIntercept(pom.getInstanceStatus().save, 30);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {
				WebElement $editstatus$ = driver
						.findElement(By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
				visbility(driver, $editstatus$, 60);
				clickIntercept($editstatus$, 30);

			} catch (StaleElementReferenceException e) {
				WebElement $editstatus$ = driver
						.findElement(By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
				clickIntercept($editstatus$, 30);

			}
		} else {
			try {
				List<WebElement> edit = driver.findElements(By.xpath("//div[text()='test']"));
				for (int i = 0; i < edit.size(); i++) {
					if (edit.get(i).isDisplayed()) {
						clickIntercept(edit.get(i), 30);
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> edit = driver.findElements(By.xpath("//div[text()='test']"));
				for (int i = 0; i < edit.size(); i++) {
					if (edit.get(i).isDisplayed()) {
						clickIntercept(edit.get(i), 30);
						break;
					}
				}
			}
		}

		try {
			visbility(driver, pom.getInstanceStatus().removeStatus, 30);
			clickIntercept(pom.getInstanceStatus().removeStatus, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().removeStatus, 30);
			clickIntercept(pom.getInstanceStatus().removeStatus, 30);
		}

		visbility(driver, pom.getInstanceStatus().icd, 30);
		sendkeys(pom.getInstanceStatus().icd, "yang");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceStatus().icdList.size() >= 2) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement we : pom.getInstanceStatus().icdList) {
				if (we.getText().trim().equals("370534002: Yang deficiency")) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);
					break;
				}

			}
		}
		clickIntercept(pom.getInstanceStatus().save, 30);

	}

	public static void favoriteStatus() {
		while (true) {
			if (pom.getInstanceStatus().favoriteicon.isDisplayed()) {
				visbility(driver, pom.getInstanceStatus().favoriteicon, 30);
				clickIntercept(pom.getInstanceStatus().favoriteicon, 30);
				break;
			} else if (!pom.getInstanceStatus().favoriteicon.isDisplayed()) {
				actions("move to element", pom.getInstanceStatus().favoriteicon);
			}
		}

		try {

			visbility(driver, pom.getInstanceStatus().addNewFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().addNewFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addNewFavorite, 30);
		}

		visbility(driver, pom.getInstanceStatus().favoritesStatusType, 30);
		dropDown("index", pom.getInstanceStatus().favoritesStatusType, "2");

		visbility(driver, pom.getInstanceStatus().favoriteIcd, 30);

		sendkeys(pom.getInstanceStatus().favoriteIcd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceStatus().favoriteicdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (WebElement we : pom.getInstanceStatus().favoriteicdList) {
				if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality (finding)")) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);

					break;
				}

			}
		}
		clickIntercept(pom.getInstanceStatus().favoriteSave, 30);

		sleep(2000);

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {

				visbility(driver, pom.getInstanceStatus().editFavorite, 30);
				clickIntercept(pom.getInstanceStatus().editFavorite, 30);

			} catch (StaleElementReferenceException e) {
				visbility(driver, pom.getInstanceStatus().editFavorite, 30);
				clickIntercept(pom.getInstanceStatus().editFavorite, 30);

			}
			try {
				visbility(driver, pom.getInstanceStatus().removeFavoriteCode, 60);
				clickIntercept(pom.getInstanceStatus().removeFavoriteCode, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceStatus().removeFavoriteCode, 60);
				clickIntercept(pom.getInstanceStatus().removeFavoriteCode, 30);
			}
		} else {
			try {
				for (int i = 0; i < pom.getInstanceStatus().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceStatus().editFavoriteBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceStatus().editFavoriteBasic.get(i), 30);
						break;
					}
				}
				
				
			} catch (StaleElementReferenceException e) {
				for (int i = 0; i < pom.getInstanceStatus().editFavoriteBasic.size(); i++) {
					if (pom.getInstanceStatus().editFavoriteBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceStatus().editFavoriteBasic.get(i), 30);
						break;
					}
				}
			}
			
			try {
				for (int i = 0; i < pom.getInstanceStatus().removeFavoriteIcdBasic.size(); i++) {
					if (pom.getInstanceStatus().removeFavoriteIcdBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceStatus().removeFavoriteIcdBasic.get(i), 30);
						break;
					}
				}
			}catch (Exception e) {
				for (int i = 0; i < pom.getInstanceStatus().removeFavoriteIcdBasic.size(); i++) {
					if (pom.getInstanceStatus().removeFavoriteIcdBasic.get(i).isDisplayed()) {
						clickIntercept(pom.getInstanceStatus().removeFavoriteIcdBasic.get(i), 30);
						break;
					}
				}
			}

		}
		
		visbility(driver, pom.getInstanceStatus().favoriteIcd, 30);

		sendkeys(pom.getInstanceStatus().favoriteIcd, "test");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {
				try {

					if (pom.getInstanceStatus().favoriteicdList.size() > 5) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (WebElement we : pom.getInstanceStatus().favoriteicdList) {
				if (we.getText().trim().equals("134376008: Hearing test right abnormality (finding)")) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);
					break;
				}

			}
		}
		clickIntercept(pom.getInstanceStatus().favoriteSave, 30);

		try {

			visbility(driver, pom.getInstanceStatus().addThisFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().addThisFavorite, 30);
			clickIntercept(pom.getInstanceStatus().addThisFavorite, 30);
		}

		try {

			visbility(driver, pom.getInstanceStatus().closeFavorite, 30);
			clickIntercept(pom.getInstanceStatus().closeFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceStatus().closeFavorite, 30);
			clickIntercept(pom.getInstanceStatus().closeFavorite, 30);
		}

	}

}
