package javareview.project3;

public class Ratings {
	 private String name;
	   private String date;
	   private String feeling;
	   private String place;
	   private String review;
	   
	   
	   
	   public Ratings(String name, String feeling, String place, String review) {
	      super();
	      this.name = name;
	      this.feeling = feeling;
	      this.place = place;
	      this.review = review;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getDate() {
	      return date;
	   }
	   public void setDate(String date) {
	      this.date = date;
	   }
	   public String getFeeling() {
	      return feeling;
	   }
	   public void setFeeling(String feeling) {
	      this.feeling = feeling;
	   }
	   public String getPlace() {
	      return place;
	   }
	   public void setPlace(String place) {
	      this.place = place;
	   }
	   public String getReview() {
	      return review;
	   }
	   public void setReview(String review) {
	      this.review = review;
	   }
	   public Ratings() {
	      super();
	      // TODO Auto-generated constructor stub
	   }

}
