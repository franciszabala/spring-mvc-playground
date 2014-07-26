package com.example.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

//spring will not recognize dao if we don't put annotations
@Repository("userDao")
public class UserDaoJdbcTemplateImpl implements UserDao {

	private static final String SAMPLE_SELECT = "select id, username, password from user ";
	private static final String SAMPLE_BY_ID_SELECT = SAMPLE_SELECT
			+ " where username=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public UserObj getUser(String username) {
		// TODO Auto-generated method stub
		List matches = jdbcTemplate.query(SAMPLE_BY_ID_SELECT,
				new Object[] { username }, new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException, DataAccessException {
						UserObj userObj = new UserObj();
						userObj.setId(rs.getLong(1));
						userObj.setUsername(rs.getString(2));
						userObj.setPassword(rs.getString(3));
						return userObj;
					}
				});
		return matches.size() > 0 ? (UserObj) matches.get(0) : null;
	}

	@Override
	public UserObj getUserDifferently(String username) {
		String query = "select id, username, password from user where username =:username";

		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"username", username);

		return namedParameterJdbcTemplate.queryForObject(query, namedParameters,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException, DataAccessException {
						UserObj userObj = new UserObj();
						userObj.setId(rs.getLong(1));
						userObj.setUsername(rs.getString(2));
						userObj.setPassword(rs.getString(3));
						return userObj;
					}
				});
	}

}
