package org.setFavorites;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.Launch.LaunchBrowser;
import org.base.Base;
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

import com.calendar.Calendars;
import com.healthRec.Problems;
import com.pageObjeman.PageObjMan;

public class Favorites extends Base {

	public PageObjMan pom;
	public JavascriptExecutor j;
	public WebDriverWait ww;
	public WebDriver driver;
	public String kpid = "";
	public String ur;
	Calendars cal;
	String $current;

	@BeforeClass
	public void LaunchBrwoser() throws Exception {

		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");
		driver = (WebDriver) getConnection.get("driver");

	}

	@Test(priority = 7, groups = "settings")
	public void Settings() throws InterruptedException, IOException {

		while (true) {

			if (ur.equals("https://localhost:8443/")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				driver.navigate().refresh();
				break;

			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.navigate().to("https://www.75health.com/health/#setting");
				driver.navigate().refresh();
				break;
			} else if (ur.equals("https://www.test.75health.com/")) {
				javascriptclick(pom.getInstanceSetting().clickSettings);
				driver.navigate().refresh();
				break;
			}

		}

		WebElement cdsclick = driver.findElement(By.xpath("//button[contains(text(),'Clinical Decision')]"));
		visbility(driver, cdsclick, 60);
		ww.until(ExpectedConditions.elementToBeClickable(cdsclick));

		WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
		visbility(driver, clicksett, 60);
		javascriptclick(clicksett);
		visbility(driver, cdsclick, 60);
		ScriptExecutor(cdsclick);

		sleep(3000);

		// Set Favorities..

		// Set Favorities..

		driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
		sleep(3000);
		List<WebElement> setfav1 = driver.findElements(By.xpath("//ul[@id='setfavoritesul']/li"));
		for (WebElement w : setfav1) {
			if (w.getText().trim().equals("Item/service")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement clickadditem = driver.findElement(By.xpath(
						"//div[@id='referral']//following::div[4]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, clickadditem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(clickadditem));
				click(clickadditem);
				WebElement sdf = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[1]"));
				visbility(driver, sdf, 60);
				sendkeys(sdf, "test");
				WebElement sdf2 = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[2]"));
				visbility(driver, sdf2, 60);
				sendkeys(sdf2, "5");
				WebElement saveitem = driver.findElement(By.xpath("(//div[@id='ItemKpop2']//following::button[2])[1]"));
				visbility(driver, saveitem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(saveitem));
				click(saveitem);

				sleep(2000);
				WebElement edititem = driver.findElement(By.xpath("//span[text()='test']"));
				visbility(driver, edititem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(edititem));
				actions("click", edititem);
				while (true) {
					try {
						WebElement deleteitem = driver
								.findElement(By.xpath("//div[@id='ItemKpop2']/div[1]/div[2]/span[1]"));
						if (deleteitem.isDisplayed()) {
							click(deleteitem);
							break;
						}

					} catch (Exception e) {

					}
				}

				WebElement itemservicebackarrow = driver
						.findElement(By.xpath("//div[@id='ItemFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, itemservicebackarrow, 60);
				ww.until(ExpectedConditions.elementToBeClickable(itemservicebackarrow));
				javascriptclick(itemservicebackarrow);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().contentEquals("Message")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement addnewfavmessage = driver
						.findElement(By.xpath("(//div[@id='message'])[1]/div[1]/div//following::td[4]/span[2]"));
				visbility(driver, addnewfavmessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(addnewfavmessage));
				javascriptclick(addnewfavmessage);

				WebElement msf = driver.findElement(By.xpath("//textarea[@id='message1']"));

				visbility(driver, msf, 60);
				sendkeys(msf, "hello");
				WebElement savemesssage = driver
						.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
				visbility(driver, savemesssage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(savemesssage));
				javascriptclick(savemesssage);
				sleep(2500);
				WebElement editmessage = driver.findElement(By.xpath("//div[text()='hello']"));
				ww.until(ExpectedConditions.elementToBeClickable(editmessage));
				actions("click", editmessage);
				WebElement deletemessage = driver
						.findElement(By.xpath("//div[@id='MessageKpop2']/div[1]/div[2]/span[1]"));
				visbility(driver, deletemessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(deletemessage));
				javascriptclick(deletemessage);

				sleep(3000);
				WebElement gobackmessage = driver
						.findElement(By.xpath("(//span[text()='Favorite Message'])[1]//following::div[1]/span"));
				visbility(driver, gobackmessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(gobackmessage));
				javascriptclick(gobackmessage);

				sleep(3000);

			} else if (w.getText().trim().equals("Symptoms")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement symptomsAddIcon = driver
						.findElement(By.xpath("(//div[@id='SymptomsFavKpop2']//following::span[5])[1]"));
				visbility(driver, symptomsAddIcon, 30);
				ww.until(ExpectedConditions.elementToBeClickable(symptomsAddIcon));
				click(symptomsAddIcon);

				WebElement SymptomIcdTextBox = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::input[1])[1]"));
				visbility(driver, SymptomIcdTextBox, 40);
				sendkeys(SymptomIcdTextBox, "test");

				List<WebElement> symptomsdrop;
				while (true) {
					try {
						symptomsdrop = driver.findElements(By.xpath(
								"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
						if (symptomsdrop.size() > 5) {
							break;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				for (WebElement web : symptomsdrop) {
					if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
						visbility(driver, web, 60);
						javascriptclick(web);
						break;
					}

				}

				WebElement SymptomDisBox = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::input[2])[1]"));
				visbility(driver, SymptomDisBox, 40);
				sendkeys(SymptomDisBox, "Symptoms");

				WebElement saveSymptom = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::button[2])[1]"));
				visbility(driver, saveSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(saveSymptom));
				click(saveSymptom);
				sleep(2500);
				WebElement editSymptom;
				while (true) {
					try {
						editSymptom = driver.findElement(
								By.xpath("(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]"));
						break;
					} catch (StaleElementReferenceException e) {
						e.printStackTrace();
					}
				}
				visbility(driver, editSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(editSymptom));
				click(editSymptom);

				WebElement deleteSymptom = driver
						.findElement(By.xpath("(//div[@id='SymptomsKpop2']//following::span[2])[1]"));
				visbility(driver, deleteSymptom, 35);
				ww.until(ExpectedConditions.elementToBeClickable(deleteSymptom));
				click(deleteSymptom);
				WebElement closeSymptomIcon = driver
						.findElement(By.xpath("(//div[@id='SymptomsFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeSymptomIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(closeSymptomIcon));
				click(closeSymptomIcon);

				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().equals("Problems")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				WebElement ProblemsAddIcon = driver
						.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']//following::span[5])[1]"));
				visbility(driver, ProblemsAddIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(ProblemsAddIcon));
				click(ProblemsAddIcon);

				WebElement ProblemsIcdBox = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[1])[1]"));
				visbility(driver, ProblemsIcdBox, 40);
				sendkeys(ProblemsIcdBox, "test");
				try {
					Problems problem = new Problems(driver);
					problem.$favproblemsIcdCode();
				} catch (Exception e) {

					e.printStackTrace();
				}
				WebElement problemTextBox = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[2])[1]"));
				visbility(driver, problemTextBox, 40);
				sendkeys(problemTextBox, "Problems");
				WebElement saveProblem = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::button[2])[1]"));
				visbility(driver, saveProblem, 40);
				ww.until(ExpectedConditions.elementToBeClickable(saveProblem));
				click(saveProblem);
				sleep(2500);
				WebElement editProblem = driver
						.findElement(By.xpath("(//span[text()='Malignant neoplasm of testis'])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(editProblem));
				click(editProblem);
				sleep(2000);
				WebElement deleteProblem = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteProblem));
				click(deleteProblem);
				WebElement closeProblemIcon = driver
						.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeProblemIcon));
				click(closeProblemIcon);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Visit Reason")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				try {
					WebElement VisitReasonAddIcon = driver
							.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]"));
					visbility(driver, VisitReasonAddIcon, 40);
					elementClickable(VisitReasonAddIcon);
					click(VisitReasonAddIcon);
				} catch (ElementClickInterceptedException e) {
					WebElement VisitReasonAddIcon = driver
							.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[5])[1]"));
					visbility(driver, VisitReasonAddIcon, 40);
					elementClickable(VisitReasonAddIcon);
					click(VisitReasonAddIcon);
				}
				ww.until(ExpectedConditions
						.elementToBeClickable(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav));
				click(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav);
				List<WebElement> $TypeDropdown = driver
						.findElements(By.xpath("(//button[@id='admissionVal_dropdown'])[1]//following::ul[1]/li/a"));

				for (WebElement Element : $TypeDropdown) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						click(Element);
						break;
					}

				}
				WebElement VisitReasonDiscription = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
				visbility(driver, VisitReasonDiscription, 40);
				sendkeys(VisitReasonDiscription, "VisitReason");

