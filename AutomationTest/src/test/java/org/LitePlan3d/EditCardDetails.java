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

import com.data.ConfigManager;

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

		
			sleep(3000);
		
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

	@Test(priority = 2, groups = { "lite" }, enabled = false)
	private void goToPayemntpageAddIncorrectCvc() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(3000);
		driver.navigate().to("https://localhost:8443/health/#allPaymentServices");

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

	@Test(priority = 3, groups = { "lite" }, enabled = false)
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
			
				sleep(2500);
			
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

	@Test(priority = 4, enabled = false, groups = { "lite" })
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

	@Test(priority = 5, groups = { "lite" }, enabled = false)
	private void verify3dcardInPayementPageAndEditCardDetails() throws InterruptedException {

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

		
			sleep(5000);
		
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(3000);
		driver.navigate().to("https://localhost:8443/health/#allPaymentServices");
		sleep(3000);
		j.executeScript("window.scrollBy(0,-350)", "");
		sleep(3000);
		// System.out.println("carosel enter");

		Carosel.basicCaroselUi();

		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);

	}

	@Test(priority = 6, groups = { "lite" }, enabled = false)
	private void verifySubscriptionWithoutCvc() {
		visbility(driver, pom.getLite().updateSubscription, 40);
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

	@Test(priority = 7, groups = { "lite" }, enabled = false)
	private void verify3dCardAndCompleteIt() throws IOException, InterruptedException {

		visbility(driver, pom.getLite().cardFieldEdit, 40);
		elementClickable(pom.getLite().cardFieldEdit);
		click(pom.getLite().cardFieldEdit);
		Valid3dcardFailAuth.valid3dCard();
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
		WebElement complteAuthentication = driver.findElement(By.id("test-source-authorize-3ds"));
		visbility(driver, complteAuthentication, 50);
		elementClickable(complteAuthentication);
		click(complteAuthentication);
		log.info("pass authentication clicked");

		defaultcontent();
		try {
			visbility(driver, pom.getLite().finishLite, 50);
			elementClickable(pom.getLite().finishLite);
			click(pom.getLite().finishLite);
			log.info("finish lite button clicked");
		} catch (Exception e) {
			visbility(driver, pom.getLite().finishLite, 50);
			elementClickable(pom.getLite().finishLite);
			click(pom.getLite().finishLite);
			log.info("finish lite button clicked");
		}

	}

	@Test(priority = 1, groups = { "lite" }, enabled = false)
	public static void editCardLite() throws Exception {
		Carosel.basicCaroselUi();
		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		Valid3dcardFailAuth.valid3dCard();
		Valid3dcardFailAuth.failAuthentication();

		cardEdit();

	}

	// basic to premium55

	@Test(priority = 8, groups = { "basic" })
	private void checkRecent3dCardUpdateInCardDetail() throws InterruptedException {
		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		elementClickable(pom.getInstanceSetting().clickSettings);
		click(pom.getInstanceSetting().clickSettings);
		sleep(2500);
		ScriptExecutor(pom.getInstanceSetting().clickactiveuserpage);
		sleep(2500);

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

	@Test(priority = 9, groups = { "basic" })
	private void goToMarketPlaceAndGiveValidCvCAndCancel() {

		visbility(driver, pom.getInstanceSetting().$marketplace, 40);
		elementClickable(pom.getInstanceSetting().$marketplace);
		click(pom.getInstanceSetting().$marketplace);

		log.info("market place clicked");
		
			sleep(3000);
		
		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 40);
		elementClickable(pom.getInstanceSetting().$eirsystembutton$);
		click(pom.getInstanceSetting().$eirsystembutton$);
		log.info("eir system clciked");
		
			sleep(3000);
		
		visbility(driver, pom.getInstanceSelectYourPlan().dismis, 40);
		elementClickable(pom.getInstanceSelectYourPlan().dismis);
		click(pom.getInstanceSelectYourPlan().dismis);
		log.info("Alert kpop handled");
		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		log.info("proceed payemnt clicked");
		frame("WebElement", pom.getLite().switchToCvcfieldFrame);

		visbility(driver, pom.getInstanceCardDetails().cvc, 40);
		sendkeys(pom.getInstanceCardDetails().cvc, "1222");

		defaultcontent();

		elementClickable(pom.getLite().updateSubscription);
		click(pom.getLite().updateSubscription);
		Valid3dcard_cancel.cancellAutheticationWindow();

	}

	@Test(priority = 10, groups = { "basic" })
	private void verifytheCardWithInavlid3d_basic() throws IOException {
		visbility(driver, pom.getLite().cardFieldEdit, 40);
		elementClickable(pom.getLite().cardFieldEdit);
		click(pom.getLite().cardFieldEdit);

		Insufficient3dCard.insufficnetcardDetails();

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
		WebElement complteAuthentication = driver.findElement(By.id("test-source-authorize-3ds"));
		visbility(driver, complteAuthentication, 50);
		elementClickable(complteAuthentication);
		click(complteAuthentication);
		log.info("pass authentication clicked");

		defaultcontent();
		
			sleep(6000);
		
	}

	@Test(priority = 11)
	private void giveValid3dCardAndCancelit() throws IOException {

		Valid3dcardFailAuth.valid3dCard();

		Valid3dcard_cancel.cancellAutheticationWindow();

	}

	@Test(priority = 12)
	private void goToOutsideLoginAAndCheckThe3dcardUpdate() {

		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		j.executeScript("window.scrollBy(0,-950)", "");
		
			sleep(2500);
		
		try {
			WebElement link = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a"));
			visbility(driver, link, 40);
			elementClickable(link);
			click(link);
		} catch (ElementClickInterceptedException e) {
			WebElement link = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a"));
			visbility(driver, link, 40);
			elementClickable(link);
			click(link);
		}
		
			sleep(2000);
		

		j.executeScript("window.scrollBy(0,950)", "");

	}

	@Test(priority = 13)
	private void verifyWithInvalidCvC() {

		frame("WebElement", pom.getInstanceBasic().switchToCvcFrame);

		visbility(driver, pom.getInstanceCardDetails().cvc, 40);
		sendkeys(pom.getInstanceCardDetails().cvc, "12");

		defaultcontent();
		visbility(driver, pom.getInstanceBasic().upgradePlan, 40);
		click(pom.getInstanceBasic().upgradePlan);
		log.info("verify alert");

		WebElement alertMessage = pom.getInstanceBasic().verifyAlertcvc;

		if (alertMessage.isDisplayed()) {
			String alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess, "Your card's security code is incomplete.");
			log.info(alertMess);
		}
		
			sleep(2500);
		
		visbility(driver, pom.getInstanceSelectYourPlan().accept, 40);
		click(pom.getInstanceSelectYourPlan().accept);

		
			sleep(2000);
		
		driver.navigate().refresh();
	}

	@Test(priority = 14)
	private void verifyDeclinedCard() throws IOException {
		visbility(driver, pom.getInstanceBasic().editCard, 30);
		elementClickable(pom.getInstanceBasic().editCard);
		click(pom.getInstanceBasic().editCard);
		log.info("ENTER basic");

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
		log.info("switch out");

		visbility(driver, pom.getInstanceBasic().upgradeDetails, 40);
		elementClickable(pom.getInstanceBasic().upgradeDetails);
		click(pom.getInstanceBasic().upgradeDetails);
		log.info("verify alert");

		WebElement alertMessage = pom.getInstanceBasic().verifyAlertcvc;

		if (alertMessage.isDisplayed()) {
			String alertMess = alertMessage.getText();

			Assert.assertEquals(alertMess, "Your card was declined.");
			log.info(alertMess);
		}
		
			sleep(2500);
		
		visbility(driver, pom.getInstanceSelectYourPlan().accept, 40);
		click(pom.getInstanceSelectYourPlan().accept);

	}

	@Test(priority = 15)
	private void giveValid3dCardAndFailIt() throws IOException {
		visbility(driver, pom.getInstanceBasic().editCard, 40);
		elementClickable(pom.getInstanceBasic().editCard);
		click(pom.getInstanceBasic().editCard);
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

		visbility(driver, pom.getInstanceBasic().upgradeDetails, 40);
		elementClickable(pom.getInstanceBasic().upgradeDetails);
		click(pom.getInstanceBasic().upgradeDetails);
		Valid3dcardFailAuth.failAuthentication();
	}

}
