package javareview.project4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	public ArrayList<Member> mlist = new ArrayList<Member>();

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	// 회원가입
	public boolean joinMember(Member me) {
		boolean flag = false;
		try {
			String sql = "insert into smlmember(loginmail,loginpass,name,phonenum,address,mobilememnum)"
					+ "values(?,?,?,?,?,?)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, me.getLoginmail());
			pstm.setString(2, me.getLoginpass());
			pstm.setString(3, me.getName());
			pstm.setString(4, me.getPhonenum());
			pstm.setString(5, me.getAddress());
			pstm.setString(6, me.getMobilememnum());
			if (pstm.executeUpdate() == 1)
				flag = true;
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally {
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

	// 로그인
	public boolean login(String loginmail, String loginpass) {
		boolean flag = false;
		try {
			String sql = "SELECT * FROM smlmember where loginmail = ? and loginpass = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, loginmail);
			pstm.setString(2, loginpass);
			rs = pstm.executeQuery(); // 실행
			flag = rs.next(); // true면 로그인 성공, false 면 로그인 실패
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
		} finally {
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

}
