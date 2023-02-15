package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class VisitReason extends Base {
	public WebDriver driver;
	PageObjMan pom;

	public void visitFeat() throws InterruptedException {
		// TODO Auto-generated method stub

		implicitWait(60, TimeUnit.SECONDS);

		WebElement u = driver.findElement(By.xpath("//div[contains(@title,'Add Visit R')]"));

		if (u.isDisplayed()) {
			click(u);
		} else {
			if (!u.isDisplayed()) {
				actions("move to element", u);
				click(u);
			}
		}

		try {
			visbility(driver, pom.getInstanceCalendar().selectAppointmentType, 60);
			click(pom.getInstanceCalendar().selectAppointmentType);

		} catch (Exception e) {
			// TODO: handle exception
		}

		List<WebElement> $TypeDropdown = driver
				.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])[2]//following::ul[1]/li/a"));

		for (WebElement Element : $TypeDropdown) {
			System.out.println(Element.getText());
			if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
				click(Element);
				break;
			}

		}
		sleep(2000);
		WebElement mj = driver.findElement(By.xpath("//div[@title='Enter the description of the patient visit']"));
		visbility(driver, mj, 60);
		mj.sendKeys("cold");

		WebElement svg = driver.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, svg, 60);
		//// div[@title='Enter the description of the patient
		//// visit']//following::div[28]/button[2]

		svg.click();
		sleep(2000);
		WebElement afk = driver.findElement(By.xpath("(//div[text()='cold'])[1]"));
		visbility(driver, afk, 60);

		actions("click", afk);

		implicitWait(30, TimeUnit.SECONDS);
		WebElement mjj = driver.findElement(By.xpath("//div[@title='Enter the description of the patient visit']"));
		visbility(driver, mjj, 60);

		mjj.clear();
		mjj.sendKeys("KAASPRO");

		WebElement svg1 = driver.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, svg1, 60);
		svg1.click();

		/*
		 * WebElement delvis = driver
		 * .findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[1]/div[2]/span"));
		 * javascriptclick(delvis);
		 */
		sleep(3000);
	}

}
