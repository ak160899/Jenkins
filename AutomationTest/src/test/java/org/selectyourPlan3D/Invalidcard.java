package org.selectyourPlan3D;

import java.io.IOException;

import org.Launch.LaunchBrowser;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.data.ConfigManager;

public class Invalidcard extends LaunchBrowser {

	static Logger log;

	public static void selectYourPln() {
		log = Logger.getLogger(Invalidcard.class);
		BasicConfigurator.configure();
		try {
			visbility(driver, pom.getInstanceSelectYourPlan().dismiss, 60);
			elementClickable(pom.getInstanceSelectYourPlan().dismiss);
			click(pom.getInstanceSelectYourPlan().dismiss);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSelectYourPlan().dismiss, 60);
			elementClickable(pom.getInstanceSelectYourPlan().dismiss);
			click(pom.getInstanceSelectYourPlan().dismiss);
		}

		driver.navigate().to("https://localhost:8443/health/#allPaymentServices");
		log.info("Navigated to payment page");

		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		log.info("proceed payment clicked");

	}

	public void cardDetails() throws IOException {

		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		log.info("switched to frame");
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().declinePayment());
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

	public static String verifyAlert() {
		log.info("verify alert");
		String alertMess ="";
		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		System.out.println(alertMessage.getText());

		if (alertMessage.isDisplayed()) {
			alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess, "Your card was declined.");
			log.info("alert is displayed");
		}
		return alertMess;

	}

	@Test
	public void invalidCardVerify() throws IOException {

		selectYourPln();
		cardDetails();
		verifyAlert();

	}

}
