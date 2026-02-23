package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.idnexDAO;
import DTO.indexDTO;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.JsonUser;


// 실질적인 중앙서버. 각 DAO, DTO, JSON 등등의 것들을 모두 모아 필요한 것들을 연결하고 보내는 역할
@WebServlet("/regiUser")
//@MultipartConfig
public class regiUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int result = 0;
		
		/*
		System.out.println("regiUser.....");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		System.out.println(id);
		System.out.println(pw);
		*/
		
		indexDTO ito = new indexDTO();		// DTO 생성
		idnexDAO iao = new idnexDAO();		// DAO 생성
		// Mapper 생성 ( JSON -> JAVA로 객체 변환)
		ObjectMapper mapper = new ObjectMapper();
		// 클라이언트가 보낸 Json 데이터를 자동으로 JsonUser객체로 변환
		JsonUser jUser = mapper.readValue(request.getReader(), JsonUser.class);
		// 그냥 확인용
		System.out.println(jUser);
		// 내가 보낼 응답을 Json 형식으로 설정하고, 글자 깨짐 방지
		response.setContentType("application/json; charset=UTF-8");
		// 응답 데이터를 보내기 위한 출력스트림
		PrintWriter out = response.getWriter();

		// insert 하기
		ito.setId(jUser.getId());	// DTO에 ID설정
		ito.setPw(jUser.getPw());	// DTO에 PW설정
		
		try {
			// DTO에 설정한 ID, PW를 DAO의 insert 를 사용하여 데이터베이스에 넣고 결과값 받아오기
			result = iao.insert(ito);		// insert 했을 때 반환값을 result 에 대입
		} catch (Exception e) {
			result = 0;					// 오류뜨면 실패로 간주하고 0으로 대입
		}
		// 결과가 1(성공)인지 0(실패)인지 구별
		if(result == 1) {
			out.print("등록 성공했습니다.\n");				// 뭔가 알아보기 힘들수도 있어서 성공했다는 말도 붙여줌
			mapper.writeValue(out, jUser);		// 결과가 1(성공)이라면(insert 성공) id, pw를 응답함
		}else {
			out.print("등록 실패했습니다.");			// 만약 실패하면 fail 로 응답
		}
	}

}
