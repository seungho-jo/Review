package project6.comment;

public class Comment {
	private String bcode;
	private String id;
	private String content;
	private String cdate;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(String bcode, String id, String content) {
		super();
		this.bcode = bcode;
		this.id = id;
		this.content = content;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	
}
