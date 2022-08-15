package com.FamilyMemberApp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FamilyMemberApp.model.FamilyMember;

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Integer> {
	//Interfejs CrudRepository wraz z adnotacjami @Query
	@Query("SELECT * FROM familymemberapp.family_member WHERE family_id = :fid")
	List<FamilyMember> findByFid(@Param("fid") Integer id);
	
	@Modifying
	@Query("insert into familymemberapp.family_member (family_id,family_name,given_name,age) VALUES (:fid,:fname,:gname,:age)")
	void saveFm(@Param("fid") Integer fid, @Param("fname") String fname, @Param("gname") String gname,
			@Param("age") Integer age);
	
	@Query("SELECT coalesce(MAX(fm_id),1) FROM familymemberapp.family_member")
	int genId();

}
