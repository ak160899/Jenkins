package org.selectyourPlan3D;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class SelectYourPlan extends LaunchBrowser {

	String cardNumber;

	@BeforeClass
	private void selectYourPln() {

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
	}

	@Test(priority = 1)
	private void paymentPriceChecking() throws InterruptedException {

		try {
			WebElement basic = driver.findElement(By.xpath("//span[@id='monthlyBasicCardPlan']"));
			sleep(2000);
			if (basic.isDisplayed()) {
				visbility(driver, basic, 60);
				elementClickable(basic);
				click(basic);

			} else {
				WebElement $next = driver.findElement(By.xpath("(// span[@title='Next'])[2]"));
				visbility(driver, $next, 60);
				sleep(2000);
				actions("click", $next);
			}
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			paymentPriceChecking();
		}

		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);

	}

	// decline payment
	@Test(priority = 3)
	private void cardVerfivation() throws IOException {

		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().declinePayment());
		System.out.println("CARD NUMBER ENTERED");

		visbility(driver, pom.getInstanceCardDetails().expirydate, 50);
		sendkeys(pom.getInstanceCardDetails().expirydate, "424");
		visbility(driver, pom.getInstanceCardDetails().cvc, 50);
		sendkeys(pom.getInstanceCardDetails().cvc, "242");
		System.out.println("EXPIRY DATE AND CVC EBTERED");
		visbility(driver, pom.getInstanceCardDetails().postalCode, 50);
		sendkeys(pom.getInstanceCardDetails().postalCode, "42424");
		System.out.println("POSTAL CODE ENTERED");
		defaultcontent();
		visbility(driver, pom.getInstanceSelectYourPlan().activateSubscription, 50);
		elementClickable(pom.getInstanceSelectYourPlan().activateSubscription);
		click(pom.getInstanceSelectYourPlan().activateSubscription);

		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		while (true) {
			if (alertMessage.isDisplayed()) {

				break;
			}
		}
		System.out.println("Alert is shown");

		try {
			sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		refresh();

	}

	@Test(priority = 4)
	private void higRiskcard() throws InterruptedException, IOException {
		paymentPriceChecking();
		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().fraudPrevention());
		System.out.println("CARD NUMBER ENTERED");

		visbility(driver, pom.getInstanceCardDetails().expirydate, 50);
		sendkeys(pom.getInstanceCardDetails().expirydate, "424");
		visbility(driver, pom.getInstanceCardDetails().cvc, 50);
		sendkeys(pom.getInstanceCardDetails().cvc, "242");
		System.out.println("EXPIRY DATE AND CVC EBTERED");
		visbility(driver, pom.getInstanceCardDetails().postalCode, 50);
		sendkeys(pom.getInstanceCardDetails().postalCode, "42424");
		System.out.println("POSTAL CODE ENTERED");
		defaultcontent();
		visbility(driver, pom.getInstanceSelectYourPlan().activateSubscription, 50);
		elementClickable(pom.getInstanceSelectYourPlan().activateSubscription);
		click(pom.getInstanceSelectYourPlan().activateSubscription);

		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));
		while (true) {
			if (alertMessage.isDisplayed()) {

				break;
			}
		}
		System.out.println("Alert is shown");

		try {
			sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		refresh();

	}

	@Test(priority = 5)
	private void insufficient3dCardAuthenticationFail() throws InterruptedException, IOException {

		paymentPriceChecking();
		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().insufficient3dCard());
		System.out.println("CARD NUMBER ENTERED");

		visbility(driver, pom.getInstanceCardDetails().expirydate, 50);
		sendkeys(pom.getInstanceCardDetails().expirydate, "424");
		visbility(driver, pom.getInstanceCardDetails().cvc, 50);
		sendkeys(pom.getInstanceCardDetails().cvc, "242");
		System.out.println("EXPIRY DATE AND CVC EBTERED");
		visbility(driver, pom.getInstanceCardDetails().postalCode, 50);
		sendkeys(pom.getInstanceCardDetails().postalCode, "42424");
		System.out.println("POSTAL CODE ENTERED");
		defaultcontent();
		visbility(driver, pom.getInstanceSelectYourPlan().activateSubscription, 50);
		elementClickable(pom.getInstanceSelectYourPlan().activateSubscription);
		click(pom.getInstanceSelectYourPlan().activateSubscription);
		defaultcontent();
		System.out.println("before switching to frame");
		// sleep(30000);

		driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe")));
		System.out.println("??????????????????");
		// sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));
		System.out.println("Nested frame");
		// sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		System.out.println("nested 2");

		WebElement failAuthentication = driver.findElement(By.id("test-source-fail-3ds"));
		visbility(driver, failAuthentication, 50);
		elementClickable(failAuthentication);
		click(failAuthentication);

		defaultcontent();
		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));

		while (true) {

			if (alertMessage.isDisplayed()) {

				break;
			}
		}
		System.out.println("Alert is shown");

		try {
			sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		refresh();

	}

	@Test(priority = 6)
	private void insufficient3dCardAuthenticationPass() throws InterruptedException, IOException {
		paymentPriceChecking();
		frame("WebElement", pom.getInstanceCardDetails().switchToCardFrame);
		visbility(driver, pom.getInstanceCardDetails().cardNumber, 50);
		sendkeys(pom.getInstanceCardDetails().cardNumber,
				ConfigManager.getconfigManager().getInstanceConfigReader().insufficient3dCard());
		System.out.println("CARD NUMBER ENTERED");

		visbility(driver, pom.getInstanceCardDetails().expirydate, 50);
		sendkeys(pom.getInstanceCardDetails().expirydate, "424");
		visbility(driver, pom.getInstanceCardDetails().cvc, 50);
		sendkeys(pom.getInstanceCardDetails().cvc, "242");
		System.out.println("EXPIRY DATE AND CVC EBTERED");
		visbility(driver, pom.getInstanceCardDetails().postalCode, 50);
		sendkeys(pom.getInstanceCardDetails().postalCode, "42424");
		System.out.println("POSTAL CODE ENTERED");
		defaultcontent();
		visbility(driver, pom.getInstanceSelectYourPlan().activateSubscription, 50);
		elementClickable(pom.getInstanceSelectYourPlan().activateSubscription);
		click(pom.getInstanceSelectYourPlan().activateSubscription);
		defaultcontent();
		System.out.println("before switching to frame");
		// sleep(30000);

		driver.switchTo().frame(driver.findElement(By.xpath("//body[@id='body']/div[1]/iframe")));
		System.out.println("??????????????????");
		sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='LightboxModalContent']/div/iframe")));
		System.out.println("Nested frame");
		sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//form[@id='form']//following::iframe")));
		System.out.println("nested 2");

		WebElement failAuthentication = driver.findElement(By.id("test-source-authorize-3ds"));
		visbility(driver, failAuthentication, 50);
		elementClickable(failAuthentication);
		click(failAuthentication);

		defaultcontent();
		WebElement alertMessage = driver.findElement(By.xpath("(//div[@id='bootstrap-alert'])[1]/div[1]/div"));

		while (true) {

			if (alertMessage.isDisplayed()) {

				break;
			}
		}
		System.out.println("Alert is shown");

		try {
			sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		refresh();

	}

	@Test(priority = 7)
	private void litePackage() throws InterruptedException {
		boolean cond = false;
		try {
			WebElement lite = driver.findElement(By.xpath("//span[@id='liteCardPlan']"));
			sleep(2000);
			if (lite.isDisplayed()) {
				visbility(driver, lite, 60);
				elementClickable(lite);
				click(lite);
				cond = true;

			} else {
				WebElement $next = driver.findElement(By.xpath("(// span[@title='Next'])[2]"));
				visbility(driver, $next, 60);
				sleep(2000);
				actions("click", $next);
			}
		} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			litePackage();

		}

		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);

	}
}
