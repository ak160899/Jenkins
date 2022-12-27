package com.healthRec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.base.*;;

public class AdvanceDirectives extends Base {

	WebDriver driver;

	public void $addAdvnceDir() throws Throwable {
		WebElement c1 = driver.findElement(By.xpath("//div[contains(@title,'Add Advance directives')]"));
		actions("move to element", c1);
		visbility(driver, c1, 60);

		actions("click", c1);

		WebElement c2 = driver.findElement(By.xpath("//div[@id='Assessment-div']/select"));
		visbility(driver, c2, 60);
		c2.click();
		dropDown("text", c2, "Assessment");
		WebElement cc1 = driver.findElement(By.xpath("//input[@id='directive_desc']"));
		visbility(driver, cc1, 60);
		sendkeys(cc1, "lets hope");// .sendKeys("lets hope");
		WebElement cc2 = driver.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, cc2, 60);
		click(cc2);// .click();
		sleep(3000);
		WebElement c4 = driver.findElement(By.xpath("//div[text()='lets hope']"));
		visbility(driver, c4, 60);
		actions("click", c4);
		sleep(2000);
		WebElement cc5 = driver.findElement(By.xpath("//input[@id='directive_desc']"));
		visbility(driver, cc5, 60);
		sendkeys(cc5, "Advance directives");// .sendKeys("Advance directives");
		WebElement cc6 = driver.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, cc6, 60);
		click(cc6);// .click();

		sleep(3000);

	}

}
