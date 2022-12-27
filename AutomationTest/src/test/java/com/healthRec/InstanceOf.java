package com.healthRec;

import org.openqa.selenium.WebDriver;

public class InstanceOf {

	WebDriver driver;

	Vitals v;
	Allergy ar;
	AdvanceDirectives ad;
	Amendment am;
	Alert alert;
	AttachFile af;
	EhrLink er;
	FamilyHealth fh;
	FollowUpEhr fe;
	Forms frm;
	Goals gl;
	ImplantableDevice id;
	Inpatient ip;
	Medication md;
	Notes n;
	PhysicalExamination pe;
	Problems p;
	Procedure pr;
	Referal r;
	SocialHistory sh;
	Status status;
	Symptoms symptom;
	TestOrder to;
	Vaccine vc;
	VisitReason vr;

	public Vitals $getInstanceOfVital() {

		if (v == null) {
			v = new Vitals(driver);
		}
		return v;

	}

	public Allergy $getInstanceOfAllergy() {
		if (ar == null) {
			ar = new Allergy();

		}
		return ar;

	}

	public AdvanceDirectives $getInstanceOfAdvanceDirectives() {
		if (ad == null) {
			ad = new AdvanceDirectives();
		}
		return ad;
	}

	public Amendment $getInstanceOfAmendment() {

		if (am == null) {
			am = new Amendment();

		}
		return am;
	}

	public Alert $getInstanceOfAlert() {
		if (alert == null) {
			alert = new Alert();
		}
		return alert;

	}

	public AttachFile $getInstanceOfAttachFile() {
		if (af == null) {
			af = new AttachFile();
		}
		return af;
	}

	public EhrLink $getInstanceOfEhrLink() {
		if (er == null) {
			er = new EhrLink();
		}
		return er;

	}

	public FamilyHealth $getInstanceOfFamilyHealth() {
		if (fh == null) {
			fh = new FamilyHealth();

		}
		return fh;
	}

	public FollowUpEhr $getInstnaceOfFollowUp() {

		if (fe == null) {
			fe = new FollowUpEhr();
		}
		return fe;

	}

	public Forms $getInstanceOfForms() {
		if (frm == null) {
			frm = new Forms();

		}
		return frm;
	}

	public Goals $getInstanceOfGoals() {
		if (gl == null) {
			gl = new Goals(driver);
		}
		return gl;

	}

}
