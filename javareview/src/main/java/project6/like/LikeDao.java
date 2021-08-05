package project6.like;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class LikeDao {
	
	// 모든 게시물 리스트
	public ArrayList<Board> boardListall() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			String sql = "select bcode,img from Board order by wdate desc";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	
	// 게시물 선택
	public Board setBoard(String bcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board brd = new Board();
		try {
			String sql = "select * from Board where bcode = ?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				brd.setBcode(rs.getString("bcode"));
				brd.setContents(rs.getString("contents"));
				brd.setImg(rs.getString("img"));
				brd.setLoc(rs.getString("loc"));
				brd.setPubRange(rs.getString("pubRange"));
				brd.setWdate(rs.getDate("wdate"));
				brd.setID(rs.getString("id"));
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
	
	//좋아요 클릭(넣기/취소) 
	public void clicklike(String id,String bcode) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select * from scrollbook_like where bcode = ? and id = ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bcode);
			pstm.setString(2, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				sql = "delete from scrollbook_like where id = ? and bcode = ?";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, id);
				pstm.setString(2, bcode);
				pstm.executeUpdate();
				conn.commit();
			}else {
				sql = "insert into scrollbook_like values(?,?)";
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, bcode);
				pstm.setString(2, id);
				pstm.executeUpdate();
				conn.commit();
			}
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally{
			try {
				if(rs!=null) {
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
	}
}
