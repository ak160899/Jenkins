package com.healthRec;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhysicalExamination extends Base {
	WebDriver driver;

	public void $addPhyscInfo() throws Throwable {
		WebElement x1 = driver.findElement(By.xpath("//div[contains(@title,'Add Physical Examination')]"));
		actions("move to element", x1);
		visbility(driver, x1, 60);

		actions("click", x1);
		WebElement x2 = driver.findElement(By.id("bodyParts"));
		visbility(driver, x2, 60);
		sendkeys(x2, "hello");// .sendKeys("hello");

		WebElement x3 = driver.findElement(By.id("finding"));
		visbility(driver, x3, 60);
		sendkeys(x3, "hw are you");// .sendKeys("hw are you");
		sleep(2000);

		WebElement abc = driver
				.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/div/button"));
		visbility(driver, abc, 60);

		javascriptclick(abc);
		List<WebElement> abcd = driver.findElements(
				By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/div/button//following::ul[1]/li"));
		for (WebElement w : abcd) {
			if (w.getText().trim().equals("Show Notes")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		sleep(2000);
		WebElement x5 = driver.findElement(By.xpath("//input[@id='notes']"));
		visbility(driver, x5, 60);
		sendkeys(x5, "lets goo");// .sendKeys("lets goo");
		//// div[@id='Physical_ExaminationsKpop2']/div[2]/div[1]/div[5]/div[2]/input
		sleep(2000);
		WebElement nn = driver.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[3]/button[2]"));
		visbility(driver, nn, 60);
		javascriptclick(nn);
		sleep(3000);
		WebElement et = driver.findElement(By.xpath("//div[text()='lets goo']"));
		visbility(driver, et, 60);
		actions("click", et);
		/*
		 * WebElement sf = driver .findElement(By.xpath(
		 * "//div[@id='Physical_ExaminationsKpop2']/div[1]/div[2]/span[1]"));
		 * javascriptclick(sf);
		 */

		WebElement x7 = driver.findElement(By.xpath("//input[@id='notes']"));
		visbility(driver, x7, 60);
		clear(x7);// .clear();
		WebElement x8 = driver.findElement(By.xpath("//input[@id='notes']"));
		visbility(driver, x8, 60);
		sendkeys(x8, "physical condition");// .sendKeys("physical condition");
		WebElement nnn = driver
				.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[3]/button[2]"));
		visbility(driver, nnn, 60);
		javascriptclick(nnn);
		sleep(4000);

	}

}
