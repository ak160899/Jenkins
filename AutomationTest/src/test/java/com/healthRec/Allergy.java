package com.healthRec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.base.*;
import com.pageObjeman.PageObjMan;

public class Allergy extends Base {
	public WebDriver driver;
	PageObjMan pom;

	public void allergyFeature() throws Exception {

		WebElement add = driver.findElement(By.xpath("//div[contains(@title,'Add Allergy')]"));

		actions("move to element", add);
		visbility(driver, add, 60);

		actions("click", add);
		WebElement se = driver.findElement(By.xpath("//select[@id='codeType']"));
		visbility(driver, se, 60);

		se.click();
		dropDown("text", se, "Food Allergy");

		/* WebElement alcl = */ WebElement fd1 = driver
				.findElement(By.xpath("//div[@id='AllergyKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
		visbility(driver, fd1, 60);
		fd1.sendKeys("food1");

		sleep(2000);
		WebElement alrgy = driver.findElement(By.xpath("//input[@placeholder='Reaction']"));
		visbility(driver, alrgy, 60);
		alrgy.sendKeys("stomach pain");

		WebElement rer = driver.findElement(By.xpath("//div[@id='AllergyKpop2']/div[2]/div[2]/div/button"));
		visbility(driver, rer, 60);

		javascriptclick(rer);

		sleep(3000);
		List<WebElement> wtw = driver.findElements(By.xpath("//div[@id='smore-btn']/ul/li"));
		for (WebElement w : wtw) {
			if (w.getText().trim().equals("Show Severity")) {
				w.click();
				break;
			}

		}
		sleep(2000);

		javascriptclick(rer);

		for (WebElement w : wtw) {
			if (w.getText().trim().equals("Show Status")) {
				visbility(driver, rer, 60);
				w.click();
				break;
			}

		}
		WebElement s = driver.findElement(By.xpath("//select[@id='severity']"));

		dropDown("text", s, "Mild");
		sleep(2000);
		WebElement ss = driver.findElement(By.xpath("//select[@id='status']"));

		dropDown("text", ss, "Inactive");

		WebElement cl2 = driver.findElement(By.xpath("//div[@id='saveadd-btn']/button"));
		visbility(driver, cl2, 60);
		cl2.click();
		List<WebElement> sss = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
		for (WebElement w : sss) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}
		sleep(2000);
		WebElement mk = driver.findElement(By.xpath("//span[text()='food1']"));
		visbility(driver, mk, 60);

		actions("click", mk);
		sleep(2000);
		WebElement jk = driver.findElement(By.xpath("//div[@id='AllergyKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
		visbility(driver, jk, 60);
		jk.clear();
		jk.sendKeys("st");
		sleep(2000);
		WebElement scq = driver.findElement(By.xpath("//div[text()='Strawberry ']"));
		visbility(driver, scq, 60);

		actions("click", scq);

		WebElement cl5 = driver.findElement(By.xpath("//div[@id='saveadd-btn']/button"));
		visbility(driver, cl5, 60);
		cl5.click();
		List<WebElement> ssss = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
		for (WebElement w : ssss) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		sleep(3000);

	}

}
