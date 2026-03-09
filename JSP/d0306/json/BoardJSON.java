package json;

import java.sql.Blob;

public class BoardJSON {

	int id;
	String name;
	String title;
	String content;
	Blob image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "BoardJSON [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", image="
				+ image + "]";
	}
	
	
}
