package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.orderDAO;
import DTO.orderDTO;
import JSON.JsonOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		int result = 0;
		orderDTO odt = new orderDTO();
		orderDAO oao = new orderDAO();
		ObjectMapper mapper = new ObjectMapper();
		JsonOrder jOdr = mapper.readValue(request.getReader(), JsonOrder.class);
		response.setContentType("apllication/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		odt.setOrderno(jOdr.getOrderno());
		odt.setShopname(jOdr.getShopname());
		odt.setOrderdate(jOdr.getOrderdate());
		odt.setPcode(jOdr.getPcode());
		odt.setAmount(jOdr.getAmount());
		
		try {
			result = oao.insertOreder(odt);
		}catch(Exception e) {
			result = 0;
		}
		if(result == 1) {
			out.print("등록완료");
		}else {
			out.print("등록실패");
		}
		
	}

}
