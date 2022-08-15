package com.FamilyApp.Contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FamilyApp.dataAdapter.FamilyData;
import com.FamilyApp.service.FamilyServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FamilyAppController {

	@Autowired
	private FamilyServiceImpl service;

	@ExceptionHandler(JsonProcessingException.class)
	public String handleException(JsonProcessingException ex) {
		return "Błąd podczas przetwarzania obiektu rodziny.";
	}

	//Strona startowa
	@GetMapping("/")
	ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello from FamilyApp!", HttpStatus.OK);
	}

	//Metoda kontrolera odpowiedzialna za utworzenie rodziny
	@PostMapping("/createFamily")
	public ResponseEntity<Integer> createFamily(@RequestBody FamilyData fdata) {
		if (service.validateFamilyData(fdata)) {
			return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
		}
		log.info("Pomyślnie stworzono rodzinę.");
		return new ResponseEntity<>(service.saveFamily(fdata).getIdF(), HttpStatus.OK);
	}

	//Metoda kontrolera odpowiedzialna za pobieranie rodziny
	@GetMapping("/getFamily/{id}")
	public ResponseEntity<String> getFamily(@PathVariable(name = "id") int id) throws JsonProcessingException {
		if (service.getFamily(id).getGetFamily() != null) {
			log.info("Pomyślnie pobrano rodzinę.");
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(service.getFamily(id)), HttpStatus.OK);
		} else {
			log.warn("Błąd podczas pobierania rodziny.");
			return new ResponseEntity<>("Nie ma takiej rodziny", HttpStatus.NO_CONTENT);
		}
	}

}
