package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjeman.PageObjMan;

import runner.Local_Host;

public class Problems extends LaunchBrowser {

	public static void Addproblems() throws InterruptedException {

		while (true) {

			if (pom.getInstanceProblems().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProblems().addIcon, 30);
				elementClickable(pom.getInstanceProblems().addIcon);
				click(pom.getInstanceProblems().addIcon);
				break;
			} else if (!pom.getInstanceProblems().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProblems().addIcon);
			}
		}

		visbility(driver, pom.getInstanceProblems().icd, 30);
		sendkeys(pom.getInstanceProblems().icd, "Cleft uvula");

		sleep(3000);
		try {
			WebElement icdCode = driver.findElement(By.xpath("//small[text()='ICD10 : Q35.7 | SNOMED : --']"));
			visbility(driver, icdCode, 60);
			elementClickable(icdCode);
			click(icdCode);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			WebElement icdCode = driver.findElement(By.xpath("//small[text()='ICD10 : Q35.7 | SNOMED : --']"));
			visbility(driver, icdCode, 60);
			elementClickable(icdCode);
			click(icdCode);
		}
		elementClickable(pom.getInstanceProblems().save);
		click(pom.getInstanceProblems().save);

		for (WebElement save : pom.getInstanceProblems().saveMore) {
			if (save.getText().trim().equals("Save")) {
				visbility(driver, save, 60);
				elementClickable(save);
				click(save);
				break;
			}

		}
		try {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Cleft uvula']"));
			visbility(driver, edit, 60);
			elementClickable(edit);

			click(edit);
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Cleft uvula']"));
			visbility(driver, edit, 60);
			elementClickable(edit);
			click(edit);
		}
		try {
			visbility(driver, pom.getInstanceProblems().removeProblem, 30);
			elementClickable(pom.getInstanceProblems().removeProblem);
			click(pom.getInstanceProblems().removeProblem);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().removeProblem, 30);
			elementClickable(pom.getInstanceProblems().removeProblem);
			click(pom.getInstanceProblems().removeProblem);
		}
		addFavoritedisbox();
		problemIcdCode();
		elementClickable(pom.getInstanceProblems().save);
		click(pom.getInstanceProblems().save);

		for (WebElement w : pom.getInstanceProblems().saveMore) {
			if (w.getText().trim().equals("Save")) {
				visbility(driver, w, 40);
				elementClickable(w);
				click(w);
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

	public static void favoriteProblemAddIcon() throws InterruptedException {

		while (true) {
			if (pom.getInstanceProblems().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProblems().favoriteIcon, 30);
				elementClickable(pom.getInstanceProblems().favoriteIcon);
				click(pom.getInstanceProblems().favoriteIcon);
				break;
			} else if (!pom.getInstanceProblems().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProblems().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstanceProblems().addNewFavorite, 30);
			elementClickable(pom.getInstanceProblems().addNewFavorite);
			click(pom.getInstanceProblems().addNewFavorite);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().addNewFavorite, 30);
			elementClickable(pom.getInstanceProblems().addNewFavorite);
			click(pom.getInstanceProblems().addNewFavorite);
		}

		addFavoritedisbox();
		$favproblemsIcdCode();
		problemFavoriteSaveButton();
		$editAndSaveProblemav();

	}

	public static void addFavoritedisbox() throws InterruptedException {

		try {

			visbility(driver, pom.getInstanceProblems().favoriteIcd, 40);
			sendkeys(pom.getInstanceProblems().favoriteIcd, "malignant neoplasm of testis");

		} catch (Exception e) {

			visbility(driver, pom.getInstanceProblems().favoriteIcd, 40);
			sendkeys(pom.getInstanceProblems().favoriteIcd, "malignant neoplasm of testis");
		}

	}

	public static void $favproblemsIcdCode() throws InterruptedException {
		boolean value = false;
		while (true) {

			if (pom.getInstanceProblems().favoriteIcdList.size() > 7)
				break;
		}

		for (WebElement web : pom.getInstanceProblems().favoriteIcdList) {

			if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --") && web.isDisplayed()) {
				visbility(driver, web, 40);
				elementClickable(web);
				value = true;
				web.click();
				break;
			}

		}

		if (value == false) {
			$favproblemsIcdCode();
		}

	}

	public static void $editAndSaveProblemav() throws InterruptedException {

		try {
			visbility(driver, pom.getInstanceProblems().editFavorite, 30);
			elementClickable(pom.getInstanceProblems().editFavorite);
			click(pom.getInstanceProblems().editFavorite);

		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceProblems().editFavorite, 30);
			elementClickable(pom.getInstanceProblems().editFavorite);
			click(pom.getInstanceProblems().editFavorite);
		}
		try {
			visbility(driver, pom.getInstanceProblems().removeFavoriteCode, 30);
			elementClickable(pom.getInstanceProblems().removeFavoriteCode);
			click(pom.getInstanceProblems().removeFavoriteCode);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().removeFavoriteCode, 30);
			elementClickable(pom.getInstanceProblems().removeFavoriteCode);
			click(pom.getInstanceProblems().removeFavoriteCode);
		}

		addFavoritedisbox();

		$favproblemsIcdCode();
		problemFavoriteSaveButton();

		try {
			visbility(driver, pom.getInstanceProblems().addThisFavorite, 30);
			elementClickable(pom.getInstanceProblems().addThisFavorite);
			click(pom.getInstanceProblems().addThisFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().addThisFavorite, 30);
			elementClickable(pom.getInstanceProblems().addThisFavorite);
			click(pom.getInstanceProblems().addThisFavorite);
		}

		try {
			visbility(driver, pom.getInstanceProblems().closeFavorite, 30);
			elementClickable(pom.getInstanceProblems().closeFavorite);
			click(pom.getInstanceProblems().closeFavorite);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().closeFavorite, 30);
			elementClickable(pom.getInstanceProblems().closeFavorite);
			click(pom.getInstanceProblems().closeFavorite);
		}
		sleep(2000);

	}

	private static void problemFavoriteSaveButton() {

		visbility(driver, pom.getInstanceProblems().favoriteNote, 40);
		sendkeys(pom.getInstanceProblems().favoriteNote, "problems");

		elementClickable(pom.getInstanceProblems().favoriteSave);
		click(pom.getInstanceProblems().favoriteSave);

	}

	private static void problemIcdCode() {

		boolean value = false;
		List<WebElement> $probDrop$;
		while (true) {
			$probDrop$ = driver.findElements(
					By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[2]/li/a/div/small"));
			if ($probDrop$.size() > 7)
				break;
		}

		for (WebElement web : $probDrop$) {
			System.out.println(web.getText());
			if (web.getText().equals("ICD10 : C62 | SNOMED : --") && web.isDisplayed()) {
				value = true;
				System.out.println("Problem icd met");
				web.click();
				break;
			}

		}

		if (value == false) {
			problemIcdCode();
		}

	}

}
