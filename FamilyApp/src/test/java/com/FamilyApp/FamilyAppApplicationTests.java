package com.FamilyApp;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.FamilyApp.dataAdapter.FamilyData;
import com.FamilyApp.model.Family;
import com.FamilyApp.model.FamilyMember;
import com.FamilyApp.repository.FamilyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class FamilyAppApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private FamilyRepository repo;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		mvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello from FamilyApp!")));
	}

	@Test
	public void testCreateFamily() throws Exception {
		int fid = repo.genId() + 1;
		mvc.perform(post("/createFamily").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(new FamilyData(new Family(fid, "Kozak", 0, 0, 2),
						new ArrayList<FamilyMember>(Arrays.asList(new FamilyMember(fid, "Kozak", "Marek", 3)))))))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetFamily() throws Exception {
		mvc.perform(get("/getFamily/0")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("Nie ma takiej rodziny")));
	}

}
