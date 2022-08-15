package com.FamilyApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FamilyMember {
	private int familyId;
	private String familyName;
	private String givenName;
	private int age;
}
