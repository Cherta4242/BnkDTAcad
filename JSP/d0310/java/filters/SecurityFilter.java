package filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter("/secu")
public class SecurityFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	private Set<String> blackList = new HashSet<>();
	
	public void init(FilterConfig fConfig) throws ServletException {
		// 192.168.0.84(건엽킴)
		blackList.add("192.168.0.84");
//		System.out.println("보안 필터 초기화: " + blackList.size() + "개의 IP를 차단합니다.");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String clientIp = httpRequest.getRemoteAddr();
		System.out.println("clientIp: " + clientIp);
		String uri = httpRequest.getRequestURI();
		System.out.println("uri: " + uri);
		
		// IP 차단
		if(blackList.contains(clientIp)) {
			System.out.println("차단된 IP 접속 시도 거부" + clientIp + ", " + uri);
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied(BlackList IP)");
			return;
		}
		
		chain.doFilter(request, response);
	}



}
