package javareview.a07_2week;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
/* 
# database - java 연결
1. DAO(database access object)
	- 소캣통신을 통한 여러가지 모듈을 필요로 한다 -jdbc 드라이버
		= 각 DB 서버 회사에서 지원한다 @@.jar 파일로 되어 있다
	- DB 연결을 위해 필요로 하는 정보
		= ip, port, sid, 계정, 비밀번호
	- DB 처리는 어떤 순서로 처리가 될까
		= DB서버가 있고
		= driver를 메모리에 로딩
		= DB연결을 필요로 하는 정보를 통해서 연결
		= 명령어를 통해서 서버에 요청(Stratement) sql과 Statement객체 필요
			select (dql) : 서버에서 해당명령의 결과를 전달
				==> 결과물을 받는 객체가 필요 ResultSet
				==> ArrayList<Vo>
			insert, update, delete(dml) : 요청정보를 DB 서버내에서 처리한다
				==> 트랜잭션처리와 함께 명령어인 commit, rollback을 처리
		= 자원을 해제
		= 기타 DB처리시, 발생하는 예외를 처리
			try{}catch(SQLException e){}
	2) DAO의 역할
		- 데이터베이스 서버 연결
		- 메서드를 통해서 입력받은 데이터인 VO를 통해서,
			조회를 하거나, 등록, 수정, 삭제를 처리한다
		- 지원을 해제처리
 */
	// 데이터베이스 연결을 처리하는 객체
	private Connection conn;
	// 서버와 대화를 하는 객체
	private Statement stmt;
	private PreparedStatement pstmt;
	//3. 결과값을 받는 객체
	private ResultSet rs;
	// db와 연동
	public void setCon(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "scott";
			String pass = "tiger";
			conn = DriverManager.getConnection(url,id,pass);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("접속성공");
	}
	// 기능 메소드 만들기
	public ArrayList<Emp> selectEmp(int cnt){
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			String sql = "select deptno, empno, ename, job, sal from emp2 where deptno = "+cnt;
			setCon();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("부서번호\t사원번호\t사원명\t직책\t급여");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getInt(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.println(rs.getDouble(5)+"\t");
			}
			rs.close(); stmt.close(); conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		Database dao = new Database();
		dao.setCon();
		dao.selectEmp(10);
	}
}
