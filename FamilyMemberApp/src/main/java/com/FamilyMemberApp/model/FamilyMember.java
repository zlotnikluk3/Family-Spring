package com.FamilyMemberApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Table("familymember")
@AllArgsConstructor
public class FamilyMember {
	@Id
	private int fmId;
	private int familyId;
	private String familyName;
	private String givenName;
	private int age;
}
