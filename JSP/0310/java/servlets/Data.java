package servlets;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("데이터 서블릿 실행");
		
		response.setContentType("text/html;charset=utf-8");
		ServletContext sc = request.getServletContext();
		
		String data = (String) sc.getAttribute("data");
		response.getWriter().print(data);
		
//		response.sendRedirect("data.jsp");
	}



}
