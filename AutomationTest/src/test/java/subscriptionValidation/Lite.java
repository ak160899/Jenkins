package subscriptionValidation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

import subscriptionData.Sub_Manager;

public class Lite extends Base {

	public static WebDriver driver;
	static PageObjMan pom;
	String $userKp;
	String $drKp;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid;
	String $gm;
	String $preplsdc;

	@BeforeClass(groups = { "before" })
	private void l() throws InterruptedException, IOException {

		driver = setUp("chrome");
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 60);
		String ur = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();

		while (true) {
			if (ur.equals("https://localhost:8443/")) {

				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				sleep(3000);
				driver.findElement(By.id("details-button")).click();
				sleep(3000);

				driver.findElement(By.id("proceed-link")).click();
				sleep(4000);
				implicitWait(60, TimeUnit.SECONDS);

				break;
			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.get("https://www.75health.com/login.jsp");

				break;
			}

		}

		click(pom.getInstanceLoginPage().sigIn);
		sleep(2000);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

		ww.until(ExpectedConditions.urlToBe("https://localhost:8443/health/#home"));
		// https://localhost:8443/health/#home
		// https://www.75health.com/health/#home

	}

	@Test(priority = 0, groups = { "lite" })
	private void LiteManageruser() throws InterruptedException, IOException {

		// while(true) {}

		WebElement $upgradeLater$ = driver.findElement(By.xpath("(//button[@title='Upgrade Later'])[1]"));
		visbility(driver, $upgradeLater$, 60);
		click($upgradeLater$);

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$lte$useremail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 1, groups = { "lite" })
	private void $liteManageSubscription() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $manageSubscription$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		visbility(driver, $manageSubscription$, 60);
		javascriptclick($manageSubscription$);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$lte$dremail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 2, groups = { "lite" })
	private void $activeuserAndPayementpage$lte$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(3000);

	}

	@Test(priority = 3, groups = { "lite" })
	private void activate$deac$lte() throws IOException, InterruptedException {

		String $user = $userKp.replace("-", "");
		// System.out.println($user);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);
//****
		WebElement $activeuserUi = driver.findElement(By.xpath("(//div[@id='menu-active-user'])[1]"));
		visbility(driver, $activeuserUi, 60);
		actions("click", $activeuserUi);
		sleep(2000);
		// *****

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}
		sleep(4000);
	}

	@Test(priority = 4, groups = { "lite" })
	private void $activateDecfromManageUser() throws InterruptedException {

		String $drkpid = $drKp.replace("-", "");

		driver.navigate().to("https://localhost:8443/health/#list_user");
		for (int i = 1; i <= 6; i++) {
			try {
				WebElement $searchusername = driver.findElement(By.id("userPartyName"));
				visbility(driver, $searchusername, 60);
				sendkeys($searchusername, $drkpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(4000);

		// System.out.println("(//div[text()='" + $gm + "'])[1]");
		while (true) {
			System.out.println("while.");
			try {
				// System.out.println("try");
				WebElement $clickuserfromManageUserlist = driver
						.findElement(By.xpath("(//div[text()='" + $gm + " '])[1]"));
				// System.out.println($clickuserfromManageUserlist);
				if ($clickuserfromManageUserlist.isDisplayed()) {
					// System.out.println("manage...");
					javascriptclick($clickuserfromManageUserlist);
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				actions("move to element", ay);
				javascriptclick(ay);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		WebElement $userdropDown = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userdropDown, 60);
		javascriptclick($userdropDown);

		List<WebElement> wl = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w : wl) {

			if (w.getText().trim().equals("ACTIVE")) {
				w.click();
				break;
			}
			sleep(4000);

		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(4000);
		// WebElement avtic =
		// driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		// j.executeScript("arguments[0].click();", avtic);

		sleep(3000);

		// suspend

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay1 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay1, 60);
				javascriptclick(ay1);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		WebElement $userActive1 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userActive1, 60);
		javascriptclick($userActive1);

		List<WebElement> wl1 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w2 : wl1) {

			if (w2.getText().trim().equals("SUSPEND")) {
				w2.click();
				break;
			}
			sleep(3000);
		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(3000);

		// active

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay2 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay2, 60);
				javascriptclick(ay2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl2 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl2) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		sleep(2000);

		// deactivate..

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay3 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				visbility(driver, ay3, 60);
				javascriptclick(ay3);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl3 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w4 : wl3) {

			if (w4.getText().trim().equals("DEACTIVE")) {
				w4.click();
				break;
			}
		}
		sleep(2000);
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(2000);

		System.out.println("hello last one..");
		// driver.navigate().refresh();
		// activate again..

		while (true) {
			try {
				WebElement $editbasicuserfrmMangeeuser = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				System.out.println("element is visble");
				if ($editbasicuserfrmMangeeuser.isDisplayed()) {
					visbility(driver, $editbasicuserfrmMangeeuser, 60);
					System.out.println("visblleee");
					javascriptclick($editbasicuserfrmMangeeuser);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(3000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				if ($userActive2.isDisplayed()) {
					visbility(driver, $userActive2, 60);
					javascriptclick($userActive2);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl22 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl22) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		while (true) {
			try {

				WebElement $baiscinfoFrmMangeuserProced = driver
						.findElement(By.xpath("(//button[@title='Proceed'])[1]"));
				visbility(driver, $baiscinfoFrmMangeuserProced, 60);
				javascriptclick($baiscinfoFrmMangeuserProced);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(3000);
	}

	@Test(priority = 5, groups = { "lite" })
	private void $upgradeplan$UI() throws InterruptedException, AWTException {

		WebElement $upgradeplnui$ = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a/img"));
		visbility(driver, $upgradeplnui$, 60);
		actions("click", $upgradeplnui$);

		sleep(2000);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@onclick='allPaymentServices.editUsers();']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);

		sleep(2000);

		try {
			WebElement $removeusermovescn$ = driver.findElement(By.xpath("//div[text()='" + $gm + "']"));
			visbility(driver, $removeusermovescn$, 60);

			actions("move to element", $removeusermovescn$);

		} catch (Exception e) { // TODO: handle exception

		}
		sleep(2000);

		WebElement $removeuserfrmedituser$ = driver
				.findElement(By.xpath("//div[text()='" + $gm + "']//following::div[2]"));

		visbility(driver, $removeuserfrmedituser$, 60);

		actions("click", $removeuserfrmedituser$);

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $userKp);
		sleep(3000);
		keypress();
		keyenter();

		WebElement $proceedpay$lte = driver.findElement(By.xpath("(//button[text()='Proceed Payment'])[3]"));
		visbility(driver, $proceedpay$lte, 60);
		javascriptclick($proceedpay$lte);
		sleep(2500);
	}

	@Test(priority = 6, groups = { "lite" })
	public void payementpageAndCardDetail$lte() throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement basicsub = driver.findElement(By.xpath("//span[text()='$ 19']"));
				actions("move to element", basicsub);
				visbility(driver, basicsub, 60);
				javascriptclick(basicsub);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(4000);
		// card details

		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-details']//iframe")));
		// System.out.println("switch in frame");

		for (int i = 1; i <= 5; i++) {
			try {
				driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242");
				System.out.println("card num iden");

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement expyr = driver.findElement(By.name("exp-date"));
		visbility(driver, expyr, 60);
		sendkeys(expyr, "424");
		WebElement cvc = driver.findElement(By.name("cvc"));
		visbility(driver, cvc, 60);
		sendkeys(cvc, "242");

		WebElement zipcode = driver.findElement(By.name("postal"));
		visbility(driver, zipcode, 60);
		sendkeys(zipcode, "42424");

		defaultcontent();

		driver.findElement(By.id("save_btn")).click();

		while (true) {

			try {
				WebElement $finishLite = driver.findElement(By.xpath("//span[text()='Finish']"));
				if ($finishLite.isDisplayed()) {
					visbility(driver, $finishLite, 60);
					javascriptclick($finishLite);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	////// $$$$$$$$$$$$$$$$$$$$$$$$$lite
	////// ends$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$////////////////////////////////////////

	// basic package..

	@Test(priority = 7, groups = { "basic" })
	private void $manageuser$basic() throws IOException, InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$bas$usmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 8, groups = { "basic" })
	private void basicManageSubscription$$() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		visbility(driver, pom.getInstanceSetting().$activeuser$, 60);
		click(pom.getInstanceSetting().$activeuser$);

		WebElement $upgradeplnui$ = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a/img"));
		visbility(driver, $upgradeplnui$, 60);
		actions("click", $upgradeplnui$);
		System.out.println("link clicked");
		sleep(2000);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@id='edit-user-btn']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);
		System.out.println("edit user clicked");
		sleep(2000);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$bas$drmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 9, groups = { "basic" })
	private void $activate$dc$suspendfromManageuser() throws InterruptedException {

		String $drkpid = $drKp.replace("-", "");

		driver.navigate().to("https://localhost:8443/health/#list_user");
		for (int i = 1; i <= 6; i++) {
			try {
				WebElement $searchusername = driver.findElement(By.id("userPartyName"));
				visbility(driver, $searchusername, 60);
				sendkeys($searchusername, $drkpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(4000);

		// System.out.println("(//div[text()='" + $gm + "'])[1]");
		while (true) {
			System.out.println("while.");
			try {
				// System.out.println("try");
				WebElement $clickuserfromManageUserlist = driver
						.findElement(By.xpath("(//div[text()='" + $gm + " '])[1]"));
				// System.out.println($clickuserfromManageUserlist);
				if ($clickuserfromManageUserlist.isDisplayed()) {
					// System.out.println("manage...");
					javascriptclick($clickuserfromManageUserlist);
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				actions("move to element", ay);
				javascriptclick(ay);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		WebElement $userdropDown = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userdropDown, 60);
		javascriptclick($userdropDown);

		List<WebElement> wl = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w : wl) {

			if (w.getText().trim().equals("ACTIVE")) {
				w.click();
				break;
			}
			sleep(4000);

		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(4000);
		// WebElement avtic =
		// driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		// j.executeScript("arguments[0].click();", avtic);

		sleep(3000);

		// suspend

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay1 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay1, 60);
				javascriptclick(ay1);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		WebElement $userActive1 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userActive1, 60);
		javascriptclick($userActive1);

		List<WebElement> wl1 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w2 : wl1) {

			if (w2.getText().trim().equals("SUSPEND")) {
				w2.click();
				break;
			}
			sleep(3000);
		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(3000);

		// active

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay2 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay2, 60);
				javascriptclick(ay2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl2 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl2) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		sleep(2000);

		// deactivate..

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay3 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				visbility(driver, ay3, 60);
				javascriptclick(ay3);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl3 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w4 : wl3) {

			if (w4.getText().trim().equals("DEACTIVE")) {
				w4.click();
				break;
			}
		}
		sleep(2000);
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(5000);

		System.out.println("hello last one..");
		// driver.navigate().refresh();
		// activate again..

		while (true) {
			try {
				WebElement $editbasicuserfrmMangeeuser = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				if ($editbasicuserfrmMangeeuser.isDisplayed()) {
					visbility(driver, $editbasicuserfrmMangeeuser, 60);
					javascriptclick($editbasicuserfrmMangeeuser);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(3000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl22 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl22) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		while (true) {
			try {
				WebElement $baiscinfoFrmMangeuserProced = driver
						.findElement(By.xpath("(//button[@title='Proceed'])[1]"));
				visbility(driver, $baiscinfoFrmMangeuserProced, 60);
				javascriptclick($baiscinfoFrmMangeuserProced);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(6000);

	}

	@Test(priority = 10, groups = { "basic" })

	private void activeuserAndPayement$bas$() throws InterruptedException {
		sleep(2000);
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(2000);
		driver.navigate().refresh();

	}

	@Test(priority = 11, groups = { "basic" })
	private void activateDeactivateuser$bas$() throws InterruptedException, IOException {

		String $user = $userKp.replace("-", "");
		// System.out.println($user);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);
				// System.out.println("moved to element:" + ids);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		// System.out.println(userdcact);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);
				//
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//
		WebElement $activeuserUi = driver.findElement(By.xpath("(//div[@id='menu-active-user'])[1]"));
		visbility(driver, $activeuserUi, 60);
		actions("click", $activeuserUi);
		sleep(2000);
		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}
		}

		sleep(4000);
	}

	@Test(priority = 12, groups = { "basic" })
	private void upgradepln$bas() throws InterruptedException, AWTException {

		WebElement $upgradeplnui$ = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a/img"));
		visbility(driver, $upgradeplnui$, 60);
		javascriptclick($upgradeplnui$);

		sleep(5000);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@id='edit-user-btn']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);

		sleep(2000);

		WebElement $removeusermovescn$ = driver.findElement(By.xpath("//div[text()='" + $gm + "']"));

		while (true) {
			if ($removeusermovescn$.isDisplayed()) {
				break;
			}
		}

		try {
			visbility(driver, $removeusermovescn$, 60);

			actions("move to element", $removeusermovescn$);

		} catch (Exception e) { // TODO: handle exception

		}
		sleep(3000);
		for (int i = 1; i <= 6; i++) {
			try {

				WebElement $removeuserfrmedituser$ = driver
						.findElement(By.xpath("//div[text()='" + $gm + "']//following::div[2]"));

				visbility(driver, $removeuserfrmedituser$, 60);

				actions("click", $removeuserfrmedituser$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $userKp);
		sleep(3000);
		keypress();
		keyenter();

		WebElement $proceedpay$lte = driver.findElement(By.xpath("(//button[text()='Proceed Payment'])[3]"));
		visbility(driver, $proceedpay$lte, 60);
		javascriptclick($proceedpay$lte);
		sleep(2500);

	}

	@Test(priority = 13, groups = { "basic" })
	private void paymentAndCrdDetails$() throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement basicsub = driver.findElement(By.xpath("//span[text()='$ 55']"));
				actions("move to element", basicsub);
				visbility(driver, basicsub, 60);
				javascriptclick(basicsub);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(4000);

		driver.findElement(By.id("update_basic_btn")).click();

		while (true) {
			try {
				WebElement $returnhmpage$ = driver
						.findElement(By.xpath("//a[text()='Click here to return to the login Page']"));

				if ($returnhmpage$.isDisplayed()) {

					javascriptclick($returnhmpage$);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	// $$$$$$$$$premium$$$$$$$$$//

	@Test(priority = 14, groups = { "premium" })
	private void $manageuser$premium() throws IOException, InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$pre$usmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 15, groups = { "premium" })
	private void $premiumManageSubscription() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $manageSubscription$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		visbility(driver, $manageSubscription$, 60);
		javascriptclick($manageSubscription$);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$pre$drmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();
		$preplsdc = $drKp;

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 16, groups = { "premium" })
	private void $activateDecSuspend$premium() throws InterruptedException {

		String $drkpid = $drKp.replace("-", "");

		driver.navigate().to("https://localhost:8443/health/#list_user");
		for (int i = 1; i <= 6; i++) {
			try {
				WebElement $searchusername = driver.findElement(By.id("userPartyName"));
				visbility(driver, $searchusername, 60);
				sendkeys($searchusername, $drkpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(4000);

		// System.out.println("(//div[text()='" + $gm + "'])[1]");
		while (true) {
			System.out.println("while.");
			try {
				// System.out.println("try");
				WebElement $clickuserfromManageUserlist = driver
						.findElement(By.xpath("(//div[text()='" + $gm + " '])[1]"));
				// System.out.println($clickuserfromManageUserlist);
				if ($clickuserfromManageUserlist.isDisplayed()) {
					// System.out.println("manage...");
					javascriptclick($clickuserfromManageUserlist);
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				actions("move to element", ay);
				javascriptclick(ay);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		WebElement $userdropDown = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userdropDown, 60);
		javascriptclick($userdropDown);

		List<WebElement> wl = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w : wl) {

			if (w.getText().trim().equals("ACTIVE")) {
				w.click();
				break;
			}
			sleep(4000);

		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(4000);
		// WebElement avtic =
		// driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		// j.executeScript("arguments[0].click();", avtic);

		sleep(3000);

		// suspend

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay1 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay1, 60);
				javascriptclick(ay1);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		WebElement $userActive1 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userActive1, 60);
		javascriptclick($userActive1);

		List<WebElement> wl1 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w2 : wl1) {

			if (w2.getText().trim().equals("SUSPEND")) {
				w2.click();
				break;
			}
			sleep(3000);
		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(3000);

		// active

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay2 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay2, 60);
				javascriptclick(ay2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl2 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl2) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		sleep(2000);

		// deactivate..

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay3 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				visbility(driver, ay3, 60);
				javascriptclick(ay3);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl3 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w4 : wl3) {

			if (w4.getText().trim().equals("DEACTIVE")) {
				w4.click();
				break;
			}
		}
		sleep(2000);
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(2000);

		System.out.println("hello last one..");
		// driver.navigate().refresh();
		// activate again..

		while (true) {
			try {
				WebElement $editbasicuserfrmMangeeuser = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				if ($editbasicuserfrmMangeeuser.isDisplayed()) {
					visbility(driver, $editbasicuserfrmMangeeuser, 60);
					javascriptclick($editbasicuserfrmMangeeuser);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(3000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl22 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl22) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}
		sleep(2000);
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		while (true) {
			try {
				WebElement $baiscinfoFrmMangeuserProced = driver
						.findElement(By.xpath("(//button[@title='Proceed'])[1]"));
				visbility(driver, $baiscinfoFrmMangeuserProced, 60);
				javascriptclick($baiscinfoFrmMangeuserProced);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(6000);

	}

	@Test(priority = 17, groups = { "premium" })

	private void activeuserAndPayement$premium$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(2000);
		driver.navigate().refresh();

	}

	@Test(priority = 18, groups = { "premium" })
	private void activateDeactivateuser$premium$() throws InterruptedException, IOException {

		String $user = $userKp.replace("-", "");
		System.out.println($user);
		// $preplsdc = $user;

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//
		WebElement $activeuserUi = driver.findElement(By.xpath("(//div[@id='menu-active-user'])[1]"));
		visbility(driver, $activeuserUi, 60);
		actions("click", $activeuserUi);
		sleep(2000);
		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}
		}
		sleep(4000);
	}

	@Test(priority = 19, groups = { "premium" })
	private void upgradepln$premium79() throws InterruptedException, AWTException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $marketplace = driver.findElement(By.xpath("//button[text()='Market Place']"));
		javascriptclick($marketplace);
		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 60);
		javascriptclick(pom.getInstanceSetting().$eirsystembutton$);

		visbility(driver, pom.getInstanceSetting().$upgradenowineir$, 60);
		javascriptclick(pom.getInstanceSetting().$upgradenowineir$);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@id='edit-user-btn']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);

		sleep(2000);

		WebElement $removeusermovescn$ = driver.findElement(By.xpath("//div[text()='" + $gm + "']"));

		while (true) {
			if ($removeusermovescn$.isDisplayed()) {
				break;
			}
		}

		try {
			visbility(driver, $removeusermovescn$, 60);

			actions("move to element", $removeusermovescn$);

		} catch (Exception e) { // TODO: handle exception

		}
		sleep(2000);

		WebElement $removeuserfrmedituser$ = driver
				.findElement(By.xpath("//div[text()='" + $gm + "']//following::div[2]"));

		visbility(driver, $removeuserfrmedituser$, 60);

		actions("click", $removeuserfrmedituser$);

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $userKp);
		sleep(3000);
		keypress();
		keyenter();

		WebElement $proceedpay$lte = driver.findElement(By.xpath("(//button[text()='Proceed Payment'])[3]"));
		visbility(driver, $proceedpay$lte, 60);
		javascriptclick($proceedpay$lte);
		sleep(2500);

		driver.findElement(By.id("update-subscription-btn")).click();

		while (true) {

			try {
				WebElement $finishpln = driver.findElement(By.xpath("//span[text()='Finish']"));

				if ($finishpln.isDisplayed()) {
					javascriptclick($finishpln);
					break;

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

////////$$$$$$$$$$$$$$premium$79....????/////////////

	@Test(priority = 20, groups = { "premiumplus" })
	private void $manageuser$premium79() throws IOException, InterruptedException {

		while (true) {
			try {
				visbility(driver, pom.getInstanceSetting().clickSettings, 60);
				javascriptclick(pom.getInstanceSetting().clickSettings);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$prepls$usmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 21, groups = { "premiumplus" })
	private void $premiumManageSubscription79() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $manageSubscription$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		visbility(driver, $manageSubscription$, 60);
		javascriptclick($manageSubscription$);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$prepls$drmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 22, groups = { "premiumplus" })
	private void $activateDcSuspend$premium79() throws InterruptedException {

		String $drkpid = $drKp.replace("-", "");

		driver.navigate().to("https://localhost:8443/health/#list_user");
		for (int i = 1; i <= 6; i++) {
			try {
				WebElement $searchusername = driver.findElement(By.id("userPartyName"));
				visbility(driver, $searchusername, 60);
				sendkeys($searchusername, $drkpid);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(4000);

		// System.out.println("(//div[text()='" + $gm + "'])[1]");
		while (true) {
			System.out.println("while.");
			try {
				// System.out.println("try");
				WebElement $clickuserfromManageUserlist = driver
						.findElement(By.xpath("(//div[text()='" + $gm + " '])[1]"));
				// System.out.println($clickuserfromManageUserlist);
				if ($clickuserfromManageUserlist.isDisplayed()) {
					// System.out.println("manage...");
					javascriptclick($clickuserfromManageUserlist);
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				actions("move to element", ay);
				javascriptclick(ay);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		WebElement $userdropDown = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userdropDown, 60);
		javascriptclick($userdropDown);

		List<WebElement> wl = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w : wl) {

			if (w.getText().trim().equals("ACTIVE")) {
				w.click();
				break;
			}
			sleep(4000);

		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(4000);
		// WebElement avtic =
		// driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
		// j.executeScript("arguments[0].click();", avtic);

		sleep(3000);

		// suspend

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay1 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay1, 60);
				javascriptclick(ay1);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		WebElement $userActive1 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
		visbility(driver, $userActive1, 60);
		javascriptclick($userActive1);

		List<WebElement> wl1 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w2 : wl1) {

			if (w2.getText().trim().equals("SUSPEND")) {
				w2.click();
				break;
			}
			sleep(3000);
		}
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(3000);

		// active

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay2 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				visbility(driver, ay2, 60);
				javascriptclick(ay2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl2 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl2) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		sleep(2000);

		// deactivate..

		implicitWait(30, TimeUnit.SECONDS);
		while (true) {
			try {
				WebElement ay3 = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));

				visbility(driver, ay3, 60);
				javascriptclick(ay3);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(2000);

		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl3 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w4 : wl3) {

			if (w4.getText().trim().equals("DEACTIVE")) {
				w4.click();
				break;
			}
		}
		sleep(2000);
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();
		sleep(2000);

		System.out.println("hello last one..");
		// driver.navigate().refresh();
		// activate again..

		while (true) {
			try {
				WebElement $editbasicuserfrmMangeeuser = driver
						.findElement(By.xpath("(//span[text()='Basic Information'])[4]//following::span[1]"));
				if ($editbasicuserfrmMangeeuser.isDisplayed()) {
					visbility(driver, $editbasicuserfrmMangeeuser, 60);
					javascriptclick($editbasicuserfrmMangeeuser);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(3000);
		while (true) {
			try {
				WebElement $userActive2 = driver.findElement(By.xpath("//button[@id='userActiveId']"));
				visbility(driver, $userActive2, 60);
				javascriptclick($userActive2);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> wl22 = driver.findElements(By.xpath("//button[@id='userActiveId']//following::ul[1]/li/a"));
		for (WebElement w3 : wl22) {

			if (w3.getText().trim().equals("ACTIVE")) {
				w3.click();
				break;
			}
		}
		sleep(2000);
		driver.findElement(By.xpath("//button[@id='userActiveId']//following::button[4]")).click();

		while (true) {
			try {
				WebElement $baiscinfoFrmMangeuserProced = driver
						.findElement(By.xpath("(//button[@title='Proceed'])[1]"));
				visbility(driver, $baiscinfoFrmMangeuserProced, 60);
				javascriptclick($baiscinfoFrmMangeuserProced);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(6000);

	}

	@Test(priority = 23, groups = { "premiumplus" })

	private void activeuserAndPayement$premium79$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(4000);
		driver.navigate().refresh();

	}

	@Test(priority = 24, groups = { "premiumplus" })
	private void activateDeactivateuser$79() throws InterruptedException, IOException {

		String $user = $userKp.replace("-", "");
		System.out.println($user);
		// $preplsdc = $user;

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//
		WebElement $activeuserUi = driver.findElement(By.xpath("(//div[@id='menu-active-user'])[1]"));
		visbility(driver, $activeuserUi, 60);
		actions("click", $activeuserUi);
		sleep(2000);
		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}
		}
		sleep(4000);

	}

	@Test(priority = 25, groups = { "premiumplus" })
	private void lst() throws InterruptedException, AWTException {
		while (true) {
			try {

				visbility(driver, pom.getInstanceSetting().clickSettings, 60);
				javascriptclick(pom.getInstanceSetting().clickSettings);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		while (true) {
			try {
				WebElement $manageSubscription$ = driver
						.findElement(By.xpath("//button[text()='Manage Subscription']"));

				javascriptclick($manageSubscription$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		System.out.println("done...");
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $preplsdc);
		sleep(3000);
		WebElement $preplususerdrop = driver.findElement(
				By.xpath("//input[@id='userPartySearch0']//following::ul[1]/li/a/table[1]/tbody/tr/td[1]/span"));
		while (true) {
			if (!$preplususerdrop.getText().isEmpty() && $preplususerdrop.isDisplayed()) {
				click($preplususerdrop);
				break;
			}

		}

		WebElement $addUser = driver.findElement(By.xpath("//input[@id='userPartySearch0']//following::button[2]"));
		visbility(driver, $addUser, 60);
		click($addUser);
		sleep(2000);

		WebElement $procedpaymentpreplus = driver
				.findElement(By.xpath("//button[@title='Continue to proceed payment']"));

		visbility(driver, $procedpaymentpreplus, 60);
		click($procedpaymentpreplus);

		while (true) {
			try {
				WebElement $updatesubpreplus = driver.findElement(By.id("update-subscription-btn"));
				if ($updatesubpreplus.isDisplayed()) {
					click($updatesubpreplus);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		while (true) {
			try {
				WebElement $finish = driver
						.findElement(By.xpath("//button[@onclick='allVasPremiumThankyou.setting();']"));
				if ($finish.isDisplayed()) {
					click($finish);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
