package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class emaildaoimpl implements emaildao {

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public String getemail(String email) {

		String sql = "Select Password from user_admin WHERE Username=?";
		return jdbctemplate.queryForObject(sql, (rs, rowNum) -> {
			return rs.getString("password");
		}, email);

		// List<Map<String, Object>> list = jdbctemplate.queryForList(sql);
		// String unique = list.toString();
		// System.out.println(unique);
		// return unique;
	}

	

	

}
