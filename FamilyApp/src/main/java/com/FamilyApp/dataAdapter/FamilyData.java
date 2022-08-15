package com.FamilyApp.dataAdapter;

import java.util.List;

import com.FamilyApp.model.Family;
import com.FamilyApp.model.FamilyMember;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FamilyData {

	//Klasa służąca jako adapter do wyświetlania danych rodziny oraz jej członków
	private Family getFamily;
	private List<FamilyMember> familyMembers;

}
