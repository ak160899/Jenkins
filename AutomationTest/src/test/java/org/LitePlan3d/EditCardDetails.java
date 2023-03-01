package org.LitePlan3d;

import java.io.IOException;

import org.Launch.LaunchBrowser;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.selectyourPlan3D.Insufficient3dCard;
import org.selectyourPlan3D.Invalidcard;
import org.selectyourPlan3D.Valid3dcardFailAuth;
import org.selectyourPlan3D.Valid3dcard_cancel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditCardDetails extends LaunchBrowser {

	private static void cardEdit() {
		driver.navigate().to("https://localhost:8443/health/#setting");
		try {
			WebElement editcard = driver.findElement(By.xpath("//button[@id='update-card']"));
			visbility(driver, editcard, 40);
			elementClickable(editcard);
			click(editcard);
			log.info("edit card clicked");
		} catch (Exception e) {
			WebElement editcard = driver.findElement(By.xpath("//button[@id='update-card']"));
			visbility(driver, editcard, 40);
			elementClickable(editcard);
			click(editcard);
			log.info("edit card clicked");
		}

		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement updateButton = driver.findElement(By.xpath("(//button[@id='update-btn'])[1]"));
		visbility(driver, updateButton, 40);
		elementClickable(updateButton);
		click(updateButton);
		log.info("update button clicked");
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='subscription-card-element']/div/iframe")));

		WebElement crdNum = driver.findElement(By.name("cardnumber"));
		sendkeys(crdNum, "4000002500003155");

		driver.findElement(By.name("exp-date")).sendKeys("424");
		driver.findElement(By.name("cvc")).sendKeys("242");
		driver.findElement(By.name("postal")).sendKeys("42424");
		log.info("card details entered");

		defaultcontent();

		WebElement saveCardDetails = driver
				.findElement(By.xpath("(//div[@id='subscription-updateCard']//following::button[2])[1]"));
		visbility(driver, saveCardDetails, 50);
		elementClickable(saveCardDetails);
		click(saveCardDetails);
		log.info("card detail added");

	}

	@Test(priority = 2)
	private void goToPayemntpageAddIncorrectCvc() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(3000);
		driver.navigate().to("https://localhost:8443/health/#allPaymentServices");
		/*
		 * try { WebElement link =
		 * driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a"));
		 * visbility(driver, link, 40); elementClickable(link); click(link); } catch
		 * (ElementClickInterceptedException e) { WebElement link =
		 * driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a"));
		 * visbility(driver, link, 40); elementClickable(link); click(link); }
		 */

		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);

		frame("WebElement", pom.getLite().switchToCvcfieldFrame);

		visbility(driver, pom.getInstanceCardDetails().cvc, 40);
		sendkeys(pom.getInstanceCardDetails().cvc, "12");

		defaultcontent();

		elementClickable(pom.getLite().updateSubscription);
		click(pom.getLite().updateSubscription);

		log.info("verify alert");

		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		// System.out.println(alertMessage.getText());

		if (alertMessage.isDisplayed()) {
			String alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess, "Your card's security code is incomplete.");
			log.info(alertMess);
		}
	}

	@Test(priority = 3)
	private void editCardWithInvalidAndVerfiy() throws IOException, InterruptedException {
		visbility(driver, pom.getLite().cardFieldEdit, 40);
		elementClickable(pom.getLite().cardFieldEdit);
		click(pom.getLite().cardFieldEdit);
		Insufficient3dCard.insufficnetcardDetails();
		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		} catch (NoSuchElementException e) {
			try {
				sleep(2500);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
			driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));

			driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		}

		WebElement failAuthentication = driver.findElement(By.id("test-source-authorize-3ds"));
		visbility(driver, failAuthentication, 50);
		elementClickable(failAuthentication);
		click(failAuthentication);
		log.info("complte authentication clicked");

		defaultcontent();
		sleep(6000);

	}

	@Test(priority = 4)
	private void giveValid3dCardCancelAndVerify() throws IOException, InterruptedException {
		sleep(3000);
		Valid3dcardFailAuth.valid3dCard();
		sleep(3000);

		Valid3dcard_cancel.cancellAutheticationWindow();

		driver.navigate().to("https://localhost:8443/health/#setting");
		try {
			WebElement editcard = driver.findElement(By.xpath("//button[@id='update-card']"));
			visbility(driver, editcard, 40);
			elementClickable(editcard);
			click(editcard);
			log.info("edit card clicked");
		} catch (Exception e) {
			WebElement editcard = driver.findElement(By.xpath("//button[@id='update-card']"));
			visbility(driver, editcard, 40);
			elementClickable(editcard);
			click(editcard);
			log.info("edit card clicked");
		}

	}

	@Test(priority = 1)
	public static void editCardLite() throws Exception {
		Carosel.basicCaroselUi();
		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		Valid3dcardFailAuth.valid3dCard();
		Valid3dcardFailAuth.failAuthentication();

		cardEdit();

	}
}
