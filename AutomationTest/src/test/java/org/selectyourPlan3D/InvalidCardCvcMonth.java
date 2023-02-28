package org.selectyourPlan3D;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class InvalidCardCvcMonth extends LaunchBrowser {

	public void CheckFails(String cvcFail) {
		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		log.info("switched to frame");
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		clear(pom.getInstanceCardDetails().cardNumber);
		sendkeys(pom.getInstanceCardDetails().cardNumber, cvcFail);
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

	public void verifyAlert(String alert) {
		boolean check = false;
		log.info("verify alert");
		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		if (alertMessage.isDisplayed()) {
			String alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess, alert);
			log.info("alert is displayed :" + alertMess);
			check = true;
		}

		while (check) {

			if (alertMessage.isDisplayed()) {
				//System.out.println("Alertj");

				
			} else {
				System.out.println("Alert  not is displayed");
				break;
			}

		}

		log.info("exit the content");
	}

	@Test(priority = 1)
	private void cvcFails() {

		log.info("check fail cvc");
		CheckFails(ConfigManager.getconfigManager().getInstanceConfigReader().getCvcfail());
		verifyAlert("Your card's security code is incorrect.");

		log.info("check expire card");
		CheckFails(ConfigManager.getconfigManager().getInstanceConfigReader().getExpiredCard());
		verifyAlert("Your card has expired.");

	}

	@Test(priority = 2)
	private void postalFails() {

		log.info("postal fail");
		CheckFails(ConfigManager.getconfigManager().getInstanceConfigReader().getPostalFail());
		verifyAlert("The zip code you supplied failed validation.");

	}

	@Test(priority = 3)
	private void yearExpired() {

		log.info("check expire card");
		CheckFails(ConfigManager.getconfigManager().getInstanceConfigReader().getExpiredCard());
		verifyAlert("Your card has expired.");

	}

}
