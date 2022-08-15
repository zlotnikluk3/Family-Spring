package com.FamilyMemberApp.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FamilyMemberApp.model.FamilyMember;
import com.FamilyMemberApp.repository.FamilyMemberRepository;

@RestController
public class FamilyMemberAppController {

	@Autowired
	private FamilyMemberRepository repo;

	//Metoda startowa kontrolera
	@GetMapping("/")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello from FamilyMemberApp", HttpStatus.OK);
	}

	//Metoda kontrolera odpowiedzialna za utworzenie rodziny
	@PostMapping("/createFamilyMember")
	public ResponseEntity<FamilyMember> createFamilyMember(@RequestBody FamilyMember familyMemeber) {
		if (familyMemeber.getFamilyId() > 0) {
			repo.saveFm(familyMemeber.getFamilyId(), familyMemeber.getFamilyName(), familyMemeber.getGivenName(),
					familyMemeber.getAge());
			return new ResponseEntity<>(new FamilyMember(repo.genId(), familyMemeber.getFamilyId(),
					familyMemeber.getFamilyName(), familyMemeber.getGivenName(), familyMemeber.getAge()),
					HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	//Metoda kontrolera odpowiedzialna za pobranie członków rodziny o zadanym id
	@GetMapping("/searchFamilyMember/{id}")
	public ResponseEntity<List<FamilyMember>> searchFamilyMember(@PathVariable(name = "id") int id) {
		return new ResponseEntity<>(repo.findByFid(id), HttpStatus.OK);
	}
}
