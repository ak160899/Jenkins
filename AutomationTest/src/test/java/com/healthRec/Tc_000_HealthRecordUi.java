package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Tc_000_HealthRecordUi extends LaunchBrowser {

	@Test(priority = 1)
	public static void tc_001_verifyTheHaelthRecordCount() {
		if (url.equals("https://localhost:8443/")) {
			driver.navigate().to("https://localhost:8443/health/#list_ehr");
		} else if (url.equals("https://www.test.75health.com/")) {
			driver.navigate().to("https://www.test.75health.com/health/#list_ehr");
		} else if (url.equals("https://www.75health.com/login.jsp")) {
			driver.navigate().to("https://www.75health.com/health/#list_ehr");
		}

		sleep(3000);
		implicitWait(60, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement remv = driver
						.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
				clickIntercept(remv, 30);
				break;
			} catch (Exception e) {

			}
		}
		sleep(2000);
		List<WebElement> wwe;
		while (true) {
			try {
				wwe = driver.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
				break;
			} catch (Exception e) {

			}
		}
		for (WebElement web : wwe) {

			if (web.getText().trim().equals(kpid)) {

				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}
		sleep(2000);

		visbility(driver, pom.getInstanceHealthRec().clickAddIconHealthRec, 60);
		clickIntercept(pom.getInstanceHealthRec().clickAddIconHealthRec, 30);

	}

	@Test(priority = 2)
	public static void verifyAndShowTheHidedOptions() {
		clickIntercept(pom.getInstanceHealthRec().ehrEllipses, 30);

		for (WebElement web : pom.getInstanceHealthRec().ehrEllipsesList) {
			if (web.getText().trim().equals("Reset Setting")) {
				visbility(driver, web, 60);
				clickIntercept(web, 30);
				break;
			}

		}

		implicitWait(60, TimeUnit.SECONDS);

		sleep(3000);
		List<WebElement> rowfor = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div"));

		int ehrrow = rowfor.size();

		boolean bl = false;
		for (int i = 1; i <= ehrrow; i++) {

			List<WebElement> ds = driver.findElements(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div"));

			for (int b = 1; b < ds.size(); b++) {

				WebElement sf = driver.findElement(By.xpath("(//div[@id='cols'])[2]/div[" + i + "]/div[" + b + "]"));

				if (sf.isDisplayed() == false) {

					bl = true;
					WebElement r8 = driver.findElement(By.xpath("(//button[@id='options-img'])[1]"));
					visbility(driver, r8, 60);
					ww.until(ExpectedConditions.elementToBeClickable(r8));
					r8.click();
					List<WebElement> fin = driver.findElements(By.xpath("(//ul[@id='matchKey'])[2]/li/span/a"));
					driver.findElement(By.xpath("(//input[@id='optionsSearch'])[2]")).sendKeys("show");
					implicitWait(60, TimeUnit.SECONDS);

					for (WebElement web : fin) {

						if (web.getText().trim().equals("Show Allergy")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Alert")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Social History")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Family Health")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Symptoms")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Problems")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Vital")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Visit Reason")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Procedure")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Medications")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Test Order")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Note")) {

							clickIntercept(web, 30);
						} else if (web.getText().trim().equals("Show Vaccine")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Attach File")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Inpatient")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Referral")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Custom-form")) {
							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Goals")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Amendment")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Implantable Devices")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Advance Directives")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Physical Examination")) {

							clickIntercept(web, 30);

						} else if (web.getText().trim().equals("Show Status")) {

							clickIntercept(web, 30);

						} else {

							continue;
						}

					}

				}

			}
			if (bl == true) {
				WebElement bb2 = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div[2]/button"));
				visbility(driver, bb2, 60);
				bb2.click();
				break;
			}
		}

	}

}
