package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Goals extends LaunchBrowser {

	WebDriver driver;

	public Goals(WebDriver driver) {
		this.driver = driver;
	}

	public void $addGoalInfo() throws Throwable {

		implicitWait(30, TimeUnit.SECONDS);
		WebElement b8 = driver.findElement(By.xpath("//div[contains(@title,'Add Goals')]"));
		actions("move to element", b8);
		visbility(driver, b8, 60);

		actions("click", b8);
		sleep(2000);
		WebElement gl1 = driver.findElement(By.xpath("//div[@title='Enter goal']"));
		visbility(driver, gl1, 60);
		sendkeys(gl1, "goal1");// .sendKeys("goal1");

		WebElement gl2 = driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div[2]/div[1]/div[2]/div/input"));// .click();
		visbility(driver, gl2, 60);
		click(gl2);
		sleep(2000);
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

		implicitWait(30, TimeUnit.SECONDS);

		dropDown("index", month, "09");

		WebElement uyr = driver.findElement(By.xpath("//a[text()='14']"));// .click();
		visbility(driver, uyr, 60);
		click(uyr);
		sleep(2000);
		WebElement hk = driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, hk, 60);
		javascriptclick(hk);
		sleep(3000);
		WebElement b10 = driver.findElement(By.xpath("//div[text()='goal1']"));
		visbility(driver, b10, 60);

		actions("click", b10);
		implicitWait(60, TimeUnit.SECONDS);

		WebElement ft = driver.findElement(By.xpath("//div[@title='Enter goal']"));// .clear();
		visbility(driver, ft, 60);
		clear(ft);
		WebElement glr1 = driver.findElement(By.xpath("//div[@title='Enter goal']"));
		// .sendKeys("HELLO THIS IS GOALS MODULE.");
		visbility(driver, glr1, 60);
		sendkeys(glr1, "HELLO THIS IS GOALS MODULE.");
		WebElement hk1 = driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, hk1, 60);
		javascriptclick(hk1);

		/*
		 * WebElement jl =
		 * driver.findElement(By.xpath("//div[@id='GoalsKpop2']/div/div[2]/span[1]"));
		 * 
		 * javascriptclick(jl);
		 */
		sleep(4000);

	}

	public void $getPastGoals() throws InterruptedException {

		try {
			visbility(driver, pom.getInstanceGoal().curePast, 30);
			clickIntercept(pom.getInstanceGoal().curePast, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().curePast, 30);
			clickIntercept(pom.getInstanceGoal().curePast, 30);

		}

		try {
			visbility(driver, pom.getInstanceGoal().yesCure, 30);
			clickIntercept(pom.getInstanceGoal().yesCure, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().yesCure, 30);
			clickIntercept(pom.getInstanceGoal().yesCure, 30);
		}

		while (true) {

			if (pom.getInstanceGoal().ellipses.isDisplayed()) {
				visbility(driver, pom.getInstanceGoal().ellipses, 30);
				clickIntercept(pom.getInstanceGoal().ellipses, 30);
				break;
			} else if (!pom.getInstanceGoal().ellipses.isDisplayed()) {
				actions("move to element", pom.getInstanceGoal().ellipses);
			}
		}

		for (WebElement web : pom.getInstanceGoal().ellipsesList) {
			if (web.getText().trim().equals("Past Completed Goals")) {
				visbility(driver, web, 30);
				clickIntercept(web, 30);
			}

		}

		try {
			visbility(driver, pom.getInstanceGoal().addPast, 30);
			clickIntercept(pom.getInstanceGoal().addPast, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().addPast, 30);
			clickIntercept(pom.getInstanceGoal().addPast, 30);
		}

		try {
			visbility(driver, pom.getInstanceGoal().closePast, 30);
			clickIntercept(pom.getInstanceGoal().closePast, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceGoal().closePast, 30);
			clickIntercept(pom.getInstanceGoal().closePast, 30);
		}
		sleep(2000);

	}

}
