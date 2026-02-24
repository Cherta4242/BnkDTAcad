package pojo;
// Json으로 받은 것들의 데이터들을 하나하나 뽑아내주는 역할
public class JsonSignup {
	// 받은 데이터들 각각 정의
	private String id;
	private String pw;
	private String name;
	private String ph;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPh() {return ph;}
	public void setPh(String ph) {this.ph = ph;}

	@Override
	public String toString() {
		return "JsonSignup [id=" + id + ", pw=" + pw + ", name=" + name + ", ph=" + ph + "]";
	}
}
