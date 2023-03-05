package org.marketPlace;

import java.awt.AWTException;

import org.Launch.LaunchBrowser;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class MarketPlace extends LaunchBrowser {

	static Logger log;

	@Test(priority = 1)
	private void marketPlaceTest() {

		log = Logger.getLogger(MarketPlace.class);
		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		elementClickable(pom.getInstanceSetting().clickSettings);
		click(pom.getInstanceSetting().clickSettings);
		log.info("settings clicked");

		visbility(driver, pom.getInstanceSetting().$marketplace, 40);
		click(pom.getInstanceSetting().$marketplace);

		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 30);
		click(pom.getInstanceSetting().$eirsystembutton$);
		log.info("MARKET PLACE");

		visbility(driver, pom.getInstanceMarketplace().Activate, 30);
		click(pom.getInstanceMarketplace().Activate);

		log.info("Activate");

		visbility(driver, pom.getInstanceMarketplace().mobileNumber, 30);

		String checkVal = pom.getInstanceMarketplace().mobileNumber.getAttribute("value");
		log.info(checkVal);

		if (checkVal.isEmpty()) {
			sendkeys(pom.getInstanceMarketplace().mobileNumber, "2012334546");
			log.info("EMPTY");
		} else if (!checkVal.isEmpty()) {

			System.out.println("not empty");
		}

		visbility(driver, pom.getInstanceMarketplace().faxNo, 40);
		sendkeys(pom.getInstanceMarketplace().faxNo, "4545454444");

		visbility(driver, pom.getInstanceMarketplace().deaNumber, 30);
		sendkeys(pom.getInstanceMarketplace().deaNumber, "BS1998123");

		sendkeys(pom.getInstanceMarketplace().Address1, "kaaspro");
		sendkeys(pom.getInstanceMarketplace().Address2, "Enterprises");

		sendkeys(pom.getInstanceMarketplace().city, "koturpuram");
		dropDown("text", pom.getInstanceMarketplace().state, "Arizona");
		sendkeys(pom.getInstanceMarketplace().postalcode, "85123");

		elementClickable(pom.getInstanceMarketplace().continueButton);
		click(pom.getInstanceMarketplace().continueButton);

	}

	@Test(priority = 2)
	public void addUsers() throws AWTException {

		visbility(driver, pom.getInstanceMarketplace().addUsers, 50);
		click(pom.getInstanceMarketplace().addUsers);

		visbility(driver, pom.getInstanceMarketplace().doctorUserSerachField, 30);

		sendkeys(pom.getInstanceMarketplace().doctorUserSerachField, "3090145");
		try {
			sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		keypress();
		keyenter();

		visbility(driver, pom.getInstanceMarketplace().birtdateField, 30);
		click(pom.getInstanceMarketplace().birtdateField);
		dropDown("text", pom.getInstanceMarketplace().selectYear, "2022");
		dropDown("text", pom.getInstanceMarketplace().selectMonth, "Dec");
		visbility(driver, pom.getInstanceMarketplace().chooseDate, 30);
		click(pom.getInstanceMarketplace().chooseDate);

		sendkeys(pom.getInstanceMarketplace().taxId, "121212121");
		sendkeys(pom.getInstanceMarketplace().userFaxNo, "3423542354");
		sendkeys(pom.getInstanceMarketplace().ssn, "666286134");

		sendkeys(pom.getInstanceMarketplace().userDeaNumber, "BS1999123");
		visbility(driver, pom.getInstanceMarketplace().userNpiNumber, 30);
		sendkeys(pom.getInstanceMarketplace().userNpiNumber, "1447561170");

		visbility(driver, pom.getInstanceMarketplace().userCheckBox, 40);
		click(pom.getInstanceMarketplace().userCheckBox);
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(pom.getInstanceMarketplace().saveUser);

	}

}
