package javareview.project3;

public class Travel {
	private String nation;
	private String korName;
	private String engName;
	private String loc;
	private int clip;
	private String content;
	private String category;
	private String pnum;
	private String web;
	public Travel() {
		
	}
	public Travel(String nation, String korName, String engName, String loc, int clip, String content, String category,
			String pnum, String web) {
		super();
		this.nation = nation;
		this.korName = korName;
		this.engName = engName;
		this.loc = loc;
		this.clip = clip;
		this.content = content;
		this.category = category;
		this.pnum = pnum;
		this.web = web;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getClip() {
		return clip;
	}
	public void setClip(int clip) {
		this.clip = clip;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
}
