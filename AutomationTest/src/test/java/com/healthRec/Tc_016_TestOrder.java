package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tc_016_TestOrder extends LaunchBrowser {

	@Test
	public static void $addTestOrder() throws Throwable {
		while (true) {
			if (pom.getInstanceTestOrder().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceTestOrder().addIcon, 30);
				clickIntercept(pom.getInstanceTestOrder().addIcon, 30);
				break;
			} else if (!pom.getInstanceTestOrder().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceTestOrder().addIcon);
			}
		}

		visbility(driver, pom.getInstanceTestOrder().icd, 30);
		sendkeys(pom.getInstanceTestOrder().icd, "test");

		testOrderIcd();

		/*
		 * if (url.equals("https://localhost:8443/") |
		 * url.equals("https://www.75health.com/login.jsp")) { try {
		 * 
		 * WebElement edit = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
		 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
		 * (StaleElementReferenceException e) { WebElement edit =
		 * driver.findElement(By.xpath("(//div[text()='test'])[1]")); try {
		 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
		 * (ElementClickInterceptedException h) { visbility(driver, edit, 30);
		 * elementClickable(edit); click(edit); } }
		 * 
		 * }
		 */ /*
			 * else if (ur.equals("https://www.75health.com/login.jsp")) { try { WebElement
			 * edit = driver.findElement(By.xpath("(//div[text()='test'])[2]"));
			 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
			 * (StaleElementReferenceException e) { WebElement edit =
			 * driver.findElement(By.xpath("(//div[text()='test'])[2]")); try {
			 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } catch
			 * (ElementClickInterceptedException t) {
			 * 
			 * visbility(driver, edit, 30); elementClickable(edit); click(edit); } }
			 * 
			 * }
			 */

		clickIntercept(pom.getInstanceTestOrder().more, 30);

		for (WebElement w : pom.getInstanceTestOrder().moreDropdown) {

			if (w.getText().trim().equals("Show Notes")) {
				visbility(driver, w, 30);
				clickIntercept(w, 30);
				break;
			}

		}
		visbility(driver, pom.getInstanceTestOrder().notes, 40);
		sendkeys(pom.getInstanceTestOrder().notes, "ERROR");
		clickIntercept(pom.getInstanceTestOrder().save, 30);

		for (WebElement w : pom.getInstanceTestOrder().saveMore) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 30);
				clickIntercept(w, 30);
				break;
			}

		}

		try {
			WebElement edit = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));
			visbility(driver, edit, 30);
			clickIntercept(edit, 30);

		} catch (StaleElementReferenceException e) {
			WebElement edit = driver.findElement(By.xpath("(//div[text()='ERROR'])[1]"));
			clickIntercept(edit, 30);
		}

		visbility(driver, pom.getInstanceTestOrder().notes, 30);
		clear(pom.getInstanceTestOrder().notes);
		sendkeys(pom.getInstanceTestOrder().notes, "Test order..");
		clickIntercept(pom.getInstanceTestOrder().save, 30);

		for (WebElement w : pom.getInstanceTestOrder().saveMore) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 30);
				clickIntercept(w, 30);
				break;
			}

		}
	}

	private static void testOrderIcd() {
		boolean cond = false;
		while (true) {
			try {

				if (pom.getInstanceTestOrder().icdList.size() >= 1) {
					System.out.println("ENTER");
					break;

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (WebElement web : pom.getInstanceTestOrder().icdList) {
			System.out.println(web.getText());
			if (web.getText().trim().equals("test")) {
				System.out.println("enter order");
				try {

					List<WebElement> test = driver.findElements(By.xpath("//div[text()='test']"));

					for (int i = 0; i < test.size(); i++) {
						if (test.get(i).isDisplayed()) {
							visbility(driver, test.get(i), 30);
							clickIntercept(test.get(i), 30);
							cond = true;
							break;
						}

					}
				} catch (StaleElementReferenceException e) {
					
					List<WebElement> test = driver.findElements(By.xpath("//div[text()='test']"));
					
					for (int i = 0; i < test.size(); i++) {
						if (test.get(i).isDisplayed()) {
							visbility(driver, test.get(i), 30);
							clickIntercept(test.get(i), 30);
							cond = true;
							break;
						}

					}
				}

				if (cond == true) {
					System.out.println("EXIT TEST ORDER");
					break;
				}

			}

		}

	}

}
