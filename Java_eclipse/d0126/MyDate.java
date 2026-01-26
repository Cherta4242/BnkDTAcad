package d0124;

public class MyDate {
	
	private int year = 1;
	private int month = 1;
	private int day = 1;
	
	MyDate(){
		System.out.println("===============================");
		System.out.println("기본적으로 1년 1월 1일이 들어가있습니다.");
		System.out.println("===============================");
	}
	
	public int years(int year) {
		this.year = year;
		
		return this.year;
	}
	
	public int months(int month) {
		if(month < 1 || month > 12) {
			System.out.println("월은 1월 ~ 12월까지만 넣을 수 있습니다.");
			System.out.println("===============================");
		}else {
			this.month = month;
		}
		
		return this.month;
	}
	
	public int days(int day) {
		
		if(month % 2 == 1) {
			// 1, 3, 5, 7월 달까지.
			if(0 < month && month < 8) {
				if(0 < day && day < 32) {
					this.day = day;
				}else {
					System.out.println("날짜는 1일부터 31일까지 넣을 수 있습니다.");
					System.out.println("날짜가 자동으로 1일로 바뀝니다.");
					System.out.println("===============================");
				}
				// 9. 11월 달까지.
			}else if(8 < month && month < 12){
				if(0 < day && day < 31) {
					this.day = day;
				}else {
					System.out.println("날짜는 1일부터 30일까지 넣을 수 있습니다.");
					System.out.println("날짜가 자동으로 1일로 바뀝니다.");
					System.out.println("===============================");
				}
			}else {
				System.out.println("월이 조금 이상합니다.");
				System.out.println("날짜가 자동으로 1일로 바뀝니다.");
				System.out.println("===============================");
			}
			
		}else if(month % 2 == 0) {
			switch(month) {
			case 2:
				if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
					if(0 < day && day < 30) {
						this.day = day;
					}else {
						System.out.println("날짜는 1일부터 29일까지 넣을 수 있습니다.");
						System.out.println("날짜가 자동으로 1일로 바뀝니다.");
						System.out.println("===============================");
					}
				}else {
					if(0 < day && day < 29) {
						this.day = day;
					}else {
						System.out.println("날짜는 1일부터 28일까지 넣을 수 있습니다.");
						System.out.println("날짜가 자동으로 1일로 바뀝니다.");
						System.out.println("===============================");
					}
				}
				break;
			case 4:
			case 6:
				if(0 < day && day < 31) {
					this.day = day;
				}else {
					System.out.println("날짜는 1일부터 30일까지 넣을 수 있습니다.");
					System.out.println("날짜가 자동으로 1일로 바뀝니다.");
					System.out.println("===============================");
				}
				break;
			case 8:
			case 10:
			case 12:
				if(0 < day && day < 32) {
					this.day = day;
				}else {
					System.out.println("날짜는 1일부터 31일까지 넣을 수 있습니다.");
					System.out.println("날짜가 자동으로 1일로 바뀝니다.");
					System.out.println("===============================");
				}
				break;
			default:
				System.out.println("월이 조금 이상한데요?");
				System.out.println("날짜가 자동으로 1일로 바뀝니다.");
				System.out.println("===============================");
			}
		}
		return this.day;
	}
	
	public void showDate() {
		System.out.println("입력받은 날짜 -> " + year + "년 " + month + "월 " + day + "일");
		System.out.println("===============================");
	}
}
