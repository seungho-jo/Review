package javareview.project3;

public class Question_Travel {
	private String writer;
	private String name;
	private String title;
	private String content;
	private String tag;
	private String date;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Question_Travel(String title, String content, String tag) {
		super();
		this.title = title;
		this.content = content;
		this.tag = tag;
	}
	public Question_Travel() {
		
	}
}
