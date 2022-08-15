package com.FamilyApp.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FamilyApp.model.Family;


@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer> {
	
	//Interfejs CrudRepository wraz z adnotacjami @Query

	@Query("SELECT coalesce(MAX(id_f),0) FROM familyapp.family")
	int genId();

	@Modifying
	@Query("insert into familyapp.family (id_f,family_name,nr_of_adults,nr_of_children,nr_of_infants) VALUES (:fid,:fname,:na,:nc,:ni)")
	void saveFam(@Param("fid") Integer fid, @Param("fname") String fname, @Param("na") Integer na,
			@Param("nc") Integer nc, @Param("ni") Integer ni);
	
	@Query("SELECT * FROM familyapp.family WHERE id_f = :fid")
	Family findByFid(@Param("fid") Integer fid);

}
