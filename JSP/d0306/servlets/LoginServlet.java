package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import dao.LoginDAO;
import dto.LoginDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("mbid");
		String pw = request.getParameter("mbpw");
		
		System.out.println(id);
		System.out.println(pw);
		
		LoginDTO dto = new LoginDTO();
		LoginDAO dao = new LoginDAO();

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		dto.setId(id);
		dto.setPw(pw);
		
		LoginDTO result = null;
		
		try {
			result = dao.login(dto);			
			System.out.println(result.getId());
			System.out.println(result.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result != null){
			HttpSession session = request.getSession();

			session.setAttribute("loginId", result.getId());
			session.setAttribute("loginName", result.getName());
			session.setAttribute("loginPw", result.getPw());

			out.print("로그인 성공");

		}else{

			out.print("로그인 실패");

		}
	}
}