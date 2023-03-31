package org.PageModules;

import java.util.List;

import org.Launch.LaunchBrowser;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.data.ConfigManager;
import com.github.dockerjava.api.model.Config;
import com.healthRec.Tc_010Problems;

public class Settings extends LaunchBrowser {

	@Test
	public static void settingsModule() {
		visbility(driver, pom.getInstanceSetting().clickSettings, 40);
		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		visbility(driver, pom.getInstanceSetting().manageYorAccount, 40);
		clickIntercept(pom.getInstanceSetting().manageYorAccount, 30);
		sleep(2500);
		visbility(driver, pom.getInstanceSetting().basicInfoEditIcon, 30);
		clickIntercept(pom.getInstanceSetting().basicInfoEditIcon, 30);

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			System.out.println("ENTER HOSPITAL NAME");
			visbility(driver, pom.getInstanceSetting().hosipitalName, 40);
			clear(pom.getInstanceSetting().hosipitalName);
			sendkeys(pom.getInstanceSetting().hosipitalName, "75health org");
			clickIntercept(pom.getInstanceSetting().basicInfoTitle, 30);

			for (WebElement choose : pom.getInstanceSetting().basicInfoTitleDropdown) {
				if (choose.getText().trim().equals("Dr")) {

					visbility(driver, choose, 60);
					clickIntercept(choose, 30);

					break;
				}

			}
		}

		visbility(driver, pom.getInstanceSetting().firstName, 40);
		clear(pom.getInstanceSetting().firstName);
		sendkeys(pom.getInstanceSetting().firstName, "Automation Acc");

		visbility(driver, pom.getInstanceSetting().lastName, 40);
		clear(pom.getInstanceSetting().lastName);
		sendkeys(pom.getInstanceSetting().lastName, "Automation Acc");
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			clickIntercept(pom.getInstanceSetting().basicInfoAdminstatus, 30);

			for (WebElement status : pom.getInstanceSetting().basicInfoAdminstatusDropdown) {
				if (status.getText().trim().equals("ACTIVE")) {
					visbility(driver, status, 40);
					clickIntercept(status, 30);

					break;
				}

			}
			if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
				clickIntercept(pom.getInstanceSetting().basicInfoSmsNotication, 30);

