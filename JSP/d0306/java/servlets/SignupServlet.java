package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.SignupDAO;
import dto.SignupDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import json.SignupJSON;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int result = 0;
		
		SignupDTO dto = new SignupDTO();
		SignupDAO dao = new SignupDAO();
		
		ObjectMapper mapper = new ObjectMapper();
		SignupJSON sjson = mapper.readValue(request.getReader(), SignupJSON.class);
		response.setContentType("aplication/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		dto.setId(sjson.getId());
		dto.setPw(sjson.getPw());
		dto.setName(sjson.getName());
		
		try {
			result = dao.signup(dto);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		if(result == 1) {
			out.print("회원가입 완료");
		}else {
			out.print("회원가입 실패");
		}
		
		
	}

}
