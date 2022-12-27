package com.healthRec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.base.*;

public class AttachFile extends Base {
	WebDriver driver;
	WebDriverWait ww;

	public void $addAttachFile() throws Throwable {
		WebElement ar = driver.findElement(By.xpath("//div[contains(@title,'Add Attach File')]"));
		actions("move to element", ar);
		visbility(driver, ar, 60);
		ww.until(ExpectedConditions.elementToBeClickable(ar));
		actions("click", ar);

		WebElement selweb = driver.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[1]/select"));
		visbility(driver, selweb, 60);
		dropDown("text", selweb, "Web link");
		WebElement y1 = driver
				.findElement(By.xpath("(//div[@id='Attach_FileKpop2']/div[2]/div[1]//following::div[3]/input[1])[1]"));
		visbility(driver, y1, 60);
		sendkeys(y1, "https://www.75health.com/");// .sendKeys("https://www.75health.com/");
		WebElement ps1 = driver.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[2]/div[3]/button[2]"));
		visbility(driver, ps1, 60);
		javascriptclick(ps1);
		sleep(1000);

		while (true) {

			try {
				WebElement $editAttachfileIcon = driver.findElement(
						By.xpath("(//a[text()='Web link : (https://www.75health.com/)'])[1]//parent::div/span[1]"));
				if ($editAttachfileIcon.isDisplayed()) {

					click($editAttachfileIcon);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		WebElement y2 = driver
				.findElement(By.xpath("(//div[@id='Attach_FileKpop2']/div[2]/div[1]//following::div[3]/input[1])[1]"));
		visbility(driver, y2, 60);
		clear(y2);
		sendkeys(y2, "https://www.75health.com/");

		for (int in = 1; in <= 7; in++) {
			try {

				WebElement $delAttachFile = driver
						.findElement(By.xpath("//div[@id='Attach_FileKpop2']/div[1]/div[2]/span[1]"));
				if ($delAttachFile.isDisplayed()) {
					click($delAttachFile);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
