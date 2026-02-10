package domain;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Count")
public class Count extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int count=0;
	
	public void plusCount() {
		count = count + 1;
	}
	
	public int getCount(){
		return count;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
