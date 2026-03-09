package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import json.BoardJSON;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int result = 0;
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		ObjectMapper mapper = new ObjectMapper();
		BoardJSON bjson = mapper.readValue(request.getReader(), BoardJSON.class);
		response.setContentType("apllication/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		dto.setName(bjson.getName());
		dto.setTitle(bjson.getTitle());
		dto.setContent(bjson.getContent());
		dto.setId(bjson.getId());
		
		try {
			result = dao.updateBoard(dto);
		}catch(Exception e) {
			result = 0;
		}
		if(result == 1) {
			out.print("수정완료");
		}else {
			out.print("수정실패");
		}
		
		
	}


}
