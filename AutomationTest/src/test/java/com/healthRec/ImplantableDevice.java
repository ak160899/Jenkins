package com.healthRec;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class ImplantableDevice extends Base {
	WebDriver driver;
	PageObjMan pom;

	public void $addImplntInfo() throws Throwable {

		WebElement b = driver.findElement(By.xpath("//div[contains(@title,'Add Implantable')]"));
		actions("move to element", b);
		visbility(driver, b, 60);
		actions("click", b);
		WebElement impl = driver.findElement(By.id("udi"));// .sendKeys("(01)00844588003288");
		visbility(driver, impl, 60);
		sendkeys(impl, "(01)00844588003288");
		WebElement svimpl = driver.findElement(By.xpath("//button[@id='verify-btn']"));// .click();
		visbility(driver, svimpl, 60);
		click(svimpl);
		sleep(3000);
		driver.findElement(By.id("deviceactive"));

		WebElement a1 = driver.findElement(By.id("deviceNote"));
		visbility(driver, a1, 60);
		sleep(1000);
		a1.sendKeys("hello123");
		WebElement savimp = driver
				.findElement(By.xpath("//div[@id='Implantable_DevicesKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savimp, 60);
		javascriptclick(savimp);

		sleep(2000);
		WebElement a2 = driver.findElement(By.xpath("//div[text()='Coated femoral stem prosthesis, modular']"));
		visbility(driver, a2, 60);

		actions("click", a2);
		WebElement a26 = driver.findElement(By.id("deviceNote"));
		ScriptExecutor(a26);
		visbility(driver, a26, 60);
		a26.clear();
		a26.sendKeys("JUst Rise up..");
		WebElement savimp1 = driver
				.findElement(By.xpath("//div[@id='Implantable_DevicesKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savimp1, 60);
		javascriptclick(savimp1);

		/*
		 * driver.findElement(By.xpath("//div[@title='Remove UDI']")).click();
		 * WebElement delimp = driver .findElement(By.xpath(
		 * "//div[@id='Implantable_DevicesKpop2']/div/div[2]/span[1]"));
		 * javascriptclick(delimp);
		 */
		sleep(3000);

	}

}
