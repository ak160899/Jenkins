package com.healthRec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.Launch.LaunchBrowser;
import org.base.*;

public class Tc_026_FollowUpEhr extends LaunchBrowser {

	@Test
	public static void $createFollowup() throws Throwable {

		j.executeScript("window.scroll(0,0)");

		try {
			clickIntercept(pom.getInstanceFollowUp().createFollowUp, 30);
		} catch (Exception e) {
			clickIntercept(pom.getInstanceFollowUp().createFollowUp, 30);
		}

		implicitWait(30, TimeUnit.SECONDS);

		clickIntercept(pom.getInstanceFollowUp().dateField, 30);

		sleep(2000);

		dropDown("text", pom.getInstanceFollowUp().year, "2023");
		dropDown("text", pom.getInstanceFollowUp().month, "Dec");
		clickIntercept(pom.getInstanceFollowUp().date, 30);
		visbility(driver, pom.getInstanceFollowUp().fixAppointment, 30);
		clickIntercept(pom.getInstanceFollowUp().fixAppointment, 30);

		List<WebElement> tot = driver.findElements(By.xpath("(//div[@id='date-data'])[1]"));
		int total = tot.size();

		implicitWait(30, TimeUnit.SECONDS);

		boolean b = false;
		for (int i = 1; i <= total; i++) {
			sleep(3000);
			List<WebElement> rowsCount = driver
					.findElements(By.xpath("(//div[@id='formAppointment'])[2]/div/div[2]/div[2]/div[2]/div"));

			for (int j = 1; j <= rowsCount.size(); j++) {

				WebElement TimeSlot = driver
						.findElement(By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + j + "]/div/div[1]"));

				WebElement id = driver
						.findElement(By.xpath("(//div[@id='date-data'])[1]/div[2]/div[" + j + "]/div/div[2]/span[3]"));

				if (TimeSlot.isDisplayed() && id.getText().isEmpty()) {
					b = true;
					clickIntercept(TimeSlot, 30);
					break;

				}

			}
			if (b == true) {

				visbility(driver, pom.getInstanceFollowUp().appointmnetType, 40);
				clickIntercept(pom.getInstanceFollowUp().appointmnetType, 30);

				for (WebElement webElement : pom.getInstanceFollowUp().appointmentTypeDropdown) {

					if (webElement.getText().equals("Emergency")) {

						visbility(driver, webElement, 60);
						clickIntercept(webElement, 30);
					}

				}

				clear(pom.getInstanceFollowUp().discription);
				sendkeys(pom.getInstanceFollowUp().discription, "FOLLOW UP EHR");
				clickIntercept(pom.getInstanceFollowUp().saveFollowup, 30);
				sleep(3000);

				actions("move to element", pom.getInstanceFollowUp().deleteAppointment);
				clickIntercept(pom.getInstanceFollowUp().deleteAppointment, 30);
				clickIntercept(pom.getInstanceFollowUp().closeFollowup, 30);

				break;
			}
		}
	}

}
