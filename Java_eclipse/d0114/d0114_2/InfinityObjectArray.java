package d0114_2;

public class InfinityObjectArray {
	
	
	
	Object[] obj = new Object[3];

	
	// abc 필드 하나씩만 두고, 
	// showArray 를 사용하면 무한배열의 필드값을 출력하는데, 필드를 하나만 두기...
	// 필드값의 결과는 문자로 반환, 
	// A클래스의 필드는 뭡니다~
	// 그 문자열을 반환해주는 함수를 각 필드에 메소드로 만드는데 오버라이딩 하는거.
	// object가 가지고 있는 tostring을 a, b, c클래스에서 오버라이딩하여 재정의 하고, 출력..?
	
	public void Add(Object obj) {
		Object[] obj2 = new Object[this.obj.length + 3];
		for(int i = 0; i < this.obj.length; i++) {
			obj2[i] = this.obj[i];
		}
		obj2[this.obj.length + 1] = obj;
		this.obj = obj2;
	}
	
	public void showArray() {
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] == null) {
				
			}else {
				System.out.println(obj[i]);	
			}
			
		}
	}
	
	public void showClassArray() {
		A a = new A();
		for(int i = 0; i < obj.length; i++) {
			if(obj[i].getClass().equals(a)) {
				a.af();
			}else {
				System.out.println(obj[i]);	
			}
			
		}
	}
	
}
