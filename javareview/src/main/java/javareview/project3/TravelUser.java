package javareview.project3;

public class TravelUser {
	private String email;
	private String pass;
	private String name;
	private String gender;
	public TravelUser() {
		
	}
	public TravelUser(String email, String pass, String name, String gender) {
		super();
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
