package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Procedure extends LaunchBrowser {

	WebDriver driver;

	public Procedure(WebDriver driver) {
		this.driver = driver;
	}

	public void $addProcedInfo() throws Throwable {
		WebElement b1 = driver.findElement(By.xpath("//div[contains(@title,'Add Procedure')]"));
		actions("move to element", b1);
		visbility(driver, b1, 60);

		actions("click", b1);
		WebElement b2;
		while (true) {
			try {
				b2 = driver.findElement(By.xpath("//select[@id='codeType']"));
				visbility(driver, b2, 60);
				javascriptclick(b2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		dropDown("text", b2, "SNOMED CT");
		WebElement ers = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/div[1]/div[2]/input"));
		visbility(driver, ers, 60);
		// driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/div[1]/div[2]/input"))
		ers.sendKeys("test");
		List<WebElement> prcddropdwn;
		;
		while (true) {
			try {
				prcddropdwn = driver.findElements(By.xpath(
						"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/small/em"));
				if (prcddropdwn.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : prcddropdwn) {

			if (web.getText().trim().equals("SNOMED : 134287002")) {
				// System.out.println("procedure met..");
				visbility(driver, web, 60);
				javascriptclick(web);
				break;

			}

		}
		WebElement smp3 = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input"));
		visbility(driver, smp3, 60);
		sendkeys(smp3, "gdgdg");// .sendKeys("gdgdg");

		WebElement svprcd1 = driver.findElement(By.id("btnSaveAdd"));
		visbility(driver, svprcd1, 60);
		click(svprcd1);// .click();
		sleep(2000);
		List<WebElement> b6 = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
		for (WebElement w : b6) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();

				break;
			}

		}
		sleep(3000);
		while (true) {
			try {
				WebElement b7 = driver
						.findElement(By.xpath("//div[text()='134287002: Cytomegalovirus antigen test (procedure)']"));
				visbility(driver, b7, 60);
				javascriptclick(b7);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// actions("click", b7);
		sleep(2000);
		WebElement clrprc = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input"));
		visbility(driver, clrprc, 60);
		clear(clrprc);// .clear();
		WebElement prcd3 = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input"));
		visbility(driver, prcd3, 60);

		sendkeys(prcd3, "LARA");// .sendKeys("LARA");

		WebElement prcd4 = driver.findElement(By.id("btnSaveAdd"));
		visbility(driver, prcd4, 60);
		click(prcd4);// .click();
		sleep(3000);
		List<WebElement> b64 = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
		for (WebElement w : b64) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		// driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[1]/div[2]/span[1]")).click();
		sleep(2500);

	}

	public void getPastProcedure() {

		while (true) {
			if (pom.getInstanceProcedure().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceProcedure().ellipses, 30);
				elementClickable(pom.getInstanceProcedure().ellipses);
				click(pom.getInstanceProcedure().ellipses);
				break;
			} else if (!pom.getInstanceProcedure().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceProcedure().ellipses);
			}
		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		for (WebElement we : pom.getInstanceProcedure().ellipsesList) {

			if (we.getText().trim().equals("Past Procedure")) {
				visbility(driver, we, 60);
				elementClickable(we);
				click(we);
				break;
			}

		}

		try {

			visbility(driver, pom.getInstanceProcedure().addPast, 30);
			elementClickable(pom.getInstanceProcedure().addPast);
			click(pom.getInstanceProcedure().addPast);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().addPast, 30);
			elementClickable(pom.getInstanceProcedure().addPast);
			click(pom.getInstanceProcedure().addPast);
		}

		try {

			visbility(driver, pom.getInstanceProcedure().closePast, 30);
			elementClickable(pom.getInstanceProcedure().closePast);
			click(pom.getInstanceProcedure().closePast);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProcedure().closePast, 30);
			elementClickable(pom.getInstanceProcedure().closePast);
			click(pom.getInstanceProcedure().closePast);
		}

	}
}
