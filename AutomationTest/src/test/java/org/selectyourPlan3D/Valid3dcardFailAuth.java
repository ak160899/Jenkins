package org.selectyourPlan3D;

import java.io.IOException;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Valid3dcardFailAuth extends LaunchBrowser {

	public static void valid3dCard() throws IOException {

		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		log.info("switched to frame");
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);

		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().getvalid3dCard());
		log.info("card number entered");
		visbility(driver, pom.getInstanceCardDetails().expirydate, 50);

		sendkeys(pom.getInstanceCardDetails().expirydate, "424");
		log.info("expiry date entered");
		visbility(driver, pom.getInstanceCardDetails().cvc, 50);

		sendkeys(pom.getInstanceCardDetails().cvc, "242");
		log.info("cvc entered");
		visbility(driver, pom.getInstanceCardDetails().postalCode, 50);

		sendkeys(pom.getInstanceCardDetails().postalCode, "42424");
		log.info("postal code entered");
		defaultcontent();
		log.info("switched to default content");
		visbility(driver, pom.getInstanceSelectYourPlan().activateSubscription, 50);
		elementClickable(pom.getInstanceSelectYourPlan().activateSubscription);
		click(pom.getInstanceSelectYourPlan().activateSubscription);
		log.info("Activate Subscription clicked");

	}

	public void failAuthentication() {
		log.info("valid card authenwindow");

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
		WebElement failAuthentication = driver.findElement(By.id("test-source-fail-3ds"));
		visbility(driver, failAuthentication, 50);
		elementClickable(failAuthentication);
		click(failAuthentication);
		log.info("fail authentication clicked");

		defaultcontent();

	}

	public void validCardFailAuthAlert() {
		log.info("verify alert valid 3d card ");
		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		if (alertMessage.isDisplayed()) {
			String alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess,
					"We are unable to authenticate your payment method. Please choose a different payment method and try again.");
			log.info("alert is displayed :" + alertMess);
		}

	}

	@Test
	public void verifyValid3dCardFailAuthentication() throws IOException {
		valid3dCard();
		failAuthentication();
		validCardFailAuthAlert();

	}

}
