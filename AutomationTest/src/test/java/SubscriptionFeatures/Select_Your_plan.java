package SubscriptionFeatures;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Select_Your_plan extends LaunchBrowser {

	String kpid = "3090-160";

	public static void verifyThePaymentUi() {

		clickIntercept(pom.getInstanceSelectYourPlan().editplanCrossIcon, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().editPlanButton, 30);
		sleep(2500);
		clickIntercept(pom.getInstanceSelectYourPlan().editPlanButton, 30);

	}

	public static void verifyTheNextPayementui() {

		try {

			visbility(driver, pom.getInstanceSetting().$Carosel$, 60);

			clickIntercept(pom.getInstanceSetting().$Carosel$, 30);
			sleep(2500);
		} catch (Exception e) {

			visbility(driver, pom.getInstanceSetting().$Carosel$, 60);

			clickIntercept(pom.getInstanceSetting().$Carosel$, 30);

		}

	}

	public static void verifyTheBasicPaymentUi() {
		boolean payment = false;

		if (pom.getInstanceSelectYourPlan().basicMonthlyUi.isDisplayed()) {
			visbility(driver, pom.getInstanceSelectYourPlan().basicMonthlyUi, 40);

			clickIntercept(pom.getInstanceSelectYourPlan().basicMonthlyUi, 30);
			verifyThePaymentUi();
			payment = true;

		} else {
			if (payment == false) {
				verifyTheNextPayementui();
				verifyTheBasicPaymentUi();
			}

		}

	}

	public static void verifyThePremium55PaymentUi() {
		boolean payment = false;
		if (pom.getInstanceSelectYourPlan().premiumMonthlyui.isDisplayed()) {
			visbility(driver, pom.getInstanceSelectYourPlan().premiumMonthlyui, 40);

			clickIntercept(pom.getInstanceSelectYourPlan().premiumMonthlyui, 30);
			verifyThePaymentUi();
			payment = true;

		} else {
			if (payment == false) {
				verifyTheNextPayementui();
				verifyThePremium55PaymentUi();
			}

		}
	}

	public static void verifyTheEnterprisePaymentUi() {
		boolean payment = false;
		if (pom.getInstanceSelectYourPlan().enterpriseUi.isDisplayed()) {
			visbility(driver, pom.getInstanceSelectYourPlan().enterpriseUi, 40);

			clickIntercept(pom.getInstanceSelectYourPlan().enterpriseUi, 30);
			verifyThePaymentUi();
			payment = true;

		} else {
			if (payment == false) {
				verifyTheNextPayementui();
				verifyTheEnterprisePaymentUi();
			}

		}

	}

	public static void verifyTheLitePaymentUi() {
		boolean payment = false;
		if (pom.getInstanceSelectYourPlan().lite.isDisplayed()) {
			visbility(driver, pom.getInstanceSelectYourPlan().lite, 40);

			clickIntercept(pom.getInstanceSelectYourPlan().lite, 30);
			verifyThePaymentUi();
			payment = true;

		} else {
			if (payment == false) {
				verifyTheNextPayementui();
				verifyTheLitePaymentUi();
			}

		}
	}

	public static void verifyThePremiumplusPayementUi() {
		boolean payment = false;
		if (pom.getInstanceSelectYourPlan().premiumplusUi.isDisplayed()) {
			visbility(driver, pom.getInstanceSelectYourPlan().premiumplusUi, 40);

			clickIntercept(pom.getInstanceSelectYourPlan().premiumplusUi, 30);
			verifyThePaymentUi();
			payment = true;

		} else {
			if (payment == false) {
				verifyTheNextPayementui();
				verifyThePremiumplusPayementUi();
			}

		}

	}

	@Test(priority = 0, enabled = false)
	private void Home_patientCreationVerifyPaymentAlert() throws InterruptedException {
		try {

			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 30);
			clickIntercept(pom.getInstanceHomeModule().$patientCreationButton, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceHomeModule().$patientCreationButton, 30);
			clickIntercept(pom.getInstanceHomeModule().$patientCreationButton, 30);
		}
		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();

		driver.navigate().back();

	}

	@Test(priority = 1, enabled = false)
	private void home_VerifyAppointmentBookPaymentUi() {

		sleep(4000);

		String hkpid = kpid;
		// home modules appointment...

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));

		int totalr = totalnumberrowdy.size();

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {
			int a = 1 + i;
			WebElement ss = driver.findElement(By.xpath("//div[@id='date-data'][" + i + "]/div[2]/div[2]/div"));
			if (ss.getText().equals("Doctor/User not working")) {

				WebElement abcd = driver.findElement(By.xpath("(//span[@id='editCalendar'])[" + a + "]"));
				visbility(driver, abcd, 60);
				actions("click", abcd);
				sleep(3000);
				WebElement checkbx = driver.findElement(By.xpath("(//input[@id='is-working-day'])[1]"));
				visbility(driver, checkbx, 60);

				actions("click", checkbx);
				WebElement ampm = driver.findElement(By.xpath("(//div[@id='thru-ampm'])[1]"));
				visbility(driver, ampm, 60);
				actions("click", ampm);
				driver.findElement(By.xpath("(//div[@id='save-btn'])[1]")).click();
				sleep(5000);

			}

			// represent total in a part..
			List<WebElement> rchange = driver
					.findElements(By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div/div[1]/div[1]/div[1])"));
			int avaiable = rchange.size();

			for (int b = 1; b <= avaiable; b++) {

				WebElement tp = driver.findElement(
						// represent the row change and time..
						By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div[" + b + "]/div[1]/div[1]/div[1])"));

				String tr = tp.getText();
				System.out.println(tr);
				boolean trp = tp.isDisplayed();
				String rrs = tp.getAttribute("id");

				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed() && !tp.getText().isEmpty()) {

					cond = true;
					visbility(driver, tp, 60);
					javascriptclick(tp);

					break;
				}

				if (cond == true) {
					break;
				}

			}
			if (cond == true) {
				break;
			}
		}

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 40);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();

		driver.navigate().back();

		sleep(2500);
	}

	@Test(priority = 2, enabled = false)
	private void patient_Module$() {
		clickIntercept(pom.getInstanceNewPatient().$patienmod, 1000);

		implicitWait(60, TimeUnit.SECONDS);

		clickIntercept(pom.getInstanceNewPatient().addNewPatient, 1000);
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 60);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();

	}

	@Test(priority = 3, enabled = false)
	private void e_h_r() throws InterruptedException {

		clickIntercept(pom.getInstanceHealthRec().clickHealthRec, 30);

		visbility(driver, pom.getInstanceHealthRec().clickAddIconHealthRec, 60);
		clickIntercept(pom.getInstanceHealthRec().clickAddIconHealthRec, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 40);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();

	}

	@Test(priority = 4, enabled = false)
	private void calendar$$$() throws InterruptedException {

		driver.navigate().to("https://localhost:8443/health/#calendar");
		implicitWait(60, TimeUnit.SECONDS);

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		$current = driver.getCurrentUrl();
		cal.$dayDrop($current);
		sleep(2000);

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));
		int totalr = totalnumberrowdy.size();

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {
			int a = 1 + i;
			WebElement ss = driver.findElement(By.xpath("//div[@id='date-data'][" + i + "]/div[2]/div[2]/div"));
			if (ss.getText().equals("Doctor/User not working")) {
				System.out.println("yes doctor not working for the:" + i);
				WebElement abcd = driver.findElement(By.xpath("(//span[@id='editCalendar'])[" + a + "]"));
				visbility(driver, abcd, 60);
				actions("click", abcd);
				sleep(3000);
				WebElement checkbx = driver.findElement(By.xpath("(//input[@id='is-working-day'])[1]"));
				System.out.println("(//input[@id='is-working-day'])[" + i + "]");
				visbility(driver, checkbx, 60);
				actions("click", checkbx);
				WebElement ampm = driver.findElement(By.xpath("(//div[@id='thru-ampm'])[1]"));
				visbility(driver, ampm, 60);
				actions("click", ampm);
				WebElement rre = driver.findElement(By.xpath("(//div[@id='save-btn'])[1]"));
				visbility(driver, rre, 60);
				javascriptclick(rre);// .click();
				sleep(5000);

			}

			// represent total in a part..
			List<WebElement> rchange = driver
					.findElements(By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div/div[1]/div[1]/div[1])"));
			int avaiable = rchange.size();

			for (int b = 1; b <= avaiable; b++) {

				WebElement tp = driver.findElement(

						By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div[" + b + "]/div[1]/div[1]/div[1])"));

				String tr = tp.getText();
				boolean trp = tp.isDisplayed();

				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed()) {

					cond = true;
					visbility(driver, tp, 60);
					javascriptclick(tp);

					break;
				}

				if (cond == true) {
					break;
				}
			}
			if (cond == true) {
				break;
			}
		}

		sleep(2000);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 40);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();

	}

	@Test(priority = 5, enabled = false)
	private void billing_$() {

		visbility(driver, pom.getInstanceBilling().clickBill, 60);

		clickIntercept(pom.getInstanceBilling().clickBill, 30);

		visbility(driver, pom.getInstanceBilling().clickCreateNewBill, 60);
		clickIntercept(pom.getInstanceBilling().clickCreateNewBill, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 40);

		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();

		driver.navigate().to("https://localhost:8443/health/#bill_report");

		try {
			visbility(driver, pom.getInstanceSetting().$dismissSubscribe$, 30);
			clickIntercept(pom.getInstanceSetting().$dismissSubscribe$, 30);
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().$dismissSubscribe$, 30);
			clickIntercept(pom.getInstanceSetting().$dismissSubscribe$, 30);
		}

	}

	@Test(priority = 6, enabled = false)
	private void $teleDoctor$() throws InterruptedException {

		clickIntercept(pom.getInstanceTeleDoctor().clickTeleDoctor, 30);

		WebElement np1 = driver.findElement(By.xpath("//button[@title='Create new Patinet']"));

		clickIntercept(np1, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		elementClickable(pom.getInstanceSetting().$editplnCrossIcon$);
		click(pom.getInstanceSetting().$editplnCrossIcon$);
		visbility(driver, pom.getInstanceSetting().$editplan$, 60);
		click(pom.getInstanceSetting().$editplan$);
		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();
		sleep(2500);

	}

	@Test(priority = 7, enabled = false)
	private void message() {

		clickIntercept(pom.getInstanceMessage().clickMessage, 30);
		clickIntercept(pom.getInstanceMessage().clickComposemMessage, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();

	}

	@Test(priority = 8)
	private void settings() throws InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		// manage your account..

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);
		visbility(driver, pom.getInstanceSetting().basicInfoEditIcon, 40);
		clickIntercept(pom.getInstanceSetting().basicInfoEditIcon, 30);

		WebElement $smsnotifcation = driver.findElement(By.xpath("(//button[@id='smsP'])[1]"));
		visbility(driver, $smsnotifcation, 30);
		clickIntercept($smsnotifcation, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		sleep(2500);

		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();

		verifyThePremiumplusPayementUi();
		// driver.navigate().back();
		driver.navigate().to("https://localhost:8443/health/#setting");

		// change password...
		WebElement changepassword = driver.findElement(By.xpath("//button[@onclick='setting.changep()']"));
		visbility(driver, changepassword, 30);
		clickIntercept(changepassword, 30);

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().back();

		// manage users..

		try {
			visbility(driver, pom.getInstanceSetting().manageuser, 40);
			clickIntercept(pom.getInstanceSetting().manageuser, 30);

			log.info("manage user clicked");
		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().manageuser, 40);
			elementClickable(pom.getInstanceSetting().manageuser);
			click(pom.getInstanceSetting().manageuser);
			log.info("manage user clicked");
		}

		try {

			visbility(driver, pom.getInstanceSetting().manageuserAddNewUser, 60);
			clickIntercept(pom.getInstanceSetting().manageuserAddNewUser, 30);

		} catch (ElementClickInterceptedException e) {

			visbility(driver, pom.getInstanceSetting().manageuserAddNewUser, 60);
			elementClickable(pom.getInstanceSetting().manageuserAddNewUser);
			clickIntercept(pom.getInstanceSetting().manageuserAddNewUser, 30);
		}
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		driver.navigate().to("https://localhost:8443/health/#setting");

		WebElement $setsign$ = driver.findElement(By.xpath("//button[text()='Set Signature']"));
		visbility(driver, $setsign$, 60);
		clickIntercept($setsign$, 30);
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		driver.navigate().back();
		sleep(2000);

		// auto logout time

		for (WebElement w : pom.getInstanceSetting().autoLogoutDrop) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);

				break;
			}

		}
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		driver.navigate().back();

		// cds

		visbility(driver, pom.getInstanceSetting().cdsClick, 30);

		clickIntercept(pom.getInstanceSetting().cdsClick, 30);
		sleep(2000);
		visbility(driver, pom.getInstanceSetting().addnewCds, 30);
		clickIntercept(pom.getInstanceSetting().addnewCds, 30);
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		driver.navigate().to("https://localhost:8443/health/#setting");
		ScriptExecutor(pom.getInstanceSetting().cdsClick);

		// set favorites..
		sleep(2500);
		visbility(driver, pom.getInstanceSetting().setFavoritesClick, 40);
		clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
		sleep(3000);
		for (WebElement w : pom.getInstanceSetting().setFavoriteListDrop) {
			if (w.getText().trim().equals("Item/service")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);
				break;
			}
		}
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		sleep(2500);
		driver.navigate().back();

		// Set forms
		visbility(driver, pom.getInstanceSetting().customForm, 60);
		clickIntercept(pom.getInstanceSetting().customForm, 30);
		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		sleep(2500);
		driver.navigate().back();
		// subscription

		WebElement $subscribe$ = driver.findElement(By.xpath("//button[text()='Subscribe']"));
		visbility(driver, $subscribe$, 60);
		clickIntercept($subscribe$, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();

		driver.navigate().back();

		// market place..

		WebElement $mrktplace$ = driver.findElement(By.xpath("//button[text()='Market Place']"));
		visbility(driver, $mrktplace$, 60);
		clickIntercept($mrktplace$, 30);
		ScriptExecutor($mrktplace$);

		// notifications

		try {
			elementClickable(pom.getInstanceSetting().customizeToggle);
			actions("click", pom.getInstanceSetting().customizeToggle);

		} catch (Exception e) {
			elementClickable(pom.getInstanceSetting().customizeToggle);
			actions("click", pom.getInstanceSetting().customizeToggle);
		}

		visbility(driver, pom.getInstanceSelectYourPlan().acceptsubscribe, 30);
		clickIntercept(pom.getInstanceSelectYourPlan().acceptsubscribe, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		sleep(2500);
		driver.navigate().back();

		try {
			visbility(driver, pom.getInstanceSetting().auditReport, 60);
			clickIntercept(pom.getInstanceSetting().auditReport, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().auditReport, 60);
			clickIntercept(pom.getInstanceSetting().auditReport, 30);
		}

		WebElement $subscribepremium$ = driver.findElement(By.xpath("//button[@title='Subscribe']"));
		visbility(driver, $subscribepremium$, 60);
		clickIntercept($subscribepremium$, 30);

		verifyTheBasicPaymentUi();
		verifyThePremium55PaymentUi();
		verifyTheEnterprisePaymentUi();
		verifyTheLitePaymentUi();
		verifyThePremiumplusPayementUi();
		sleep(2500);

		driver.navigate().back();

	}
}
