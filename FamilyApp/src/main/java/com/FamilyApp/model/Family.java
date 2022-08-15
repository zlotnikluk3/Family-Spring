package com.FamilyApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table("family")
public class Family {
	@Id
	private int idF;
	private String familyName;
	private int nrOfAdults;
	private int nrOfChildren;
	private int nrOfInfants;

}
