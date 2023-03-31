package com.healthRec;

import org.Launch.LaunchBrowser;
import org.PageModules.Settings;
import org.testng.annotations.Test;

public class CheckTestClasses extends LaunchBrowser {
	@Test()
	private void runScript() {
		org.PageModules.Patient_Module.patientCreation();
		Tc_000_HealthRecordUi.tc_001_verifyTheHaelthRecordCount();
		Tc_000_HealthRecordUi.verifyAndShowTheHidedOptions();
		try {

			/*
			 * Tc_001_Vitals.tc_002_addVitals_Edit_Save();
			 * Tc_002_Allergy.tc_003_addAllergy_Edit_Save();
			 * Tc_003_SocialHistory.tc_004_addSocialHistory_Edit_Save();
			 * Tc_004_FamilyHealth.tc_005_addFamilyHealth_Edit_Save();
			 * Tc_005_Alert.tc_006_addAlertEditAndSave();
			 * Tc_006_VisitReason.tc_007_addVisitReason_Edit_Save();
			 * Tc_007_Vaccine.tc_008_addVaccine_Edit_Save();
			 * Tc_008_ImplantableDevice.tc_009_addSaveAndEditImplantableDevice();
			 * Tc_009_Amendment.tc_010_addAmendent_Edit_Save();
			 * Tc_010Problems.addproblems_Edit_Save();
			 * Tc_011_Symptoms.addSymptoms_Edit_Save();
			 * Tc_012_Procedure.addProcedure_Edit_Save(); Tc_013_Goals.addGoals_Edit_Save();
			 * Tc_014_AdvanceDirectives.addAdvnceDiretivesAdd_EditAndSave();
			 * Tc_015_Status.addStatus_Edit_Save(); Tc_016_TestOrder.$addTestOrder();
			 * Tc_017_Medication.addMedication_Edit_Save();
			 * Tc_018_Notes.addNotes_Edit_Save();
			 * Tc_019_PhysicalExamination.addPhysicalExamination_Edit_Save();
			 * Tc_021_AttachFile.attachFileAdd_SaveAndEdit();
			 * Tc_022_Inpatient.addInpatient_Edit_Save();
			 * Tc_023_GenerateBillFromEhr.verifyTheGenerteBill();
			 * 
			 * Tc_007_Vaccine.$getPastVaccine(); Tc_011_Symptoms.getPastSymptom();
			 * Tc_012_Procedure.getPastProcedure(); Tc_013_Goals.$getPastGoals();
			 * Tc_017_Medication.$getPastMedication(); Tc_026_saltScenarios.saltScenarios();
			 * 
			 * Tc_006_VisitReason.favoriteVisitReason(); Tc_007_Vaccine.favoriteVaccine();
			 * Tc_011_Symptoms.favoriteSymptoms(); Tc_012_Procedure.favoriteProcedure();
			 * Tc_013_Goals.favoriteGoals();
			 * Tc_014_AdvanceDirectives.favoriteAdvanceDirectives();
			 * Tc_015_Status.favoriteStatus();
			 */

			Tc_010Problems.favoriteProblemAddIcon();
			/*
			 * Tc_018_Notes.favoriteNotes();
			 * Tc_019_PhysicalExamination.favoritePhysicalExamination();
			 * Tc_026_FollowUpEhr.$createFollowup();
			 */

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	@Test
	private void settingsRun() {
		//Settings.settingsModule();

	}

}
