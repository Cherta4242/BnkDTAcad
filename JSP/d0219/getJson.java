package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/getJson")
public class getJson extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String json = "{\"no\": 10, \"id\": \"abc\", \"name\",: \"진우\"}";
//		String nostr = request.getParameter("no");
//		if(nostr != null) {
//			user.setNo(Integer.parseInt(nostr));			
//		}else {
//		}
//		String id = request.getParameter("id");
//		if(id != null) {
//			user.setId(id);
//		}else {
//		}

		
		
//		User user = new User();
//		ObjectMapper mapper = new ObjectMapper();
//		user.setNo(20);			
//		user.setId("bbb");			
//		String name = request.getParameter("name");
//		if(name != null) {
//			user.setName(name);			
//		}else {
//			user.setName("Khan");			
//		}	
//		String json = mapper.writeValueAsString(user);
//		out.print(json);

		
		
		System.out.println(request.getParameter("id"));
//		if("cherta42".equals(request.getParameter("id"))) {
//			out.print("이미 있는 아이디입니다.");
//		}else {
//			out.print("없는 아이디입니다");
//		}
		
		List<String> idlist = Arrays.asList("cherta42", "admin", "user01", "guest");		
		
		boolean flag = idlist.contains(request.getParameter("id"));
		
		if(flag) {
			out.print("이미 있는 아이디입니다.");
		}else {
			out.print("없는 아이디입니다");
		}
		
	}
}
