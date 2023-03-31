package com.healthRec;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.apache.commons.lang.RandomStringUtils;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Tc_020_Forms extends LaunchBrowser {

	static String frm;

	@Test
	public static void $addForm() throws Throwable {

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {

			while (true) {

				if (pom.getInstanceform().addIcon.isDisplayed()) {
					visbility(driver, pom.getInstanceform().addIcon, 30);
					clickIntercept(pom.getInstanceform().addIcon, 30);
					break;
				} else if (!pom.getInstanceform().addIcon.isDisplayed()) {
					actions("move to element", pom.getInstanceform().addIcon);

				}

			}

			sleep(3000);

			String $frmName = "";
			boolean result = false;

			for (WebElement web : pom.getInstanceform().editicon) {

				if (web.isDisplayed()) {
					result = true;
					// System.out.println("TRUE");
					clickIntercept(web, 30);
					break;

				}

			}

			if (result == false) {

				$addNewForm();
				$addFormToEhr();
				sleep(6000);
				WebElement ytt = driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/div[2]/span"));
				clickIntercept(ytt, 30);
				$delForm();

			}

			if (result == true) {
				// sleep(4000);

				visbility(driver, pom.getInstanceform().formTitleDiscription, 60);

				$frmName = pom.getInstanceform().formTitleDiscription.getAttribute("value");

				visbility(driver, pom.getInstanceform().deleteForm, 60);
				clickIntercept(pom.getInstanceform().deleteForm, 30);

				$addNewForm();
				$addFormToEhr();
				sleep(6000);
				WebElement ytt = driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/div[2]/span"));
				javascriptclick(ytt);
				$delForm();

			}

			sleep(3000);

		}

	}

	public static void $addNewForm() {

		try {
			visbility(driver, pom.getInstanceform().addNewFormAddIcon, 40);
			clickIntercept(pom.getInstanceform().addNewFormAddIcon, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceform().addNewFormAddIcon, 40);
			clickIntercept(pom.getInstanceform().addNewFormAddIcon, 30);
		}

		sleep(2000);

		frm = RandomStringUtils.randomAlphabetic(30);

		visbility(driver, pom.getInstanceform().formTitleDiscription, 40);
		sendkeys(pom.getInstanceform().formTitleDiscription, frm + "53463645");

		for (WebElement web : pom.getInstanceform().dragCheckBox) {

			if (web.getText().trim().equals("Checkbox Group")) {

				Actions ac = new Actions(driver);
				ac.dragAndDrop(web, pom.getInstanceform().dropCheckBox).build().perform();

				clear(pom.getInstanceform().clearLableInCheckBox);
				sendkeys(pom.getInstanceform().clearLableInCheckBox, "Kaaspro Enterprise");
				clickIntercept(pom.getInstanceform().saveNewForm, 30);
			}
		}

		sleep(2000);

	}

	public static void $addFormToEhr() {

		try {
			implicitWait(30, TimeUnit.SECONDS);
			WebElement addit = driver.findElement(By.xpath("//span[text()='" + frm + "']//following::div[1]/span"));
			visbility(driver, addit, 60);

			clickIntercept(addit, 30);

		} catch (Exception e) {
			implicitWait(30, TimeUnit.SECONDS);
			WebElement addit = driver.findElement(By.xpath("//span[text()='" + frm + "']//following::div[1]/span"));
			visbility(driver, addit, 60);
			clickIntercept(addit, 30);
		}

	}

	public static void $delForm() {
		boolean $frmcnd = false;

		WebElement ffr = null;
		try {
			ffr = driver.findElement(By.xpath("//span[text()='" + frm + "']//following::div[1]/div"));
			if (ffr.isDisplayed()) {

				$frmcnd = true;
				clickIntercept(ffr, 30);

			} else {
				actions("move to element", ffr);

				$delForm();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if ($frmcnd == true) {
			for (int i = 1; i <= 7; i++) {

				try {
					WebElement delfr = driver
							.findElement(By.xpath("(//span[text()='" + frm + "'])[2]//following::div[1]/span[1]"));
					if (delfr.isDisplayed()) {
						click(delfr);
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		}

	}
}
