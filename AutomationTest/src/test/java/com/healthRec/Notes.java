package com.healthRec;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import runner.Local_Host;

public class Notes extends Base {
	WebDriver driver;

	public void $addNotesInfo() throws Throwable {
		WebElement kk = driver.findElement(By.xpath("//div[contains(@title,'Add Notes')]"));
		actions("move to element", kk);
		visbility(driver, kk, 60);

		actions("click", kk);
		WebElement kk1 = driver
				.findElement(By.xpath("//div[@title='Enter the notes description of the patient visit']"));
		visbility(driver, kk1, 60);
		sendkeys(kk1, "hell");// .sendKeys("hell");
		WebElement zv = driver.findElement(By.xpath("//div[@id='NotesKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, zv, 60);
		javascriptclick(zv);
		sleep(3000);
		WebElement jl = driver.findElement(By.xpath("//div[text()='hell']"));
		visbility(driver, jl, 60);
		actions("click", jl);
		WebElement kk2 = driver
				.findElement(By.xpath("//div[@title='Enter the notes description of the patient visit']"));
		visbility(driver, kk2, 60);
		clear(kk2);// .clear();
		WebElement kk3 = driver
				.findElement(By.xpath("//div[@title='Enter the notes description of the patient visit']"));
		visbility(driver, kk3, 60);
		sendkeys(kk3, "NOTES--MMM");// .sendKeys("NOTES--MMM");
		WebElement zv1 = driver.findElement(By.xpath("//div[@id='NotesKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, zv1, 60);
		javascriptclick(zv1);

		/*
		 * WebElement fg =
		 * driver.findElement(By.xpath("//div[@id='NotesKpop2']/div/div[2]/span[1]"));
		 * javascriptclick(fg);
		 */
		sleep(3000);
	}

}
