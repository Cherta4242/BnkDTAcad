package listeners;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class AppListener implements ServletContextListener, ServletContextAttributeListener {

	public void contextInitialized(ServletContextEvent sce) {
//		System.out.println("AppListener Context init...");
//		ServletContext sc = sce.getServletContext();
//		
//		Enumeration<String> names = sc.getAttributeNames();
//		while(names.hasMoreElements()) {
//			System.out.println("기본 등록 전역 속성: " + names.nextElement());
//		}
		
//		try {
//			String data = CommonData.getData();
//			sc.setAttribute("data", data);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}   
	public void contextDestroyed(ServletContextEvent sce) {
//		System.out.println("AppListener Context destroyeed!");
	}
	

	public void attributeAdded(ServletContextAttributeEvent scae)  {
//		System.out.println("애플리케이션 영역에 속성 수정");
		/*
		String name = scae.getName();
		Object value = scae.getValue();
		System.out.println("속성명: " + name + "| " + value);
		*/
//		ServletContext sc = scae.getServletContext();
//		Enumeration<String> names = sc.getAttributeNames();
//		while(names.hasMoreElements()) {
//			System.out.println("등록된 전역 속성: " + names.nextElement());
//		}
	}
	public void attributeReplaced(ServletContextAttributeEvent scae)  {
//		System.out.println("애플리케이션 영역에 속성 수정");
		
//		String name = scae.getName();
//		System.out.println(name);
//		Object value = scae.getValue();
//		System.out.println(value);
	}


}
