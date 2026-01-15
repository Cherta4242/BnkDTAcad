package d0115_2;

public class GEinfinityArray<T> {

	private Object[] obj = new Object[0];
	
	
	public void add(T obj) {
		Object[] obj2 = new Object[this.obj.length + 1];
		for(int i = 0; i < this.obj.length; i++) {
			obj2[i] = this.obj[i];
		}
		obj2[this.obj.length] = obj;
		this.obj = obj2;
	}
	
	
	public void add(int idx, T obj) {
		Object[] obj2 = new Object[this.obj.length + 1];
		for(int i = 0; i < idx; i++) {
			obj2[i] = this.obj[i];
		}
		obj2[idx] = obj;
		for(int i = idx; i < this.obj.length; i++) {
			obj2[i+1] = this.obj[i];
		}
		this.obj = obj2;
	}
	
	
	public void set(int idx, T obj) {
		this.obj[idx] = obj;
	}
	
	public void remove(int idx) {
		Object[] obj2 = new Object[this.obj.length-1];
		for(int i = 0; i < idx; i++) {
			obj2[i] = this.obj[i];
		}
		for(int i = idx; i < this.obj.length-1; i++) {
			obj2[i] = this.obj[i+1];
		}
		this.obj = obj2;
	}
	
	public T get(int idx) {
		T ob = (T)obj[idx];
		return ob;
	}
	
	public boolean contains(T t) {
		boolean br = true;
		for(int i = 0; i < obj.length; i++) {
			if(t == obj[i]) {
				br = true;
				break;
			}else {
				br = false;
			}
		}
		return br;
	}
	
	public void showall(){
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] == null) {
				
			}else {
				System.out.println(obj[i]);
			}
		}
	}
}
