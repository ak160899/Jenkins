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

		addFavoritedisbox();
		problemIcdCode();

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
		try {
			sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		for (int i = 1; i <= 8; i++) {
			try {

				WebElement $addedDatatiopast$ = driver.findElement(By.xpath("(//span[@title='Click to cure'])[1]"));
				if ($addedDatatiopast$.isDisplayed()) {
					visbility(driver, $addedDatatiopast$, 60);
					javascriptclick($addedDatatiopast$);
					break;
				}
			} catch (Exception e) {

			}
		}
		try {
			sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			WebElement $yescure$ = driver
					.findElement(By.xpath("(//div[text()='This is cured?'])[2]//following::span[1]"));
			visbility(driver, $yescure$, 60);
			javascriptclick($yescure$);
		} catch (Exception e) {

		}

		for (int i = 1; i <= 5; i++) {
			WebElement ps = null;
			try {

				ps = driver.findElement(By.xpath("//div[contains(@title,'SALT Problems')]//following::div[3]"));
				actions("move to element", ps);
				if (ps.isDisplayed()) {
					click(ps);
					break;
				}
			} catch (Exception e) {
				actions("move to element", ps);

			}
		}
		try {
			sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> ellipsedrpprlb = driver.findElements(
				By.xpath("//div[contains(@title,'SALT Problems')]//following::div[3]//following::ul[1]/li"));

		for (WebElement web : ellipsedrpprlb) {

			if (web.getText().trim().equals("Past Cured Problems")) {

				web.click();
				break;
			}

		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		for (int i = 1; i <= 8; i++) {
			try {

				WebElement addpastprb = driver.findElement(By
						.xpath("(//span[text()='Past Cured Problems'])[1]//following::div[1]/div[3]/div/div[1]/span"));
				if (addpastprb.isDisplayed()) {
					visbility(driver, addpastprb, 25);
					javascriptclick(addpastprb);
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
		WebElement clse = driver
				.findElement(By.xpath("(//span[text()='Past Cured Problems'])[1]//parent::div/span[1]"));
		visbility(driver, clse, 25);
		javascriptclick(clse);

	}

	public void favoriteProblemAddIcon() throws InterruptedException {
		WebElement pr1 = driver.findElement(By.xpath("//div[contains(@title,'Show my favorite Problems list ')]"));
		actions("move to element", pr1);
		visbility(driver, pr1, 60);
		javascriptclick(pr1);
		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $prob_fav_kpop$ = driver.findElement(By.xpath(
						"//div[@id='ProblemsFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, $prob_fav_kpop$, 60);
				javascriptclick($prob_fav_kpop$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		addFavoritedisbox();
		$favproblemsIcdCode();
		problemFavoriteSaveButton();
		$editAndSaveProblemav();

	}

	public void addFavoritedisbox() throws InterruptedException {
		// $$$$$$problems$$$$$$$

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $probSendkeys$ = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[1])[1]"));
				visbility(driver, $probSendkeys$, 60);
				sendkeys($probSendkeys$, "test");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void $favproblemsIcdCode() throws InterruptedException {
		boolean value = false;
		List<WebElement> $probDrop$;
		while (true) {
			$probDrop$ = driver.findElements(
					By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[1]/li/a/div/small"));
			if ($probDrop$.size() > 7)
				break;
		}
		// System.out.println($probDrop$.size());
		for (WebElement web : $probDrop$) {

			if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --") && web.isDisplayed()) {
				value = true;
				web.click();
				break;
			}

		}

		if (value == false) {
			$favproblemsIcdCode();
		}

	}

	public void $editAndSaveProblemav() throws InterruptedException {

		sleep(2000);
		for (int i = 1; i <= 7; i++) {
			try {
				WebElement $problemedit$ = driver
						.findElement(By.xpath("(//span[text()='Malignant neoplasm of testis'])[2]"));
				if ($problemedit$.isDisplayed()) {

					click($problemedit$);
					break;
				}
			} catch (Exception e) {

			}
		}

		while (true) {
			try {
				WebElement $cancel_icon_prblem$ = driver
						.findElement(By.xpath("//td[text()='Malignant neoplasm of testis']//following::div[1]"));
				visbility(driver, $cancel_icon_prblem$, 60);
				click($cancel_icon_prblem$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		addFavoritedisbox();

		$favproblemsIcdCode();
		problemFavoriteSaveButton();

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $add_problem_to_list$ = driver.findElement(By.xpath(
						"(//span[text()='Malignant neoplasm of testis'])[2]//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1]"));
				click($add_problem_to_list$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		WebElement $cancelprobKpop2$ = driver
				.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']/div[1]//following::span[1])[1]"));
		click($cancelprobKpop2$);
		sleep(2000);

	}

	private void problemFavoriteSaveButton() {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $problemsNotes$ = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[2])[1]"));
				sendkeys($problemsNotes$, "problems");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $problemsave$ = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::button[2])[1]"));
				click($problemsave$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	private void problemIcdCode() {

		boolean value = false;
		List<WebElement> $probDrop$;
		while (true) {
			$probDrop$ = driver.findElements(
					By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[2]/li/a/div/small"));
			if ($probDrop$.size() > 7)
				break;
		}
		// System.out.println($probDrop$.size());
		for (WebElement web : $probDrop$) {

			if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --") && web.isDisplayed()) {
				value = true;
				web.click();
				break;
			}

		}

		if (value == false) {
			problemIcdCode();
		}

	}

}
