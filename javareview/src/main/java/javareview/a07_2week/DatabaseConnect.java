package javareview.a07_2week;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnect {
	/*
	 * # 데이터 베이스 연결 
	 * 1. sql 작성 
	 * 2. Connection로 부터 Statement 객체 생성
	 * 3. sql를 statement에 의해 실행 ==> ResultSet 객체 
	 * 4. ResultSet 객체를 통해 결과내용 확인 
	 * 5. ResultSet를 while next(), getXXX(컬럼명)를 통해서 최종적으로 return할 ArrayList<VO> 객체 데이터 할당 
	 * 6. 자원 해제 :생성된 객체들에 대한 자원을 해제 
	 * ResultSet ==> Statement ==> Connection 순 
	 * 7. 예외처리의 내용을 구체화 처리 혹, 남아있는 객체들 메모리 해제 dml의 경우 rollback 처리.. 
	 * # PreparedStatement 객체 
	 * 1. 동적 sql(문자열 조합)구문의 보안적 필요성과 처리 속도에 대한 이슈로 만들어진 객체 
	 * 2. DML(insert,update,delete) 
	 * 	1) 기능메서드선언 public void insertEmp(Emp ins) 
	 * 	2) 연결 공통 메서드 호출 
	 * 	3) con.setAutocommit(false); 자동 autocommit 발생 방지 
	 * 	4) sql 선언 insert into emp02 values(emp_seq.nextval,?,?,sysdate,?,?,?) 
	 * 	5) PreparedStatement 처리 pstmt.setXXX(1,데이터) pstmt.setXXX(2,데이터) pstmt.setXXX(3,데이터) 
	 * 	6) executeUpdate() 
	 * 	7) con.commit 
	 * 	8) 자원해제처리 
	 * 	9) 예외 처리 - rollback
	 */
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 연결
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "scott";
			String pass = "tiger";
			conn = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("접속성공");
	}

	// Statement
	public ArrayList<Emp> schEmp() {
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			String sql = "select * from emp";
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	// PreparedStatement
	public ArrayList<Emp> schEmp2() {
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			String sql = "select * from emp";
			connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	// DML
	public void insertEmp(Emp ins) {
		try {
			String sql = "insert into emp2 values(?,?,?,?,sysdate,?,?,?)";
			connect();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ins.getEmpno());
			pstmt.setString(2, ins.getEname());
			pstmt.setString(3, ins.getJob());
			pstmt.setInt(4, ins.getMgr());
			pstmt.setDouble(5, ins.getSal());
			pstmt.setDouble(6, ins.getComm());
			pstmt.setInt(7, ins.getDeptno());
			pstmt.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnect dao = new DatabaseConnect();
		ArrayList<Emp> list = dao.schEmp();
		for(Emp e: list) {
			System.out.print(e.getEmpno());
			System.out.print(e.getEname());
			System.out.print(e.getJob());
			System.out.print(e.getMgr());
			System.out.print(e.getHiredate());
			System.out.print(e.getSal());
			System.out.print(e.getComm());
			System.out.println(e.getDeptno());
		}
		ArrayList<Emp> list2 = dao.schEmp2();
		for(Emp e: list2) {
			System.out.print(e.getEmpno());
			System.out.print(e.getEname());
			System.out.print(e.getJob());
			System.out.print(e.getMgr());
			System.out.print(e.getHiredate());
			System.out.print(e.getSal());
			System.out.print(e.getComm());
			System.out.println(e.getDeptno());
		}
		dao.insertEmp(new Emp(8000,"조승호","학생",7999,null,3200,300,20));
	}

}
