package com.healthRec;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class Forms extends Base {
	public WebDriver driver;
	// String ur;

	public void $addForm(WebDriver driver) throws Throwable {
		this.driver = driver;

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement formsaddicon = driver.findElement(By.xpath("//div[contains(@title,'Add Forms')]"));
				if (formsaddicon.isDisplayed()) {
					click(formsaddicon);
					break;
				} else {
					actions("move to element", formsaddicon);
					click(formsaddicon);
				}

			} catch (Exception e) {

			}
		}
		sleep(3000);

		List<WebElement> numberofformspresent = driver
				.findElements(By.xpath("(//div[@class='form-pop-body'])[10]/div/div[1]"));
		int ffs = numberofformspresent.size();
		// System.out.println(ffs);

		String $frmName = "";
		boolean result = false;
		/*
		 * for (int imp = 4; imp <= ffs; imp++) {
		 * 
		 * // u = 1 + i; WebElement rtt = driver
		 * .findElement(By.xpath("(//div[@class='form-pop-body'])[10]/div[" + imp +
		 * "]/div/div[1]/span[2]")); System.out.println(rtt.getText());
		 */
		List<WebElement> $editFromicon = driver.findElements(By.xpath("//span[@title='Edit this Form']"));

		for (WebElement web : $editFromicon) {

			if (web.isDisplayed()) {
				result = true;
				System.out.println("TRUE");
				click(web);
				break;

			}

		}
		if (result == true) {
			sleep(4000);
			WebElement $FormdisBox = driver
					.findElement(By.xpath("(//label[text()='Form Title*'])[2]//following::input[1]"));
			visbility(driver, $FormdisBox, 60);

			$frmName = $FormdisBox.getAttribute("value");
			System.out.println($frmName);

			System.out.println("ok");

			WebElement js = driver.findElement(By.xpath("(//span[@id='del-form'])[2]"));
			visbility(driver, js, 60);
			javascriptclick(js);

			$addNewForm($frmName);
			$addFormToEhr($frmName);
			sleep(6000);
			WebElement ytt = driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/div[2]/span"));
			javascriptclick(ytt);
			$delForm($frmName);

		}

		sleep(3000);

	}

	public void $addNewForm(String key) {

		for (int i = 1; i <= 8; i++) {
			try {
				WebElement addfrm = driver.findElement(By.xpath("//div[@id='FormsKpop2']/div[1]/span"));
				if (addfrm.isDisplayed()) {
					click(addfrm);
					break;
				}
			} catch (Exception e) {

			}
		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement x9 = driver.findElement(By.xpath("(//label[text()='Form Title*'])[2]//following::input[1]"));
				visbility(driver, x9, 60);
				sendkeys(x9, key);
				break;
			} catch (Exception e) {

			}
		}

		List<WebElement> drk = driver.findElements(By.xpath("(//div[@id='build-wrap'])[2]/div[1]/div[2]/ul/li"));

		for (WebElement web : drk) {

			if (web.getText().trim().equals("Checkbox Group")) {

				WebElement drop = driver.findElement(
						By.xpath("(//div[contains(@data-content,'Drag a field from the right to this area')])[2]/ul"));

				Actions ac = new Actions(driver);
				ac.dragAndDrop(web, drop).build().perform();
				driver.findElement(By.xpath("//label[text()='Label']//following::div[1]/input")).clear();
				driver.findElement(By.xpath("//label[text()='Label']//following::div[1]/input"))
						.sendKeys("Kaaspro Enterprise");
				driver.findElement(By.xpath("(//div[@id='build-wrap'])[2]/div[1]/div[2]/ul//following::div[1]/button"))
						.click();
			}
		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void $addFormToEhr(String s) {

		for (int i = 1; i <= 5; i++) {
			try {
				implicitWait(30, TimeUnit.SECONDS);
				WebElement addit = driver.findElement(By.xpath("//span[text()='" + s + "']//following::div[1]/span"));
				visbility(driver, addit, 60);
				actions("click", addit);
				break;
			} catch (Exception e) {

			}
		}
		try {
			sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void $delForm(String s) {
		boolean $frmcnd = false;
		// System.out.println("fUNCTION STARTS");
		WebElement ffr = null;
		try {
			ffr = driver.findElement(By.xpath("//span[text()='" + s + "']//following::div[1]/div"));
			if (ffr.isDisplayed()) {
				System.out.println("HELLO");
				$frmcnd = true;
				click(ffr);

			} else {
				actions("move to element", ffr);
				System.out.println("BEFORE FUNCTION CALL");
				$delForm(s);
				System.out.println("funcion call ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("COUNT DOWN");
		if ($frmcnd == true) {
			for (int i = 1; i <= 7; i++) {
				System.out.println("ROOT");
				System.out.println($frmcnd);
				try {
					WebElement delfr = driver
							.findElement(By.xpath("(//span[text()='" + s + "'])[2]//following::div[1]/span[1]"));
					if (delfr.isDisplayed()) {
						click(delfr);
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		}
		System.out.println("FUNCTION END HERE");

	}
}
