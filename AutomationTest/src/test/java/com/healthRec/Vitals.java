package com.healthRec;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Vitals extends Base {
	public WebDriver driver;

	public Vitals(WebDriver driver) {
		this.driver = driver;
	}

	public void vitalsFeature() throws InterruptedException {
		// TODO Auto-generated method stub

		driver.findElement(By.xpath("(//button[contains(@title,'Add Multiple Vitals')])[1]")).click();

		driver.findElement(By.id("wresult")).sendKeys("55");

		WebElement sel = driver.findElement(By.xpath("(//select[@id='unit'])[1]"));

		sel.click();
		sleep(2000);
		dropDown("text", sel, "kilograms");

		driver.findElement(By.id("hresult")).sendKeys("7'7");

		WebElement hdrp = driver.findElement(By.xpath("(//select[@id='unit'])[2]"));

		hdrp.click();

		dropDown("text", hdrp, "ft-in");

		WebElement edity = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));

		javascriptclick(edity);

		sleep(2000);
		WebElement edicon = driver.findElement(By.xpath("(//span[text()='55 kilograms'])[1]"));

		actions("click", edicon);
		sleep(2000);
		driver.findElement(By.xpath("//input[@id='wresult']")).clear();
		driver.findElement(By.xpath("//input[@id='wresult']")).sendKeys("59");

		driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]")).click();
		sleep(3000);
		/*
		 * WebElement mv =
		 * driver.findElement(By.xpath("//span[text()='59 kilograms']"));
		 * actions("click", mv); WebElement mm =
		 * driver.findElement(By.xpath("(//span[@id='del-btn'])[1]")); actions("click",
		 * mm); sleep(2000)
		 */;
	}

	public void $vitalsSalt() {
		WebElement vitalsal = driver.findElement(By.xpath("//div[@id='vital']/div[1]/div[1]/div/div[2]/div[1]"));

		actions("click", vitalsal);

	}
}
