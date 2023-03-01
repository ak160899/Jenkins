package org.selectyourPlan3D;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UpgradeToLite extends LaunchBrowser {

	@Test
	public void liteUpgrade() throws InterruptedException {
		driver.navigate().refresh();
		boolean cond = false;
		try {
			WebElement lite = driver.findElement(By.xpath("//span[@id='liteCardPlan']"));
			sleep(2000);
			if (lite.isDisplayed()) {
				visbility(driver, lite, 60);
				elementClickable(lite);
				click(lite);
				cond = true;

			} else {
				WebElement $next = driver.findElement(By.xpath("(// span[@title='Next'])[2]"));
				visbility(driver, $next, 60);
				sleep(2000);
				actions("click", $next);
				WebElement lite1 = driver.findElement(By.xpath("//span[@id='liteCardPlan']"));
				sleep(2000);
				if (lite1.isDisplayed()) {
					visbility(driver, lite1, 60);
					elementClickable(lite1);
					click(lite1);
				}
			}
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			System.out.println("1");
			liteUpgrade();

		}

		try {
			WebElement activateSubLite = driver.findElement(By.xpath("(//button[@id='save_btn_lite'])"));
			visbility(driver, activateSubLite, 50);
			elementClickable(activateSubLite);
			click(activateSubLite);
		} catch (ElementClickInterceptedException e) {
			WebElement activateSubLite = driver.findElement(By.xpath("(//button[@id='save_btn_lite'])"));
			visbility(driver, activateSubLite, 50);
			elementClickable(activateSubLite);
			click(activateSubLite);
		}

		try {
			WebElement finishLite = driver
					.findElement(By.xpath("//button[@onclick='allVasPremiumThankyou.setting();']"));
			visbility(driver, finishLite, 40);
			elementClickable(finishLite);
			click(finishLite);
		} catch (Exception e) {
			WebElement finishLite = driver
					.findElement(By.xpath("//button[@onclick='allVasPremiumThankyou.setting();']"));
			visbility(driver, finishLite, 40);
			elementClickable(finishLite);
			click(finishLite);
		}
	}

}
