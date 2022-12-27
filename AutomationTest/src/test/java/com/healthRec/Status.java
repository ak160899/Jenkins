package com.healthRec;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Status extends Base {

	WebDriver driver;

	public void $addStatusInfo() throws Throwable {

		WebElement c5 = driver.findElement(By.xpath("//div[contains(@title,'Add Status')]"));
		actions("move to element", c5);
		visbility(driver, c5, 60);

		actions("click", c5);
		while (true) {
			try {
				WebElement c6 = driver.findElement(By.xpath("(//select[@id='statusType'])[1]"));
				visbility(driver, c6, 60);
				javascriptclick(c6);
				dropDown("text", c6, "Cognitive status");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement cc7 = driver.findElement(
				By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select[1]//following::div[1]/div[2]/input"));
		visbility(driver, cc7, 60);
		sendkeys(cc7, "test");// .sendKeys("test");
		sleep(2000);
		List<WebElement> $statusicddrp$;
		;
		while (true) {
			try {
				$statusicddrp$ = driver.findElements(By.xpath(
						"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
				System.out.println($statusicddrp$.size());
				if ($statusicddrp$.size() > 5) {

					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement we : $statusicddrp$) {
			if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality")) {
				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}
		WebElement cc8 = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));// .click();
		visbility(driver, cc8, 60);
		click(cc8);
		sleep(2000);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $editstatus$ = driver
						.findElement(By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
				visbility(driver, $editstatus$, 60);
				;
				javascriptclick($editstatus$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(3000);
		WebElement hjj = driver
				.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select//following::span[5]"));
		visbility(driver, hjj, 60);
		actions("click", hjj);
		WebElement cc9 = driver.findElement(
				By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select[1]//following::div[1]/div[2]/input"));
		visbility(driver, cc9, 60);
		sendkeys(cc9, "yang");// .sendKeys("yang");

		List<WebElement> $statusicddrp1$;
		;
		while (true) {
			try {
				$statusicddrp1$ = driver.findElements(By.xpath(
						"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
				if ($statusicddrp1$.size() >= 2) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement we : $statusicddrp1$) {
			if (we.getText().trim().equals("370534002: Yang deficiency")) {
				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}

		WebElement cc10 = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));// .click();
		visbility(driver, cc10, 60);
		click(cc10);
		/*
		 * WebElement delsmd =
		 * driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[1]/div[2]/span[1]")
		 * ); javascriptclick(delsmd);
		 */
		sleep(3000);

	}

}
