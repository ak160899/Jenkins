package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class Symptoms extends Base {

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

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $cureSypmtoms$ = driver
						.findElement(By.xpath("(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]"));
				if ($cureSypmtoms$.isDisplayed()) {
					visbility(driver, $cureSypmtoms$, 60);
					javascriptclick($cureSypmtoms$);
					break;
				}
			} catch (Exception e) {

			}
		}

		sleep(1500);
		WebElement $yes_sympton$ = driver.findElement(By.xpath(
				"(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]//following::div[10]//following::div[1]/span[1]"));
		visbility(driver, $yes_sympton$, 60);
		javascriptclick($yes_sympton$);

		for (int i = 1; i <= 10; i++) {
			WebElement symptn = null;
			try {
				symptn = driver.findElement(By.xpath("//div[contains(@title,'Add Symptoms')]//following::div[1]"));
				actions("move to element", symptn);
				if (symptn.isDisplayed()) {
					visbility(driver, symptn, 60);
					javascriptclick(symptn);
					break;
				}
			} catch (Exception e) {
				actions("move to element", symptn);

			}
		}
		List<WebElement> vr = driver.findElements(
				By.xpath("//div[contains(@title,'Add Symptoms')]//following::div[1]//following::ul[1]/li"));
		for (WebElement web : vr) {

			if (web.getText().trim().equals("Past Cured Symptom")) {

				web.click();
				break;
			}

		}
		sleep(2000);
		for (int i = 1; i <= 8; i++) {
			try {
				WebElement addsymppast = driver.findElement(
						By.xpath("(//span[text()='Past Cured Symptom'])[1]//following::div[1]/div[3]/div/div/span"));
				if (addsymppast.isDisplayed()) {
					click(addsymppast);
					break;
				}
			} catch (Exception e) {

			}
		}
		sleep(2000);
		WebElement clsesymp = driver
				.findElement(By.xpath("(//span[text()='Past Cured Symptom'])[1]//parent::div/span[1]"));
		visbility(driver, clsesymp, 25);
		javascriptclick(clsesymp);

	}
}
