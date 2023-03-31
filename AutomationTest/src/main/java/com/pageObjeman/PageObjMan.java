package com.pageObjeman;

import org.openqa.selenium.WebDriver;

import com.pomclass.AdvanceDirectives;
import com.pomclass.Alert;
import com.pomclass.Allergy;
import com.pomclass.Amendment;
import com.pomclass.AttachFile;
import com.pomclass.Basic;
import com.pomclass.Billing;
import com.pomclass.Calendar;
import com.pomclass.CardDetails;
import com.pomclass.Ehr_FollowUp;
import com.pomclass.FamilyHealth;
import com.pomclass.Forms;
import com.pomclass.Goals;
import com.pomclass.HealthRecord;
import com.pomclass.HomeModule;
import com.pomclass.ImplantableDevice;
import com.pomclass.Inpatient;
import com.pomclass.Lite;
import com.pomclass.LoginPage;
import com.pomclass.MarketPlace;
import com.pomclass.Medication;
import com.pomclass.Message;
import com.pomclass.Notes;
import com.pomclass.PatientCreation;
import com.pomclass.PhysicalExamination;
import com.pomclass.Problems;
import com.pomclass.Procedure;
import com.pomclass.SelectYourPlan;
import com.pomclass.Settings;
import com.pomclass.SocialHistory;
import com.pomclass.Status;
import com.pomclass.Symptoms;
import com.pomclass.TeleDcotor;
import com.pomclass.TestOrder;
import com.pomclass.Vaccine;
import com.pomclass.VisitReason;
import com.pomclass.Vitals;

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
	private VisitReason visit;
	private Vitals vital;
	private Allergy alergy;
	private SocialHistory social;
	private FamilyHealth family;
	public WebDriver driver;
	private Alert alert;
	private Vaccine vacc;
	private ImplantableDevice imp;
	private Amendment amd;
	private Problems pro;
	private Symptoms smp;
	private Procedure procd;
	private Goals goal;
	private AdvanceDirectives ad;
	private Status status;
	private TestOrder test;
	private Medication med;
	private Notes note;
	private Forms form;
	private PhysicalExamination py;
	private AttachFile attach;
	private Inpatient in;

	private Ehr_FollowUp followup;

	public PageObjMan(WebDriver driver) {
		this.driver = driver;
	}

	public Vitals getInstanceVitals() {
		if (vital == null) {
			vital = new Vitals(driver);
			return vital;
		}
		return vital;
	}

	public Ehr_FollowUp getInstanceFollowUp() {
		if (followup == null) {
			followup = new Ehr_FollowUp(driver);
			return followup;
		}
		return followup;
	}

	public Inpatient getInstanceInpatient() {
		if (in == null) {
			in = new Inpatient(driver);
			return in;
		}
		return in;
	}

	public Forms getInstanceform() {
		if (form == null) {
			form = new Forms(driver);
			return form;
		}
		return form;
	}

	public AttachFile getInstanceAttachFile() {
		if (attach == null) {
			attach = new AttachFile(driver);
			return attach;
		}
		return attach;
	}

	public PhysicalExamination getInstancePhysicalExam() {
		if (py == null) {
			py = new PhysicalExamination(driver);
			return py;
		}
		return py;
	}

	public Notes getInstanceNotes() {
		if (note == null) {
			note = new Notes(driver);
			return note;
		}
		return note;
	}

	public TestOrder getInstanceTestOrder() {
		if (test == null) {
			test = new TestOrder(driver);
			return test;
		}
		return test;
	}

	public Medication getInstanceMedication() {
		if (med == null) {
			med = new Medication(driver);
			return med;
		}
		return med;
	}

	public Status getInstanceStatus() {
		if (status == null) {
			status = new Status(driver);
			return status;
		}
		return status;
	}

	public Goals getInstanceGoal() {
		if (goal == null) {
			goal = new Goals(driver);
			return goal;
		}
		return goal;
	}

	public AdvanceDirectives getInstanceAdvanceDirective() {
		if (ad == null) {
			ad = new AdvanceDirectives(driver);
			return ad;
		}
		return ad;
	}

	public Procedure getInstanceProcedure() {
		if (procd == null) {
			procd = new Procedure(driver);
			return procd;
		}
		return procd;
	}

	public Symptoms getInstanceSymptom() {
		if (smp == null) {
			smp = new Symptoms(driver);
			return smp;
		}
		return smp;
	}

	public Problems getInstanceProblems() {
		if (pro == null) {
			pro = new Problems(driver);
			return pro;
		}
		return pro;
	}

	public Amendment getInstanceAmendment() {
		if (amd == null) {
			amd = new Amendment(driver);
			return amd;
		}
		return amd;
	}

	public ImplantableDevice getInstanceImplantableDevice() {
		if (imp == null) {
			imp = new ImplantableDevice(driver);
			return imp;
		}
		return imp;
	}

	public Vaccine getInstanceVaccine() {
		if (vacc == null) {
			vacc = new Vaccine(driver);
			return vacc;
		}
		return vacc;
	}

	public Alert getInstanceAlert() {
		if (alert == null) {
			alert = new Alert(driver);
			return alert;
		}
		return alert;
	}

	public VisitReason getInstanceVistReason() {
		if (visit == null) {
			visit = new VisitReason(driver);
			return visit;
		}
		return visit;
	}

	public Allergy getInstanceAllerygy() {
		if (alergy == null) {
			alergy = new Allergy(driver);
			return alergy;
		}
		return alergy;
	}

	public FamilyHealth getInstanceFamilyHaelth() {
		if (family == null) {
			family = new FamilyHealth(driver);
			return family;
		}
		return family;
	}

	public SocialHistory getInstanceSocialHistory() {
		if (social == null) {
			social = new SocialHistory(driver);
			return social;
		}
		return social;
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