				for (WebElement web : pom.getInstanceSetting().basicInfoSmsNoticationDropdown) {
					if (web.getText().trim().equals("ON")) {
						visbility(driver, web, 60);
						clickIntercept(web, 30);

						break;
					}

				}
			}
			clickIntercept(pom.getInstanceSetting().basicInfoSave, 30);

		} else {

			clickIntercept(pom.getInstanceSetting().basicInfoSavedrLogin, 30);
		}
		log.info("basic info saved");
		sleep(1000);

		// Contact info..
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			try {
				visbility(driver, pom.getInstanceSetting().conatctInfoEditIcon, 40);
				clickIntercept(pom.getInstanceSetting().conatctInfoEditIcon, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().conatctInfoEditIcon, 40);
				elementClickable(pom.getInstanceSetting().conatctInfoEditIcon);
				click(pom.getInstanceSetting().conatctInfoEditIcon);
			}

			visbility(driver, pom.getInstanceSetting().contactInfoAddressLine1, 40);
			clear(pom.getInstanceSetting().contactInfoAddressLine1);
			sendkeys(pom.getInstanceSetting().contactInfoAddressLine1, "no.224,Main avenue");
			visbility(driver, pom.getInstanceSetting().contactInfoAddressLine2, 40);
			clear(pom.getInstanceSetting().contactInfoAddressLine2);
			sendkeys(pom.getInstanceSetting().contactInfoAddressLine2, "watson street usa");

			visbility(driver, pom.getInstanceSetting().contactInfoCity, 40);
			clear(pom.getInstanceSetting().contactInfoCity);
			sendkeys(pom.getInstanceSetting().contactInfoCity, "usa");
			visbility(driver, pom.getInstanceSetting().contactInfoCountry, 40);
			dropDown("text", pom.getInstanceSetting().contactInfoCountry, "Germany");
			visbility(driver, pom.getInstanceSetting().contactInfoState, 40);
			dropDown("text", pom.getInstanceSetting().contactInfoState, "Berlin");
			visbility(driver, pom.getInstanceSetting().contactInfoPostalCode, 30);
			clear(pom.getInstanceSetting().contactInfoPostalCode);
			sendkeys(pom.getInstanceSetting().contactInfoPostalCode, "2001143");

			elementClickable(pom.getInstanceSetting().contactInfoPhone1Flag);
			click(pom.getInstanceSetting().contactInfoPhone1Flag);
			for (WebElement flag : pom.getInstanceSetting().contactInfoPh1FlagDropdown) {
				if (flag.getText().trim().equals("+91")) {
					visbility(driver, flag, 30);
					elementClickable(flag);
					click(flag);
				}

			}

			visbility(driver, pom.getInstanceSetting().contactInfoPhone1field, 30);
			clear(pom.getInstanceSetting().contactInfoPhone1field);
			sendkeys(pom.getInstanceSetting().contactInfoPhone1field, "9898764536");

			elementClickable(pom.getInstanceSetting().contactInfoPhone2Flag);
			click(pom.getInstanceSetting().contactInfoPhone2Flag);
			for (WebElement flag : pom.getInstanceSetting().contactInfoPh2FlagDropdown) {
				if (flag.getText().trim().equals("+91")) {
					visbility(driver, flag, 30);
					elementClickable(flag);
					click(flag);
				}

			}
			visbility(driver, pom.getInstanceSetting().contactInfoPhone2field, 30);
			clear(pom.getInstanceSetting().contactInfoPhone2field);
			sendkeys(pom.getInstanceSetting().contactInfoPhone2field, "9898764536");

			elementClickable(pom.getInstanceSetting().contactInfoSave);
			click(pom.getInstanceSetting().contactInfoSave);

		}
		// specailaity
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().equalsIgnoreCase("premium")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().accountType().contains("admin")) {

			try {

				visbility(driver, pom.getInstanceSetting().specialtyAddIcon, 40);
				clickIntercept(pom.getInstanceSetting().specialtyAddIcon, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().specialtyAddIcon, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcon);
				click(pom.getInstanceSetting().specialtyAddIcon);
			}
		} else if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.equalsIgnoreCase("premium")) {
			try {

				visbility(driver, pom.getInstanceSetting().specialtyAddIcondrLogin, 40);
				clickIntercept(pom.getInstanceSetting().specialtyAddIcondrLogin, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().specialtyAddIcondrLogin, 40);
				elementClickable(pom.getInstanceSetting().specialtyAddIcondrLogin);
				click(pom.getInstanceSetting().specialtyAddIcondrLogin);
			}
		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			visbility(driver, pom.getInstanceSetting().specialtyEnter, 40);

			String rand = RandomStringUtils.randomAlphabetic(20);
			sendkeys(pom.getInstanceSetting().specialtyEnter, rand);
			try {
				elementClickable(pom.getInstanceSetting().specialtySave);
				click(pom.getInstanceSetting().specialtySave);
			} catch (Exception e) {
				elementClickable(pom.getInstanceSetting().specialtySave);
				click(pom.getInstanceSetting().specialtySave);
			}
		}
		// patient info
		try {
			visbility(driver, pom.getInstanceSetting().patientInfoeditIcon, 30);
			clickIntercept(pom.getInstanceSetting().patientInfoeditIcon, 30);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceSetting().patientInfoeditIcon, 30);
			elementClickable(pom.getInstanceSetting().patientInfoeditIcon);
			click(pom.getInstanceSetting().patientInfoeditIcon);
		}

		try {
			elementClickable(pom.getInstanceSetting().patientInfoGender);
			click(pom.getInstanceSetting().patientInfoGender);
		} catch (Exception e) {
			elementClickable(pom.getInstanceSetting().patientInfoGender);
			click(pom.getInstanceSetting().patientInfoGender);
		}

		for (WebElement web : pom.getInstanceSetting().patientInfoGenderDrop) {
			if (web.getText().trim().equals("Male")) {
				visbility(driver, web, 60);
				elementClickable(web);
				click(web);
				break;
			}

		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")) {
			visbility(driver, pom.getInstanceSetting().patinetInfoEducation, 30);
			clear(pom.getInstanceSetting().patinetInfoEducation);
			sendkeys(pom.getInstanceSetting().patinetInfoEducation, "B.tech");

			visbility(driver, pom.getInstanceSetting().patientInfoLicense, 30);
			clear(pom.getInstanceSetting().patientInfoLicense);
			sendkeys(pom.getInstanceSetting().patientInfoLicense, "trt43534");
		}
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			elementClickable(pom.getInstanceSetting().patientInfoSave);
			click(pom.getInstanceSetting().patientInfoSave);
		} else if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("user")) {
			elementClickable(pom.getInstanceSetting().patientInfoSavedrLogin);
			click(pom.getInstanceSetting().patientInfoSavedrLogin);
		}

		navigateback(1);
		log.info("back t0 settings");

		while (true) {

			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#setting")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#setting")) {
				break;
			}
		}

		// Manage users...

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
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
				click(pom.getInstanceSetting().manageuserAddNewUser);
			}
			visbility(driver, pom.getInstanceSetting().MangerUserFirstName, 30);
			sendkeys(pom.getInstanceSetting().MangerUserFirstName, "KAASPRO");
			visbility(driver, pom.getInstanceSetting().ManageUserLastNmae, 30);
			sendkeys(pom.getInstanceSetting().ManageUserLastNmae, "ENTERPRISES");

			String random = RandomStringUtils.randomAlphabetic(25);
			visbility(driver, pom.getInstanceSetting().manageuserEmailId, 30);
			sendkeys(pom.getInstanceSetting().manageuserEmailId, random + "@gmail.com");
			try {

				elementClickable(pom.getInstanceSetting().manageUserType);
				clickIntercept(pom.getInstanceSetting().manageUserType, 30);
			} catch (ElementClickInterceptedException e) {
				elementClickable(pom.getInstanceSetting().manageUserType);
				clickIntercept(pom.getInstanceSetting().manageUserType, 30);
			}
			for (WebElement web : pom.getInstanceSetting().manageUserTypeDrop) {
				if (web.getText().trim().equals("Standard User")) {
					visbility(driver, web, 60);
					elementClickable(web);
					clickIntercept(web, 30);
					break;
				}

			}

			clickIntercept(pom.getInstanceSetting().createuser, 30);

			while (true) {
				if (driver.getCurrentUrl().equals("https://localhost:8443/health/#user")) {
					break;
				} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#user")) {
					break;
				} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#user")) {
					break;
				}
			}

			if (url.equals("https://localhost:8443/")) {
				driver.navigate().to("https://localhost:8443/health/#setting");

			} else if (url.equals("https://www.75health.com/login.jsp")) {
				driver.navigate().to("https://www.75health.com/health/#setting");
			} else if (url.equals("https://www.test.75health.com/")) {
				driver.navigate().to("https://www.test.75health.com/health/#setting");
			}
		}

		// manage Branding (enterprise)
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().equalsIgnoreCase("premium70")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {
			visbility(driver, pom.getInstanceSetting().manageBrandingClick, 40);
			clickIntercept(pom.getInstanceSetting().manageBrandingClick, 30);

			visbility(driver, pom.getInstanceSetting().manageBrandingOrgNameDiscription, 30);
			clear(pom.getInstanceSetting().manageBrandingOrgNameDiscription);
			sendkeys(pom.getInstanceSetting().manageBrandingOrgNameDiscription, "75 Health Organisation");

			clickIntercept(pom.getInstanceSetting().manageBrandingSetName, 30);

			clickIntercept(pom.getInstanceSetting().manageBrandingEmailPreview, 30);

			for (WebElement mb : pom.getInstanceSetting().manageBrandingEmailPreviewDropdown) {
				System.out.println(mb);

				if (mb.getText().trim().equals("Patient Account Creation")
						| mb.getText().trim().equals("Patient Account Re-Activation")
						| mb.getText().trim().equals("Doctor appointment send patient")
						| mb.getText().trim().equals("Doctor appointment cancel")
						| mb.getText().trim().equals("Doctor appointment reject")
						| mb.getText().trim().equals("Appointment request send patient")
						| mb.getText().trim().equals("Patient referral notification")
						| mb.getText().trim().equals("Patient lab detail email")
						| mb.getText().trim().equals("Patient pharmacy detail email")
						| mb.getText().trim().equals("Completed health record")) {
					visbility(driver, mb, 40);
					clickIntercept(mb, 30);

					sleep(2000);

					clickIntercept(pom.getInstanceSetting().manageBrandingPreviewClick, 30);
					sleep(2000);
					clickIntercept(pom.getInstanceSetting().manageBrandingCancelWindow, 30);
					sleep(2000);
					clickIntercept(pom.getInstanceSetting().manageBrandingEmailPreview, 30);
				}

			}
			navigateback(1);
		}
		for (WebElement w : pom.getInstanceSetting().autoLogoutDrop) {

			if (w.getText().trim().equals("2 Hour")) {
				visbility(driver, w, 60);
				clickIntercept(w, 30);

				break;
			}

		}
		sleep(1000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")) {

			clickIntercept(pom.getInstanceSetting().hospitalServiceChargeTaxclick, 30);

			visbility(driver, pom.getInstanceSetting().hospitalServiceChargeTaxdropclick, 40);

			clickIntercept(pom.getInstanceSetting().hospitalServiceChargeTaxdropclick, 30);

			visbility(driver, pom.getInstanceSetting().hospitalTaxAddnewTax, 30);

			clickIntercept(pom.getInstanceSetting().hospitalTaxAddnewTax, 30);

			visbility(driver, pom.getInstanceSetting().hospitalTaxdiscription, 30);
			sendkeys(pom.getInstanceSetting().hospitalTaxdiscription, "DK");

			visbility(driver, pom.getInstanceSetting().hospitalTaxPercentage, 30);
			sendkeys(pom.getInstanceSetting().hospitalTaxPercentage, "5");

			clickIntercept(pom.getInstanceSetting().hospitaltaxSave, 30);

			try {
				visbility(driver, pom.getInstanceSetting().editHospitalTax, 30);
				clickIntercept(pom.getInstanceSetting().editHospitalTax, 30);

			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().editHospitalTax, 30);
				clickIntercept(pom.getInstanceSetting().editHospitalTax, 30);
			}

			try {
				visbility(driver, pom.getInstanceSetting().deleteHospitalTAX, 30);
				clickIntercept(pom.getInstanceSetting().deleteHospitalTAX, 30);
			} catch (Exception e) {
				visbility(driver, pom.getInstanceSetting().deleteHospitalTAX, 30);
				clickIntercept(pom.getInstanceSetting().deleteHospitalTAX, 30);
			}

			visbility(driver, pom.getInstanceSetting().closeHospitalTax, 30);
			clickIntercept(pom.getInstanceSetting().closeHospitalTax, 30);

		}
		sleep(2500);
		// cds

		visbility(driver, pom.getInstanceSetting().cdsClick, 30);

		clickIntercept(pom.getInstanceSetting().cdsClick, 30);

		visbility(driver, pom.getInstanceSetting().addnewCds, 30);
		clickIntercept(pom.getInstanceSetting().addnewCds, 30);

		visbility(driver, pom.getInstanceSetting().enterCds, 30);
		sendkeys(pom.getInstanceSetting().enterCds, "Akash");

		sleep(2000);
		WebElement scrolltill = driver.findElement(By.xpath("//input[@id='weight_from']"));
		ScriptExecutor(scrolltill);

		sleep(2000);
		visbility(driver, pom.getInstanceSetting().cdsIcd, 30);
		sendkeys(pom.getInstanceSetting().cdsIcd, "test");
		sleep(3000);
		if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			visbility(driver, pom.getInstanceSetting().CdsicdList, 30);
			elementClickable(pom.getInstanceSetting().CdsicdList);
			click(pom.getInstanceSetting().CdsicdList);

			visbility(driver, pom.getInstanceSetting().cdsCheckbox, 30);
			clickIntercept(pom.getInstanceSetting().cdsCheckbox, 30);

			clickIntercept(pom.getInstanceSetting().saveCds, 30);

			sleep(3000);
		}
		visbility(driver, pom.getInstanceSetting().clickSettings, 40);

		clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		sleep(1000);
		ScriptExecutor(pom.getInstanceSetting().cdsClick);

		// Set Favorities..

		visbility(driver, pom.getInstanceSetting().setFavoritesClick, 40);
		clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

		for (WebElement w : pom.getInstanceSetting().setFavoriteListDrop) {
			if (w.getText().trim().equals("Item/service")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setfavoritesItemServiceAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDiscription, 60);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServiceDiscription, "test");
				visbility(driver, pom.getInstanceSetting().setFavoritesItemServicePrice, 40);
				sendkeys(pom.getInstanceSetting().setFavoritesItemServicePrice, "5");

				clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceEdit, 40);
					/* elementClickable(pom.getInstanceSetting().setFavoritesItemServiceEdit); */
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceEdit, 30);

				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceEdit, 40);
					elementClickable(pom.getInstanceSetting().setFavoritesItemServiceEdit);
					click(pom.getInstanceSetting().setFavoritesItemServiceEdit);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceDelete, 30);
				}

				try {

					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceClose, 30);
				} catch (Exception e) {
					clickIntercept(pom.getInstanceSetting().setFavoritesItemServiceClose, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().contentEquals("Message")) {
				visbility(driver, w, 40);
				clickIntercept(w, 30);

				try {

					visbility(driver, pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageAddIcon, 30);
				}
				visbility(driver, pom.getInstanceSetting().setFavoritesMessageDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesMessageDiscription, "hello");

				clickIntercept(pom.getInstanceSetting().setFavoritesMessageSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageEdit, 30);

					clickIntercept(pom.getInstanceSetting().setFavoritesMessageEdit, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageEdit, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageEdit, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageDelete, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageDelete, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageClose, 40);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageClose, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesMessageClose, 40);
					clickIntercept(pom.getInstanceSetting().setFavoritesMessageClose, 30);
				}

			} else if (w.getText().trim().equals("Symptoms")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesSymptomsIcd, "test");
				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					while (true) {
						try {

							if (pom.getInstanceSymptom().favoriteicdList.size() > 5) {
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (WebElement web : pom.getInstanceSymptom().favoriteicdList) {
						if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
							visbility(driver, web, 60);
							clickIntercept(web, 30);
							break;
						}

					}
				}
				visbility(driver, pom.getInstanceSetting().setFavoritesSymotomsdiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoritesSymotomsdiscription, "Symptoms");

				clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsSave, 30);
				sleep(1000);
				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					try {
						visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
						clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsedit, 30);

					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
						clickIntercept(pom.getInstanceSetting().setFavoritesSymptomsedit, 30);
					}
				} else {

					try {
						for (int i = 0; i < pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.size(); i++) {
							if (pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.get(i).isDisplayed()) {
								visbility(driver, pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.get(i), 30);
								clickIntercept(pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.get(i), 30);
								break;
							}
						}
					} catch (StaleElementReferenceException e) {
						for (int i = 0; i < pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.size(); i++) {
							if (pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.get(i).isDisplayed()) {
								visbility(driver, pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.get(i), 30);
								clickIntercept(pom.getInstanceSetting().settingsFavoriteSymptomBasicEdit.get(i), 30);
								break;
							}
						}
					}
				}
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsDelete, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteSymtomsClose, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
			} else if (w.getText().trim().equals("Problems")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteProblemsIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteProblemsIcd, "test");
				sleep(2000);
				clickIntercept(pom.getInstanceSetting().setFavoriteProblemsIcd, 30);

				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					try {

						Tc_010Problems.$favproblemsIcdCode();
					} catch (Exception e) {

						e.printStackTrace();
					}
				} else {
					List<WebElement> icd = driver.findElements(By.cssSelector("div[id='ProblemsKpop2'] ul li a"));

					while (true) {
						if (icd.size() >= 1) {
							break;
						}
					}
					for (int i = 0; i < icd.size(); i++) {
						if (icd.get(i).getText().equalsIgnoreCase("test") && icd.get(i).isDisplayed()) {
							clickIntercept(icd.get(i), 30);
							break;
						}
					}
				}
				visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteProblemsDiscription, "Problems");

				clickIntercept(pom.getInstanceSetting().setFavoriteProblemsSave, 30);
				sleep(1000);
				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					try {
						visbility(driver, pom.getInstanceProblems().editFavorite, 30);

						clickIntercept(pom.getInstanceProblems().editFavorite, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceProblems().editFavorite, 30);
						clickIntercept(pom.getInstanceProblems().editFavorite, 30);
					}
				} else {
					try {
						WebElement edit = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
						visbility(driver, edit, 30);
						clickIntercept(edit, 30);
					} catch (StaleElementReferenceException e) {
						WebElement edit = driver.findElement(By.xpath("(//div[text()='test'])[1]"));
						visbility(driver, edit, 30);
						clickIntercept(edit, 30);
					}
				}
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsDelete, 30);

				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsDelete, 30);
				}

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsClose, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProblemsClose, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteProblemsClose, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
			} else if (w.getText().trim().equals("Visit Reason")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);
				try {

					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 30);

				} catch (Exception e) {

					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonAddIcon, 30);
				}
				ww.until(ExpectedConditions
						.elementToBeClickable(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav));
				clickIntercept(pom.getInstanceSetting().selectAppointmentTypeVisitReasonSetFav, 30);

				for (WebElement Element : pom.getInstanceSetting().setFavoriteVisitReasonTypeDrop) {
					System.out.println(Element.getText());
					if (Element.getText().equals("Emergency") && Element.isDisplayed()) {
						visbility(driver, Element, 30);
						clickIntercept(Element, 30);
						break;
					}

				}

				visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonDiscription, 40);
				sendkeys(pom.getInstanceSetting().setFavoriteVisitReasonDiscription, "VisitReason");

				clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonEdit, 40);

					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonEdit, 30);
				} catch (StaleElementReferenceException e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVisitReasonEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasondelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteVisitReasonClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("Procedure")) {

				visbility(driver, w, 40);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteProcedureAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureAddIcon, 30);
				}

				visbility(driver, pom.getInstanceProcedure().favoriteCodeType, 40);

				dropDown("text", pom.getInstanceProcedure().favoriteCodeType, "SNOMED CT");

				visbility(driver, pom.getInstanceProcedure().favoriteIcd, 40);
				sendkeys(pom.getInstanceProcedure().favoriteIcd, "test");

				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					while (true) {

						if (pom.getInstanceSetting().setFavoriteProcedureIcdList.size() > 5) {
							break;
						}

					}
					for (WebElement web : pom.getInstanceSetting().setFavoriteProcedureIcdList) {

						if (web.getText().trim().equals("SNOMED : 134287002")) {

							visbility(driver, web, 60);
							clickIntercept(web, 30);
							break;

						}

					}
				}

				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 40);
					sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure");

					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureSave, 30);
					try {

						sleep(2000);
						visbility(driver, pom.getInstanceSetting().setFavoriteProcedureEdit, 40);
						clickIntercept(pom.getInstanceSetting().setFavoriteProcedureEdit, 30);
					} catch (StaleElementReferenceException e) {

						sleep(1000);
						visbility(driver, pom.getInstanceSetting().setFavoriteProcedureEdit, 40);
						clickIntercept(pom.getInstanceSetting().setFavoriteProcedureEdit, 30);
					}
				} else {
					visbility(driver, pom.getInstanceProcedure().favoriteProcedure, 40);
					sendkeys(pom.getInstanceProcedure().favoriteProcedure, "procedure favorite");
					clickIntercept(pom.getInstanceSetting().setFavoriteProcedureSave, 30);
					sleep(2000);
					try {
						for (int i = 0; i < pom.getInstanceProcedure().editFavoriteBasic.size(); i++) {
							if (pom.getInstanceProcedure().editFavoriteBasic.get(i).isDisplayed()) {
								visbility(driver, pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
								clickIntercept(pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
								break;
							}
						}
					} catch (StaleElementReferenceException e) {
						for (int i = 0; i < pom.getInstanceProcedure().editFavoriteBasic.size(); i++) {
							if (pom.getInstanceProcedure().editFavoriteBasic.get(i).isDisplayed()) {
								visbility(driver, pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
								clickIntercept(pom.getInstanceProcedure().editFavoriteBasic.get(i), 30);
								break;
							}
						}
					}

				}
				clickIntercept(pom.getInstanceSetting().setFavoriteProcedureDelete, 30);
				visbility(driver, pom.getInstanceSetting().setFavoriteProcedureClose, 40);

				clickIntercept(pom.getInstanceSetting().setFavoriteProcedureClose, 30);
				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("djfhjdfhjdfh")) {
				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					visbility(driver, w, 60);
					clickIntercept(w, 30);
					try {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
						clickIntercept(pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);

					} catch (Exception e) {
						visbility(driver, pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
						clickIntercept(pom.getInstanceSetting().setFavoriteMedicationAddIcon, 30);
					}

					visbility(driver, pom.getInstanceSetting().setFavoriteMedicationIcd, 40);
					sendkeys(pom.getInstanceSetting().setFavoriteMedicationIcd, "1009");

					while (true) {
						try {

							if (pom.getInstanceSetting().setFavoriteMedicationIcdList.size() > 5) {
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					for (WebElement we : pom.getInstanceSetting().setFavoriteMedicationIcdList) {
						System.out.println(we.getText());
						if (we.getText().trim().equals("RXNORM : 1009145")) {

							visbility(driver, we, 60);
							clickIntercept(we, 30);
							break;

						}

					}

					clickIntercept(pom.getInstanceSetting().setFavoriteMedicationSave, 30);
					if (url.equals("https://www.75health.com/login.jsp")) {
						try {
							visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
							clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
						} catch (StaleElementReferenceException e) {
							visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
							clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEdit, 30);
						}
					} else if (url.equals("https://localhost:8443/")) {

						try {
							visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
							clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
						} catch (StaleElementReferenceException e) {
							visbility(driver, pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
							clickIntercept(pom.getInstanceSetting().setFavoriteMedicationEditLh, 30);
						}
					} else if (url.equals("https://www.test.75health.com/")) {
						try {
							visbility(driver, pom.getInstanceSetting().setFAoriteeditTestSer, 30);
							clickIntercept(pom.getInstanceSetting().setFAoriteeditTestSer, 30);
						} catch (StaleElementReferenceException e) {
							visbility(driver, pom.getInstanceSetting().setFAoriteeditTestSer, 30);
							clickIntercept(pom.getInstanceSetting().setFAoriteeditTestSer, 30);
						}

					}

					clickIntercept(pom.getInstanceSetting().setFavoriteMedicationDelete, 30);

					clickIntercept(pom.getInstanceSetting().setFavoriteMedicationClose, 30);

					clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
				}

			} else if (w.getText().trim().equals("Test Order")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderIcd, 40);
				sendkeys(pom.getInstanceSetting().setFavoriteTestOrderIcd, "test");

				while (true) {
					if (pom.getInstanceSetting().setFavoriteTestOrderIcdList.size() >= 1) {
						break;
					}
				}

				for (WebElement test : pom.getInstanceSetting().setFavoriteTestOrderIcdList) {

					if (test.getText().trim().equals("test")) {
						visbility(driver, test, 40);
						clickIntercept(test, 30);
						break;
					}
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderEdit, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderDelete, 30);

				visbility(driver, pom.getInstanceSetting().setFavoriteTestOrderClose, 50);

				clickIntercept(pom.getInstanceSetting().setFavoriteTestOrderClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);

			} else if (w.getText().trim().equals("Vaccine")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVaccineAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineAddIcon, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteVaccineAddIcon, 30);
				}

				visbility(driver, pom.getInstanceSetting().setFavoriteVaccineIcd, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteVaccineIcd, "vacc");

				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					while (true) {

						if (pom.getInstanceVaccine().favoriteIcdList.size() >= 5) {

							break;
						}
					}

					for (WebElement web : pom.getInstanceVaccine().favoriteIcdList) {

						if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
							visbility(driver, web, 30);
							clickIntercept(web, 30);
							break;
						}

					}
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineDiscription, 30);
					sendkeys(pom.getInstanceSetting().setFavoriteVaccineDiscription, "vaccine");
				} else {
					visbility(driver, pom.getInstanceSetting().setFavoriteVaccineDiscription, 30);
					sendkeys(pom.getInstanceSetting().setFavoriteVaccineDiscription, "vacine favorite");
				}
				clickIntercept(pom.getInstanceVaccine().favoriteSave, 30);
				sleep(2000);

				if (ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails()
						.contains("premium")) {
					try {
						visbility(driver, pom.getInstanceSetting().setFavoriteVaccineEdit, 40);
						clickIntercept(pom.getInstanceSetting().setFavoriteVaccineEdit, 30);
					} catch (StaleElementReferenceException e) {
						visbility(driver, pom.getInstanceSetting().setFavoriteVaccineEdit, 40);
						clickIntercept(pom.getInstanceSetting().setFavoriteVaccineEdit, 30);
					}

				} else {
					try {
						for (int i = 0; i < pom.getInstanceVaccine().editFavoriteBasic.size(); i++) {
							if (pom.getInstanceVaccine().editFavoriteBasic.get(i).isDisplayed()) {
								clickIntercept(pom.getInstanceVaccine().editFavoriteBasic.get(i), 30);
								break;
							}
						}
					} catch (StaleElementReferenceException e) {
						for (int i = 0; i < pom.getInstanceVaccine().editFavoriteBasic.size(); i++) {
							if (pom.getInstanceVaccine().editFavoriteBasic.get(i).isDisplayed()) {
								clickIntercept(pom.getInstanceVaccine().editFavoriteBasic.get(i), 30);
								break;
							}
						}
					}

				}
				clickIntercept(pom.getInstanceSetting().setFavoriteVaccinedelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteVaccineClose, 30);

				clickIntercept(pom.getInstanceSetting().setFavoritesClick, 30);
			} else if (w.getText().trim().equals("Goals")) {

				visbility(driver, w, 60);
				clickIntercept(w, 30);

				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalsAddIcon, 30);
				}
				visbility(driver, pom.getInstanceSetting().setFavoriteGoalDiscription, 30);
				sendkeys(pom.getInstanceSetting().setFavoriteGoalDiscription, "goals");

				clickIntercept(pom.getInstanceSetting().setFavoriteGoalSave, 30);
				sleep(1000);
				try {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalEdit, 30);
				} catch (Exception e) {
					visbility(driver, pom.getInstanceSetting().setFavoriteGoalEdit, 40);
					clickIntercept(pom.getInstanceSetting().setFavoriteGoalEdit, 30);
				}

				clickIntercept(pom.getInstanceSetting().setFavoriteGoalDelete, 30);

				clickIntercept(pom.getInstanceSetting().setFavoriteGoalClose, 30);

			}

		}

		sleep(2500);
		// Hospital codes... // Item/service code...

		/*
		 * visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton);
		 * 
		 * for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) { if
		 * (w.getText().trim().equals("Item/Service Code")) { while (true) { try {
		 * visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } }
		 * 
		 * sleep(4000);
		 * 
		 * WebElement itemcodeadd = driver.findElement( By.xpath(
		 * "//div[@id='Item_ServiceHosKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]"
		 * )); visbility(driver, itemcodeadd, 60); elementClickable(itemcodeadd);
		 * click(itemcodeadd);
		 * 
		 * WebElement itemdis = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[2])[1]"));
		 * visbility(driver, itemdis, 60); sendkeys(itemdis, "160899");
		 * 
		 * WebElement code2 = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[3])[1]"));
		 * visbility(driver, code2, 60); sendkeys(code2, "Birthday");
		 * 
		 * WebElement code3 = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::input[4])[1]"));
		 * visbility(driver, code3, 60); sendkeys(code3, "5");
		 * 
		 * WebElement hg = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']/div[2]//following::button[2])[1]"));
		 * 
		 * visbility(driver, hg, 60); elementClickable(hg); click(hg);
		 * 
		 * sleep(3000);
		 * 
		 * try { WebElement cc = driver.findElement(By.xpath("//div[text()='160899']"));
		 * visbility(driver, cc, 40); elementClickable(cc); click(cc);
		 * 
		 * } catch (Exception e) { WebElement cc =
		 * driver.findElement(By.xpath("//div[text()='160899']")); visbility(driver, cc,
		 * 40); elementClickable(cc); click(cc); }
		 * 
		 * try { WebElement vv = driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceKpop2']//following::span[2])[1]"));
		 * visbility(driver, vv, 40); elementClickable(vv); click(vv); } catch
		 * (ElementClickInterceptedException e) { WebElement vv = driver
		 * .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceKpop2']//following::span[2])[1]"));
		 * visbility(driver, vv, 40); elementClickable(vv); click(vv); } WebElement th =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='Item_ServiceHosKpop2']//following::span[1])[1]"));
		 * visbility(driver, th, 60); elementClickable(th); click(th); sleep(2500);
		 * 
		 * implicitWait(30, TimeUnit.SECONDS); try { System.out.println("ENTER ");
		 * visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 50);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton); } catch
		 * (StaleElementReferenceException | ElementClickInterceptedException a) {
		 * System.out.println("item service exp"); visbility(driver,
		 * pom.getInstanceSetting().hospitalcodeButton, 50);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton);
		 * System.out.println("click hospital code");
		 * 
		 * } break; } }
		 */

		/*
		 * for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) { if
		 * (w.getText().trim().equals("Procedure Code")) { while (true) { try {
		 * visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } } sleep(3000); try { WebElement addnewprocedurecode = driver
		 * .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::span[6])[1]"));
		 * visbility(driver, addnewprocedurecode, 60);
		 * elementClickable(addnewprocedurecode); click(addnewprocedurecode); } catch
		 * (StaleElementReferenceException | ElementClickInterceptedException e) {
		 * WebElement addnewprocedurecode = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::span[6])[1]"));
		 * visbility(driver, addnewprocedurecode, 60);
		 * elementClickable(addnewprocedurecode); click(addnewprocedurecode); }
		 * WebElement prcd2 = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::input[2])[1]"));
		 * visbility(driver, prcd2, 60); sendkeys(prcd2, "Procedure12");
		 * 
		 * WebElement prcd3 = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::input[3])[1]"));
		 * visbility(driver, prcd3, 60); sendkeys(prcd3, "medicine"); WebElement prcd4 =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::input[4])[1]"));
		 * visbility(driver, prcd4, 60); sendkeys(prcd4, "2");
		 * 
		 * WebElement saveprocedure = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::button[2])[1]"));
		 * visbility(driver, saveprocedure, 60); elementClickable(saveprocedure);
		 * click(saveprocedure);
		 * 
		 * sleep(3000);
		 * 
		 * try { WebElement editprocedure =
		 * driver.findElement(By.xpath("//div[text()='PROCEDURE12']"));
		 * visbility(driver, editprocedure, 60); elementClickable(editprocedure);
		 * click(editprocedure);
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 * 
		 * WebElement delprocd = driver
		 * .findElement(By.xpath("(//div[@id='ProcedureKpop2']//following::span[2])[1]")
		 * ); visbility(driver, delprocd, 60); elementClickable(delprocd);
		 * click(delprocd);
		 * 
		 * WebElement gobackproced = driver .findElement(By.xpath(
		 * "(//div[@id='ProcedureHosKpop2']//following::span[1])[1]"));
		 * visbility(driver, gobackproced, 60); elementClickable(gobackproced);
		 * click(gobackproced);
		 * 
		 * sleep(2500);
		 * 
		 * try { visbility(driver, pom.getInstanceSetting().hospitalcodeButton, 40);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton);
		 * 
		 * } catch (Exception e) { visbility(driver,
		 * pom.getInstanceSetting().hospitalcodeButton, 40);
		 * elementClickable(pom.getInstanceSetting().hospitalcodeButton);
		 * click(pom.getInstanceSetting().hospitalcodeButton); } break; }
		 * 
		 * }
		 */
		/*
		 * for (WebElement w : pom.getInstanceSetting().HosiptalCodeDropDown) { if
		 * (w.getText().trim().equals("Medication Code")) { while (true) { try {
		 * visbility(driver, w, 60); w.click(); break; } catch (Exception e) {
		 * 
		 * } } sleep(3000); WebElement clickaddmedd = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsHosKpop2']//following::span[6])[1]"));
		 * visbility(driver, clickaddmedd, 60); elementClickable(clickaddmedd);
		 * click(clickaddmedd);
		 * 
		 * WebElement md2 = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[1])[1]"));
		 * visbility(driver, md2, 60); sendkeys(md2, "MED1"); WebElement med3 = driver
		 * .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[2])[1]"));
		 * visbility(driver, med3, 60); sendkeys(med3, "medication med"); WebElement
		 * med4 = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[3])[1]"));
		 * visbility(driver, med4, 60); sendkeys(med4, "powerful"); WebElement med5 =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[4])[1]"));
		 * visbility(driver, med5, 60); sendkeys(med5, "kaaspro"); WebElement med6 =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::input[5])[1]"));
		 * visbility(driver, med6, 60); sendkeys(med6, "3"); WebElement savemedication =
		 * driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::button[2])[1]"));
		 * visbility(driver, savemedication, 60); elementClickable(savemedication);
		 * click(savemedication); sleep(3000);
		 * 
		 * try { WebElement editmedication =
		 * driver.findElement(By.xpath("(//div[text()='MED1'])[1]")); visbility(driver,
		 * editmedication, 60); elementClickable(editmedication); click(editmedication);
		 * 
		 * } catch (Exception e) { WebElement editmedication =
		 * driver.findElement(By.xpath("(//div[text()='MED1'])[1]")); visbility(driver,
		 * editmedication, 60); elementClickable(editmedication); click(editmedication);
		 * }
		 * 
		 * sleep(3000); WebElement delmed = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsKpop2']//following::span[2])[1]")); visbility(driver,
		 * delmed, 60); elementClickable(delmed); click(delmed);
		 * 
		 * WebElement gobackmed = driver .findElement(By.xpath(
		 * "(//div[@id='MedicationsHosKpop2']//following::span[1])[1]"));
		 * visbility(driver, gobackmed, 60); elementClickable(gobackmed);
		 * click(gobackmed); sleep(3000); break;
		 * 
		 * }
		 * 
		 * }
		 */

		// forms...
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {
			visbility(driver, pom.getInstanceSetting().customForm, 60);
			clickIntercept(pom.getInstanceSetting().customForm, 30);
			sleep(5000);

			visbility(driver, pom.getInstanceSetting().addNewform, 60);
			clickIntercept(pom.getInstanceSetting().addNewform, 30);
			// actions("click", pom.getInstanceSetting().addNewform);

			sleep(4000);

			visbility(driver, pom.getInstanceSetting().formTitleDiscription, 60);
			String form = RandomStringUtils.randomAlphabetic(30);
			sendkeys(pom.getInstanceSetting().formTitleDiscription, form);

			for (WebElement web : pom.getInstanceSetting().fromdropDown) {

				if (web.getText().trim().equals("Checkbox Group")) {

					Actions ac = new Actions(driver);
					ac.dragAndDrop(web, pom.getInstanceSetting().dropForm).build().perform();

					visbility(driver, pom.getInstanceSetting().formClearLabel, 60);
					clear(pom.getInstanceSetting().formClearLabel);

					visbility(driver, pom.getInstanceSetting().formClearLabel, 60);
					sendkeys(pom.getInstanceSetting().formClearLabel, "Kaaspro Enterprise");

					visbility(driver, pom.getInstanceSetting().saveForm, 60);
					clickIntercept(pom.getInstanceSetting().saveForm, 30);

					sleep(3000);

					break;
				}

			}
			refresh();

		}
		// sleep(3000); // edit preference....

		visbility(driver, pom.getInstanceSetting().printSettingsClick, 60);
		clickIntercept(pom.getInstanceSetting().printSettingsClick, 30);
		sleep(3000);

		visbility(driver, pom.getInstanceSetting().cancelPrintpreference, 60);
		clickIntercept(pom.getInstanceSetting().cancelPrintpreference, 30);

		visbility(driver, pom.getInstanceSetting().resetSettingClick, 60);
		clickIntercept(pom.getInstanceSetting().resetSettingClick, 30);

		visbility(driver, pom.getInstanceSetting().confirmResetSetting, 60);
		clickIntercept(pom.getInstanceSetting().confirmResetSetting, 30);

		sleep(3000);

		// notification

		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {

			boolean b = true;
			while (b) {

				if (!pom.getInstanceSetting().customizeMessage.isDisplayed()) {

					elementClickable(pom.getInstanceSetting().customizeToggle);
					actions("click", pom.getInstanceSetting().customizeToggle);

					clickIntercept(pom.getInstanceSetting().customizeMessage, 30);

					ScriptExecutor(pom.getInstanceSetting().abovePrefernceToggle);
					sleep(2000);
					j.executeScript("window.scrollBy(0,0)");

				}

				b = false;
			}
			sleep(1500);
			while (true) {
				try {
					if (pom.getInstanceSetting().clickSettings.isDisplayed()) {
						clickIntercept(pom.getInstanceSetting().clickSettings, 30);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// notify ehr complte...

			ScriptExecutor(pom.getInstanceSetting().notifyEhrToggle);

			actions("click", pom.getInstanceSetting().notifyEhrToggle);

		}

		// set interval time for emial...
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("admin")
				| ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equalsIgnoreCase("dr")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {

			actions("click", pom.getInstanceSetting().setIntervalToggle);
		}
		// Audit Report...
		if (ConfigManager.getconfigManager().getInstanceConfigReader().accountType().equals("admin")
				&& ConfigManager.getconfigManager().getInstanceConfigReader().getPackageDetails().contains("premium")) {

			visbility(driver, pom.getInstanceSetting().clickSettings, 60);
			clickIntercept(pom.getInstanceSetting().clickSettings, 30);

			driver.navigate().refresh();

			visbility(driver, pom.getInstanceSetting().auditReport, 60);
			clickIntercept(pom.getInstanceSetting().auditReport, 30);
			sleep(3000);

			visbility(driver, pom.getInstanceSetting().AuditReportPatientSerachField, 60);
			sendkeys(pom.getInstanceSetting().AuditReportPatientSerachField, kpid);
			sleep(3000);

			for (WebElement we : pom.getInstanceSetting().AuditReportPatientDropdown) {

				if (we.getText().contains(kpid)) {
					visbility(driver, we, 60);
					clickIntercept(we, 30);
					break;
				}

			}

			sleep(3000);

			visbility(driver, pom.getInstanceSetting().selectDate, 60);
			dropDown("text", pom.getInstanceSetting().selectDate, "All");
			sleep(4000);

			visbility(driver, pom.getInstanceSetting().selectType, 60);
			dropDown("text", pom.getInstanceSetting().selectType, "Allergy");
			sleep(3000);
			navigateback(1);

			driver.navigate().refresh();

			visbility(driver, pom.getInstanceSetting().clickSettings, 60);
			clickIntercept(pom.getInstanceSetting().clickSettings, 30);

		}
		// Dashboard
		WebElement dashboard;

		try {
			dashboard = driver.findElement(By.xpath("(//div[@id='option-setting'])[1]/div/img"));
			visbility(driver, dashboard, 50);
			clickIntercept(dashboard, 30);

		} catch (Exception e) {
			dashboard = driver.findElement(By.xpath("(//div[@id='option-setting'])[1]/div/img"));
			visbility(driver, dashboard, 50);
			clickIntercept(dashboard, 30);
		}
		List<WebElement> ths = driver
				.findElements(By.xpath("(//div[@id='option-setting'])[1]/div/img//following::ul[1]/li"));

		while (true) {

			for (WebElement st : ths) {
				if (st.getText().trim().equals("Home")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Dashboard")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Quick Tour")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					WebElement cncltr = driver.findElement(By.xpath("(//li[text()='NO, CANCEL TOUR'])[1]"));
					visbility(driver, cncltr, 50);
					clickIntercept(cncltr, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Settings")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Migration Services")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);
					WebElement clmgr = driver
							.findElement(By.xpath("//h4[text()='Migration Services']//parent::div/button"));
					sleep(2000);
					visbility(driver, clmgr, 50);
					clickIntercept(clmgr, 30);
					sleep(2000);
					clickIntercept(dashboard, 30);
				} else if (st.getText().trim().equals("Sign out")) {
					visbility(driver, st, 50);
					clickIntercept(st, 30);

					break;
				}

			}
			break;
		}

	}

}
