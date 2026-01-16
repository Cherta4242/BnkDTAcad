package d0116;

import java.util.Objects;

public class INum {

	private int num;
	
	public INum(int num) {
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(num == ((INum)obj).num) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(num);
	}
	
	
}
