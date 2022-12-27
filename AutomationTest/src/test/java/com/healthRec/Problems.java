package com.healthRec;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjeman.PageObjMan;

import runner.Local_Host;

public class Problems extends Base {
	WebDriver driver;

	public Problems(WebDriver driver) throws Exception {
		this.driver = driver;

	}

	public void Addproblems() throws InterruptedException {
		WebElement a3 = driver.findElement(By.xpath("//div[contains(@title,'Add Problems')]"));
		actions("move to element", a3);
		visbility(driver, a3, 60);

		actions("click", a3);
		sleep(2000);

		WebElement ct = driver.findElement(By.xpath("//div[@id='ProblemsKpop2']/div[2]/div/div[1]/div[2]/input"));
		visbility(driver, ct, 60);
		// driver.findElement(By.xpath("//div[@id='ProblemsKpop2']/div[2]/div/div[1]/div[2]/input"))
		ct.sendKeys("Cleft uvula");

		sleep(3000);
		WebElement prbcl = driver.findElement(By.xpath("//small[text()='ICD10 : Q35.7 | SNOMED : --']"));
		visbility(driver, prbcl, 60);

		actions("click", prbcl);
		sleep(2000);

		WebElement gg = driver.findElement(By.xpath("//button[@id='btnSaveAdd']"));
		visbility(driver, gg, 60);

		javascriptclick(gg);

		List<WebElement> a5 = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
		for (WebElement w : a5) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;
			}

		}
		sleep(3000);
		WebElement a6 = driver.findElement(By.xpath("//div[text()='Cleft uvula']"));
		visbility(driver, a6, 60);

		actions("click", a6);
		sleep(3000);
		WebElement clr = driver
				.findElement(By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[2]"));
		visbility(driver, clr, 60);

		javascriptclick(clr);

		WebElement ljv = driver.findElement(By.xpath("//div[@id='ProblemsKpop2']/div[2]/div/div[1]/div[2]/input"));
		// driver.findElement(By.xpath("//div[@id='ProblemsKpop2']/div[2]/div/div[1]/div[2]/input"))
		visbility(driver, ljv, 60);
		ljv.sendKeys("test");
		List<WebElement> $probDrop$;
		while (true) {
			$probDrop$ = driver.findElements(
					By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[2]/li/a/div/small"));
			if ($probDrop$.size() > 7)
				break;
		}
		// System.out.println($probDrop$.size());
		boolean prbcnd = false;
		for (WebElement web : $probDrop$) {

			if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --")) {
				prbcnd = true;
				;

				web.click();
				break;
			}

		}

		WebElement gg1 = driver.findElement(By.xpath("//button[@id='btnSaveAdd']"));
		visbility(driver, gg1, 60);

		javascriptclick(gg1);
		sleep(3000);
		List<WebElement> a56 = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
		for (WebElement w : a56) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 60);
				w.click();
				break;

			}

		}
		sleep(3000);
	}

	public void getPastProblem() {

		WebElement $addedDatatiopast$ = driver.findElement(By.xpath("(//span[@title='Click to cure'])[1]"));
		visbility(driver, $addedDatatiopast$, 60);
		javascriptclick($addedDatatiopast$);

		WebElement $yescure$ = driver.findElement(By.xpath("(//div[text()='This is cured?'])[2]//following::span[1]"));
		visbility(driver, $yescure$, 60);
		javascriptclick($yescure$);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement ps = driver
						.findElement(By.xpath("//div[contains(@title,'SALT Problems')]//following::div[3]"));
				actions("move to element", ps);

				visbility(driver, ps, 25);
				actions("click", ps);
				break;
			} catch (Exception e) {

			}
		}

		List<WebElement> ellipsedrpprlb = driver.findElements(
				By.xpath("//div[contains(@title,'SALT Problems')]//following::div[3]//following::ul[1]/li"));

		for (WebElement web : ellipsedrpprlb) {

			if (web.getText().trim().equals("Past Cured Problems")) {

				web.click();
				break;
			}

		}

		//

		WebElement addpastprb = driver.findElement(
				By.xpath("(//span[text()='Past Cured Problems'])[1]//following::div[1]/div[3]/div/div[1]/span"));
		visbility(driver, addpastprb, 25);
		javascriptclick(addpastprb);
		WebElement clse = driver
				.findElement(By.xpath("(//span[text()='Past Cured Problems'])[1]//parent::div/span[1]"));
		visbility(driver, clse, 25);
		javascriptclick(clse);

	}
}
