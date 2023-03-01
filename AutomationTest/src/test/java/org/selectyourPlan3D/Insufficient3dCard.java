package org.selectyourPlan3D;

import java.io.IOException;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Insufficient3dCard extends LaunchBrowser {

	public static void insufficnetcardDetails() throws IOException {

		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		log.info("switched to frame");
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		clear(pom.getInstanceCardDetails().cardNumber);
		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().insufficient3dCard());
		log.info("card number entered");
		visbility(driver, pom.getInstanceCardDetails().expirydate, 50);
		clear(pom.getInstanceCardDetails().expirydate);
		sendkeys(pom.getInstanceCardDetails().expirydate, "424");
		log.info("expiry date entered");
		visbility(driver, pom.getInstanceCardDetails().cvc, 50);
		clear(pom.getInstanceCardDetails().cvc);
		sendkeys(pom.getInstanceCardDetails().cvc, "242");
		log.info("cvc entered");
		visbility(driver, pom.getInstanceCardDetails().postalCode, 50);
		clear(pom.getInstanceCardDetails().postalCode);
		sendkeys(pom.getInstanceCardDetails().postalCode, "42424");
		log.info("postal code entered");
		defaultcontent();
		log.info("switched to default content");
		visbility(driver, pom.getInstanceSelectYourPlan().activateSubscription, 50);
		elementClickable(pom.getInstanceSelectYourPlan().activateSubscription);
		click(pom.getInstanceSelectYourPlan().activateSubscription);
		log.info("Activate Subscription clicked");

	}

	public static void authenticationWindow() throws InterruptedException {

		sleep(30000);
		try {
			WebElement frame = driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe"));
			visbility(driver, frame, 50);

		} catch (Exception e) {
			WebElement frame = driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe"));
			visbility(driver, frame, 50);
			driver.switchTo().frame((frame));
		}
		try {
			visbility(driver, driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")), 50);
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));
		} catch (Exception e) {
			visbility(driver, driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")), 50);
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));
		}
		try {
			visbility(driver, driver.findElement(By.xpath("//form[@id='form']//following::iframe")), 50);
			driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		} catch (Exception e) {
			visbility(driver, driver.findElement(By.xpath("//form[@id='form']//following::iframe")), 50);
			driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		}
		WebElement failAuthentication = driver.findElement(By.id("test-source-authorize-3ds"));
		visbility(driver, failAuthentication, 50);
		elementClickable(failAuthentication);
		click(failAuthentication);
		log.info("complte authentication clicked");

		defaultcontent();

	}

	public void verifyInsufficient3dCardAlert() {
		log.info("verify alert");
		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		if (alertMessage.isDisplayed()) {
			String alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess, "Your card has insufficient funds.");
			log.info("alert is displayed :" + alertMess);
		}

	}

	@Test
	public void insufficinet3dCardVerify() throws IOException, InterruptedException {
		insufficnetcardDetails();
		authenticationWindow();
		verifyInsufficient3dCardAlert();

	}
}
