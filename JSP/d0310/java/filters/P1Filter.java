package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;


@WebFilter("/p1")
public class P1Filter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("before p1 chaining...");
		chain.doFilter(request, response);
		System.out.println("after p1 chaining...");
	}


}
