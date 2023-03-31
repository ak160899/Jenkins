package com.healthRec;

import org.Launch.LaunchBrowser;
import org.testng.annotations.Test;

public class Tc_025_FavoriteKpopScenarios extends LaunchBrowser {

	@Test(priority = 1)
	public void favoriteVisitReason() {
		Tc_006_VisitReason.favoriteVisitReason();

	}

	@Test(priority = 2)
	public void favoriteVaccine() {
		Tc_007_Vaccine.favoriteVaccine();

	}

	@Test(priority = 3)
	public void favoriteSympytoms() {
		Tc_011_Symptoms.favoriteSymptoms();

	}

	@Test(priority = 4)
	public void favoriteProcedure() {
		Tc_012_Procedure.favoriteProcedure();

	}

	@Test(priority = 5)
	public void favoriteGoals() {
		Tc_013_Goals.favoriteGoals();

	}

	@Test(priority = 6)
	public void favoriteStatus() {
		Tc_015_Status.favoriteStatus();

	}

	@Test(priority = 7)
	public void favoriteProblems() {
		try {
			Tc_010Problems.favoriteProblemAddIcon();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 8)
	public void favoriteAdvaceDirectives() {
		Tc_014_AdvanceDirectives.favoriteAdvanceDirectives();

	}

	@Test(priority = 9)
	public void favoriteNotes() {
		Tc_018_Notes.favoriteNotes();

	}

	@Test(priority = 10)
	public void favoritePhusicalExamination() {
		Tc_019_PhysicalExamination.favoritePhysicalExamination();

	}
}
