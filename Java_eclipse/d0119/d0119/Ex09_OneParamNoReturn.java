package d0119;

interface Singable{
	void sing(String song);
}

public class Ex09_OneParamNoReturn {

	public static void main(String[] args) {
		Singable s;
		
		// 람다로 작성
		s = new Singable() {
			@Override
			public void sing(String song) {
				System.out.println(song);
			}
		};
		s.sing("내가 만일 하늘이라면~");
		// 줄이고
		s = (String song) -> {
			System.out.println(song);		
		};
		s.sing("그대, 나를, 나를 잊었나");
		// 더 줄이고
		s = (song) -> {
			System.out.println(song);
		};
		s.sing("그대, 나를, 진저어어엉~~~~");
		//더 더 줄이고
		s = (song) -> System.out.println(song);
		s.sing("워어어어어어어어어어어어어어어어엉어ㅓㅇ이예에에에에에에에~~~");
		
		//더 더 줄이고
		s = song -> System.out.println(song);
		s.sing("어둡고 탁한~ 나의 맘에~ 길을 잃은 밤에!");
	}
	
}
