package org.patientLogin;

import java.util.List;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.calendar.Calendars;

public class PatietAppoint extends Base {

	public void bookAppointment(WebDriver driver, Calendars cal) throws InterruptedException {

		List<WebElement> totalnumberrowdy = driver.findElements(By.xpath("//div[@id='date-data']"));
		int totalr = totalnumberrowdy.size();
		// System.out.println("found you>>>" + totalr);

		boolean cond = false;

		for (int i = 1; i <= totalr; i++) {

			// cal.$checkDoctorUserStatus(i);

			// represent total in a part..
			List<WebElement> rchange = driver
					.findElements(By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div/div[1]/div[1]/div[1])"));
			int avaiable = rchange.size();
			int count = 2;
			for (int b = 1; b <= avaiable; b++) {

				WebElement tp = driver.findElement(

						By.xpath("(//div[@id='date-data'][" + i + "]/div[2]/div[" + b + "]/div[1]/div[1]/div[1])"));

				// String tr = tp.getText();
				// boolean trp = tp.isDisplayed();

				// the kpid ..
				WebElement kp = driver.findElement(
						By.xpath("(//div[@id='date-data'])[" + i + "]/div[2]/div[" + b + "]/div/div[2]/span[2]"));

				if (kp.getText().isEmpty() && tp.isDisplayed() && !tp.getText().isEmpty()) {

					clickIntercept(tp, 30);
					sleep(2000);
					WebElement $disscriptionBox = driver
							.findElement(By.xpath("(//textarea[@id='description'])[" + count + "]"));
					if ($disscriptionBox.isDisplayed()) {
						// System.out.println("displayed");

						sendkeys($disscriptionBox, "HELLO DOCOTR");
						WebElement $saveappointment = driver.findElement(By.xpath("(//button[@id='accept-btn'])[1]"));
						visbility(driver, $saveappointment, 40);
						clickIntercept($saveappointment, 30);

						cond = true;
						break;

					} else if (!$disscriptionBox.isDisplayed()) {
						// System.out.println("not displayed");
						continue;
					}

				} else if (tp.getText().isEmpty() && tp.isDisplayed()) {

					count = count + 1;
					continue;

				}

			}

			//
			if (cond == true) {
				for (int in = 1; in <= 7; in++) {
					try {
						WebElement edit = driver.findElement(By.xpath("//span[text()='HELLO DOCOTR']"));
						if (edit.isDisplayed()) {
							clickIntercept(edit, 30);
							break;
						}
					} catch (Exception e) {

					}
				}

				for (int in = 1; in <= 7; in++) {
					try {
						WebElement goToehr = driver.findElement(By.id("goEhrButton"));
						if (goToehr.isDisplayed()) {
							elementClickable(goToehr);
							clickIntercept(goToehr, 30);
							break;
						}
					} catch (Exception e) {

					}
				}

				try {
					WebElement back = driver.findElement(By.xpath("(//button[@id='back-btn'])[6]"));
					visbility(driver, back, 50);

					clickIntercept(back, 30);
				} catch (ElementClickInterceptedException e) {
					WebElement back = driver.findElement(By.xpath("(//button[@id='back-btn'])[6]"));
					visbility(driver, back, 50);

					clickIntercept(back, 30);
				}

				for (int in = 1; in <= 7; in++) {
					try {
						WebElement edit = driver.findElement(By.xpath("//span[text()='HELLO DOCOTR']"));
						if (edit.isDisplayed()) {
							clickIntercept(edit,30);
							break;
						}
					} catch (Exception e) {

					}
				}
				sleep(2000);

				if (count > 1) {

					System.out.println("ENTER DEL");
					for (int in = 1; in <= 7; in++) {
						try {
							WebElement delete = driver.findElement(By.xpath("(//span[@id='del-btn'])[" + count + "]"));
							System.out.println(delete);
							if (delete.isDisplayed()) {
								clickIntercept(delete,30);
								break;
							}

						} catch (Exception e) {

						}
					}

				} else {
					for (int in = 1; in <= 7; in++) {
						try {
							WebElement del = driver.findElement(By.xpath("(//span[@id='del-btn'])[2]"));
							if (del.isDisplayed()) {
								System.out.println("NO DIV");
								clickIntercept(del,30);
								break;
							}
						} catch (Exception e) {

						}
					}
				}
			}
			////// end

			if (cond == true) {
				delAppointment(count, driver);
				System.out.println("PARENT");
				break;
			}

			if (cond == false) {
				System.out.println("QUEUE");
				cal.$nextsetOfDays(cal.cnt);
				bookAppointment(driver, cal);

			}
		}

		System.out.println("EXIT");

	}

	private boolean delAppointment(int count, WebDriver driver) {
		boolean condition = false;

		for (int in = 1; in <= 7; in++) {
			try {

				WebElement $deletekpop = driver
						.findElement(By.xpath("//div[@id='AppointmentCreateMessage']/div[2]/div[2]/button[2]"));
				if ($deletekpop.isDisplayed()) {
					clickIntercept($deletekpop,30);
					condition = true;
					break;
				}
			} catch (Exception e) {

			}
		}
		return condition;
	}

}
