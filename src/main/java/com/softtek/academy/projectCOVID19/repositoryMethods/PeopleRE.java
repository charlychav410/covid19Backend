package com.softtek.academy.projectCOVID19.repositoryMethods;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.projectCOVID19.dataBaseEntities.People;

@Repository
public interface PeopleRE extends CrudRepository<People,String>{

	
	 @Query(value="select AES_DECRYPT(p.PASSWORD_P,'KEY') from PEOPLE p where p.IS = :is", nativeQuery = true)
	  String findByIs(String is);
	
	 @Modifying
     @Transactional 
     @Query(value ="insert into PEOPLE (`IS`,`NAME`,`LAST_NAME`,`LAST_NAME_M`,`EMAIL`,`PHONE`,`PASSWORD_P`) values (:is,:name,:lastName,:lastNameM,:email,:phone,aes_encrypt(:pass, 'KEY'))",nativeQuery = true)
    void insertUserQ(String is,String name,String lastName,String lastNameM,String email,String phone,String pass);
}
