package org.selectyourPlan3D;

import java.io.IOException;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Valid3dcard_cancel extends LaunchBrowser {

	public static void cancellAutheticationWindow() throws NoSuchElementException {

		log.info("valid card authenwindow");

		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		} catch (NoSuchElementException e) {
			
				sleep(2500);
			
			driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		}

		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		try {
			WebElement cancelAuthWindow = driver.findElement(By.xpath("//button[@class='LightboxModalClose']"));
			visbility(driver, cancelAuthWindow, 40);
			elementClickable(cancelAuthWindow);
			click(cancelAuthWindow);
			log.info("authentication window closed");
		} catch (WebDriverException e) {
			WebElement cancelAuthWindow = driver.findElement(By.xpath("//button[@class='LightboxModalClose']"));
			visbility(driver, cancelAuthWindow, 50);
			elementClickable(cancelAuthWindow);
			click(cancelAuthWindow);
			log.info("authentication window closed");
		}
		defaultcontent();

	}

	@Test(priority = 1)
	private void pagenavigate() {
		driver.navigate().refresh();
		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);
	}

	@Test(priority = 2)
	private void cancelAuthentication3dWindow() throws IOException {

		Valid3dcardFailAuth.valid3dCard();
		cancelAuthentication3dWindow();
	}

}
