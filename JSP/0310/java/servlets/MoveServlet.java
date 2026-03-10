package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("move servlet.....");
		
		String conPath = request.getContextPath();
		System.out.println("conPath: " + conPath);
		String uri = request.getRequestURI();
		System.out.println(uri.substring(conPath.length()+1));
		String rp = uri.substring(conPath.length()+1);
		
		// 컨텍스트/a 요청이면 a.jsp
		// 컨텍스트/b 요청이면 b.jsp
		// 컨텍스트/c 요청이면 c.jsp
		// 위 3개 요청을 처리할 수 있도록 코드를구현하시오.
		
		if(rp.equals("a")) {
			response.sendRedirect("a.jsp");
		}else if(rp.equals("b")) {
			response.sendRedirect("b.jsp");
		}else if(rp.equals("c")) {
			response.sendRedirect("c.jsp");
		}else {
			response.sendRedirect("test.jsp");
		}
		
	}


}
