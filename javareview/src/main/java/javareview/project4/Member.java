package javareview.project4;

public class Member {
	 private String loginmail;
	   private String loginpass;
	   private String name;
	   private String phonenum;
	   private String address;
	   private String mobilememnum;
	   public Member() {
	      
	   }
	   public Member(String loginmail, String loginpass, String name, String phonenum, String address) {
	      super();
	      this.loginmail = loginmail;
	      this.loginpass = loginpass;
	      this.name = name;
	      this.phonenum = phonenum;
	      this.address = address;
	   }
	   public Member(String loginmail, String loginpass) {
	      super();
	      this.loginmail = loginmail;
	      this.loginpass = loginpass;
	   }
	   public Member(String loginmail, String loginpass, String name, String phonenum, String address,
	         String mobilememnum) {
	      super();
	      this.loginmail = loginmail;
	      this.loginpass = loginpass;
	      this.name = name;
	      this.phonenum = phonenum;
	      this.address = address;
	      this.mobilememnum = mobilememnum;
	   }

	   public String getLoginmail() {
	      return loginmail;
	   }
	   public void setLoginmail(String loginmail) {
	      this.loginmail = loginmail;
	   }
	   public String getLoginpass() {
	      return loginpass;
	   }
	   public void setLoginpass(String loginpass) {
	      this.loginpass = loginpass;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getPhonenum() {
	      return phonenum;
	   }
	   public void setPhonenum(String phonenum) {
	      this.phonenum = phonenum;
	   }
	   public String getAddress() {
	      return address;
	   }
	   public void setAddress(String address) {
	      this.address = address;
	   }
	   public String getMobilememnum() {
	      return mobilememnum;
	   }
	   public void setMobilememnum(String mobilememnum) {
	      this.mobilememnum = mobilememnum;
	   }
}
