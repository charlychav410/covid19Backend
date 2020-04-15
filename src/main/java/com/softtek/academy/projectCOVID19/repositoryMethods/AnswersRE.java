package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.stream.Stream;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.projectCOVID19.dataBaseEntities.Answers;

@Repository
public interface AnswersRE extends CrudRepository<Answers,String> {
	
	@QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE))
	@Query(value="select * from ANSWERS a where a.FK_IS = :is", nativeQuery = true)
	Stream<Answers> findAllByIs(String is);
	
}
