package d0112;

class Animal {

	public void Cry() {
		System.out.println("울었습니다.");
	}
}
	
class Tiger extends Animal{
	public void Cry() {
		System.out.println("호랑이는 어흥.. 하고");
	}
}
class Dog extends Animal{
	public void Cry() {
		System.out.println("개는 멍멍.. 하고");
	}
}
class Cat extends Animal{
	public void Cry() {
		System.out.println("고양이는 야옹.. 하고");
	}
	public void See() {
		System.out.println("하지만 고양이는 귀엽죠?");
	}
}

public class Animals {

	
	
	public static void main(String[] args) {

		// 호랑이가 있다. 어흥하고 운다.
		// 강아지가 있다. 멍멍하고 운다.
		// 고양이는 야옹

		// 각 동물들이 우는걸 출력하는거. 만들기
		// 그리고 반복문을 사용해서 처리하세요.

		Animal[] animals = new Animal[4];
		
		animals[0] = new Animal();
		animals[1] = new Tiger();
		animals[2] = new Dog();
		animals[3] = new Cat();
		
		for(int i = 0; i < 4; i++) {
			animals[i].Cry();
		}
		
		System.out.println("=================");
		Cat cat = (Cat)animals[3];
		cat.See();
			
	}
}
