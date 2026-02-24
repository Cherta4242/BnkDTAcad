package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.SignupDAO;
import DTO.SignupDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.JsonSignup;


@WebServlet("/viewSignUp")
public class viewSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세팅
		request.setCharacterEncoding("UTF-8");
		int result = 0;
		SignupDTO dto = new SignupDTO();
		SignupDAO dao = new SignupDAO();
		ObjectMapper mapper = new ObjectMapper();
		JsonSignup jSup = mapper.readValue(request.getReader(), JsonSignup.class);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// dto에 데이터 쥐여주기
		dto.setId(jSup.getId());
		dto.setPw(jSup.getPw());
		dto.setName(jSup.getName());
		dto.setPh(jSup.getPh());
		
		try {
			result = dao.signUpviewing(dto);
		}catch(Exception e) {
			result = 0;
		}
		
		if(result == 1) {
			out.print("등록 완료.\n");
		}else {
			out.print("등록 실패.\n아이디를 다시 적어주세요");
		}
	}
}
