package com.healthRec;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pageObjeman.PageObjMan;

public class Tc_003_SocialHistory extends LaunchBrowser {

	@Test
	public static void tc_004_addSocialHistory_Edit_Save() throws InterruptedException {

		while (true) {
			if (pom.getInstanceSocialHistory().addIcon.isDisplayed()) {

				visbility(driver, pom.getInstanceSocialHistory().addIcon, 30);

				clickIntercept(pom.getInstanceSocialHistory().addIcon, 30);
				break;

			} else {
				if (!pom.getInstanceSocialHistory().addIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceSocialHistory().addIcon);
				}
			}
		}

		visbility(driver, pom.getInstanceSocialHistory().selectShType, 30);

		dropDown("text", pom.getInstanceSocialHistory().selectShType, "Alcohol");
		visbility(driver, pom.getInstanceSocialHistory().discription, 30);
		sendkeys(pom.getInstanceSocialHistory().discription, "social histry");

		clickIntercept(pom.getInstanceSocialHistory().save, 30);
		try {
			WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
			visbility(driver, jj, 60);

			clickIntercept(jj, 30);
		} catch (StaleElementReferenceException e) {
			WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
			visbility(driver, jj, 60);
			clickIntercept(jj, 30);

		}
		visbility(driver, pom.getInstanceSocialHistory().discription, 30);
		clear(pom.getInstanceSocialHistory().discription);

		sendkeys(pom.getInstanceSocialHistory().discription, "KAASPRO ENTERPRISES");

		clickIntercept(pom.getInstanceSocialHistory().save, 30);
	}

}
