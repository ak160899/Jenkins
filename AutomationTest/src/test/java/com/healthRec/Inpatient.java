package com.healthRec;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import runner.Local_Host;

public class Inpatient extends Base {
	WebDriver driver;

	public void $addInpatInfo() throws Throwable {
		WebElement qq = driver.findElement(By.xpath("//div[contains(@title,'Add Inpatient')]"));
		actions("move to element", qq);
		visbility(driver, qq, 60);

		actions("click", qq);
		// driver.findElement(By.id("admissioniid")).click();

		WebElement inpmnth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		visbility(driver, inpmnth, 60);
		dropDown("index", inpmnth, "08");

		WebElement ipmyr = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		visbility(driver, ipmyr, 60);
		dropDown("text", ipmyr, "2022");
		WebElement y2 = driver.findElement(By.xpath("//a[text()='21']"));// .click();
		visbility(driver, y2, 60);
		click(y2);

		sleep(2000);
		driver.findElement(By.id("dischargeiid")).click();
		WebElement inpmnth1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		visbility(driver, inpmnth1, 60);
		dropDown("index", inpmnth1, "10");
		WebElement ipmyr1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		visbility(driver, ipmyr1, 60);
		dropDown("text", ipmyr1, "2022");
		WebElement y3 = driver.findElement(By.xpath("//a[text()='26']"));
		visbility(driver, y3, 60);
		click(y3);// .click();

		sleep(2000);
		WebElement re = driver.findElement(By.xpath("//div[@id='InpatientKpop2']/div[2]/div[1]/select"));
		visbility(driver, re, 60);
		// (//select[@id='admissionType'])[1]

		javascriptclick(re);
		dropDown("text", re, "Urgent");
		driver.findElement(By.id("rmNo")).sendKeys("777");
		WebElement y4 = driver.findElement(By.id("dischargeSummary"));
		visbility(driver, y4, 60);
		sendkeys(y4, "okay");// .sendKeys("okay");
		WebElement yt = driver.findElement(By.xpath("//div[@id='InpatientKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, yt, 60);
		javascriptclick(yt);

		sleep(3000);

	}

}
