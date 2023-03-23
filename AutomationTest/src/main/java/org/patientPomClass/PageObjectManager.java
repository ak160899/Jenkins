package org.patientPomClass;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;

	private HealthRecord rec;
	private Appointment appointment;
	private Settings set;

	public HealthRecord getInstnaceHealthRecord() {
		if (rec == null) {
			rec = new HealthRecord(driver);

		}
		return rec;
	}

	public void getInstanceAppointment() {
		if (appointment == null) {
			appointment = new Appointment();
		}

	}

	public Settings getInstanceSettings() {
		if (set == null) {
			set = new Settings(driver);
			return set;
		}
		return set;

	}

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

}
