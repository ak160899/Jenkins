package com.healthRec;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Medication extends Base {

	WebDriver driver;

	public Medication(WebDriver driver) {
		this.driver = driver;
	}

	public void $addMedInfo() throws Throwable {
		WebElement ci = driver.findElement(By.xpath("(//div[contains(@title,'Add Medications')])[1]"));
		actions("move to element", ci);
		visbility(driver, ci, 60);

		actions("click", ci);
		sleep(2000);
		driver.findElement(By.id("DRUG_NAME")).sendKeys("tata");
		driver.findElement(By.id("STRENGTH")).sendKeys("str");
		driver.findElement(By.id("DISP_QUANTITY")).sendKeys("1");
		driver.findElement(By.id("SIG_DIRECTIONS")).sendKeys("q1");
		List<WebElement> medq = driver.findElements(By.xpath("//div[@id='addfav-div']//following::ul[1]/li/a/div"));
		for (WebElement web : medq) {
			if (web.getText().trim().equals("q12h - Every twelve hours")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		// driver.findElement(By.id("startdateiid")).sendKeys("2022-07-20");
		// driver.findElement(By.id("enddateiid")).sendKeys("2022-07-22");
		WebElement dd1 = driver.findElement(By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button"));// .click();
		visbility(driver, dd1, 60);
		click(dd1);
		sleep(2000);
		List<WebElement> d1 = driver.findElements(
				By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button//following::ul[1]/li"));
		for (WebElement w : d1) {

			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		sleep(3000);
		WebElement d3 = driver.findElement(By.xpath("//div[text()='q12h - Every twelve hours']"));
		visbility(driver, d3, 60);

		actions("click", d3);
		sleep(2000);

		/*
		 * WebElement delmed = driver
		 * .findElement(By.xpath("//div[@id='MedicationsKpop2']/div[1]/div[2]/span[1]"))
		 * ; javascriptclick(delmed);
		 */
		WebElement rqw = driver.findElement(
				By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[3]/table/tbody/tr/td[2]/div"));
		visbility(driver, rqw, 60);
		javascriptclick(rqw);
		sleep(2000);
		WebElement jsk = driver.findElement(By.id("DRUG_NAME"));
		visbility(driver, jsk, 60);
		sendkeys(jsk, "1009");

		List<WebElement> $med$drop$down$;

		while (true) {
			try {
				$med$drop$down$ = driver.findElements(
						By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em"));
				if ($med$drop$down$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (WebElement we : $med$drop$down$) {
			System.out.println(we.getText());
			if (we.getText().trim().equals("RXNORM : 1009145")) {
				// System.out.println("med cond met");
				visbility(driver, we, 60);
				javascriptclick(we);
				break;

			}

		}

		/*
		 * WebElement rt = driver.findElement(
		 * By.xpath("//b[text()='testosterone enanthate 100 MG/ML Injectable Solution']"
		 * )); visbility(driver, rt, 60); javascriptclick(rt);
		 */

		driver.findElement(By.id("DISP_QUANTITY")).sendKeys("1");
		driver.findElement(By.id("SIG_DIRECTIONS")).sendKeys("12");

		List<WebElement> med2 = driver.findElements(By.xpath("//div[@id='addfav-div']//following::ul[1]/li/a/div"));
		for (WebElement web : med2) {
			if (web.getText().trim().equals("q12h - Every twelve hours")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}

		WebElement dd2 = driver.findElement(By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button"));// .click();
		visbility(driver, dd2, 60);
		click(dd2);
		sleep(2000);
		List<WebElement> d2 = driver.findElements(
				By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]/div[1]/button//following::ul[1]/li"));
		for (WebElement w : d2) {

			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}

		sleep(3000);

	}

	public void $getPastMedication() throws InterruptedException {

		WebElement $med_cr$ = driver.findElement(By.xpath("(//span[text()='RXNORM :  1009145  '])[1]"));
		visbility(driver, $med_cr$, 60);
		javascriptclick($med_cr$);
		sleep(1000);
		WebElement $curemed$ = driver
				.findElement(By.xpath("(//span[text()='RXNORM :  1009145  '])[1]//following::div[20]/span[1]"));
		visbility(driver, $curemed$, 60);
		javascriptclick($curemed$);
		sleep(1000);

		WebElement $medEllipse$ = driver.findElement(
				By.xpath("//div[@title='Show my favorite Medications list for selection']//following::div[2]"));
		actions("move to element", $medEllipse$);
		visbility(driver, $medEllipse$, 60);
		javascriptclick($medEllipse$);

		List<WebElement> $medellipseList$ = driver.findElements(By.xpath(
				"//div[@title='Show my favorite Medications list for selection']//following::div[2]//following::ul[1]/li/a"));
		for (WebElement web : $medellipseList$) {

			if (web.getText().trim().equals("Past Ended Medication")) {
				click(web);
				break;
			}

		}
		WebElement $addToEhr$ = driver.findElement(By.xpath("(//span[@title='Click to add this medication'])[2]"));
		visbility(driver, $addToEhr$, 60);
		javascriptclick($addToEhr$);

		WebElement $clsoemed$ = driver
				.findElement(By.xpath("(//span[text()='Past Ended Medication'])[1]//parent::div/span[1]"));
		visbility(driver, $clsoemed$, 60);
		javascriptclick($clsoemed$);

	}
}
