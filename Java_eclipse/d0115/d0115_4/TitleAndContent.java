package d0115_4;

public class TitleAndContent {

	Title title;
	Content content;
	
	TitleAndContent(Title title, Content content) {
		this.title = title;
		this.content = content;
	}
	
	public Title setT(Title title) {
		this.title = title;
		
		return this.title;
	}
	
	public void getT() {
		title.getTitleName();
	}
	
	
	public Content setC(Content content) {
		this.content = content;

		return this.content;
	}
	public void getC() {
		content.getContent();
	}
	
}
