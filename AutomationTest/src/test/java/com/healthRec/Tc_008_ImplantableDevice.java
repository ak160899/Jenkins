package com.healthRec;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pageObjeman.PageObjMan;

public class Tc_008_ImplantableDevice extends LaunchBrowser {

	@Test
	public static void tc_009_addSaveAndEditImplantableDevice() throws Throwable {

		while (true) {

			if (pom.getInstanceImplantableDevice().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceImplantableDevice().addIcon, 30);

				clickIntercept(pom.getInstanceImplantableDevice().addIcon, 30);
				break;
			} else if (!pom.getInstanceImplantableDevice().addIcon.isDisplayed()) {

				actions("move to element", pom.getInstanceImplantableDevice().addIcon);
			}
		}

		visbility(driver, pom.getInstanceImplantableDevice().udi, 30);
		sendkeys(pom.getInstanceImplantableDevice().udi, "(01)00844588003288");

		clickIntercept(pom.getInstanceImplantableDevice().verifyButton, 30);

		while (true) {
			if (pom.getInstanceImplantableDevice().verifiedTick.isDisplayed()) {
				break;
			}
		}

		visbility(driver, pom.getInstanceImplantableDevice().note, 30);
		sendkeys(pom.getInstanceImplantableDevice().note, "hello123");

		clickIntercept(pom.getInstanceImplantableDevice().save, 30);

		try {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);
		} catch (StaleElementReferenceException e) {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);

		}
		visbility(driver, pom.getInstanceImplantableDevice().note, 30);
		clear(pom.getInstanceImplantableDevice().note);
		sendkeys(pom.getInstanceImplantableDevice().note, "JUst Rise up..");

		clickIntercept(pom.getInstanceImplantableDevice().save, 30);

	}

}
