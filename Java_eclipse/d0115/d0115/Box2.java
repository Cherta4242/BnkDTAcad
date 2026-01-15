package d0115;

public class Box2<T> {

	// T = type 을 의미, 이 T를 파라미터 라고 부름
	
	private T ob;
	
	public void set(T o) {
		this.ob = o;
	}
	public T get() {
		return ob;
	}
}