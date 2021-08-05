package project6.comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import project6.page.Board;

public class Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 댓글 등록
	public String writeComment(Comment c) {
		try {
			String sql = "insert into scrollbook_comment values(?,?,?,sysdate)";
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getBcode());
			pstmt.setString(2, c.getId());
			pstmt.setString(3, c.getContent());
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
		return "작성완료";
	}
	// 댓글 보기
	public ArrayList<Comment> commentList(String code) {
		ArrayList<Comment> list = new ArrayList<Comment>();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String sql = "select id, content, cdate from scrollbook_comment where bcode = ?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Comment c = new Comment();
				c.setId(rs.getString("id"));
				c.setContent(rs.getString("content"));
				String cdate = transFormat.format(rs.getDate("cdate"));
				c.setCdate(cdate);
				list.add(c);
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
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 게시물 리스트
	public ArrayList<Board> boardList() {
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			String sql = "select bcode,img from Board";
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
}