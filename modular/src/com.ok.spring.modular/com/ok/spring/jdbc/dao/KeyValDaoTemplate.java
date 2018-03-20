package com.ok.spring.jdbc.dao;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;

import com.ok.spring.jdbc.entity.KeyVal;

@Component
public class KeyValDaoTemplate {
	@Autowired
	private DataSource dataSource;

	public void save(KeyVal keyVal) {
		String query = "INSERT INTO key_val VALUES(?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[] { keyVal.getKey(), keyVal.getValue() };

		try {
			jdbcTemplate.update(query, params);
			System.out.println("Saved: " + keyVal);

			query = "SELECT count(*) kvcount FROM key_val";
			Integer kvCount = jdbcTemplate.queryForObject(query, Integer.class);
			System.out.println("Total KV Pairs in Store: " + kvCount);
		} catch(DataAccessException e) {
			System.out.println("Error in saving data..");
		}
	}

	public String findByKey(String key) {
		String query = "SELECT the_value FROM key_val WHERE the_key = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[] { key };
		String value = null;

		try {
			value = jdbcTemplate.queryForObject(query, params, String.class);
		} catch(DataAccessException e) {
			System.out.println("Error in fetching data..");
		}

		return value;
	}
}

