package d0116_4;


public class Dictionary_Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Dictionary dict = new Dictionary();
		
		dict.Add("키위", "kiwi");
		dict.Add("사과", "apple");
		dict.Add("과일", "fruit");
		dict.Add("코끼리", "aliphant");
		dict.Add("장진우", "JangJinWoo");
		dict.Add("수업", "class");
		dict.Add("학교", "school");
		dict.Add("문제", "problem");
		
		Dictionary.showDiction(dict);
		
		Dictionary.quection();
		
		
		
		
	}
	
	
}
