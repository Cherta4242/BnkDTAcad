package JSON;

public class JsonOrder{
	private String orderno;
	private String shopname;
	private String orderdate;
	private String pcode;
	private int amount;
	
	// orderno
	public String getOrderno() {return orderno;}
	public void setOrderno(String orderno) {this.orderno = orderno;}
	// shopname
	public String getShopname() {return shopname;}
	public void setShopname(String shopname) {this.shopname = shopname;}
	// orderdate
	public String getOrderdate() {return orderdate;}
	public void setOrderdate(String orderdate) {this.orderdate = orderdate;}
	// pcode
	public String getPcode() {return pcode;}
	public void setPcode(String pcode) {this.pcode = pcode;}
	// amount
	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}
	// tostring 재정의
	@Override
	public String toString() {
		return "orderDTO [orderno=" + orderno + ", shopname=" + shopname + ", orderdate=" + orderdate + ", pcode="
				+ pcode + ", amount=" + amount + "]";
	}
}
