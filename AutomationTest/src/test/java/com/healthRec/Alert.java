package com.healthRec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.base.*;
import com.pageObjeman.PageObjMan;

public class Alert extends Base {
	WebDriver driver;
	PageObjMan pom;

	public void $addAlertinfo() throws Exception {
		WebElement $alert$;
		while (true) {
			try {

				$alert$ = driver.findElement(By.xpath("//div[contains(@title,'Add Alert')]"));

				// System.out.println("finded the alert icon");

				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
		}

		while (true) {

			try {
				actions("move to element", $alert$);

				// System.out.println("element is visble able to click");
				break;
			} catch (Exception e) {

			}
		}
		while (true) {
			try {
				// System.out.println("hello exception occurs here...");
				actions("click", $alert$);
				;
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		while (true) {
			try {
				WebElement fh2 = driver.findElement(By.xpath("//div[@title='Enter the description of the alert ']"));
				visbility(driver, fh2, 60);
				fh2.sendKeys("hello");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement r = driver.findElement(By.xpath("//button[@id='visibility']"));

		click(r);

		List<WebElement> $alertdrop$ = driver
				.findElements(By.xpath("//button[@id='visibility']//following::ul[1]/li/a"));
		for (WebElement web : $alertdrop$) {

			if (web.getText().trim().equals("Everyone")) {
				click(web);
				break;
			}

		}
		WebElement hbt6 = driver.findElement(By.xpath("//div[@id='AlertKpop2']/div[2]/div[2]/button[2]"));// .click();
		visbility(driver, hbt6, 60);
		click(hbt6);
		sleep(3000);
		WebElement $alertContent$;
		while (true) {
			try {
				$alertContent$ = driver.findElement(By.xpath("//div[text()='hello']"));
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		visbility(driver, $alertContent$, 60);

		javascriptclick($alertContent$);
		WebElement $contentchng$ = null;
		while (true) {
			try {
				$contentchng$ = driver.findElement(By.xpath("//div[@title='Enter the description of the alert ']"));
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		visbility(driver, $contentchng$, 60);
		clear($contentchng$);
		WebElement alrt2 = driver.findElement(By.xpath("//div[@title='Enter the description of the alert ']"));
		visbility(driver, alrt2, 60);
		sendkeys(alrt2, "wELCOME");
		WebElement alrt3 = driver.findElement(By.xpath("//div[@id='AlertKpop2']/div[2]/div[2]/button[2]"));// .click();
		visbility(driver, alrt3, 60);
		click(alrt3);
		sleep(3000);

	}

}
