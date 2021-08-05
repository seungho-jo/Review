package project6.follow;

public class Follow {
	private String id; // 팔로워 id
	private String follow; // 팔로잉 id
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Follow(String id, String follow) {
		super();
		this.id = id;
		this.follow = follow;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	
}
