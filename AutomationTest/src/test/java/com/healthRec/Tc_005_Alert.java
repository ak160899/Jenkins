package com.healthRec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.Launch.LaunchBrowser;
import org.base.*;
import com.pageObjeman.PageObjMan;

public class Tc_005_Alert extends LaunchBrowser {
	
	@Test
	public static void tc_006_addAlertEditAndSave() throws Exception {
		while (true) {

			if (pom.getInstanceAlert().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceAlert().addIcon, 30);

				clickIntercept(pom.getInstanceAlert().addIcon, 30);
				break;
			} else {
				if (!pom.getInstanceAlert().addIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceAlert().addIcon);
				}
			}
		}

		visbility(driver, pom.getInstanceAlert().discription, 30);
		sendkeys(pom.getInstanceAlert().discription, "hello");

		clickIntercept(pom.getInstanceAlert().visbility, 30);

		for (WebElement web : pom.getInstanceAlert().visbilityDropDown) {

			if (web.getText().trim().equals("Everyone")) {
				visbility(driver, web, 30);
				clickIntercept(web, 30);

				break;
			}

		}

		clickIntercept(pom.getInstanceAlert().save, 30);

		try {
			visbility(driver, pom.getInstanceAlert().edit, 40);

			clickIntercept(pom.getInstanceAlert().edit, 30);

		} catch (StaleElementReferenceException e) {
			System.out.println("stale");
			visbility(driver, pom.getInstanceAlert().edit, 40);
			clickIntercept(pom.getInstanceAlert().edit, 30);

		}

		visbility(driver, pom.getInstanceAlert().discription, 30);
		clear(pom.getInstanceAlert().discription);
		sendkeys(pom.getInstanceAlert().discription, "wELCOME");

		clickIntercept(pom.getInstanceAlert().save, 30);

	}

}
