package com.healthRec;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.SmokeTesting.Local_Host;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Tc_010Problems extends LaunchBrowser {

	@Test
	public static void addproblems_Edit_Save() throws InterruptedException {

		while (true) {

			if (pom.getInstanceProblems().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProblems().addIcon, 30);
				clickIntercept(pom.getInstanceProblems().addIcon, 30);
				break;
			} else if (!pom.getInstanceProblems().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProblems().addIcon);
			}
		}

		visbility(driver, pom.getInstanceProblems().icd, 30);
		sendkeys(pom.getInstanceProblems().icd, "Cleft uvula");

		sleep(3000);

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			try {
				WebElement icdCode = driver.findElement(By.xpath("//small[text()='ICD10 : Q35.7 | SNOMED : --']"));
				visbility(driver, icdCode, 60);
				clickIntercept(icdCode, 30);
			} catch (StaleElementReferenceException e) {
				WebElement icdCode = driver.findElement(By.xpath("//small[text()='ICD10 : Q35.7 | SNOMED : --']"));
				visbility(driver, icdCode, 60);
				clickIntercept(icdCode, 30);
			}

		} else {
			List<WebElement> icd = driver.findElements(By.xpath("//div[text()='Cleft uvula']"));
			for (int i = 0; i < icd.size(); i++) {
				if (icd.get(i).isDisplayed()) {
					clickIntercept(icd.get(i), 30);
					break;
				}
			}
		}

		clickIntercept(pom.getInstanceProblems().save, 30);

		for (WebElement save : pom.getInstanceProblems().saveMore) {
			if (save.getText().trim().equals("Save")) {
				visbility(driver, save, 60);
				clickIntercept(save, 30);
				break;
			}

		}

		try {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Cleft uvula']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);
		} catch (StaleElementReferenceException e) {
			WebElement edit = driver.findElement(By.xpath("//div[text()='Cleft uvula']"));
			visbility(driver, edit, 60);
			clickIntercept(edit, 30);
		}

		try {
			visbility(driver, pom.getInstanceProblems().removeProblem, 30);
			clickIntercept(pom.getInstanceProblems().removeProblem, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().removeProblem, 30);
			clickIntercept(pom.getInstanceProblems().removeProblem, 30);
		}
		addFavoritedisbox();

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			problemIcdCode();
		} else {
			List<WebElement> icd = driver.findElements(By.xpath("//div[text()='malignant neoplasm testis']"));
			for (int i = 0; i < icd.size(); i++) {
				if (icd.get(i).isDisplayed()) {
					clickIntercept(icd.get(i), 30);
					break;
				}
			}
		}
		clickIntercept(pom.getInstanceProblems().save, 30);

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

		sleep(2000);

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

		sleep(2000);

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

		sleep(1500);

		List<WebElement> ellipsedrpprlb = driver.findElements(
				By.xpath("//div[contains(@title,'SALT Problems')]//following::div[3]//following::ul[1]/li"));

		for (WebElement web : ellipsedrpprlb) {

			if (web.getText().trim().equals("Past Cured Problems")) {

				web.click();
				break;
			}

		}

		sleep(2000);

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

		sleep(2000);

		WebElement clse = driver
				.findElement(By.xpath("(//span[text()='Past Cured Problems'])[1]//parent::div/span[1]"));
		visbility(driver, clse, 25);
		javascriptclick(clse);

	}

	public static void favoriteProblemAddIcon() throws InterruptedException {

		while (true) {
			if (pom.getInstanceProblems().favoriteIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceProblems().favoriteIcon, 30);
				clickIntercept(pom.getInstanceProblems().favoriteIcon, 30);
				break;
			} else if (!pom.getInstanceProblems().favoriteIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceProblems().favoriteIcon);
			}
		}

		try {
			visbility(driver, pom.getInstanceProblems().addNewFavorite, 30);
			clickIntercept(pom.getInstanceProblems().addNewFavorite, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().addNewFavorite, 30);
			clickIntercept(pom.getInstanceProblems().addNewFavorite, 30);
		}

		addFavoritedisbox();

		$favproblemsIcdCode();

		problemFavoriteSaveButton();
		sleep(2000);
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

		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			while (true) {

				if (pom.getInstanceProblems().favoriteIcdList.size() > 7)
					break;
			}

			for (WebElement web : pom.getInstanceProblems().favoriteIcdList) {

				if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --") && web.isDisplayed()) {
					visbility(driver, web, 40);

					value = true;
					clickIntercept(web, 30);
					break;
				}

			}

			if (value == false) {
				$favproblemsIcdCode();
			}
		} else {
			List<WebElement> icd = driver.findElements(By.cssSelector("div[id='ProblemsKpop2'] ul li a"));
			while (true) {
				if (icd.size() >= 1) {

					break;
				}
			}

			for (int i = 0; i < icd.size(); i++) {
				System.out.println(icd.get(i).getText());
				if (icd.get(i).isDisplayed() && icd.get(i).getText().equalsIgnoreCase("malignant neoplasm testis")) {
					clickIntercept(icd.get(i), 30);
					break;
				}
			}
		}

	}

	public static void $editAndSaveProblemav() throws InterruptedException {
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {

			try {
				visbility(driver, pom.getInstanceProblems().editFavorite, 30);
				clickIntercept(pom.getInstanceProblems().editFavorite, 30);
			} catch (StaleElementReferenceException e) {
				visbility(driver, pom.getInstanceProblems().editFavorite, 30);
				clickIntercept(pom.getInstanceProblems().editFavorite, 30);
			}

			try

			{
				visbility(driver, pom.getInstanceProblems().removeFavoriteCode, 30);
				clickIntercept(pom.getInstanceProblems().removeFavoriteCode, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceProblems().removeFavoriteCode, 30);
				clickIntercept(pom.getInstanceProblems().removeFavoriteCode, 30);
			}

		} else {
			try {
				List<WebElement> icd = driver.findElements(By.xpath("//div[text()='malignant neoplasm testis']"));
				for (int i = 0; i < icd.size(); i++) {
					// div[text()='malignant neoplasm of testis']
					if (icd.get(i).isDisplayed()) {
						clickIntercept(icd.get(i), 30);
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> icd = driver.findElements(By.xpath("//div[text()='malignant neoplasm testis']"));
				for (int i = 0; i < icd.size(); i++) {
					if (icd.get(i).isDisplayed()) {
						clickIntercept(icd.get(i), 30);
						break;
					}
				}
			}

			try {
				for (int i = 0; i < pom.getInstanceProblems().removeFavoriteBaisc.size(); i++) {
					if (pom.getInstanceProblems().removeFavoriteBaisc.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceProblems().removeFavoriteBaisc.get(i), 30);
						clickIntercept(pom.getInstanceProblems().removeFavoriteBaisc.get(i), 30);
						break;
					}
				}
			} catch (Exception e) {
				for (int i = 0; i < pom.getInstanceProblems().removeFavoriteBaisc.size(); i++) {
					if (pom.getInstanceProblems().removeFavoriteBaisc.get(i).isDisplayed()) {
						visbility(driver, pom.getInstanceProblems().removeFavoriteBaisc.get(i), 30);
						clickIntercept(pom.getInstanceProblems().removeFavoriteBaisc.get(i), 30);
						break;
					}
				}
			}

		}

		addFavoritedisbox();

		$favproblemsIcdCode();

		problemFavoriteSaveButton();
		
		sleep(2000);

		try

		{
			for (int i = 0; i < pom.getInstanceProblems().addThisFavorite.size(); i++) {
				if (pom.getInstanceProblems().addThisFavorite.get(i).isDisplayed()) {

					clickIntercept(pom.getInstanceProblems().addThisFavorite.get(i), 30);
					break;
				}
			}
		} catch (Exception e) {
			for (int i = 0; i < pom.getInstanceProblems().addThisFavorite.size(); i++) {
				if (pom.getInstanceProblems().addThisFavorite.get(i).isDisplayed()) {
					clickIntercept(pom.getInstanceProblems().addThisFavorite.get(i), 30);
					break;
				}
			}
		}

		try {
			visbility(driver, pom.getInstanceProblems().closeFavorite, 30);
			clickIntercept(pom.getInstanceProblems().closeFavorite, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceProblems().closeFavorite, 30);
			clickIntercept(pom.getInstanceProblems().closeFavorite, 30);
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
