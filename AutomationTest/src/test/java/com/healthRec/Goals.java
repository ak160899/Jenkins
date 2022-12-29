package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Goals extends Base {

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
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement $goalsYs_No$ = driver
						.findElement(By.xpath("(//div[text()='HELLO THIS IS GOALS MODULE.'])[1]"));
				if ($goalsYs_No$.isDisplayed()) {
					click($goalsYs_No$);
					break;
				}
			} catch (Exception e) {

			}
		}

		sleep(2000);

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement $yes_cnfrm_goal$ = driver.findElement(
						By.xpath("(//div[text()='HELLO THIS IS GOALS MODULE.'])[1]//following::div[14]/span[1]"));
				if ($yes_cnfrm_goal$.isDisplayed()) {
					visbility(driver, $yes_cnfrm_goal$, 60);
					javascriptclick($yes_cnfrm_goal$);
					break;
				}
			} catch (Exception e) {

			}
		}
		sleep(2000);
		WebElement $goalsEllipse$ = driver
				.findElement(By.xpath("//div[@title='Show my favorite Goals list for selection']//following::div[2]"));
		actions("move to element", $goalsEllipse$);
		visbility(driver, $goalsEllipse$, 60);
		javascriptclick($goalsEllipse$);

		List<WebElement> $goalsEllipselist$ = driver.findElements(By.xpath(
				"//div[@title='Show my favorite Goals list for selection']//following::div[2]//following::ul[1]/li/a"));
		for (WebElement web : $goalsEllipselist$) {
			if (web.getText().trim().equals("Past Completed Goals")) {
				click(web);
			}

		}

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement $addGoaltoehr$ = driver
						.findElement(By.xpath("(//span[@title='Click to add this goal'])[2]"));
				if ($addGoaltoehr$.isDisplayed()) {
					click($addGoaltoehr$);
					break;
				}
			} catch (Exception e) {

			}
		}
		sleep(2000);
		WebElement $closegoals$ = driver
				.findElement(By.xpath("(//span[text()='Past Completed Goals'])[1]//parent::div[1]/span[1]"));
		visbility(driver, $closegoals$, 60);
		javascriptclick($closegoals$);
	}

}
