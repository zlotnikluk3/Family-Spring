package com.FamilyApp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;

import com.FamilyApp.Accessor.FeignApiAccessor;
import com.FamilyApp.model.FamilyMember;


/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"dev.pater:spring-cloud-contract-producer:+:stubs:6565"},stubsMode = StubsMode.LOCAL)*/
@SpringBootTest
class InsteadOfContracTest {
	
	//Klasa testująca działanie interfejsu dostarczanego przez producera.

	@Autowired
	private FeignApiAccessor feignAccesor;

	@Test
	public void testCreateFamilyMember() {
		Assert.assertNotEquals(feignAccesor.createFamilyMember(new FamilyMember(-1, "Nowak", "Jan", 4)),
				HttpStatus.CREATED);
	}

	@Test
	public void testsearchFamilyMember() {
		Assert.assertNotEquals(feignAccesor.searchFamilyMember(33), HttpStatus.OK);
	}

}
