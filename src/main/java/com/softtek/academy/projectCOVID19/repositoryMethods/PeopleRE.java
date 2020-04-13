package com.softtek.academy.projectCOVID19.repositoryMethods;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.projectCOVID19.dataBaseEntities.People;

@Repository
public interface PeopleRE extends CrudRepository<People,String>{

	
	 @Query(value="select AES_DECRYPT(p.PASSWORD_P,'KEY') from PEOPLE p where p.IS = :is", nativeQuery = true)
	  String findByIs(String is);
}
