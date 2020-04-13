package com.softtek.academy.projectCOVID19.repositoryMethods;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.util.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AnswersREImpl implements AnswersRE{
	
	private static final String SQL_FIND_BY_IS = "SELECT * FROM	Answers WHERE fkIs = :fkIs ";
	
	@Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> selectAnswers(String paramIs) {
        try {           
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("fkIs", paramIs);
            
            
            return jdbcTemplate.queryForList(SQL_FIND_BY_IS, parameters);
        }
        catch (EmptyResultDataAccessException ex) {
            return Collections.emptyList();
        }
	}

	@Override
	public String insertAnswers(String answers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAnswers(String answers) {
		// TODO Auto-generated method stub
		return null;
	}

}
