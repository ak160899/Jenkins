package com.healthRec;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Procedure extends Base {

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
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= 7; i++) {
			WebElement rss = null;
			try {
				rss = driver.findElement(By.xpath("//div[contains(@title,'SALT Procedure')]//following::div[3]"));
				actions("move to element", rss);
				if (rss.isDisplayed()) {
					visbility(driver, rss, 60);
					javascriptclick(rss);
					break;
				}
			} catch (Exception e) {
				actions("move to element", rss);

			}
		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> procdpast = driver.findElements(
				By.xpath("//div[contains(@title,'SALT Procedure')]//following::div[3]//following::ul[1]/li"));

		for (WebElement we : procdpast) {

			if (we.getText().trim().equals("Past Procedure")) {
				visbility(driver, we, 60);

				we.click();
				break;
			}

		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement prcdad = driver.findElement(
						By.xpath("(//span[text()='Past Procedure'])[1]//following::div[1]/div[3]/div/div/span"));
				if (prcdad.isDisplayed()) {
					click(prcdad);
					break;
				}
			} catch (Exception e) {

			}
		}

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement clsprcd = driver
						.findElement(By.xpath("(//span[text()='Past Procedure'])[1]//parent::div/span[1]"));
				if (clsprcd.isDisplayed()) {
					click(clsprcd);
					break;
				}
			} catch (Exception e) {

			}
		}

	}
}
