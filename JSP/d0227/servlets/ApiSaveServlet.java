package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApiSaveServlet")
public class ApiSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
    public void init() throws ServletException {
        super.init();
        BufferedReader rd = null;
        HttpURLConnection conn = null;
        
        try {
            // API URL 만들기
            StringBuilder urlBuilder = new StringBuilder(
                "http://apis.data.go.kr/6480000/gyeongnamcultural/gyeongnamculturallist"
            );
            // Service Key
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=1a113cbe7f4f2b05fcbd0ebf42de0db624bfa7c9a27fb081b4e4cffc1e5a1b11");
            // 페이지 번호
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
            // 한 페이지 결과 수
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8"));
            // Json 방식으로 호출 시 파라미터 resultType=json 입력
            urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            rd.close();
            conn.disconnect();

            // application에 저장
            getServletContext().setAttribute("apiData", sb.toString());

            System.out.println("API 데이터 application에 저장 완료");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(rd != null) rd.close();
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	if(conn != null) conn.disconnect();
        }
    }

    // doGet에서는 application에서 가져와서 브라우저에 출력
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter out = response.getWriter();
        // application에서 저장된 데이터 가져오기
        String data = (String) getServletContext().getAttribute("apiData");

        if(data != null){
            out.print(data);
        } else {
            out.print("{\"error\":\"데이터 없음\"}");
        }
    }
}