package dto;

public class MemberDTO {
	// 변수
	private String id;
	private String pw;
	private String nickname;
	
	// getter, setter
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	// toString
	@Override
	public String toString() {
		return "InsertDTO [id=" + id + ", pw=" + pw + ", nickname=" + nickname + "]";
	}	
}
