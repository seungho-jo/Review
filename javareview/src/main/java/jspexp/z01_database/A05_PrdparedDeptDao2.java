package jspexp.z01_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jspexp.z02_VO.Dept;
import jspexp.z02_VO.Emp;

public class A05_PrdparedDeptDao2 {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void connSet() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String user = "scott";
			String pw = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("연결완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Emp> empList(){
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			String sql = "select * from emp";
			connSet();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("empno"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<Dept> deptList(){
		ArrayList<Dept> deptList = new ArrayList<Dept>();
		A05_PrdparedDeptDao2 dao = new A05_PrdparedDeptDao2();
		try {
			String sql = "select * from dept";
			dao.connSet();
			dao.stmt = dao.conn.prepareStatement(sql);
			dao.rs = dao.stmt.executeQuery(sql);
			while(rs.next()) {
				
			}
		}catch(SQLException e) {
			
		}
		return deptList;
	}
	
	public ArrayList<Dept> schDept(){
		ArrayList<Dept> list = new ArrayList<Dept>();
		try {
			// 부서정보 받아온 sql 선언
			String sql = "select * from dept02";
			connSet();
			pstmt = conn.prepareStatement(sql);
			// 추후에 ? 갯수만큼 순서 1,2, ... 할당처리
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dept d = new Dept();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
				list.add(d);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<Emp> schEmp(String ename,String job){
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			String sql = "select * from emp2 where ename like ? and job like ? order by hiredate desc";
			connSet();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ename+"%");
			pstmt.setString(2, "%"+job+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getDate(5));
				emp.setSal(rs.getDouble(6));
				emp.setComm(rs.getDouble(7));
				emp.setDeptno(rs.getInt(8));
				list.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void insertEmp(Emp ins) {
		try {
			String sql = "INSERT INTO EMP2 VALUES(emp_seq_01.nextval,?,?,?,sysdate,?,?,?)";
			connSet();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ins.getEname());
			pstmt.setString(2, ins.getJob());
			pstmt.setInt(3, ins.getMgr());
			pstmt.setDouble(4, ins.getSal());
			pstmt.setDouble(5, ins.getComm());
			pstmt.setInt(6, ins.getDeptno());
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
	public void insertDept(Dept dp) {
		try {
			String sql = "insert into dept02 values(?,?,?)";
			connSet();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dp.getDeptno());
			pstmt.setString(2, dp.getDname());
			pstmt.setString(3, dp.getLoc());
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
	public void updateEmp(Emp ins) {
		try {
			String sql = "update emp2 set ename = ?, job = ? , mgr = ? , hiredate = to_date( ? ,'YYYY/MM/DD'), sal = ? , comm = comm+?, deptno = ?"
					+ " where empno = ? ";
			connSet();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ins.getEname());
			pstmt.setString(2, ins.getJob());
			pstmt.setInt(3, ins.getMgr());
			pstmt.setString(4, ins.getHiredates());
			pstmt.setDouble(5, ins.getSal());
			pstmt.setDouble(6, ins.getComm());
			pstmt.setInt(7, ins.getDeptno());
			pstmt.setInt(8, ins.getEmpno());
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
		A05_PrdparedDeptDao2 dao1 = new A05_PrdparedDeptDao2();
		//dao1.connSet();
		//dao1.insertEmp(new Emp(0,"마길동","대리",7780,null,4000,1000,10));
		/*
		ArrayList<Emp> list = dao1.schEmp("","");
		for(Emp d: list) {
			System.out.print(d.getEmpno()+"\t");
			System.out.print(d.getEname()+"\t");
			System.out.print(d.getJob()+"\t");
			System.out.print(d.getMgr()+"\t");
			System.out.print(d.getHiredate()+"\t");
			System.out.print(d.getSal()+"\t");
			System.out.print(d.getComm()+"\t");
			System.out.println(d.getDeptno()+"\t");
		}*/
		//dao1.insertDept(new Dept(50,"si개발","강남"));
		/*ArrayList<Dept> list = dao1.schDept();
		for(Dept d: list) {
			System.out.print(d.getDeptno()+"\t");
			System.out.print(d.getDname()+"\t");
			System.out.println(d.getLoc());
		}*/
		dao1.updateEmp(new Emp(7936,"김소현(수정)","대리",7780,"2021/07/09",5000,1000,10));
		ArrayList<Emp> list2 = dao1.schEmp("","");
		for(Emp d: list2) {
			System.out.print(d.getEmpno()+"\t");
			System.out.print(d.getEname()+"\t");
			System.out.print(d.getJob()+"\t");
			System.out.print(d.getMgr()+"\t");
			System.out.print(d.getHiredate()+"\t");
			System.out.print(d.getSal()+"\t");
			System.out.print(d.getComm()+"\t");
			System.out.println(d.getDeptno()+"\t");
		}
		// ex) Member 테이블을 mno 기준으로 수정처리
	}
}
