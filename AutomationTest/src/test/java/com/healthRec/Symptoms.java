package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class Symptoms extends LaunchBrowser {

	WebDriver driver;
	// PageObjMan pom;

	public Symptoms(WebDriver driver) {

		this.driver = driver;
	}

	public void $addSympInfo() throws Throwable {
		sleep(2500);
		WebElement a7 = driver.findElement(By.xpath("//div[contains(@title,'Add Symptoms')]"));

		actions("move to element", a7);
		visbility(driver, a7, 60);

		actions("click", a7);
		WebElement prsend = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[2]/div[2]/input"));
		visbility(driver, prsend, 60);
		sendkeys(prsend, "test");// .sendKeys("R10.12:");
		implicitWait(30, TimeUnit.SECONDS);
		List<WebElement> symptomsdrop;
		while (true) {
			try {
				symptomsdrop = driver.findElements(By
						.xpath("//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
				if (symptomsdrop.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : symptomsdrop) {
			if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		sleep(2000);
		WebElement sydes = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"));
		// driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"))
		visbility(driver, sydes, 60);
		sydes.sendKeys("fever");
		WebElement svsymp = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, svsymp, 60);
		javascriptclick(svsymp);
		sleep(3000);
		WebElement a8 = driver
				.findElement(By.xpath("//div[contains(text(),'R76.1: Abnormal reaction to tuberculin test')]"));
		visbility(driver, a8, 60);

		actions("click", a8);
		WebElement smp1 = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"));
		visbility(driver, smp1, 60);
		clear(smp1);// .clear();

		sleep(2000);
		WebElement smp2 = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input"));
		visbility(driver, smp2, 60);
		sendkeys(smp2, "covid");// .sendKeys("covid");

		WebElement svsymp1 = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, svsymp1, 60);

		javascriptclick(svsymp1);
		// driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div/div[2]/span[1]")).click();
		sleep(4000);

	}

	public void getPastSymptom() throws InterruptedException {
		sleep(2000);

		try {
			visbility(driver, pom.getInstanceSymptom().curePast, 30);
			clickIntercept(pom.getInstanceSymptom().curePast, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().curePast, 30);
			clickIntercept(pom.getInstanceSymptom().curePast, 30);
		}

		sleep(1500);
		try {
			visbility(driver, pom.getInstanceSymptom().yesCure, 30);
			clickIntercept(pom.getInstanceSymptom().yesCure, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSymptom().yesCure, 30);
			clickIntercept(pom.getInstanceSymptom().yesCure, 30);
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
}
