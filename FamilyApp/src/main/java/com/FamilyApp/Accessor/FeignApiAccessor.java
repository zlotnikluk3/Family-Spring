package com.FamilyApp.Accessor;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.FamilyApp.model.FamilyMember;

@FeignClient(name="FAMILYMEMBERAPP-SERVICE", url = "http://localhost:9100/")
public interface FeignApiAccessor {
	//Interfejs Feign zapewniający komunikację pomiędzy mikroserwisami. Zapewnia wywołanie dwóch metod kontrolera FamilymemberApp
	
	@PostMapping("/createFamilyMember")
    public FamilyMember createFamilyMember(@RequestBody FamilyMember familyMemeber);
	
	@GetMapping("/searchFamilyMember/{id}")
	public List<FamilyMember> searchFamilyMember(@PathVariable(name = "id") int id);

}
