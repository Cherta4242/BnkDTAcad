package DTO;
// DTO는 데이터를 실어나르는 역할(Data Transfer Object)
public class indexDTO {
	// ID 및 PW 준비
	private String id;
	private String pw;
	
	// SET, GET 정의
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	// toString을 오버라이딩
	@Override
	public String toString() {
		return "indexDTO [id=" + id + ", pw=" + pw + "]";
	}
}
