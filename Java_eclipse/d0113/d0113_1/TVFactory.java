package d0113_1;

public class TVFactory {
	
	String brandName;
	
	
	TVFactory(String brandName){
		brandName(brandName);
	}
	
	// 브랜드네임이 삼성이면 삼성, 엘지면 엘지를, 둘 다 아니면 Null반환.
	// 브랜드네임은 삼성 또는 엘지 둘 중 하나 저장
	public String brandName(String brandName) {
		if(brandName == "samsung") {
			STv sams = new STv();
			this.brandName = "SamSung";
		}else if(brandName == "lg") {
			LTv lgs = new LTv();
			this.brandName = "LG";{
				
			}
		}else {
			this.brandName = "NULL";
		}
		
		return this.brandName;
	}
	
	void getBrand(){
		System.out.println(brandName);
	}
}


// 행님 혹시 모하는거에요?

