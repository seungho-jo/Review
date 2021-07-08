package javareview.project5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection dbConn;
	
		public static Connection getConnection() {
			Connection conn = null;
			try {
				String user = "scott";
				String pw = "tiger";
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
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