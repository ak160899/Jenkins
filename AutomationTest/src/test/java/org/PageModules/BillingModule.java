package org.PageModules;

import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.data.ConfigManager;

public class BillingModule extends LaunchBrowser {

	@Test
	public static void BillingModue() {
		implicitWait(50, TimeUnit.SECONDS);
		visbility(driver, pom.getInstanceBilling().clickBill, 60);

		clickIntercept(pom.getInstanceBilling().clickBill, 30);

		driver.navigate().refresh();
		implicitWait(50, TimeUnit.SECONDS);
		sleep(3000);

		createInvoice();
		sleep(2500);
		favoriteItemService();

		sleep(2500);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			itemServiceCode();

			sleep(2000);

			ServiceChargeAndTax();
			sleep(2000);

			discount();
			sleep(2000);
		}
		addPayment();

		sleep(2000);

		finalizeBill();
		sleep(2000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			visbility(driver, pom.getInstanceBilling().deleteInvoice, 60);
			clickIntercept(pom.getInstanceBilling().deleteInvoice, 30);
			sleep(2000);

			visbility(driver, pom.getInstanceBilling().deleteInvoiceConfirmationKpop, 60);
			clickIntercept(pom.getInstanceBilling().deleteInvoiceConfirmationKpop, 30);
		}
		sleep(2000);

		clickIntercept(pom.getInstanceBilling().clickBill, 30);

		driver.navigate().refresh();

