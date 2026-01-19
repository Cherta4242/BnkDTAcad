package d0119;

interface Animal{
	int DOG = 1;
	int CAT = 2;
}

class Person{
	public static final int MAN = 1;
	public static final int WOMAN = 2;
}

public class Ex02_NonSafeConst {
	
	public static void who(int man) {
		switch(man) {
		case Person.MAN:
			System.out.println("남성 입니다.");	break;
		case Person.WOMAN:
			System.out.println("여성 입니다.");	break;

		}
	}
	
	public static void main(String[] args) {
		who(Person.MAN);
		who(Person.WOMAN);
		who(Animal.DOG);
	}
}
