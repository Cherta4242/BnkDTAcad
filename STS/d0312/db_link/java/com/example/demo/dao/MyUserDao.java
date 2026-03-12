package com.example.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dto.MyUserDto;

public class MyUserDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	public MyUserDao(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertUser(String id, String pw, String name) {
	    String sql = "INSERT INTO member3(id, pw, name) VALUES (?, ?, ?)";
	    return jdbcTemplate.update(sql, id, pw, name);
	}
	
	public int countUsers() {
	    String sql = "SELECT COUNT(*) FROM member3";
	    return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String findUserNameById(int id) {
	    String sql = "SELECT name FROM member3 WHERE id = ?";
	    return jdbcTemplate.queryForObject(sql, String.class, id);
	}

	
	public List<MyUserDto> list() {
	    String sql = "SELECT id, pw, name FROM member3";
	    return jdbcTemplate.query(sql, (rs, rowNum) -> {
	        MyUserDto dto = new MyUserDto();
	        dto.setId(rs.getString("id"));
	        dto.setPw(rs.getString("pw"));
	        dto.setName(rs.getString("name"));
	        return dto;
	    });
	}

}