		try {

			visbility(driver, pom.getInstanceBilling().searchPatientBy, 60);
			sendkeys(pom.getInstanceBilling().searchPatientBy, kpid);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().searchPatientBy, 60);
			sendkeys(pom.getInstanceBilling().searchPatientBy, kpid);
		}

		sleep(2000);

		for (WebElement we : pom.getInstanceBilling().searchPatientDropdown) {
			if (we.getText().trim().equals(kpid)) {
				visbility(driver, we, 60);
				clickIntercept(we, 30);
				break;
			}

		}
		createInvoice();
		sleep(2000);
	}

	public static void createInvoice() {
		try {
			visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
			clickIntercept(pom.getInstanceBilling().clickCreateNewBill, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
			clickIntercept(pom.getInstanceBilling().clickCreateNewBill, 30);
		}

		try {
			visbility(driver, pom.getInstanceBilling().addItem, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().addItem));
			click(pom.getInstanceBilling().addItem);
			visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		} catch (ElementClickInterceptedException e) {
			visbility(driver, pom.getInstanceBilling().addItem, 60);
			ww.until(ExpectedConditions.elementToBeClickable(pom.getInstanceBilling().addItem));
			click(pom.getInstanceBilling().addItem);
			visbility(driver, pom.getInstanceBilling().enterTheItem, 60);
		}
		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo");
		visbility(driver, pom.getInstanceBilling().addPrice, 60);
		sendkeys(pom.getInstanceBilling().addPrice, "10");
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		clear(pom.getInstanceBilling().addQuantity);
		visbility(driver, pom.getInstanceBilling().addQuantity, 60);
		sendkeys(pom.getInstanceBilling().addQuantity, "2");

		visbility(driver, pom.getInstanceBilling().saveItem, 60);
		clickIntercept(pom.getInstanceBilling().saveItem, 30);

	}

	public static void favoriteItemService() {

		try {

			visbility(driver, pom.getInstanceBilling().favoriteItemServiceUi, 40);
			clickIntercept(pom.getInstanceBilling().favoriteItemServiceUi, 30);
		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceBilling().favoriteItemServiceUi, 40);
			clickIntercept(pom.getInstanceBilling().favoriteItemServiceUi, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 40);
			clickIntercept(pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 30);
		} catch (StaleElementReferenceException e) {

			visbility(driver, pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 60);
			clickIntercept(pom.getInstanceBilling().addNewFavoriteItemServiceAddIcon, 30);
		}

		visbility(driver, pom.getInstanceBilling().favoriteItemServiceDiscription, 60);
		sendkeys(pom.getInstanceBilling().favoriteItemServiceDiscription, "Kaaspro");

		visbility(driver, pom.getInstanceBilling().favoriteItemServicePriceField, 60);
		sendkeys(pom.getInstanceBilling().favoriteItemServicePriceField, "3");

		visbility(driver, pom.getInstanceBilling().favoriteItemServiceSave, 60);
		clickIntercept(pom.getInstanceBilling().favoriteItemServiceSave, 30);

		sleep(2500);

		try {

			clickIntercept(pom.getInstanceBilling().addFavoriteItemserviceToBillList, 30);
		} catch (Exception e) {
			clickIntercept(pom.getInstanceBilling().addFavoriteItemserviceToBillList, 30);

		}

		try {

			visbility(driver, pom.getInstanceBilling().editFavoriteItemservice, 60);
			clickIntercept(pom.getInstanceBilling().editFavoriteItemservice, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().editFavoriteItemservice, 60);
			clickIntercept(pom.getInstanceBilling().editFavoriteItemservice, 30);
		}

		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().deleteFavoriteItemService, 60);
			clickIntercept(pom.getInstanceBilling().deleteFavoriteItemService, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().deleteFavoriteItemService, 60);
			clickIntercept(pom.getInstanceBilling().deleteFavoriteItemService, 30);
		}

	}

	public static void itemServiceCode() {
		try {

			visbility(driver, pom.getInstanceBilling().favoriteItemseriveCodeUi, 60);

			clickIntercept(pom.getInstanceBilling().favoriteItemseriveCodeUi, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().favoriteItemseriveCodeUi, 60);

			clickIntercept(pom.getInstanceBilling().favoriteItemseriveCodeUi, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().itemServiceCodeAddIcon, 60);

			clickIntercept(pom.getInstanceBilling().itemServiceCodeAddIcon, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemServiceCodeAddIcon, 60);

			clickIntercept(pom.getInstanceBilling().itemServiceCodeAddIcon, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().enterItemServiceCode, 60);
			sendkeys(pom.getInstanceBilling().enterItemServiceCode, "product001");

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().enterItemServiceCode, 60);
			sendkeys(pom.getInstanceBilling().enterItemServiceCode, "product001");
		}

		visbility(driver, pom.getInstanceBilling().itemserviceCodeDiscription, 60);
		sendkeys(pom.getInstanceBilling().itemserviceCodeDiscription, "sr");

		visbility(driver, pom.getInstanceBilling().itemservicecodePrice, 60);
		sendkeys(pom.getInstanceBilling().itemservicecodePrice, "5");

		try {

			visbility(driver, pom.getInstanceBilling().itemservicecodeSave, 60);
			clickIntercept(pom.getInstanceBilling().itemservicecodeSave, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().itemservicecodeSave, 60);
			clickIntercept(pom.getInstanceBilling().itemservicecodeSave, 30);
		}

		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().itemservicecodeAddToBillList, 60);

			clickIntercept(pom.getInstanceBilling().itemservicecodeAddToBillList, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemservicecodeAddToBillList, 60);

			clickIntercept(pom.getInstanceBilling().itemservicecodeAddToBillList, 30);
		}

		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().itemservicecodeEdit, 60);

			clickIntercept(pom.getInstanceBilling().itemservicecodeEdit, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemservicecodeEdit, 60);

			clickIntercept(pom.getInstanceBilling().itemservicecodeEdit, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().itemservicecodeDelete, 60);

			clickIntercept(pom.getInstanceBilling().itemservicecodeDelete, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemservicecodeDelete, 60);

			clickIntercept(pom.getInstanceBilling().itemservicecodeDelete, 30);

		}

	}

	public static void ServiceChargeAndTax() {
		try {

			visbility(driver, pom.getInstanceBilling().itemservicechargesUi, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesUi, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemservicechargesUi, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesUi, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().itemservicechargesAddIcon, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesAddIcon, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().itemservicechargesAddIcon, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesAddIcon, 30);
		}

		visbility(driver, pom.getInstanceBilling().itemservicechargesDiscription, 60);
		sendkeys(pom.getInstanceBilling().itemservicechargesDiscription, "service charge<>");

		visbility(driver, pom.getInstanceBilling().itemservicechargesPrice, 60);
		sendkeys(pom.getInstanceBilling().itemservicechargesPrice, "5");
		try {

			visbility(driver, pom.getInstanceBilling().itemservicechargesSave, 60);
			clickIntercept(pom.getInstanceBilling().itemservicechargesSave, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().itemservicechargesSave, 60);
			clickIntercept(pom.getInstanceBilling().itemservicechargesSave, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().itemservicechargesAddToBillList, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesAddToBillList, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().itemservicechargesAddToBillList, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesAddToBillList, 30);
		}

		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().itemservicechargesEdit, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesEdit, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemservicechargesEdit, 60);

			clickIntercept(pom.getInstanceBilling().itemservicechargesEdit, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().itemservicechargesDelete, 60);
			clickIntercept(pom.getInstanceBilling().itemservicechargesDelete, 30);
		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().itemservicechargesDelete, 60);
			clickIntercept(pom.getInstanceBilling().itemservicechargesDelete, 30);
		}

	}

	public static void discount() {

		try {

			visbility(driver, pom.getInstanceBilling().discountUi, 60);

			clickIntercept(pom.getInstanceBilling().discountUi, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().discountUi, 60);

			clickIntercept(pom.getInstanceBilling().discountUi, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().discountAddIcon, 60);

			clickIntercept(pom.getInstanceBilling().discountAddIcon, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().discountAddIcon, 60);

			clickIntercept(pom.getInstanceBilling().discountAddIcon, 30);
		}

		visbility(driver, pom.getInstanceBilling().discountDiscription, 60);
		sendkeys(pom.getInstanceBilling().discountDiscription, "Discnt");

		visbility(driver, pom.getInstanceBilling().discountType, 60);
		clickIntercept(pom.getInstanceBilling().discountType, 30);

		for (WebElement we : pom.getInstanceBilling().discountDropDown) {
			if (we.getText().trim().equals("Percentage Discount")) {
				visbility(driver, we, 60);
				clickIntercept(we, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceBilling().discountPercentage, 60);
		sendkeys(pom.getInstanceBilling().discountPercentage, "5");
		try {

			visbility(driver, pom.getInstanceBilling().saveDiscount, 60);
			clickIntercept(pom.getInstanceBilling().saveDiscount, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().saveDiscount, 60);
			clickIntercept(pom.getInstanceBilling().saveDiscount, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().addDiscountToBillList, 60);
			clickIntercept(pom.getInstanceBilling().addDiscountToBillList, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().addDiscountToBillList, 60);
			clickIntercept(pom.getInstanceBilling().addDiscountToBillList, 30);
		}
		sleep(2000);

		try {

			visbility(driver, pom.getInstanceBilling().editDiscount, 60);

			clickIntercept(pom.getInstanceBilling().editDiscount, 30);

		} catch (Exception e) {

			visbility(driver, pom.getInstanceBilling().editDiscount, 60);

			clickIntercept(pom.getInstanceBilling().editDiscount, 30);
		}

		try {

			visbility(driver, pom.getInstanceBilling().deleteDiscount, 60);
			clickIntercept(pom.getInstanceBilling().deleteDiscount, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().deleteDiscount, 60);
			clickIntercept(pom.getInstanceBilling().deleteDiscount, 30);
		}

	}

	public static void addPayment() {
		try {

			visbility(driver, pom.getInstanceBilling().addPayment, 60);
			clickIntercept(pom.getInstanceBilling().addPayment, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().addPayment, 60);
			clickIntercept(pom.getInstanceBilling().addPayment, 30);
		}

		visbility(driver, pom.getInstanceBilling().selectPayment, 60);
		clickIntercept(pom.getInstanceBilling().selectPayment, 30);
		sleep(2000);

		for (WebElement w : pom.getInstanceBilling().selectPayemntDropdown) {
			if (w.getText().trim().equals("Cash Payment")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);
				break;
			}

		}

		visbility(driver, pom.getInstanceBilling().paymentDiscription, 60);
		clickIntercept(pom.getInstanceBilling().paymentDiscription, 30);
		sleep(2000);
		sendkeys(pom.getInstanceBilling().paymentDiscription, "CASH PAYMENT DONE");

		try {

			visbility(driver, pom.getInstanceBilling().makePayment, 60);
			clickIntercept(pom.getInstanceBilling().makePayment, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().makePayment, 60);
			clickIntercept(pom.getInstanceBilling().makePayment, 30);
		}

	}

	public static void finalizeBill() {
		try {

			visbility(driver, pom.getInstanceBilling().finalizBill, 60);

			clickIntercept(pom.getInstanceBilling().finalizBill, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceBilling().finalizBill, 60);

			clickIntercept(pom.getInstanceBilling().finalizBill, 30);
		}

		sleep(2000);

		visbility(driver, pom.getInstanceBilling().finalizeBillConfirmationKpop, 60);

		clickIntercept(pom.getInstanceBilling().finalizeBillConfirmationKpop, 30);

	}

}
