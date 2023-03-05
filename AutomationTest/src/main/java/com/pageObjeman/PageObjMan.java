package com.pageObjeman;

import org.openqa.selenium.WebDriver;

import com.pomclass.Basic;
import com.pomclass.Billing;
import com.pomclass.Calendar;
import com.pomclass.CardDetails;
import com.pomclass.HealthRecord;
import com.pomclass.HomeModule;
import com.pomclass.Lite;
import com.pomclass.LoginPage;
import com.pomclass.MarketPlace;
import com.pomclass.Message;
import com.pomclass.PatientCreation;
import com.pomclass.SelectYourPlan;
import com.pomclass.Settings;
import com.pomclass.TeleDcotor;

public class PageObjMan {

	private LoginPage lg;
	private PatientCreation pc;
	private HealthRecord hr;
	private Calendar c;
	private Billing b;
	private TeleDcotor t;
	private Message m;
	private Settings s;
	private HomeModule home;
	private SelectYourPlan selectplan;
	private CardDetails card;
	private Lite lite;
	private MarketPlace marketplc;
	private Basic basic;

	public WebDriver driver;

	public PageObjMan(WebDriver driver) {
		this.driver = driver;
	}

	public Lite getLite() {

		if (lite == null) {
			lite = new Lite(driver);
			return lite;

		}
		return lite;

	}

	public LoginPage getInstanceLoginPage() {
		if (lg == null) {

			lg = new LoginPage(driver);

		}
		return lg;
	}

	public Basic getInstanceBasic() {
		if (basic == null) {
			basic = new Basic(driver);
			return basic;
		}
		return basic;
	}

	public CardDetails getInstanceCardDetails() {
		if (card == null) {
			card = new CardDetails(driver);
		}
		return card;

	}

	public MarketPlace getInstanceMarketplace() {
		if (marketplc == null) {
			marketplc = new MarketPlace(driver);
			return marketplc;
		}

		return marketplc;

	}

	public SelectYourPlan getInstanceSelectYourPlan() {
		if (selectplan == null) {
			selectplan = new SelectYourPlan(driver);
		}
		return selectplan;

	}

	public HomeModule getInstanceHomeModule() {
		if (home == null) {
			home = new HomeModule(driver);
		}
		return home;

	}

	public PatientCreation getInstanceNewPatient() {
		if (pc == null) {
			pc = new PatientCreation(driver);
		}
		return pc;
	}

	public HealthRecord getInstanceHealthRec() {
		if (hr == null) {

			hr = new HealthRecord(driver);
		}
		return hr;
	}

	public Calendar getInstanceCalendar() {
		if (c == null) {
			c = new Calendar(driver);
		}
		return c;
	}

	public Billing getInstanceBilling() {
		if (b == null) {

			b = new Billing(driver);
		}
		return b;
	}

	public TeleDcotor getInstanceTeleDoctor() {
		if (t == null) {

			t = new TeleDcotor(driver);
		}
		return t;
	}

	public Message getInstanceMessage() {
		if (m == null) {

			m = new Message(driver);
		}
		return m;

	}

	public Settings getInstanceSetting() {
		if (s == null) {

			s = new Settings(driver);

		}
		return s;
	}

}
