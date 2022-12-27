package com.healthRec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.base.*;

public class Amendment extends Base {
	WebDriver driver;

	public void $addAmendInfo() throws Throwable {
		WebElement d = driver.findElement(By.xpath("//div[contains(@title,'Add Amendment')]"));

		actions("move to element", d);
		visbility(driver, d, 60);
		clickble(driver, d, 25);
		actions("click", d);
		WebElement s1 = driver.findElement(By.xpath("//select[@id='source']"));
		visbility(driver, s1, 60);
		s1.click();
		dropDown("text", s1, "Patient");
		WebElement amd = driver.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[2]/div/div[2]/div[2]/input"));
		visbility(driver, amd, 60);
		sendkeys(amd, "Akash");// .sendKeys("Akash");

		WebElement s2 = driver.findElement(By.xpath("//select[@id='status']"));
		visbility(driver, s2, 60);
		s2.click();
		dropDown("text", s2, "Accept");
		WebElement vs = driver.findElement(By.xpath("//input[@id='reason']"));
		visbility(driver, vs, 60);
		sendkeys(vs, "whats up...");// .sendKeys("whats up...");
		WebElement svamen = driver.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, svamen, 60);

		javascriptclick(svamen);
		sleep(3000);
		WebElement ac = driver.findElement(By.xpath("//div[text()='Accepted : whats up...']"));
		visbility(driver, ac, 60);
		actions("click", ac);
		sleep(2000);
		WebElement clr = driver.findElement(By.xpath("//input[@id='reason']"));
		visbility(driver, clr, 60);
		clear(clr);// .clear();

		WebElement ips = driver.findElement(By.xpath("//input[@id='reason']"));
		visbility(driver, ips, 60);

		sendkeys(ips, "warrior");// .sendKeys("warrior");
		WebElement iis = driver.findElement(By.xpath("//input[@id='reason']"));// .sendKeys("WAR BEGINS");
		visbility(driver, iis, 60);
		sendkeys(iis, "WAR BEGINS");
		WebElement svamen1 = driver.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, svamen1, 60);
		javascriptclick(svamen1);
		// driver.findElement(By.xpath("//div[@id='AmendmentKpop2']/div[1]/div[2]/span[1]")).click();
		sleep(3000);
	}

}
