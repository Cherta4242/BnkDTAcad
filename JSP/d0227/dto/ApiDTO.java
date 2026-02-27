package dto;

public class ApiDTO {
	private int cultnum;
	private String cultaddress;
	private String cultname;
	
	public int getCultnum() {
		return cultnum;
	}
	public void setCultnum(int cultnum) {
		this.cultnum = cultnum;
	}
	public String getCultaddress() {
		return cultaddress;
	}
	public void setCultaddress(String cultaddress) {
		this.cultaddress = cultaddress;
	}
	public String getCultname() {
		return cultname;
	}
	public void setCultname(String cultname) {
		this.cultname = cultname;
	}
	
	@Override
	public String toString() {
		return "ApiDTO [cultnum=" + cultnum + ", cultaddress=" + cultaddress + ", cultname=" + cultname + "]";
	}
	
}
