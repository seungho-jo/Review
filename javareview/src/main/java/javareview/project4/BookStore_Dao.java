package javareview.project4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookStore_Dao {
	// 책방 리스트
	public ArrayList<BookStore> bookStoreList() {
		ArrayList<BookStore> list = new ArrayList<BookStore>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT kind,name,nvl(pnum,'-') pnum,nvl(loc,'-') loc,nvl(web,'-') web,nvl(sns,'-') sns FROM bookStore";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				BookStore bstore = new BookStore();
				bstore.setKind(rs.getString("kind"));
				bstore.setName(rs.getString("name"));
				bstore.setPnum(rs.getString("pnum"));
				bstore.setLoc(rs.getString("Loc"));
				bstore.setWeb(rs.getString("web"));
				bstore.setSns(rs.getString("sns"));
				list.add(bstore);
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

	// 책방 검색
	public ArrayList<BookStore> searchList(String k, String l, String name) {
		ArrayList<BookStore> list = new ArrayList<BookStore>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			if (k.equals("") && (l.equals("") && name.equals(""))) {
				String sql = "SELECT kind,name,nvl(pnum,'-') pnum,nvl(loc,'-') loc,nvl(web,'-') web,nvl(sns,'-') sns FROM bookStore";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} else {
				String sql = "SELECT kind,name,nvl(pnum,'-') pnum,nvl(loc,'-') loc,nvl(web,'-') web,nvl(sns,'-') sns FROM bookStore"
						+ " where loc like ? and upper(name) like upper(?) and kind like ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + l + "%");
				pstm.setString(2, "%" + name + "%");
				pstm.setString(3, "%" + k + "%");
				rs = pstm.executeQuery();
			}
			while (rs.next()) {
				BookStore bstore = new BookStore();
				bstore.setKind(rs.getString("kind"));
				bstore.setName(rs.getString("name"));
				bstore.setPnum(rs.getString("pnum"));
				bstore.setLoc(rs.getString("Loc"));
				bstore.setWeb(rs.getString("web"));
				bstore.setSns(rs.getString("sns"));
				list.add(bstore);
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

	// 연도별 행사자료 리스트
	public ArrayList<EventDataByYear> eventList(String s, int y) {
		ArrayList<EventDataByYear> list = new ArrayList<EventDataByYear>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM evtDataPrg where kind like ? and evtyear like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, s);
			pstm.setInt(2, y);
			rs = pstm.executeQuery();
			while (rs.next()) {
				EventDataByYear data = new EventDataByYear();
				data.setEvtyear(rs.getInt("evtyear"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setWdate(rs.getString("wdate").substring(0, 10));
				data.setVisit(rs.getInt("visit"));
				list.add(data);
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

	// 연도별 행사자료 상세보기
	public EventDataByYear detailEvent(String s) {
		EventDataByYear data = new EventDataByYear();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM evtDataPrg where title like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + s + "%");
			rs = pstm.executeQuery();
			if (rs.next()) {
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setWdate(rs.getString("wdate").substring(0, 10));
				data.setVisit(rs.getInt("visit"));
				data.setContent(rs.getString("content"));
				data.setImg(rs.getString("img"));
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
		return data;
	}

	// 상세보기 진입시 조회수 증가
	public void upCount(String s) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "update evtDataPrg set visit = visit + 1 where title like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + s + "%");
			rs = pstm.executeQuery();
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
	}

	// 연도별 행사자료 필터링 검색
	public ArrayList<EventDataByYear> searchEvent(int y, String t, String c, String d1, String d2, String k) {
		ArrayList<EventDataByYear> list = new ArrayList<EventDataByYear>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			if ((t.equals("") && c.equals("")) && (d1.equals("") && d2.equals(""))) {
				String sql = "SELECT * FROM evtDataPrg where kind like ? and evtyear like ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, k);
				pstm.setInt(2, y);
				rs = pstm.executeQuery();
			} else if (d1.equals("") && d2.equals("")) {
				String sql = "select * from evtDataPrg where evtyear like ? and title like ? and content like ? and kind like ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, y);
				pstm.setString(2, "%" + t + "%");
				pstm.setString(3, "%" + c + "%");
				pstm.setString(4, k);
				rs = pstm.executeQuery();
			} else {
				String sql = "select * from evtDataPrg where evtyear like ? and title like ? and content like ? and "
						+ "wdate between to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD') and kind like ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, y);
				pstm.setString(2, "%" + t + "%");
				pstm.setString(3, "%" + c + "%");
				pstm.setString(4, d1);
				pstm.setString(5, d2);
				pstm.setString(6, k);
				rs = pstm.executeQuery();
			}
			while (rs.next()) {
				EventDataByYear data = new EventDataByYear();
				data.setEvtyear(rs.getInt("evtyear"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setWdate(rs.getString("wdate").substring(0, 10));
				data.setVisit(rs.getInt("visit"));
				list.add(data);
			}
		} catch (Exception e) {
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

	// 도서관 리스트
	public ArrayList<Library> libraryList() {
		ArrayList<Library> list = new ArrayList<Library>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM library";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Library l = new Library();
				l.setName(rs.getString("name"));
				l.setUsetime(rs.getString("usetime"));
				l.setClosedDay(rs.getString("closedDay"));
				l.setPnum(rs.getString("pnum"));
				l.setWeb(rs.getString("web"));
				l.setLoc(rs.getString("loc"));
				l.setBookjoin(rs.getString("bookjoin"));
				list.add(l);
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

	// 도서 검색
	public ArrayList<Library> searchLib(String k, String l, String n) {
		ArrayList<Library> list = new ArrayList<Library>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			if (k.equals("") && (l.equals("") && n.equals(""))) {
				String sql = "SELECT * FROM library";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} else {
				String sql = "SELECT * FROM library"
						+ " where loc like ? and upper(name) like upper(?) and kind like ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + l + "%");
				pstm.setString(2, "%" + n + "%");
				pstm.setString(3, "%" + k + "%");
				rs = pstm.executeQuery();
			}
			while (rs.next()) {
				Library lib = new Library();
				lib.setName(rs.getString("name"));
				lib.setUsetime(rs.getString("usetime"));
				lib.setClosedDay(rs.getString("closedDay"));
				lib.setPnum(rs.getString("pnum"));
				lib.setWeb(rs.getString("web"));
				lib.setLoc(rs.getString("loc"));
				lib.setBookjoin(rs.getString("bookjoin"));
				list.add(lib);
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

	// 도서 자료 상세 검색
	public ArrayList<Books> searchBooks(String k1, String sw1, String logic, String k2, String sw2, int year1,
			int year2) {
		ArrayList<Books> list = new ArrayList<Books>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			if (k1.equals("제목")) {
				k1 = "name";
			} else if (k1.equals("저자")) {
				k1 = "writer";
			} else if (k1.equals("발행처")) {
				k1 = "publisher";
			}
			if (k2.equals("제목")) {
				k2 = "name";
			} else if (k2.equals("저자")) {
				k2 = "writer";
			} else if (k2.equals("발행처")) {
				k2 = "publisher";
			}
			if (k2.equals("") && sw2.equals("")) {
				String sql = "SELECT * FROM Books where upper(" + k1 + ") like upper(?) and pdate between ? and ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + sw1 + "%");
				pstm.setInt(2, year1);
				pstm.setInt(3, year2);
				rs = pstm.executeQuery();
			} else {
				String sql = "SELECT * FROM Books where upper(" + k1 + ") like upper(?) " + logic + " upper(" + k2
						+ ") like upper(?) and pdate between ? and ?";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + sw1 + "%");
				pstm.setString(2, "%" + sw2 + "%");
				pstm.setInt(3, year1);
				pstm.setInt(4, year2);
				rs = pstm.executeQuery();
			}
			while (rs.next()) {
				Books book = new Books();
				book.setName(rs.getString("name"));
				book.setWriter(rs.getString("writer"));
				book.setPdate(rs.getInt("pdate"));
				book.setLib(rs.getString("lib"));
				list.add(book);
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

	// 나의 검색 설정 만들기
	public void searchset(String e, String n, String l) {
		ArrayList<SearchSet> list = new ArrayList<SearchSet>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "insert into mysearch values(?,?,?)";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, e);
			pstm.setString(2, n);
			pstm.setString(3, l);
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
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
	}
	// 나의 검색 설정 도서관 추가하기
	public void addLibrary(String s,String e,String n){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "update mysearch set library = library||? where loginmail = ? and searchname like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, ","+s);
			pstm.setString(2, e);
			pstm.setString(3, n);
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
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
	}
	// 나의 검색 설정 보기
	public ArrayList<SearchSet> showSearchSet(String e){
		ArrayList<SearchSet> list = new ArrayList<SearchSet>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM mysearch where loginmail like ?";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, e);
			rs = pstm.executeQuery();
			while (rs.next()) {
				SearchSet s = new SearchSet();
				s.setSearchname(rs.getString("searchname"));
				s.setLibrary(rs.getString("library"));
				list.add(s);
			}
		} catch (SQLException e1) {
			System.out.println("예외발생");
			e1.printStackTrace();
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
		return list;
	}
}