				WebElement saveVisitReason = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveVisitReason));
				click(saveVisitReason);
				sleep(2500);
				WebElement editVisitReason = driver.findElement(By.xpath("(//div[text()='VisitReason'])[1]"));
				visbility(driver, editVisitReason, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editVisitReason));
				click(editVisitReason);
				WebElement deleteVisitReason = driver
						.findElement(By.xpath("(//div[@id='Visit_ReasonKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteVisitReason));
				click(deleteVisitReason);

				WebElement closeVisitReason = driver
						.findElement(By.xpath("(//div[@id='Visit_ReasonFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeVisitReason));
				click(closeVisitReason);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Procedure")) {

				visbility(driver, w, 40);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);
				WebElement PreocedureSetFavAddIcon = driver
						.findElement(By.xpath("(//div[@id='ProcedureFavKpop2']//following::span[5])[1]"));
				visbility(driver, PreocedureSetFavAddIcon, 40);
				ww.until(ExpectedConditions.elementToBeClickable(PreocedureSetFavAddIcon));
				click(PreocedureSetFavAddIcon);

				WebElement SetfavprocedureCodeTypeDropdown = driver.findElement(By.xpath("//select[@id='codeType']"));
				visbility(driver, SetfavprocedureCodeTypeDropdown, 60);
				ww.until(ExpectedConditions.elementToBeClickable(SetfavprocedureCodeTypeDropdown));
				click(SetfavprocedureCodeTypeDropdown);

				dropDown("text", SetfavprocedureCodeTypeDropdown, "SNOMED CT");

				WebElement SetfavProcedureIcdBox = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::input[1])[1]"));
				visbility(driver, SetfavProcedureIcdBox, 40);
				sendkeys(SetfavProcedureIcdBox, "test");

				List<WebElement> prcddropdwn;
				;
				while (true) {
					try {
						prcddropdwn = driver.findElements(By.xpath(
								"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div/small/em"));
						if (prcddropdwn.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}
				for (WebElement web : prcddropdwn) {

					if (web.getText().trim().equals("SNOMED : 134287002")) {
						// System.out.println("procedure met..");
						visbility(driver, web, 60);
						javascriptclick(web);
						break;

					}

				}

				WebElement SetFavProcedureTextbox = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::input[2])[1]"));
				visbility(driver, SetFavProcedureTextbox, 40);
				sendkeys(SetFavProcedureTextbox, "procedure");

				WebElement saveSetFavProcedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::button[2])[1]"));
				visbility(driver, saveSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(saveSetFavProcedure));
				click(saveSetFavProcedure);
				sleep(2500);

				WebElement editSetFavProcedure = driver.findElement(
						By.xpath("(//div[text()='134287002: Cytomegalovirus antigen test (procedure)'])[1]"));
				visbility(driver, editSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editSetFavProcedure));
				click(editSetFavProcedure);

				WebElement deleteProcedureSetFav = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteProcedureSetFav));
				click(deleteProcedureSetFav);

				WebElement closeSetFavProcedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeSetFavProcedure, 40);
				ww.until(ExpectedConditions.elementToBeClickable(closeSetFavProcedure));
				click(closeSetFavProcedure);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().equals("Medications")) {
				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement MedicationAddIcon = driver
						.findElement(By.xpath("(//div[@id='MedicationsFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(MedicationAddIcon));
				click(MedicationAddIcon);

				WebElement MedicationIcdBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[1])[1]"));
				visbility(driver, MedicationIcdBoxSetfav, 40);
				sendkeys(MedicationIcdBoxSetfav, "1009");
				visbility(driver, MedicationIcdBoxSetfav, 40);
				clear(MedicationIcdBoxSetfav);
				sendkeys(MedicationIcdBoxSetfav, "1009");
				List<WebElement> $med$drop$down$;

				while (true) {
					try {
						$med$drop$down$ = driver.findElements(By.xpath(
								"//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[2]/li/a/div/small/em"));
						if ($med$drop$down$.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}

				for (WebElement we : $med$drop$down$) {
					System.out.println(we.getText());
					if (we.getText().trim().equals("RXNORM : 1009145")) {
						// System.out.println("med cond met");
						visbility(driver, we, 60);
						javascriptclick(we);
						break;

					}

				}

				WebElement savemedicationSetFav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::button[3])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(savemedicationSetFav));
				click(savemedicationSetFav);
				sleep(2500);
				WebElement editmedicationSetFav = driver.findElement(By.xpath(
						"(//div[text()='amphetamine aspartate 1.875 MG / amphetamine sulfate 1.875 MG / dextroamphetamine saccharate 1.875 MG / dextroamphetamine sulfate 1.875 MG Oral Tablet 1.875 MG / 1.875 MG / 1.875 MG / 1.875 MG'])[1]"));
				visbility(driver, editmedicationSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editmedicationSetFav));
				click(editmedicationSetFav);

				WebElement deletemedsetfav = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deletemedsetfav));
				click(deletemedsetfav);

				WebElement closemedicationSetFav = driver
						.findElement(By.xpath("(//div[@id='MedicationsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closemedicationSetFav));
				click(closemedicationSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Test Order")) {
				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement TestOrderAddIcon = driver
						.findElement(By.xpath("(//div[@id='Test_OrderFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(TestOrderAddIcon));
				click(TestOrderAddIcon);

				WebElement TestOrderIcdBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::input[1])[1]"));
				visbility(driver, TestOrderIcdBoxSetfav, 40);
				sendkeys(TestOrderIcdBoxSetfav, "test");

				WebElement saveTestOrderSetFav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveTestOrderSetFav));
				click(saveTestOrderSetFav);
				sleep(2500);
				WebElement editTestOrderSetFav = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
				visbility(driver, editTestOrderSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editTestOrderSetFav));
				click(editTestOrderSetFav);

				WebElement deleteTestOrdersetfav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteTestOrdersetfav));
				click(deleteTestOrdersetfav);

				WebElement closeTestOrderSetFav = driver
						.findElement(By.xpath("(//div[@id='Test_OrderFavKpop2']//following::span[1])[1]"));
				visbility(driver, closeTestOrderSetFav, 50);
				ww.until(ExpectedConditions.elementToBeClickable(closeTestOrderSetFav));
				click(closeTestOrderSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Vaccine")) {

				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement VaccineAddIcon = driver
						.findElement(By.xpath("(//div[@id='VaccineFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(VaccineAddIcon));
				click(VaccineAddIcon);

				WebElement vaccineIcdTextBox = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::input[1])[1]"));
				visbility(driver, vaccineIcdTextBox, 40);
				sendkeys(vaccineIcdTextBox, "vacc");

				List<WebElement> vc4;
				while (true) {

					vc4 = driver.findElements(By.xpath(
							//// div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[2]/li/a/span[2]

							"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));

					if (vc4.size() >= 5) {
						System.out.println(vc4.size());
						break;
					}
				}

				for (WebElement web : vc4) {
					System.out.println(web.getText());

					if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
						web.click();
						break;
					}

				}

				WebElement VaccDisBoxSetfav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::input[2])[1]"));
				visbility(driver, VaccDisBoxSetfav, 40);
				sendkeys(VaccDisBoxSetfav, "vaccine");

				WebElement saveVaccineSetFav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveVaccineSetFav));
				click(saveVaccineSetFav);
				sleep(2500);
				WebElement editVaccSetFav = driver
						.findElement(By.xpath("(//div[text()='105: vaccinia (smallpox) diluted'])[1]"));
				visbility(driver, editVaccSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editVaccSetFav));
				click(editVaccSetFav);

				WebElement deleteVaccsetfav = driver
						.findElement(By.xpath("(//div[@id='VaccineKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteVaccsetfav));
				click(deleteVaccsetfav);

				WebElement closeVaccSetFav = driver
						.findElement(By.xpath("(//div[@id='VaccineFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeVaccSetFav));
				click(closeVaccSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			} else if (w.getText().trim().equals("Goals")) {

				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement GoalsAddIcon = driver
						.findElement(By.xpath("(//div[@id='GoalsFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(GoalsAddIcon));
				click(GoalsAddIcon);

				WebElement GoalsTextBox = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]"));
				visbility(driver, GoalsTextBox, 40);
				sendkeys(GoalsTextBox, "goals");

				WebElement saveGoalSetFav = driver
						.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]//following::button[2]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveGoalSetFav));
				click(saveGoalSetFav);
				sleep(2500);
				WebElement editGoalSetFav = driver.findElement(By.xpath("(//div[text()='goals'])[1]"));
				visbility(driver, editGoalSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editGoalSetFav));
				click(editGoalSetFav);

				WebElement deleteGoalssetfav = driver
						.findElement(By.xpath("(//div[@id='GoalsKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteGoalssetfav));
				click(deleteGoalssetfav);

				WebElement closeGoalsSetFav = driver
						.findElement(By.xpath("(//div[@id='GoalsFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeGoalsSetFav));
				click(closeGoalsSetFav);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}
			}

		}
		sleep(2500);
		// Hospital codes... // Item/service code...

		visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
		elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		click(pom.getInstanceSetting().hospitalcodeButton);

		for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) {
			if (w.getText().trim().equals("Item/Service Code")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement itemcodeadd = driver.findElement(
						By.xpath("//div[@id='Item_ServiceHosKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"));
				visbility(driver, itemcodeadd, 60);
				elementClickable(itemcodeadd);
				click(itemcodeadd);

				WebElement itemdis = driver
						.findElement(By.xpath("(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[2])[1]"));
				visbility(driver, itemdis, 60);
				sendkeys(itemdis, "160899");

				WebElement code2 = driver
						.findElement(By.xpath("(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[3])[1]"));
				visbility(driver, code2, 60);
				sendkeys(code2, "Birthday");

				WebElement code3 = driver
						.findElement(By.xpath("(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[4])[1]"));
				visbility(driver, code3, 60);
				sendkeys(code3, "5");

				WebElement hg = driver
						.findElement(By.xpath("(//div[@id='Item_ServiceHosKpop2']/div[2]//following::button[2])[1]"));

				visbility(driver, hg, 60);
				elementClickable(hg);
				click(hg);

				sleep(3000);

				try {
					WebElement cc = driver.findElement(By.xpath("//div[text()='160899']"));
					visbility(driver, cc, 40);
					elementClickable(cc);
					click(cc);

				} catch (Exception e) {
					WebElement cc = driver.findElement(By.xpath("//div[text()='160899']"));
					visbility(driver, cc, 40);
					elementClickable(cc);
					click(cc);
				}

				try {
					WebElement vv = driver
							.findElement(By.xpath("(//div[@id='Item_ServiceKpop2']//following::span[2])[1]"));
					visbility(driver, vv, 40);
					elementClickable(vv);
					click(vv);
				} catch (ElementClickInterceptedException e) {
					WebElement vv = driver
							.findElement(By.xpath("(//div[@id='Item_ServiceKpop2']//following::span[2])[1]"));
					visbility(driver, vv, 40);
					elementClickable(vv);
					click(vv);
				}
				WebElement th = driver
						.findElement(By.xpath("(//div[@id='Item_ServiceHosKpop2']//following::span[1])[1]"));
				visbility(driver, th, 60);
				elementClickable(th);
				click(th);
				sleep(2500);
				driver.navigate().refresh();
				sleep(3000);
				implicitWait(30, TimeUnit.SECONDS);
				try {
					System.out.println("ENTER ");
					visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
					elementClickable(pom.getInstanceSetting().hospitalcodeButton);
					click(pom.getInstanceSetting().hospitalcodeButton);
				} catch (StaleElementReferenceException | ElementClickInterceptedException a) {
					System.out.println("item service exp");
					visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
					elementClickable(pom.getInstanceSetting().hospitalcodeButton);
					click(pom.getInstanceSetting().hospitalcodeButton);
					System.out.println("click hospital code");

				}
				break;
			}
		}

		for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) {
			if (w.getText().trim().equals("Procedure Code")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement addnewprocedurecode = driver
						.findElement(By.xpath("(//div[@id='ProcedureHosKpop2']//following::span[6])[1]"));
				visbility(driver, addnewprocedurecode, 60);
				elementClickable(addnewprocedurecode);
				click(addnewprocedurecode);

				WebElement prcd2 = driver
						.findElement(By.xpath("(//div[@id='ProcedureHosKpop2']//following::input[2])[1]"));
				visbility(driver, prcd2, 60);
				sendkeys(prcd2, "Procedure12");

				WebElement prcd3 = driver
						.findElement(By.xpath("(//div[@id='ProcedureHosKpop2']//following::input[3])[1]"));
				visbility(driver, prcd3, 60);
				sendkeys(prcd3, "medicine");
				WebElement prcd4 = driver
						.findElement(By.xpath("(//div[@id='ProcedureHosKpop2']//following::input[4])[1]"));
				visbility(driver, prcd4, 60);
				sendkeys(prcd4, "2");

				WebElement saveprocedure = driver
						.findElement(By.xpath("(//div[@id='ProcedureHosKpop2']//following::button[2])[1]"));
				visbility(driver, saveprocedure, 60);
				elementClickable(saveprocedure);
				click(saveprocedure);

				sleep(3000);

				try {
					WebElement editprocedure = driver.findElement(By.xpath("//div[text()='PROCEDURE12']"));
					visbility(driver, editprocedure, 60);
					elementClickable(editprocedure);
					click(editprocedure);

				} catch (Exception e) {

				}

				WebElement delprocd = driver
						.findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[2])[1]"));
				visbility(driver, delprocd, 60);
				elementClickable(delprocd);
				click(delprocd);

				WebElement gobackproced = driver
						.findElement(By.xpath("(//div[@id='ProcedureHosKpop2']//following::span[1])[1]"));
				visbility(driver, gobackproced, 60);
				elementClickable(gobackproced);
				click(gobackproced);

				sleep(2500);

				try {
					visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 40);
					elementClickable(pom.getInstanceSetting().hospitalcodeButton);
					click(pom.getInstanceSetting().hospitalcodeButton);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 40);
					elementClickable(pom.getInstanceSetting().hospitalcodeButton);
					click(pom.getInstanceSetting().hospitalcodeButton);
				}
				break;
			}

		}

		for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) {
			if (w.getText().trim().equals("Medication Code")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement clickaddmedd = driver
						.findElement(By.xpath("(//div[@id='MedicationsHosKpop2']//following::span[6])[1]"));
				visbility(driver, clickaddmedd, 60);
				elementClickable(clickaddmedd);
				click(clickaddmedd);

				WebElement md2 = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[1])[1]"));
				visbility(driver, md2, 60);
				sendkeys(md2, "MED1");
				WebElement med3 = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[2])[1]"));
				visbility(driver, med3, 60);
				sendkeys(med3, "medication med");
				WebElement med4 = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[3])[1]"));
				visbility(driver, med4, 60);
				sendkeys(med4, "powerful");
				WebElement med5 = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[4])[1]"));
				visbility(driver, med5, 60);
				sendkeys(med5, "kaaspro");
				WebElement med6 = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::input[5])[1]"));
				visbility(driver, med6, 60);
				sendkeys(med6, "3");
				WebElement savemedication = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::button[2])[1]"));
				visbility(driver, savemedication, 60);
				elementClickable(savemedication);
				click(savemedication);
				sleep(3000);

				try {
					WebElement editmedication = driver.findElement(By.xpath("(//div[text()='MED1'])[1]"));
					visbility(driver, editmedication, 60);
					elementClickable(editmedication);
					click(editmedication);

				} catch (Exception e) {
					WebElement editmedication = driver.findElement(By.xpath("(//div[text()='MED1'])[1]"));
					visbility(driver, editmedication, 60);
					elementClickable(editmedication);
					click(editmedication);
				}

				sleep(3000);
				WebElement delmed = driver
						.findElement(By.xpath("(//div[@id='MedicationsKpop2']//following::span[2])[1]"));
				visbility(driver, delmed, 60);
				elementClickable(delmed);
				click(delmed);

				WebElement gobackmed = driver
						.findElement(By.xpath("(//div[@id='MedicationsHosKpop2']//following::span[1])[1]"));
				visbility(driver, gobackmed, 60);
				elementClickable(gobackmed);
				click(gobackmed);
				sleep(3000);
				break;

			}

		}

	}
}
