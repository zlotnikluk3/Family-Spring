package com.FamilyApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FamilyApp.Accessor.FeignApiAccessor;
import com.FamilyApp.dataAdapter.FamilyData;
import com.FamilyApp.model.Family;
import com.FamilyApp.model.FamilyMember;
import com.FamilyApp.repository.FamilyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FamilyServiceImpl implements FamilyService {
	
	//Klasa zawierająca logikę biznesową FamilyApp

	@Autowired
	private FamilyRepository repo;
	@Autowired
	private FeignApiAccessor feignAccesor;

	@Transactional
	@Override
	public Family saveFamily(FamilyData fdata) {
		fdata.getGetFamily().setIdF(repo.genId() + 1);
		for (FamilyMember fm : fdata.getFamilyMembers()) {
			feignAccesor.createFamilyMember(new FamilyMember(fdata.getGetFamily().getIdF(),
					fdata.getGetFamily().getFamilyName(), fm.getGivenName(), fm.getAge()));
		}
		repo.saveFam(fdata.getGetFamily().getIdF(), fdata.getGetFamily().getFamilyName(),
				fdata.getGetFamily().getNrOfAdults(), fdata.getGetFamily().getNrOfChildren(),
				fdata.getGetFamily().getNrOfInfants());
		return new Family(fdata.getGetFamily().getIdF(), fdata.getGetFamily().getFamilyName(),
				fdata.getGetFamily().getNrOfAdults(), fdata.getGetFamily().getNrOfChildren(),
				fdata.getGetFamily().getNrOfInfants());
	}

	@Transactional
	@Override
	public FamilyData getFamily(int id) {
		return new FamilyData(repo.findByFid(id), feignAccesor.searchFamilyMember(id));
	}

	@Override
	public boolean validateFamilyData(FamilyData fdata) {
		int tab[] = new int[3];
		boolean f = false;
		for (FamilyMember fm : fdata.getFamilyMembers()) {
			if (fm.getAge() < 0) {
				log.error("Age cannot be negative!");
				f = true;
			} else if (fm.getAge() < 4) {
				tab[0]++;
			} else if (fm.getAge() < 16) {
				tab[1]++;
			} else {
				tab[2]++;
			}
		}

		if (fdata.getGetFamily().getNrOfInfants() != tab[0]) {
			f = true;
			log.error("Wrong number of infants!");
		}
		if (fdata.getGetFamily().getNrOfChildren() != tab[1]) {
			f = true;
			log.error("Wrong number of childrens!");
		}
		if (fdata.getGetFamily().getNrOfAdults() != tab[2]) {
			f = true;
			log.error("Wrong number of adults!");
		}
		return f;
	}

}