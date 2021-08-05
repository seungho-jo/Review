package project6.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 게시물 작성
	public void writeBoard(Board b) { // 게시물코드,내용,공개범위,사진,태그,장소
		String[] ids = b.getID().split("@"); // @이름,@이름2,....
		String[] tags = b.getTag().split(",");
		int num = 7;
		try {
			String sql = "insert all "
					+ "into Board values(?||seq_"+ids[0]+".nextval,?,?,?,?,sysdate,?) ";
			for(int i=0;i<tags.length;i++) {
				sql += "into BoardTag values(?||seq_"+ids[0]+".currval,?) ";
			}
			sql += "select * from dual";
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBcode());
			pstmt.setString(2, b.getContents());
			pstmt.setString(3, b.getImg());
			pstmt.setString(4, b.getLoc());
			pstmt.setString(5, b.getPubRange());
			pstmt.setString(6, b.getID());
			for(int i=0;i<tags.length;i++) {
				pstmt.setString(num++, b.getBcode());
				pstmt.setString(num++, tags[i]);
			}
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
	// 게시물 리스트
	public ArrayList<Board> boardList(String ID) {
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			String sql = "select bcode,img from Board where ID = ? order by wdate desc";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBcode(rs.getString("bcode"));
				b.setImg(rs.getString("img"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 게시물 삭제
	public void deleteBoard(String id,String bcode) {
		try {
			String sql = "delete from Board where bcode = ? and ID = ?";
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bcode);
			pstmt.setString(2, id);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 게시물 불러오기
	public Board setBoard(String bcode,String id) {
		Board brd = new Board();
		try {
			String sql = "select * from BoardTag where bcode = ?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sql = "SELECT a.* , tag FROM Board a,"
						+ "(SELECT BCODE, LISTAGG(tag,',') WITHIN GROUP(ORDER BY tag) AS tag "
						+ "FROM BoardTag "
						+ "GROUP BY bcode) b "
						+ "WHERE a.BCODE = b.bcode "
						+ "AND a.bcode = ? "
						+ "AND ID = ? ";
				conn = DBConnection.getConnection();     // 001 @이름 001 @이름2 001 @이름3 -> @이름,@이름1,@이름3
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bcode);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					brd.setBcode(rs.getString("bcode"));
					brd.setContents(rs.getString("contents"));
					brd.setImg(rs.getString("img"));
					brd.setTag(rs.getString("tag"));
					brd.setLoc(rs.getString("loc"));
					brd.setPubRange(rs.getString("pubRange"));
				}
			}else {
				sql = "select * from board where bcode = ? AND ID = ?";
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bcode);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					brd.setBcode(rs.getString("bcode"));
					brd.setContents(rs.getString("contents"));
					brd.setImg(rs.getString("img"));
					brd.setLoc(rs.getString("loc"));
					brd.setPubRange(rs.getString("pubRange"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return brd;
	}
	// 게시물 업데이트
		public void updateBoard(Board b) {
			String[] ids = b.getID().split("@");
			String[] tags = b.getTag().split(",");
			int num = 1;
			try {
				String sql = "update Board "
						+ "set contents = ?, img = ?, loc = ?, pubRange = ?, wdate = sysdate "
						+ "where bcode = ? and ID = ?";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b.getContents());
				pstmt.setString(2, b.getImg());
				pstmt.setString(3, b.getLoc());
				pstmt.setString(4, b.getPubRange());
				pstmt.setString(5, b.getBcode());
				pstmt.setString(6, b.getID());
				pstmt.executeUpdate();
				conn.commit();
				sql = "delete from BoardTag "
							+ "where bcode = ?";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b.getBcode());;
				pstmt.executeUpdate();
				conn.commit();
				sql = "insert all ";
				for(int i=0;i<tags.length;i++) {
					sql += "into BoardTag values(?,?) ";
				}
				sql += "select * from dual";
				pstmt = conn.prepareStatement(sql);
				for(int i=0;i<tags.length;i++) {
					pstmt.setString(num++, b.getBcode());
					pstmt.setString(num++, tags[i]);
				}
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
	// 태그된 게시물 리스트 불러오기
	public ArrayList<Board> tagBoard(String tag){
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			String sql = "select a.bcode, img from Board a,(select bcode from BoardTag where tag = ?) b"
					+ " where a.bcode = b.bcode order by wdate desc";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBcode(rs.getString("bcode"));
				b.setImg(rs.getString("img"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 컬랙션 생성
	public void createCollection(String id,String colname) {
		String[] ids = id.split("@");
		try {
			String sql = "select * from USER_SEQUENCES where sequence_name = upper('seq_col_'||?)";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ids[0]);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sql = "insert into collection values(?||seq_col_"+ids[0]+".nextval,?,?)";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ids[0]);
				pstmt.setString(2, id);
				pstmt.setString(3, colname);
				pstmt.executeUpdate();
			}else {
				sql = "create sequence seq_col_"+ids[0]+" "
						+ "increment by 1 start with 1 minvalue 1 maxvalue 999999";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				sql = "insert into collection values(?||seq_col_"+ids[0]+".nextval,?,?)";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ids[0]);
				pstmt.setString(2, id);
				pstmt.setString(3, colname);
				pstmt.executeUpdate();
			}
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
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 나의 컬랙션 리스트
	public ArrayList<Collections> colList(String id){
		ArrayList<Collections> clist = new ArrayList<Collections>();
		try {
			String sql = "select * from collection where ID = ?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Collections c = new Collections();
				c.setColcode(rs.getString("colcode"));
				c.setColname(rs.getString("colname"));
				clist.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return clist;
	}
	// 컬랙션 내부 내용
	public ArrayList<Board> colBoard(String colcode){
		ArrayList<Board> blist = new ArrayList<Board>();
		try {
			String sql = "select a.bcode,img from Board a, "
					+ "(select bcode from collectionBoard where colcode = ?) b "
					+ "where a.bcode = b.bcode order by wdate desc";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, colcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBcode(rs.getString("bcode"));
				b.setImg(rs.getString("img"));
				blist.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return blist;
	}
	// 게시물 저장
	public void saveBoard(String colcode,String bcode) {
		try {
			String sql = "insert into collectionBoard values(?,?)";
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, colcode);
			pstmt.setString(2, bcode);
			pstmt.executeUpdate();
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
}
