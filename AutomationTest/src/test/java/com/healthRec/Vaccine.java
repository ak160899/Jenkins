package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObjeman.PageObjMan;

public class Vaccine extends Base {
	WebDriver driver;
	// PageObjMan pom;

	public Vaccine(WebDriver driver) {
		this.driver = driver;
	}

	public void $addVaccInfo() throws Exception {
		WebElement k = driver.findElement(By.xpath("//div[contains(@title,'Add Vaccine')]"));
		actions("move to element", k);
		visbility(driver, k, 60);

		actions("click", k);
		WebElement x = driver.findElement(By.xpath("//select[@id='date-type']"));
		visbility(driver, x, 60);
		x.click();
		dropDown("text", x, "Taken Date");
		WebElement vcne = driver.findElement(By.id("vaccine-cvx"));
		visbility(driver, vcne, 60);
		vcne.sendKeys("kaaspro");

		WebElement vcne2 = driver.findElement(By.id("vaccineName"));
		visbility(driver, vcne2, 60);
		vcne2.sendKeys("TT");
		WebElement sv = driver
				.findElement(By.xpath("//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']"));
		visbility(driver, sv, 60);
		javascriptclick(sv);
		sleep(3000);
		WebElement l = driver.findElement(By.xpath("//div[text()='TT']"));
		visbility(driver, l, 60);
		actions("click", l);

		WebElement vcna = driver.findElement(By.id("vaccineName"));// .clear();
		visbility(driver, vcna, 60);
		vcna.clear();
		WebElement vcna1 = driver.findElement(By.id("vaccineName"));// .sendKeys("TT INJECTION");
		visbility(driver, vcna1, 60);
		sendkeys(vcna1, "TT INJECTION");
		implicitWait(60, TimeUnit.SECONDS);
		/*
		 * WebElement delvc = driver .findElement(By.xpath(
		 * "(//div[@id='VaccineKpop2']//following::div[1]/span[1])[1]"));
		 * javascriptclick(delvc);
		 */
		WebElement vcc = driver
				.findElement(By.xpath("//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']"));
		visbility(driver, vcc, 60);
		click(vcc);

		sleep(3000);

	}

	public void $getPastVaccine() {
		WebElement $vaccineEllipse$ = driver.findElement(
				By.xpath("//div[@title='Show my favorite Vaccine list for selection']//following::div[2]"));
		actions("move to element", $vaccineEllipse$);
		visbility(driver, $vaccineEllipse$, 60);
		javascriptclick($vaccineEllipse$);

		List<WebElement> $vaccEllipseList$ = null;
		for (int i = 1; i <= 5; i++) {
			try {

				$vaccEllipseList$ = driver.findElements(By.xpath(
						"//div[@title='Show my favorite Vaccine list for selection']//following::div[2]//following::ul[1]/li/a/span[2]"));
				break;
			} catch (Exception e) {
				System.out.println("yes exception occurs here...");
			}
		}
		for (WebElement web : $vaccEllipseList$) {

			if (web.getText().trim().equals("Past Taken Vaccine")) {
				System.out.println("cnd me...");

				click(web);

				System.out.println("cliked ellipse past vacc");
			}

		}

		WebElement $vaccToehr$ = driver.findElement(By.xpath("(//span[@title='Click to add this vaccine'])[2]"));
		System.out.println("finded");
		visbility(driver, $vaccToehr$, 60);
		System.out.println("its visble");
		javascriptclick($vaccToehr$);

		WebElement $closeVacc$ = driver
				.findElement(By.xpath("(//span[text()='Past Taken Vaccine'])[1]//parent::div/span[1]"));
		visbility(driver, $closeVacc$, 60);
		javascriptclick($closeVacc$);
	}
}
