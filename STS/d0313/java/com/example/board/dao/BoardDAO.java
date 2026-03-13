package com.example.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.board.dto.BboardDTO;
import com.example.board.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public int insert(BoardDTO dto) {
	    String sql = "INSERT INTO jjw_board2 VALUES (jb_seq.NEXTVAL, ?, ?, ?)";
	    return jdbcTemplate.update(sql, dto.getJbid(), dto.getJbpw(), dto.getJbname());
	}
	
	public BoardDTO check(BoardDTO dto) {
		String sql = "SELECT * FROM jjw_board2 WHERE jbid=? AND jbpw=?";
		
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), dto.getJbid(), dto.getJbpw());			
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<BboardDTO> showBoard() {
		String sql = "SELECT jbb.jbbno, jbb.jbbtitle, jb.jbid,jb.jbname "
					+"FROM jjw_board2_board jbb "
					+"JOIN jjw_board2 jb "
					+"ON jb.jbid = jbb.jbid";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BboardDTO.class));
	}
	
	public BboardDTO viewBoard(int jbbno) {
		String sql = "SELECT jbb.jbbno AS jbbno, jbb.jbbtitle AS jbbtitle, jbb.jbbcontent AS jbbcontent, jb.jbname AS jbname "
					+"FROM jjw_board2_board jbb "
					+"JOIN jjw_board2 jb "
					+"ON jb.jbid = jbb.jbid "
					+"WHERE jbbno = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BboardDTO.class), jbbno);
		
	}
}
