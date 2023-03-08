package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class Vaccine extends LaunchBrowser {

	public Vaccine(WebDriver driver) {
		this.driver = driver;
	}

	public void $addVaccInfo() throws Exception {
		WebElement k = driver.findElement(By.xpath("//div[contains(@title,'Add Vaccine')]"));
		actions("move to element", k);
		visbility(driver, k, 60);

		actions("click", k);
		WebElement x = driver.findElement(By.xpath("//select[@id='date-type']"));
		visbility(driver, x, 60);
		x.click();
		dropDown("text", x, "Taken Date");
		WebElement vcne = driver.findElement(By.id("vaccine-cvx"));
		visbility(driver, vcne, 60);
		vcne.sendKeys("kaaspro");

		WebElement vcne2 = driver.findElement(By.id("vaccineName"));
		visbility(driver, vcne2, 60);
		vcne2.sendKeys("TT");
		WebElement sv = driver
				.findElement(By.xpath("//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']"));
		visbility(driver, sv, 60);
		javascriptclick(sv);
		sleep(3000);
		WebElement l = driver.findElement(By.xpath("//div[text()='TT']"));
		visbility(driver, l, 60);
		actions("click", l);

		WebElement vcna = driver.findElement(By.id("vaccineName"));// .clear();
		visbility(driver, vcna, 60);
		vcna.clear();
		WebElement vcna1 = driver.findElement(By.id("vaccineName"));// .sendKeys("TT INJECTION");
		visbility(driver, vcna1, 60);
		sendkeys(vcna1, "TT INJECTION");
		implicitWait(60, TimeUnit.SECONDS);
		/*
		 * WebElement delvc = driver .findElement(By.xpath(
		 * "(//div[@id='VaccineKpop2']//following::div[1]/span[1])[1]"));
		 * javascriptclick(delvc);
		 */
		WebElement vcc = driver
				.findElement(By.xpath("//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']"));
		visbility(driver, vcc, 60);
		click(vcc);

		sleep(3000);

	}

	private void curePastTaken() throws InterruptedException {
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

	public void $getPastVaccine() throws Throwable {
		curePastTaken();

		sleep(1500);

		while (true) {
			if (pom.getInstanceVaccine().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceVaccine().ellipses, 30);
				elementClickable(pom.getInstanceVaccine().ellipses);
				click(pom.getInstanceVaccine().ellipses);
				break;
			} else if (!pom.getInstanceVaccine().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceVaccine().ellipses);
			}
		}
		sleep(1500);

		for (WebElement web : pom.getInstanceVaccine().ellipsesList) {

			if (web.getText().trim().equals("Past Taken Vaccine")) {
				visbility(driver, web, 30);
				elementClickable(web);

				click(web);

				System.out.println("cliked ellipse past vacc");
			}

		}

		try {

			visbility(driver, pom.getInstanceVaccine().addThisVaccine, 40);
			elementClickable(pom.getInstanceVaccine().addThisVaccine);
			click(pom.getInstanceVaccine().addThisVaccine);
		} catch (Exception e) {

			visbility(driver, pom.getInstanceVaccine().addThisVaccine, 40);
			elementClickable(pom.getInstanceVaccine().addThisVaccine);
			click(pom.getInstanceVaccine().addThisVaccine);
		}

		sleep(1500);
		try {
			visbility(driver, pom.getInstanceVaccine().cancelPastTaken, 30);
			elementClickable(pom.getInstanceVaccine().cancelPastTaken);
			click(pom.getInstanceVaccine().cancelPastTaken);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceVaccine().cancelPastTaken, 30);
			elementClickable(pom.getInstanceVaccine().cancelPastTaken);
			click(pom.getInstanceVaccine().cancelPastTaken);
		}

	}
}
