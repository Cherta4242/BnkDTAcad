package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import json.MemberJson;

@WebServlet("/InsertSelect")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int result = 0;
		
		// 각종 것들 셋팅
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		ObjectMapper mapper = new ObjectMapper();
		MemberJson json = mapper.readValue(request.getReader(), MemberJson.class);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 받아온 데이터 대입
		dto.setId(json.getId());
		dto.setPw(json.getPw());
		dto.setNickname(json.getNickname());
		
		// 등록
		try {
			result = dao.insert(dto);
		}catch(Exception e) {
			result = 0;
		}
		
		if(result == 1) {
			out.print("등록성공");
		}else {
			out.print("등록실패");
		}
	}
}
