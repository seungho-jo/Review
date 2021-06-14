package javareview.project3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Travel_Dao {
	public ArrayList<Travel> list = new ArrayList<Travel>();
	public ArrayList<ChangingInfo> clist = new ArrayList<ChangingInfo>();
	public ArrayList<Question_Travel> qlist = new ArrayList<Question_Travel>();
	public ArrayList<TravelUser> ulist = new ArrayList<TravelUser>();
	public ArrayList<Ratings> listt = new ArrayList<Ratings>();
	Connection conn = null; 
	PreparedStatement pstm = null; 
	ResultSet rs = null; 
	public ArrayList<Travel> insertTravel(Travel t) {
		Travel tbean = new Travel();
		tbean.setNation(t.getNation());
		tbean.setKorName(t.getKorName());
		tbean.setEngName(t.getEngName());
		tbean.setLoc(t.getLoc());
		tbean.setClip(t.getClip());
		tbean.setContent(t.getContent());
		tbean.setCategory(t.getCategory());
		tbean.setPnum(t.getPnum());
		tbean.setWeb(t.getWeb());
		list.add(tbean);
		return list;
	}

	public ArrayList<Travel> insertTravel2(Travel t) {
		Travel tbean = new Travel();
		tbean.setNation(t.getNation());
		tbean.setKorName(t.getKorName());
		tbean.setEngName(t.getEngName());
		tbean.setLoc(t.getLoc());
		tbean.setClip(t.getClip());
		tbean.setContent(t.getContent());
		tbean.setCategory(t.getCategory());
		tbean.setPnum(t.getPnum());
		tbean.setWeb(t.getWeb());
		list.add(tbean);
		return list;
	}

	public ArrayList<Travel> showList() {
		System.out.println("# 전체 정보 전달");
		return list;
	}

	public ArrayList<Travel> search(String s) {
		ArrayList<Travel> lists = new ArrayList<Travel>();
		for (Travel t : list) {
			if (t.getKorName().equals(s)) {
				lists.add(t);
			}
		}
		return lists;
	}

	public ArrayList<Travel> delete(String s) {
		int choice = Integer.parseInt(s) - 1;
		list.remove(choice);
		return list;
	}

	public ArrayList<Travel> modify(String s) {
		ArrayList<Travel> lists = new ArrayList<Travel>();
		int choice = Integer.parseInt(s) - 1;
		lists.add(list.get(choice));
		return lists;
	}

	public ArrayList<Travel> detail(String s) {
		ArrayList<Travel> lists = new ArrayList<Travel>();
		int cho = Integer.parseInt(s)-1;
		lists.add(list.get(cho));
		return lists;
	}
	
	public Travel clip(String s){
		Travel lists = new Travel();	
		lists = list.get(Integer.parseInt(s)-1);
		return lists;
	}

	public ArrayList<ChangingInfo> changingInfo(String r,String s,String m){
		ChangingInfo c = new ChangingInfo();
		c.setName(r);
		c.setCategory(s);
		c.setContent(m);
		clist.add(c);
		return clist;
	}
	
	public ArrayList<Question_Travel> question(Question_Travel q, String s,String n){
		Question_Travel qbean = new Question_Travel();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		String format_time = format.format(cal.getTime());
		qbean.setWriter(s);
		qbean.setName(n);
		qbean.setTitle(q.getTitle());
		qbean.setContent(q.getContent());
		qbean.setTag(q.getTag());
		qbean.setDate(format_time);
		qlist.add(qbean);
		return qlist;
	}
	
	public ArrayList<Question_Travel> questionList(){
		return qlist;
	}
	public boolean login(String e,String p){
		boolean flag = false;
		try {
			String sql = "SELECT * FROM travelUser where email = ? and pass = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, e);
			pstm.setString(2, p);
			rs = pstm.executeQuery();
			flag = rs.next();
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
		return flag;
	}
	
	public TravelUser member(String e){
		TravelUser user = null;
		try {
			String sql = "SELECT * FROM travelUser where email = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, e);
			rs = pstm.executeQuery();
			if(rs.next()) {
				user = new TravelUser();
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setGender(rs.getString("gender"));
			}
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
		return user;
	}
	
	public ArrayList<Ratings> insertRatings(Ratings r) {
		Ratings tbea = new Ratings();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		String format_time = format.format(cal.getTime());
		tbea.setName(r.getName());
		tbea.setDate(format_time);
		tbea.setFeeling(r.getFeeling());
		tbea.setPlace(r.getPlace());
		tbea.setReview(r.getReview());
	      
		listt.add(tbea);
		return listt;
	}
	public ArrayList<Ratings> rshowList() {
		return listt;
	}
	public ArrayList<Ratings> modify1(String s) {
	      ArrayList<Ratings> lists = new ArrayList<Ratings>();
	      int choice = Integer.parseInt(s) - 1;
	      lists.add(listt.get(choice));
	      return lists;
	   }
	   public ArrayList<Ratings> delete1(String s) {
	      int choice = Integer.parseInt(s) - 1;
	      listt.remove(choice);
	      return listt;
	   }
}
