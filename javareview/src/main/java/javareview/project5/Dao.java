package javareview.project5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	// 관리자 페이지 로그인
	public boolean login(String i, int p) {
		boolean result = false;
		try {
			String sql = "SELECT * from adMember where id = ? and pass = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, i);
			pstm.setInt(2, p);
			rs = pstm.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
		return result;
	}

	// 회원정보 통계 - 최근회원가입자 정보
	public ArrayList<Member> thisWeekMemberInfo() {
		ArrayList<Member> mlist = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM (SELECT * FROM saruwa_mem ORDER BY mdate desc) WHERE rownum <= 3";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setMdate(rs.getString("mdate"));
				m.setMemId(rs.getString("memid"));
				m.setMemEmail(rs.getString("email"));
				m.setMrkAgree(rs.getInt("mkagr"));
				mlist.add(m);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return mlist;
	}
	// 회원수 통계
	public int[] total() {
		int[] list = new int[4];
		try {
			String sql = "select count(*) from saruwa_mem where to_char(mdate,'YYYY/MM/DD') = to_char(sysdate,'YYYY/MM/DD')";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[0] = rs.getInt(1);
			}
			sql = "select count(*) from saruwa_mem where mdate between trunc(sysdate,'iw') and"
					+ " trunc(sysdate,'iw') - (1/24/60/60)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[1] = rs.getInt(1);
			}
			sql = "select count(*) from drop_saruwa_mem";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[2] = rs.getInt(1);
			}
			sql = "select count(*) from saruwa_mem";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				list[3] = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
	// 회원정보 나열/정렬
	public ArrayList<Member> memberInfo(String s){
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			if(s.equals("")) {
				String sql = "select * from saruwa_mem";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			}else {
				String sql = "select * from saruwa_mem order by mdate " + s;
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			}
			while(rs.next()) {
				Member m = new Member();
				m.setMemId(rs.getString("memid"));
				m.setMemEmail(rs.getString("email"));
				m.setPhoneNum(rs.getString("phone"));
				m.setMrkAgree(rs.getInt("mkagr"));
				m.setMdate(rs.getString("mdate"));
				list.add(m);
			}
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
	// 상품 통계
	public int[] pTotal() {
		int[] list = new int[4];
		try {
			String sql = "select count(p.pcode) from sproduct p,stock s where p.pcode = s.pcode";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				list[0] = rs.getInt(1);
			}
			sql = "select count(p.pcode) from sproduct p,stock s where p.pcode = s.pcode and stock != 0";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				list[1] = rs.getInt(1);
			}
			sql = "select count(pcode) from soldOut";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				list[2] = rs.getInt(1);
			}
			sql = "select count(pcode) from dropProduct";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				list[3] = rs.getInt(1);
			}
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
	// 상품정보 통계 - 최근등록한 상품 정보
		public ArrayList<Product> latelyProduct() {
			ArrayList<Product> list = new ArrayList<Product>();
			try {
				String sql = "SELECT * FROM (SELECT * FROM sproduct ORDER BY pdate desc) WHERE rownum <= 3";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
					Product p = new Product();
					p.setPdate(rs.getString("pdate"));
					p.setPcode(rs.getString("pcode"));
					p.setPname(rs.getString("pname"));
					p.setPrice(rs.getInt("price"));
					list.add(p);
				}
			} catch (SQLException e) {
				System.out.println("예외발생");
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstm != null)
						pstm.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			return list;
		}
	// 상품 등록
	public void insertProduct(String s,String n,String b,String c,int p,String d,String[] sizes,int pcnt) {
		int cnt = 0;
		String code = "";
		try {
			String sql = "select count(pcode) from sproduct where pcode like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, s + "%");
			rs = pstm.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			if(cnt/100 == 0) {
				if(cnt%100 >= 0 && cnt%100 <= 8) {
					code = s+"00"+Integer.toString(cnt+1);
				}else if(cnt%100 >= 9 && cnt%100 <= 98) {
					code = s+"0"+Integer.toString(cnt+1);
				}else {
					code = s+Integer.toString(cnt+1);
				}
			}else {
				code = s+Integer.toString(cnt+1);
			}
			sql = "insert into sproduct values(?,?,?,?,?,to_date(?,'YYYY/MM/DD'))";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, code);
			pstm.setString(2, n);
			pstm.setString(3, b);
			pstm.setString(4, c);
			pstm.setInt(5, p);
			pstm.setString(6, d);
			rs = pstm.executeQuery();
			for(int i=0;i<sizes.length;i++) {
				sql = "insert into stock values(?,?,?)";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, code);
				pstm.setString(2, sizes[i]);
				pstm.setInt(3, pcnt);
				rs = pstm.executeQuery();
			}
		}catch (SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	// 상품 리스트 불러오기
	public ArrayList<Product> proList(){
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			String sql = "select p.pcode, pname, price, stock from sproduct p,(SELECT pcode, sum(stock) stock FROM stock GROUP BY pcode) s where p.pcode = s.pcode";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Product pro = new Product();
				pro.setPcode(rs.getString(1));
				pro.setPname(rs.getString(2));
				pro.setPrice(rs.getInt(3));
				pro.setCnt(rs.getInt(4));
				list.add(pro);
			}
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
	// 상품 불러오기
	public Product showProduct(String n) {
		Product pro = new Product();
		String size = "";
		try {
			String sql = "select p.*, s.psize, s.stock from sproduct p,stock s where p.pcode = s.pcode and pname like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + n + "%");
			rs = pstm.executeQuery();
			while(rs.next()) {
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPbrand(rs.getString("pbrand"));
				pro.setColor(rs.getString("color"));
				pro.setPrice(rs.getInt("price"));
				size += rs.getString("psize")+",";
				pro.setCnt(rs.getInt("stock"));
			}
			pro.setSize(size);
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();				
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return pro;
	}
	// 상품 수정
	public Product updateProduct(ArrayList a,ArrayList b,String c) {
		Product pro = new Product();
		try {
			String sql = "update sproduct set ";
			for(int i=0;i<a.size();i++) {
				if(i+1 == a.size()) {
					sql += a.get(i) +" = ?";
					break;
				}
				sql += a.get(i) +" = ?,";
			}
			sql += " where pcode = ?";
			System.out.println(sql);
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			for(int i=0;i<a.size();i++) {
				pstm.setString(i+1, (String) b.get(i));
			}
			pstm.setString(a.size()+1, c);
			rs = pstm.executeQuery();
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();				
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return pro;
	}
	// 상품 삭제
	public void deleteProduct(String c) {
		try {
			String sql = "delete from stock where pcode = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,c);
			rs = pstm.executeQuery();
			sql = "delete from sproduct where pcode = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,c);
			rs = pstm.executeQuery();
		}catch(SQLException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();				
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}