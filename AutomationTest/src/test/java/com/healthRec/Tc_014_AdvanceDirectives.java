package com.healthRec;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.Launch.LaunchBrowser;

public class Tc_014_AdvanceDirectives extends LaunchBrowser {

	@Test
	public static void addAdvnceDiretivesAdd_EditAndSave() throws Throwable {
		while (true) {
			if (pom.getInstanceAdvanceDirective().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceAdvanceDirective().addIcon, 30);
				clickIntercept(pom.getInstanceAdvanceDirective().addIcon, 30);
				break;
			} else if (!pom.getInstanceAdvanceDirective().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAdvanceDirective().addIcon);
			}
		}

		visbility(driver, pom.getInstanceAdvanceDirective().selectType, 30);
		dropDown("text", pom.getInstanceAdvanceDirective().selectType, "Assessment");

		visbility(driver, pom.getInstanceAdvanceDirective().assesment, 30);
		sendkeys(pom.getInstanceAdvanceDirective().assesment, "lets hope");
		clickIntercept(pom.getInstanceAdvanceDirective().save, 30);

		try {
			WebElement edit = driver.findElement(By.xpath("//div[text()='lets hope']"));
			visbility(driver, edit, 30);
			clickIntercept(edit, 30);

		} catch (StaleElementReferenceException e) {
			WebElement edit = driver.findElement(By.xpath("//div[text()='lets hope']"));

			visbility(driver, edit, 30);
			clickIntercept(edit, 30);

		}

		visbility(driver, pom.getInstanceAdvanceDirective().assesment, 30);
		sendkeys(pom.getInstanceAdvanceDirective().assesment, "Advance directives");
		clickIntercept(pom.getInstanceAdvanceDirective().save, 30);
	}

	public static void favoriteAdvanceDirectives() {
		while (true) {

			if (pom.getInstanceAdvanceDirective().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceAdvanceDirective().favoriteIcon, 30);
				clickIntercept(pom.getInstanceAdvanceDirective().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceAdvanceDirective().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAdvanceDirective().favoriteIcon);
			}

		}
		try {
			visbility(driver, pom.getInstanceAdvanceDirective().addNewFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().addNewFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addNewFavorite, 30);

		}

		visbility(driver, pom.getInstanceAdvanceDirective().favoriteStatusType, 30);
		dropDown("text", pom.getInstanceAdvanceDirective().favoriteStatusType, "Assessment");
		visbility(driver, pom.getInstanceAdvanceDirective().favoriteDiscription, 40);
		sendkeys(pom.getInstanceAdvanceDirective().favoriteDiscription, "Advance directives");
		clickIntercept(pom.getInstanceAdvanceDirective().favoriteSave, 30);

		sleep(1500);
		try {
			visbility(driver, pom.getInstanceAdvanceDirective().editFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().editFavorite, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceAdvanceDirective().editFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().editFavorite, 30);
		}

		visbility(driver, pom.getInstanceAdvanceDirective().favoriteDiscription, 40);
		clear(pom.getInstanceAdvanceDirective().favoriteDiscription);
		sendkeys(pom.getInstanceAdvanceDirective().favoriteDiscription, "Advance directives");
		clickIntercept(pom.getInstanceAdvanceDirective().favoriteSave, 30);

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().addThisFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addThisFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().addThisFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().addThisFavorite, 30);
		}

		try {
			visbility(driver, pom.getInstanceAdvanceDirective().closeFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceAdvanceDirective().closeFavorite, 30);
			clickIntercept(pom.getInstanceAdvanceDirective().closeFavorite, 30);
		}

	}
}
