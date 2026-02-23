package pojo;
// Json으로 받은 것들의 데이터들을 하나하나 뽑아내주는 역할
public class JsonUser {
	// 받은 ID 및 PW 정의
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
	// toString 재정의
	@Override
	public String toString() {
		return "JsonUser [id=" + id + ", pw=" + pw + "]";
	}
}
