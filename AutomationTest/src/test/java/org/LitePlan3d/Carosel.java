package org.LitePlan3d;

import org.Launch.LaunchBrowser;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Carosel extends LaunchBrowser {

	static Logger log;

	public static void linktextUpgradePlanActiveuser() {
		log = Logger.getLogger(Carosel.class);
		BasicConfigurator.configure();
		visbility(driver, pom.getInstanceSetting().dismiss, 40);
		click(pom.getInstanceSetting().dismiss);
		log.info("clicked upgrade later in lite");

		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");

		WebElement link = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a"));
		visbility(driver, link, 40);
		click(link);
	}

	public static void basicCaroselUi() throws InterruptedException {

		boolean cond = false;
		WebElement basic = driver.findElement(By.xpath("//span[@id='monthlyBasicCardPlan']"));
		sleep(2000);
		if (basic.isDisplayed()) {
			visbility(driver, basic, 60);
			elementClickable(basic);
			click(basic);
			log.info("basic ui displyaed");
			cond = true;
		}
		if (cond == false) {
			nextSetDay();
			basicCaroselUi();
		} else if (cond == true) {

			editBasicCarsolUi();

		}
	}

	private static void nextSetDay() throws InterruptedException {
		WebElement $next = driver.findElement(By.xpath("(// span[@title='Next'])[2]"));
		visbility(driver, $next, 60);
		sleep(2000);
		actions("click", $next);
		log.info("next set clicked");

	}

	private static void editBasicCarsolUi() throws InterruptedException {

		visbility(driver, pom.getInstanceSetting().$editplnCrossIcon$, 40);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		log.info("edit plan (x) icon clicked");
		sleep(2500);
		visbility(driver, pom.getInstanceSetting().$editplan$, 40);
		click(pom.getInstanceSetting().$editplan$);
		log.info("edit plan ui clicked");
	}

	public static void premium55CaroselUi() throws InterruptedException {
		boolean cond = false;
		WebElement premium = driver.findElement(By.xpath("//span[@id='monthlyPremiumCardPlan']"));
		sleep(2000);
		if (premium.isDisplayed()) {
			visbility(driver, premium, 60);
			elementClickable(premium);
			click(premium);
			log.info("premium55 ui clicked");
			cond = true;
		}
		if (cond == false) {
			nextSetDay();
			basicCaroselUi();
		} else if (cond == true) {

			editBasicCarsolUi();
		}

	}

	public static void premium79carsolUi() throws InterruptedException {

		boolean cond = false;
		WebElement pre79 = driver.findElement(By.xpath("//span[@id='monthlyPremiumPlusCardPlan']"));
		sleep(2000);
		if (pre79.isDisplayed()) {
			visbility(driver, pre79, 60);
			elementClickable(pre79);
			click(pre79);
			log.info("premium79 ui clicked");
			cond = true;
		}
		if (cond == false) {
			nextSetDay();
			premium79carsolUi();
		} else if (cond == true) {

			editBasicCarsolUi();
		}

	}
}
