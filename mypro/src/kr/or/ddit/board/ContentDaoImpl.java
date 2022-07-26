package kr.or.ddit.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.JDBCUtil3;

public class ContentDaoImpl implements IContentDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public List<ContentVO> seeAll() {
		List<ContentVO> conList = new ArrayList<ContentVO>();
		
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int boardNum = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String date = rs.getString(4);
				String content = rs.getString(5);
				
				ContentVO cv = new ContentVO();
				cv.setBoardNum(boardNum);
				cv.setTitle(title);
				cv.setWriter(writer);
				cv.setDate(date);
				cv.setContent(content);
				
				conList.add(cv);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return conList;
	}

	@Override
	public int writeContent(ContentVO cv) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "insert into jdbc_board (board_no,board_title,board_writer,board_date,board_content)"
					+ " Values(board_seq.nextVal,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cv.getTitle());
			pstmt.setString(2, cv.getWriter());
			pstmt.setString(3, cv.getContent());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int editContent(ContentVO cv) {
		
		return 0;
	}

	@Override
	public int deleteContent(int boardNum) {
		
		return 0;
	}

	@Override
	public List<ContentVO> searchContent(ContentVO cv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkBoardNum(int boardNum) {
		boolean isExist = false;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select count(*) as cnt from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if (cnt > 0) {
				isExist = true;
			}else {
				isExist = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return isExist;
	}

}
