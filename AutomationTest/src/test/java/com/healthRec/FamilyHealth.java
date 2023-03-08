package com.healthRec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.Launch.LaunchBrowser;
import org.base.*;
import com.pageObjeman.PageObjMan;

public class FamilyHealth extends LaunchBrowser {

	public void $familH() {
		WebElement a = driver.findElement(By.xpath("//div[contains(@title,'Add Family Health')]"));

		actions("move to element", a);
		visbility(driver, a, 60);

		actions("click", a);
		WebElement ee = driver.findElement(By.xpath("//div[@id='Family_HealthKpop2']/div[2]/div/select"));
		visbility(driver, ee, 60);
		ee.click();
		dropDown("text", ee, "Half Brother");

		WebElement fh = driver.findElement(
				By.xpath("//div[@id='Family_HealthKpop2']/div[2]/div/select//following::div[1]/div[2]/input"));
		visbility(driver, fh, 60);
		fh.sendKeys("24781");
		List<WebElement> fhkpop;

		while (true) {
			fhkpop = driver.findElements(By.xpath("//div[@id='Family_HealthKpop2']/div[2]/ul/li/a/div/small"));

			// System.out.println("element has been finded.." + "size is:" + fhkpop.size());
			if (fhkpop.size() > 5) {

				break;
			}

		}
		boolean $familcond$ = false;
		for (WebElement web : fhkpop) {

			if (web.getText().trim().equals("ICD10 : F40.2 | SNOMED : 247810008")) {
				$familcond$ = true;
				visbility(driver, web, 60);
				click(web);

				break;
			}

		}
		if ($familcond$ == true) {
			WebElement atf = driver.findElement(By.xpath("//button[@id='btnSaveAdd']"));
			visbility(driver, atf, 60);
			javascriptclick(atf);
			List<WebElement> rr = driver.findElements(By.xpath("//div[@id='saveadd-btn']/ul/li"));
			for (WebElement w : rr) {

				if (w.getText().trim().equals("Save")) {
					visbility(driver, w, 60);
					w.click();
					break;
				}

			}
		}

		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void familyHealthIcd() {
		boolean check = false;
		

		try {

			if (pom.getInstanceFamilyHaelth().icdDropdown.size() <= 2) {
				System.out.println(">=2 " + pom.getInstanceFamilyHaelth().icdDropdown.size());
				check = true;

			}
		} catch (Exception e) {

		}

		System.out.println("exit fh");

		if (check == true) {
			for (WebElement web : pom.getInstanceFamilyHaelth().icdDropdown) {
				System.out.println("ENTER");
				System.out.println(web.getText());
				if (web.getText().equals("ICD10 : F40.2 | SNOMED : 247810008") && web.isDisplayed()) {
					visbility(driver, web, 60);
					elementClickable(web);
					click(web);
					System.out.println("FAMILY HEALTH ");
					check = true;
					break;
				}

			}
		}
		if (check == false) {
			familyHealthIcd();
		}

	}

}
