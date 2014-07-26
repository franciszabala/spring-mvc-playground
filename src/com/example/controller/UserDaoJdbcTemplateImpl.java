package com.example.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//spring will not recognize dao if we don't put annotations
@Repository("userDao")
public class UserDaoJdbcTemplateImpl implements UserDao{
	
	private static final String SAMPLE_SELECT = "select id, name from sample";
	private static final String SAMPLE_BY_ID_SELECT = SAMPLE_SELECT + "where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserObj getUser(String username) {
		// TODO Auto-generated method stub
		List matches = jdbcTemplate.query(SAMPLE_BY_ID_SELECT,
				new Object[] { username },
				new RowMapper() {
					public Object mapRow (ResultSet rs, int rowNum) throws
						SQLException, DataAccessException {
						 UserObj userObj = new UserObj();
						 userObj.setId(rs.getLong(0));
						 userObj.setUsername(rs.getString(1));
						 userObj.setPassword(rs.getString(2));
						 return userObj;
					}
		});
		return matches.size() > 0 ? (UserObj) matches.get(0) :null;
	}

}
