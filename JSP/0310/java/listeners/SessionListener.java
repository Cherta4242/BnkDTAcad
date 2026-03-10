package listeners;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	
	private static AtomicInteger activeSession = new AtomicInteger(0);
	
	public static int getActiveSessions() {
		return activeSession.get();
	}
	
	static int usercount = 0;
	
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created!");
		usercount++;
		int count = activeSession.incrementAndGet();
		System.out.println("현재 접속자 수: " + usercount + "명 입니다. | count: " + count);
	}
	
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("session attribute added!");
		System.out.println("현재 접속자 수: " + usercount + "명 입니다.");
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session attribute replaced!");
		System.out.println("현재 접속자 수: " + usercount + "명 입니다.");
	}
		
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("session attribute removed!");
		System.out.println("현재 접속자 수: " + usercount + "명 입니다.");
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session attribute destroyed!");
		usercount--;
		int count = activeSession.decrementAndGet();
		System.out.println("현재 접속자 수: " + usercount + "명 입니다. | count: " + count);
		
		
	}
	
	
}
