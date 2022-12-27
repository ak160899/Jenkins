package com.healthRec;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestOrder extends Base {

	WebDriver driver;
	String ur;

	public void $addTestOrder() throws Throwable {
		WebElement ad1 = driver.findElement(By.xpath("//div[contains(@title,'Add Test Order')]"));

		actions("move to element", ad1);
		actions("click", ad1);
		driver.findElement(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]/input")).sendKeys("test");

		while (true) {
			try {

				List<WebElement> $testOrderDropDown = driver.findElements(
						By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[4]/div/button//following::ul[2]/li/a"));

				if ($testOrderDropDown.size() >= 1) {
					System.out.println("ENTER");
					break;

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// sleep(4000);

		for (int in = 1; in <= 10; in++) {
			try {
				if (ur.equals("https://localhost:8443/")) {
					WebElement b = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
					if (b.isDisplayed()) {
						click(b);
						break;
					}
				} else if (ur.equals("https://www.75health.com/login.jsp")) {
					WebElement b = driver.findElement(By.xpath("(//div[text()='test'])[2]"));
					if (b.isDisplayed()) {
						click(b);
						break;
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		/*
		 * List<WebElement> tyr = driver.findElements( By.xpath(
		 * "//div[@id='Test_OrderKpop2']/div[2]/div[1]//following::ul[3]/li/a/div/span")
		 * ); for (WebElement webE : tyr) { if
		 * (webE.getText().contains("LOINC NUM :5802-4")) { webE.click(); break; }
		 * 
		 * }
		 */

		sleep(2000);

		driver.findElement(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div/button")).click();
		List<WebElement> chs = driver
				.findElements(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div/button//following::ul[1]/li"));
		for (WebElement w : chs) {

			if (w.getText().trim().equals("Show Notes")) {
				w.click();
				break;
			}

		}

		sleep(3000);
		driver.findElement(By.xpath(

				"//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input"))
				.sendKeys("ERROR");
		driver.findElement(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button"))
				.click();
		List<WebElement> dss = driver.findElements(By.xpath(
				"//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button//following::ul[1]/li"));
		for (WebElement w : dss) {
			if (w.getText().trim().equals("Save")) {

				w.click();
				break;
			}

		}
		while (true) {
			try {
				WebElement testorder = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));

				if (testorder.isDisplayed()) {
					click(testorder);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		driver.findElement(By.xpath(

				"//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input"))
				.clear();
		driver.findElement(By.xpath(

				"//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input"))
				.sendKeys("Test order..");

		driver.findElement(By.xpath("//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button"))
				.click();
		List<WebElement> dsss = driver.findElements(By.xpath(
				"//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button//following::ul[1]/li"));
		for (WebElement w : dsss) {
			if (w.getText().trim().equals("Save")) {

				w.click();
				break;
			}

		}

		sleep(3000);

	}

}
