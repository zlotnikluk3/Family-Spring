package com.FamilyApp.service;

import com.FamilyApp.dataAdapter.FamilyData;
import com.FamilyApp.model.Family;

public interface FamilyService {
	public Family saveFamily(FamilyData fdata);

	public FamilyData getFamily(int id);

	public boolean validateFamilyData(FamilyData fdata);
}
