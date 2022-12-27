package com.healthRec;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjeman.PageObjMan;

public class SocialHistory extends Base {
	WebDriver driver;
	WebDriverWait ww;
	PageObjMan pom;

	public void $socialHistory() throws InterruptedException {

		WebElement sh = ww.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'Add Social History')]")));
		actions("move to element", sh);
		visbility(driver, sh, 60);
		actions("click", sh);
		sleep(2000);
		WebElement ssc = driver.findElement(By.xpath("//select[@id='habitType']"));
		visbility(driver, ssc, 60);
		ssc.click();
		dropDown("text", ssc, "Alcohol");
		WebElement hbt = driver.findElement(By.xpath("//select[@id='habitType']//following::div[3]/input"));
		visbility(driver, hbt, 60);
		hbt.sendKeys("social histry");

		WebElement hbt2 = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		visbility(driver, hbt2, 60);
		hbt2.click();
		sleep(2000);
		WebElement jj = driver.findElement(By.xpath("//div[text()='( Alcohol )']"));
		visbility(driver, jj, 60);

		actions("click", jj);
		sleep(2000);
		WebElement hbt4 = driver.findElement(By.xpath("//select[@id='habitType']//following::div[3]/input"));
		visbility(driver, hbt4, 60);
		hbt4.clear();
		// .clear();
		WebElement kspr = driver.findElement(By.xpath("//select[@id='habitType']//following::div[3]/input"));
		visbility(driver, kspr, 60);
		kspr.sendKeys("Kaaspro");
		WebElement hbt5 = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		visbility(driver, hbt5, 60);
		hbt5.click();

		sleep(3000);

	}

}
