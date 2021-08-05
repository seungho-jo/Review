package project6.follow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection dbConn;
	
		public static Connection getConnection() {
			Connection conn = null;
			try {
				String user = "project6";
				String pw = "1111";
				String url = "jdbc:oracle:thin:@203.216.179.152:1521:xe";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url,user,pw);
				System.out.println("Database에 연결되었습니다");
			}catch(ClassNotFoundException cnfe) {
				System.out.println("DB 드라이버 로딩 실패: " + cnfe.toString());
			}catch(SQLException sqle) {
				System.out.println("DB 접속실패: "+sqle.toString());
			}catch(Exception e) {
				System.out.println("에러발생");
				e.printStackTrace();
			}
			return conn;
		}
}
