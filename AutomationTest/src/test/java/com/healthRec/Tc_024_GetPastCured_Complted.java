package com.healthRec;

import org.Launch.LaunchBrowser;
import org.testng.annotations.Test;

public class Tc_024_GetPastCured_Complted extends LaunchBrowser {

	@Test(priority = 1)
	public void pastVaccine() {
		try {
			Tc_007_Vaccine.$getPastVaccine();
		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void pastSymptoms() {
		try {
			Tc_011_Symptoms.getPastSymptom();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void pastCuredProcedure() {
		Tc_012_Procedure pr = new Tc_012_Procedure();
		pr.getPastProcedure();

	}

	@Test(priority = 4)
	public void pastGoals() {
		Tc_013_Goals g = new Tc_013_Goals();
		try {
			g.$getPastGoals();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Test(priority = 5)
	public void pastMedication() {
		Tc_017_Medication med = new Tc_017_Medication();
		try {
			med.$getPastMedication();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
